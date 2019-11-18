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
import com.cong.service.Report;
import com.cong.service.User;

@WebServlet(urlPatterns = "/searchServlet")
public class SearchServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		User login_user = (User) request.getSession().getAttribute("login_user");
		System.out.println(login_user.getCompanyname());
		String customno = login_user.getCompanyno();
		String salid = request.getParameter("salid");
		String goodsname = request.getParameter("goodsname");
		String lotno = request.getParameter("lotno");
		System.out.println(customno);
		System.out.println(salid);
		System.out.println(goodsname);
		System.out.println(lotno);
		List<Report> report = new ReportDaoImpl().findAll(customno, salid, goodsname, lotno);
		System.out.println(report.isEmpty());
		Iterator<Report> iter = report.iterator();
		while(iter.hasNext()) {
			Report s = iter.next();
			System.out.println(s.getLotno());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
