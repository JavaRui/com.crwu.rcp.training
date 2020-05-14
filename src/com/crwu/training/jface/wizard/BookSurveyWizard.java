package com.crwu.training.jface.wizard;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
/**
 * class  desc�?
 * @author WuChengRui  
 * @date 2018-6-22  
 */
public class BookSurveyWizard extends Wizard{  
    
    /**
     * 
     */
    public static final String HARD = "太难";
    /**
     * 
     */
    public static final String NORMAL = "还可�?";
    /**
     * 
     */
    public static final String SIMPLE = "太简�?";
    /**
     * 
     */
    public static final String SELECT_BTN = "select_btn";
    
    public static final String Q1 = "QUESTION_1";  
    public static final String Q2 = "QUESTION_2";  
    public static final String THANKS = "THANKS";  
      
    private QuestionOne one;  
    private QuestionTwo two;  
    private Thanks thanks;  
    public BookSurveyWizard(){  
        one = new QuestionOne();  
        two = new QuestionTwo();  
        thanks = new Thanks();  
          
        this.addPage(one);  
        this.addPage(two);  
        this.addPage(thanks);  
        this.setWindowTitle("读�?�调查向�?");  
    }  
    
    /* (non-Javadoc)
     * @see org.eclipse.jface.wizard.Wizard#getNextPage(org.eclipse.jface.wizard.IWizardPage)
     */
    @Override
    public IWizardPage getNextPage(IWizardPage page) {
        String string = getDialogSettings().get(SELECT_BTN);
        System.out.println("选择�?:  "+string);
      //  setHelpAvailable(false);
        if(SIMPLE.equals(string)){
            //好了，你可以毕业了，直接跳转到最后的界面
            System.out.println("好了，你可以毕业了，直接跳转到最后的界面");
//            setHelpAvailable(false);
            return thanks;
        }
        System.out.println("继续走下�?�?");
        
        return super.getNextPage(page);
    }
      
    public boolean canFinish(){  
        if(this.getContainer().getCurrentPage() == thanks)  
            return true;  
        else  
            return false;  
    }  
      
    public boolean performFinish(){  
        return true;  
    }  
}

