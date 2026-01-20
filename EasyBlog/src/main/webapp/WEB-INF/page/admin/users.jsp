<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
        <meta name="generator" content="HTML Tidy for HTML5 (experimental) for Windows https://github.com/w3c/tidy-html5/tree/c63cc39" />
		<meta http -equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bootstrap Admin</title>
        <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <link rel="stylesheet" type="text/css" href="/static/lib/bootstrap/css/bootstrap.css" />
        <link rel="stylesheet" type="text/css" href="/static/stylesheets/theme.css" />
        <link rel="stylesheet" href="/static/lib/font-awesome/css/font-awesome.css" />
        <script src="/static/lib/jquery-1.7.2.min.js" type="text/javascript"></script>
        <!-- Demo page code -->
        <style type="text/css">
	        #line-chart {
	            height:300px;
	            width:800px;
	            margin: 0px auto;
	            margin-top: 1em;
	        }
	        .brand { font-family: georgia, serif; }
	        .brand .first {
	            color: #ccc;
	            font-style: italic;
	        }
	        .brand .second {
	            color: #fff;
	            font-weight: bold;
	        }
	        .disable {
	        	cursor: not-allowed;
	        }
	        .pagination ul > li > a .active {
			    background-color: #595959;
			    color: #fff;
			    border-color: #595959;
			}
    	</style>
    </head>

    <body class="">
    <div class="navbar">
        <div class="navbar-inner">
            <ul class="nav pull-right">
                <li>
                    <a href="#" class="hidden-phone visible-tablet visible-desktop" role="button">Settings</a>
                </li>
                <li id="fat-menu" class="dropdown">
                    <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">Jack Smith</a>
                    <ul class="dropdown-menu">
                        <li>
                            <a tabindex="-1" href="#">My Account</a>
                        </li>
                        <li>
                            <a tabindex="-1" class="visible-phone" href="#">Settings</a>
                        </li>
                        <li>
                            <a tabindex="-1" href="sign-in.html">Logout</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <a class="brand" href="/admin/index.html">
            <span class="first">EasyBlog</span> 
            <span class="second">Admin</span></a>
        </div>
    </div>
    <div class="sidebar-nav">
    <a href="#dashboard-menu" class="nav-header" data-toggle="collapse">Dashboard</a>
    <ul id="dashboard-menu" class="nav nav-list collapse in">
        <li>
            <a href="/admin/index.html">主页</a>
        </li>
        <li class="active">
            <a href="/user/list.html">用户列表</a>
        </li>
        <li>
            <a href="/user/create.html">新建用户</a>
        </li>
        <li>
            <a href="media.html">Media</a>
        </li>
        <li>
            <a href="calendar.html">Calendar</a>
        </li>
    </ul>
    <a href="#accounts-menu" class="nav-header" data-toggle="collapse">Account
    <span class="label label-info">+3</span></a>
    <ul id="accounts-menu" class="nav nav-list collapse">
        <li>
            <a href="sign-in.html">Sign In</a>
        </li>
        <li>
            <a href="sign-up.html">Sign Up</a>
        </li>
        <li>
            <a href="reset-password.html">Reset Password</a>
        </li>
    </ul>
    <a href="#error-menu" class="nav-header collapsed" data-toggle="collapse">Error Pages</a>
    <ul id="error-menu" class="nav nav-list collapse">
        <li>
            <a href="403.html">403 page</a>
        </li>
        <li>
            <a href="404.html">404 page</a>
        </li>
        <li>
            <a href="500.html">500 page</a>
        </li>
        <li>
            <a href="503.html">503 page</a>
        </li>
    </ul>
    <a href="#legal-menu" class="nav-header" data-toggle="collapse">Legal</a>
    <ul id="legal-menu" class="nav nav-list collapse">
        <li>
            <a href="privacy-policy.html">Privacy Policy</a>
        </li>
        <li>
            <a href="terms-and-conditions.html">Terms and Conditions</a>
        </li>
    </ul>
    <a href="help.html" class="nav-header">Help</a> 
    <a href="faq.html" class="nav-header">Faq</a></div>
    <div class="content">
        <div class="header">
            <h1 class="page-title">用户列表</h1>
        </div>
        <ul class="breadcrumb">
            <li>
            <a href="index.html">主页</a> 
            <span class="divider">/</span></li>
            <li class="active">用户列表</li>
        </ul>
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="btn-toolbar">
                <button id="create-user" class="btn btn-primary">New User</button> 
                <button class="btn">Import</button> 
                <button class="btn">Export</button>
                <div class="btn-group"></div></div>
                <div class="well">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>#</th>
                                <th>名称</th>
                                <th>电子邮箱</th>
                                <th>地址</th>
                                <th style="width: 40px;">操作</th>
                            </tr>
                        </thead>
                        <tbody>
                        	<c:forEach items="${page.data}" var="u" varStatus="seNo">
                            <tr>
                                <td>${seNo.count }</td>
                                <td><c:out value="${u.name}"></c:out></td>
                                <td>${u.email}</td>
                                <td>${u.position}</td>
                                <td>
              						<a href="/user/update?id=${u.id }&pageNo=${page.pageNo}"><i class="icon-pencil"></i></a>
              						&nbsp;
              						<a href="#myModal" role="button" data-toggle="modal"><i class="icon-remove"></i></a>
                                </td>
                            </tr>
							</c:forEach>
                        </tbody>
                    </table>
                </div>
                
                <!-- Pagination logic begin -->
                <c:if test="${page.totalPage > 1}">
                <div class="pagination">
                    <ul>
		                <li>
                        <c:choose>
						 	<c:when test="${page.pageNo <= 1}">
						 		<a href="#" class="disable">Prev</a>
						 	</c:when>
						 	<c:otherwise>
						 		<a href="/user/list?pageNo=${page.pageNo - 1 }" >Prev</a>
		      				</c:otherwise>
						</c:choose>
		                </li>
                        
                        <c:forEach var="pNo" begin="${page.showPageNoBegin }" end="${page.showPageNoBegin + page.showPageNoSize - 1}">
                        <li>
                            <a href="/user/list?pageNo=${pNo}">${pNo}</a>
                        </li>
      					</c:forEach>

		                <li>
                        <c:choose>
						 	<c:when test="${page.pageNo == page.totalPage}">
						 		<a href="#" class="disable">Next</a>
						 	</c:when>
						 	<c:otherwise>
						 		<a href="/user/list?pageNo=${page.pageNo + 1 }">Next</a>
		      				</c:otherwise>
						</c:choose>
                            
                        </li>
                    </ul>
                </div>
                </c:if>
                <!-- Pagination logic end -->
                
                <div class="modal small hide fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                        <h3 id="myModalLabel">Delete Confirmation</h3>
                    </div>
                    <div class="modal-body">
                        <p class="error-text">Are you sure you want to delete the user?</p>
                    </div>
                    <div class="modal-footer">
                    <button class="btn" data-dismiss="modal" aria-hidden="true">Cancel</button> 
                    <button class="btn btn-danger" data-dismiss="modal">Delete</button></div>
                </div>
                <footer>
                    <hr />
                    <!-- Purchase a site license to remove this link from the footer: http://www.portnine.com/bootstrap-themes -->
                    <p class="pull-right">A 
                    <a href="http://www.portnine.com/bootstrap-themes" target="_blank">Free Bootstrap Theme</a> by 
                    <a href="http://www.mycodes.net/" title="源码之家" target="_blank">源码之家</a></p>
                    <p>ɠ2012 
                    <a href="http://www.mycodes.net/" title="源码之家" target="_blank">源码之家</a></p>
                </footer>
            </div>
        </div>
    </div>
    <script src="/static/lib/bootstrap/js/bootstrap.js"></script> 
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
            $("#create-user").on("click", function() {
                window.location.href="create.html";
            });
        });
	</script>
	</body>
</html>
