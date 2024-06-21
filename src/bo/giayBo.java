package bo;

import java.util.ArrayList;

import bean.giayBean;
import bean.giayPT;
import dao.giayDao;

public class giayBo {
	private giayDao giaydao = new giayDao();
	
	public ArrayList<giayBean> getGiay(){
		return giaydao.getGiay();
	}
	public ArrayList<giayBean> searchShoes(String search) {
		return giaydao.searchShoes(search);
	}

	public giayPT getshoesPagination(int page) {
		return giaydao.getshoesPagination(page);
	}

	public int updateQuantityShoes(String bookId, long quantity) {
		return giaydao.updateQuantityShoes(bookId, quantity);
	}

	public giayPT findbyLoai(String loaiid, int page) {
		return giaydao.findbyLoai(loaiid, page);
	}

	public giayPT findbyHang(String hangid, int page) {
		return giaydao.findbyHang(hangid, page);
	}
	public int addGiay(String maGiay,String tenGiay, Long soLuong, String mota, Long gia, String anh, String maLoai,String maHang,String maGT) throws Exception {
		return giaydao.addGiay(maGiay, tenGiay, soLuong, mota, gia, anh, maLoai, maHang,maGT);
	}


}
