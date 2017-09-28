package lmx.sky.pojo;

import java.awt.Image;
import java.io.Serializable;

import javax.swing.Icon;

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
		gameObject.addGameObject(plane);
		Plane plane2 = (Plane) gameObject.findGameObjectsByClass(Plane.class);
	}
	

}
