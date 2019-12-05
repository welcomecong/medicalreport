package com.cong.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cong.dao.impl.UserDaoImpl;
import com.cong.domain.User;
import com.cong.web.util.ResultInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class LoginServelt
 */
@WebServlet(urlPatterns = "/loginServelt")
public class LoginServelt extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		//获取验证码并校验
		//1.获取客户输入的验证码
		String checkCode = request.getParameter("verifycode");
		//2.从session中获取CheckCodeServlet生成验证码
		HttpSession session = request.getSession();
		String checkCode_server = (String) session.getAttribute("CHECKCODE_SERVER");
		//3.判断
		if(checkCode_server == null || "".equals(checkCode_server) || !checkCode_server.equalsIgnoreCase(checkCode)){
            //验证码错误
            ResultInfo info = new ResultInfo();
            //注册失败
            info.setFlag(false);
            info.setErrorMsg("验证码错误");
            //将info对象序列化为json
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(info);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(json);
        }
		
		//获取用户名和密码并校验
		//1.获取输入的用户名和密码
		String companyno = request.getParameter("userno");	
		String ucompanyno = request.getParameter("password");
		//2.登录验证
		User login_user = new UserDaoImpl().findCompanyname(companyno, ucompanyno);
		if(login_user != null) {
			//2.1登录验证通过，保存user信息。
			request.getSession().setAttribute("companyno", companyno);
			request.getSession().setAttribute("companyname", login_user.getCompanyname());
			request.getSession().setAttribute("companyno", companyno);
			request.getSession().setAttribute("login_user", login_user);
			response.sendRedirect("search.jsp");
		}else {
			//2.2登录验证不通过，跳回到登录页面
			request.setAttribute("login_errormsg", "用户名或密码错误，请重新输入");
			request.getRequestDispatcher("login.html").forward(request, response);
		}
		//System.out.println(login_user);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
