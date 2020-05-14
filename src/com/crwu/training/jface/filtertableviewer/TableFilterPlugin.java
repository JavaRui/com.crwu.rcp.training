package com.crwu.training.jface.filtertableviewer;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
/**
 * class  desc�?
 * @author WuChengRui  
 * @date 2018-8-13  
 */
public class TableFilterPlugin {
    /**
     * 创建过滤规则为字符串规则为contains的AbstractTableFilter
     * @param tableviewer
     * @return
     */
    public static AbstractTableFilter createContainsRole(TableViewer tableviewer){
        ITableLabelProvider labelProvider = (ITableLabelProvider) tableviewer.getLabelProvider();
        AbstractTableFilter filter = new AbstractTableFilter(tableviewer , labelProvider){
            
            @Override
            public boolean filterByRole(String textString, String columnString, int eventType) {
                System.out.println(textString+"    "+columnString);
                if(columnString.contains(textString)){
                    System.out.println("-------true--------");
                    return true;
                }
                return false;
            }
        };
        filter.addModfity();
        return filter;
    } 
    /**
     * 创建过滤规则为字符串规则为startsWith的AbstractTableFilter
     * @param tableviewer
     * @return
     */
    public static AbstractTableFilter createStartWithRole(TableViewer tableviewer ){
        ITableLabelProvider labelProvider = (ITableLabelProvider) tableviewer.getLabelProvider();
        AbstractTableFilter filter = new AbstractTableFilter(tableviewer , labelProvider){
            
            @Override
            public boolean filterByRole(String textString, String columnString, int eventType) {
//                System.out.println(textString+"    "+columnString);
                if(columnString.startsWith(textString)){
//                    System.out.println("-------true--------");
                    return true;
                }
                return false;
            }
        };
        filter.addModfity();
        return filter;
    } 
    
    
}

