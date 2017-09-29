package lmx.sky.scenes;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.io.File;
import java.io.IOException;
import java.security.cert.CRLReason;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.omg.Messaging.SyncScopeHelper;

import lmx.sky.GameConfig;
import lmx.sky.GameState;
import lmx.sky.componts.Material;
import lmx.sky.listener.GameKeyListener;
import lmx.sky.listener.GameMouseListener;
import lmx.sky.pojo.GameObject;
import lmx.sky.pojo.MyPlane;
import lmx.sky.tools.ImageTool;

/**
 * @classname  World
 * @desc
 * @createtime 2017年9月14日 下午5:21:53      
 * @author liyan
 *
 * @version V1.0.1
 */
public class World extends JFrame{
	
	
	private static final long serialVersionUID = 1L;
	public static final int DEFAULT_WIDTH;
	public static final int DEFAULT_HEIGHT;
	
	private GameState curState = GameState.DEFAULT;		//当前游戏状态
	public GameConfig config = GameConfig.getInstance();
	
	public int width;
	public int height;
	
	private Container c;
	private Graphics graphics;
	
	
	private JLabel labelBg;		//背景label
	private JButton btnStart;	//开始游戏btn
	public MyPlane myPlane;	//
	
	
	private GameKeyListener myKeyListener;
	private GameMouseListener myMouseListener;
	
	
	
	protected Map<String, Scenes> scenesMap = new HashMap<>();
	
	
	static {
		//获取屏幕宽高
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		DEFAULT_WIDTH = screensize.width;
		DEFAULT_HEIGHT = screensize.height;
	}
	

	public World() {
		
		this(DEFAULT_WIDTH / 4,(int)(DEFAULT_HEIGHT * 0.8));
		
	}
	
	
	public World(int width,int height) {
		
		this.width = width;
		this.height = height;
		
		//窗口大小
		this.setSize(this.width, this.height);
		
		//窗口名称
		this.setTitle(config.base.title);
		
		//设置窗体显示的位置在屏幕的中央
		this.setLocationRelativeTo(null);  
		
		//不能随意改变窗口的大小
		this.setResizable(false);
		
		//当点击关闭按钮时,将程序退出
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		//设置主面板的布局方式为自由布局
		this.getContentPane().setLayout(null);
		
		//将this.getContentPane()赋值给c，便于书写
		c = getContentPane();
		
		//
		graphics = this.getGraphics();
		
		this.init();
		
		//显示窗口
		this.setVisible(true);
	}
	
	
	public void addScenes() {
		
		
		CreateScenes createScenes = new CreateScenes(this.width,this.height);
		createScenes.setWorld(this);
		
		this.addScenes(createScenes);
		
		
	}
	
	
	/**
	 * 添加一个场景，并显示在最上层
	 * @param scenes
	 */
	public void addScenes(Scenes scenes){
		c.add(scenes);
		this.scenesMap.put(scenes.getClass().getSimpleName(), scenes);
		c.setComponentZOrder(scenes, 0);
	}
	
	/**
	 * 根据场景类获取场景
	 * @param clazz
	 * @return
	 */
	public <T> Scenes getScenes(Class<T> clazz) {
		return this.scenesMap.get(clazz.getSimpleName()); 
	}
	
	/**
	 * init
	 */
	public void init() { 
		
		//初始化监听器
		this.initListener();
		
		addScenes();
		
		//设置游戏状态
		this.setCurState(GameState.CREATE);
	}
	
	
	/**
	 * 初始化监听器
	 */
	private void initListener() {
		
		//添加键盘监听器
		if(myKeyListener == null) 
			myKeyListener = new GameKeyListener(this);
		this.addKeyListener(myKeyListener);
		
		//添加鼠标监听器
		myMouseListener = new GameMouseListener();
		this.addMouseListener(myMouseListener);
		
	}
	
	
	/**
	 * 开始游戏按钮触发事件
	 */
	public void startGame() {
		
		//切换游戏状态
		this.setCurState(GameState.START);
		
		//先将所有component隐藏
		for (Component component : c.getComponents()) {
			component.setVisible(false);
		}
		
		//切换背景
		ImageIcon iconBg = (ImageIcon)ImageTool.getIcon(this.config.image.bgPlay);
		iconBg.setImage(iconBg.getImage().getScaledInstance(this.width,this.height, Image.SCALE_SMOOTH));  
		labelBg.setIcon(iconBg);
		labelBg.setVisible(true);
		
		
		createPlane();
		
		
		
	}
	
	
	public void createPlane() {
		//创建主角
		myPlane = new MyPlane();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				try {
					
					for(int i = 0; i< 20 ; i++) {
						repaint();
						Thread.sleep(20);
					}
					
					//获取焦点
					requestFocus();
					
					//设置可控
					myKeyListener.setEnable(true);
					myMouseListener.setEnable(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}
		}).start();
	}
	
	
	

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		switch (curState) {
		case START:				//游戏开始
			drawStart(g);
			break;
			
			
		default:
			break;

		}
		
	}
	
	
	private void drawStart(Graphics g) {
		
		//绘制主机
		if(myPlane != null)
			myPlane.draw(g);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public void setCurState(GameState curState) {
		this.curState = curState;
	}

	
	
	public GameState getCurState() {
		return curState;
	}
}
