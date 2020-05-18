/**
 * 
 */
package com.crwu.common.img;
import org.eclipse.swt.graphics.Image;

import com.crwu.common.img.UiEnumData.PIC_TYPE;
/**
 * @author cr.wu
 *
 * 2015�?7�?11�?
 */
public class ImgMgr {
	
	
	/**
	 * 生成图片数组
	 * @param imagePath 基础图片
	 * @param fd 特殊参数
	 * @param picType 组合图片的方�?
	 * @return
	 */
	public static Image[] setImage(String imagePath , CustomFd fd ,UiEnumData.PIC_TYPE picType){
		Image norImg = null;
		Image overImg = null;
		
		if(picType == PIC_TYPE.img){
			
			norImg = ImageFoctory.getImg(imagePath) ;
			
		}else if(picType == PIC_TYPE.imgImg){
			
			ImgAddImg ii1 = new ImgAddImg(imagePath, fd.getOverPic());
			norImg = ii1.createImage().getImage();
			
		}else if(picType == PIC_TYPE.imgNorOverImg){
			
			ImgAddImg ii1 = new ImgAddImg(imagePath+"Nor.png", fd.getOverPic());
			ImgAddImg ii2 = new ImgAddImg(imagePath+"Over.png", fd.getOverPic());
			
			norImg = ii1.createImage().getImage();
			overImg = ii2.createImage().getImage();
			
			
		}else if(picType == PIC_TYPE.imgNorOver){
			
			norImg = ImageFoctory.getImg(imagePath+"Nor.png") ;
			overImg = ImageFoctory.getImg(imagePath+"Over.png") ;
			
		}else if(picType == PIC_TYPE.imgTxt){
			
			norImg = ImageFoctory.getImg(imagePath) ;
			norImg = imageAddTxt(norImg , fd);
			
		}else if(picType == PIC_TYPE.imgNorOverTxt){
			
			norImg = ImageFoctory.getImg(imagePath+"Nor.png") ;
			overImg = ImageFoctory.getImg(imagePath+"Over.png") ;
			
			norImg = imageAddTxt(norImg , fd);
			overImg = imageAddTxt(overImg , fd);
			
			
		}
		return new Image[]{norImg , overImg};
	}
	
	/**
	 * 如果不需要设置fd，可以调用此方法传�??
	 * */
	public static Image[] setImage(String imagePath ,String txt ,UiEnumData.PIC_TYPE picType){ 
		CustomFd fd = CustomFd.getTxtFd(txt);
		if(txt.length() == 0){
			fd = null;
		}
		return setImage(imagePath , fd , picType);
	}
	
	
	public static Image[] setImage(String imagePath ,PIC_TYPE picType){ 
		return setImage(imagePath , "" ,picType);
	}
	
	/**  =============    获取�?单的图片+文本    =====================*/
	public static Image getSimpleLT(String imagePath , String txt){
		return getSimpleLT(ImageFoctory.getImg(imagePath),txt);
	}
	
	public static Image getSimpleLT(Image image , String txt){
		return imageAddTxt(image , CustomFd.getTxtFd(txt));
	}
	
	private static Image imageAddTxt(Image image , CustomFd customFd){
		ImgAddTxt img = new ImgAddTxt(image, customFd.getTxt());
		
		img.setCustomFd(customFd);
		img.createImage();
		return img.getImage();
	}
	
}

