package com.crwu.training.jface;
/**
 * class  desc�?
 * @author WuChengRui  
 * @date 2018-8-14  
 */
//MainWindow.java
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import com.crwu.rcp.training.action.NewAction;
import com.crwu.rcp.training.action.OpenAction;
public class MainWindow extends ApplicationWindow{
  private NewAction newAction;
  private OpenAction openAction;
  private FileManager manager;
  private Text content;
  private static MainWindow app;
  
  private MainWindow(){
      super(null);
      app = this;
      manager = new FileManager();
      newAction = new NewAction();
      openAction = new OpenAction();
      
      this.addMenuBar();
      this.addToolBar(SWT.FLAT);
      this.addStatusLine();
  }
  
  public static MainWindow getApp(){
      return app;
  }
  
  protected void configureShell(Shell shell){
      super.configureShell(shell);
      shell.setText("�?单写字板");
      shell.setMaximized(true);
  }
  
  protected Control createContents(Composite parent){
      content = new Text(parent, SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL);
      content.addModifyListener(new ModifyListener(){
          public void modifyText(ModifyEvent e){
              manager.setDirty(true);
          }
      });
      return parent;
  }
  
  protected MenuManager createMenuManager(){
      MenuManager menuBar = new MenuManager();
      
      MenuManager fileMenu = new MenuManager("文件(&F)");
      MenuManager editMenu = new MenuManager("编辑(&E)");
      MenuManager formatMenu = new MenuManager("格式(&F)");
      MenuManager helpMenu = new MenuManager("帮助(&H)");
      
      menuBar.add(fileMenu);
      menuBar.add(editMenu);
      menuBar.add(formatMenu);
      menuBar.add(helpMenu);
      
      fileMenu.add(newAction);
      fileMenu.add(openAction);
      return menuBar;
  }
  
  public static void main(String[] args){
      MainWindow main = new MainWindow();
      main.setBlockOnOpen(true);
      main.open();
      Display.getCurrent().dispose();
  }
  
  public Text getContent(){
      return content;
  }
  public FileManager getManager(){
      return manager;
  }
  public void setManager(FileManager manager){
      this.manager = manager;
  }
  
  public StatusLineManager getStatusLineManager(){
      StatusLineManager statusLineManager = new StatusLineManager();
      return statusLineManager;
  }
}

