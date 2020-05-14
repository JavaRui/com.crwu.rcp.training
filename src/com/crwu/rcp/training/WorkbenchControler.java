package com.crwu.rcp.training;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
 
public class WorkbenchControler {
//不同的工作台窗体代表的�??
   public final static int main = 1;
   public final static int child_1 = 2;
   public final static int child_2 = 3;
   //默认值为1，作为菜单的标示位，如当切换到child_2子系统是，flag的�?�则变为3�?
   public static int flag = 1;
   //eclipse提供的窗口句�?
   static public IWorkbenchWindow mainUI = null;
   static public IWorkbenchWindow child_1_UI = null;
   static public IWorkbenchWindow child_2_UI = null;
   //初始化主窗体
   static{
       mainUI = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
   }
}

