<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html xmlns:c="http://java.sun.com/xml/ns/javaee" xmlns:form="http://www.w3.org/1999/xhtml">
<head>
    <%@ include file="/WEB-INF/views/jsp/common/commonStyle.jsp"%>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>거래처관리(상세보기)</title>
    <script type="text/javascript">
        $(document).ready(function() {
            cmCodeSelectGenerator('type', 'cpType', 10, false,true,"${companyVo.type}");
        });

        function doCancel(){
            location.replace("<c:url value='/'/>");
        }

        function doSave(){
            $("#frm").submit();
        }
    </script>
</head>
<body>

<c:import url="/main/selectHeaderView.do"/>

<div class="contentwrap">
    <article class="container bgc-white" >
        <div class="page-header">
            <h1>거래처관리 <small>상세보기</small></h1>
        </div>
        <c:url var="post_url"  value="/company/saveCompanyDetail" />
        <form:form commandName="companyVo" data-toggle="validator" cssClass="form-horizontal" id="frm" ACTION="${post_url}" METHOD="POST">
            <form:hidden path="viewType" />
            <form:hidden path="companyId" />
            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">거래처유형</label>
                <div class="col-sm-6">
                    <form:select class="input-validation-error width100p" path="type" id="type" name="type" placeholder="거래처유형"></form:select>
                    <form:errors path="type"  id="type" cssClass="errorMsg"/>
                </div>
            </div>
            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">거래처명</label>
                <div class="col-sm-6">
                    <form:input type="text" path="name" cssClass="input-validation-error form-control" id="name" placeholder="거래처명" />
                    <form:errors path="name"  id="name" cssClass="errorMsg"/>
                </div>
            </div>
            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">담당자</label>
                <div class="col-sm-6">
                    <form:input type="text" path="managerName" cssClass="input-validation-error form-control" id="managerName" placeholder="담당자" />
                    <form:errors path="managerName"  id="managerName" cssClass="errorMsg"/>
                </div>
            </div>
            <div class="form-group">
                <label for="companyNumber" class="col-sm-2 control-label">사업자번호</label>
                <div class="col-sm-6">
                    <form:input type="text" path="companyNumber" cssClass="input-validation-error form-control" id="companyNumber" placeholder="사업자번호" numberonly='true'/>
                    <form:errors path="companyNumber"  id="companyNumber" cssClass="errorMsg"/>
                </div>
            </div>
            <div class="form-group">
                <label for="companyNumber" class="col-sm-2 control-label">휴대폰번호</label>
                <div class="col-sm-6">
                    <form:input type="text" path="mobilePhoneNumber" cssClass="input-validation-error form-control" id="mobilePhoneNumber" placeholder="휴대폰번호" numberonly='true'/>
                    <form:errors path="mobilePhoneNumber"  id="mobilePhoneNumber" cssClass="errorMsg"/>
                </div>
            </div>
            <div class="form-group">
                <label for="companyPhoneNumber" class="col-sm-2 control-label">회사전화번호</label>
                <div class="col-sm-6">
                    <form:input type="text" path="companyPhoneNumber" cssClass="input-validation-error form-control" id="companyPhoneNumber" placeholder="회사전화번호" numberonly='true'/>
                    <form:errors path="companyPhoneNumber"  id="companyPhoneNumber" cssClass="errorMsg"/>
                </div>
            </div>
            <div class="form-group">
                <label for="address" class="col-sm-2 control-label">주소</label>
                <div class="col-sm-6">
                    <form:input type="text" path="address" cssClass="input-validation-error form-control" id="address" placeholder="주소" />
                    <form:errors path="address"  id="address" cssClass="errorMsg"/>
                </div>
            </div>
            <div class="form-group">
                <label for="rm" class="col-sm-2 control-label">메모</label>
                <div class="col-sm-6">
                    <form:textarea path="rm" rows="5" cols="30" cssClass="input-validation-error form-control" id="rm" placeholder="메모"/>
                    <form:errors path="rm"  id="rm" cssClass="errorMsg"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label"></label>
                <div class="col-sm-6">
                    <!--<button type="submit" class="btn btn-primary">수정</button>-->
                    <button type="button" class="btn btn-primary" onclick="doSave();">수정</button>
                    <button type="button" class="btn btn-primary" onClick="doCancel();">취소</button>
                </div>
            </div>
        </form:form>
    </article>
</div>

<c:import url="/main/selectFooterView.do"/>

</body>
</html>