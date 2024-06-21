package bo;

import java.util.List;

import bean.hangBean;
import dao.HangGiayDao;


public class HangGiayBo {
	HangGiayDao hangdao = new HangGiayDao();

    public List<hangBean> getHang() {
        return hangdao.getHang();
    }
    
    public static void main(String[] args) {
    	HangGiayBo hbo = new HangGiayBo();
		for(hangBean c : hbo.getHang()) {
			System.out.println(c.getTenHang());
		}
	}

}
