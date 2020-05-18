/**
 * @author ruien.wu  
 * @date 2018-5-14  
 * @desc   
 */
package com.crwu.common;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import com.crwu.common.callback.ShellBack;
/**
 * @author ruien.wu  
 * @date 2018-5-14  
 * @desc   
 */
public class UiUtil {
    
    /**
     * ui同步线程更新，会造成阻塞
     * */
    public static void delaySyn(final int delay, final Runnable runnable) {
        if (delay == 0) {
            Display.getDefault().syncExec(runnable);
            return;
        }
        new Thread(new Runnable() {
            // 开辟新线程
            public void run() {
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e1) {
                    // e1.printStackTrace();
                }
                Display.getDefault().syncExec(runnable);
            }
        }).start();
    }
    /**
     * ui异步线程更新，不会阻塞,该方法会等待调用此方法的方法体的功能全部运行完成之后，才会执�??
     * */
    public static void delayAsy(final int delay, final Runnable runnable) {
        if (delay == 0) {
            Display.getDefault().asyncExec(runnable);
            return;
        }
        new Thread(new Runnable() {
            // 开辟新线程
            public void run() {
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e1) {
                    // e1.printStackTrace();
                }
                Display.getDefault().asyncExec(runnable);
            }
        }).start();
    }
    
    /**
     * 创建swt程序
     * @param inBack
     */
    public static void createSwt(ShellBack inBack) {
        //新建1个display
        Display display = Display.getDefault();
        //新建1个窗�??
        Shell shell = new Shell();
        //设置窗体尺寸
        shell.setSize(300, 400);
        //设置窗体标题
        shell.setText("hello 讯讯");
        //设置充满式布�??
        shell.setLayout(new FillLayout());
        inBack.callBack(shell);
        //打开窗体
        shell.open();
        //刷新布局，如果没有设置布局，则不需要刷新
        shell.layout();
        //以下代码是为了阻塞display释放
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        System.exit(0);
    }
    
    
}

