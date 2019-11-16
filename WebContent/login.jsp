<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>广东深华药业有限公司药检查询系统</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	
</script>
</head>
<body>
<div class="container" style="width: 400px;">
  		<h3 style="text-align: center;">管理员登录</h3>
        <form action="loginServelt" method="post">
	      <div class="form-group">
	        <label for="userno">用户名：</label>
	        <input type="text" name="userno" class="form-control" id="userno" placeholder="请输入用户名"/>
	      </div>
	      
	      <div class="form-group">
	        <label for="password">密码：</label>
	        <input type="password" name="password" class="form-control" id="password" placeholder="请输入密码"/>
	      </div>
	      
	      <!--  <div class="form-inline">
	        <label for="vcode">验证码：</label>
	        <input type="text" name="verifycode" class="form-control" id="verifycode" placeholder="请输入验证码" style="width: 120px;"/>
	        <a href="javascript:refreshCode()"><img src="vcode" title="看不清点击刷新" id="vcode"/></a>
	      </div>
	      <hr/>-->
	      <div class="form-group" style="text-align: center;">
	        <input class="btn btn btn-primary" type="submit" value="登录">
		  </div>
	  	</form>
		<!--  
		 出错显示的信息框 -->
	  	<div class="alert alert-warning alert-dismissible" role="alert">
		  <button type="button" class="close" data-dismiss="alert" >
		  	<span>&times;</span>
		  </button>
		   <strong>${login_errormsg }</strong>
		</div>
		
  	</div>
</body>
</html>