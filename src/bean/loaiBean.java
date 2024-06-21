package bean;

public class loaiBean {
	private String maLoai;
	private String tenLoai;
	/**
	 * @return the maLoai
	 */
	public String getMaLoai() {
		return maLoai;
	}
	/**
	 * @param maLoai the maLoai to set
	 */
	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}
	/**
	 * @return the tenLoai
	 */
	public String getTenLoai() {
		return tenLoai;
	}
	/**
	 * @param tenLoai the tenLoai to set
	 */
	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}
	public loaiBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public loaiBean(String maLoai, String tenLoai) {
		super();
		this.maLoai = maLoai;
		this.tenLoai = tenLoai;
	}
	

}
