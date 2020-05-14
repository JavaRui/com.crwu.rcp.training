/**
 * 
 */
package com.crwu.common.img;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import com.crwu.common.UiEnumData.ALIGN_TYPE;
/**
 * @author cr.wu
 *
 * 2015?7??14?
 */
public class ImgAddImg implements IImgAdd{
	private Image mainImg;
	private Image overImg;
	private CustomFd fd;
	private String imgKey = "";
	
	/**
	 * 
	 */
	public ImgAddImg(Image mainImg , Image overImg) {
		this.mainImg = mainImg;
		this.overImg = overImg;
	}
	
	public ImgAddImg(String mainPath , String overPath){
		mainImg = ImageFoctory.getImg(mainPath);
		overImg = ImageFoctory.getImg(overPath);
		imgKey = mainPath + overPath;
	}
	
	public void setImgKey(String key){
		imgKey = key;
	}
	
	public void setCustomFd(CustomFd fd){
		this.fd = fd;
	}
	
	public IImgAdd createImage(){
		return createImage(false);
	}
	
	@Override
	public IImgAdd createImage(boolean cache) {
		
		if(fd == null){
			fd = new CustomFd();
		}
		
		if(ImageFoctory.getImg(imgKey) == null){
			Point xy = dealXY();
			GC gc = new GC(mainImg);
			gc.drawImage(overImg, xy.x, xy.y);
			gc.dispose();
			overImg.dispose();
			if(imgKey.length()!=0  ){
				if(cache){
					ImageFoctory.hm.put(imgKey, mainImg.getImageData());
				}
			}
			
		}else{
			mainImg.dispose();
			mainImg = null;
			mainImg = ImageFoctory.getImg(imgKey);
		}
		
		return this;
	}
	
	public Image getImage(){
		return mainImg;
	}
	
	/**
	 * ??xy????
	 * */
	private Point dealXY() {
		Point xy = new Point(0, 0);
		int w = mainImg.getImageData().width;
		int h = mainImg.getImageData().height;
		int sw = overImg.getImageData().width;
		int sh = overImg.getImageData().height;
		if (ALIGN_TYPE.center.equals(fd.getAlignType())) {
			xy.x = w / 2 - sw / 2;
			xy.y = h / 2 - sh / 2;
		} else if (ALIGN_TYPE.left.equals(fd.getAlignType())) {
			xy.x = 2;
			xy.y = 0;
		} else if (ALIGN_TYPE.right.equals(fd.getAlignType())) {
			xy.x = w - sw;
			xy.y = 0;
		}
		xy.x += fd.getOffsetX();
		xy.y += fd.getOffsetY();
		
		
		return xy;
	}
	
	
}

