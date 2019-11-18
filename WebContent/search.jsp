<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>广东深华药业有限公司药检系统</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/jquery-3.4.1.min.js"></script>
</head>
<body>
	<%if(session.getAttribute("companyname") != null){
		%>
			<h1>${companyname }，欢迎使用广东深华药业药检系统</h1>
		<%}else{
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	 %>
<form  action="searchServlet" method="post" class="form-inline">
	  <div class="form-group">
	    <label for="goodsname">商品名称</label>
	    <input type="text" class="form-control" name="goodsname" id="goodsname" placeholder="商品名称">
	  </div>
	  <div class="form-group">
	    <label for="lotno">批号</label>
	    <input type="text" class="form-control" name="lotno" id="lotno" placeholder="批号">
	  </div>
	  <div class="form-group">
	    <label for="salid">销售单ID</label>
	    <input type="text" class="form-control" name="salid" id="salid" placeholder="销售单ID">
	  </div>
	  <button type="submit" class="btn btn-default">查询</button>
	  <button type="reset" class="btn btn-default">重置</button>
</form>
</body>
</html>