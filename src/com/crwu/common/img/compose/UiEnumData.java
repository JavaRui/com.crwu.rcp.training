
package com.crwu.common.img.compose;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Cursor;
/**
 * @author cr.wu
 *
 */
public class UiEnumData {
	/**
	 * 定义位置的枚举
	 * */
	public static enum ALIGN_TYPE{
		center , left , right;
	}
	/**
	 * 在imgMgr里面有引用实�?
	 * 定义图片类型的枚�?
	 * img 单图�?   
	 * imgTxt 图片+文字    
	 * imgImg 图片+图片   
	 * imgNorOverImg nor图片+图片,over图片+图片   
	 * imgNorOver 图片nor+图片over   
	 * imgNorOverTxt 图片nor+图片over+txt文本   
	 * */
	public static enum PIC_TYPE{
		/**img 单图�?   */
		img,
		/**imgTxt 图片+文字     */
		imgTxt,
		/**nor+图片,over图片+图片  */
		imgNorOverImg,
		/**nor图片+over图片+txt文本   */
		imgNorOverTxt,
		/**图片+图片   */
		imgImg,
		/**nor图片+over图片   */
		imgNorOver
	}
	
	
	
}

