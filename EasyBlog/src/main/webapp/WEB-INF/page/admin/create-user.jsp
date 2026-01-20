<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta name="generator"
        content="HTML Tidy for HTML5 (experimental) for Windows https://github.com/w3c/tidy-html5/tree/c63cc39" />
        <meta charset="utf-8" />
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
			        height: 300px;
			        width: 800px;
			        margin: 0px auto;
			        margin-top: 1em;
			}
			
			.brand {
			        font-family: georgia, serif;
			}
			
			.brand .first {
			        color: #ccc;
			        font-style: italic;
			}
			
			.brand .second {
			        color: #fff;
			        font-weight: bold;
			}
		</style>
        <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
      <script src="lib/html5.js"></script>
    <![endif]-->
        <!-- Le fav and touch icons -->
        <link rel="shortcut icon" href="../assets/ico/favicon.ico" />
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png" />
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png" />
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png" />
        <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png" />
    </head>
    <!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
    <!--[if IE 7 ]> <body class="ie ie7 "> <![endif]-->
    <!--[if IE 8 ]> <body class="ie ie8 "> <![endif]-->
    <!--[if IE 9 ]> <body class="ie ie9 "> <![endif]-->
    <!--[if (gt IE 9)|!(IE)]><!-->
    <body class="">
        <!--<![endif]-->
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
                <span class="first">Your</span> 
                <span class="second">Company</span></a>
            </div>
        </div>
        <div class="sidebar-nav">
        <a href="#dashboard-menu" class="nav-header" data-toggle="collapse">Dashboard</a>
        <ul id="dashboard-menu" class="nav nav-list collapse in">
            <li>
                <a href="/admin/index.html">主页</a>
            </li>
            <li>
                <a href="/user/list.html">用户列表</a>
            </li>
            <li class="active">
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
            <h1 class="page-title">新建用户</h1>
        </div>
        <ul class="breadcrumb">
            <li>
            <a href="index.html">主页</a> 
            <span class="divider">/</span></li>
            <li>
            <a href="users.html">用户列表</a> 
            <span class="divider">/</span></li>
            <li class="active">新建用户</li>
        </ul>
        <div class="container-fluid">
            <div class="row-fluid">
                <div class="btn-toolbar">
                <button id="save-user" class="btn btn-primary">Save</button> 
                <a href="#myModal" data-toggle="modal" class="btn">Delete</a>
                <div class="btn-group"></div></div>
                <div class="well">
                    <ul class="nav nav-tabs">
                        <li class="active">
                            <a href="#home" data-toggle="tab">用户资料</a>
                        </li>
                    </ul>
                    <div id="myTabContent" class="tab-content">
                        <div class="tab-pane active in" id="home">
                            <form id="create-form" method="post" action="/user/create/save">
	                            <label>用户名称：</label> 
	                            <input name="name" type="text" value="" class="input-xlarge" /> 
	                            <label>英文名称：</label> 
	                            <input name="enName" type="text" value="" class="input-xlarge" /> 
	                            <label>用户密码：</label> 
	                            <input name="password" type="password" class="input-xlarge" /> 
	                            <label>确认密码：</label> 
	                            <input name="confirmpwd" type="password" class="input-xlarge" /> 
	                            <label>电子邮箱：</label> 
	                            <input name="email" type="text" value="" class="input-xlarge" /> 
	                            <label>性别：</label> 男：
	                            <input type="radio" checked="checked" name="sex" value="male" /> 女：
	                            <input type="radio" name="sex" value="female" /> 
	                            <label>用户类型：</label> 
	                            <select name="type" class="input-xlarge">
	                                <option value="visitor">访问用户</option>
	                                <option value="manager">管理用户</option>
	                            </select> 
	                            <label>个人主页：</label> 
	                            <input name="website" type="text" value="http://" class="input-xlarge" /> 
	                            <label>地址：</label> 
	                            <textarea value="address" rows="3" class="input-xlarge"></textarea>
                            </form>
                        </div>
                    </div>
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
	            $("#save-user").click(function(){
	                $("#create-form").submit();             
	            });
	        });
		</script>
	</div>
    </body>
</html>
