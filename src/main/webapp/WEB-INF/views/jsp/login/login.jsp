<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html xmlns:c="http://www.w3.org/1999/XSL/Transform">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <%@ include file="/WEB-INF/views/jsp/common/commonStyle.jsp"%>

    <!-- Custom styles for this template -->
    <link href="/resources/css/login/signin.css" rel="stylesheet">

    <script>
        function doRegister(){
            location.replace("<c:url value='/login/selectRegistView.do'/>");
        }

    </script>

    <title>Signin Template for Bootstrap</title>
</head>

<body>

<div class="container">

    <form class="form-signin" method="post" action="loginProcess">
        <h2 class="form-signin-heading">로그인하세요.</h2>
        <label for="id" class="sr-only">Email address</label>
        <input type="text" id="id" name="id" class="form-control" placeholder="아이디" required autofocus>
        <label for="pw" class="sr-only">Password</label>
        <input type="password" id="pw" name="pw" class="form-control" placeholder="비밀번호" required>
        <div>
            <label>
                <input type="button" value="회원가입" class="btn btn-xs btn-default pull-right" onClick="doRegister()">
            </label>
        </div>
        <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
        <button class="btn btn-lg btn-primary btn-block" type="submit">로그인</button>
    </form>
    <c:if test="${fail != null}">
        <div class="login-fail-msg">
            <p>로그인이 실패하였습니다.</p>
            <p>아이디와 비밀번호를 확인해주세요.</p>
        </div>
    </c:if>
</div> <!-- /container -->


<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="/resources/bootstrap/assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
