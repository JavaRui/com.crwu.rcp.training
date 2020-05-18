package com.crwu.training.jface.tableviewer;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import com.crwu.bean.SimpleBean;
import com.crwu.common.UiUtil;
import com.crwu.common.callback.ShellBack;
import com.crwu.common.table.CommonTableViewerContentProvider;
import com.crwu.utils.RandomUtil;
/**
 * @author WuChengRui
 * @date 2018-5-14
 * @desc tableviewer的提供�??
 */
public class Demo4TableViewer implements ShellBack {
    public static void main(String[] args) {
        UiUtil.createSwt(new Demo4TableViewer());
    }
    @Override
    public void callBack(Shell shell) {
        shell.setSize(500, 400);
        // 生成测试数据
        List<SimpleBean> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            SimpleBean bean = new SimpleBean();
            bean.setId("id_" + i);
            bean.setAirCode("code_" + RandomUtil.getInst().getEnRandom(4, 6));
            bean.setAirStart("start_" +  RandomUtil.getInst().getNumRandom(4, 6));
            bean.setAirEnd("end_" +  RandomUtil.getInst().getNumRandom(4, 6));
            list.add(bean);
        }
        // 生成列头
        String[] headers = new String[] { "id�?", "airCode�?", "airStart�?", "airEnd�?" };
        // 1.定义�?个TableViewer对象. 同时在构造方法中定义其式�?. 这里设置成可以多�?(SWT.MULTI),
        // 可以整行选择(SWT.FULL_SELECTION)
       final TableViewer tableviewer = new TableViewer(shell, SWT.H_SCROLL | SWT.BORDER 
                | SWT.FULL_SELECTION | SWT.V_SCROLL);
        Table table = tableviewer.getTable();
        table.setHeaderVisible(true);// 设置标头
        table.setLinesVisible(true);// 显示表格�?
        // 2.建立TableViewer中的�?
        TableLayout tLayout = new TableLayout();// 专用于表格的布局
        tableviewer.getTable().setLayout(tLayout);
        for (int i = 0; i < headers.length; i++) {
            String header = headers[i];
            tLayout.addColumnData(new ColumnWeightData(80));// 这个是设置ID列的列宽�?80像素
            TableColumn cc = new TableColumn(tableviewer.getTable(), SWT.NONE);
            cc.setText(header);
            cc.setData(i);
            //点击排序
            cc.addSelectionListener(new SelectionListener() {
                
                @Override
                public void widgetSelected(SelectionEvent e) {
                    if(tableviewer.getSorter() == null){
                        return ;
                    }
                    //排序
                    int column = Integer.valueOf(e.widget.getData()+"");
                    ((SimpleTableSorter)tableviewer.getSorter()).doSort(column);
                    //刷新
                    tableviewer.refresh();
                }
                
                @Override
                public void widgetDefaultSelected(SelectionEvent e) {
                }
            });
            
        }
        // 4.设定内容�?,�?般都不用修改这个�?
        tableviewer.setContentProvider(new CommonTableViewerContentProvider());
        // 5.设定标签�?
        tableviewer.setLabelProvider(new SimpleLabelProvider());
        //设置sort排序
        tableviewer.setSorter(new SimpleTableSorter());
        // 6.设置显示列数�?
        tableviewer.setInput(list);
    }
}

