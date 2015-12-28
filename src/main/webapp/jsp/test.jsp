<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<script type="text/javascript"
	src="/RCS/jquery-easyui-1.3.5/jquery-1.4.4.min.js"></script>
<title>Insert title here</title>

<script type="text/javascript">
	var data = {
		dbInfo : {
			"driverClassName" : "com.mysql.jdbc.Driver",
			"url" : "jdbc:mysql://127.0.0.1:3306/test?&amp;useUnicode=true&amp;zeroDateTimeBehavior=convertToNull&amp;characterEncoding=UTF-8",
			"userName" : "root",
			"password" : "root",
			"type" : "mysql"
		},
		tableName : "test",
		basePackage : "com.koumi.framework.product.test"
	};
	$.ajax({
		url : "/RCS/code/generateCode",
		type : "POST",
		data : JSON.stringify(data),//将对象序列化成JSON字符串  
		dataType : "json",
		contentType : 'application/json;charset=utf-8', //设置请求头信息 
		success : function(callback) {
			alert(JSON.stringify(callback));
		},
		dataType : "json"
	});
</script>
</head>
<body>

</body>
</html>