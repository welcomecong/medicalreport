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
		session.removeAttribute("CHECKCODE_SERVER");
		//实例化错误信息对象以及json对象序列化的ObjectMapper对象
		ResultInfo info = new ResultInfo();
		ObjectMapper mapper = new ObjectMapper();
		//3.判断
		if(checkCode_server == null || !checkCode_server.equalsIgnoreCase(checkCode)){
            //验证码错误
			info.setFlag(false);
			info.setErrorMsg("验证码错误");
            //将info对象序列化为json
			String json = mapper.writeValueAsString(info);
            response.setContentType("application/json;charset=utf-8");
			response.getWriter().write(json);
			return;
        }
		
		//获取用户名和密码并校验
		//1.获取输入的用户名和密码
		String companyno = request.getParameter("companyno");	
		String ucompanyno = request.getParameter("ucompanyno");
		//2.登录验证
		User login_user = new UserDaoImpl().findCompanyname(companyno, ucompanyno);
		if(login_user != null) {
			//用户名或密码正确
			//将登录的用户所有信息保存到session中
			request.getSession().setAttribute("user", login_user);
			info.setFlag(true);
			//将info对象序列化为json
			String json = mapper.writeValueAsString(info);
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().write(json);
		}else {
			//用户名或密码不正确
			info.setFlag(false);
			info.setErrorMsg("用户名或密码错误");
			String json = mapper.writeValueAsString(info);
			System.out.println(json);
			response.setContentType("application/json;charset=utf-8");
			response.getWriter().write(json);
		}
		//System.out.println(login_user);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
