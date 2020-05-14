package com.crwu.rcp.training.view;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IPageListener;
import org.eclipse.ui.IPageService;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IPerspectiveListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.internal.WorkbenchWindow;
import org.eclipse.ui.part.ViewPart;
/**
 * class  desc�?
 * @author WuChengRui  
 * @date 2018-8-2  
 */
public class Demo4ListenerView extends ViewPart implements IPartListener{
    public static final String ID = "com.crwu.rcp.training.view.Demo4ListenerView";
    @Override
    public void createPartControl(Composite parent) {
        
        parent.setLayout(new FillLayout());
        Button btn = new Button(parent, SWT.PUSH);
        btn.setText("Demo4ListenerView");
        
        IPageService service = (IPageService) getSite().getService(IPageService.class);
        service.addPerspectiveListener(new IPerspectiveListener() {
            
            @Override
            public void perspectiveChanged(IWorkbenchPage page, IPerspectiveDescriptor perspective, String changeId) {
                //�?----其他----透视图（是其他的透视图来通知你）的页面内容改变的时�?�会触发，比如view被关闭或者打�?的时候会触发
                //当内容发生改变的时�?�，并不只是改变当前的�?�视图，同时系统会自动保存一份到workspace中，
                //当再次打�?的时候，透视图布�?会被复原
                System.out.println( perspective.getLabel() + "    透视图内容发生变�?-----------perspectiveChanged");
            }
            
            @Override
            public void perspectiveActivated(IWorkbenchPage page, IPerspectiveDescriptor perspective) {
                System.out.println( perspective.getLabel() + "   透视图活动？�?-----------perspectiveActivated");
            }
        });
        
        service.addPageListener(new IPageListener() {
            
            @Override
            public void pageOpened(IWorkbenchPage page) {
                System.out.println( page.getPerspective().getDescription() + " 对应的page-----------打开�?");
            }
            
            @Override
            public void pageClosed(IWorkbenchPage page) {
                System.out.println( page.getPerspective().getDescription() + " 对应的page-----------关闭�?");
            }
            
            @Override
            public void pageActivated(IWorkbenchPage page) {
                System.out.println( page.getPerspective().getDescription() + " 对应的page-----------活动�?");
            }
        });
        
    }
    @Override
    public void setFocus() {
        System.out.println(ID + "setFocus");
    }
    @Override
    public void partActivated(IWorkbenchPart part) {
        System.out.println("直接implements IpartListener 触发的："+ID + "partActivated");
    }
    @Override
    public void partBroughtToTop(IWorkbenchPart part) {
        System.out.println("直接implements IpartListener 触发的："+ID + "partBroughtToTop");
    }
    @Override
    public void partClosed(IWorkbenchPart part) {
        System.out.println("直接implements IpartListener 触发的："+ID + "partClosed");
    }
    @Override
    public void partDeactivated(IWorkbenchPart part) {
        System.out.println("直接implements IpartListener 触发的："+ID + "partDeactivated");
    }
    @Override
    public void partOpened(IWorkbenchPart part) {
        System.out.println("直接implements IpartListener 触发的："+ID + "partOpened");
    }
    
    
}

