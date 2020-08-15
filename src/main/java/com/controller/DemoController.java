package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class DemoController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("输出结果");
		//ViewResovler
		ModelAndView mav = new ModelAndView("main");
		return mav;
	}

}
//1.SpringMVC 中重要组件
//1.1 DispatcherServlet : 前端控制器,接收所有请求	(如果配置/的话就不包含jsp)
//1.2 HandlerMapping: 解析请求格式的.判断希望要执行哪个具体的方法.
//1.3 HandlerAdapter: 负责调用具体的方法.
//1.4 ViewResovler:视图解析器.解析结果,准备跳转到具体的物理视图
//2.SpringMVC 运行原理图

/*@WebServlet("/")//1.1 DispatcherServlet : 前端控制器,接收所有请求	(如果配置/的话就不包含jsp)
public class DispatchServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String str = req.getParameter("control");//1.2 HandlerMapping: 解析请求格式的.判断希望要执行哪个具体的方法.
		if (str.equals("demo1")) {//1.3 HandlerAdapter: 负责调用具体的方法.
			demo1(req,resp);
		}
		if (str.equals("demo2")) {
			demo2(req,resp);
		}
	}
	public void demo1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("demo1");
		req.getRequestDispatcher("index.jsp").forward(req, resp);//1.4 ViewResovler:视图解析器.解析结果,准备跳转到具体的物理视图
	}
	public void demo2(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("demo2");
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
	//三.SpringMVC 运行原理
	//1. 文字解释
	//如果在web.xml 中设置DispatcherServlet 的<url-pattern>为 / 时,
	//当用户发起请求, 请求一个控制器, 首先会执行DispatcherServlet. 
	//由DispatcherServlet 调用HandlerMapping，具体调用哪个类需要根据具体环境
	//例如使用注解方式则调用 DefaultAnnotationHandlerMapping 解析URL, 
	//解析后调用HandlerAdatper 组件的AnnotationMethodHandlerAdapter 调用Controller 中的HandlerMethod.
	//当HandlerMethod 执行完成后会返回View,
	//这个view会被ViewResovler 进行视图解析,解析后调用jsp 对应的.class 文件并运行,最终把运行.class 文件的结果响应给客户端.
	//以上就是springmvc 运行原理(给面试官说的)*/