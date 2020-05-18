/**
 * Administrator
 * 2015-4-13
 */
package com.crwu.utils.log;
import java.io.File;
/**
 * 输出类，主要为了解决没有slf4j的情况下的日志输出
 * */
public class SimpleLog implements LogFace{
	
	private static SimpleLog inst ;
	//要捕获的字段
	private StringBuilder filterSb = new StringBuilder();
	//表示是否开启过滤器
	private boolean isFilter = false;
	
	private SimpleLog(){
	}
	
	/**
	 * 可以用xxx.l代替
	 */
	public static SimpleLog getInst(){
		if(inst == null){
			inst = new SimpleLog();
		}
		return inst;
	}
	
	public void log(String logName , Object show){
		System.out.println(logName+""+show.toString());
	}
	
	public void log(Class<?> logName , Object show){
		log("["+logName.getSuperclass().getSimpleName()+"--"+logName.getSimpleName()+"]",show);
	}
	
	public void le(Class<?> logName , Object show){
		le("["+logName.getSuperclass().getSimpleName()+"--"+logName.getSimpleName()+"]" , show.toString());
	}
	@Override
	public void le(String clsName, Object show) {
		
		System.err.println(clsName + " " + show.toString());
		
	}
	
	
	
}

