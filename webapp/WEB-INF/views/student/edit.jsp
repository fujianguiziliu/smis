<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${requestScope.stu==null?'添加':'编辑'}页面</h1>
	
	<form action="${pageContext.request.contextPath}/student?cmd=saveOrUpdate" method="post">
	<input type="hidden" name="id" value="${requestScope.stu.id}">
		账号：
		<input type="text" name="name" value="${requestScope.stu.name}"/> 
		<br/>
		年龄：
		<input type="text" name="age" value="${requestScope.stu.age}"/>
		<br/>
		<input type="submit" value="${requestScope.stu == null ? '添加' : '编辑'}"/>
	
	</form>
</body>
</html>