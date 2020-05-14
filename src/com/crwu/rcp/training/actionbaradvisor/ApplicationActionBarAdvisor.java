package com.crwu.rcp.training.actionbaradvisor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import com.crwu.rcp.training.WorkbenchControler;
import com.crwu.rcp.training.action.OpenWindowsAction;
public class ApplicationActionBarAdvisor extends ActionBarAdvisor {
    public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
        super(configurer);
    }
    /*
     * (non-Javadoc) 创建�?? fill 方法中使用的 action , 这个方法用来通过 key binding 服务注册
     * action并且添加到关闭窗口时要清除的 action列表中�?�IWorkbenchWindow的传入是为了可以在action�??
     * 也可以�?�过IWorkbenchWindow获取到框架的功能
     */
    protected void makeActions(IWorkbenchWindow window) {
    }
    /*
     * (non-Javadoc) 填充窗口的主菜单
     */
    protected void fillMenuBar(IMenuManager menuBar) {
        menuBar.add(createOpenWindowsMenu());
    }
    /*
     * (non-Javadoc) 填充窗口的主工具�??
     */
    @Override
    protected void fillCoolBar(ICoolBarManager coolBar) {
        IToolBarManager barManager = new ToolBarManager(coolBar.getStyle());
        IWorkbenchAction create = ActionFactory.ABOUT.create(getActionBarConfigurer().getWindowConfigurer().getWindow());
        create.setDescription("hello !! this is crwu's training");
        
        register(create);
        barManager.add(create);
        
        IWorkbenchAction create2 = ActionFactory.BACK.create(getActionBarConfigurer().getWindowConfigurer().getWindow());
        register(create2);
        barManager.add(create2);
        
        IWorkbenchAction create3 = ActionFactory.HELP_SEARCH.create(getActionBarConfigurer().getWindowConfigurer().getWindow());
        register(create3);
        barManager.add(create3);
        
        coolBar.add(barManager);
        
    }
    
    
    /*
     * (non-Javadoc) 填充窗口的主状�?�栏
     */
    @Override
    protected void fillStatusLine(IStatusLineManager statusLine) {
        super.fillStatusLine(statusLine);
    }
    // 创建切换到子窗体菜单
    private MenuManager createOpenWindowsMenu() {
        MenuManager openWindows = new MenuManager("&Change",IWorkbenchActionConstants.M_EDIT);
        openWindows.add(new Separator());
        openWindows.add(new OpenWindowsAction(WorkbenchControler.child_1));
        openWindows.add(new Separator());
        openWindows.add(new OpenWindowsAction(WorkbenchControler.child_2));
        return openWindows;
    }
}

