package lmx.sky.pojo;

import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.Icon;
import javax.swing.JLabel;

import org.apache.commons.lang3.StringUtils;

import lmx.sky.componts.BaseComponent;
import lmx.sky.componts.Translate;
import lmx.sky.tools.BaseTool;

/**
 * @classname  GameObject	游戏物体，所有物体的基类
 * @desc
 * @createtime 2017年9月14日 下午5:00:02      
 * @author liyan
 *
 * @version V1.0.1
 */
public class GameObject extends JLabel implements Serializable{
	
	
	public String id;		//物体id
	
	public int width;		//宽
	public int height;		//高
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4172843079858803490L;
	

	/**
	 * 组件map
	 */
	protected Map<String, BaseComponent> components = new HashMap<>();
	
	
	/**
	 * 子物体map
	 */
	protected Map<String, GameObject> gameObjects = new HashMap<>();
	
	
	 public GameObject() {
		
	}
	
	
	/**
	 * 添加组件
	 * @param component
	 * @return	检查gameobject中是否已经有对应组件，如果有则不再添加，返回false；如果没有则添加组件，返回true
	 */
	public boolean addComponent(BaseComponent component) {
		
		if(hasComponent(component.getClass())) 
			return false;
		
		this.components.put(component.getClass().getSimpleName(), component);
		return true;
	}
	
	
	/**
	 * 删除组件
	 * @param component
	 * @return	如果gameobject包含该组件，则删除组件，返回true；如果不包含返回false
	 */
	public <BaseComponent> boolean removeComponent(Class<BaseComponent> clazz) {
		if(!hasComponent(clazz))
			return false;
		this.components.remove(clazz.getSimpleName());
		return true;
	}
	
	
	
	
	/**
	 * 根据组件类名获取gameobject的组件
	 * @param clazz
	 * @return	如果gameobject包含该类组件则返回该组件实例，如果不包含则返回null
	 */
	public <BaseComponent> BaseComponent getComponent(Class<BaseComponent> clazz) {
		return (BaseComponent) this.components.get(clazz.getSimpleName());
	}
	
	/**
	 * 获取gameobject所有组件列表
	 * @return
	 */
	public List<BaseComponent> getAllComponents() {
		return new ArrayList<>(this.components.values());
	}
	
	
	/**
	 * 判断gameobject是否包含某一组件
	 * @param clazz
	 * @return
	 */
	public <BaseComponent> boolean hasComponent(Class<BaseComponent> clazz) {
		return this.components.containsKey(clazz.getSimpleName());
	}
	
	
	
	/**
	 * 添加子物体
	 * @param gameObject
	 * @return
	 */
	public boolean addGameObject(GameObject gameObject) {
		
		return BaseTool.addGameObject(this.gameObjects, gameObject);
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
		List<GameObject> list = new ArrayList<>();
		for(GameObject gameObject : this.gameObjects.values()) {
			
			if(gameObject.getClass().getSimpleName() == clazz.getSimpleName()) 
				list.add(gameObject);
			
		}
		return list;
	}
}
