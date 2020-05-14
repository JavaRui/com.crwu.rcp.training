/**
 * 
 */
package com.crwu.common.img;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import com.crwu.common.UiEnumData.ALIGN_TYPE;
import com.crwu.common.YtColorUtil;
/**
 * @author cr.wu
 *
 * 2015�?7�?8�?
 */
public class CustomFd {
	
	/**字体颜色*/
	private Color fontColor = YtColorUtil.whiteColor;
	private String txt = "";
	private int height = 0;
	private int style = SWT.NORMAL;
	/**另外添加的图�?*/
	private String overPic = "";
	
	/**   =============    以下是共有参�?    =================*/
	/**
	 * 参�?�enmuData.ALIGN_TYPE
	 * */
	private ALIGN_TYPE alignType = ALIGN_TYPE.center;
	/**x坐标偏移*/
	private int offsetX = 0;
	private int offsetY = 0;
	
	public static CustomFd getPicFd(String overPic){
		CustomFd fd = new CustomFd();
		fd.setOverPic(overPic);
		return fd;
	}
	
	public static CustomFd getPicFd(String overPic , ALIGN_TYPE alignType){
		CustomFd fd = new CustomFd();
		fd.setOverPic(overPic);
		fd.setAlignType(alignType);
		return fd;
	}
	
	public static CustomFd getTxtFd(String txt){
		CustomFd fd = new CustomFd();
		fd.setTxt(txt);
		return fd;
	}
	
	public ALIGN_TYPE getAlignType() {
		return alignType;
	}
	public void setAlignType(ALIGN_TYPE alignType) {
		this.alignType = alignType;
	}
	public Color getFontColor() {
		return fontColor;
	}
	public void setFontColor(Color fontColor) {
		this.fontColor = fontColor;
	}
	public int getOffsetX() {
		return offsetX;
	}
	public void setOffsetX(int offsetX) {
		this.offsetX = offsetX;
	}
	public int getOffsetY() {
		return offsetY;
	}
	public void setOffsetY(int offsetY) {
		this.offsetY = offsetY;
	}
	public String getTxt() {
		return txt;
	}
	public void setTxt(String txt) {
		this.txt = txt;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getStyle() {
		return style;
	}
	public void setStyle(int style) {
		this.style = style;
	}
	public String getOverPic() {
		return overPic;
	}
	public void setOverPic(String overPic) {
		this.overPic = overPic;
	}
	@Override
	public String toString() {
		return "CustomFd [fontColor=" + fontColor + ", txt=" + txt + ", height=" + height + ", style=" + style + ", overPic=" + overPic + ", alignType=" + alignType + ", offsetX=" + offsetX
				+ ", offsetY=" + offsetY + "]";
	}
	
	
	
}

