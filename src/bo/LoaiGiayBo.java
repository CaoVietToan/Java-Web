package bo;

import java.util.List;

import bean.loaiBean;
import dao.LoaiGiayDao;


public class LoaiGiayBo {
	LoaiGiayDao loaiDao = new LoaiGiayDao();

    public List<loaiBean> getLoai() {
        return loaiDao.getLoai();
    }
    
    public static void main(String[] args) {
    	LoaiGiayBo lbo = new LoaiGiayBo();
		for(loaiBean c : lbo.getLoai()) {
			System.out.println(c.getTenLoai());
		}
	}

}
