/**
 * 
 */
package com.crwu.common.img;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.internal.OverlayIcon;

import com.crwu.common.ShellBack;
import com.crwu.common.UiUtils;
import com.crwu.common.UiEnumData.ALIGN_TYPE;
/**
 * @author cr.wu
 * 
 *         2015�??7�??8�??
 */
public class OverLay2 extends OverlayIcon {
    
	// the size of the OverlayIcon
	private Point fSize = null;
	// the main image
	private ImageDescriptor fBase = null;
	// the additional image (a pin for example)
	private ImageDescriptor fOverlay = null;
	private ALIGN_TYPE alignType = ALIGN_TYPE.center;
	
	/**坐标偏移�??*/
	private int offsetX = 0;
	private int offsetY = 0;
	public OverLay2(ImageDescriptor base, ImageDescriptor overlay, Point size) {
		super(base, overlay, size);
		fBase = base;
		fOverlay = overlay;
		fSize = size;
	}
	
	
	public static OverLay2 creatOver(String mainPath, String overPath){
		OverLay2 ol = OverLay2.creatOver(ImageFoctory.getImg(mainPath), ImageFoctory.getImg(overPath));
		return ol;
	}
	
	public static OverLay2 creatOver(Image mainPath, Image overPath){
		ImageDescriptor base = ImageDescriptor.createFromImage(mainPath);
		ImageDescriptor overlay = ImageDescriptor.createFromImage(overPath);
		Point size = new Point(base.getImageData().width, base.getImageData().height);
		OverLay2 ol = new OverLay2(base, overlay, size);
		return ol;
	}
	
	
	@Override
	protected void drawCompositeImage(int width, int height) {
		ImageData bg;
		if (fBase == null || (bg = fBase.getImageData()) == null) {
			bg = DEFAULT_IMAGE_DATA;
		}
		drawImage(bg, 0, 0);
		if (fOverlay != null) {
			Point p = dealXY();
			ImageData id = fOverlay.getImageData();
			drawImage(id, p.x, p.y);
		}
	}
	/**
	 * 处理xy坐标
	 * */
	private Point dealXY() {
		Point xy = new Point(0, 0);
		int w = fBase.getImageData().width;
		int h = fBase.getImageData().height;
		int sw = fOverlay.getImageData().width;
		int sh = fOverlay.getImageData().height;
		if (ALIGN_TYPE.center.equals(alignType)) {
			xy.x = w / 2 - sw / 2;
			xy.y = h / 2 - sh / 2;
		} else if (ALIGN_TYPE.left.equals(alignType)) {
			xy.x = 2;
			xy.y = 0;
		} else if (ALIGN_TYPE.right.equals(alignType)) {
			xy.x = w - sw;
			xy.y = 0;
		}
		xy.x += offsetX;
		xy.y += offsetY;
		
		
		return xy;
	}
	public void setAlign(ALIGN_TYPE t){
		alignType = t;
	}
	/**
	 * 设置坐标偏移量，在左右对齐的时�?�，离边界问题可能要修改
	 * */
	public void setOffset(int x , int y){
		offsetX = x;
		offsetX = y;
	}
	
	public static void main(String[] args) {
        UiUtils.createSwt(new ShellBack() {
            
            @Override
            public void callBack(Shell shell) {
            }
        });
    }
	
	
}

