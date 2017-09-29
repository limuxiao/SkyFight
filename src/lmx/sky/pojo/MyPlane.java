package lmx.sky.pojo;

import java.awt.Graphics;
import java.io.Serializable;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import lmx.sky.GameConfig;
import lmx.sky.componts.Material;
import lmx.sky.componts.Translate;
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
		
		this.width = MyPlaneIcon.getIconWidth();
		this.height = MyPlaneIcon.getIconHeight();
		
		Material material = new Material(MyPlaneIcon);
		this.addComponent(material);
		Translate translate = new Translate();
		this.addComponent(translate);
		
		Icon icon = this.getComponent(Material.class).icon;
		
		this.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
	}
	
	
	public void draw(Graphics g) {
		
		
	}
	
}
