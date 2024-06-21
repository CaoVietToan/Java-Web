package bean;

public class sexBean {
	private String maGT;
	private String gioiTinh;
	/**
	 * @return the maGT
	 */
	public String getMaGT() {
		return maGT;
	}
	/**
	 * @param maGT the maGT to set
	 */
	public void setMaGT(String maGT) {
		this.maGT = maGT;
	}
	/**
	 * @return the gioiTinh
	 */
	public String getGioiTinh() {
		return gioiTinh;
	}
	/**
	 * @param gioiTinh the gioiTinh to set
	 */
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public sexBean(String maGT, String gioiTinh) {
		super();
		this.maGT = maGT;
		this.gioiTinh = gioiTinh;
	}
	public sexBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
