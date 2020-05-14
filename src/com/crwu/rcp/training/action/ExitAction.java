package com.crwu.rcp.training.action;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IWorkbenchWindow;
import com.crwu.rcp.training.Activator;
import com.crwu.rcp.training.WorkbenchControler;
public class ExitAction extends Action {
  
   public ExitAction(){
       this.setText("�?�?");
       this.setToolTipText("�?�?");
       this.setEnabled(true);
   }
   public void run(){
       //做�??出处理，首先判断是否为主窗体，如果为主窗体，则所有子窗体全部�?出，
       //如果为子窗体，则只单单的�?出子窗体，�?�主窗体则不用�??�?
       if(Activator.getActiveWorkbenchWindow()==WorkbenchControler.mainUI){
    //�?有的窗体都需要�??�?
           doAllClose(true);
       }else{
           //�?出子窗体
           doSClose(true);
       }
   }
   //�?出所有窗�?
   private boolean doAllClose(boolean flag){
       if(Activator.getActiveWorkbenchWindow()==WorkbenchControler.mainUI)
{
           IWorkbenchWindow[] iWorkbenchWindows =Activator.getWorkbenchWindows();
           if(MessageDialog.openConfirm(null,"提示","确定要�??出系统吗�?")){
               for(int i=0;i<iWorkbenchWindows.length;i++){
                   iWorkbenchWindows[i].close();
               }
               System.exit(0);
               return true;
           }
       }
       return false;
   }
   //�?出当前的窗体
   private boolean doSClose(boolean flag){
       if(MessageDialog.openConfirm(null,"提示","确定要�??出系统吗?")){
           Activator.getActiveWorkbenchWindow().close();
           if(Activator.getWorkbenchWindowCount()>=1){
               WorkbenchControler.mainUI.getShell().setMaximized(true);
               WorkbenchControler.mainUI.getShell().setFocus();
               return true;
           }
       }
       //MessageDialog.o
       return false;
   }
}

