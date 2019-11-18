package com.cong.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cong.dao.IReportDao;
import com.cong.service.Report;
import com.cong.util.OracleConnection;

public class ReportDaoImpl implements IReportDao{

	private Connection conn = OracleConnection.getConnection();		//数据库连接对象
	PreparedStatement pstmt = null;		//操作数据库对象
	ResultSet rs = null;		//数据库查询对象
	
	/*
	 * 	从"EBMS_SAL_HISTORY_V"视图中查询数据
	 * 客户只能查询自己的药检，所以查询条件添加了customno(客户编码)，销售单ID不支持模糊
	 * 我们的检验报告名称只有商品名称、厂家名称、批号，因此只需要从销售记录中获取这三个值
	 * */
	@Override
	public List<Report> findAll(String customno,String salid,String goodsname,String lotno) {
		List<Report> all = new ArrayList<Report>();
		String sql = "select goodsname,factoryname,lotno from EBMS_SAL_HISTORY_V where customno = ? and salid like ? "
				+ "and goodsname like ? and lotno like ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, customno);
			pstmt.setString(2, "%" + salid + "%");
			pstmt.setString(3, "%" + goodsname + "%");
			pstmt.setString(4, "%" + lotno + "%");
			rs = pstmt.executeQuery();
			Report report = null;
			while(rs.next()) {
				report = new Report();
				report.setGoodsname(rs.getString(1));
				report.setFactoryname(rs.getString(2));
				report.setLotno(rs.getString(3));
				all.add(report);
				//System.out.println(all);
			}
			//System.out.println(all);
			return all;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			OracleConnection.close(rs, pstmt, conn);
		}
		System.out.println(all);
		return all;
	}
	
	/*
	@Override
	public List<Report> findAll(String salid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Report> findAll(String customno, String lotno) {
		// TODO Auto-generated method stub
		return null;
	}
	*/
	
}
