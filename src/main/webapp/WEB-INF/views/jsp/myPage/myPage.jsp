<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html xmlns:c="http://java.sun.com/xml/ns/javaee" xmlns:form="http://www.w3.org/1999/xhtml">
<head>
    <%@ include file="/WEB-INF/views/jsp/common/commonStyle.jsp"%>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>회원가입</title>
    <script type="text/javascript">
        $(document).ready(function() {
            $('#birthDate').datetimepicker({
                locale:'ko'
                ,format: 'YYYY-MM-DD'
            });
        });

        function doCancel(){
            location.replace("<c:url value='/'/>");
        }
    </script>
</head>
<body>

<c:import url="/main/selectHeaderView.do"/>

<div class="contentwrap">
    <article class="container bgc-white" >
        <div class="page-title">
            <h2 class="page-title-h2">마이페이지 <small>상세보기</small></h2>
        </div>
        <div class="detail-page-form">
            <c:url var="post_url"  value="/myPage/updateMyPage.do" />
            <form:form commandName="myPageVo" data-toggle="validator" cssClass="form-horizontal" id="frm" ACTION="${post_url}" METHOD="POST">
                <div class="form-group">
                    <label for="id" class="col-sm-2 control-label">아이디</label>
                    <div class="col-sm-6">
                        <form:input type="text" path="id" cssClass="input-validation-error form-control" id="id" placeholder="아이디" engNum="true" readonly="true"/>
                        <form:errors path="id"  id="id" cssClass="errorMsg"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="updatePw" class="col-sm-2 control-label">변경 비밀번호</label>
                    <div class="col-sm-6">
                        <form:input type="password" path="updatePw" cssClass="input-validation-error form-control" id="updatePw" placeholder="변경 비밀번호" engNum="true"/>
                        <form:errors path="updatePw"  id="updatePw" cssClass="errorMsg"/>
                        <p class="help-block">변경이 필요시, 변경될 비밀번호를 입력해주세요.</p>
                    </div>
                </div>
                <div class="form-group">
                    <label for="updatePwCheck" class="col-sm-2 control-label">변경 비밀번호 확인</label>
                    <div class="col-sm-6">
                        <form:input type="password" path="updatePwCheck" cssClass="input-validation-error form-control" id="updatePwCheck" placeholder="변경 비밀번호 확인" engNum="true"/>
                        <form:errors path="updatePwCheck"  id="updatePwCheck" cssClass="errorMsg"/>
                        <p class="help-block">변경이 필요시, 변경될 비밀번호를 한번 더 입력해주세요.</p>
                    </div>
                </div>
                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">이름</label>
                    <div class="col-sm-6">
                        <form:input type="text" path="name" cssClass="input-validation-error form-control" id="name" placeholder="이름" required="required"/>
                        <form:errors path="name"  id="name" cssClass="errorMsg"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">성별</label>
                    <div class="col-sm-6">
                        <div class="row">
                            <div class="col-sm-1">
                                <label class="radio-inline">
                                    <form:radiobutton path="sex" value="M" required="required"/>남
                                </label>
                            </div>
                            <div class="col-sm-1">
                                <label class="radio-inline">
                                    <form:radiobutton path="sex" value="F" required="required"/>여
                                </label>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label for="birthDate" class="col-sm-2 control-label">생년월일</label>
                    <div class="col-sm-6">
                        <form:input type="text" path="birthDate" cssClass="input-validation-error form-control" id="birthDate" placeholder="생년월일" required="required"/>
                        <form:errors path="birthDate"  id="birthDate" cssClass="errorMsg"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="phoneNumber" class="col-sm-2 control-label">휴대폰번호</label>
                    <div class="col-sm-6">
                        <form:input type="number" path="phoneNumber" cssClass="input-validation-error form-control" id="phoneNumber" placeholder="휴대폰번호" required="required"/>
                        <form:errors path="phoneNumber"  id="phoneNumber" cssClass="errorMsg"/>
                        <p class="help-block">- 없이 숫자만 적어주세요.</p>
                    </div>
                </div>
                <div class="form-group">
                    <label for="email" class="col-sm-2 control-label">이메일</label>
                    <div class="col-sm-6">
                        <form:input type="email" path="email" cssClass="input-validation-error form-control" id="email" placeholder="이메일" required="required"/>
                        <form:errors path="email"  id="email" cssClass="errorMsg"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label"></label>
                    <div class="col-sm-6">
                        <button type="submit" class="btn btn-primary">수정</button>
                        <button type="button" class="btn btn-primary" onClick="doCancel();">취소</button>
                    </div>
                </div>
            </form:form>
        </div>
    </article>
</div>

<c:import url="/main/selectFooterView.do"/>

</body>
</html>