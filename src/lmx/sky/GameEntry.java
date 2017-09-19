package lmx.sky;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import lmx.sky.pojo.World;

/**
 * @classname  GameEntry	游戏入口
 * @desc
 * @createtime 2017年9月14日 下午4:55:49      
 * @author liyan
 *
 * @version V1.0.1
 */
public final class GameEntry {
	
	
	
	
	public static void main(String[] args) {
		
		new Game().create().start();
		
		
		
	}

	
	
	
	
	
	
	
	
}
