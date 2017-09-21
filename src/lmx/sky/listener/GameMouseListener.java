package lmx.sky.listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * @classname  GameMouseListener
 * @desc
 * @createtime 2017年9月14日 下午5:29:12      
 * @author liyan
 *
 * @version V1.0.1
 */
public class GameMouseListener implements MouseListener {

	private boolean isEnable = false;	//是否可控，true -- 可控 ， false -- 不可控
	
	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if(isEnable)
			System.out.println("鼠标进入");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if(isEnable)
			System.out.println("鼠标移出");
	}

	
	
	
	public boolean isEnable() {
		return isEnable;
	}

	public void setEnable(boolean isEnable) {
		this.isEnable = isEnable;
	}
}
