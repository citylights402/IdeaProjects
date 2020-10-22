package cn.qztc.zsq.service;

import java.util.List;

import cn.qztc.zsq.dao.StudentDao;
import cn.qztc.zsq.entity.Student;

public class StudentService {
	// 业务逻辑层依赖于数据访问层

	StudentDao stuDao = new StudentDao();

	// 增加学生

	public boolean addStudent(Student stu)

	{

		// 增加之前先进行逻辑判断，如果此人已经存在，则不能再次增加

		if (stuDao.isExistByNo(stu.getStudentNo()))

		{

			System.out.println("此人已经存在，不能重复增加！");

			return false;

		}

		// 调用数据访问层的方法，实现增加操作

		return stuDao.addStudent(stu);

	}

	// 根据学号删除学生

	public boolean deleteStudentByNo(int stuNo)

	{

		// 删除之前先进行逻辑判断，如果此人不存在，则给出错误提示

		if (!stuDao.isExistByNo(stuNo))

		{

			System.out.println("查无此人，无法删除！");

			return false;

		}

		// 调用数据访问层的方法，实现删除操作

		return stuDao.deleteStudentByNo(stuNo);

	}

	// 修改学生信息：将原来学号为stuNo的学生信息，修改为实体类stu中的包含信息

	public boolean updateStudent(Student stu, int stuNo)

	{

		// 修改之前先进行逻辑判断，如果需要修改的人不存在，则给出错误提示

		if (!stuDao.isExistByNo(stuNo))

		{

			System.out.println("查无此人，无法修改！");

			return false;

		}

		// 调用数据访问层的方法，实现删除操作

		return stuDao.updateStudent(stu, stuNo);

	}

	// 根据学号，查询某一个学生

	public Student queryStudentByNo(int stuNo)

	{

		// 查询操作一般不用判断，直接调用数据访问层的方法即可

		return stuDao.queryStudentByNo(stuNo);

	}

	// 查询全部学生

	public List<Student> queryAllStudents()

	{

		// 查询操作一般不用判断，直接调用数据访问层的方法即可

		return stuDao.queryAllStudents();

	}

	// 根据学号，判断某一个学生是否已经存在

	public boolean isExistByNo(int stuNo)

	{

		// 直接调用数据访问层的方法进行判断

		return stuDao.isExistByNo(stuNo);

	}

}
