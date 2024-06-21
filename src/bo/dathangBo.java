package bo;

import java.util.ArrayList;

import bean.cthdBean;
import bean.dathangBean;
import bean.lichsuBean;
import dao.dathangDao;

public class dathangBo {
	public dathangDao dhdao = new dathangDao();
	public ArrayList<dathangBean> getHD() {
		return dhdao.getHD();
	}

	public ArrayList<dathangBean> getHD_makh(Long makh) {
		return dhdao.getHD_makh(makh);
	}

	public ArrayList<cthdBean> getCTHD(String mahd) {
		return dhdao.getCTHD(mahd);
	}

	public long insertHD(dathangBean dhbean) {
		return dhdao.insertHD(dhbean);
	}

	public long insertCTHD(lichsuBean cthdbean) {
		return dhdao.insertCTHD(cthdbean);
	}

	public int chitiettthd(String macthd) {
		return dhdao.chitiettthd(macthd);
	}

	public void thanhtoanHD(String mahd) {
		dhdao.thanhtoanHD(mahd);
	}

}
