package com.crwu.training.jface.tableviewer;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableColorProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Table;
import com.crwu.bean.SimpleBean;
/**
 * class 标签规则提供�?
 * @author WuChengRui  
 * @date 2018-6-13  
 */
public class SimpleLabelProvider implements ITableLabelProvider , ITableColorProvider{
    Table table = null;
    public SimpleLabelProvider(){
        
    }
    
    public SimpleLabelProvider(Table table){
        this.table =table;
    }
    
    
	@Override
	public String getColumnText(Object element, int columnIndex) {
	    if(columnIndex == 0){
	        return table.getItemCount()+"";
	    }
	    SimpleBean bean = (SimpleBean) element;
	    //�?0列，显示id
	    if(columnIndex==0){
            return bean.getId();
        }
	    //第一列，显示airCode
	    else if(columnIndex==1){
            return bean.getAirCode();
        }
	    //第二列，显示airStart
	    else if(columnIndex==2){
            return bean.getAirStart();
        }
	    //第三列，显示airEnd
	    else if(columnIndex==3){
            return bean.getAirEnd();
        }
		return "";
	}
    @Override
    public void addListener(ILabelProviderListener listener) {
    }
    @Override
    public void dispose() {
    }
    @Override
    public boolean isLabelProperty(Object element, String property) {
        return false;
    }
    @Override
    public void removeListener(ILabelProviderListener listener) {
    }
    @Override
    public Image getColumnImage(Object element, int columnIndex) {
        return null;
    }
    @Override
    public Color getForeground(Object element, int columnIndex) {
        if(columnIndex == 0){
            return new Color(null,213,20,80);
        }
        return null;
    }
    @Override
    public Color getBackground(Object element, int columnIndex) {
        if(columnIndex == 1){
            return new Color(null,213,120,180);
        }
        return null;
    }
	
}

