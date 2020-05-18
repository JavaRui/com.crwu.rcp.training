package com.crwu.training.jface;
/**
 * class  desc�?
 * @author WuChengRui  
 * @date 2018-6-7  
 */
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.crwu.utils.RandomUtil;
  
public class JfaceStart extends ApplicationWindow{  
      
    private static JfaceStart app;
    private IProgressMonitor progressMonitor;
    private JfaceStart(){  
        super(null);  
        app = this;  
          
        this.addMenuBar();  
        this.addToolBar(SWT.FLAT);  
        this.addStatusLine();  
    }  
      
    public static JfaceStart getApp(){  
        return app;  
    }  
    
    /* (non-Javadoc)
     * @see org.eclipse.jface.window.Window#getShellStyle()
     */
    @Override
    protected int getShellStyle() {
        
        return SWT.MIN;
    }
      
    protected void configureShell(Shell shell){  
        super.configureShell(shell);  
        shell.setText("�?单写字板");  
        shell.setSize(500, 300);
        
//        shell.setMaximized(true);  
    }  
      
    protected Control createContents(Composite parent){
        progressMonitor = getApp().getStatusLineManager().getProgressMonitor();
        progressMonitor.beginTask("", 100);
        Button btn = new Button(parent,SWT.PUSH  );
        btn.addSelectionListener(new SelectionListener( ) {
            
            @Override
            public void widgetSelected(SelectionEvent e) {
//                progressMonitor.internalWorked(10);
                getApp().getStatusLineManager().setMessage(RandomUtil.getInst().getEnFixed(7));
                progressMonitor.internalWorked(20);
                
                getApp().getStatusLineManager().getControl().setVisible(false);
            }
            
            @Override
            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });
        return parent;  
    }  
      
    protected MenuManager createMenuManager(){  
        MenuManager menuBar = new MenuManager();  
          
        MenuManager fileMenu = new MenuManager("文件(&F)");  
        fileMenu.add(new Action("点我�?") {
            /* (non-Javadoc)
             * @see org.eclipse.jface.action.Action#run()
             */
            @Override
            public void run() {
                getApp().getStatusLineManager().setMessage("当前打开的文件是: ");
                System.out.println("被点击了");
                super.run();
            }
        });
//        MenuManager editMenu = new MenuManager("编辑(&E)");  
//        MenuManager formatMenu = new MenuManager("格式(&F)");  
//        MenuManager helpMenu = new MenuManager("帮助(&H)");  
          
        menuBar.add(fileMenu);  
//        menuBar.add(editMenu);  
//        menuBar.add(formatMenu);  
//        menuBar.add(helpMenu);  
          
        fileMenu.add(new Separator());  
        fileMenu.add(new Separator());  
        
          
        return menuBar;  
    }  
      
    public static void main(String[] args){  
        JfaceStart main = new JfaceStart();  
        main.setBlockOnOpen(true);  
        main.open();  
        Display.getCurrent().dispose();  
    }  
      
    
    /* (non-Javadoc)
     * @see org.eclipse.jface.window.ApplicationWindow#createStatusLineManager()
     */
    @Override
    protected StatusLineManager createStatusLineManager() {
        
        StatusLineManager statusLineManager = new StatusLineManager();
        Control createControl = statusLineManager.createControl(getShell());
//        final Composite composite = new Composite(statusComposite, SWT.LEFT_TO_RIGHT);  
//        GridLayout gl = new GridLayout(1, false);  
//        gl.marginHeight = 1;  
//        composite.setLayout(gl);  
//          
//        CLabel label = new CLabel(composite, SWT.NONE);  
//        label.setText("当前登录用户...");  
        return statusLineManager;  
    }
    
}  

