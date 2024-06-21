package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.loaiBean;


public class LoaiGiayDao {
	public List<loaiBean> getLoai() {
    	ArrayList<loaiBean> ds = new ArrayList<loaiBean>();
    	PreparedStatement statement = null;
    	ResultSet rs = null;
    	try {
    		String sql = "SELECT * FROM LoaiGiay";
    		statement = KetNoiDao.connection.prepareStatement(sql);
    		rs = statement.executeQuery();
    		while (rs.next()) {
    			loaiBean loaiBean = new loaiBean();
    			loaiBean.setMaLoai(rs.getString("maLoai"));
    			loaiBean.setTenLoai(rs.getString("tenLoai"));
    			ds.add(loaiBean);
    		}
    		return ds;
		} catch (SQLException e) {
			return null;
		} finally {
			try {
				if(statement != null) {
					statement.close();
				}
				if(rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
    }

}
