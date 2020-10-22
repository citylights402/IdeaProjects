<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="cn.qztc.zsq.entity.Student" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>学生信息详情页</h3>

	​
	<%

      //如果修改失败，返回本页时需有错误提示。具体可查看UpdateStudentServlet.java中的代码

         //如果存放了错误标识符

         if(request.getAttribute("updateError") != null )

         {

                  out.print("<strong>修改失败！</strong>");

         }

         //接收查询到的学生信息

         Student stu = (Student)request.getAttribute("stu");

         if(stu !=null)

         {

     %>
	<form action="UpdateStudentServlet" method="post">

		<%--假设学号不能修改 --%>

		学号：<input type="text" name="sno" readonly="readonly"
			value="<%=stu.getStudentNo() %>" /><br /> 姓名：<input type="text"
			name="sname" value="<%=stu.getStudentName() %> " /><br /> 年龄：<input
			type="text" name="sage" value="<%=stu.getStudentAge() %>" /><br />

		年级：<input type="text" name="gname" value="<%=stu.getGradeName() %>" /><br />

		<input type="submit" value="修改" />

	</form>

	​
	<%

         }

   %>

	<a href="QueryAllStudentsServlet">返回</a>
</body>
</html>