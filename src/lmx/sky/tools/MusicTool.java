package lmx.sky.tools;


import java.io.InputStream;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import lmx.sky.GameConfig;

/**
 * @classname  MusicTool	--	音乐播放工具类
 * @desc
 * @createtime 2017年9月20日 上午9:28:38      
 * @author liyan
 *
 * @version V1.0.1
 */
public class MusicTool {

	
	public static Thread play(String path) {
		
		Thread t = new Thread();
		t.start();
		return t;
		
	}
	
	public static void main(String[] args) {
		String path = GameConfig.getInstance().music.bg01;
		System.out.println(path);
		Thread thread = play(path);
	}
	
}
