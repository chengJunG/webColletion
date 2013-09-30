package com.cheng.freemarker;

import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;


public class FreemarkerTest {
	private static FreemarkerUtil fu;
	private static Map<String,Object> map = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		fu = new FreemarkerUtil();
		map = new HashMap<String,Object>();
	}
	
	//1、创建简单freemarker
	@Test
	public void test01() {
		//1、创建数据模型
		Map<String,Object> root = new HashMap<String,Object>();
		//2、为数据模型添加值
		root.put("username", "张三");
		//3、将数据模型和模板组合的数据输出到控制台
		fu.print("01.ftl", root);
	}
}
