package lmx.sky.managers;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import lmx.sky.pojo.GameObject;
import lmx.sky.scenes.Scenes;

/**
 * @classname  ApplyManager		--		渲染管理器
 * @desc
 * @createtime 2017年9月28日 下午1:44:47      
 * @author liyan
 *
 * @version V1.0.1
 */
public class ApplyManager {
	
	private Scenes scenes;
	
	public ApplyManager(Scenes scenes) {
		this.scenes = scenes;
	}
	
	/**
	 * 渲染线程池
	 */
	private ThreadPoolExecutor apply_pool = 
			new ThreadPoolExecutor(4, 20, 10, TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>(),
			new ThreadPoolExecutor.DiscardOldestPolicy());
	
	
	/**
	 * 渲染组件
	 */
	public void apply(GameObject gameObject) {
		apply_pool.execute(new ApplyRunnable(gameObject));
	}
	
	
	
	class ApplyRunnable implements Runnable{

		private GameObject gameObject;
		
		public ApplyRunnable(GameObject gameObject) {
			this.gameObject = gameObject;
		}
		
		@Override
		public void run() {
			
		}
		
	}
	

}
