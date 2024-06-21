package bean;

import java.util.Date;

public class cthdBean {
	private Long mahd;
	private Long macthd;
	private String tengiay;
	private String anh;
	private Date ngaymua;
	private long soluong;
	private long gia;
	private long thanhtien;
	private boolean trangthai;
	private long size;
	private String gioitinh;
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
	 * @return the macthd
	 */
	public Long getMacthd() {
		return macthd;
	}
	/**
	 * @param macthd the macthd to set
	 */
	public void setMacthd(Long macthd) {
		this.macthd = macthd;
	}
	/**
	 * @return the tengiay
	 */
	public String getTengiay() {
		return tengiay;
	}
	/**
	 * @param tengiay the tengiay to set
	 */
	public void setTengiay(String tengiay) {
		this.tengiay = tengiay;
	}
	/**
	 * @return the and
	 */
	public String getAnh() {
		return anh;
	}
	/**
	 * @param and the and to set
	 */
	public void setAnh(String anh) {
		this.anh = anh;
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
	 * @return the soluong
	 */
	public long getSoluong() {
		return soluong;
	}
	/**
	 * @param soluong the soluong to set
	 */
	public void setSoluong(long soluong) {
		this.soluong = soluong;
	}
	/**
	 * @return the gia
	 */
	public long getGia() {
		return gia;
	}
	/**
	 * @param gia the gia to set
	 */
	public void setGia(long gia) {
		this.gia = gia;
	}
	/**
	 * @return the thanhtien
	 */
	public long getThanhtien() {
		return thanhtien;
	}
	/**
	 * @param thanhtien the thanhtien to set
	 */
	public void setThanhtien(long thanhtien) {
		this.thanhtien = thanhtien;
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
	 * @return the size
	 */
	public long getSize() {
		return size;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(long size) {
		this.size = size;
	}
	/**
	 * @return the gioitinh
	 */
	public String getGioitinh() {
		return gioitinh;
	}
	/**
	 * @param gioitinh the gioitinh to set
	 */
	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}
	public cthdBean(Long mahd, Long macthd, String tengiay, String anh, Date ngaymua, long soluong, long gia,
			long thanhtien, boolean trangthai, long size, String gioitinh) {
		super();
		this.mahd = mahd;
		this.macthd = macthd;
		this.tengiay = tengiay;
		this.anh = anh;
		this.ngaymua = ngaymua;
		this.soluong = soluong;
		this.gia = gia;
		this.thanhtien = thanhtien;
		this.trangthai = trangthai;
		this.size = size;
		this.gioitinh = gioitinh;
	}
	public cthdBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
