package com.crwu.rcp.training.action;
/**
 * class  descï¼?
 * @author WuChengRui  
 * @date 2018-8-14  
 */
//OpenAction.java
import java.lang.reflect.InvocationTargetException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.operation.ModalContext;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import com.crwu.training.jface.FileManager;
import com.crwu.training.jface.MainWindow;
public class OpenAction extends Action{
  public OpenAction(){
      super();
      setText("æå¼(&O)");
      setToolTipText("æå¼æä»¶");
//      setImageDescriptor(ImageDescriptor.createFromFile(NewAction.class, "icons\\open.gif"));
  }
  
  public void run(){
      FileDialog dialog = new FileDialog(MainWindow.getApp().getShell(), SWT.OPEN);
      dialog.setFilterExtensions(new String[]{"*.java", "*.*"});
      final String name = dialog.open();
      if((name == null) || (name.length()==0))
          return;
      final FileManager fileManager = MainWindow.getApp().getManager();
      try{
          ModalContext.run(new IRunnableWithProgress(){
              public void run(IProgressMonitor progressMonitor){
                  progressMonitor.beginTask("æå¼æä»¶", IProgressMonitor.UNKNOWN);
                  fileManager.load(name);
                  progressMonitor.done();
              }
          }, true, MainWindow.getApp().getStatusLineManager().getProgressMonitor(), 
          MainWindow.getApp().getShell().getDisplay());
      }catch(InvocationTargetException e){
          e.printStackTrace();
      }catch(InterruptedException e){
          e.printStackTrace();
      }
      
      MainWindow.getApp().getContent().setText(fileManager.getContent());
      MainWindow.getApp().getStatusLineManager().setMessage("å½åæå¼çæä»¶æ¯: "+name);
  }
}

