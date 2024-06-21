package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.cthdBean;
import bean.dathangBean;
import bean.lichsuBean;

public class dathangDao {
	public ArrayList<cthdBean> getCTHD(String mahd) {
	ArrayList<cthdBean> ds = new ArrayList<cthdBean>();
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			String sql = "select * from VLichSu where maHD = ?";
			statement = KetNoiDao.connection.prepareStatement(sql);
			statement.setLong(1, Long.parseLong(mahd));
			rs = statement.executeQuery();

			while (rs.next()) {
				cthdBean cthd = new cthdBean();
				cthd.setMahd(rs.getLong("maHD"));
				cthd.setMacthd(rs.getLong("maCTHD"));
				cthd.setAnh(rs.getString("anh"));
				cthd.setTengiay(rs.getString("tenGiay"));
				cthd.setSoluong(rs.getInt("soLuong"));
				cthd.setGia(rs.getLong("gia"));
				cthd.setTrangthai(rs.getBoolean("trangthai"));
				cthd.setThanhtien(rs.getLong("thanhtien"));
				cthd.setGioitinh(rs.getString("gioiTinh"));
				ds.add(cthd);
			}
			return ds;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
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
	}
	public ArrayList<dathangBean> getHD() {
		ArrayList<dathangBean> ds = new ArrayList<dathangBean>();
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			String sql = "select * from VXacnhan " + "ORDER BY ngayMua DESC";
			statement = KetNoiDao.connection.prepareStatement(sql);
			rs = statement.executeQuery();

			while (rs.next()) {
				dathangBean hd = new dathangBean();
				hd.setMahd(rs.getLong("maHD"));
				hd.setNgaymua(rs.getDate("ngayMua"));
				hd.setThanhtien(rs.getLong("thanhtien"));
				hd.setTrangthai(rs.getBoolean("trangthai"));
				hd.setMakh(rs.getLong("maKh"));
				hd.setTenkh(rs.getString("hoTen"));
				ds.add(hd);
			}
			return ds;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
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
	}
	public ArrayList<dathangBean> getHD_makh(Long makh) {
		ArrayList<dathangBean> ds = new ArrayList<dathangBean>();
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			String sql = "select * from VXacnhan where maKh = ? \r\n" + "ORDER BY trangthai DESC";
			statement = KetNoiDao.connection.prepareStatement(sql);
			statement.setLong(1, makh);
			rs = statement.executeQuery();

			while (rs.next()) {
				dathangBean hd = new dathangBean();
				hd.setMahd(rs.getLong("maHD"));
				hd.setNgaymua(rs.getDate("NgayMua"));
				hd.setThanhtien(rs.getLong("thanhtien"));
				hd.setTrangthai(rs.getBoolean("trangthai"));
				ds.add(hd);
			}
			return ds;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
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
	}
	public long insertHD(dathangBean dh) {
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			String sql = " insert into HoaDon(maKh,ngayMua,trangthai) values(?,?,?) ";
			statement = KetNoiDao.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setLong(1, dh.getMakh());
			statement.setDate(2, new Date(dh.getNgaymua().getTime()));
			statement.setBoolean(3, false);
			if (statement.executeUpdate() > 0) {
				rs = statement.getGeneratedKeys();
				long temp = 0;
				if (rs.next()) {
					temp = rs.getLong(1);
				}
				return temp;
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
		return -1;
	}
	public long insertCTHD(lichsuBean ls) {
		PreparedStatement statement = null;
		PreparedStatement statement2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		try {
			String sql1 = "select count(*) from Giay where maGiay = ? and soLuong >= ?";
			statement2 = KetNoiDao.connection.prepareStatement(sql1);
			statement2.setString(1, ls.getMagiay());
			statement2.setLong(2, ls.getSoluong());
			rs2 = statement2.executeQuery();
			if (rs2.next()) {
				if (rs2.getInt(1) > 0) {
					String sql = "insert into ChiTietHoaDon(maHD,maGiay,soLuong, trangthai) values(?,?,?,?)";
					statement = KetNoiDao.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
					statement.setLong(1, ls.getMahd());
					statement.setString(2, ls.getMagiay());
					statement.setInt(3, ls.getSoluong());
					statement.setBoolean(4, false);
					if (statement.executeUpdate() > 0) {
						rs = statement.getGeneratedKeys();
						if (rs.next()) {
							return rs.getLong(1);
						}
					}
				} else {
					return -1;
				}
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
		return -1;
	}
	public int thanhtoanHD(String mahd) {
		PreparedStatement statement = null;
		ResultSet rs = null;
		PreparedStatement statement1 = null;
		ResultSet rs1 = null;
		try {
			String sql1 = "select count(trangthai) from ChiTietHoaDon where maHD = ? and trangthai = 0";
			statement1 = KetNoiDao.connection.prepareStatement(sql1);
			statement1.setLong(1, Long.parseLong(mahd));
			rs1 = statement1.executeQuery();
			if (rs1.next()) {
				if (rs1.getInt(1) == 0) {
					String sql = "update HoaDon set trangthai = 1\r\n" + "where maHD= ?";
					statement = KetNoiDao.connection.prepareStatement(sql);
					statement.setLong(1, Long.parseLong(mahd));
					return statement.executeUpdate();
				} else
					return -1;
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
		return -1;
	}
	public int chitiettthd(String macthd) {
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {

			String sql = "update ChiTietHoaDon set trangthai = 1\r\n" + "where maCTHD = ?";
			statement = KetNoiDao.connection.prepareStatement(sql);
			statement.setLong(1, Long.parseLong(macthd));
			return statement.executeUpdate();

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
		return -1;
	}

}
