package com.cong.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cong.dao.IUserDao;
import com.cong.service.User;
import com.cong.util.OracleConnection;

public class UserDaoImpl implements IUserDao{
	
	private Connection conn = OracleConnection.getConnection();		//数据库连接对象
	PreparedStatement pstmt = null;		//操作数据库对象
	ResultSet rs = null;		//数据库查询对象
	
	/**
	 * 通过输入的用户名和密码查出相对应的客户信息，并保存在User中
	 * 
	 */
	@Override
	public User findCompanyname(String companyno,String ucompanyno) {
		//List<User> all = new ArrayList<User>();
		String sql = "select companyname from pub_company where companyno = ? and ucompanyno = ?";
		User user = null;
		try {
			this.pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, companyno);
			pstmt.setString(2, ucompanyno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				user = new User();
				user.setCompanyno(companyno);
				user.setCompanyname(rs.getString(1));
				user.setUcompanyno(ucompanyno);
				//all.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			OracleConnection.close(rs, pstmt, conn);
		}
		return user;
	}

}
