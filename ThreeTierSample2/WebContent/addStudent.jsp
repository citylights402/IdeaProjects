<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
​         <%-- 如果增加失败，则返回本页时需有错误提示，具体可查看AddStudentServlet.java中的代码 --%>

​         <%

       //如果存放了错误标识符

       if(request.getAttribute("addError") != null )

       {

                out.print("<strong>增加失败！</strong>");

       }

      %>

​         <form action="AddStudentServlet" method="post">

       学号：<input type="text" name="sno" /><br/>

       姓名：<input type="text" name="sname" /><br/>

       年龄：<input type="text" name="sage" /><br/>

       年级：<input type="text" name="gname" /><br/>

       <input type="submit" value="增加" /><br/>

​         </form>

</body>
</html>