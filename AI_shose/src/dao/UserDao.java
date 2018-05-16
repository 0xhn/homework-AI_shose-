package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.GreenHouse;
import bean.User;
import db.DBUtils;

public class UserDao {
	public User selectUserByName(User u){
    	System.out.println("selectUserByName...");
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        String sql = "select * from user where username=?";
        try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, u.getUsername());
            rs = ps.executeQuery();
            if(rs.next()){
            	user = new User();
            	user.setId(rs.getInt("id"));
            	user.setUsername(rs.getString("username"));   //必须与数据表的字段一致！！！
                user.setPassword(rs.getString("password"));
                user.setLevel(rs.getString("level"));
            }
        }catch(SQLException e){
            e.printStackTrace();
            try {
				throw new SQLException("MySql访问异常 ");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }finally{
            DBUtils.close(rs, ps, conn);
        }
        return user;
    }
	public User selectUserById(User user) {
		// TODO Auto-generated method stub
    	System.out.println("selectUserById...");
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;
        String sql = "select * from user where id=?";
        try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, user.getId());
            rs = ps.executeQuery();
            if(rs.next()){
            	u = new User();
            	u.setId(rs.getInt("id"));
            	u.setUsername(rs.getString("username"));   //必须与数据表的字段一致！！！
                u.setPassword(rs.getString("password"));
            }
        }catch(SQLException e){
            e.printStackTrace();
            try {
				throw new SQLException("MySql访问异常 ");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }finally{
            DBUtils.close(rs, ps, conn);
        }
        return u;
	}
	public int AddUser(User user) {
		// TODO Auto-generated method stub
    	System.out.println("AddUser...");
        Connection conn = null;
        PreparedStatement ps = null;
        int n=0;
        String sql = "insert into user values(null,?,?)";
        try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            n = ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            try {
				throw new SQLException("MySql访问异常 ");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }finally{
            DBUtils.close(null, ps, conn);
        }
        return n;
	}
	public int UpdateUser(User user){
		int n=0;
        Connection conn = null;
        PreparedStatement ps = null;
//        System.out.println(greenHouse.getPublishtime()+"            333333333333");
        String sql = "update user set username=?,password=? where id=?";
        try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(2, user.getPassword());
            ps.setString(1, user.getUsername());
            ps.setInt(3, user.getId());
            n=ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            try {
				throw new SQLException("数据库访问异常");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }finally{
            DBUtils.close(null, ps, conn);
        }    
        return n;
	}
	public List<User> SelectAllUser(){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<User> infoList=new ArrayList<User>();
		try {
			String sql="select * from user";
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);     
            rs = ps.executeQuery();
			while(rs.next()){
				User info=new User();
				info.setId(rs.getInt("id"));
				info.setUsername(rs.getString("username"));
				info.setPassword(rs.getString("password"));
				info.setLevel(rs.getString("level"));
				infoList.add(info);
			}
		}catch(SQLException e){
            e.printStackTrace();          
			try {
				throw new SQLException("MySql访问异常 ");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}			
        }finally{
        	DBUtils.close(rs, ps, conn);
        }
		return infoList;
	}
}
