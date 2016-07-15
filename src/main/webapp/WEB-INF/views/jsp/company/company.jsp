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
                    "url":"/company/selectCompanyList"
                    ,"data": function(d){
                         d.form = $("#frm").serializeObject();
                     }
                }
                ,"columns": [
                    { "data": "companyId","title": "companyId","visible":false}
                    ,{ "data": "type","title": "거래처유형" }
                    ,{ "data": "name","title": "거래처명" }
                    ,{ "data": "managerName","title": "담당자" }
                    ,{ "data": "companyNumber","title": "사업자번호" }
                    ,{ "data": "mobilePhoneNumber","title": "휴대폰번호" }
                    ,{ "data": "companyPhoneNumber","title": "회사전화번호" }
                ]
            });

            $('#tableList tbody').on( 'click', 'tr', function () {
                if ( $(this).hasClass('selected') ) {
                    $(this).removeClass('selected');
                }
                else {
                    table.$('tr.selected').removeClass('selected');
                    $(this).addClass('selected');
                }
            } );

            $('#button').click( function () {
                table.row('.selected').remove().draw( false );
            } );


            cmCodeSelectGenerator('type', 'cpType', 10, true ,true, null);
        });

        function search(){
            $('#tableList').DataTable().ajax.reload();
        }

        function doRegist(){
            location.replace("<c:url value='/company/selectCompanyDetail'/>");
        }

        function doDetail(){
            var selectRow = $("#tableList").DataTable().rows('.selected').data();
            if(selectRow.length == 1){
                location.replace("<c:url value='/company/selectCompanyDetail/"+selectRow[0].companyId+"'/>");
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
        <h2 class="page-title-h2">거래처관리 <small>정보검색</small></h2>
    </div>
    <div class="col-xs-12 col-lg-12 search-box">
        <form class="form-inline" id="frm" ACTION="${post_url}" METHOD="POST">
            <div class="form-group search-item">
                <label for="type">거래처유형</label>
                <select class="input-validation-error" id="type" name="type"></select>
            </div>
            <div class="form-group search-item">
                <label for="name" >거래처명</label>
                <input type="text" class="input-validation-error form-control" id="name" name="name"/>
            </div>
            <div class="form-group search-item">
                <label for="managerName" >담당자</label>
                <input type="text" class="input-validation-error form-control" id="managerName" name="managerName"/>
            </div>
            <div class="form-group search-item">
                <label for="companyNumber" >사업자번호</label>
                <input type="text" class="input-validation-error form-control" id="companyNumber" name="companyNumber"/>
            </div>
            <div class="form-group search-item">
                <label for="mobilePhoneNumber" >휴대폰번호</label>
                <input type="text" class="input-validation-error form-control" id="mobilePhoneNumber" name="mobilePhoneNumber"/>
            </div>
            <div class="form-group search-item">
                <label for="companyPhoneNumber" >회사전화번호</label>
                <input type="text" class="input-validation-error form-control" id="companyPhoneNumber" name="companyPhoneNumber"/>
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
