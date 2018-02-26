package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 数据库工具类
 * @author Administrator
 *
 */
public class SqlUtil {
/**
 * 1. 加载驱动，只需要加载一次
 * 2. 获取链接
 * 3. 创建预处理器
 * 4. 执行增删改查
 * 5. 关闭
 */
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取连接
	 */
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/library","root","yifan520");
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 关闭资源
	 */
	public static void close(ResultSet rs,PreparedStatement pst,Connection conn) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pst != null) {
			try {
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn != null ) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
