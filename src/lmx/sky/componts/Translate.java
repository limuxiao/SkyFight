package lmx.sky.componts;

/**
 * @classname  Translate	--		位置组件
 * @desc
 * @createtime 2017年9月22日 上午10:01:43      
 * @author liyan
 *
 * @version V1.0.1
 */
public class Translate extends ApplyComponent{
	
	public int x;	//横坐标
	public int y;	//纵坐标
	
	
	public Translate() {
		this(0,0);
	}
	
	public Translate(int x,int y) {
		this.x = x;
		this.y = y;
	}
	

}
