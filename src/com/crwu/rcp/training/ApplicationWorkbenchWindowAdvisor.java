package com.crwu.rcp.training;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;
import com.crwu.rcp.training.actionbaradvisor.WorkbenchActionBuilder;
public class ApplicationWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {
    WorkbenchActionBuilder builder = null;
	public ApplicationWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
		super(configurer);
	}
    public ActionBarAdvisor createActionBarAdvisor(IActionBarConfigurer configurer) {
        if(builder == null){
            builder = new WorkbenchActionBuilder(configurer);
        }
        return builder.makeWinAction();
    }
    
    /* (non-Javadoc)
     * �? WorkBench Window 的构造函数中调用, 用于设置窗口的一些特�?, 
     * �? 是否显示状�?�栏�? 但是这个时�?�还没有创建任何窗体控件, �?以在这里还不能引用它们�??
     */
    public void preWindowOpen() {
       
        IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
        configurer.setInitialSize(new Point(400, 300));
        configurer.setShowCoolBar(true);
        configurer.setShowStatusLine(true);
        configurer.setTitle("Hello RCP"); //$NON-NLS-1$
        //显示透视图开�?
        configurer.setShowPerspectiveBar(true);
        
    }
    @Override
    protected IWorkbenchWindowConfigurer getWindowConfigurer() {
        
        return super.getWindowConfigurer();
    }
    /* (non-Javadoc)
     * 在窗口恢复到以前保存的状态之�?, 打开窗口之前调用这个方法在新建窗�?, Workbench第一次运�?, 
     * 以及没有保存窗口状�?�的情况下都不会调用�? 在这里可以调用IWorkbench.close() 
     * 方法关闭Workbench 和所有打�?的Workbench Window�?
     */
    @Override
    public void postWindowRestore() throws WorkbenchException {
        
        super.postWindowRestore();
    }
    @Override
    protected void cleanUpEditorArea() {
        
        super.cleanUpEditorArea();
    }
    /* (non-Javadoc)
     * Intro就是你第�?次打�?Eclispe的时候看到的内容, 这个方法的默认的实现�?:
     *  如果IWorkbenchPreferences.SHOW_INTRO 属�?�被设置为True, 那么在第�?次打�?窗口的时候将会调用这个方�?,
     *在Intro显示过之后该属�?�将会设置为False。后�?, 只有在WorkbenchConfigurer.getSaveAndRestore() 方法返回True,
     *并且关闭窗口时intro仍然显示的时候才会调用这个方法�??
     */
    @Override
    public void openIntro() {
        
        super.openIntro();
    }
    /* (non-Javadoc)
     * 在窗口创建以�?, 打开以前调用�? 或�?�是窗口恢复到以前保存的状�?�后, 在执行postWindowRestore 方法之后调用
     */
    @Override
    public void postWindowCreate() {
        
        super.postWindowCreate();
    }
    /* (non-Javadoc)
     * �? Workbench 窗口打开之后调用, 可以在这里开/�?(Tweak)窗体控件, 例如设置Title, 改变窗口尺寸等等�?
     */
    @Override
    public void postWindowOpen() {
        
        super.postWindowOpen();
    }
    @Override
    public boolean preWindowShellClose() {
        
        return super.preWindowShellClose();
    }
    /* (non-Javadoc)
     * 在Workbench窗口关闭之后调用, 这个时�?�窗口中的控件都已经被清除了�? 
     * 在这里可以清除由postWindowOpen 方法创建的内容�??
     */
    @Override
    public void postWindowClose() {
        
        super.postWindowClose();
    }
    /* (non-Javadoc)
     * 这个方法用来创建�?个窗口的内容,默认的实现添加了�?个菜单栏, �?个工具条, �?个状态栏,�?个�?�视图栏, 和一个快速视图栏�?
     *  这些控件的可见�?�可以使�? IWorkbenchWindowConfigurer 中的 setShow* 方法进行设置�?
     *  可以通过在子类中覆写( override ) 这个方法来实现自定义的窗口内容和布局, 
     *  但是必须要调用IWorkbenchWindowConfigurer.createPageComposite方法。这个方法只有一个参�?: Shell
     */
    @Override
    public void createWindowContents(Shell shell) {
        
        super.createWindowContents(shell);
    }
    /* (non-Javadoc)
     * 创建并且返回在窗口没有页面显示的时�?�要显示的控件�?�如果返回的是Null, 则会使用默认的窗口背景�?? 覆写这个方法可以实现自定义的窗口背景�?
     *  默认的实现是返回 Null 。这个方法只有一个参�?: Composite
     */
    @Override
    public Control createEmptyWindowContents(Composite parent) {
        
        return super.createEmptyWindowContents(parent);
    }
}

