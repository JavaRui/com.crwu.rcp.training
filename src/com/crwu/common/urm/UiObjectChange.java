package com.crwu.common.urm;
/**
 * @author cr.wu
 *
 * 2015年8月25日
 */
public interface UiObjectChange {
	/**
	 * 对象转ui
	 * */
	public void Objecst2Ui(Object obj);
	
	/**
	 * 返回一个ui的数据object
	 * @return
	 */
	public Object ui2Object();
	
}

