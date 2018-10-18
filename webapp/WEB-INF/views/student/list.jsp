<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>梦的开始</title>
</head >
<body >
	<h1 style="font-size:30px;color:red;">学生信息表</h1>
	<a href="/student?cmd=edit" style="font-size:20px;color:purple;">添加</a>
	<table border="1" cellpadding="0" cellspacing="0" width="80%">
	<tr>
		<th style="font-size:20px;color:purple;">序号</th>
		<th style="font-size:20px;color:purple;">编号</th>
		<th style="font-size:20px;color:purple;">姓名</th>
		<th style="font-size:20px;color:purple;">年龄</th>	
		<th style="font-size:20px;color:black;">操作</th>		
	</tr>
	<c:forEach items="${requestScope.list}" var="stu" varStatus="vs" >	
		<tr style="background-color: ${vs.count%2==0?'gray':''};">
		<td style="color:blue;">${vs.count}</td>
		<td style="color:green;">${stu.id}</td>
		<td style="color:black;">${stu.name}</td>
		<td style="color:orange;">${stu.age}</td>
		<td> <a href="/student?cmd=delete&id=${stu.id}" style="font-size:20px;color:red;">删除</a> <div align="center">|</div> 
		 <a href="/student?cmd=edit&id=${stu.id}" style="font-size:20px;color:purple;">编辑</a></td>
		</tr>	
	</c:forEach>	
	</table>
	
</body>
</html>