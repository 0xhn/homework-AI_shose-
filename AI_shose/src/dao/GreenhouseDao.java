package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.GreenHouse;
import db.DBUtils;

public class GreenhouseDao {
	public GreenHouse selectGreenhouseById(GreenHouse g){
    	System.out.println("selectGreenhouseById...");
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        GreenHouse gh = null;
        String sql = "select * from greenhouse where id=?";
        try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, g.getId());
            rs = ps.executeQuery();
            if(rs.next()){
            	gh = new GreenHouse();
            	gh.setId(rs.getInt("id"));
            	gh.setArea(rs.getDouble("area"));
            	gh.setHumidity(rs.getInt("humidity"));
            	gh.setIllumination(rs.getInt("illumination"));
            	gh.setIsbreed(rs.getBoolean("isbreed"));
            	gh.setTemperature(rs.getInt("temperature"));
            	gh.setType(rs.getString("type"));
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
        return gh;
    }
	public int UpdateGreenHouse(GreenHouse greenHouse){
		int n=0;
        Connection conn = null;
        PreparedStatement ps = null;
//        System.out.println(greenHouse.getPublishtime()+"            333333333333");
        String sql = "update greenhouse set area=?,humidity=?,illumination=?,isbreed=?,temperature=?,type=? where id=?";
        try{
            conn = DBUtils.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(7, greenHouse.getId());
            ps.setDouble(1, greenHouse.getArea());
            ps.setInt(2, greenHouse.getHumidity());
            ps.setInt(3, greenHouse.getIllumination());
            ps.setBoolean(4, greenHouse.isIsbreed());
            ps.setInt(5, greenHouse.getTemperature());
            ps.setString(6, greenHouse.getType());
            
           
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
}
