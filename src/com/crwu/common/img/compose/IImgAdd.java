/**
 * 
 */
package com.crwu.common.img.compose;
import org.eclipse.swt.graphics.Image;
/**
 * @author cr.wu
 *
 * 2015�?7�?14�?
 * 
 * 组合图片或组合文字图片的接口�?
 * 
 */
public interface IImgAdd {
	/**�?始组合图片，返回自身*/
	public IImgAdd createImage();
	public IImgAdd createImage(boolean cache);
	/**获取组合之后的图�?*/
	public Image getImage();
	/**设置自定义参�?*/
	public void setCustomFd(CustomFd fd);
	
	
}

