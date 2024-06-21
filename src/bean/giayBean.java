package bean;

public class giayBean {
	private String maGiay;
	private String tenGiay;
	private String mota;
	private long soLuong;
	private long gia;
	private String anh;
	private long maSize;
	private boolean maGT;
	private String maHang;
	private String maLoai;
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
	 * @return the mota
	 */
	public String getMota() {
		return mota;
	}
	/**
	 * @param mota the mota to set
	 */
	public void setMota(String mota) {
		this.mota = mota;
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
	 * @return the maSize
	 */
	public long getMaSize() {
		return maSize;
	}
	/**
	 * @param maSize the maSize to set
	 */
	public void setMaSize(long maSize) {
		this.maSize = maSize;
	}
	/**
	 * @return the maGT
	 */
	public boolean isMaGT() {
		return maGT;
	}
	/**
	 * @param maGT the maGT to set
	 */
	public void setMaGT(boolean maGT) {
		this.maGT = maGT;
	}
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
	public giayBean(String maGiay, String tenGiay, String mota, long soLuong, long gia, String anh, long maSize,
			boolean maGT, String maHang, String maLoai) {
		super();
		this.maGiay = maGiay;
		this.tenGiay = tenGiay;
		this.mota = mota;
		this.soLuong = soLuong;
		this.gia = gia;
		this.anh = anh;
		this.maSize = maSize;
		this.maGT = maGT;
		this.maHang = maHang;
		this.maLoai = maLoai;
	}
	public giayBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
