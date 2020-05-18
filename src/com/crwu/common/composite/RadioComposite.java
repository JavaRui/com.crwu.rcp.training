package com.crwu.common.composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.crwu.common.UiUtil;
import com.crwu.common.callback.ShellBack;
/**
 * class  desc�??
 * @author WuChengRui  
 * @date 2018-8-1  
 */
public class RadioComposite extends Composite{
    private static final String CONTENT_OBJ = "contentObj";
    public RadioComposite(Composite parent, int style) {
        super(parent, style);
    }
    public Button addRadioBtn(String text , Object contentObj){
        return addRadioBtn(text , contentObj , 0);
    }
    /**
     * 新增radio按钮
     * @param text
     * @param contentObj
     * @param style
     * @return
     */
    public Button addRadioBtn(String text , Object contentObj , int style){
        Button radioBtn = new Button(this, SWT.RADIO|style);
        radioBtn.setText(text);
        radioBtn.setData(CONTENT_OBJ, contentObj);
        return radioBtn;
    }
    
    /**
     * 获取选择的radio里面的content_OBJ内容
     * @return
     */
    public Object getSelectRadioContent(){
        Control[] children = getChildren();
        for (Control control : children) {
            if(control instanceof Button){
                Button btn = (Button) control;
                if((btn.getStyle() & SWT.RADIO ) == 0){
                    continue;
                }
                if(btn.getSelection()){
                    return btn.getData(CONTENT_OBJ);
                }
                
            }
        }
        return null;
    }
    
    public static void main(String[] args) {
        UiUtil.createSwt(new ShellBack() {
            
            @Override
            public void callBack(Shell shell) {
                final RadioComposite radioComp = new RadioComposite(shell, 0);
                radioComp.setLayout(new GridLayout(5, false));
                radioComp.addRadioBtn("btn1", "111" , SWT.BORDER);
                radioComp.addRadioBtn("btn2", "222");
                radioComp.addRadioBtn("btn3", "333");
                Text t1 = new Text(radioComp, SWT.BORDER);
                Button addRadioBtn = radioComp.addRadioBtn("btn4", "444");
                
                Button simpleBtn = new Button(radioComp, SWT.PUSH);
                simpleBtn.setText("点击输出");
                simpleBtn.addSelectionListener(new SelectionListener() {
                    
                    @Override
                    public void widgetSelected(SelectionEvent e) {
                        Object selectRadioContent = radioComp.getSelectRadioContent();
                        System.out.println(selectRadioContent);
                    }
                    
                    @Override
                    public void widgetDefaultSelected(SelectionEvent e) {
                    }
                });
                
                
            }
        });
    }
    
    
    
}

