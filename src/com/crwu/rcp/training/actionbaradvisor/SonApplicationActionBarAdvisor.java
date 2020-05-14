package com.crwu.rcp.training.actionbaradvisor;
import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
public class SonApplicationActionBarAdvisor extends ActionBarAdvisor {
    public SonApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
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

