package com.manager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.manager.entity.User;
import com.manager.util.SqlUtil;

public class UserDao {
	/**
	 * 执行注册
	 * @param user
	 * @return
	 */
	public boolean reg(User user) {
		Connection conn = SqlUtil.getConnection();
		String sql = "insert into user values (0,?,?,?,?,?,?)";
		PreparedStatement pst = null;
		boolean flag = false;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getSex());
//			String hobbys = "";
//			for (String hobby : user.getHobbys()) {
//				hobbys += hobby+",";
//			}
//			hobbys = hobbys.substring(0, hobbys.length()-1);
			
			//把数组转换成集合
//			List<String> list = Arrays.asList(user.getHobbys());
			String hobbys = Arrays.toString(user.getHobbys());
			pst.setString(4, hobbys);
			pst.setString(5, user.getAddress());
			pst.setString(6, user.getIntroduce());
			flag = pst.executeUpdate() > 0 ;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			SqlUtil
			.close(null, pst, conn);
		}
		return flag;
	}

	public User login(String username, String password) {
		Connection conn = SqlUtil.getConnection();
		String sql = "select * from user where username=? and password=?";
		PreparedStatement pst = null;
		ResultSet rs = null;
		User user = null;
		
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, username);
			pst.setString(2, password);
			rs = pst.executeQuery();
			if(rs.next()) {
				user = new User();
				user.setUid(rs.getInt("uid"));
				user.setAddress(rs.getString("address"));
				user.setIntroduce(rs.getString("introduce"));
				user.setPassword(rs.getString("password"));
				user.setSex(rs.getString("sex"));
				user.setUsername(rs.getString("username"));
				user.setHobbys(rs.getString("hobby").split(","));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			SqlUtil
			.close(null, pst, conn);
		}
		return user;
	}
	
	public List<User> selectAll() {
		Connection conn = SqlUtil.getConnection();
		String sql = "select * from user";
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<User> users = new ArrayList<>();
		
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setUid(rs.getInt("uid"));
				user.setAddress(rs.getString("address"));
				user.setIntroduce(rs.getString("introduce"));
				user.setPassword(rs.getString("password"));
				user.setSex(rs.getString("sex"));
				user.setUsername(rs.getString("username"));
				user.setHobbys(rs.getString("hobby").split(","));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			SqlUtil
			.close(null, pst, conn);
		}
		return users;
	}
	
	public boolean deleteUser(int uid) {
		Connection conn = SqlUtil.getConnection();
		String sql = "delete from user where uid=?";
		PreparedStatement pst = null;
		boolean flag = false;
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, uid);
			flag = pst.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			SqlUtil
			.close(null, pst, conn);
		}
		return flag;
	}
	
	
	/**
	 * 执行注册
	 * @param user
	 * @return
	 */
	public boolean update(User user) {
		Connection conn = SqlUtil.getConnection();
		String sql = "update user set username=?,password=?,sex=?,hobby=?,address=?,introduce=? where uid=?";
		PreparedStatement pst = null;
		boolean flag = false;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getSex());
//			String hobbys = "";
//			for (String hobby : user.getHobbys()) {
//				hobbys += hobby+",";
//			}
//			hobbys = hobbys.substring(0, hobbys.length()-1);
			
			//把数组转换成集合
//			List<String> list = Arrays.asList(user.getHobbys());
			String hobbys = Arrays.toString(user.getHobbys());
			pst.setString(4, hobbys);
			pst.setString(5, user.getAddress());
			pst.setString(6, user.getIntroduce());
			pst.setInt(7, user.getUid());
			flag = pst.executeUpdate() > 0 ;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			SqlUtil
			.close(null, pst, conn);
		}
		return flag;
	}
	
}
