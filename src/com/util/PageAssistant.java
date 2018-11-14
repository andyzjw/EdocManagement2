package com.util;

public class PageAssistant {
	/** 页面大小 */
	private int pageSize = 5;
	/** 当前页码 */
	private int currPage=1;
	/** 记录的起始编号 */
	private int identifier;
	/** 总页数 */
	private int totalPage;
	/** 总记录数 */
	private int count;

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		setTotalPage();
		setIdentifier();
	}

	public int getTotalPage() {
		return totalPage;
	}

	private void setTotalPage() {
		totalPage = count / pageSize;
		if (count % pageSize != 0) {
			totalPage++;
		}
	}

	public int getIdentifier() {
		return identifier;
	}

	private void setIdentifier() {
		identifier = (currPage - 1) * pageSize;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
		setIdentifier();
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
		setTotalPage();
	}

}
