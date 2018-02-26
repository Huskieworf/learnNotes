package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Book;
import entity.Catelog;
import util.SqlUtil;

public class BookDao {
	/**
	 * 查询
	 * 
	 * @return
	 */
	public List<Book> selectBook() {
		Connection conn = SqlUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Book> books = new ArrayList<>();
		String sql = "select * from book left join catelog on book.cid=catelog.cid";
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				Book book = new Book();
				book.setBid(rs.getInt("bid"));
				book.setAuthor(rs.getString("author"));
				book.setName(rs.getString("bname"));
				book.setIntroduce(rs.getString("introduce"));
				book.setPrice(rs.getDouble("price"));
				book.setPublish(rs.getString("publish"));
				// 书籍分类信息
				Catelog catelog = new Catelog();
				catelog.setCid(rs.getInt("cid"));
				catelog.setName(rs.getString("cname"));
				catelog.setIntroduce(rs.getString("cintroduce"));
				book.setCatelog(catelog);
				books.add(book);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			SqlUtil.close(rs, pst, conn);
		}
		return books;

	}
	
	/**
	 * 查询一本书
	 */
	public Book selectOneBook(int bid) {
		Book book = new Book();
		Connection conn = SqlUtil.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select * from book where bid=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, bid);
			rs = pst.executeQuery();
			while (rs.next()) {
				
				book.setBid(rs.getInt("bid"));
				book.setAuthor(rs.getString("author"));
				book.setName(rs.getString("bname"));
				book.setIntroduce(rs.getString("introduce"));
				book.setPrice(rs.getDouble("price"));
				book.setPublish(rs.getString("publish"));
				Catelog catelog = new Catelog();
				catelog.setCid(rs.getInt("cid"));
				book.setCatelog(catelog);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			SqlUtil.close(rs, pst, conn);
		}
		return book;

	}

	/**
	 * 添加add
	 */
	public boolean insertBook(Book book) {
		Connection conn = SqlUtil.getConnection();
		PreparedStatement pst = null;
		boolean flag = false;
		String sql = "insert into book values (0,?,?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, book.getName());
			pst.setString(2, book.getAuthor());
			pst.setString(3, book.getPublish());
			pst.setDouble(4, book.getPrice());
			pst.setString(5, book.getIntroduce());
			pst.setInt(6, book.getCatelog().getCid());
			flag = (pst.executeUpdate() > 0);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtil.close(null, pst, conn);
		}
		return flag;
	}

	/**
	 * 删除
	 */
	public boolean deleteBook(int bid) {
		boolean flag = false;
		Connection conn = SqlUtil.getConnection();
		PreparedStatement pst = null;
		String sql = "delete from book where bid=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, bid);
			flag = (pst.executeUpdate() > 0);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SqlUtil.close(null, pst, conn);
		}
		return flag;
	}

	/**
	 * 修改书籍
	 */
	public boolean updateBook(Book book) {
		boolean flag = false;
		Connection conn = SqlUtil.getConnection();
		PreparedStatement pst = null;
		String sql = "update book set bname=?,author=?,publish=?,price=?,introduce=?,cid=? where bid=?";
		try {
			pst= conn.prepareStatement(sql);
			pst.setString(1,book.getName() );
			pst.setString(2,book.getAuthor() );
			pst.setString(3,book.getPublish() );
			pst.setDouble(4,book.getPrice() );
			pst.setString(5,book.getIntroduce() );
			pst.setInt(6,book.getCatelog().getCid());
			pst.setInt(7, book.getBid());
			flag=pst.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			SqlUtil.close(null, pst, conn);
		}
		return flag;
	}
}
