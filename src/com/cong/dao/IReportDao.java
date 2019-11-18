package com.cong.dao;

import java.util.List;

import com.cong.service.Report;

public interface IReportDao {
	public List<Report> findAll(String customno,String salid,String goodsname,String lotno);
}
