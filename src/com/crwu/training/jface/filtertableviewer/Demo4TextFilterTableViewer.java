package com.crwu.training.jface.filtertableviewer;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import com.utils.ShellBack;
import com.utils.UiUtils;
import com.crwu.bean.SimpleBean;
import com.crwu.common.RandomUtil;
import com.crwu.common.table.CommonTableViewerContentProvider;
import com.crwu.training.jface.tableviewer.SimpleLabelProvider;
/**
 * class  desc�?
 * @author WuChengRui  
 * @date 2018-8-8  
 */
public class Demo4TextFilterTableViewer implements ShellBack {
    
    private AbstractTableFilter filter;
    public static void main(String[] args) {
        UiUtils.createSwt(new Demo4TextFilterTableViewer());
    }
    @Override
    public void callBack(Shell shell) {
        shell.setSize(600, 800);
     // 生成测试数据
        List<SimpleBean> list = createList();
       
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
            tLayout.addColumnData(new ColumnWeightData(120));// 这个是设置ID列的列宽�?80像素
            new TableColumn(tableviewer.getTable(), SWT.NONE).setText(header);
        }
        // 4.设定内容�?,�?般都不用修改这个�?
        tableviewer.setContentProvider(new CommonTableViewerContentProvider());
        // 5.设定标签�?
        tableviewer.setLabelProvider(new SimpleLabelProvider());
        // 6.设置显示列数�?
//        list.add(0, new SimpleBean());
//        list.clear();
        tableviewer.setInput(null);
        addItemEdit(tableviewer);
        
        Button btn = new Button(shell, SWT.PUSH);
        btn.addSelectionListener(new SelectionListener() {
            
            @Override
            public void widgetSelected(SelectionEvent e) {
                List<SimpleBean> list = createList();
//                list.clear();
                filter.refresh(list);
            }
            
            @Override
            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });
    }
    /**
     * @param table
     */
    private void addItemEdit(TableViewer tableviewer) {
        filter = TableFilterPlugin.createContainsRole(tableviewer);
        
    }
    
    private List createList(){
        List<SimpleBean> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            SimpleBean bean = new SimpleBean();
            bean.setId("id_" + i);
            bean.setAirCode("code_" + RandomUtil.getInst().getEnRandom(4, 6));
            bean.setAirStart("start_" +  RandomUtil.getInst().getNumRandom(4, 6));
            bean.setAirEnd("end_" +  RandomUtil.getInst().getNumRandom(4, 6));
            list.add(bean);
        }
        return list;
    }
    
}

