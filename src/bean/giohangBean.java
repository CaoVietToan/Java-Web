package bean;

public class giohangBean {
	private String maGiay;
	private String tenGiay;
	private String anh;
	private long soLuong;
	private long gia;
	@SuppressWarnings("unused")
	private long thanhtien;
	public giohangBean(String maGiay, String tenGiay, String anh, long soLuong, long gia) {
		super();
		this.maGiay = maGiay;
		this.tenGiay = tenGiay;
		this.anh = anh;
		this.soLuong = soLuong;
		this.gia = gia;
	}
	public giohangBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the maGiay
	 */
	public String getMaGiay() {
		return maGiay;
	}
	/**
	 * @param maGiay the maGiay to set
	 */
	public void setMaGiay(String maGiay) {
		this.maGiay = maGiay;
	}
	/**
	 * @return the tenGiay
	 */
	public String getTenGiay() {
		return tenGiay;
	}
	/**
	 * @param tenGiay the tenGiay to set
	 */
	public void setTenGiay(String tenGiay) {
		this.tenGiay = tenGiay;
	}
	/**
	 * @return the anh
	 */
	public String getAnh() {
		return anh;
	}
	/**
	 * @param anh the anh to set
	 */
	public void setAnh(String anh) {
		this.anh = anh;
	}
	/**
	 * @return the soLuong
	 */
	public long getSoLuong() {
		return soLuong;
	}
	/**
	 * @param soLuong the soLuong to set
	 */
	public void setSoLuong(long soLuong) {
		this.soLuong = soLuong;
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
		return soLuong*gia;
	}
	/**
	 * @param thanhtien the thanhtien to set
	 */
	

}
