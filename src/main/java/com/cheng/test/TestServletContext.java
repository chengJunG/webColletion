package com.cheng.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * display some servletContext cases ,see more at http://blog.csdn.net/bryanliu1982/article/details/5214899
 * 
 * @author Fuck
 *
 */
public class TestServletContext extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		ServletContext context = req.getServletContext();

		out.println("servlet context path : " + context.getContextPath());

		out.println("real path : " + context.getRealPath("/"));
		
		out.println("init parameter --> email : " + context.getInitParameter("email"));
		
		context.setAttribute("name", "chengjun");

		out.println("app attribute --> name : " + context.getAttribute("name"));
		
		out.flush();
		out.close();
	}

}
