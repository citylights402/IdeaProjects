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

@WebServlet("/QueryAllStudentsServlet")
public class QueryAllStudentsServlet extends HttpServlet

{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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

		// 调用业务逻辑层代码

		StudentService stuService = new StudentService();

		List<Student> students = stuService.queryAllStudents();

		// 将查询到的学生集合放入request作用域中

		request.setAttribute("students", students);

		// 跳转到首页（学生列表页）

		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

}
