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
            $('#birthDate').datetimepicker({
                locale:'ko'
                ,format: 'YYYY-MM-DD'
            });

            $('#tableList').DataTable({
                "paging": false
                ,"processing": true
                ,serverSide: true
                ,searching: false
                ,language:{
                    "url":"/resources/json/datatable-korean.json"
                }
                ,"ordering": false
                ,"columns": [
                    { "data": "ncdId","title": "ncdId", "visible":false},
                    { "data": "a","title": "판매유형" },
                    { "data": "b","title": "거래날짜" },
                    { "data": "c","title": "출발지" },
                    { "data": "d","title": "목적지" }
                ]
            });

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
    ${companyVo.type}
    <article class="container bgc-white" >
        <div class="page-header">
            <h1>거래처관리 <small>상세보기</small></h1>
        </div>
        <c:url var="post_url"  value="/company/saveCompanyDetail" />
        <form:form commandName="nomalClientVo" data-toggle="validator" cssClass="form-horizontal" id="frm" ACTION="${post_url}" METHOD="POST">
            <form:hidden path="viewType" />
            <form:hidden path="ncId" />
            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">이름</label>
                <div class="col-sm-6">
                    <form:input type="text" path="name" cssClass="input-validation-error form-control" id="name" placeholder="이름" required="required" />
                    <form:errors path="name"  id="name" cssClass="errorMsg"/>
                </div>
            </div>
            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">생년월일</label>
                <div class="col-sm-6">
                    <form:input type="text" path="birthDate" cssClass="input-validation-error form-control" id="birthDate" placeholder="생년월일" required="required" />
                    <form:errors path="birthDate"  id="birthDate" cssClass="errorMsg"/>
                </div>
            </div>
            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">휴대폰번호</label>
                <div class="col-sm-6">
                    <form:input type="text" path="phoneNumber" cssClass="input-validation-error form-control" id="phoneNumber" placeholder="휴대폰번호" required="required" />
                    <form:errors path="phoneNumber"  id="phoneNumber" cssClass="errorMsg"/>
                </div>
            </div>
            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">이메일</label>
                <div class="col-sm-6">
                    <form:input type="email" path="email" cssClass="input-validation-error form-control" id="email" placeholder="이메일" required="required" />
                    <form:errors path="email"  id="email" cssClass="errorMsg"/>
                </div>
            </div>
            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">주소</label>
                <div class="col-sm-6">
                    <form:input type="text" path="address" cssClass="input-validation-error form-control" id="address" placeholder="주소"/>
                    <form:errors path="address"  id="address" cssClass="errorMsg"/>
                </div>
            </div>
            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">비고</label>
                <div class="col-sm-6">
                    <form:input type="text" path="rm" cssClass="input-validation-error form-control" id="rm" placeholder="비고"/>
                    <form:errors path="rm"  id="rm" cssClass="errorMsg"/>
                </div>
            </div>
            <div class="form-group">
                <label for="name" class="col-sm-2 control-label">거래내역</label>
                <div class="col-sm-6">
                    <table id="tableList" class="table table-striped table-bordered" cellspacing="0" width="100%">
                    </table>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label"></label>
                <div class="col-sm-8">
                    <!--<button type="submit" class="btn btn-primary">수정</button>-->
                    <button type="button" class="btn btn-primary" onclick="doSave();">저장</button>
                    <button type="button" class="btn btn-primary" onClick="doCancel();">취소</button>
                </div>
            </div>
        </form:form>
    </article>


</div>

<c:import url="/main/selectFooterView.do"/>

</body>
</html>