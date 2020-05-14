package com.crwu.training.swt;
/**
 * class  desc�?
 * @author ruien.wu  
 * @date 2018-6-5  
 */
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
public class TestGridLayout {
    public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setText("Find (GridLayout)");
        GridLayout layout = new GridLayout(4, false);
        layout.marginWidth = layout.marginHeight = 14;
        shell.setLayout(layout);
        {
            Label label = new Label(shell, SWT.NONE);
            label.setText("Find what:");
            // 创建水平充满，上下居中，水平不抢占，垂直不抢�?
            GridData labelData = new GridData(SWT.FILL, SWT.CENTER, false, false);
            label.setLayoutData(labelData);
        }
        {
            Text text = new Text(shell, SWT.BORDER);
            Monitor monitor = shell.getMonitor();
            int width = monitor.getClientArea().width / 10;
         // 创建水平充满，上下居中，水平抢占，垂直不抢占，水平为2个格子，垂直�?1个格子的gridData
            GridData textData = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
            textData.widthHint = width;
            text.setLayoutData(textData);
        }
        {
            Button findButton = new Button(shell, SWT.PUSH);
            findButton.setText("Find Next");
         // 创建水平充满，上下居中，水平不抢占，垂直不抢�?
            GridData findData = new GridData(SWT.FILL, SWT.CENTER, false, false);
            findButton.setLayoutData(findData);
        }
        {
            Group group = new Group(shell, SWT.NONE);
            group.setLayout(new RowLayout());
            group.setText("Direction");
            
            Button upButton = new Button(group, SWT.RADIO);
            upButton.setText("Up");
            
            Button downButton = new Button(group, SWT.RADIO);
            downButton.setText("Down");
            downButton.setSelection(true);
            // 创建靠右，上下居中，水平不抢占，垂直不抢占，水平�?3个格子，垂直�?1个格子的gridData
            GridData groupData = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 3, 1);
            group.setLayoutData(groupData);
        }
        {
            Button cancelButton = new Button(shell, SWT.PUSH);
            cancelButton.setText("Cancel");
            // 创建水平充满，上下居中，水平不抢占，垂直不抢�?
            GridData cancelData = new GridData(SWT.FILL, SWT.CENTER, false, false);
            cancelButton.setLayoutData(cancelData);
        }
        shell.pack();
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
    }
}

