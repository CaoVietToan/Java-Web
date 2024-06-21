package bean;

import java.util.Date;

public class dathangBean {
	private Long mahd;
	private Long makh;
	private String tenkh;
	private Date ngaymua;
	private boolean trangthai;
	private Long thanhtien;
	/**
	 * @return the mahd
	 */
	public Long getMahd() {
		return mahd;
	}
	/**
	 * @param mahd the mahd to set
	 */
	public void setMahd(Long mahd) {
		this.mahd = mahd;
	}
	/**
	 * @return the makh
	 */
	public Long getMakh() {
		return makh;
	}
	/**
	 * @param makh the makh to set
	 */
	public void setMakh(Long makh) {
		this.makh = makh;
	}
	/**
	 * @return the tenkh
	 */
	public String getTenkh() {
		return tenkh;
	}
	/**
	 * @param tenkh the tenkh to set
	 */
	public void setTenkh(String tenkh) {
		this.tenkh = tenkh;
	}
	/**
	 * @return the ngaymua
	 */
	public Date getNgaymua() {
		return ngaymua;
	}
	/**
	 * @param ngaymua the ngaymua to set
	 */
	public void setNgaymua(Date ngaymua) {
		this.ngaymua = ngaymua;
	}
	/**
	 * @return the trangthai
	 */
	public boolean isTrangthai() {
		return trangthai;
	}
	/**
	 * @param trangthai the trangthai to set
	 */
	public void setTrangthai(boolean trangthai) {
		this.trangthai = trangthai;
	}
	/**
	 * @return the thanhtien
	 */
	public Long getThanhtien() {
		return thanhtien;
	}
	/**
	 * @param thanhtien the thanhtien to set
	 */
	public void setThanhtien(Long thanhtien) {
		this.thanhtien = thanhtien;
	}
	public dathangBean(Long mahd, Long makh, String tenkh, Date ngaymua, boolean trangthai, Long thanhtien) {
		super();
		this.mahd = mahd;
		this.makh = makh;
		this.tenkh = tenkh;
		this.ngaymua = ngaymua;
		this.trangthai = trangthai;
		this.thanhtien = thanhtien;
	}
	public dathangBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
