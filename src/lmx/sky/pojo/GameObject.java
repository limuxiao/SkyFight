package lmx.sky.pojo;

import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.Icon;

import lmx.sky.componts.BaseComponent;
import lmx.sky.componts.Translate;

/**
 * @classname  GameObject	游戏物体，所有物体的基类
 * @desc
 * @createtime 2017年9月14日 下午5:00:02      
 * @author liyan
 *
 * @version V1.0.1
 */
public class GameObject implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4172843079858803490L;
	

	/**
	 * 组件map
	 */
	private Map<String, BaseComponent> components = new HashMap<>();
	
	
	
	 public GameObject() {
		
	}
	
	
	/**
	 * 添加组件
	 * @param component
	 * @return	检查gameobject中是否已经有对应组件，如果有则不再添加，返回false；如果没有则添加组件，返回true
	 */
	public boolean addComponent(BaseComponent component) {
		
		if(hasComponent(component)) 
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
		if(hasComponent(clazz))
			return (BaseComponent) this.components.get(clazz.getSimpleName());
		return null;
	}
	
	/**
	 * 获取gameobject所有组件列表
	 * @return
	 */
	public List<BaseComponent> getComponents() {
		return new ArrayList<>(this.components.values());
	}
	
	/**
	 * 判断时候已经有某一个组件
	 * @param component	
	 * @return	已经包含 返回true；不包含 返回false
	 */
	public boolean hasComponent(BaseComponent component){
		return this.hasComponent(component.getClass());
	}
	
	
	/**
	 * 判断gameobject是否包含某一组件
	 * @param clazz
	 * @return
	 */
	public <BaseComponent> boolean hasComponent(Class<BaseComponent> clazz) {
		return this.components.containsKey(clazz.getSimpleName());
	}
	
	
}
