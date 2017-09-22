package lmx.sky.scenes;

import java.awt.Graphics;

import javax.swing.JPanel;

import lmx.sky.pojo.MyPlane;

/**
 * @classname  PlanePanel	--	Play Scene
 * @desc
 * @createtime 2017年9月21日 下午2:07:36      
 * @author liyan
 *
 * @version V1.0.1
 */
public class PlanePanel extends JPanel {

	
	public MyPlane myPlane;		//游戏主角
	
	public PlanePanel() {
		super();
		myPlane = new MyPlane();
	}
	
	
	@Override
	public void paint(Graphics g) {
		
		//绘制主角
		System.out.println("绘制主角...");
//		myPlane.draw(g);
		
		super.paint(g);
	}
	
	
	
	
	
	
	

}
