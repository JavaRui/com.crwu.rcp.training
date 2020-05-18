package com.crwu.common.dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import com.crwu.common.callback.INBack;
/**
 * 2015-4-13
 * @author cr.wu
 *
 */
public class BtnDlgUtil {
	
	private BtnDlgUtil(){
		
	}
	/**
	 * 创建一个选择路径的button
	 * */
	public static Button createDirBtn(Composite parent , final INBack callBack){
		Button tempBtn = new Button(parent, SWT.PUSH);
		tempBtn.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				super.widgetSelected(e);
				String path = ChooseDlgUtil.openDir();
				if(path == null){
					return;
				}
				callBack.callBack(path);
			}
		});
		tempBtn.setText("选择目录路径");
		return tempBtn;
	}
	
	
	public static Button createDirBtn(Composite parent , final Text backText){
		return createDirBtn(parent , new INBack() {
			
			@Override
			public void callBack(Object o) {
				backText.setText(o+"");
			}
		});
		
	}
	
	/**
	 * 创建一个选择文件的button
	 * */
	public static Button createFileBtn(Composite parent , final INBack callBack){
		Button tempBtn = new Button(parent, SWT.PUSH);
		tempBtn.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				super.widgetSelected(e);
				String path = ChooseDlgUtil.openFile();
				if(path == null){
					return;
				}
				callBack.callBack(path);
			}
		});
		tempBtn.setText("选择路径");
		return tempBtn;
	}
	
	public static Button createFileBtn(Composite parent , final Text backText){
		return createFileBtn(parent , new INBack() {
			
			@Override
			public void callBack(Object o) {
				backText.setText(o+"");
			}
		});
		
	}
	
	/**
	 * 创建一个选择颜色的button
	 * */
	public static Button createColorBtn(Composite parent , final INBack callBack){
		Button tempBtn = new Button(parent, SWT.PUSH);
		tempBtn.setText("请设置颜色");
		tempBtn.addSelectionListener(new SelectionAdapter() {
			
			@Override
			public void widgetSelected(SelectionEvent e) {
				super.widgetSelected(e);
				RGB rgb = ChooseDlgUtil.openColor();
				if(rgb == null){
					return;
				}
				callBack.callBack(rgb);
			}
		});
		return tempBtn;
	}
	
}

