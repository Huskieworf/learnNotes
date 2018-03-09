package com.homework1.dao;

import com.homework1.domain.Page;
import com.homework1.domain.User;
import com.homework1.util.MySqlUtil;

import javax.jms.ConnectionConsumer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * dao层感觉是用来解析sql语句
 */
public class UserDao {
    /**
     * 执行注册
     *
     * @param user
     * @return
     */
    public boolean register(User user) {
        Connection conn = MySqlUtil.getConnection();
        String sql = " insert into users values (0,?,?,?,?,?,?)  ";
        PreparedStatement pst = null;
        boolean flag = false;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());
            pst.setString(3, user.getSex());
            pst.setString(4, user.getLikes());
            pst.setString(5, user.getAddress());
            pst.setString(6, user.getIntroduction());
            flag = pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySqlUtil.close(null, pst, conn);
        }
        return flag;
    }


    public User login(String username, String password) {
        Connection conn = MySqlUtil.getConnection();
        String sql = " select * from users where username=? and password=?  ";
        PreparedStatement pst = null;
        ResultSet rs = null;
        User user = null;

        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);
            rs = pst.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setUid(rs.getInt("userid"));
                user.setAddress(rs.getString("address"));
                user.setIntroduction(rs.getString("introduction"));
                user.setPassword(rs.getString("password"));
                user.setSex(rs.getString("sex"));
                user.setUsername(rs.getString("username"));
                user.setLikes(rs.getString("likes"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySqlUtil.close(null, pst, conn);
        }
        return user;
    }


    public List<User> selectAll() {
        Connection conn = MySqlUtil.getConnection();
        String sql = " select * from users ";
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<User> users = new ArrayList<>();
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUid(rs.getInt("userid"));
                user.setAddress(rs.getString("address"));
                user.setIntroduction(rs.getString("introduction"));
                user.setPassword(rs.getString("password"));
                user.setSex(rs.getString("sex"));
                user.setUsername(rs.getString("username"));
                user.setLikes(rs.getString("likes"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySqlUtil.close(null, pst, conn);
        }
        return users;
    }


    public Page<User> selectAll(Page<User> page) {
        Connection conn = MySqlUtil.getConnection();
        String sql = " select * from users limit ?,? ";
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<User> users = new ArrayList<>();
        //设置共多少条数据
        page.setTotalRecords(selectCount());
        //计算总共多少页数据
        page.setTotalPages((page.getTotalRecords() - 1) / page.getPageSize() + 1);
            try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1,(page.getPageNow()-1)*page.getPageSize());
            pst.setInt(2,page.getPageSize());
            rs = pst.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUid(rs.getInt("userid"));
                user.setAddress(rs.getString("address"));
                user.setIntroduction(rs.getString("introduction"));
                user.setPassword(rs.getString("password"));
                user.setSex(rs.getString("sex"));
                user.setUsername(rs.getString("username"));
                user.setLikes(rs.getString("likes"));
                users.add(user);
            }
            page.setList(users);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySqlUtil.close(null, pst, conn);
        }
        return page;
    }

    public int selectCount(){
        Connection conn= MySqlUtil.getConnection();
        PreparedStatement pst = null;
        ResultSet rs = null;
        int count = 0;
        String sql= " select count(*) c from users ";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()) {
                count = rs.getInt("c");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            MySqlUtil.close(rs,pst,conn);
        }
        return count;
    }


    public boolean update(User user) {
        Connection conn = MySqlUtil.getConnection();
        String sql = " update users set username=?,password=?,sex=?,likes=?,address=?,introduction=? where userid=? ";
        PreparedStatement pst = null;
        boolean flag = false;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());
            pst.setString(3, user.getSex());
            pst.setString(4, user.getLikes());
            pst.setString(5, user.getAddress());
            pst.setString(6, user.getIntroduction());
            pst.setInt(7, user.getUid());
            flag = pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySqlUtil.close(null, pst, conn);
        }
        if (flag == false) {
            System.out.println("修改不成功");
        }

        return flag;
    }

    public boolean deleteUser(int uid) {
        Connection conn = MySqlUtil.getConnection();
        String sql = " delete from users  where userid=? ";
        PreparedStatement pst = null;
        boolean flag = false;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, uid);
            flag = pst.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MySqlUtil.close(null, pst, conn);
        }
        return flag;
    }
}