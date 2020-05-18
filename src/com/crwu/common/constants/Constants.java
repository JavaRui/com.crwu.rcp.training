package com.crwu.common.constants;
import java.io.File;
/**
 * 常量配置类
 * */
public class Constants {
	public static final String $ = File.separatorChar + "";
	public static String TITLE = "请选择";// softName+version
	public static String USER_DIR = System.getProperty("user.dir") + $ + "";
	public static final String res = USER_DIR + "res"+$;
	
	public static String CODE_TYPE = "utf-8";
	
}

