package lmx.sky.managers;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import lmx.sky.pojo.GameObject;

/**
 * @classname  ApplyManager		--		渲染管理器
 * @desc
 * @createtime 2017年9月28日 下午1:44:47      
 * @author liyan
 *
 * @version V1.0.1
 */
public class ApplyManager {
	
	/**
	 * 渲染线程池
	 */
	private static final ThreadPoolExecutor APPLY_POOL;
	
	
	private static LinkedBlockingQueue<Runnable> queue
		= new LinkedBlockingQueue<Runnable>();
	
	static {
		APPLY_POOL = 
				new ThreadPoolExecutor(4, 20, 10, TimeUnit.SECONDS,queue,
						new ThreadPoolExecutor.DiscardOldestPolicy());
	}
	
	
	/**
	 * 渲染组件
	 */
	public static synchronized void apply(GameObject gameObject) {
		
	}
	

}
