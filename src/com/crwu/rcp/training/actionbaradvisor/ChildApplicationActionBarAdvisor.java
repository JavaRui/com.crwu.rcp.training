package com.crwu.rcp.training.actionbaradvisor;
import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import com.crwu.rcp.training.WorkbenchControler;
import com.crwu.rcp.training.action.OpenWindowsAction;
public class ChildApplicationActionBarAdvisor extends ActionBarAdvisor {
    public ChildApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
        super(configurer);
    }
    /* (non-Javadoc)
     * 创建�? fill 方法中使用的 action , 这个方法用来通过 key binding 服务注册
     *  action并且添加到关闭窗口时要清除的 action列表中�?�IWorkbenchWindow的传入是为了可以在action�?
     *  也可以�?�过IWorkbenchWindow获取到框架的功能
     */
    protected void makeActions(IWorkbenchWindow window) {
    }
    /* (non-Javadoc)
     * 填充窗口的主菜单
     */
    protected void fillMenuBar(IMenuManager menuBar) {
        MenuManager openWindows = new MenuManager("&child",IWorkbenchActionConstants.M_EDIT);
        openWindows.add(new Separator());
        openWindows.add(new OpenWindowsAction(WorkbenchControler.main));
        openWindows.add(new Separator());
        openWindows.add(new OpenWindowsAction(WorkbenchControler.child_2));
        menuBar.add(openWindows);
    }
    
    /* (non-Javadoc)
     * 填充窗口的主工具�?
     */
    @Override
    protected void fillCoolBar(ICoolBarManager coolBar) {
        
        super.fillCoolBar(coolBar);
    }
    
    /* (non-Javadoc)
     * 填充窗口的主状�?�栏
     */
    @Override
    protected void fillStatusLine(IStatusLineManager statusLine) {
        
        super.fillStatusLine(statusLine);
    }
    
    
    
    
}

