package com.crwu.utils.log;
/**
 * @author cr.wu
 * 日志的适配类
 *
 * 2015年12月28日
 */
public interface LogFace {
	/** 
	 * 一般输出功能
	 * */
	public void log(String clsName , Object log);
	
	/** 
	 * 一般输出功能
	 * */
	public void log(Class<?> clsName , Object log);
	
	/**
	 * 特殊输出功能，比如syserr输出
	 * */
	public void le(String clsName , Object show);
	/**
	 * 特殊输出功能，比如syserr输出
	 * */
	public void le(Class<?> clsName , Object show);
	
	
}

