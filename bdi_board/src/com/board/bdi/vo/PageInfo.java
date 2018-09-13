package com.board.bdi.vo;

public class PageInfo {
	private Integer page = 1;
	private Integer rowCnt = 10;
	private Integer blockCnt = 10;
	private Integer totalCnt;
	private Integer limitFNum = 0;
	private Integer limitLnum = 10;
	private Integer totalPage;
	private Integer totalBlock;
	private Integer sBlock;
	private Integer eBlock;
	
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getTotalBlock() {
		return totalBlock;
	}
	public void setTotalBlock(Integer totalBlock) {
		this.totalBlock = totalBlock;
	}
	public Integer getsBlock() {
		return sBlock;
	}
	public void setsBlock(Integer sBlock) {
		this.sBlock = sBlock;
	}
	public Integer geteBlock() {
		return eBlock;
	}
	public void seteBlock(Integer eBlock) {
		this.eBlock = eBlock;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRowCnt() {
		return rowCnt;
	}
	public void setRowCnt(Integer rowCnt) {
		this.rowCnt = rowCnt;
	}
	public Integer getBlockCnt() {
		return blockCnt;
	}
	public void setBlockCnt(Integer blockCnt) {
		this.blockCnt = blockCnt;
	}
	public Integer getTotalCnt() {
		return totalCnt;
	}
	public void setTotalCnt(Integer totalCnt) {
		this.totalCnt = totalCnt;
	}
	public Integer getLimitFNum() {
		return limitFNum;
	}
	public void setLimitFNum(Integer limitFNum) {
		this.limitFNum = limitFNum;
	}
	public Integer getLimitLnum() {
		return limitLnum;
	}
	public void setLimitLnum(Integer limitLnum) {
		this.limitLnum = limitLnum;
	}
	
	public void pageCount() {
		if(totalCnt==null) {
			//TODO 에러처리 필요
			
		}
		
		totalPage = (int)(Math.ceil((double)totalCnt/rowCnt));
		totalBlock = (int)(Math.ceil((double)totalPage/blockCnt));
		limitFNum = (page-1) * rowCnt;
		sBlock = ((int)(Math.ceil((double)page/blockCnt))-1) * 10 + 1;
		eBlock = sBlock+blockCnt-1;
		if(eBlock>totalPage) {
			eBlock = totalPage;
		}
	}
	public static void main(String[] args) {
		PageInfo pi = new PageInfo();
		pi.setTotalCnt(11008);
		pi.setPage(22);
		pi.pageCount();
	}
}
