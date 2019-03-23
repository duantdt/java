<%@page import="org.apache.catalina.Session"%>
<%@page import="com.duant.rcpy.domain.Info"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">

<!--jquery-->
<script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/jquery-ui.js" type="text/javascript"></script>


<!-- bootstrap -->
<link href="css/bootstrap-combined.min.css" rel="stylesheet"
	media="screen">
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/bootstrap.min.js" type="text/javascript"></script>

<!-- bootstrap-select -->
<link href="css/bootstrap-select.min.css" rel="stylesheet">
<script src="js/bootstrap-select.min.js"></script>

<title>审核</title>
</head>
<body>
	<br>
	<div class="container-fluid" id="LG">
		<div class="row-fluid">
			<div class="span12">
				<div class="row-fluid">
					<div class="span2"></div>
					<div class="span8">
						<div class="navbar">
							<div class="navbar-inner">
								<div class="container-fluid">
									<a data-target=".navbar-responsive-collapse"
										data-toggle="collapse" class="btn btn-navbar"><span
										class="icon-bar"></span><span class="icon-bar"></span><span
										class="icon-bar"></span></a> <a href="#" class="brand">aku</a>
									<div class="nav-collapse collapse navbar-responsive-collapse">
										<ul class="nav">
											<li><a
												href="${pageContext.request.contextPath }/rcpy_index_select.do">主页</a>
											</li>
											<li><a href="#">录入</a></li>
											<li><a href="#">预览</a></li>
											<li class="dropdown"><a data-toggle="dropdown"
												class="dropdown-toggle" href="#">下拉菜单<strong
													class="caret"></strong></a>
												<ul class="dropdown-menu">
													<li><a href="#">下拉导航1</a></li>
													<li><a href="#">下拉导航2</a></li>
													<li><a href="#">其他</a></li>
													<li class="divider"></li>
													<li class="nav-header">标签</li>
													<li><a href="#">链接1</a></li>
													<li><a href="#">链接2</a></li>
												</ul></li>
										</ul>
										<ul class="nav pull-right">
											<li><a href="#" id="li_infoid">待审核</a></li>
											<li class="divider-vertical"></li>
											<li class="dropdown"><a data-toggle="dropdown"
												class="dropdown-toggle" href="#">${user.username }<strong
													class="caret"></strong></a>
												<ul class="dropdown-menu">
													<li><a href="#">修改密码</a></li>
													<li><a href="#">联系管理员</a></li>
													<li><a href="#">其他</a></li>
													<li class="divider"></li>
													<li><a href="logout.jsp">注销</a></li>
												</ul></li>
										</ul>
									</div>

								</div>
							</div>
						</div>
					</div>
					<br><br><br><br><br><br><hr>
					<div class="span2"></div>
				</div>
			</div>
		</div>
		
		<div class="row-fluid">
			<div class="span12">
				<div class="row-fluid">
					<div class="span2"></div>
					<div class="span8">
						<table class="table">
							<thead>
								<tr style="text-align: center;">
									<th>专业编号</th>		
									<th>年级</th>
									<th>院系</th>
									<th>班级</th>
									<th>用户</th>
									<th>状态</th>
									<th colspan="3" >操作</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach var = "info" items="${list }"> 
									<td id="infoid">${info.infoid}</td>
									<td>${info.grade}</td>
									<td>${info.college}</td>
									<td>${info.specialty}</td>
									<td>${info.userid}</td>
									<td>${info.submit eq 0 ? '未提交' : '已提交'} /${info.change eq 0 ? '待审核' : '已审核'}</td>
									<td>
										<a href="${pageContext.request.contextPath }/rcpy_index_preview.do?infoid=${info.infoid}"><button class="btn">预览</button></a>
										<a href="${pageContext.request.contextPath}/review.do?infoid=${info.infoid}&type=1"><button class="btn">通过</button></a>
										<a href="${pageContext.request.contextPath}/review.do?infoid=${info.infoid}&type=0"><button class="btn">驳回</button></a>
									</td>
								</tr>
							</c:forEach>

							</tbody>
						</table>
						<div class="pagination pagination-centered">
							<ul items="${page}">	
								<li id="review_li_shouye" value="1">
									<a href="${pageContext.request.contextPath}/review.do?currentPage=1" >首页</a>
								</li>
								<li>
									<a href="${pageContext.request.contextPath}/review.do?currentPage=${page.prefPage}">上一页</a>
								</li>
								<li><a href="${pageContext.request.contextPath}/review.do?currentPage=${page.prefPage}">${page.prefPage}</a></li>
								<li><a href="">当前：第${page.currentPage}页</a></li>
								<li><a href="${pageContext.request.contextPath}/review.do?currentPage=${page.nextPage}">${page.nextPage}</a></li>
								
								<li>
									<a href="${pageContext.request.contextPath}/review.do?currentPage=${page.nextPage}">下一页</a>
								</li>
								<li><a href="${pageContext.request.contextPath}/review.do?currentPage=${page.totalPages}">尾页</li>
							</ul>
						</div>
						
					</div>
					<div class="span2"></div>
				</div>
			</div>
		</div>


	</div>


<script type="text/javascript">
		
		function reviewBnt(){
			
			var currentPage = $("#review_li_shouye").val;
			
			
			$.ajax({
				type:"post",
				url : "${pageContext.request.contextPath }/review.do",
				dataType : "json",
				data:{
					"currentPage" : currentPage,
				},
				
				success : function(data){
					
				}
				
			});
			
		}
		
</script>
</body>
</html>
