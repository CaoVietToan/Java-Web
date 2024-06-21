package bean;

public class sizeBean {
	private String maSize;
	private int size;
	/**
	 * @return the maSize
	 */
	public String getMaSize() {
		return maSize;
	}
	/**
	 * @param maSize the maSize to set
	 */
	public void setMaSize(String maSize) {
		this.maSize = maSize;
	}
	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}
	public sizeBean(String maSize, int size) {
		super();
		this.maSize = maSize;
		this.size = size;
	}
	public sizeBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
