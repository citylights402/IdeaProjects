package cn.qztc.zsq.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.qztc.zsq.entity.Student;
import cn.qztc.zsq.service.StudentService;
@WebServlet("/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet

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

             //接收需要修改学生的学号

             int studentNo = Integer.parseInt(request.getParameter("sno"));

             //接收修改后的学生信息（学号不能修改）

             String studentName = request.getParameter("sname");

             int studentAge = Integer.parseInt(request.getParameter("sage"));

             String gradeName = request.getParameter("gname");

             //将学生信息封装到实体类中

             Student student = new Student(studentNo,studentName,studentAge,gradeName);

      //调用业务逻辑层代码，实现修改

             StudentService stuService = new StudentService();

             boolean result = stuService.updateStudent(student, studentNo);
             if (!result)

             {

                      //如果修改失败，则在request中放入一个标识符，标识一下错误

                      request.setAttribute("updateError", "error");

             }else

             {

                      request.setAttribute("updateSuccess", "success");

             }

             //将修改后的学生信息放入request作用域中

             request.setAttribute("stu", student);
             //返回修改页面（学生详情页）

             //因为需要传递request作用域中的数据（错误标识符），所以使用请求转发

        request.getRequestDispatcher("showStudentInfo.jsp").forward(request, response);

   }

}
