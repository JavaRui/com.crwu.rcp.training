package com.crwu.training.jface.wizard;
import org.eclipse.jface.dialogs.DialogSettings;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IPageChangedListener;
import org.eclipse.jface.dialogs.PageChangedEvent;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import com.crwu.common.LayoutDataUtil;
  
  
public class Demo4Wizard extends ApplicationWindow{  
    public Demo4Wizard(){  
        super(null);  
    }  
      
    
    protected Control createContents(Composite parent){  
        
        //打开帮助按钮
        TrayDialog.setDialogHelpAvailable(true);
        
        parent.setLayout(new RowLayout(SWT.VERTICAL));  
        Button button  = new Button(parent, SWT.NONE);  
        button.setText("打开�?单向导对话框");  
        button.addSelectionListener(new SelectionAdapter(){  
            public void widgetSelected(SelectionEvent e){  
                DialogSettings setting = new DialogSettings("");
                //建立并打�?打开向导对话框，该对话框使用�? BookSurveyWizard 向导  
                BookSurveyWizard bookSurveyWizard = new BookSurveyWizard();
                bookSurveyWizard.setDialogSettings(setting);
                WizardDialog dlg = new SimpleWizardDialog(Display.getCurrent().getActiveShell(),  
                        bookSurveyWizard );  
                dlg.open();  
            }  
        });  
        return parent;  
    }  
      
    public static void main(String[] args){  
        Demo4Wizard test = new Demo4Wizard();  
        test.setBlockOnOpen(true);  
        test.open();  
        Display.getCurrent().dispose();  
    }  
} 

