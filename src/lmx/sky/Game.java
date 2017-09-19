package lmx.sky;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import lmx.sky.listener.GameKeyListener;
import lmx.sky.listener.GameMouseListener;
import lmx.sky.pojo.World;

/**
 * @classname  Game
 * @desc
 * @createtime 2017年9月14日 下午4:48:17      
 * @author liyan
 *
 * @version V1.0.1
 */
public class Game {
	
	private GameState curState;		//当前游戏状态
	private GameConfig config = GameConfig.getInstance();
	
	public Game create() {
		World world = new World();
		world.setVisible(true);
		world.setTitle(config.base.title);
		
		world.addKeyListener(new GameKeyListener());
		world.addMouseListener(new GameMouseListener());
		
		
		
		ImageIcon bgIcon = new ImageIcon(config.path.imgBackground); 
		JLabel imgLabel = new JLabel(bgIcon);
		world.getLayeredPane().add(imgLabel,Integer.MIN_VALUE);
		imgLabel.setBounds(0, 0, world.getWidth(), world.getHeight());
		JPanel panel = (JPanel)world.getContentPane();
		panel.setLayout(null);
		panel.setOpaque(false);
		
		curState = GameState.CREATE;
		return this;
	}
	 
	public void start() {
		curState = GameState.START;
	}

}
