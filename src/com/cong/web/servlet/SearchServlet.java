package com.cong.web.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cong.dao.impl.ReportDaoImpl;
import com.cong.domain.Report;
import com.cong.domain.User;

@WebServlet(urlPatterns = "/searchServlet")
public class SearchServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");	//设置编码
		
		User login_user = (User) request.getSession().getAttribute("login_user");	//获取登录客户的信息
		String customno = login_user.getCompanyno();	//获取登录客户的客户编码
		String salid = request.getParameter("salid");	//获取销售单ID
		String goodsname = request.getParameter("goodsname");	//获取商品名称
		String lotno = request.getParameter("lotno");		//获取商品批号
		
		//
		List<Report> report = new ReportDaoImpl().findAll(customno, salid, goodsname, lotno);
		System.out.println(report.isEmpty());
		Iterator<Report> iter = report.iterator();
		while(iter.hasNext()) {
			Report s = iter.next();
			System.out.print(s.getGoodsname() + "--->");
			System.out.print(s.getFactoryname()  + "--->" );
			System.out.println(s.getLotno());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
