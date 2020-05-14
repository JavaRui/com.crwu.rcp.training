package com.crwu.rcp.training.perspective;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import com.crwu.rcp.training.view.Demo4ListenerView;
import com.crwu.rcp.training.view.SelectionProviderTestView;
public class Perspective implements IPerspectiveFactory {
	public static final String PERSPECTIVE_ID = "com.crwu.rcp.training.perspective"; //$NON-NLS-1$
    public void createInitialLayout(IPageLayout layout) {
	    String editorArea = layout.getEditorArea();
	    layout.setEditorAreaVisible(false);
	    layout.addView(SelectionProviderTestView.ID, IPageLayout.LEFT  , 0.5f, editorArea);
	    layout.addView(Demo4ListenerView.ID, IPageLayout.LEFT  , 0.5f, editorArea);
	    //新增透视图下拉效果，如果不添加，只能在Other面板显示
	    layout.addPerspectiveShortcut(PerspectiveFolder.ID);
	    layout.addPerspectiveShortcut(Perspective.PERSPECTIVE_ID);
	}
}

