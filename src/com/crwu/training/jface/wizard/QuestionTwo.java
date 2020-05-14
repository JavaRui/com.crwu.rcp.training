package com.crwu.training.jface.wizard;
/**
 * class  desc�?
 * @author WuChengRui  
 * @date 2018-6-22  
 */
import org.eclipse.jface.resource.ImageDescriptor;  
import org.eclipse.jface.wizard.WizardPage;  
import org.eclipse.swt.SWT;  
import org.eclipse.swt.layout.GridLayout;  
import org.eclipse.swt.widgets.Button;  
import org.eclipse.swt.widgets.Composite;  
import org.eclipse.swt.widgets.Label;  
  
  
public class QuestionTwo extends WizardPage{  
    public QuestionTwo(){  
        super(BookSurveyWizard.Q2, "问题2", ImageDescriptor.createFromFile(QuestionOne.class, "q.gif"));  
        this.setMessage("您会考虑在今后的项目中使用SWT�?发桌面程序吗:");  
    }  
      
    public void createControl(Composite parent){  
        Composite composite = new Composite(parent, SWT.NONE);  
        composite.setLayout(new GridLayout(2, false));  
        new Label(composite, SWT.LEFT).setText("A.");  
        Button b1 = new Button(composite, SWT.RADIO);  
        b1.setText("�?");  
        b1.setSelection(true);  
        new Label(composite, SWT.LEFT).setText("B.");  
        Button b2 = new Button(composite, SWT.RADIO);  
        b2.setText("可能�?");  
        new Label(composite, SWT.LEFT).setText("C.");  
        Button b3 = new Button(composite, SWT.RADIO);  
        b3.setText("不会");  
        setControl(composite);  
    }  
} 

