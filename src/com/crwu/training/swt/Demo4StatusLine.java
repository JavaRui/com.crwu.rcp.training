package com.crwu.training.swt;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.internal.layout.LayoutUtil;
import com.crwu.common.LayoutDataUtils;
import com.crwu.utils.ShellBack;
import com.crwu.utils.UiUtils;
/**
 * class desc�?
 * 
 * @author WuChengRui
 * @date 2018-8-15
 */
public class Demo4StatusLine extends Composite{
    private Label messageText ;
    private ProgressBar progressBar;
    
    
    /**
     * @param shell
     * @param i
     */
    public Demo4StatusLine(Composite shell, int i) {
        super(shell, i);
        setLayout(new GridLayout(3,false));
        initStatusLine();
    }
    /**
     * 
     */
    private void initStatusLine() {
        
        messageText = new Label(this, 0);
        messageText.setLayoutData(new GridData(200, 20));
        
        Label tempLabel = new Label(this, 0);
        tempLabel.setLayoutData(LayoutDataUtils.createFillGridNoVer(1));
        
        progressBar = new ProgressBar(this, SWT.SMOOTH);
        progressBar.setLayoutData(new GridData(200, 20));
        progressBar.setMinimum(0); // �?小�??
        
    }
    
    public void setMessage(String string){
        messageText.setText(string);
    }
    
    public void beginWork(String workName , int max){
        messageText.setText(workName);
        progressBar.setMaximum(max);// �?大�??
    }
    
    public void internalWorked(){
        progressBar.setSelection(progressBar.getSelection()+1);
    }
    
    public void internalWorked(int c){
        progressBar.setSelection(progressBar.getSelection()+c);
    }
    
    public void setProgress(int c){
        progressBar.setSelection(c);
    }
    
    public int getProgress(){
        return progressBar.getSelection();
    }
    
    public static void main(String[] args) {
        UiUtils.createSwt(new ShellBack() {
            private Demo4StatusLine demo4StatusLine;
            @Override
            public void callBack(Shell shell) {
                shell.setLayout(new GridLayout());
                
                Composite contentComp = new Composite(shell, SWT.BORDER);
                contentComp.setLayoutData(LayoutDataUtils.createFillGrid(1));
                contentComp.setLayout(new GridLayout(2, true));
                Button btn = new Button(contentComp, SWT.PUSH);
                btn.setText("click");
                btn.addSelectionListener(new SelectionListener() {
                    
                    @Override
                    public void widgetSelected(SelectionEvent e) {
                        demo4StatusLine.setMessage("当前任务:   ");
                        demo4StatusLine.internalWorked();
                    }
                    
                    @Override
                    public void widgetDefaultSelected(SelectionEvent e) {
                    }
                });
                
                demo4StatusLine = new Demo4StatusLine(shell, 0);
                demo4StatusLine.setLayoutData(LayoutDataUtils.createFillGridNoVer(1));
            }
        });
    }
}

