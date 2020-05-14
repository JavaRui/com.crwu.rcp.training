package com.crwu.rcp.training.perspective;
import org.eclipse.ui.IWorkbenchPreferenceConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.util.PrefUtil;
import com.crwu.rcp.training.Activator;
/**
 * class  本类是为了设置�?�视图样式位置等功能的utils类，并非�?有的属�?�配置更多属性配置请自行查看
 * IWorkbenchPreferenceConstants中的Perspective关键字的属�??
 * 大多数的Perspective属�?�设置需要在ApplicationWorkbenchAdvisor.initialize或之前完成做执行�?
 * {@link IWorkbenchPreferenceConstants}
 * @author WuChengRui  
 * @date 2018-8-3  
 */
public class PerspectiveUtils {
    /**
     * 设置透视图按钮位置TopRight;
     * 
     */
    public static void setPositionTopRight(){
        setPosition(IWorkbenchPreferenceConstants.TOP_RIGHT);
    }
    
    
    /**
     * 设置透视图按钮位�?
     * <p>
     * values: {@link IWorkbenchPreferenceConstants#TOP_RIGHT},
     * {@link #TOP_LEFT}, or {@link #LEFT}.
     * {@link IWorkbenchPreferenceConstants#TOP_LEFT}
     * {@link IWorkbenchPreferenceConstants#LEFT}
     * </p>
     * 
     */
    public static void setPosition(String position){
        PlatformUI.getPreferenceStore().setDefault(IWorkbenchPreferenceConstants.DOCK_PERSPECTIVE_BAR, position);
    }
    
    /**
     * 设置透视图圆�?
     */
    public static void setStyle(boolean flag){
        PlatformUI.getPreferenceStore().setDefault(IWorkbenchPreferenceConstants.SHOW_TRADITIONAL_STYLE_TABS, flag);
    }
    /**
     * 设置透视图按钮是否显示文�?
     */
    public static void setShowText(boolean flag){
        PlatformUI.getPreferenceStore().setDefault(IWorkbenchPreferenceConstants.SHOW_TEXT_ON_PERSPECTIVE_BAR, flag);
    }
    
}

