<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-fixed-top navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="<c:url value='/' />"><spring:message code="jsp.main.projectName"/></a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">정보관리<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">일반 고객관리</a></li>
                        <li><a href="#">거래처 고객관리</a></li>
                        <li><a href="#">거래처관리</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">판매관리<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">전세기</a></li>
                        <li><a href="#">해외여행</a></li>
                        <li><a href="#">국내여행</a></li>
                        <li><a href="#">자유여행</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">정산관리<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">전세기</a></li>
                        <li><a href="#">해외여행</a></li>
                        <li><a href="#">국내여행</a></li>
                        <li><a href="#">자유여행</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">수익현황<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">수익관리</a></li>
                        <li><a href="#">미수금관리</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">시스템관리<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="<c:url value='/userManagement/userManagementView.do' />">사용자관리</a></li>
                    </ul>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="../navbar-static-top/">마이페이지</a></li>
                <li><a href="<c:url value='/login/logout.do' />">로그아웃</a></li>
            </ul>
        </div><!-- /.nav-collapse -->
    </div><!-- /.container -->
</nav><!-- /.navbar -->
