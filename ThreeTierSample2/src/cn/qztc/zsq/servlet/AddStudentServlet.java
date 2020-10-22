package cn.qztc.zsq.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.qztc.zsq.entity.Student;
import cn.qztc.zsq.service.StudentService;
@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet

{

     protected void doGet(HttpServletRequest request, HttpServletResponse response)

                        throws ServletException, IOException

     {

               //若是get方式的请求，则仍然使用post方式进行处理

               this.doPost(request, response);

     }



     protected void doPost(HttpServletRequest request, HttpServletResponse response)

     throws ServletException, IOException

     {

               request.setCharacterEncoding("UTF-8");

               //接收表单提交的数据

               int studentNo = Integer.parseInt(request.getParameter("sno"));

               String studentName = request.getParameter("sname");

               int studentAge = Integer.parseInt(request.getParameter("sage"));

               String gradeName = request.getParameter("gname");

               //将数据封装到实体类中

               Student stu =new Student(studentNo, studentName, studentAge, gradeName);

               //调用业务逻辑层代码

               StudentService stuService = new StudentService();

               boolean result = stuService.addStudent(stu);



               if (!result)

               {

                        //如果增加失败，则在request中放入一个标识符，标识一下错误

                        request.setAttribute("addError", "error");

                        //返回增加页面。因为需要传递request作用域中的数据，所以使用请求转发

                        request.getRequestDispatcher("addStudent.jsp").forward(request, response);

               }else

               {

                        response.sendRedirect("QueryAllStudentsServlet");

               }

     }

}