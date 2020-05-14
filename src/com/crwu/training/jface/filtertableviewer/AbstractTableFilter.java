package com.crwu.training.jface.filtertableviewer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
/**
 * class desc�?
 * 
 * @author WuChengRui
 * @date 2018-8-10
 */
public abstract class AbstractTableFilter {
    public final static String COLUMN_INDEX = "COLUMN_INDEX";
    private Table table;
    //存放text文本框的数组
    private List<Text> textList = new ArrayList<Text>();
    //
    private TableViewer tableViewer;
    //用来做解析对象的provider
    private ITableLabelProvider labelProvider;
    //原始数据
    private List allInput;
    private ModifyListener listener  = new ModifyListener() {
        @Override
        public void modifyText(ModifyEvent e) {
            String textString = ((Text) (e.widget)).getText();
            int column = (int) e.widget.getData(COLUMN_INDEX);
            preFilter();
            doFilter(textString, column,SWT.Modify);
            postFilter();
        }
    };
    private boolean alwayShowFilterControls;
    private TraverseListener traverseListener  = new TraverseListener() {
        @Override
        public void keyTraversed(TraverseEvent e) {
            // TRAVERSE_RETURN 是回车键
            if (e.detail != SWT.TRAVERSE_TAB_NEXT && e.detail != SWT.TRAVERSE_RETURN) {
                return;
            }
            Text tt = (Text) e.widget;
            int column = (int) e.widget.getData(COLUMN_INDEX);
            doFilter(tt.getText(), column , SWT.Traverse);
        }
    };;
    public AbstractTableFilter(TableViewer tableViewer, ITableLabelProvider labelProvider) {
        this.tableViewer = tableViewer;
        this.labelProvider = labelProvider;
        allInput = (List) tableViewer.getInput();
        this.table = tableViewer.getTable();
        initTableEditor(allInput);
    }
    
    /**
     * 调用刷新功能
     * @param newInput
     */
    public void refresh(List newInput){
//        allInput.clear();
        //�?要把之前的数据清理一�?
        if(table.getItemCount() > 1){
            table.remove(1, table.getItemCount()-1);
        }
        allInput = newInput;
        //因为是如果直接设置text，会触发modify方法，所以还是先移除，再添加
        removeModfity();
        for (Text text : textList) {
            text.setText("");
        }
        addModfity();
        initTableEditor(allInput);
    }
    /**
     * 初始化editor
     * 1.�?定是新建了一条空item
     * 2.�?要给空item.setData
     * 3.才能setInput
     * @param newInput 
     */
    protected void initTableEditor(List newInput) {
        //如果没有任何数据,�?要新增一条tableEditorItem
        if (newInput == null || newInput.isEmpty()) {
            if(textList.isEmpty()){
                TableItem item = new TableItem(table, 0);
                createEditorItem();
            }
            
        } else {
            addEmptyItemAtFirst(newInput);
            tableViewer.setInput(newInput);
        }
    }
    /**
     * 添加�?条新的空数据在list的最前面
     * @param newInput
     */
    protected List addEmptyItemAtFirst(List newInput) {
       
        Object newInstance = createObj();
        newInput.add(0, newInstance);
        
        createEditorItem();
        //在调用setInput之前，需要先给第�?条item设置data，不然会引发解析对象出错
        TableItem item = table.getItem(0);
        item.setData(newInstance);
        return newInput;
    }
    /**
     * 创建�?个对象，类型和allInput里面的数据一�?
     * @return
     */
    protected Object createObj() {
        if (allInput.isEmpty()) {
            return null;
        }
        Object data = allInput.get(0);
        Object newInstance = null;
        // 新建�?个对象放到list的表�?
        try {
            newInstance = data.getClass().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return newInstance;
    }
    /**
     * 创建�?条editorItem
     * 此方法，只会执行�?次，当textList不Empty的时候，不会再执�?
     */
    private void createEditorItem() {
        if(!textList.isEmpty()){
            return ;
        }
        for (int index = 0; index < table.getColumnCount(); index++) {
            TableEditor e = createTableEditor(index);
            textList.add((Text) e.getEditor());
        }
    }
    /**
     * 创建单一列的editor，如果想某些列不�?要editor，可以复写此方法
     * @param index
     * @return
     */
    protected TableEditor createTableEditor(int index) {
        TableItem item = table.getItem(0);
        TableEditor editor = new TableEditor(table);
        Text text = new Text(table, SWT.BORDER);
        text.setData(COLUMN_INDEX, index);
        editor.setEditor(text, item, index);
        editor.grabHorizontal = true;
        editor.grabVertical = true;
        return editor;
    }
    /**
     * �?要实现的过滤规则，符合规则返回true，不符合返回false
     * @param textString 文本的输入框的文�?
     * @param columnString table列的文本
     * @param eventType
     *            SWT.Modify||SWT.TRAVERSE_TAB_NEXT ||SWT.TRAVERSE_RETURN 事件类型
     * @return
     */
    public abstract boolean filterByRole(String textString, String columnString, int eventType);
    /**
     * 新增内容更改事件
     */
    public void addModfity() {
        for (Text text : textList) {
            text.addModifyListener(listener);
        }
    }
    
    /**
     * 移除�?有的modify方法
     */
    public void removeModfity() {
        for (Text text : textList) {
            text.removeModifyListener(listener);
        }
    }
    
    /**
     * 创建键盘切换焦点事件
     */
    public void addTraverse() {
        for (final Text text : textList) {
            text.addTraverseListener(traverseListener);
        }
    }
    
    /**
     * 新增文本框输入验证事�?
     * @param listener
     */
    public void addVifity(VerifyListener listener){
        for (final Text text : textList) {
            text.addVerifyListener(listener);
        }
    }
    
    /**
     * 获取�?有的过滤文本
     * @return
     */
    public String[] getAllTexts() {
        String[] texts = new String[textList.size()];
        for (int i = 0; i < textList.size(); i++) {
            if(textList.get(i) == null){
                continue;
            }
            texts[i] = textList.get(i).getText();
        }
        return texts;
    }
    /**
     * 进行�?有的table的filter处理
     * @param textString 输入的text
     * @param index 第几�?
     * @param eventType 事件类型
     */
    public void doFilter(String textString, int index , int eventType) {
        
        List newInput = new ArrayList<>();
        
        newInput.addAll(allInput);
        if(newInput.isEmpty()){
            return ;
        }
        boolean needAdd = false;
        for (int columnIndex = 0; columnIndex < textList.size(); columnIndex++) {
            //有可能会出现某些列没有文本框的情况，�?要continue
            if(textList.get(columnIndex) == null){
                continue;
            }
            String text = textList.get(columnIndex).getText();
            //如果没有任何输入，也可以不需要处�?
            if(text.length() == 0){
                continue;
            }
            needAdd = true;
            for (Iterator iterator = newInput.iterator(); iterator.hasNext();) {
                Object object = (Object) iterator.next();
                String columnText = labelProvider.getColumnText(object, columnIndex);
                boolean filterByRole = filterByRole(text, columnText, eventType);
                if (!filterByRole) {
                    iterator.remove();
                }
            }
            
        }
        if(needAdd){
            addEmptyItemAtFirst(newInput);
        }
        tableViewer.setInput(newInput);
    }
    
    /**
     * 设置是否�?直显示过滤文�?
     * @param flag
     */
    public void setAlwayShowFilterControls(boolean flag){
        
        alwayShowFilterControls = flag;
        
    }
    
    /**
     * doFilter之前
     */
    protected void preFilter(){
        
    }
    
    /**
     * doFilter之后
     */
    protected void postFilter(){
        
    }
    
}

