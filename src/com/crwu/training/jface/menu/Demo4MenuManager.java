package com.crwu.training.jface.menu;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Decorations;
import org.eclipse.swt.widgets.Shell;
import com.crwu.common.img.ImageFoctory;
import com.crwu.common.img.ImgMgr;
import com.utils.ShellBack;
import com.utils.UiUtils;
/**
 * class desc�?
 * 
 * @author WuChengRui
 * @date 2018-6-12
 */
public class Demo4MenuManager {
    
    // 每个MenuManager都可以独立运作，同时又可以组合在�?起，成为树状结构
    // menuManager实现了可以成为叶子的IAction接口�?
    //同时又为自己添加了发展为枝的接口add(IAction)
    // 这种可以组合成不同的层级关系的设计模式，叫组合模�?
    
    
    public Demo4MenuManager(Shell shell) {
        MenuManager createMenuManager = createMenuManager();
        //右键菜单
        shell.setMenu(createMenuManager.createContextMenu(shell));
        //顶部菜单
//        shell.setMenuBar(createMenuManager.createMenuBar((Decorations) shell));
        createMenuManager.updateAll(true);
    }
    protected MenuManager createMenuManager() {
        
       
        //新建�?节点
        MenuManager menuBar = new MenuManager();
        //新建�?个fileMenu节点�?
        MenuManager fileMenu = new MenuManager("文件(&F)");
        //新建�?个可勾�?�的item节点
        Action openAction = new Action("可勾选的item(&F)") {
        	
            @Override
            public void run() {
                System.out.println("打开被点击了");
                super.run();
            }
            //设置可勾�?
            @Override
            public int getStyle() {
            	// TODO Auto-generated method stub
            	//IAction中还有很多种样式可以设置�?
            	return IAction.AS_CHECK_BOX;
            }
            
        };
        menuBar.add(openAction);
        
        MenuManager fileMenu2 = new MenuManager("文件2(&F)");
       
        
      //新建�?个openAction节点
        Action openAction2 = new Action("打开2") {
            @Override
            public void run() {
                System.out.println("打开被点击了2");
                super.run();
            }
            @Override
            public int getStyle() {
            	// TODO Auto-generated method stub
            	//IAction中还有很多种样式可以设置�?
            	return IAction.AS_RADIO_BUTTON;
            }
        };
        fileMenu2.add(openAction2);
        //确定层级关系，Menu为最高层的树
        //fileMenu为一个枝节点，因为它有上级同时也有下�?
        //openAction 为叶子节点，因为是最顶层的节�?
        fileMenu.add(openAction);
        menuBar.add(fileMenu);
        fileMenu.add(fileMenu2);
        
        MenuManager exMenu = new MenuManager("扩展(&F)");
        exMenu.add(new Action("这是扩展") {
            @Override
            public void run() {
                System.out.println("扩展被点击了");
                super.run();
            }
        });
        menuBar.add(exMenu);
        
        IContributionItem[] items = menuBar.getItems();
        for (IContributionItem iContributionItem : items) {
        	//
        	if(iContributionItem instanceof MenuManager) {
        		MenuManager item = ((MenuManager)iContributionItem);
        	}
		}
        
        return menuBar;
    }
    
    private void addFlag2Action() {
    	
    }
    
    public static void main(String[] args) {
        UiUtils.createSwt(new ShellBack() {
            @Override
            public void callBack(Shell shell) {
               new Demo4MenuManager(shell);
            }
        });
    }
}

