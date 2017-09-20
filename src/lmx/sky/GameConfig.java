package lmx.sky;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Serializable;

import javax.security.auth.login.Configuration;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;



/**
 * @classname  GameConfig
 * @desc
 * @createtime 2017年9月14日 下午4:24:29      
 * @author liyan
 *
 * @version V1.0.1
 */
public class GameConfig implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1138747993761454166L;
	
	
	
	public BaseConfig base;
	public ImageConfig image;
	public MusicConfig music;
	
	
	private static GameConfig config;
	
	
	private GameConfig() {
		
	}
	
	
	public static GameConfig getInstance() {
		if (config== null) {
			loadConfig();
		}
		return config;
	}
	
	
	/**
	 * 加载config
	 */
	public static void loadConfig() {
		try {
			String pathname = "./props/config.json";
			FileInputStream fis = new FileInputStream(new File(pathname));
			InputStreamReader isr = new InputStreamReader(fis,"utf-8");
			BufferedReader reader = new BufferedReader(isr);
			String str = null;
			StringBuilder sb = new StringBuilder();
			while ((str = reader.readLine()) != null) {
				sb.append(str);
				
			}
			Gson gson = new GsonBuilder().create();
			config = gson.fromJson(sb.toString(), GameConfig.class);
			System.out.println("加载静态资源成功...");
			
		} catch (Exception e) {

		}
	}
	
	
	/**
	 * 生成config
	 */
	public static void createConfig() {
		GameConfig config = new GameConfig();
		config.base = new GameConfig.BaseConfig();
		config.base.title = "SkyFight";
		
		try {
			String pathname = "./props/config.json";
			File file = new File(pathname);
			PrintWriter pw = new PrintWriter(file);
			Gson gson = new GsonBuilder().create();
			String str = gson.toJson(config);
			pw.write(str);
			pw.flush();
			pw.close();
			
		} catch (Exception e) {

		}
	}
	
	/**
	 * @classname  BaseConfig	基础配置
	 * @desc	
	 * @createtime 2017年9月14日 下午4:24:20      
	 * @author liyan
	 *
	 * @version V1.0.1
	 */
	public static class BaseConfig implements Serializable{

		/**
		 * 
		 */
		private static final long serialVersionUID = 8777816134965360710L;
		
		
		
		/**
		 * title
		 */
		public String title;
		
		/**
		 * width
		 */
		public int width;
		
		
		/**
		 * height
		 */
		public int height;
		
	}
	

	/**
	 * @classname  PathConfig	路径配置
	 * @desc
	 * @createtime 2017年9月14日 下午5:37:35      
	 * @author liyan
	 *
	 * @version V1.0.1
	 */
	public static class ImageConfig implements Serializable{

		/**
		 * 
		 */
		private static final long serialVersionUID = -4300140164174530550L;
		
		public String bgStart;		//初始画面背景图
		public String bgPlay;		//开始游戏后背景图
		public String big;
		public String gameStart;	//开始按钮贴图
		
	}
	
	
	/**
	 * @classname  MusicConfig	音乐配置
	 * @desc
	 * @createtime 2017年9月20日 上午9:38:07      
	 * @author liyan
	 *
	 * @version V1.0.1
	 */
	public static class MusicConfig implements Serializable{

		/**
		 * 
		 */
		private static final long serialVersionUID = 2861667282019195759L;
		
		public String bg01;		//bg music 01
		public String bg02;		//bg music 02
		public String bg03;		//bg music 03
		public String bg04;		//bg music 04
		
	}
	
}
