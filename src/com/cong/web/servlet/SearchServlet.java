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
import com.cong.web.util.ResultInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(urlPatterns = "/searchServlet")
public class SearchServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");	//设置编码
		
		User login_user = (User) request.getSession().getAttribute("user");	//获取登录客户的信息
		String customno = login_user.getCompanyno();	//获取登录客户的客户编码
		String salid = request.getParameter("salid");	//获取销售单ID
		String goodsname = request.getParameter("goodsname");	//获取商品名称
		String lotno = request.getParameter("lotno");		//获取商品批号
		
		//实例化错误信息对象以及json对象序列化的ObjectMapper对象
		ResultInfo info = new ResultInfo();
		ObjectMapper mapper = new ObjectMapper();
		
		//通过用户编码、销售单ID、商品名称、批号查询检验报告所需要的信息
		List<Report> report = new ReportDaoImpl().findAll(customno, salid, goodsname, lotno);
		if(report.isEmpty()) {
			info.setFlag(false);
			info.setErrorMsg("无销售记录");
			String json = mapper.writeValueAsString(info);
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().write(json);
			return;
		}else {
			//将List集合转换成json
			String json = mapper.writeValueAsString(report);
			response.setContentType("application/json;charset=utf-8");
			System.out.println(json);
			return;
		}
		
		
		
		
		/*
		 * System.out.println(report.isEmpty()); Iterator<Report> iter =
		 * report.iterator(); while(iter.hasNext()) { Report s = iter.next();
		 * System.out.print(s.getGoodsname() + "--->");
		 * System.out.print(s.getFactoryname() + "--->" );
		 * System.out.println(s.getLotno()); }
		 */
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
