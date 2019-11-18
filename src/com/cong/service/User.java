package com.cong.service;

public class User {
	private String companyno;		//pub_company表中的客户编码，对应loign表单的userno
	private String companyname;		//pub_company表中的客户名称
	private String ucompanyno;		//pub_company表中的统一码，对应loign表单的password
	
	public String getCompanyno() {
		return companyno;
	}
	public void setCompanyno(String companyno) {
		this.companyno = companyno;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getUcompanyno() {
		return ucompanyno;
	}
	public void setUcompanyno(String ucompanyno) {
		this.ucompanyno = ucompanyno;
	}
	@Override
	public String toString() {
		return "User [companyno=" + companyno + ", companyname=" + companyname + ", ucompanyno=" + ucompanyno + "]";
	}
	
	
	
}
