package bean;

public class KhachHangBean {
	private Long makh;
	private String hoten;
	private String diachi;
	private String sdt;
	private String email;
	private String username;
	private String password;
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
	 * @return the hoten
	 */
	public String getHoten() {
		return hoten;
	}
	/**
	 * @param hoten the hoten to set
	 */
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	/**
	 * @return the diachi
	 */
	public String getDiachi() {
		return diachi;
	}
	/**
	 * @param diachi the diachi to set
	 */
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	/**
	 * @return the sdt
	 */
	public String getSdt() {
		return sdt;
	}
	/**
	 * @param sdt the sdt to set
	 */
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	public KhachHangBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public KhachHangBean(Long makh, String hoten, String diachi, String sdt, String email, String username,
			String password) {
		super();
		this.makh = makh;
		this.hoten = hoten;
		this.diachi = diachi;
		this.sdt = sdt;
		this.email = email;
		this.username = username;
		this.password = password;
	}
	@Override
	public String toString() {
		return "KhachHangBean [makh=" + makh + ", hoten=" + hoten + ", diachi=" + diachi + ", sdt=" + sdt + ", email="
				+ email + ", username=" + username + ", password=" + password + "]";
	}
	
	

}
