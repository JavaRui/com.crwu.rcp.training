package com.crwu.rcp.training.action;
/**
 * class  desc�?
 * @author WuChengRui  
 * @date 2018-8-14  
 */
//NewAction.java
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import com.crwu.training.jface.FileManager;
import com.crwu.training.jface.MainWindow;
public class NewAction extends Action{
  public NewAction(){
      super();
      setText("新建(&N)");
      this.setAccelerator(SWT.ALT + SWT.SHIFT + 'N');
      setToolTipText("新建");
//      setImageDescriptor(ImageDescriptor.createFromFile(NewAction.class, "icons\\new.gif"));
  }
  
  public void run(){
      MainWindow.getApp().getContent().setText("");
      MainWindow.getApp().setManager(new FileManager());
  }
}

