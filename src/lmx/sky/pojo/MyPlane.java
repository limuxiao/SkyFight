package lmx.sky.pojo;

import java.awt.Graphics;
import java.io.Serializable;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import lmx.sky.GameConfig;
import lmx.sky.scenes.PlanePanel;
import lmx.sky.tools.ImageTool;

/**
 * @classname  MyPlane
 * @desc
 * @createtime 2017年9月21日 下午1:51:19      
 * @author liyan
 *
 * @version V1.0.1
 */
public class MyPlane extends Plane implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7883394553516703973L;
	
	
	//默认贴图
	public static final Icon MyPlaneIcon = 
			ImageTool.getIcon(GameConfig.getInstance().image.myPlane);
	
	
	
	public MyPlane() {
		super();
	}
	
	
	public void draw(Graphics g) {
		
		
	}
	
}
