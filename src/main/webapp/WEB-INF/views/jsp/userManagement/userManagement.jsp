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
           $('#tableList').DataTable({
                "pagingType": "full_numbers"
                ,"processing": true
                ,"recordsFiltered":100
                ,serverSide: true
                ,searching: false
                ,language:{
                    "url":"/resources/json/dataTable-korean.json"
                }
                ,"ordering": false
                ,"ajax": {
                    "url":"/userManagement/selectUserList.do"
                    ,"data": function(d){
                         d.form = $("#frm").serializeObject();
                     }
                }
                ,"columns": [
                    { "data": "id","title": "아이디"},
                    { "data": "name","title": "이름" },
                    { "data": "sex","title": "성별" },
                    { "data": "birthDate","title": "생년월일" },
                    { "data": "phoneNumber","title": "휴대폰번호" },
                    { "data": "email","title": "이메일" },
                    { "data": "joinDate","title": "가입일" }
                ]
            });

            cmCodeSelectGenerator('sex', 'sex', 4, false,true);
            $('#birthDate').datetimepicker({
                locale:'ko'
                ,format: 'YYYY-MM-DD'
            });
            $('#joinDate').datetimepicker({
                locale:'ko'
                ,format: 'YYYY-MM-DD'
            });
        });

        function search(){
            $('#tableList').DataTable().ajax.reload();
        }
    </script>
</head>

<body>

<c:import url="/main/selectHeaderView.do"/>

<div class="container">
    <div class="col-xs-12 col-lg-12 search-box">
        <form class="form-inline" id="frm" ACTION="${post_url}" METHOD="POST">
            <div class="form-group search-item">
                <label for="id" style="100px;">아이디</label>
                <input type="text" class="input-validation-error form-control" id="id" name="id"/>
            </div>
            <div class="form-group search-item">
                <label for="name" >이름</label>
                <input type="text" class="input-validation-error form-control" id="name" name="name"/>
            </div>
            <div class="form-group search-item">
                <label for="sex" >성별</label>
                <select class="input-validation-error" id="sex" name="sex">
                </select>
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
            <div class="form-group search-item">
                <label for="email" >가입일</label>
                <input type="text" class="input-validation-error form-control" id="joinDate" name="joinDate"/>
            </div>
        </form>
    </div>

    <div class="col-xs-12 col-lg-12 button-box">
        <button type="button" class="btn btn-primary" onClick="search();">검색</button>
        <button type="button" class="btn btn-info" onClick="alert('개발중');">등록</button>
        <button type="button" class="btn btn-warning" onClick="alert('개발중');">닫기</button>
    </div>

    <div class="col-xs-12 col-lg-12">
    <table id="tableList" class="table table-striped table-bordered" cellspacing="0" width="100%">
    </table>

    </div>

</div>

<c:import url="/main/selectFooterView.do"/>

</body>
</html>
