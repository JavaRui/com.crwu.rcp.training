package com.crwu.training.swt;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseWheelListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import com.utils.ShellBack;
import com.utils.UiUtils;
/**
 * class  desc�?
 * @author WuChengRui  
 * @date 2018-6-26  
 */
public class Demo4ScrolledComposite extends Composite{
    
    public Demo4ScrolledComposite(Composite parent, int style) {
        super(parent, style);
        init();
    }
    private void init() {
        setLayout(new FillLayout());
        
        ScrolledComposite scComp = new ScrolledComposite(this, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
        scComp.setLayout(new FillLayout()); 
//        scComp.getVerticalBar().setIncrement(30);
        scComp.addMouseWheelListener(new MouseWheelListener() {
            
            @Override
            public void mouseScrolled(MouseEvent e) {
                e.count = e.count*30;
                System.out.println(e.count);
            }
        });
        
        Composite searchComp = new Composite(scComp, 0);
        searchComp.setLayout(new GridLayout());
        
        
        
        for (int i = 0; i < 200; i++) {
            Button button = new Button(searchComp,SWT.PUSH);
            button.setText("btn:  "+i);
        }
        //重要，一个ScrolledComposite只能设置�?个content
        scComp.setContent(searchComp);
        //重要，设置这个composite的真实尺�?
        searchComp.setSize(searchComp.computeSize(SWT.DEFAULT, SWT.DEFAULT));
        searchComp.layout();
        
    }
    public static void main(String[] args) {
        
        UiUtils.createSwt(new ShellBack() {
            
            @Override
            public void callBack(Shell shell) {
                new Demo4ScrolledComposite(shell, 0);
            }
        });
        
    }
    
}

