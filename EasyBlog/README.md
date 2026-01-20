#EasyBlog#

这是一个基于SpringMVC + Mybatis + MySQL的个人博客系统。

##开发环境##
Eclispe(Luna), JDK1.7, MySQL5.6, Maven3.0+, Spring3.2+

##MyBatis代码生成器工具的使用##
本项目数据Model层代码基于Generate MyBatis/iBATIS Artifacts(代码生成器完成)
需要下载生成工具为Eclipse使用，也可以Maven来生成代码，具体方可以百度一下


##启动方式##
1.基于项目自身Maven jetty plugin Eclipse mode
	Menu: Run-->Run Configuration / Maven Build
		Goals : clean jetty:run
		profiles : dev
		
2.基于maven jetty command line
	mvn clean jetty:run -P dev

3.基于Tomcat启动在Eclipse中配置
	Project上右键  --> Run As --> Run on Server
	

##其它