package cn.qztc.zsq.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.qztc.zsq.service.StudentService;
@WebServlet("/DeleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet{
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

		// 接收通过地址重写传递来的参数

		int studentNo = Integer.parseInt(request.getParameter("stuNo"));

		// 调用业务逻辑层代码

		StudentService stuService = new StudentService();

		boolean result = stuService.deleteStudentByNo(studentNo);

		if (!result)

		{

			// 如果删除失败，则在request中放入一个标识符，标识一下错误

			request.setAttribute("delError", "error");

		}

		if (request.getAttribute("addError") != null)

		{
			PrintWriter out = response.getWriter();
			out.print("<strong>增加失败！</strong>");

		} else

		{

			// 返回增加页面。

			// 因为需要传递request作用域中的数据（错误标识符），

			// 所以使用请求转发

			request.getRequestDispatcher("QueryAllStudentsServlet").forward(request, response);

		}
	}
}
