package com.cong.dao;

import java.util.List;

import com.cong.domain.Report;

public interface IReportDao {
	public List<Report> findAll(String customno,String salid,String goodsname,String lotno);
	//public List<Report> findAll(String salid);
	//public List<Report> findAll(String customno,String lotno);
}
