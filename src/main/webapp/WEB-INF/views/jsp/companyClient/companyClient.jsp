<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html xmlns:spring="http://www.w3.org/1999/XSL/Transform">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <%@ include file="/WEB-INF/views/jsp/common/commonStyle.jsp"%>
    <title>Off Canvas Template for Bootstrap</title>

    <script>
        $(document).ready(function() {
            <c:if test="${not empty msg}">
            alert("<c:out value='${msg}'/>");
            </c:if>

            var table = $('#tableList').DataTable({
                "pagingType": "full_numbers"
                ,"processing": true
                ,serverSide: true
                ,searching: false
                ,language:{
                    "url":"/resources/json/dataTable-korean.json"
                }
                ,"ordering": false
                ,"ajax": {
                    "url":"/companyClient/selectCompanyClientList"
                    ,"data": function(d){
                        d.form = $("#frm").serializeObject();
                    }
                }
                ,"columns": [
                    { "data": "ccId","title": "cnId","visible":false},
                    { "data": "name","title": "이름" },
                    { "data": "birthDate","title": "생년월일" },
                    { "data": "phoneNumber","title": "휴대폰번호" },
                    { "data": "email","title": "이메일" }
                ]
            });

            datetimeGenerator("birthDate");
            dataTableSingleSelect(table, "tableList");
            cmCodeSelectGenerator('type', 'cpType', 10, false ,true);
        });

        function search(){
            $('#tableList').DataTable().ajax.reload();
        }

        function doRegist(){
            location.replace("<c:url value='/companyClient/selectCompanyClientDetail'/>");
        }

        function doDetail(){
            var selectRow = $("#tableList").DataTable().rows('.selected').data();
            if(selectRow.length == 1){
                location.replace("<c:url value='/companyClient/selectCompanyClientDetail/"+selectRow[0].ccId+"'/>");
            }else{
                alert('항목을 선택해주세요');
            }
        }
    </script>
</head>

<body>

<c:import url="/main/selectHeaderView.do"/>

<div class="container">
    <div class="page-title">
        <h2 class="page-title-h2">고객관리(거래처) <small>정보검색</small></h2>
    </div>
    <div class="col-xs-12 col-lg-12 search-box">
        <form class="form-inline" id="frm" ACTION="${post_url}" METHOD="POST">
            <div class="form-group search-item">
                <label for="name">이름</label>
                <input type="text" class="input-validation-error form-control" id="name" name="name"/>
                <!--<select class="input-validation-error" id="type" name="type"></select>-->
            </div>
            <div class="form-group search-item">
                <label for="birthDate" >생년월일</label>
                <input type="text" class="input-validation-error form-control" id="birthDate" name="birthDate"/>
            </div>
            <div class="form-group search-item">
                <label for="phoneNumber" >휴대폰번호</label>
                <input type="text" class="input-validation-error form-control" id="phoneNumber" name="phoneNumber"/>
            </div>
            <div class="form-group search-item">
                <label for="email" >이메일</label>
                <input type="text" class="input-validation-error form-control" id="email" name="email"/>
            </div>
        </form>
    </div>

    <div class="col-xs-12 col-lg-12 button-box">
        <button type="button" class="btn btn-primary" onClick="search();">검색</button>
        <button type="button" class="btn btn-success" onClick="doRegist();">등록</button>
        <button type="button" class="btn btn-success" onClick="doDetail();">상세보기</button>
        <button type="button" class="btn btn-danger" onClick="alert('개발중');">삭제</button>
    </div>

    <div class="col-xs-12 col-lg-12">
        <table id="tableList" class="table table-striped table-bordered" cellspacing="0" width="100%">
        </table>
    </div>
</div>

<c:import url="/main/selectFooterView.do"/>

</body>
</html>
