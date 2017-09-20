package lmx.sky.pojo;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import lmx.sky.GameConfig;
import lmx.sky.GameState;
import lmx.sky.listener.GameKeyListener;
import lmx.sky.listener.GameMouseListener;
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
	
	private GameState curState;		//当前游戏状态
	private GameConfig config = GameConfig.getInstance();
	
	private int width;
	private int height;
	
	private Container c;
	
	
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
		
		this.init();
		
		//显示窗口
		this.setVisible(true);
	}
	
	
	/**
	 * init
	 */
	public void init() { 
		
		//初始化监听器
		this.initListener();
		
		//初始化lable
		this.initLable();
		
		
		
		
	}
	
	
	/**
	 * 初始化监听器
	 */
	private void initListener() {
		
		//添加键盘监听器
		this.addKeyListener(new GameKeyListener());
		
		//添加鼠标监听器
		this.addMouseListener(new GameMouseListener());
		
	}
	
	/**
	 * 初始化lable
	 */
	private void initLable() {
		
		Icon bgIcon = ImageTool.getIcon(this.config.image.bg);
		JLabel label = new JLabel(bgIcon);
		label.setBounds(0, 0, this.width, this.height);
		c.add(label);
	}

}
