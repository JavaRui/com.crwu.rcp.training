package com.crwu.training.item;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.internal.layout.LayoutUtil;
import com.crwu.common.LayoutDataUtils;
import com.utils.FileUtils;
import com.utils.ShellBack;
import com.utils.UiUtils;
/**
 * class desc�?
 * 
 * @author WuChengRui
 * @date 2018-6-6
 */
public class Demo4Table {
    private Control[] controls = null;
    
    /**
     * @param shell
     */
    public Demo4Table(Shell shell) {
        shell.setLayout(new GridLayout());
        
        final Table table = new Table(shell, SWT.MULTI | SWT.FULL_SELECTION | SWT.CHECK);
        table.setLayoutData(LayoutDataUtils.createFillGrid()   );
        table.setHeaderVisible(true);// 设置显示表头
        table.setLinesVisible(true);// 设置显示表格�?/*
        // 创建表头的字符串数组
        final String[] tableHeader = { "姓名", "性别", "电话", "电子邮件" };
        for (int i = 0; i < tableHeader.length; i++) {
            // 设置列头
            TableColumn tableColumn = new TableColumn(table, SWT.NONE);
            tableColumn.addControlListener(new ControlListener() {
                
                @Override
                public void controlResized(ControlEvent e) {
                    TableColumn[] columns = table.getColumns();
                    int[] widths = new int[columns.length];
                    for(int i = 0 ; i < widths.length ; i ++ ){
                        widths[i] = columns[i].getWidth();
                    }
                    resizeControls(widths);
                }
                
                @Override
                public void controlMoved(ControlEvent e) {
                    System.out.println(e);
                }
            });
            tableColumn.setText(tableHeader[i]);
            tableColumn.setWidth(80);
//            tableColumn.setText(tableHeader[i]);
            // 设置表头可移动，默认为false
            tableColumn.setMoveable(true);
            // 如果不调用pack，则要设置宽�?
//            tableColumn.pack();
        }
        table.setLayoutData(LayoutDataUtils.createFillGrid()   );
       
        // 添加1行数�?
        TableItem item = new TableItem(table, SWT.NONE);
        item.setText(new String[] { "张三", "�?", "123", "" });
        // 设置图标
        item.setImage(new Image(null, FileUtils.getSrcDir()+"\\icons\\logo.gif"));
        for (int i = 0; i < 5; i++) {
            item = new TableItem(table, SWT.NONE);
            item.setText(new String[] { "李四", "�?", "458"+i, "" });
        }
        initControls(shell,table);
    }
    
    private void initControls(Shell shell ,final Table table){
        Composite cc = new Composite(shell, 0);
        controls = new Control[table.getColumnCount()];
        for(int i = 0 ; i < controls.length ; i ++ ){
            controls[i] = new Text(cc,SWT.BORDER);
        }
        cc.setLayoutData(LayoutDataUtils.createFillGridNoVer(1))    ;
        GridLayout layout = new GridLayout(controls.length, false);
        layout.marginLeft = -5;
        layout.horizontalSpacing = 0;
        cc.setLayout(layout);
        
        TableColumn[] columns = table.getColumns();
        for (TableColumn tableColumn : columns) {
            tableColumn.addControlListener(new ControlListener() {
                
                @Override
                public void controlResized(ControlEvent e) {
                    TableColumn[] columns = table.getColumns();
                    int[] widths = new int[columns.length];
                    for(int i = 0 ; i < widths.length ; i ++ ){
                        widths[i] = columns[i].getWidth();
                    }
                    System.out.println(e);
                    resizeControls(widths);
                }
                
                @Override
                public void controlMoved(ControlEvent e) {
                    System.out.println(e);
                }
            });
        }
        int[] widths = new int[columns.length];
        for(int i = 0 ; i < widths.length ; i ++ ){
            widths[i] = columns[i].getWidth();
        }
        resizeControls(widths);
        
    }
    
    
    public void resizeControls(int[] widths){
        if(controls == null){
            return ;
        }
        
        for(int i = 0 ; i < controls.length ; i ++ ){
            if(controls[i] == null){
                continue;
            }
            GridData gd = new GridData(widths[i]-9, 15);
            controls[i].setLayoutData(gd);
        }
        controls[0].getParent().layout();
    }
    
    public static void main(String[] args) {
        UiUtils.createSwt(new ShellBack() {
            @Override
            public void callBack(Shell shell) {
               new Demo4Table(shell);
            }
        });
    }
}

