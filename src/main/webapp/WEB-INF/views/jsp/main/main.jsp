<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html xmlns:spring="http://www.w3.org/1999/XSL/Transform">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <%@ include file="/WEB-INF/views/jsp/common/commonStyle.jsp"%>
    <script src="/resources/js/main/offcanvas.js"></script>
    <title>Off Canvas Template for Bootstrap</title>

    <script type="text/javascript">
        google.charts.load('current', {'packages':['corechart']});
        google.charts.setOnLoadCallback(drawChart1);
        google.charts.setOnLoadCallback(drawChart2);
        google.charts.setOnLoadCallback(drawChart3);

        function drawChart1() {

            // Create the data table.
            var data = new google.visualization.DataTable();
            data.addColumn('string', 'Topping');
            data.addColumn('number', 'Slices');
            data.addRows([
                ['일반고객', 33],
                ['거래처고객', 11]
            ]);

            // Set chart options
            var options = {'title':'7월 고객통계',
                'width':400,
                'height':300};

            // Instantiate and draw our chart, passing in some options.
            var chart = new google.visualization.PieChart(document.getElementById('chart_div1'));
            chart.draw(data, options);
        }

        function drawChart2() {

            // Create the data table.
            var data = new google.visualization.DataTable();
            data.addColumn('string', 'Topping');
            data.addColumn('number', 'Slices');
            data.addRows([
                ['전세기', 3],
                ['해외', 1],
                ['국내', 1],
                ['자유', 1]
            ]);

            // Set chart options
            var options = {'title':'7월 판매통계',
                'width':400,
                'height':300};

            // Instantiate and draw our chart, passing in some options.
            var chart = new google.visualization.PieChart(document.getElementById('chart_div2'));
            chart.draw(data, options);
        }

        function drawChart3() {
            // Some raw data (not necessarily accurate)
            var data = google.visualization.arrayToDataTable([
                ['Month', '전세기', '해외', '국내', '자유'],
                ['2016/01', 165, 938, 522, 998],
                ['2016/02', 135, 1120, 599, 1268],
                ['2016/03', 157, 1167, 587, 807],
                ['2016/04', 139, 1110, 615, 968],
                ['2016/05', 136, 691, 629, 1026],
                ['2016/06', 136, 691, 629, 26]
            ]);

            var options = {
                title : '월별 판매 실적',
                vAxis: {title: '판매량'},
                hAxis: {title: '월'},
                seriesType: 'bars',
                series: {5: {type: 'line'}}
            };

            var chart = new google.visualization.ComboChart(document.getElementById('chart_div3'));
            chart.draw(data, options);
        }
    </script>
</head>

<body>

<c:import url="/main/selectHeaderView.do"/>

<div class="container">

    <div class="row row-offcanvas row-offcanvas-right">

        <div class="col-xs-12 col-sm-9">
            <p class="pull-right visible-xs">
                <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas">Toggle nav</button>
            </p>
            <div class="jumbotron">
                <h2><spring:message code="jsp.main.mainMessage01"/></h2>
                <p><spring:message code="jsp.main.mainMessage02"/></p>
            </div>
            <div class="row">
                <div class="col-xs-6 col-lg-6">
                    <div id="chart_div1"></div>
                </div><!--/.col-xs-6.col-lg-4-->
                <div class="col-xs-6 col-lg-6">
                    <div id="chart_div2"></div>
                </div><!--/.col-xs-6.col-lg-4-->
                <div class="col-xs-6 col-lg-12">
                    <div id="chart_div3"></div>
                </div><!--/.col-xs-6.col-lg-4-->
            </div><!--/row-->
        </div><!--/.col-xs-12.col-sm-9-->

        <div class="col-xs-6 col-sm-3 sidebar-offcanvas" id="sidebar">
            <div class="list-group">
                <a class="list-group-item active">즐겨찾기</a>
                <a href="#" class="list-group-item">Link</a>
                <a href="#" class="list-group-item">Link</a>
                <a href="#" class="list-group-item">Link</a>
                <a href="#" class="list-group-item">Link</a>
                <a href="#" class="list-group-item">Link</a>
                <a href="#" class="list-group-item">Link</a>
                <a href="#" class="list-group-item">Link</a>
                <a href="#" class="list-group-item">Link</a>
                <a href="#" class="list-group-item">Link</a>
            </div>
        </div><!--/.sidebar-offcanvas-->
    </div><!--/row-->
</div><!--/.container-->

<c:import url="/main/selectFooterView.do"/>

</body>
</html>
