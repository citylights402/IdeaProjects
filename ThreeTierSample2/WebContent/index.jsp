<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="cn.qztc.zsq.entity.Student,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--

    如果删除失败，则返回本页时需有错误提示。具体可查看DeleteStudentServlet.java中的代码

    --%>

	<%
		//如果存放了错误标识符

		if (request.getAttribute("delError") != null)

		{

			out.print("<strong>删除失败！</strong>");

		}

		if (request.getAttribute("addError") != null)

		{

			out.print("<strong>增加失败！</strong>");

		}
	%>

	<table border="1">

		<tr>

			<th>学号</th>

			<th>姓名</th>

			<th>年龄</th>
			<th>年级</th>

			<th>操作</th>

			<%--

                          年级信息不在列表页显示，只能在具体学生的详情页showStudentInfo.jsp显示

                          --%>

		</tr>


		<%
			List<Student> students = (List<Student>) request.getAttribute("students");

			if (students != null)

			{

				for (Student stu : students)

				{
		%>

		<tr>

			<%-- 单击“学号”链接，可以进入修改页面 --%>

			<td>
				<%--调用查询某一个学生的Servlet；

                                                         并通过地址重写的方式将需要修改学生的学号传递过去 --%>


				<a
				href="QueryStudentByNoServlet?stuNo=<%=stu.

							getStudentNo()%>">

					<%=stu.getStudentNo()%>

			</a>

			</td> ​

			<td><%=stu.getStudentName()%></td>

			<td><%=stu.getStudentAge()%></td> ​

			<td><%=stu.getGradeName()%></td> ​
			<%--调用删除的Servlet，并通过地址重写的方式将学号传递过去

                                              --%>

			<td><a href="DeleteStudentServlet?stuNo=<%=stu.getStudentNo()%>">
					删除 </a>　　　<a href="QueryStudentByNoServlet?stuNo=<%=stu.getStudentNo()%>">
					修改</a></td>

		</tr>

		<%
			}

			}
		%>

	</table>

	<a href="addStudent.jsp">增加</a>
</body>
</html>