package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Book;
import entity.Catelog;
import entity.UserEntity;
import util.SqlUtil;

public class UserDao {
	/**
	 * 注册操作数据库
	 */
	public boolean reg(UserEntity user) {
		boolean flag = false;
		Connection conn = SqlUtil.getConnection();
		String sql = "insert into user values (0,?,?,?)";
		PreparedStatement pst =null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getNickname());
			flag = pst.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtil.close(null,pst,conn);
		}
		return flag;
	}
	
	/**
	 * 登陆操作数据库
	 */
	public UserEntity login(String username,String password) {
		Connection  conn = SqlUtil.getConnection();
		String sql = "select * from user where username=? and password=?";
		PreparedStatement pst =null;
		ResultSet rs = null;
		UserEntity user =null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, password);
			rs= pst.executeQuery();
			if(rs.next()) {
				user=new UserEntity();
				user.setUid(rs.getInt("uid"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setNickname(rs.getString("nickname"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			SqlUtil.close(rs, pst, conn);
		}
		return user;
	}
}
