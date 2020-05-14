package com.crwu.training.swt;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
/**
 * class desc�?
 * 
 * @author ruien.wu
 * @date 2018-6-1
 */
public class Demo1 {
    public static void main(String[] args) {
        new Demo1();
    }
    /**
     * 
     */
    public Demo1() {
        // 新建�?个display
    	// 相当于创建了�?个swt的运行环境，这个运行环境里面有一条主线程，也就是swt的UI线程
    	// UI线程的东西只能在UI线程中处理，这种处理方式并不是jvm的处理规�?,
    	//而是swt乃至其他界面语言的一个线程保护机制�?�主要实现是在widget.class里面的checkWidget ()做判断�??
        Display display = Display.getDefault();
        // 新建�?个窗体，窗体就是�?个面板，带有标题栏啥�?
        Shell shell = new Shell();
        // 设置窗体尺寸
        shell.setSize(300, 400);
        // 设置窗体标题
        shell.setText("hello 讯讯");
        // 创建主要内容
        createContent(shell);
        // 打开窗体
        shell.open();
        // 设置充满式布�?
        // shell.setLayout(new FillLayout());
        // 刷新布局，如果没有设置布�?，则不需要刷�?
        // shell.layout();
        // 以下代码是为了阻塞display释放,
        //和抛出display接收到的事件
        while (!shell.isDisposed()) {
        	//这几句代码是很多人都会奇怪的地方，也讲解下，
        	//这两句代码，其实就是接受请求系统，查看是否有关于swt的操作没�?
        	//如果有，则会�?层一层的抛出，交给对应的控件去处�?
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        System.exit(0);
    }
    /**
     * @param shell
     */
    private static void createContent(Shell shell) {
        // 创建�?个button，父容器为shell，样式为SWT.PUSH，此样式效果是凸�?
        final Button leftButton = new Button(shell, SWT.PUSH);
        // 设置坐标及尺�?
        leftButton.setBounds(0, 0, 100, 100);
        // 设置文本
        leftButton.setText("i am button");
        
        // 新建�?个composite容器，父容器为shell，样式为SWT.BORDER，此样式效果是有边框
        Composite emptyComp = new Composite(shell, SWT.BORDER);
        emptyComp.setBounds(100, 0, 100, 100);
        // 新建�?个composite容器，父容器为shell，样式为0，此样式效果没有任何效果
        Composite contentComp = new Composite(shell, SWT.BORDER);
        contentComp.setBounds(100, 100, 200, 100);
        // 新建�?个text，父容器为contentComp�?
        //样式为SWT.BORDER，此样式效果是有边框,且多行，且自动换�?
        Text text = new Text(contentComp, SWT.BORDER | SWT.MULTI | SWT.WRAP);
        text.setText("i am text , i am text");
        // 此处的坐标，�?0,0，因为设置坐标的是相对于父控件，
        //也就是contentComp来说的，并不是对于整个应用设置的
        // �?以从0�?0�?始，也就是父控件的坐标起�?
        text.setBounds(0, 0, 200, 100);
    }
}

