package com.crwu.rcp.training;
import org.eclipse.ui.application.IWorkbenchConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

import com.crwu.rcp.training.perspective.Perspective;
import com.crwu.rcp.training.perspective.PerspectiveUtils;
public class ApplicationWorkbenchAdvisor extends WorkbenchAdvisor {
	public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
        return new ApplicationWorkbenchWindowAdvisor(configurer);
    }
    
    /* (non-Javadoc)
     * @see org.eclipse.ui.application.WorkbenchAdvisor#initialize(org.eclipse.ui.application.IWorkbenchConfigurer)
     */
    @Override
    public void initialize(IWorkbenchConfigurer configurer) {
        super.initialize(configurer);
        PerspectiveUtils.setPositionTopRight();
        PerspectiveUtils.setShowText(false);
    }

	/** 
	 * 默认透视图
	 */
	public String getInitialWindowPerspectiveId() {
		return Perspective.PERSPECTIVE_ID;
	}
	
	/** (non-Javadoc)
	 * 在初始化完成之后, 打开第一个窗口之前调用, 在这里可以对打开编辑器和视图的初始化参数进行设置。
	 */
	@Override
	public void preStartup() {
	    
	    super.preStartup();
	}
	
	/** (non-Javadoc)
	 * 在所有窗口打开或恢复以后开始事件循环之前调用。 在这里可以进行一些类似自动批处理的工作。
	 */
	@Override
	public void postStartup() {
	    
	    super.postStartup();
	}
	
	/** 
	 * 在事件循环结束以后, 关闭任何一个窗口之前调用
	 */
	@Override
	public boolean preShutdown() {
	    
	    return super.preShutdown();
	}
	
	/** 
	 * 在所有窗口关闭之后, 关闭工作台 ( Workbench ) 之前调用, 可以用来保存当前应用的状态, 清理 initialize 方法创建的内容
	 */
	@Override
	public void postShutdown() {
	    
	    super.postShutdown();
	}
}

