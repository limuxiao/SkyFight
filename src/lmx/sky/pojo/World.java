package lmx.sky.pojo;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @classname  World
 * @desc
 * @createtime 2017年9月14日 下午5:21:53      
 * @author liyan
 *
 * @version V1.0.1
 */
public class World extends JFrame{
	
	
	private static final long serialVersionUID = 1L;


	public World() {
		
		//获取屏幕宽高
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = screensize.width / 3;
		int height = (int)(screensize.height * 0.8);
		
		Point p = new Point((screensize.width -width )/2,20);
		
		this.setSize(width, height);
		this.setLocation(p);
		
		
	}
	
	
	public class MyJpanel extends JPanel{
		
	}
	

}
