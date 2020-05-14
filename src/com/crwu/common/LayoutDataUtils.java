package com.crwu.common;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
/**
 * 用于创建常用的gridData等等
 * @author WuChengRui
 * @category swt扩展功能模块
 * 
 * */
public class LayoutDataUtils {
	
	
	
	/**
	 * 创建样式为充满，并自动抢占的griddata
	 * */
	public static GridData createFillGrid(){
		GridData gd = new GridData();
		gd.horizontalSpan = 1;
		gd.grabExcessHorizontalSpace = true;
		gd.grabExcessVerticalSpace = true;
		gd.horizontalAlignment = gd.verticalAlignment = SWT.FILL;
		
		return gd;
	}
	/**
	 * 创建样式为充满，且全�??占满，占有gridCount个数个griddata
	 * @param gridCount 水平方向的占用grid数量
	 * @return GridData
	 * */
	public static GridData createFillGrid(int gridCount){
		GridData gd = createFillGrid();
		gd.horizontalSpan = gridCount;
		return gd;
	}
	
	/**
	 * 创建样式为充满，占有gridCount个数个griddata
	 * @param gridCount 水平方向的占用grid数量
	 * @return GridData
	 * */
	public static GridData createFillGridNoFill(int gridCount){
		GridData gd = createFillGridNoVer(gridCount);
		gd.grabExcessHorizontalSpace = false;
		return gd;
	}
	
	/**
	 * 创建样式为充满，且水平占满，占有gridCount个数个griddata
	 * @param gridCount 水平方向的占用grid数量
	 * @return GridData
	 * */
	public static GridData createFillGridNoVer(int gridCount){
		GridData gd = createFillGrid(gridCount);
		gd.grabExcessVerticalSpace = false;
		return gd;
	}
	
	/**
	 * 设置与本来相反的显示
	 * */
	public static void changeExclude(Control c){
		GridData gd = null;
		if(c.getLayoutData() == null){
			gd = new GridData();
		}else{
			gd = (GridData)c.getLayoutData();
		}
		gd.exclude = !gd.exclude;
		c.setLayoutData(gd);
		c.setVisible(!gd.exclude);
		c.getParent().layout();
	}
	
	/**
	 * 设置显示方式
	 * */
	public static void setExclude(Control c , boolean b){
		GridData gd = null;
		if(c.getLayoutData() == null){
			gd = new GridData();
		}else{
			gd = (GridData)c.getLayoutData();
		}
		gd.exclude = !b;
		c.setLayoutData(gd);
		c.setVisible(b);
		c.getParent().layout();
	}
	
	
	
}

