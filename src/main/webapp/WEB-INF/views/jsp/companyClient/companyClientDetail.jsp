<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html xmlns:c="http://java.sun.com/xml/ns/javaee" xmlns:form="http://www.w3.org/1999/xhtml">
<head>
    <%@ include file="/WEB-INF/views/jsp/common/commonStyle.jsp"%>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>고객관리(거래처)상세보기</title>
    <script type="text/javascript">
        $(document).ready(function() {
            /*콤보박스 생성*/
            cmCodeSelectGenerator('saleType', 'saleType', 10, false,true, null);

            /*날짜박스 생성*/
            datetimeGenerator('birthDate');
            datetimeGenerator('tradeDate');

            /*테이블 생성*/
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
                    "url":"/companyClient/selectCompanyClientDetailList"
                    ,"data": function(d){
                        d.ccId = $("#ccId").val();
                    }
                }
                ,"ordering": false
                ,"columns": [
                    dataTableCheckBox,
                    { "data":"saleType", "visible":false},
                    { "data":"saleTypeName", "title": "판매유형" },
                    { "data":"tradeDate", "title": "거래날짜" },
                    { "data":"startPlace", "title": "출발지" },
                    { "data":"endPlace", "title": "목적지" }
                ]
                ,"drawCallback": function( settings ) {
                    /*전체선택,해제 생성*/
                    selectAllClick(table);
                }
            });

            /*테이블 단일선택 세팅*/
            dataTableSingleSelect(table, "tableList");

            /*dialog 생성*/
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

            /*거래처 combobox*/
            $.ajax({
                method: "POST",
                url: "/company/selectCompanyComboList",
                dataType: 'json'
            })
            .done(function( data ) {
                selectGenerator(data, 'companyId', 100, true, true, "${companyClientVo.companyId}");
            });
        });

        /*테이블 항목 추가*/
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

        /*상세보기 저장*/
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

        /*dialog 추가*/
        function doAdd(){
            dialog.dialog( "open" );
            $("#dialogType").val("insert");
        }

        /*dialog 수정*/
        function doDialogDetail(){
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

        function doDeleteRows(){
            $('#tableList').DataTable().$('input[type="checkbox"]').each(function(){
                if(this.checked){
                    $("#tableList").DataTable().row($(this).parents('tr')).remove().draw();
                }
            });
        }

        /*dialog form을 리셋한다.*/
        function dialogReset(){
            $('select[name=saleType]').selectpicker('val',null);
            $("#tradeDate").val("");
            $("#startPlace").val("");
            $("#endPlace").val("");
        }

        /*목록으로 돌아가기*/
        function doList(){
            location.replace("<c:url value='/companyClient/selectCompanyClientView'/>");
        }

    </script>
</head>
<body>

<c:import url="/main/selectHeaderView.do"/>
<div class="contentwrap">
    <article class="container bgc-white" >
        <div class="page-title">
            <h2 class="page-title-h2">고객관리(거래처) <small>상세보기</small></h2>
        </div>
        <div class="detail-page-form">
            <c:url var="post_url"  value="/companyClient/saveCompanyClientDetail" />
            <form:form commandName="companyClientVo" data-toggle="validator" cssClass="form-horizontal" id="frm" ACTION="${post_url}" METHOD="POST">
                <form:hidden path="viewType" />
                <form:hidden path="ccId" />
                <form:hidden path="tableData01" />

                <div class="form-group">
                    <label for="companyId" class="col-sm-2 control-label">거래처</label>
                    <div class="col-sm-6">
                        <form:select class="input-validation-error width100p" path="companyId" id="companyId" name="companyId" placeholder="거래처"></form:select>
                        <form:errors path="companyId"  id="companyId" cssClass="errorMsg"/>
                    </div>
                </div>
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
                            <button type="button" class="btn btn-sm btn-default" onclick="doAdd()">추가</button>
                            <button type="button" class="btn btn-sm btn-default" onclick="doDialogDetail()">수정</button>
                            <button type="button" class="btn btn-sm btn-default" onClick="doDeleteRows()">삭제</button>
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
                        <button type="button" class="btn btn-primary" onClick="doList();">목록</button>
                    </div>
                </div>
            </form:form>
        </div>
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

