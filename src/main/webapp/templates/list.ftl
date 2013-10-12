<html>
<head>
<base href="http://localhost:8088/webColletion/" />
<title>hello!</title>
</head>
<body>
<h2>你好,项目有如下Servlet链接 </h2>
	
<#list list as listItem>
	<a href=${listItem.url}>${listItem.name}</a><br>
</#list>  

</body>
</html>