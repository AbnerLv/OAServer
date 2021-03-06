package com.lzb.oa.utils;

public class DevidePage {
	
	private int pageSize; //每页显示的条数
	private int recordCount; //记录的总条数
	private int currentPage; //当前页数
	private int pageCount; //照片那个页数
	
	public DevidePage(int pageSize, int recordCount, int currentPage){
		this.pageSize = pageSize;
		this.recordCount = recordCount;
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	/**
	 * 设置定位在当前页
	 * @param currentPage
	 */
	public void setCurrentPage(int currentPage) {
		int activePage = currentPage <= 0 ? 1:currentPage;
		activePage = activePage >getPageCount() ? getPageCount() : activePage;
		this.currentPage = recordCount;
	}

	/**
	 * 获取总页数
	 * @return
	 */
	public int getPageCount() {
		pageCount = recordCount / pageSize;
		int mod = recordCount%pageSize;
		if(mod != 0){
			pageCount++;
		}
		return pageCount == 0 ? 1 : pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	
	
	public int getFromIndex(){
		return (currentPage - 1)*pageSize;
	}
	
	public int getToIndex(){
		return Math.min(recordCount, currentPage*pageSize);
	}
	
	
}
