package lmx.sky.pojo;

import java.awt.Image;
import java.io.Serializable;

import javax.swing.Icon;
import javax.swing.JLabel;

/**
 * @classname  Elf	小精灵，所有物体的基类
 * @desc
 * @createtime 2017年9月14日 下午5:00:02      
 * @author liyan
 *
 * @version V1.0.1
 */
public class Elf implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4172843079858803490L;
	

	public int width;		//宽
		
	public int height;		//高
	
	public int x;			//x轴坐标
	
	public int y;			//y轴坐标
	
	public boolean canMove = true;	//是否可以移动
	
	public int speed;		//速度
	
	public Icon icon;		//贴图
	
	public Image image;		//image
	
	
	
	public void setLocation(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * 上移
	 */
	public void moveUp() {
		if(this.canMove && this.y > 0)
			this.y -= this.speed;
	}
	
	
	/**
	 * 下移
	 */
	public void moveDown() {
		if(this.canMove)
			this.y += this.speed;
	}
	
	
	/**
	 * 左移
	 */
	public void moveLeft() {
		if(this.canMove && this.x > 0)
			this.x -= this.speed;
	}
	
	
	/**
	 * 右移
	 */
	public void moveRight() {
		if (this.canMove) {
			this.x += this.speed;
		}
	}

}
