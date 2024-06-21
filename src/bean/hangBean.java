package bean;

public class hangBean {
	private String maHang;
	private String tenHang;
	/**
	 * @return the maHang
	 */
	public String getMaHang() {
		return maHang;
	}
	/**
	 * @param maHang the maHang to set
	 */
	public void setMaHang(String maHang) {
		this.maHang = maHang;
	}
	/**
	 * @return the tenHang
	 */
	public String getTenHang() {
		return tenHang;
	}
	/**
	 * @param tenHang the tenHang to set
	 */
	public void setTenHang(String tenHang) {
		this.tenHang = tenHang;
	}
	public hangBean(String maHang, String tenHang) {
		super();
		this.maHang = maHang;
		this.tenHang = tenHang;
	}
	public hangBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
