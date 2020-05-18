package com.crwu.common.dialog;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;

import com.crwu.common.UiUtil;
import com.crwu.common.constants.xxx;
public class MsgDlgUtil {
	public  static String TITLE = "系统提示";
	
	public static void setTitle(String t){
		TITLE = t;
	}
	
	/**
	 * return:
	 * SWT.OK
	 * SWT.CANCEL
	 * */
	public static int showMessbox(String desc){
		return showMessbox(MsgDlgUtil.TITLE,desc,0);
	}
	public static int showMessbox(final String title,final String desc,int style){
		
		if(style == 0){
			style = SWT.OK|SWT.CANCEL;
		}else{
			style =  SWT.OK;
		}
		MessageBox messageBox = new MessageBox(Display.getDefault().getActiveShell(), style); 
		messageBox.setMessage(desc);
		messageBox.setText( title);
		
		return messageBox.open() ;// messageBox.open() == SWT.OK, messageBox.open() == SWT.CANCEL;
	}
	
	public static void showInfo(final String title,final String desc){
		UiUtil.delayAsy(0, new Runnable() {
			
			@Override
			public void run() {
				MessageDialog.openInformation(Display.getCurrent().getActiveShell(), title, desc);
			}
		});
	}
	
	public static int showCustomDialog(String title,String desc,String[] btnTxt){
		MessageDialog d = new MessageDialog(Display.getCurrent().getActiveShell(),title,
				null,desc,
				MessageDialog.INFORMATION,
				btnTxt,
				1) ;
		int i = d.open();
		return i;
	}
	
	public static void showError(final String title,final String desc){
		UiUtil.delayAsy(0, new Runnable() {
			
			@Override
			public void run() {
				MessageDialog.openError(null, title, desc);
			}
		});
	}
	
	public static void showError(String desc){
		showError( MsgDlgUtil.TITLE, desc);
	}
	/**
	 * return value	正常输入
	 * 	""==>用户点击了确定按钮，但没输入
	 * 	null==>用户点击了取消按钮
	 * */
	public static String showInput(String desc){
		
		return showInput(desc , "");
		
	}
	
	/**
	 * return value	正常输入
	 * 	""==>用户点击了确定按钮，但没输入
	 * 	null==>用户点击了取消按钮
	 * */
	public static String showInput(String desc , String value){
		
		InputDialog inputDialog = new InputDialog(null,desc, desc, value, null);
		
		int r = inputDialog.open();
		if(r == Window.OK){
			xxx.log(MsgDlgUtil.class,"ok");
			value = inputDialog.getValue();
		}else {
			xxx.log(MsgDlgUtil.class,"no");
			return null;
		}
		return value;
		
	}
	
}

