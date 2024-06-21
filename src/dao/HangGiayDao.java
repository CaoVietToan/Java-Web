package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.hangBean;


public class HangGiayDao {
	public List<hangBean> getHang() {
    	ArrayList<hangBean> ds = new ArrayList<hangBean>();
    	PreparedStatement statement = null;
    	ResultSet rs = null;
    	try {
    		String sql = "SELECT * FROM HangGiay";
    		statement = KetNoiDao.connection.prepareStatement(sql);
    		rs = statement.executeQuery();
    		while (rs.next()) {
    			hangBean hangBean = new hangBean();
    			hangBean.setMaHang(rs.getString("maHang"));
    			hangBean.setTenHang(rs.getString("tenHang"));
    			ds.add(hangBean);
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
