package com.crwu.utils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class DateUtil {
	// MM是月，mm是分，不能混用
	public final static String YMD_HMS1 = "yyyy-MM-dd HH:mm:ss";
	public final static String YMD_HMS2 = "yyyy.MM.dd hh:mm:ss";
	public final static String YMD_HMS3 = "yyyy/MM/dd hh:mm:ss";
	public final static String YMD_HMS4 = "yyyy年MM月dd日  HH时mm分ss秒  ";
	public final static String YM1 = "yyyy-MM";
	public final static String YM2 = "yyyy.MM";
	public final static String YM3 = "yyyy/MM";
	public final static String YM4 = "yyyy年MM月 ";
	public final static String YMD1 = "yyyy-MM-dd";
	public final static String YMD2 = "yyyy.MM.dd";
	public final static String YMD3 = "yyyy/MM/dd";
	public final static String YMD4 = "yyyy年MM月dd日 ";
	public final static String HMS1 = "HH:mm:ss";
	public final static String ERP_YMD1 = YMD1;
	public final static String ERP_YMD_HMS1 = YMD_HMS1;
	public final static String ERP_YM1 = YM1;
	// G 公元 ，E 星期几，a 上午或下午，z时区， D一年的第几天，w一年的第几个星期，W一个月的第几个星期，k小时
	public static long getTime(String time) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date d1 = sdf.parse(time);
			return d1.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	 //是否提醒 
	 public static boolean getRemind(String endTime , String currentTime ,int day){
		 SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
		 Date d1 = null;
		 Date d2=null;
		try {
			d1 = sdf.parse(endTime);
			d2 = sdf.parse(currentTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 long dddd= (d1.getTime()-d2.getTime())/1000;
		// System.out.println(dddd/(60*60*24));
		 return ( (dddd-day*24*60*60)<0 && dddd>=0 );
	 }
	/**
	 * 计算持续时间
	 * */
	public static long getDuration(String endTime, String currentTime) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d1 = null;
		Date d2 = null;
		try {
			d1 = sdf.parse(endTime);
			d2 = sdf.parse(currentTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long dddd = (d1.getTime() - d2.getTime()) / 1000;
		return dddd;
	}
	/**
	 * 返回format格式的时间
	 * */
	public static String getFormatDate(long time, String format) {
		Date date = new Date(time);
		return getFormatDate(date, format);
	}
	/**
	 * 返回format格式的时间
	 * */
	public static String getFormatDate(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
	public static String getFormatDate(Date date) {
		return simpleSDF.format(date);
	}
	/**
	 * 获取当前时间
	 * */
	public static String getNewDate() {
		String d = getFormatDate(new Date().getTime(), ERP_YMD_HMS1);
		return d;
	}
	/**
	 * 获取当前时间
	 * 
	 * @param format
	 *            格式
	 * */
	public static String getNewDate(String format) {
		String d = getFormatDate(new Date().getTime(), format);
		return d;
	}
	/**
	 * 小时折算成毫秒
	 * */
	public static long getHours(double i) {
		return getMinute(i * 60);
	}
	/**
	 * 分钟折算成毫秒
	 * */
	public static long getMinute(double i) {
		return (long) (1000 * 60 * i);
	}
	public static Date getDateByStr(String str) throws ParseException {
		Date date = simpleSDF.parse(str);
		return date;
	}
	public static SimpleDateFormat simpleSDF = new SimpleDateFormat(ERP_YMD_HMS1);
	public static void main(String[] args) throws ParseException {
		// System.out.println( getFormatDate(new Date().getTime(), "yyyy-MM-dd"));
		String t = DateUtil.getFormatDate(new Date().getTime(), "G 公元 ，E 星期几，a 上午或下午，z时区， D一年的第几天，w一年的第几个星期，W一个月的第几个星期，k小时");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = sdf.parse("2015-07-01 11:11:22");
		System.out.println(date);
	}
}

