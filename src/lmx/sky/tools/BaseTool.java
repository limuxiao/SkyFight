package lmx.sky.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import lmx.sky.pojo.GameObject;

/**
 * @classname  BaseTool		--		基本工具类
 * @desc
 * @createtime 2017年9月26日 上午10:25:57      
 * @author liyan
 *
 * @version V1.0.1
 */
public class BaseTool {
	
	
	
	/**
	 * 添加子物体,这个方法稍微复杂点儿
	 * @param gameObject
	 * @return
	 */
	public static synchronized boolean addGameObject(Map<String, GameObject> gameObjects,GameObject gameObject) {
		
		if(gameObject == null) return false;
		
		//1.首先获取gameobject的id,如果id为空，则获取类名
		String id = 
				StringUtils.isEmpty(gameObject.id) 
						? gameObject.getClass().getSimpleName()
						: gameObject.id ;
		
		//2.获取所有的key，判断是否包含id
		List<String> keys = new ArrayList<>(gameObjects.keySet());
		
		if(keys.contains(id)) {
			
			int index = 0;
			
			for(String key : keys) {
				if(key.startsWith(id + "_")) {
					int i = Integer.parseInt(key.split(id+"_")[1]);
					if(index < i) index = i;
				}
			}
			index ++;
			gameObjects.put(id+"_"+index, gameObject);
			
			
		}else {
			gameObjects.put(id, gameObject);
		}
		
		return true;
	}

	
	/**
	 * 根据游戏物体类获取子物体列表
	 * @param clazz
	 * @return
	 */
	public static synchronized <GameObject> List<GameObject> findGameObjectsByClass(Map<String, GameObject> gameObjects,Class<GameObject> clazz){
		List<GameObject> list = new ArrayList<>();
		for(GameObject gameObject : gameObjects.values()) {
			
			if(gameObject.getClass().getSimpleName() == clazz.getSimpleName()) 
				list.add(gameObject);
			
		}
		return list;
	}

	
	
}
