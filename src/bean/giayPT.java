package bean;

import java.util.ArrayList;
import java.util.List;

public class giayPT {
	private List<giayBean> list = new ArrayList<>();
	private int page;
	private int totalPage;
	private int size;

	public List<giayBean> getList() {
		return list;
	}

	public void setList(List<giayBean> list) {
		this.list = list;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public giayPT(List<giayBean> list, int page, int totalPage, int size) {
		super();
		this.list = list;
		this.page = page;
		this.totalPage = totalPage;
		this.size = size;
	}

	public giayPT() {
		super();
	}


}
