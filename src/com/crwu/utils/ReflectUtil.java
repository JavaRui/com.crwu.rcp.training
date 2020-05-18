package com.crwu.utils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.crwu.common.constants.xxx;
public class ReflectUtil {
	
	/**
	 * 获取某个方法的返回值
	 * @param object
	 * @param getMetName
	 * @return
	 */
	public static Object getValue(Object object, String getMetName){
		Class<?> tCls = object.getClass();
		Method tMethod;
		
		Object r =null;
		try {
			tMethod = tCls.getMethod(getMetName, null);
			r = tMethod.invoke(object, new Object[] {});
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return r;
	}
	/**
	**
	 * 获取属性的值
	 * 
	 * @param object
	 * @param fieldName
	 * @return
	 */
	public static Object getValueByFieldName(Object object, String fieldName) {
		String getMetName = pareGetName(fieldName);
		Class<?> tCls = object.getClass();
		Method tMethod;
		Object r = null;
		try {
			Field ff = tCls.getDeclaredField(fieldName);
			
			String fieldType = ff.getType().getSimpleName();
			if (fieldType.equals("boolean") || fieldType.equals("Boolean")) {
				if(!checkMethod(object , getMetName)){
					tMethod = tCls.getMethod("is" + fieldName.substring(0, 1).toUpperCase()+ fieldName.substring(1), null);
				}else{
					tMethod = tCls.getMethod(getMetName, null);
				}
				
			} else {
				tMethod = tCls.getMethod(getMetName, null);
			}
			r = tMethod.invoke(object, new Object[] {});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return r;
	}
	
	
	/**
	 * 取出bean 属性和值
	 * 
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public static Map<Object, Object> getFileValue(Object obj) throws Exception {
		Map<Object, Object> map = new HashMap<Object, Object>();
		Class<?> cls = obj.getClass();
		Method methods[] = cls.getDeclaredMethods();
		Field fields[] = cls.getDeclaredFields();
		for (Field field : fields) {
			String fldtype = field.getType().getSimpleName();
			String getMetName = pareGetName(field.getName());
			String result = "";
			if (!checkMethod(methods, getMetName)) {
				continue;
			}
			Method method = cls.getMethod(getMetName, null);
			Object object = method.invoke(obj, new Object[] {});
			if (null != object) {
				if (fldtype.equals("Date")) {
					result = fmlDate((Date) object);
				} else if (fldtype.equals("boolean")
						|| fldtype.equals("Boolean")) {
				} else
					result = String.valueOf(object);
			}
			map.put(field.getName(), result);
		}
		return map;
	}
	
	/**
	 * 判断该对象类型，是否有method方法
	 * @param obj
	 * @param methodName
	 * @return
	 */
	public static boolean checkMethod(Object obj , String methodName){
		Class<?> cls = obj.getClass();
		Method methods[] = cls.getDeclaredMethods();
		for (Method method : methods) {
			if (methodName.equals(method.getName())) {
				return true;
			}
		}
		return false;
	}
	
	
	
	public static Object setFieldValue(Object bean) throws Exception {
		return setFieldValue(getValueMap(),bean);
	}
	/**
	 * 设置bean 属性值
	 * 
	 * @param map
	 * @param bean
	 * @throws Exception
	 */
	public static Object setFieldValue(Map<Object, Object> map, Object bean) throws Exception {
		Class<?> cls = bean.getClass();
		Field fields[] = cls.getDeclaredFields();
		for (Field field : fields) {
			String fldtype = field.getType().getSimpleName();
			Object value = map.get(fldtype);
			setValue(bean, field, value);
		}
		return bean;
	}
	
	/**
	 * 设置bean的field的value
	 */
	public static void setValue(Object bean, Field field, Object value)
			throws Exception {
		Class<?> cls = bean.getClass();
		String fldtype = field.getType().getSimpleName();
		String fldSetName = field.getName();
		String setMethod = pareSetName(fldSetName);
		Method methods[] = cls.getDeclaredMethods();
		if (!checkMethod(methods, setMethod)) {
//			xxx.log(ReflectUtil.class, bean + "    找不到            " + setMethod+ "       方法");
			return;
		}
		Method method = cls.getMethod(setMethod, field.getType());
		if (null != value) {
			if ("String".equals(fldtype)) {
				method.invoke(bean, (String) (value + ""));
			} else if ("Double".equals(fldtype) || "double".equals(fldtype)) {
				if ((value + "").length() == 0) {
					value = "0";
				}
				method.invoke(bean, Double.valueOf(value + ""));
			} else if ("Integer".equals(fldtype) || "int".equals(fldtype)) {
				if ((value + "").length() == 0) {
					value = "0";
				}else if((value + "").equals("false")){
					value = "0";
				}else if((value + "").equals("true")){
					value = "1";
				}
				Integer val = Integer.valueOf(value + "");
				method.invoke(bean, val);
			} else if ("Date".equals(fldtype)) {
				Date val = null;
				if(value.getClass().getSimpleName().equals("String")){
					if(!(value.toString()).contains(":")){
						if(value.toString().length() == 0){
							val = new Date();
						}else{
							value = value+" 00:00:00";
							val = DateUtil.getDateByStr(value+"");
						}
					}
				}
				else {
					val = (Date) value;
				}
				
				method.invoke(bean, val);
			} else if ("Float".equals(fldtype) || "float".equals(fldtype)) {
				if ((value + "").length() == 0) {
					value = "0";
				}
				Float val = Float.valueOf((String) (value + ""));
				method.invoke(bean, val);
			} else if ("Boolean".equals(fldtype) || "boolean".equals(fldtype)) {
				Boolean val = Boolean.valueOf(value + "");
				method.invoke(bean, val);
			}
		}
	}
	
	/**
	 * 根据属性名字，设置值
	 */
	public static void setValueByFieldName(Object bean ,  String fieldName ,  Object value) throws Exception{
		Class<?> cls = bean.getClass();
		Field indexField = null;
		Field[] fields = cls.getDeclaredFields();
		for(Field field : fields){
			if(field.getName().equals(fieldName)){
				indexField = field;
				break;
			}
		}
		if(indexField == null){
			xxx.log(ReflectUtil.class,"找不到property：         "+fieldName);
			return ;
		}
		setValue(bean,indexField,value);
	}
	
	/**
	 * 拼接某属性get 方法
	 * 
	 * @param fldname
	 * @return
	 */
	public static String pareGetName(String fldname) {
		if (null == fldname || "".equals(fldname)) {
			return null;
		}
		String pro = "get" + fldname.substring(0, 1).toUpperCase() + fldname.substring(1);
		return pro;
	}
	/**
	 * 拼接某属性set 方法
	 * 
	 * @param fldname
	 * @return
	 */
	public static String pareSetName(String fldname) {
		if (null == fldname || "".equals(fldname)) {
			return null;
		}
		String pro = "set" + fldname.substring(0, 1).toUpperCase() + fldname.substring(1);
		return pro;
	}
	/**
	 * 判断该方法是否存在
	 * 
	 * @param methods
	 * @param met
	 * @return
	 */
	public static boolean checkMethod(Method methods[], String met) {
		if (null != methods) {
			for (Method method : methods) {
				if (met.equals(method.getName())) {
					return true;
				}
			}
		}
		return false;
	}
	/**
	 * 把date 类转换成string
	 * 
	 * @param date
	 * @return
	 */
	public static String fmlDate(Date date) {
		if (null != date) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
			return sdf.format(date);
		}
		return null;
	}
	/**
	 * 定义生成值的MAP并返回
	 * 
	 * @param
	 * @return Map<Object, Object>
	 */
	public static Map<Object, Object> getValueMap() {
		Map<Object, Object> map = new HashMap<Object, Object>();
		try {
			String intType = "Integer";
			String intType2 = "int";
			String floatType = "Float";
			String floatType2 = "float";
			String strType = "String";
			String dateType = "Date";
			RandomUtil ru = RandomUtil.getInst();
			map.put(intType, ru.getInt(100));
			map.put(intType2, ru.getInt(100));
			int t = ru.getInt(1000000);
			float f = (float) (Float.valueOf(t + "") / (100.00));
			map.put(floatType, f);
			map.put(floatType2, f);
			map.put(strType, ru.getEnFixed(8));
			map.put(dateType, "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	
	/**
	 * 获取一个class
	 * @param className 全路径 "com.yt.utils.reflect.TestData";
	 * TestData op = (TestData)ReflectGetValue.getObjByClassName(className);
	 * */
	public static Object getObjByClassName(String className){
	
		try {
			Class clazz = Class.forName(className);
			Object obj = clazz.newInstance();
			return ReflectUtil.setFieldValue( obj);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public static Object getObjByClass(Class<?> classInt){
		try {
			Object obj = classInt.newInstance();
			return ReflectUtil.setFieldValue( obj);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 获取长度为len的对象数组,在json情况下可以用，一般情况下，不如用getObjByClassName自己循环
	 * 如
	 * TestData[] objs = new TestData[len];
		for(int i = 0 ; i < objs.length ;i++ ){
			TestData o = (TestData)getObjByClassName(className);
			objs[i] = o;
		}
	 * 
	 * @param className
	 * @param len
	 * @return
	 * Object[] objs = getObjByClassName(className,5);
		TestData[] tds = new TestData[objs.length];
		for(int i = 0 ; i < objs.length ;i++ ){
			TestData o = (TestData)objs[i];
			xxx.log(ReflectGetValue.class,o.toString());
			tds[i] = o;
		}
	 */
	public static Object[] getObjByClassName(String className , int len){
		Object[] objs = new Object[len];
		for(int i = 0 ; i < objs.length ;i++ ){
			Object o = getObjByClassName(className);
			objs[i] = o;
		}
		return objs;
		
		
	}
	
	/**
	 * 在list中获取属性值用","隔开。
	 * @param list 对象列表
	 * @param fieldName 要获取的属性
	 * @return
	 */
	public static String getFieldsByList(List<?> list , String fieldName){
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < list.size() ; i++ ){
			String id = ReflectUtil.getValueByFieldName(list.get(i), fieldName)+"";
			sb.append(id+",");
		}
		String delIds = sb.toString().substring(0, sb.toString().length()-1);
		return delIds;
	}
	
}

