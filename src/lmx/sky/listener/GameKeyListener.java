package lmx.sky.listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @classname  GameKeyListener
 * @desc
 * @createtime 2017年9月14日 下午5:29:17      
 * @author liyan
 *
 * @version V1.0.1
 */
public class GameKeyListener implements KeyListener{

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("点击了：" + e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

}
