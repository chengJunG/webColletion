package com.cheng.freemarker;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cheng.freemarker.model.User;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class Hello1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		Configuration cfg = Util.getTemplateConfiguration();

		Template template = cfg.getTemplate("hello1.ftl");

		/**
		 * 一定要先设置字符集，然后再获取输出流，否则无法生效。
		 * The response's character encoding is only set from the given content type if this method is called before getWriter is called. 
		 */
		response.setContentType("text/html; charset = " + template.getEncoding());
		PrintWriter out = response.getWriter();
		@SuppressWarnings("rawtypes")
		HashMap map = new HashMap();
		map.put("user", new User(2, "zhangsan", 16));
		
		try {
			template.process(map, out);
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	}

}
