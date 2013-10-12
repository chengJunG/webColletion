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

public class URLlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Configuration cfg = Util.getTemplateConfiguration();

		Template template = cfg.getTemplate("list.ftl");

		response.setContentType("text/html; charset = " + template.getEncoding());
		PrintWriter out = response.getWriter();
		@SuppressWarnings("rawtypes")
		HashMap map = new HashMap();
		map.put("list", Util.getURLlist());
		
		try {
			template.process(map, out);
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	}

}
