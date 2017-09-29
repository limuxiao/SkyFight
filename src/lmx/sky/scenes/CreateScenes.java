package lmx.sky.scenes;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import lmx.sky.GameConfig;
import lmx.sky.pojo.GameObject;
import lmx.sky.tools.ImageTool;

/**
 * @classname  CreateScenes	--	游戏初始场景
 * @desc
 * @createtime 2017年9月26日 上午10:51:45      
 * @author liyan
 *
 * @version V1.0.1
 */
public class CreateScenes extends Scenes{
	
	public CreateScenes() {
		super();
	}
	
	public CreateScenes(int width,int height) {
		super(width,height);
		joinLabel();
	}
	
	
	/**
	 * 添加组件
	 */
	private void joinLabel() {
		//设置背景
		ImageIcon iconBg = (ImageIcon)ImageTool.getIcon(GameConfig.getInstance().image.bgStart);
		iconBg.setImage(iconBg.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH));  
		GameObject gameObject = new GameObject();
		gameObject.setBounds(0, 0, this.getWidth(), this.getHeight());
		gameObject.setIcon(iconBg);
		this.addGameObject(gameObject);
		
		//设置开始按钮
		ImageIcon iconStart = (ImageIcon)ImageTool.getIcon(GameConfig.getInstance().image.gameStart);
		JButton btnStart = new JButton(iconStart);
		int btnStartX = (this.getWidth() - iconStart.getIconWidth()) / 2;
		int btnStartY = this.getHeight() - iconStart.getIconHeight() - 100;
		btnStart.setBounds(btnStartX, btnStartY, iconStart.getIconWidth(), iconStart.getIconHeight());
		btnStart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(world != null) {
					
					PlayScenes playScenes = new PlayScenes(world.width,world.height);
					playScenes.setWorld(world);
					
					world.addScenes(playScenes);
					CreateScenes.this.setVisible(false);
				}
			}
		});
		this.add(btnStart);
	}
	
	
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		
	}
	
	
}
