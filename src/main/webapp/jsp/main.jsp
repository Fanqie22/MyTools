<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>MyTools 我 的 首 页</title>
  <!--  <link rel="stylesheet" href="../css/bootstrap.css" />-->
  <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="../css/font-awesome.min.css" />
  <link rel="stylesheet" href="../css/main.css" />
</head>
<body bgcolor="#f8f8f8">
		<div class="head">
			<nav class="navbar navbar-default" role="navigation">
				<div class="container-fluid">
					<div class="navbar-header">
						<a class="navbar-brand" href="#"> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
						<span class="glyphicon glyphicon-wrench"></span> MyTools
						</a>
						<div class="kongge"></div>
					</div>
					<div>
						<form class="navbar-form navbar-left" role="search">
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Search">
							</div>
							<button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search"></span> 搜 索</button>
						</form>
						<!--<p class="navbar-text">让 您 的 工 作 生 活 更 简 便 </p>-->
						<!--向右对齐-->
						<ul class="nav navbar-nav navbar-right">
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown"> 查 看 更 多 <b class="caret"></b>
								</a>
								<ul class="dropdown-menu">
									<li>
										<a href="#">jmeter</a>
									</li>
									<li>
										<a href="#">EJB</a>
									</li>
									<li>
										<a href="#">Jasper Report</a>
									</li>
									<li class="divider"></li>
									<li>
										<a href="#">分离的链接</a>
									</li>
									<li class="divider"></li>
									<li>
										<a href="#">另一个分离的链接</a>
									</li>
								</ul>
							</li>
						</ul>
						<a href="#"><p class="navbar-text navbar-right"><font style="color: #1874CD;"> &nbsp; ${users.username } (<i >${users.usermail } </i> )&nbsp;  &nbsp; </font> 欢 迎 来 到 MyTools  &nbsp;  &nbsp; </p></a>
					</div>
				</div>
			</nav>

		</div>
		<div class="daohang">
			<ul id="myTab" class="nav nav-tabs">
				<li class="active">
					<a href="#main" data-toggle="tab"><span class="glyphicon glyphicon-home"></span> 我 的 首 页 </a>
				</li>
				<li>
					<a href="#note" data-toggle="tab"><span class="glyphicon glyphicon-tags"></span> 我 的 便 签 </a>
				</li>
				<li>
					<a href="#document" data-toggle="tab"><span class="glyphicon glyphicon-folder-open"></span>  我 的 文 档 </a>
				</li>
				<li>
					<a href="#music" data-toggle="tab"> &nbsp; <span class="glyphicon glyphicon-headphones"></span> 听 音 乐 &nbsp;</a>
				</li>
				
				<li>
					<a href="#cloud" data-toggle="tab"><span class="glyphicon glyphicon-cloud"></span> 我 的 云 盘 </a>
				</li>
				<li>
					<a href="#mail" data-toggle="tab"><span class="glyphicon glyphicon-envelope"></span> 发 送 邮 件 </a>
				</li>
				
				<li>
					<a href="#film" data-toggle="tab"><span class="glyphicon glyphicon-hd-video"></span> 电 视 剧 电 影</a>
				</li>
				<li>
					<a href="#friends" data-toggle="tab"><span class="glyphicon glyphicon-user"></span> 我 的 好 友 </a>
				</li>
				<li>
					<a href="#jobs" data-toggle="tab"><span class="glyphicon glyphicon-briefcase"></span> 找 工 作 &nbsp; &nbsp; </a>
				</li>
				<li>
				           	<a href="#image" data-toggle="tab"><span class="glyphicon glyphicon-picture"></span> 文 字 识 别 </a>
				       </li>
				<li class="dropdown">
					<a href="#" id="myTabDrop1" class="dropdown-toggle" data-toggle="dropdown"><span class="glyphicon glyphicon-log-out"></span> 还 有 更 多 <b class="caret"></b>
					</a>
					<ul class="dropdown-menu" role="menu" aria-labelledby="myTabDrop1">
						
						<li>
					      <a href="#news" data-toggle="tab"><span class="glyphicon glyphicon-th"></span> 看 新 闻&nbsp; &nbsp; </a>
				       </li>
					</ul>
				</li>

			</ul>
			<div id="myTabContent" class="tab-content">
				<!-- 我的首页-->
			<div class="tab-pane fade in active" id="main">
				<div class="mains">

					<div class="main-left">
						<h5 style="margin-left: 50px; margin-top: 20px;">
							<button class="btn btn-success btn-lg" data-toggle="modal"
								data-target="#myModal" >&nbsp;
								&nbsp; 发 布 动 态 &nbsp; &nbsp;</button>
							<br>
							<h5 style="margin-left: 50px; margin-top: 20px;">
								<button class="btn btn-success btn-lg" data-toggle="modal"
									data-target="">&nbsp; &nbsp; 我 的 动 态 &nbsp; &nbsp;</button>
							</h5>
						</h5>
					</div>
					
					<div class="main-right">
					      <p class="text-primary text-center" style="margin: 20px 20px;"> 天 气 预 报 </p>
					    <div class="main-right-left">
					      <img src="${weather.icon }" style="margin: 1px 20px;"/>
					    </div>
					    <div class="main-right-right">
					      
					      <p class="text-primary text-center" style="font-size:6;display: inline-block;">${weather.weather } &nbsp;  &nbsp;  &nbsp;  &nbsp; </p>
					      <p class="text-primary text-center" style="font-size:6;display: inline-block;">${weather.temperature } &nbsp;  &nbsp;  &nbsp; </p><br>
					      <p class="text-primary text-center" style="font-size:6;display: inline-block;"><span class="glyphicon glyphicon-map-marker"></span>  ${weather.local } &nbsp;  &nbsp;  &nbsp; </p>
					      <p class="text-primary text-center" style="font-size:6;display: inline-block;">更新于  ${weather.times } &nbsp;${weather.week }  &nbsp;  &nbsp; </p>
					    </div>
					</div>


					<!-- 发布动态模态框（Modal） -->
					<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
						aria-labelledby="myModalLabel" aria-hidden="true"
						data-backdrop="static">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-hidden="true">&times;</button>
									<h4 class="modal-title" id="myModalLabel">发布一条动态到朋友圈</h4>
								</div>
								<div class="modal-body">
									<form class="bs-example bs-example-form" role="form"
										method="post" action="sendTidings" id="tidingsform">

										<div class="input-group input-group-lg">
											<span class="input-group-addon"> <span
												class="glyphicon glyphicon-user"></span></span> <input type="text"
												class="form-control" value="${users.usermail }"
												name="usermail" id="usermails" readonly="readonly"> <input
												type="text" class="form-control" value="${users.username }"
												name="username" id="usernames" readonly="readonly">
										</div>
										<br>

										<div class="input-group input-group-lg">
											<span class="input-group-addon"> <span
												class="glyphicon glyphicon-edit"></span></span> <input type="text"
												class="form-control" placeholder=" 在 这 里 输 入 你 的 动 态 标 题 ">
										</div>
										<br>
										<textarea class="form-control" rows="6" name="tiding"
											placeholder=" 在 这 里 输 入 你 的 动 态 内 容" style="resize: none;"
											id="areatidings"></textarea>
										<i id="tidingsmessage"></i>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-primary"
										data-dismiss="modal">关 闭</button>
									<button type="button" class="btn btn-success"
										onclick="sendTidings()">发 布 动 态</button>
								</div>
								</form>
							</div>
							<!-- /.modal-content -->
						</div>
						<!-- /.modal -->
					</div>


					<div class="main-center">
						<c:forEach items="${tidings}" var="t">
							<div class="main-center-card input-group">
								&nbsp; &nbsp; <img src="../img/logo.png" />
								<h4 style="display: inline-block;">${t.username}</h4>
								<h5 style="display: inline-block;">&nbsp; &nbsp; &nbsp;
									&nbsp; &nbsp; &nbsp; 发 布 于 ${t.senddate }</h5>
								 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
								 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
								<button type="button" class="btn btn-success"
									style="display: inline-block;" name="zan" onclick="zan(this,${t.tidingsid })">
								   	<i name="zanValue" >
								   	<c:forEach items="${zan}" var="z">
										<c:choose>
											<c:when test="${t.tidingsid eq z.tidingsid}">已
										    </c:when>
										</c:choose>
									</c:forEach></i><i name="z">赞</i>	
									<span class="glyphicon glyphicon-thumbs-up"></span>
								</button>
								&nbsp; &nbsp; &nbsp;
								<!--  <p id="tidingsid" >${t.tidingsid }</p>-->
								<h3 style="display: inline-block;">
									<span class="glyphicon glyphicon-heart-empty"></span>
								</h3>
								${t.support} 人次
								<h4>&nbsp; &nbsp; ${t.tidings }</h4>
								<h5 style="margin-left: 50px; margin-top: 20px;">
									<c:forEach items="${comments}" var="co">
										<!-- 判断两者是否相等 -->
										<c:if test="${t.tidingsid eq co.tidingsid}">
                                                    ${co.username} (${co.commentdate}) : ${co.comment }<br>
										</c:if>
									</c:forEach>
								</h5>
								<div class="main-center-comments">
									<button class="btn btn-success" data-toggle="modal"
										data-target="#myCommentsModal">转发动态</button>
										 &nbsp;  &nbsp;  &nbsp; 
									<button class="btn btn-success" data-toggle="modal"
										data-target="#myCommentsModal">发表评论</button>
									 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
								</div>

							</div>
							<hr>
						</c:forEach>
					</div>
				</div>
			</div>




			<div class="tab-pane fade" id="note">
				<p>iOpple Inc. Originally released in 2007 for the iPhone, iPod
					Touch, and Apple TV. iOS is derived from OS X, with which it shares
					the Darwin foundation. iOS is Apple's mobile version of the OS X
					operating system used on Apple computers.</p>
			</div>
			<div class="tab-pane fade" id="document">
				<p>jMeter is an Open Source testing software. It is 100% pure
					Java application for load and performance testing.</p>
			</div>
			<div class="tab-pane fade" id="image">
				<p>Enterprise Java Beans (EJB) is a development architecture for
					building highly scalable and robust enterprise level applications
					to be deployed on J2EE compliant Application Server such as JBOSS,
					Web Logic etc.</p>
			</div>
		</div>
	</div>
	<script>
		$(function() {
			$('#myTab li:eq(0) a').tab('show');
		});
	</script>
	<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="../js/bootstrap.js"></script>
	<script type="text/javascript" src="../js/main.js"></script>

</body>

</html>