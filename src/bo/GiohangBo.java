package bo;

import java.util.ArrayList;
import java.util.List;

import bean.giohangBean;

public class GiohangBo {
	public List<giohangBean> ds = new ArrayList<>();

    public void Them(String maGiay, String tenGiay, long soLuong, long gia,String anh ) {
        for (giohangBean s : ds) {
            if (s.getMaGiay().equals(maGiay)) {
                s.setSoLuong(s.getSoLuong() + 1);
                return;
            }
        }
        ds.add(new giohangBean(maGiay, tenGiay,anh, soLuong, gia));
    }

    public long tongTien() {
        long sum = 0;
        for (giohangBean s : ds) {
            sum += s.getThanhtien();
        }
        return sum;
    }

    public void Delete(String magiay) {
        for (giohangBean s : ds) {
            if (s.getMaGiay().equals(magiay)) {
                ds.remove(s);
                return;
            }
        }
    }

    public void update(String magiay, long quantity) {
        for (giohangBean s : ds) {
            if (s.getMaGiay().equals(magiay)) {
                s.setSoLuong(quantity);
                return;
            }
        }
    }

    public void quantityIncrease(String magiay) {
        for (giohangBean s : ds) {
            if (s.getMaGiay().equals(magiay)) {
                s.setSoLuong(s.getSoLuong() + 1);
                return;
            }
        }
    }

    public void quantityDecrease(String magiay) {
        for (giohangBean s : ds) {
            if (s.getMaGiay().equals(magiay)) {
                s.setSoLuong(s.getSoLuong() - 1);
                if (s.getSoLuong() == 0) ds.remove(s);
                return;
            }
        }
    }

    public void clearCart() {
        ds.clear();
    }

}
