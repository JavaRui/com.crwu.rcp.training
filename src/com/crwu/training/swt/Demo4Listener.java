package com.crwu.training.swt;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import com.utils.ShellBack;
import com.utils.UiUtils;
/**
 * class desc�?
 * 
 * @author ruien.wu
 * @date 2018-6-6
 */
public class Demo4Listener {
    public static void main(String[] args) {
        UiUtils.createSwt(new ShellBack() {
            @Override
            public void callBack(Shell shell) {
                GridLayout gl = new GridLayout(2, true);
                shell.setLayout(gl);
                Button btn1 = new Button(shell, SWT.PUSH);
                btn1.setText("btn1");
                btn1.addSelectionListener(new SelectionListener() {
                    //鼠标选择事件
                    @Override
                    public void widgetSelected(SelectionEvent arg0) {
                        System.out.println(Display.getDefault().getBounds());
                        System.out.println(Display.getDefault().getClientArea());
                        Display.getDefault().getFocusControl();
                        System.out.println("click me");
                    }
                    @Override
                    public void widgetDefaultSelected(SelectionEvent arg0) {
                    }
                });
                //鼠标移入，移动，移出事件
                Button btn2 = new Button(shell, SWT.PUSH);
                btn2.setText("btn2");
                btn2.addMouseTrackListener(new MouseTrackListener() {
                    // 进入了控件之后，鼠标在内部的移动
                    @Override
                    public void mouseHover(MouseEvent arg0) {
                        System.out.println("over");
                    }
                    // 鼠标移出控件
                    @Override
                    public void mouseExit(MouseEvent arg0) {
                        System.out.println("exit");
                    }
                    // 鼠标进入控件
                    @Override
                    public void mouseEnter(MouseEvent arg0) {
                        System.out.println("enter");
                    }
                });
                //监控内容变化
                Text text1 = new Text(shell, SWT.BORDER);
                text1.addModifyListener(new ModifyListener() {
                    //内容变化事件
                    @Override
                    public void modifyText(ModifyEvent arg0) {
                        System.out.println("文本内容发生变化 ");
                    }
                });
                //键盘事件
                Text text2 = new Text(shell, SWT.BORDER);
                text2.addKeyListener(new KeyListener() {
                    // 完整的按下，松开的事�?
                    @Override
                    public void keyReleased(KeyEvent arg0) {
                        System.out.println("键盘释放的事�?" + arg0);
                    }
                    // 按下，且长按有效
                    @Override
                    public void keyPressed(KeyEvent arg0) {
                        System.out.println("键盘按下的事�?" + arg0);
                    }
                });
                //事件的另外一种写法�??
                Text text3 = new Text(shell, SWT.BORDER);
                text3.addListener(SWT.SELECTED, new Listener() {
                    //�?有的事件在control都是这样的写�?
                    @Override
                    public void handleEvent(Event arg0) {
                        System.out.println("点击�?");
                    }
                });
                
            }
        });
    }
}

