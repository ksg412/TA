<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html xmlns:c="http://java.sun.com/xml/ns/javaee" xmlns:form="http://www.w3.org/1999/xhtml">
<head>
    <%@ include file="/WEB-INF/views/jsp/common/commonStyle.jsp"%>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>일반고객관리(상세보기)</title>
    <script type="text/javascript">
        $(document).ready(function() {
            cmCodeSelectGenerator('saleType', 'saleType', 10, false,true,null);

            datetimeGenerator('birthDate');
            datetimeGenerator('tradeDate');

            var table = $('#tableList').DataTable({
                paging: false
                ,processing: true
                ,serverSide: false
                ,searching: false
                ,"scrollY": "200px"
                ,language:{
                    "url":"/resources/json/dataTable-korean.json"
                }
                ,"ajax": {
                    "url":"/nomalClient/selectNomalClientDetailList"
                    ,"data": function(d){
                        d.ncId = $("#ncId").val();
                    }
                }
                ,"ordering": false
                ,"columns": [
                    { "data":"saleType", "visible":false},
                    { "data":"saleTypeName", "title": "판매유형" },
                    { "data":"tradeDate", "title": "거래날짜" },
                    { "data":"startPlace", "title": "출발지" },
                    { "data":"endPlace", "title": "목적지" }
                ]
            });

            dataTableSingleSelect(table, "tableList");

            dialog = $( "#dialog-form" ).dialog({
                autoOpen: false,
                height: 600,
                width: 350,
                modal: true,
                buttons: {
                    "추가": addUser,
                    닫기: function() {
                    dialog.dialog( "close" );
                    dialogReset();
                    }
                },
                close: function() {
                    dialogReset();
                }
            });

            form = dialog.find( "form" ).on( "submit", function( event ) {
                event.preventDefault();
                addUser();
            });
        });

        function addUser() {
            var valid = true;
            var allFields = $( [] ).add($("#saleType")).add($("#tradeDate")).add($("#startDate")).add($("#endDate"));
            allFields.removeClass( "ui-state-error" );

            valid = valid && checkEmpty( "saleType", "판매유형", "validateTips");
            valid = valid && checkEmpty( "tradeDate", "거래날짜", "validateTips");
            valid = valid && checkEmpty( "startPlace", "출발지", "validateTips");
            valid = valid && checkEmpty( "endPlace", "도착지", "validateTips");

            if ( valid ) {
                var data = {
                    "saleType":$('select[name=saleType]').val()
                    ,"saleTypeName":$('select[name=saleType] option:selected').text()
                    ,"tradeDate":$("#tradeDate").val()
                    ,"startPlace":$("#startPlace").val()
                    ,"endPlace":$("#endPlace").val()
                };

                if($("#dialogType").val() == "insert"){
                    $('#tableList').DataTable().row.add(data).draw();
                }else{
                    $("#tableList").DataTable().row('.selected').data(data).draw();
                }
                $( "#dialog-form" ).dialog("close");
            }
            return valid;
        }

        function doCancel(){
            location.replace("<c:url value='/'/>");
        }

        function doSave(){
            var tableList = $('#tableList').DataTable().rows().data();
            var arrayObj = new Array();
            for(var i=0;i<tableList.length;i++){
                var object = {
                    "saleType":tableList[i].saleType
                    ,"tradeDate":tableList[i].tradeDate
                    ,"startPlace":tableList[i].startPlace
                    ,"endPlace":tableList[i].endPlace
                }
                arrayObj.push(object);
            }
            $("#tableData01").val(JSON.stringify(arrayObj));
            $("#frm").submit();
        }

        function doAdd(){
            dialog.dialog( "open" );
            $("#dialogType").val("insert");
        }

        function dialogReset(){
            $('select[name=saleType]').selectpicker('val',null);
            $("#tradeDate").val("");
            $("#startPlace").val("");
            $("#endPlace").val("");
        }

        function doDetail(){
            var selectRow = $("#tableList").DataTable().rows('.selected').data();
            if(selectRow.length == 1){
                doAdd();
                $("#dialogType").val("update");
                $('select[name=saleType]').selectpicker('val',selectRow[0].saleType);
                $("#tradeDate").val(selectRow[0].tradeDate);
                $("#startPlace").val(selectRow[0].startPlace);
                $("#endPlace").val(selectRow[0].endPlace);
            }else{
                alert('항목을 선택해주세요');
            }
        }

    </script>
</head>
<body>

<c:import url="/main/selectHeaderView.do"/>

<div class="contentwrap">
    ${companyVo.type}
    <article class="container bgc-white" >
        <div class="page-header">
            <h1>일반고객관리 <small>상세보기</small></h1>
        </div>
        <c:url var="post_url"  value="/nomalClient/saveNomalClientDetail" />
        <form:form commandName="nomalClientVo" data-toggle="validator" cssClass="form-horizontal" id="frm" ACTION="${post_url}" METHOD="POST">
            <form:hidden path="viewType" />
            <form:hidden path="ncId" />
            <form:hidden path="tableData01" />
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
                <div class="col-sm-8">
                    <div class="tableList-btn">
                        <button type="button" class="btn btn-sm btn-default" onclick="doAdd()">저장</button>
                        <button type="button" class="btn btn-sm btn-default" onclick="doDetail()">수정</button>
                        <button type="button" class="btn btn-sm btn-default" onClick="">삭제</button>
                    </div>
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

<div id="dialog-form" title="거래내역추가">
    <form id="dialogForm">
        <fieldset>
            <input type="hidden" id="dialogType" name="dialogType"/>
            <div class="dialog-group">
                <p class="dialog-p">판매유형</p>
                <select type="text" name="saleType" id="saleType" class="input-validation-error width100p"></select>
            </div>
            <div class="dialog-group">
                <p class="dialog-p">거래일자</p>
                <input type="text" name="tradeDate" id="tradeDate" class="input-validation-error form-control">
            </div>
            <div class="dialog-group">
                <p class="dialog-p">출발지</p>
                <input type="text" name="startPlace" id="startPlace" class="input-validation-error form-control">
            </div>
            <div class="dialog-group">
                <p class="dialog-p">도착지</p>
                <input type="text" name="endPlace" id="endPlace" class="input-validation-error form-control">
            </div>
            <input type="submit" tabindex="-1" style="position:absolute; top:-1000px">
        </fieldset>
    </form>
    <p id="validateTips"></p>
</div>

