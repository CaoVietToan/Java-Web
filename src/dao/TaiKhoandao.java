package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.TaiKhoanBean;

public class TaiKhoandao {
	public TaiKhoanBean checkAdminLogin(String username, String pass) {
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			String sql = "  select * from Admin where username = ? and password = ? and phanquyen = 1";
			statement = KetNoiDao.connection.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, pass);
			rs = statement.executeQuery();
			while (rs.next()) {
				TaiKhoanBean a = new TaiKhoanBean();
				a.setUsername(rs.getString("username"));
				a.setPassword(rs.getString("password"));
				return a;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
