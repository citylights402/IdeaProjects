package cn.qztc.zsq.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.qztc.zsq.entity.Student;
import cn.qztc.zsq.service.StudentService;

@WebServlet("/QueryStudentByNoServlet")
public class QueryStudentByNoServlet extends HttpServlet

{

	protected void doGet(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException

	{

		// 若是get方式的请求，则仍然使用post方式进行处理

		this.doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException

	{

		request.setCharacterEncoding("UTF-8");

		// 接收需要显示学生的学号

		int studentNo = Integer.parseInt(request.getParameter("stuNo"));

		// 调用业务逻辑层代码

		StudentService stuService = new StudentService();

		Student stu = stuService.queryStudentByNo(studentNo);

		// 将查询到的学生信息放入request作用域中

		request.setAttribute("stu", stu);

		request.getRequestDispatcher("showStudentInfo.jsp").forward(request, response);
	}

}
