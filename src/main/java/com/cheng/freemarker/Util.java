package com.cheng.freemarker;

import java.util.LinkedList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.cheng.freemarker.model.URL;

import freemarker.template.Configuration;

public class Util {
	public static Configuration getTemplateConfiguration() {
		// 初始化FreeMarker配置
		// 创建一个Configuration实例
		Configuration cfg = new Configuration();

		cfg.setDefaultEncoding("UTF-8");
		// 设置FreeMarker的模版文件位置
		cfg.setClassForTemplateLoading(Util.class, "../../../../../templates");

		return cfg;
	}

	public static List<URL> getURLlist() {

		SAXReader reader = new SAXReader();

		Document document = null;

		List<URL> result = new LinkedList<URL>();

		try {
			
			
			//获取资源URL，如果以/开头，则在classpath路径下查找，否则相对类路径
//			document = reader.read(Util.class.getResource("../../../../../WEB-INF/web.xml"));
			document = reader.read(Util.class.getResource("/../../WEB-INF/web.xml"));
			
			System.out.println(Util.class.getProtectionDomain().getCodeSource().getLocation().getPath());
			
			List<Element> servlets = document.getRootElement().elements("servlet-mapping");

			for (Element e : servlets) {
				URL url = new URL();
				//substring重载的方法总共有两个，分别为一个参数和两个参数，一个参数表示起始位置，表示截取到结尾
				url.setUrl(e.elementText("url-pattern").substring(1));
				url.setName(e.elementText("servlet-name"));
				result.add(url);
			}

		} catch (DocumentException e) {
			e.printStackTrace();
		}

		return result;

	}
}
