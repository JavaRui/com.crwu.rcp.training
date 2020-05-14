package com.crwu.training.jface.combotableviewer;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import com.utils.ShellBack;
import com.utils.UiUtils;
import com.crwu.bean.SimpleBean;
import com.crwu.common.LayoutDataUtils;
import com.crwu.common.table.CommonTableViewerContentProvider;
import com.crwu.training.jface.tableviewer.SimpleLabelProvider;
/**
 * @author WuChengRui
 * @date 2018-5-14
 * @desc tableviewer的提供�??
 */
public class Demo4HeaderTableViewer {
    public static void main(String[] args) {
        UiUtils.createSwt(new ShellBack() {
            @Override
            public void callBack(Shell shell) {
                final GridLayout layout = new GridLayout();
//                layout.marginHeight = -10;
                layout.verticalSpacing = -5;
                shell.setLayout(layout);
                shell.setSize(500, 400);
                // 生成测试数据
                List<SimpleBean> list = new ArrayList<>();
                for (int i = 0; i < 10; i++) {
                    SimpleBean bean = new SimpleBean();
                    bean.setId("id_" + i);
                    bean.setAirCode("airCode_" + i);
                    bean.setAirStart("airStart_" + i);
                    bean.setAirEnd("airEnd_" + i);
                    list.add(bean);
                }
                // 生成列头
                String[] headers = new String[] { "id�?", "airCode�?", "airStart�?", "airEnd�?" };
                // 1.定义�?个TableViewer对象. 同时在构造方法中定义其式�?. 这里设置成可以多�?(SWT.MULTI),
                // 可以整行选择(SWT.FULL_SELECTION)
                TableViewer headerviewer = new TableViewer(shell, SWT.H_SCROLL | SWT.BORDER 
                        | SWT.FULL_SELECTION | SWT.V_SCROLL);
                Table headerTable = headerviewer.getTable();
                headerTable.setHeaderVisible(true);// 设置标头
                headerTable.setLinesVisible(true);// 显示表格�?
                
                // 2.建立TableViewer中的�?
                TableLayout tLayout = new TableLayout();// 专用于表格的布局
                headerviewer.getTable().setLayout(tLayout);
                CellEditor[] editors = new CellEditor[headers.length];
                for (int i = 0; i < headers.length; i++) {
                    String header = headers[i];
                    tLayout.addColumnData(new ColumnWeightData(80));// 这个是设置ID列的列宽�?80像素
                    new TableColumn(headerviewer.getTable(), SWT.NONE).setText(header);
                    CellEditor ce = new ComboBoxCellEditor(headerviewer.getTable(),headers);
                    editors[i] = ce;
                }
                List<SimpleBean> tempList = new ArrayList<>();
                tempList.add(new SimpleBean());
                headerviewer.setCellEditors(editors);
                GridData createFillGridNoVer = LayoutDataUtils.createFillGridNoVer(1);
                createFillGridNoVer.heightHint = 30;
                headerviewer.getTable().setLayoutData(createFillGridNoVer);
                headerviewer.setColumnProperties(headers);
                
                
                headerviewer.setCellModifier(new TableBaseModify());
                // 4.设定内容�?,�?般都不用修改这个�?
                headerviewer.setContentProvider(new CommonTableViewerContentProvider());
                // 5.设定标签�?
                headerviewer.setLabelProvider(new SimpleLabelProvider());
                // 6.设置显示列数�?
                headerviewer.setInput(tempList);
                
                
                TableLayout ssLayout = new TableLayout();// 专用于表格的布局
                TableViewer contentviewer = new TableViewer(shell, SWT.H_SCROLL | SWT.BORDER 
                        | SWT.FULL_SELECTION | SWT.V_SCROLL);
                contentviewer.setColumnProperties(headers);
                
                Table table1 = contentviewer.getTable();
                table1.setLayout(ssLayout);
                for (int i = 0; i < headers.length; i++) {
                    String header = headers[i];
                    ssLayout.addColumnData(new ColumnWeightData(80));// 这个是设置ID列的列宽�?80像素
                    new TableColumn(table1, SWT.NONE).setText(header);
                }
                
                table1.setHeaderVisible(false);// 设置标头
                table1.setLinesVisible(true);// 显示表格�?
                GridData createFillGrid = LayoutDataUtils.createFillGrid();
//                createFillGrid.verticalAlignment = -5;
                table1.setLayoutData(createFillGrid);
                // 4.设定内容�?,�?般都不用修改这个�?
                contentviewer.setContentProvider(new CommonTableViewerContentProvider());
                // 5.设定标签�?
                contentviewer.setLabelProvider(new SimpleLabelProvider());
                // 6.设置显示列数�?
                contentviewer.setInput(list);
            }
        });
    }
}

