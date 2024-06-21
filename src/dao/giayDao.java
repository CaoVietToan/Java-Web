package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.giayBean;
import bean.giayPT;
import bean.hangBean;
import bean.loaiBean;
import bean.sexBean;

public class giayDao {
	public ArrayList<giayBean> getGiay() {
		ArrayList<giayBean> ds = new ArrayList<giayBean>();
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			String sql = " select * \r\n"
					+ "from Giay join HangGiay \r\n"
					+ "on Giay.maHang=HangGiay.maHang join LoaiGiay \r\n"
					+ "on Giay.maLoai=LoaiGiay.maLoai join Sex\r\n"
					+ "on Giay.maGT=Sex.maGT\r\n";
			statement = KetNoiDao.connection.prepareStatement(sql);
			rs = statement.executeQuery();
			while (rs.next()) {
				giayBean giaybean = new giayBean();
				giaybean.setMaGiay(rs.getString("maGiay"));
				giaybean.setAnh(rs.getString("anh"));
				giaybean.setTenGiay(rs.getString("tenGiay"));
				giaybean.setMota(rs.getString("mota"));
				giaybean.setSoLuong(rs.getLong("soLuong"));
				giaybean.setGia(rs.getLong("gia"));
				giaybean.setMaLoai(rs.getString("tenLoai"));
				giaybean.setMaHang(rs.getString("tenHang"));
				ds.add(giaybean);
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
	public giayPT getshoesPagination(int page) {
		ArrayList<giayBean> list = new ArrayList<giayBean>();
		PreparedStatement statement = null;
		PreparedStatement statement2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		int size = 6;
		giayPT giaypt = new giayPT();
		try {
			String sql = " select Giay.maGiay, tenGiay,mota,gia,anh , tenloai, tenhang, gioiTinh\r\n"
					+ "from Giay join HangGiay \r\n"
					+ "on Giay.maHang=HangGiay.maHang join LoaiGiay \r\n"
					+ "on Giay.maLoai=LoaiGiay.maLoai join Sex\r\n"
					+ "on giay.maGT=Sex.maGT \r\n"
					+ "order by tenGiay " + " OFFSET ? ROWS\r\n "
					+ " FETCH NEXT ? ROWS ONLY ";
			statement = KetNoiDao.connection.prepareStatement(sql);
			statement.setInt(1, (page - 1) * size);
			statement.setInt(2, size);
			rs = statement.executeQuery();
			while (rs.next()) {
				giayBean giayBean = new giayBean();
				giayBean.setMaGiay(rs.getString("maGiay"));
				giayBean.setTenGiay(rs.getString("tenGiay"));
				giayBean.setMota(rs.getString("mota"));
				giayBean.setGia(rs.getLong("gia"));
				giayBean.setAnh(rs.getString("anh"));
				loaiBean loaiBean = new loaiBean();
				loaiBean.setTenLoai("tenLoai");
				hangBean hangBean = new hangBean();
				hangBean.setTenHang("tenHang");
				sexBean gt = new sexBean();
				gt.setGioiTinh(rs.getString("gioiTinh"));
				list.add(giayBean);
			}
			giaypt.setList(list);

			String sql2 = " select count(*)\r\n "
					+ " from Giay ";
			statement2 = KetNoiDao.connection.prepareStatement(sql2);
			rs2 = statement2.executeQuery();
			int count = 0;
			while (rs2.next())
				count = rs2.getInt(1);
			giaypt.setTotalPage((count % size == 0) ? count / size : (count / size) + 1);
			return giaypt;
		} catch (SQLException e) {
			e.printStackTrace();
			return new giayPT();
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
	public int updateQuantityShoes(String shoesId, long quantity) {
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			String sql = "update Size set soLuong = ? \r\n"
					+ "from Size join Giay on Size.maGiay=Giay.maGiay\r\n"
					+ "where Size.maGiay=?";
			statement = KetNoiDao.connection.prepareStatement(sql);
			statement.setLong(1, quantity);
			statement.setString(2, shoesId);
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
	public giayPT findbyLoai(String loaiId, int page) {
		PreparedStatement statement = null;
		PreparedStatement statement2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		giayPT giaypt = new giayPT();
		int size = 6;
		List<giayBean> list = new ArrayList<>();
		try {
			String sql = " select Giay.maGiay, tenGiay,mota,gia,anh,tenloai,tenhang,gioiTinh\r\n "
					+ " from Giay join HangGiay \r\n "
					+ " on Giay.maHang=HangGiay.maHang join LoaiGiay \r\n "
					+ " on Giay.maLoai=LoaiGiay.maLoai join Sex\r\n "
					+ " on giay.maGT=Sex.maGT where Giay.maLoai = ?\r\n "
					+ " order by tenGiay " + " OFFSET ? ROWS\r\n "
					+ " FETCH NEXT ? ROWS ONLY ";
			statement = KetNoiDao.connection.prepareStatement(sql);
			statement.setString(1, loaiId);
			statement.setInt(2, (page - 1) * size);
			statement.setInt(3, size);
			rs = statement.executeQuery();
			while (rs.next()) {
				giayBean giayBean = new giayBean();
				giayBean.setMaGiay(rs.getString("maGiay"));
				giayBean.setTenGiay(rs.getString("tenGiay"));
				giayBean.setMota(rs.getString("mota"));
				giayBean.setGia(rs.getLong("gia"));
				giayBean.setAnh(rs.getString("anh"));
				loaiBean loaiBean = new loaiBean();
				loaiBean.setTenLoai("tenLoai");
				hangBean hangBean = new hangBean();
				hangBean.setTenHang("tenHang");
				sexBean gt = new sexBean();
				gt.setGioiTinh(rs.getString("gioiTinh"));
				list.add(giayBean);
			}
			giaypt.setList(list);
			String sql2 = "select count(*)\r\n"
					+ "from Giay join LoaiGiay \r\n"
					+ "on Giay.maLoai=LoaiGiay.maLoai WHERE Giay.maLoai= ?";
			statement2 = KetNoiDao.connection.prepareStatement(sql2);
			statement2.setString(1, loaiId);
			rs2 = statement2.executeQuery();
			int count = 0;
			while (rs2.next())
				count = rs2.getInt(1);
			giaypt.setTotalPage((count % size == 0) ? count / size : (count / size) + 1);
			return giaypt;
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
	public giayPT findbyHang(String hangId, int page) {
		PreparedStatement statement = null;
		PreparedStatement statement2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		giayPT giaypt = new giayPT();
		int size = 6;
		List<giayBean> list = new ArrayList<>();
		try {
			String sql = " select Giay.maGiay, tenGiay,mota,gia,anh , tenloai, tenhang, gioiTinh\r\n"
					+ "from Giay join HangGiay \r\n"
					+ "on Giay.maHang=HangGiay.maHang join LoaiGiay \r\n"
					+ "on Giay.maLoai=LoaiGiay.maLoai join Sex\r\n"
					+ "on giay.maGT=Sex.maGT where Giay.maHang=? \r\n"
					+ "order by tenGiay " + " OFFSET ? ROWS\r\n "
					+ " FETCH NEXT ? ROWS ONLY ";
			statement = KetNoiDao.connection.prepareStatement(sql);
			statement.setString(1, hangId);
			statement.setInt(2, (page - 1) * size);
			statement.setInt(3, size);
			rs = statement.executeQuery();
			while (rs.next()) {
				giayBean giayBean = new giayBean();
				giayBean.setMaGiay(rs.getString("maGiay"));
				giayBean.setTenGiay(rs.getString("tenGiay"));
				giayBean.setMota(rs.getString("mota"));
				giayBean.setGia(rs.getLong("gia"));
				giayBean.setAnh(rs.getString("anh"));
				loaiBean loaiBean = new loaiBean();
				loaiBean.setTenLoai("tenLoai");
				hangBean hangBean = new hangBean();
				hangBean.setTenHang("tenHang");
				sexBean gt = new sexBean();
				gt.setGioiTinh(rs.getString("gioiTinh"));
				list.add(giayBean);
			}
			giaypt.setList(list);
			String sql2 = "select count(*)\r\n"
					+ "from Giay join HangGiay \r\n"
					+ "on Giay.maHang=HangGiay.maHang WHERE Giay.maHang= ?";
			statement2 = KetNoiDao.connection.prepareStatement(sql2);
			statement2.setString(1, hangId);
			rs2 = statement2.executeQuery();
			int count = 0;
			while (rs2.next())
				count = rs2.getInt(1);
			giaypt.setTotalPage((count % size == 0) ? count / size : (count / size) + 1);
			return giaypt;
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

	public ArrayList<giayBean> searchShoes(String search) {
		ArrayList<giayBean> ds = new ArrayList<giayBean>();
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			String sql = "select Giay.maGiay, tenGiay,mota,gia,anh , tenloai, tenhang, gioiTinh\r\n"
					+ "from Giay join HangGiay \r\n"
					+ "on Giay.maHang=HangGiay.maHang join LoaiGiay \r\n"
					+ "on Giay.maLoai=LoaiGiay.maLoai join Sex\r\n"
					+ "on giay.maGT=Sex.maGT\r\n"
					+ " where tenGiay like ? OR tenLoai like ? OR tenHang like ? \r\n"
					+ "order by tenGiay";
			statement = KetNoiDao.connection.prepareStatement(sql);
			statement.setString(1, "%" + search + "%");
			statement.setString(2, "%" + search + "%");
			statement.setString(3, "%" + search + "%");
			rs = statement.executeQuery();
			while (rs.next()) {
				giayBean giayBean = new giayBean();
				giayBean.setMaGiay(rs.getString("maGiay"));
				giayBean.setTenGiay(rs.getString("tenGiay"));
				giayBean.setMota(rs.getString("mota"));
				giayBean.setGia(rs.getLong("gia"));
				giayBean.setAnh(rs.getString("anh"));
				loaiBean loaiBean = new loaiBean();
				loaiBean.setTenLoai("tenLoai");
				hangBean hangBean = new hangBean();
				hangBean.setTenHang("tenHang");
				sexBean gt = new sexBean();
				gt.setGioiTinh(rs.getString("gioiTinh"));
				ds.add(giayBean);
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
	public int addGiay(String maGiay,String tenGiay, Long soLuong, String mota, Long gia, String anh, String maLoai,String maHang,String maGT) throws SQLException {
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
				String sql = "insert into Giay(maGiay,tenGiay,mota,gia,anh,maLoai,maHang,maGT,soLuong) values(?,?,?,?,?,?,?,?,?)";
				statement = KetNoiDao.connection.prepareStatement(sql);
				statement.setString(1,maGiay);
				statement.setString(2, tenGiay);
				statement.setString(3, mota);
				statement.setLong(4, gia);
				statement.setString(5, anh);
				statement.setString(6, maLoai);
				statement.setString(7, maHang);
				statement.setLong(9,soLuong);
				statement.setString(8,maGT);
				return statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (rs != null) {
				rs.close();
			}
		}
		return -1;
	}

}
