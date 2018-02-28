<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MyTools 让您的工作生活更简便</title>
<link
	href="//netdna.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="../css/bootstrap.css" />
<link rel="stylesheet" href="../css/font-awesome.min.css" />
<style type="text/css">
width:100%;
height:1000px;
</style>
</head>

<body>
	<div class="main">
		<div id="myCarousel" class="carousel slide" data-ride="carousel"
			data-interval="3000">
			<!-- 轮播（Carousel）指标 -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>
			<!-- 轮播（Carousel）项目 -->
			<div class="carousel-inner">
				<div class="item active">
					<img src="../img/main-Carousel-image1.jpg" alt="First slide">
					<div class="carousel-caption">
						<h1>MyTools</h1>
						<br>
						<h1>MyTools 让您的工作生活更简便</h1>
						<br> <br>
						<h4>大脑是用来思考的, 记录宝贵灵感的事交给我们</h4>
						<br>
						<h4>现代生活喧嚣繁杂，MyTools帮你轻松简化一切，让生活更美好，让工作更省力</h4>
						<br> <br>
						<button type="button" class="btn btn-success btn-lg"
							data-toggle="modal" data-target="#myModal">立即登录</button>
						&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
						<button type="button" class="btn btn-primary btn-lg"
							data-toggle="modal" data-target="#register">加入我们</button>
						<br> <br> <br> <br>
					</div>
				</div>
				<div class="item">
					<img src="../img/main-Carousel-image4.jpg" alt="Second slide">
					<div class="carousel-caption">
						<h4>MyTools : 让你事半功倍</h4>
						<h4>集收集、记录、保存、分享于一体,在一个地方就能找到</h4>
					</div>
				</div>
				<div class="item">
					<img src="../img/main-Carousel-image5.jpg" alt="Third slide">
					<div class="carousel-caption">
						<h4>MyTools : 打造你的专属资料库</h4>
						<h4>整理碎片化信息，记录想法、待办事项、个人日记、工作日志、会议记录和项目资料</h4>
					</div>
				</div>
			</div>
			<!-- 轮播（Carousel）导航 -->
			<a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
			<a class="carousel-control right" href="#myCarousel"
				data-slide="next">&rsaquo;</a>
		</div>
		<!--快速登录弹出层-->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="width: 450px;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
						<h4 class="modal-title" id="myModalLabel">MyTools -快速登录</h4>
					</div>
					<form action="login" method="post"
						class="bs-example bs-example-form" role="form"
						onSubmit="return checkloginfrom();">
						<div class="modal-body">
							<div style="padding: 30px 30px 10px;">
								<div class="input-group input-group-lg">
									<span class="input-group-addon"><i class="fa fa-user"
										aria-hidden="true"></i></span> <input type="text" name="usermail"
										class="form-control" placeholder="请输入你的手机号/邮箱(必填)"
										id="login-username" onblur="checkusernumber()">
									<!--<span id="login-username-messages"></span>-->
									<i id="login-username-messages"></i>
								</div>
								<br>
								<div class="input-group input-group-lg">
									<span class="input-group-addon"><i
										class="fa fa-unlock-alt" aria-hidden="true"></i></span> <input
										type="password" name="userpassword" class="form-control"
										placeholder="请输入你注册的用户密码(必填)" id="login-password"
										onblur="checkpassword()"> <i
										id="login-password-messages"></i>
								</div>
								<br>
								<div class="input-group input-group-lg">
									<span class="input-group-addon"><i
										class="fa fa-keyboard-o" aria-hidden="true"></i></span> <img
										src="/img/login-Verification-Code.jpg" class="img-responsive"
										alt="Cinque Terre"> <input type="text"
										class="form-control" placeholder="请输入上图的验证码答案(必填)"
										id="login-VerificationCode"
										onblur="checkloginVerificationCode()"> <i
										id="login-VerificationCode-messages"></i>
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary"
								data-dismiss="modal">关 闭</button>
							<button type="submit" class="btn btn-success">立即登录</button>
						</div>
					</form>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
		<!--快速注册弹出层-->
		<div class="modal fade" method="post" id="register" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" style="width: 450px;">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
						<h4 class="modal-title" id="myModalLabel">MyTools -快速注册</h4>
					</div>
					<form action="register" method="post"
						class="bs-example bs-example-form" role="form"
						onSubmit="return checkregisterfrom();">
						<div class="modal-body">
							<div style="padding: 30px 30px 10px;">
								<div class="input-group input-group-lg">
									<span class="input-group-addon"><i class="fa fa-user"
										aria-hidden="true"></i></span> <input type="text" name="usermail"
										class="form-control" placeholder="请输入你的常用邮箱(必填)"
										id="registerMail" onblur="checkuserMail()"> <i
										id="register-mail-messages"></i>
								</div>
								<br>
								<div class="input-group input-group-lg">
									<span class="input-group-addon"><i class="fa fa-phone"
										aria-hidden="true"></i></span> <input type="text" name="userphone"
										class="form-control" placeholder="请输入你的手机号码(选填)"
										id="registerPhone" onblur="checkuserPhone()"> <i
										id="register-phone-messages"></i>
								</div>
								<br>
								<div class="input-group input-group-lg">
									<span class="input-group-addon"><i
										class="fa fa-unlock-alt" aria-hidden="true"></i></span> <input
										type="password" name="userpassword" class="form-control"
										placeholder="请输入你注册的用户密码(必填)" id="registerPassword"
										onblur="checkregisterpassword()"> <i
										id="register-password-messages"></i>
								</div>
								<br>
								<div class="input-group input-group-lg">
									<span class="input-group-addon">
									<i class="fa fa-unlock-alt" aria-hidden="true"></i></span> <input
										type="password" class="form-control"
										placeholder="请重复你注册的用户密码(必填)" id="registerRePassword"
										onblur="checkregisterRepassword()"> <i
										id="register-repassword-messages"></i>
								</div>
								<br>
								<div class="input-group input-group-lg">
									<span class="input-group-addon"><i
										class="fa fa-envelope-o" aria-hidden="true"></i></span> <input
										type="button"
										class="btn btn-default btn-lg btn-block btn-success"
										id="register-send-btn" value="获取邮箱验证码" onclick="sendmail()">
									<input id="mailcode" type="text" name="code"
										class="form-control" placeholder="请输入上面的6位数的邮箱验证码(必填)"
										onfocus="mailcodecheck()"> <i
										id="register-codes-messages"></i>
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary"
								data-dismiss="modal">关 闭</button>
							<button type="submit" class="btn btn-success">立即注册</button>
						</div>
					</form>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
	</div>
	<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="../js/bootstrap.js"></script>
	<script type="text/javascript" src="../js/register.js"></script>
	<script type="text/javascript" src="../js/login.js"></script>

</body>

</html>