/**
 * 
 */
package com.crwu.common.img;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;

import com.crwu.common.YtColorUtil;
import com.crwu.common.YtFontUtil;
import com.crwu.common.img.UiEnumData.ALIGN_TYPE;
/**
 * @author cr.wu
 *
 * 2015�?7�?8�?
 * 
 * 例子1�?
 * ImgAddTxt img = new ImgAddTxt(ImagePath.T, "我就�?");
		
		img.createImage();
		Image image = img.getImageTxt();
		
	ImgAddTxt img = new ImgAddTxt(image, "我就�?");
		
		img.createImage();
		
	合并图片和文�?
 */
/**
 * @author cr.wu
 *
 * 2015�?7�?8�?
 */
public class ImgAddTxt implements IImgAdd{
	private Image imageTxt;
	private String txt;
	private Font font = YtFontUtil.getFontNor(0);
	private int offsetX = 0;
	private int offsetY = 0;
	private int x = 0;
	private int y = 0;
	/**字体大小*/
	private int fontHeight = 0;
	/**字体颜色*/
	private Color fontColor = YtColorUtil.whiteColor;
	
	private int style = SWT.NO_MERGE_PAINTS;
	/**上下间隔*/
	private int verSpace = 20;
	/**左右间隔*/
	private int horSpace = 40;
	
	
	private ALIGN_TYPE alignType = ALIGN_TYPE.center;
	
	private String imgKey = "";
	
	/**
	 * 
	 * @param imagePath 图片地址
	 * @param txt 文字
	 */
	public ImgAddTxt(String imagePath , String txt){
		imageTxt = ImageFoctory.getImg(imagePath);
		this.txt = txt;
		
		imgKey = imageTxt+txt;
		
	}
	
	/**
	 * 
	 * @param imagePath 图片地址
	 * @param txt 文字
	 */
	public ImgAddTxt(Image image , String txt){
		imageTxt = image;
		this.txt = txt;
		
		imgKey = imageTxt+txt;
		
	}
	
	/**
	 * 设置很多参数，用类传�?
	 * @param fd 
	 */
	public void setCustomFd(CustomFd fd){
		if(fd == null){
			return;
		}
		offsetX = fd.getOffsetX();
		offsetY = fd.getOffsetY();
		
		fontColor = fd.getFontColor();
		
		setFont(fd.getHeight(), fd.getStyle());
		
		if(fd.getTxt().length() != 0){
			txt = fd.getTxt();
		}
		
		alignType = fd.getAlignType();
		
	}
	
	/**
	 * 设置字体的大小和style
	 * @param style SWT.NORMAL,SWT.SWT.BOLD,SWT.ITALIC(斜体)
	 * */
	public void setFont(int height , int style){
		if(height != 0){
			fontHeight = height;
		}
		this.style = style;
		Font tempFont = new Font(null, YtFontUtil.FONT_STYLE, height, style);
		font = tempFont;
	}
	/**
	 * 设置位置
	 * */
	public void setAlignType(ALIGN_TYPE alignType) {
		this.alignType = alignType;
	}
	/**
	 * 获取生成之后的图�?
	 * */
	public Image getImage(){
		
		return imageTxt;
	}
	/**
	 * 创建image且设置是否要缓存
	 * */
	public IImgAdd createImage(boolean cache){
		if(txt.length() == 0){
			return this;
		}
		if(fontHeight == 0){
			verSpace = imageTxt.getImageData().height/2;
			fontHeight = getSizeByPx(imageTxt.getImageData().height - verSpace);
			setFont(fontHeight , style);
		}
		
		imgKey += font.getFontData()[0].getHeight() + font.getFontData()[0].getStyle();
		if(ImageFoctory.getImg(imgKey) == null){
			GC gc = createGc();
			fontHeight = font.getFontData()[0].getHeight();
			int textWidth = gc.textExtent(txt).x;
			//当文字的实际宽度大于图片的宽�?.
			if(textWidth >= imageTxt.getImageData().width-horSpace){
				
				imageTxt = ImageFoctory.setSize(imageTxt, textWidth+horSpace, -1);
				gc = createGc();
			}
			dealXY();
			gc.drawString(txt, x, y , true);
			gc.dispose();
			if(cache){
				ImageFoctory.hm.put(imgKey, imageTxt.getImageData());
			}
		}else{
			imageTxt = ImageFoctory.getImg(imgKey);
		}
		return this;
		
	}
	
	private GC createGc(){
		GC gc = new GC(imageTxt);
		gc.setForeground(fontColor);
		gc.setFont(font);
		return gc;
	}
	
	/**
	 * 参数设置好之后，创建图片
	 * */
	public IImgAdd createImage(){
		return createImage(false);
	}
	
	
	/**
	 * 设置居中，且含有偏移量，为某些特殊字符中，提供坐标修改的支持
	 * 
	 * @param offsetX
	 * @param offsetY
	 * */
	public void setAutoAndAffset(int offsetX, int offsetY) {
		this.offsetX = offsetX;
		this.offsetY = offsetY;
	}
	/**
	 * 计算�?个字占有多少像素,只针对swt下的微软雅黑，且会有些偏�?
	 * */
	private Point getPxByFontSize(int fontSize) {
//		return Integer.valueOf((int) (Float.valueOf(fontSize) / 72 * 137));
		Font font = YtFontUtil.getFontBold(fontSize);
		Point p = YtFontUtil.getPxByText(txt, font);
		return p;
	}
	/**
	 * 通过图片的高，生成字体的尺寸
	 * */
	private int getSizeByPx(int h){
		int size = (int)(Float.valueOf(h) / 137 * 72);
		if(size%2!=0){
			size += 1;
		}
		if(size <=12){
			size = 12;
		}
		return size;
	}
	
	/**
	 * 处理xy坐标
	 * */
	private void dealXY(){
		
		int w = imageTxt.getImageData().width;
		int h = imageTxt.getImageData().height;
		//没个文本的高�?
		int fd = getPxByFontSize(fontHeight).y;
		//fd * txt.length()
		int txtWidth = getPxByFontSize(fontHeight).x;
		if(ALIGN_TYPE.center.equals(alignType)){
			this.x = w/2 - txtWidth/2;
//			this.x = w/2 - (fd * txt.length() )/2 + fd*txt.length()/8;
		}else if(ALIGN_TYPE.left.equals(alignType)){
			this.x = 5;
		}else if(ALIGN_TYPE.right.equals(alignType)){
			this.x = w - txtWidth;
//			this.x = w - (fd * txt.length() ) + fd*txt.length()/8;
		}
		this.y = h / 2 - fd / 2;
		
		this.x += offsetX;
		this.y += offsetY;
		
	}
	
	
	
	
	
}

