package com.crwu.training.jface.wizard;
/**
 * class  desc�?
 * @author WuChengRui  
 * @date 2018-6-22  
 */
import org.eclipse.jface.resource.ImageDescriptor;  
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.WizardPage;  
import org.eclipse.swt.SWT;  
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;  
import org.eclipse.swt.widgets.Button;  
import org.eclipse.swt.widgets.Composite;  
import org.eclipse.swt.widgets.Label;  
  
  
public class QuestionOne extends WizardPage{  
   
    public QuestionOne(){  
        super(BookSurveyWizard.Q1, "问题1�?", ImageDescriptor.createFromFile(QuestionOne.class, "q.gif"));  
        this.setMessage("您认为这本书的难度是:");  
    }  
      
    public void createControl(Composite parent){  
        Composite composite = new Composite(parent, SWT.NONE);  
        composite.setLayout(new GridLayout(2,false));
        
        new Label(composite, SWT.LEFT).setText("A.");  
        Button b1 =  createBtn(composite ,BookSurveyWizard.SIMPLE);  
        b1.setSelection(true);  
        
        getWizard().getDialogSettings().put(BookSurveyWizard.SELECT_BTN, BookSurveyWizard.SIMPLE);
        
        new Label(composite, SWT.LEFT).setText("B.");  
        Button b2 = createBtn(composite ,BookSurveyWizard.NORMAL);  
        
        new Label(composite, SWT.LEFT).setText("C.");  
        Button b3 = createBtn(composite , BookSurveyWizard.HARD);  
        
        setControl(composite);  
       
    }  
    
    private Button createBtn(Composite composite,String text){
        Button b2 = new Button(composite, SWT.RADIO);  
        b2.setText(text);  
        b2.addSelectionListener(new SelectionListener() {
            
            @Override
            public void widgetSelected(SelectionEvent e) {
                String text = ((Button)e.widget).getText();
                System.out.println(text);
                //将�?�择的�?�，存入到设置中
                getWizard().getDialogSettings().put(BookSurveyWizard.SELECT_BTN, text);
            }
            
            @Override
            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });
        return b2;
    }
    
    
    
}  

