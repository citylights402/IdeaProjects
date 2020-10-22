package cn.qztc.zsq.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import cn.qztc.zsq.entity.Student;
import cn.qztc.zsq.util.DBUtils;

public class StudentDao {
	// 增加学生

	public boolean addStudent(Student stu)

	{

		Connection conn = null;

		PreparedStatement pstmt = null;

		// flag用来标记是否增加成功，若增加成功则返回true，若增加失败则返回false

		boolean flag = true;

		try

		{

			conn = DBUtils.getConnection();

			String sql = "insert into student(stuNo,stuName,stuAge,graName) values(?,?,?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, stu.getStudentNo());

			pstmt.setString(2, stu.getStudentName());

			pstmt.setInt(3, stu.getStudentAge());

			pstmt.setString(4, stu.getGradeName());

			pstmt.executeUpdate();

		} catch (Exception e)

		{

			e.printStackTrace();

			flag = false;

		} finally

		{

			try

			{

				if (pstmt != null)
					pstmt.close();

				if (conn != null)
					conn.close();

			} catch (SQLException e)

			{

				e.printStackTrace();

				flag = false;

			}

		}

		return flag;

	}

	// 根据学号删除学生

	public boolean deleteStudentByNo(int stuNo)

	{

		Connection conn = null;

		PreparedStatement pstmt = null;

		// flag用来标记是否删除成功，若删除成功则返回true，若删除失败则返回false

		boolean flag = true;

		try

		{

			conn = DBUtils.getConnection();

			String sql = "delete from student where stuNo = ? ";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, stuNo);

			pstmt.executeUpdate();

		} catch (Exception e)

		{

			e.printStackTrace();

			flag = false;

		} finally

		{

			try

			{

				if (pstmt != null)
					pstmt.close();

				if (conn != null)
					conn.close();

			} catch (SQLException e)

			{

				e.printStackTrace();

				flag = false;

			}

		}

		return flag;

	}

	// 修改学生信息：将原来学号为stuNo的学生信息，修改为实体类stu中的包含信息

	public boolean updateStudent(Student stu, int stuNo)

	{

		Connection conn = null;

		PreparedStatement pstmt = null;

		// flag用来标记是否修改成功，若修改成功则返回true，若修改失败则返回false

		boolean flag = true;

		try

		{

			conn = DBUtils.getConnection();

			String sql = "update student set stuNo = ?, stuName = ?,stuAge = ? ,graName=? where stuNo = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, stu.getStudentNo());

			pstmt.setString(2, stu.getStudentName());

			pstmt.setInt(3, stu.getStudentAge());

			pstmt.setString(4, stu.getGradeName());

			pstmt.setInt(5, stuNo);
			pstmt.executeUpdate();

		} catch (Exception e)

		{

			e.printStackTrace();

			flag = false;

		}

		finally

		{

			try

			{

				if (pstmt != null)
					pstmt.close();

				if (conn != null)
					conn.close();

			} catch (SQLException e)

			{

				e.printStackTrace();

				flag = false;

			}

		}

		return flag;

	}

	// 根据学号，查询某一个学生

	public Student queryStudentByNo(int stuNo)

	{

		Connection conn = null;

		PreparedStatement pstmt = null;

		ResultSet rs = null;

		Student stu = null;

		try

		{

			conn = DBUtils.getConnection();

			String sql = "select stuNo,stuName,stuAge,graName from student where stuNo = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, stuNo);

			rs = pstmt.executeQuery();

			if (rs.next())

			{

				int sNo = rs.getInt("stuNo");

				String sName = rs.getString("stuName");

				int sAge = rs.getInt("stuAge");

				String gName = rs.getString("graName");

				// 将查询到的学生信息封装到stu对象中

				stu = new Student(sNo, sName, sAge, gName);

			}

		} catch (Exception e)

		{

			e.printStackTrace();

		} finally

		{

			try

			{

				if (rs != null)
					rs.close();

				if (pstmt != null)
					pstmt.close();

				if (conn != null)
					conn.close();

			} catch (SQLException e)

			{

				e.printStackTrace();

			}

		}

		return stu;

	}

	// 查询全部学生

	public List<Student> queryAllStudents()

	{

		Connection conn = null;

		PreparedStatement pstmt = null;

		ResultSet rs = null;

		List<Student> students = new ArrayList<Student>();

		try

		{

			conn = DBUtils.getConnection();

			String sql = "select stuNo,stuName,stuAge,graName from student ";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next())

			{

				int sNo = rs.getInt("stuNo");

				String sName = rs.getString("stuName");

				int sAge = rs.getInt("stuAge");

				String gName = rs.getString("graName");

				// 将查询到的学生信息封装到stu对象中

				Student stu = new Student(sNo, sName, sAge, gName);

				// 将封装好的stu对象存放到List集合中

				students.add(stu);

			}

		} catch (Exception e)

		{

			e.printStackTrace();

		} finally

		{

			try

			{

				if (rs != null)
					rs.close();

				if (pstmt != null)
					pstmt.close();

				if (conn != null)
					conn.close();

			} catch (SQLException e)

			{

				e.printStackTrace();

			}

		}

		return students;

	}

	// 根据学号，判断某一个学生是否已经存在

	public boolean isExistByNo(int stuNo)

	{

		boolean isExist = false;

		Student stu = this.queryStudentByNo(stuNo);

		// 如果stu为null，说明查无此人，即此人不存在；否则说明已经存在此人

		isExist = (stu == null) ? false : true;

		return isExist;

	}

}
