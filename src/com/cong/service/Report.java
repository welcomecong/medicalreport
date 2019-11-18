package com.cong.service;

public class Report {
	
	private String goodsname;		//商品名称
	private String factoryname;		//生产厂家
	private String lotno;			//商品批号
	
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public String getFactoryname() {
		return factoryname;
	}
	public void setFactoryname(String factoryname) {
		this.factoryname = factoryname;
	}
	public String getLotno() {
		return lotno;
	}
	public void setLotno(String lotno) {
		this.lotno = lotno;
	}
	@Override
	public String toString() {
		return "Report [goodsname=" + goodsname + ", factoryname=" + factoryname + ", lotno=" + lotno + "]";
	}
	
}
