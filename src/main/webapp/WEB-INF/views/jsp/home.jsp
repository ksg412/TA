<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
	var absoluteUrl = '${pageContext.request.scheme}' + '://' + '${pageContext.request.serverName}' + ':' + '${pageContext.request.serverPort}' + '${pageContext.request.contextPath}';
	location.href=absoluteUrl+"/login/loginCheck.do";
</script>
<html>
<head>
    <title>Home</title>
</head>
<body>
</body>
</html>


