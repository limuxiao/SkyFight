package lmx.sky.scenes;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import lmx.sky.GameConfig;
import lmx.sky.componts.Material;
import lmx.sky.componts.RigidBody;
import lmx.sky.componts.Translate;
import lmx.sky.pojo.GameObject;
import lmx.sky.tools.BaseTool;
import lmx.sky.tools.ImageTool;

/**
 * @classname  Scenes	--	游戏场景基类
 * @desc
 * @createtime 2017年9月22日 上午11:01:38      
 * @author liyan
 *
 * @version V1.0.1
 */
public class Scenes extends JPanel{
	
	private Map<String, GameObject> gameObjects = new HashMap<String, GameObject>();
	
	
	
	protected ImageIcon iconBg;		//背景
	
	
	public Scenes() {
		this.init();
	
	}
	
	public Scenes(int width, int height) {
		this.setSize(width,height);
		this.init();
	}
	
	public Scenes(int width, int height,ImageIcon icon) {
		this.setSize(width,height);
		this.iconBg = icon;
		this.iconBg.setImage(iconBg.getImage().getScaledInstance(this.getWidth(),this.getHeight(), Image.SCALE_SMOOTH)); 
		this.init();
	}
	
	
	protected void init() {
		this.setLayout(null);		//默认布局置空
	}
	
	
	
	
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		//绘制背景
		if(this.iconBg != null)
			g.drawImage(iconBg.getImage(),0,0,this.getWidth(),this.getHeight(),null);
	}
	
	
	
	
	/**
	 * 添加子物体
	 * @param gameObject
	 * @return
	 */
	public boolean addGameObject(GameObject gameObject) {
		
		boolean isAdd = BaseTool.addGameObject(this.gameObjects, gameObject);
		
		//渲染
		if(isAdd) {
			
			//get Translate
			Translate translate = gameObject.getComponent(Translate.class);
			if(translate != null) {
				
			}
			
			//get Material
			Material material = gameObject.getComponent(Material.class);
			if(material != null) {
				
			}
			
			//get RigidBody
			RigidBody rigidBody = gameObject.getComponent(RigidBody.class);
			if(rigidBody != null) {
				
			}
			
			
			this.add(gameObject);
		}
		
		return isAdd;
		
	}
	
	
	
	
	
	
	/**
	 * 根据id获取游戏物体
	 * @param id
	 * @return
	 */
	public GameObject findGameObjectByID(String id) {
		return this.gameObjects.get(id);
	}
	
	/**
	 * 根据游戏物体类获取子物体列表
	 * @param clazz
	 * @return
	 */
	public List<GameObject> findGameObjectsByClass(Class<GameObject> clazz){
		return BaseTool.findGameObjectsByClass(this.gameObjects, clazz);
	}
	
	
	/**
	 * set iconbg
	 * @param icon
	 */
	public void setIconBg(ImageIcon icon) {
		this.iconBg = icon;
		this.iconBg.setImage(iconBg.getImage().getScaledInstance(this.getWidth(),this.getHeight(), Image.SCALE_SMOOTH));
		repaint();
	}
	
	
}
