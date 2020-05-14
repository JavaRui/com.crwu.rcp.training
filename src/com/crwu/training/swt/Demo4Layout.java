package com.crwu.training.swt;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
/**
 * class desc�?
 * 
 * @author ruien.wu
 * @date 2018-6-5
 */
public class Demo4Layout {
    public static void main(String[] args) {
        new Demo4Layout().createSwt();
    }
    /**
     * 创建�?个swt程序
     * 
     * @param inBack
     */
    public void createSwt() {
        // 新建�?个display
        Display display = Display.getDefault();
        // 新建�?个窗�?
        Shell shell = new Shell();
        // 设置窗体尺寸
        shell.setSize(500, 500);
        // 设置窗体标题
        shell.setText("hello 讯讯");
        createContent(shell);
        // 打开窗体
        shell.open();
        // 刷新布局，如果没有设置布�?，则不需要刷�?
        shell.layout();
        // 以下代码是为了阻塞display释放
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        System.exit(0);
    }
    /**
     * @param shell
     */
    private void createContent(Shell shell) {
        // 设置�?个垂直充满式的布�?，可以看到，
        //效果是全部充满且垂直均分�?整个shell
        shell.setLayout(new FillLayout());
        // 设置水平充满式布�?
        // shell.setLayout(new FillLayout(SWT.HORIZONTAL));
        Button pushBtn = new Button(shell, SWT.PUSH);
        pushBtn.setText("btn");
        Composite gridComp = new Composite(shell, SWT.BORDER);
        // 设置�?个网格布�?，�?�且网格之间宽度相等
        GridLayout gl = new GridLayout(3, true);
        // margin的属性主要设置与边距的距�?
        // 在设置margin属�?�时要注意，margin本身就与边距有些距离�?
        // 如果要设置到完全紧贴边距，要设置为负�?
        // 想要marginRight和marginBottom生效，同时要保证子控件占满空�?
        // 比如当子控件使用了grabExcessHorizontalSpace之后，才有效�?
        gl.marginTop = 40;// 控制顶部离边缘的距离空间
        gl.marginBottom = 20;// 控制底部离边缘的距离空间
        gl.marginLeft = 50;// 控制左边离边缘的距离空间
        gl.marginRight = 30;// 控制右边离边缘的距离空间
        // gl.marginWidth = 50;//控制左边和右边组件离边缘的距离空�?
        // gl.marginHeight = 50;//控制顶部和底部组件离边缘的距离空�?
        gl.horizontalSpacing = 15;// 水平控件之间的空�?
        gl.verticalSpacing = 15;// 垂直控件之间的空�?
        gridComp.setLayout(gl);
        Button btn1 = new Button(gridComp, SWT.PUSH);
        btn1.setText("btn1");
        GridData gd1 = new GridData();
        // 水平抢占,由于上面的gl的makeColumnsEqualWidth=true�?
        // �?以此时这个属性无法生�?
        gd1.grabExcessHorizontalSpace = true;
        gd1.grabExcessVerticalSpace = true;// 垂直抢占
        gd1.horizontalAlignment = SWT.FILL;// 水平充满
        gd1.verticalAlignment = SWT.FILL; // 垂直充满
        btn1.setLayoutData(gd1);
        Button btn2 = new Button(gridComp, SWT.PUSH);
        btn2.setText("btn2");
        GridData gd2 = new GridData();
        gd2.horizontalSpan = 2; // 水平占满2个格�?
        gd2.verticalSpan = 2;// 垂直占满2个格�?
        gd2.horizontalIndent = 5; // 水平网格缩进
        gd2.horizontalAlignment = SWT.FILL;// 水平充满
        gd2.verticalAlignment = SWT.FILL;// 垂直充满
        btn2.setLayoutData(gd2);
        Button btn3 = new Button(gridComp, SWT.PUSH);
        btn3.setText("btn3");
        Button btn4 = new Button(gridComp, SWT.PUSH);
        btn4.setText("btn4");
        Button btn5 = new Button(gridComp, SWT.PUSH);
        btn5.setText("btn5");
        Button btn6 = new Button(gridComp, SWT.PUSH);
        btn6.setText("btn6");
    }
}

