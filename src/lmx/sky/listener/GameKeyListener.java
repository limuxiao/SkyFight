package lmx.sky.listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import lmx.sky.scenes.World;

/**
 * @classname  GameKeyListener
 * @desc
 * @createtime 2017年9月14日 下午5:29:17      
 * @author liyan
 *
 * @version V1.0.1
 */
public class GameKeyListener implements KeyListener{
	
	
	private boolean isEnable = false;	//是否可控，true -- 可控 ， false -- 不可控
	
	private World world;
	
	public GameKeyListener(World world) {
		this.world = world;
	}
	

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(!isEnable) return;
		switch (e.getKeyCode()) {
		case KeyEvent.VK_A:		//左移
			this.world.myPlane.moveLeft();
			break;
		case KeyEvent.VK_S:		//下移
			this.world.myPlane.moveDown();
			break;
		case KeyEvent.VK_W:		//上移
			this.world.myPlane.moveUp();
			break;
		case KeyEvent.VK_D:		//右移
			this.world.myPlane.moveRight();
			break;
			
		default:
			break;
		}
		this.world.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	
	
	
	

	public boolean isEnable() {
		return isEnable;
	}

	public void setEnable(boolean isEnable) {
		this.isEnable = isEnable;
	}
	
	
	
	
	
	
	

}
