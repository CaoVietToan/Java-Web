package bo;

import bean.TaiKhoanBean;
import dao.TaiKhoandao;

public class TaiKhoanBo {
	private TaiKhoandao accountDao = new TaiKhoandao();

	public TaiKhoanBean checkAdminLogin(String username, String pass) {
		return accountDao.checkAdminLogin(username, pass);
	}

}
