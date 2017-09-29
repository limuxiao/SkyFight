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
import lmx.sky.managers.ApplyManager;
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
	
	/**
	 * 游戏物体map
	 */
	private Map<String, GameObject> gameObjects = new HashMap<String, GameObject>();
	
	/**
	 * 渲染管理器
	 */
	protected ApplyManager applyManager = new ApplyManager(Scenes.this);
	
	
	/**
	 * 所处世界
	 */
	protected World world;
	
	
	
	public Scenes(World world) {
		this.world = world;
		this.init();
	
	}
	
	public Scenes(World world,int width, int height) {
		this.world = world;
		this.setSize(width,height);
		this.init();
	}
	
	
	protected void init() {
		this.setLayout(null);		//默认布局置空
	}
	
	
	
	
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
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
				gameObject.setLocation(translate.x, translate.y);
			}
			
			//get Material
			Material material = gameObject.getComponent(Material.class);
			if(material != null) {
				gameObject.setIcon(material.icon);
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
	
	
	public void setWorld(World world) {
		this.world = world;
	}
	
}
