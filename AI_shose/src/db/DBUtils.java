package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {
	private static final String driver="com.mysql.jdbc.Driver";
    private static final String url="jdbc:mysql://120.79.65.213/AI_shose?useUnicode=true&characterEncoding=UTF-8";
    private static final String username="xh_web";
    private static final String password="123456";
    static Connection conn=null;
    static Statement stmt=null;
    static PreparedStatement pstmt=null;
    static ResultSet rs=null;
    
    
    public static Connection getConnection(){
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
    
    
    public static void close(ResultSet rs,Statement stat,Connection conn){
        try {
            if(rs!=null)rs.close();
            if(stat!=null)stat.close();
            if(conn!=null)conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
