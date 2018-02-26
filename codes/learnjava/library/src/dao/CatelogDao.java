package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import entity.Catelog;
import util.SqlUtil;

public class CatelogDao {
	/**
	 * 查詢書籍分類
	 */
	public List<Catelog> selectCatelog(){
		Connection conn = SqlUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Catelog> catelogs = new ArrayList<>();
		String sql = "select * from catelog";
		try {
			pst = conn.prepareStatement(sql);
			rs= pst.executeQuery();
			while(rs.next()) {
				Catelog catelog = new Catelog();
				catelog.setCid(rs.getInt("cid"));
				catelog.setName(rs.getString("cname"));
				catelog.setIntroduce(rs.getString("cintroduce"));
				catelogs.add(catelog);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			SqlUtil.close(rs,pst,conn);
		}
		return catelogs;
	}
	
	/**
	 * 添加add
	 */
	public boolean insertCatelog(Catelog catelog) {
		Connection conn = SqlUtil.getConnection();
		PreparedStatement pst = null;
		boolean flag = false;
		String sql = "insert into catelog values (0,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, catelog.getName());
			pst.setString(2, catelog.getIntroduce());
			flag = (pst.executeUpdate() > 0);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtil.close(null, pst, conn);
		}
		return flag;
	}
	
	public boolean deleteCatelog(int cid) {
		boolean flag = false;
		Connection conn = SqlUtil.getConnection();
		PreparedStatement pst = null;
		String sql = "delete from catelog where cid=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, cid);
			flag = (pst.executeUpdate() > 0);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtil.close(null, pst, conn);
		}
		return flag;
	}
	
}
