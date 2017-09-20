package lmx.sky.tools;

import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;


public class ImageTool {
	
	/**
	 * 
	 * @param path
	 * @return
	 */
	public static Icon getIcon(String path){
		Icon icon = new ImageIcon(path);
		return icon;
	}

}
