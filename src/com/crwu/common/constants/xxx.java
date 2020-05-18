/**
 * 
 */
package com.crwu.common.constants;

import com.crwu.utils.log.LogFace;
import com.crwu.utils.log.SimpleLog;

/**
 * @author cr.wu
 *
 * 2015年7月16日
 * 
 * 原谅我放荡的命名
 * 
 * 存放常用单例
 * 存放交互地址，和context
 */
public class xxx {
	
	/**特殊的分割符号*/
	public static final String SP = "！。@。！";
	private xxx(){
		
	}
	
	/**商品数据*/
//	public static GoodsData g = GoodsData.getInst();
	/**log处理*/
	public static LogFace consoleLog = SimpleLog.getInst();
	
	
	
	
	public static void log(Object obj , Object show){
		Class<?> logName = obj.getClass();
		consoleLog.log(logName, show);
	}
	
	public static void log(String logName , Object show){
		consoleLog.log(logName, show);
	}
	
	public static void log(Class<?> logName , Object show){
		consoleLog.log(logName, show);
	}
	
	public static void le(Class<?> logName , Object show){
		consoleLog.le(logName, show);
	}
	
	public static void le(Class<?> logName , Exception ex){
		consoleLog.le(logName, ex);
	}
	
	
	
	
}

