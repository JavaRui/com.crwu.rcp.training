package com.crwu.rcp.training.perspective;
import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import com.crwu.rcp.training.view.Demo4ActionBarView;
import com.crwu.rcp.training.view.Demo4ListenerView;
import com.crwu.rcp.training.view.SelectionProviderTestView;
/**
 * class  folder布局的�?�视�?
 * @author WuChengRui  
 * @date 2018-8-2  
 */
public class PerspectiveFolder implements IPerspectiveFactory {
    public static final String ID = "com.crwu.rcp.training.PerspectiveFolder";
    /**
     * 如果�?要出现�?�视图开关，�?要去修改 ApplicationWorkbenchWindowAdvisor.preWindowOpen-->
     * 添加透视图设置configurer.setShowPerspectiveBar(true);
     */
    public void createInitialLayout(IPageLayout layout) {
        String editorArea = layout.getEditorArea();
        layout.setEditorAreaVisible(false);
        //新增文件夹布�?
        IFolderLayout createFolder = layout.createFolder("temp", IPageLayout.LEFT, 1, editorArea);
        createFolder.addView(SelectionProviderTestView.ID);
        createFolder.addView(Demo4ListenerView.ID);
        createFolder.addView(Demo4ActionBarView.ID);
        
    }
}

