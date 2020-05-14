package com.crwu.training.jface.combotableviewer;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.swt.widgets.TableItem;
import com.crwu.bean.SimpleBean;
/**
 * @author cr.wu
 * 
 *         2015-8-2
 */
public class TableBaseModify implements ICellModifier {
    public final static String  CAN_MODIFY = "CAN_MODIFY";
    public final static String  COMBO_ITEMS = "COMBO_ITEMS";
    private String[] names;
    /** table值被修改之后，抛出事�? **/
    public static final int TABLE_MODIFY = 1001;
    public TableBaseModify() {
    }
    @Override
    public void modify(Object element, String property, Object value) {
        TableItem item = (TableItem) element;
        
        System.out.println(element);
        System.out.println(property);
        System.out.println(value);
        
    }
    /**
     * 编辑之前获取
     * */
    @Override
    public Object getValue(Object element, String property) {
        SimpleBean bean = (SimpleBean) element;
        //�?0列，显示id
        if(property.equals("id�?")){
            return 0;
        }
        //第一列，显示airCode
        else if(property.equals("airCode�?")){
            return 1;
        }
        //第二列，显示airStart
        else if(property.equals("airStart�?")){
            return 2;
        }
        //第三列，显示airEnd
        else if(property.equals("airEnd�?")){
            return 3;
        }
        return "";
    }
    @Override
    public boolean canModify(Object element, String property) {
        TableItem item = (TableItem) element;
        try{
            boolean flag = (boolean) item.getData(CAN_MODIFY);
            return flag;
        }catch(Exception e){
            
        }
       
        return false;
    }
}

