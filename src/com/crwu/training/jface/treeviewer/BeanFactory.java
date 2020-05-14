package com.crwu.training.jface.treeviewer;
import java.util.ArrayList;
import java.util.List;
import com.crwu.training.jface.treeviewer.bean.City;
import com.crwu.training.jface.treeviewer.bean.Country;
import com.crwu.training.jface.treeviewer.bean.People;
public class BeanFactory {
	@SuppressWarnings("unchecked")
	public static List createTree() {
		// 生成国家
		Country cn = new Country("中国");
		Country us = new Country("美国");
		Country jp = new Country("日本");
		// 生成城市
		City beijing = new City("北京");
		City shanghai = new City("上海");
		City newyork = new City("纽约");
		City la = new City("洛杉�?");
		City tokyo = new City("东京");
		City osaka = new City("大阪");
		// 北京�?
		ArrayList list = new ArrayList();
		list.add(new People(1,"张三"));
		list.add(new People(2,"李四"));
		list.add(new People(3,"王五"));
		beijing.setChildren(list);
		// 上海�?
		list = new ArrayList();
		list.add(new People(4,"翠花"));
		list.add(new People(5,"小红"));
		list.add(new People(6,"小崔"));
		shanghai.setChildren(list);
		// 纽约�?
		list = new ArrayList();
		list.add(new People(7,"tom"));
		list.add(new People(8,"rose"));
		list.add(new People(9,"john"));
		newyork.setChildren(list);
		// 洛杉矶人
		list = new ArrayList();
		list.add(new People(10,"Sofia"));
		list.add(new People(11,"sarah"));
		list.add(new People(12,"Jennifer"));
		la.setChildren(list);
		// 东京�?
		list = new ArrayList();
		list.add(new People(13,"渡边"));
		list.add(new People(14,"鬼冢"));
		list.add(new People(15,"山本"));
		tokyo.setChildren(list);
		// 大阪�?
		list = new ArrayList();
		list.add(new People(16,"奈奈�?"));
		list.add(new People(17,"菜菜�?"));
		list.add(new People(18,"新垣结衣"));
		osaka.setChildren(list);
		// 关联城市与国�?
		// 中国
		ArrayList citys = new ArrayList();
		citys.add(beijing);
		citys.add(shanghai);
		cn.setChildren(citys);
		// 美国
		citys = new ArrayList();
		citys.add(newyork);
		citys.add(la);
		us.setChildren(citys);
		// 日本
		citys = new ArrayList();
		citys.add(tokyo);
		citys.add(osaka);
		jp.setChildren(citys);
		// 国家列表
		ArrayList countrys = new ArrayList();
		countrys.add(cn);
		countrys.add(us);
		countrys.add(jp);
		return countrys;
	}
}

