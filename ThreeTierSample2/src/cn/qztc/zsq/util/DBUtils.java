package cn.qztc.zsq.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUtils {
	// ��װ���ݿ������Ϣ
	public final static String DRIVER = "com.mysql.cj.jdbc.Driver";
	public final static String URL = "jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding=UTF8&&serverTimezone=UTC";
	final static String USERNAME = "root";
	final static String PASSWORD = "sam404";

	// ��ȡConnection
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	// ��ȡPreparedStatement
	public static PreparedStatement getPreparedStatement(Connection conn, String sql) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pstmt;
	}

}
