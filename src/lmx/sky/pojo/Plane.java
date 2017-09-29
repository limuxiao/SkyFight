package lmx.sky.pojo;

import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;

import lmx.sky.componts.BaseComponent;
import lmx.sky.componts.Translate;

/**
 * @classname  Plane		--		飞行器
 * @desc
 * @createtime 2017年9月21日 上午10:22:52      
 * @author liyan
 *
 * @version V1.0.1
 */
public class Plane extends GameObject implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5225308653335053068L;
	
	
	
	public Plane() {
		super();
		Translate translate = new Translate();
		this.addComponent(translate);
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		GameObject gameObject = new GameObject();
		
		Plane plane = new Plane();
		plane.id = "plane";
		Translate translate = null;
		if(plane.hasComponent(Translate.class)) {
			translate = plane.getComponent(Translate.class);
			translate.x = 50;
			translate.y = 100;
		}
		
		gameObject.addGameObject(plane);
		Plane plane2 = gameObject.findGameObjectByID("plane");
		System.out.println(plane2.getComponent(Translate.class).x);
		
		List<GameObject> l = new ArrayList<>(gameObject.gameObjects.values());
		
		System.out.println(l.get(0).getClass().getSimpleName());
		
		List<Plane> list = gameObject.findGameObjectsByClass(Plane.class);
		System.out.println(list);
		
	}
	

}
