package com.crwu.rcp.training.view;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.CoolBarManager;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.internal.WorkbenchWindow;
import org.eclipse.ui.part.ViewPart;
import com.crwu.rcp.training.Activator;
/**
 * class  desc�?
 * @author WuChengRui  
 * @date 2018-8-2  
 */
public class Demo4ActionBarView extends ViewPart {
    public static final String ID = "com.crwu.rcp.training.view.Demo4ActionBarView";
    //总进�?
    public static final int allCount = 100;
    public int currentActionId = 0;
    @Override
    public void createPartControl(Composite parent) {
        //
        getViewSite().getActionBars().getStatusLineManager().getProgressMonitor().beginTask("给你看看", allCount);
        
        parent.setLayout(new FillLayout());
        Button btn = new Button(parent, SWT.PUSH);
        btn.setText("StatusLineManager\n--addWork");
        btn.addSelectionListener(new SelectionListener() {
            
            @Override
            public void widgetSelected(SelectionEvent e) {
                //点击�?下加10
                StatusLineManager sm = ((WorkbenchWindow)Activator.getActiveWorkbenchWindow()).getStatusLineManager();
//                sm.getControl().setVisible(!sm.getControl().isVisible());
//                System.out.println(sm.getControl().isVisible());
//                sm.update(true);
                ((WorkbenchWindow)Activator.getActiveWorkbenchWindow()).getStatusLineManager().getProgressMonitor().internalWorked(10);
//                ((WorkbenchWindow)Activator.getActiveWorkbenchWindow()).getStatusLineManager().
                sm.update(true);
            }
            
            @Override
            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });
        
        Button sysMenuBtn = new Button(parent, SWT.PUSH);
        sysMenuBtn.setText("system\n--MenuManager\n--show/hide");
        sysMenuBtn.addSelectionListener(new SelectionListener() {
            
            @Override
            public void widgetSelected(SelectionEvent e) {
                //获取的是系统顶级的菜�?
                IMenuManager menuManager = ((WorkbenchWindow)Activator.getActiveWorkbenchWindow()).getMenuBarManager();
                IContributionItem[] items = menuManager.getItems();
                for (IContributionItem iContributionItem : items) {
                    iContributionItem.setVisible(!iContributionItem.isVisible());
                }
                //点击�?下加10
//                menuManager.setVisible(menuManager.isVisible() );
                menuManager.update(true);
            }
            
            @Override
            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });
        
        Button viewMenuBtn = new Button(parent, SWT.PUSH);
        viewMenuBtn.setText("view\n--MenuManager\n--add/del");
        viewMenuBtn.addSelectionListener(new SelectionListener() {
            
            @Override
            public void widgetSelected(SelectionEvent e) {
               final IMenuManager menuManager = (getViewSite().getActionBars()).getMenuManager();
               currentActionId++;
                menuManager.add(new Action() {
                    int id = currentActionId;
                    @Override
                    public String getId() {
                        return "点我我就被删�?"+id;
                    }
                    @Override
                    public String getText() {
                        return getId();
                    }
                    @Override
                    public void run() {
                        super.run();
                        System.out.println(getId());
                        menuManager.remove(getId());
                        menuManager.update(true);
                    }
                    
                });
                menuManager.update(true);
            }
            
            @Override
            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });
        Button sysCoolBtn = new Button(parent, SWT.PUSH);
        sysCoolBtn.setText("system\n--CoolManager\n--show/hide");
        sysCoolBtn.addSelectionListener(new SelectionListener() {
            
            @Override
            public void widgetSelected(SelectionEvent e) {
                //获取的是系统顶级的CoolBarManager
                CoolBarManager cc = ((WorkbenchWindow)Activator.getActiveWorkbenchWindow()).getCoolBarManager();
                cc.getControl().setVisible(!cc.getControl().isVisible());
                cc.update(true);
            }
            
            @Override
            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });
        
    }
    @Override
    public void setFocus() {
        System.out.println(ID + "   --->   setFocus");
    }
    
    
}

