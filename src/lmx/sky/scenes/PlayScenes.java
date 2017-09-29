package lmx.sky.scenes;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import lmx.sky.GameConfig;
import lmx.sky.componts.Translate;
import lmx.sky.pojo.GameObject;
import lmx.sky.pojo.MyPlane;
import lmx.sky.tools.ImageTool;

/**
 * @classname  PlayScenes	--		游戏场景
 * @desc
 * @createtime 2017年9月28日 下午2:35:22      
 * @author liyan
 *
 * @version V1.0.1
 */
public class PlayScenes extends Scenes{
	
	
	private MyPlane myPlane;
	
	public PlayScenes(World world) {
		super(world);
	}
	
	
	public PlayScenes(World world, int width, int height) {
		super(world,width, height);
		joinLabel();
	}
	
	
	/**
	 *	添加组件 
	 */
	private void joinLabel() {
		//设置背景
		ImageIcon iconBg = (ImageIcon)ImageTool.getIcon(GameConfig.getInstance().image.bgPlay);
		iconBg.setImage(iconBg.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));  
		GameObject gameObject = new GameObject();
		gameObject.setBounds(0, 0, this.getWidth(), this.getHeight());
		gameObject.setIcon(iconBg);
//		this.addGameObject(gameObject);
		this.add(gameObject);
		
		//添加角色
		myPlane = new MyPlane();
		Translate translate = myPlane.getComponent(Translate.class);
		translate.x = this.getWidth() / 2;
		translate.y = this.getHeight() / 2;
		
		this.addGameObject(myPlane);
	}
	
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
	}
	
}
