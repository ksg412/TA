<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!--favicon.ico-->
<!--<link rel="icon" href="resources/favicon.ico">-->

<!--jqueryui css-->
<link href="/resources/jqueryui/jquery-ui-1.12.0/jquery-ui.css" rel="stylesheet">
<!-- bootstrap 합쳐지고 최소화된 최신 CSS -->
<link href="/resources/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="<c:url value='/resources/bootstrap/dist/css/bootstrap-theme.css'/>" rel="stylesheet">
<link rel="stylesheet" href="/resources/bootstrap/select/css/bootstrap-select.css">
<link rel="stylesheet" href="/resources/bootstrap/datetimepicker/css/bootstrap-datetimepicker.min.css">
<!-- dataTables css-->
<link href="<c:url value='/resources/dataTable/dataTables.bootstrap.min.css'/>" rel="stylesheet">

<!--헤더부분-->
<link href="/resources/css/main/offcanvas.css" rel="stylesheet">
<!--풋터부분-->
<link href="/resources/css/footer/sticky-footer.css" rel="stylesheet">
<!-- 커스텀 css -->
<link href="<c:url value='/resources/css/common/custom.css'/>" rel="stylesheet">


<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link href="/resources/bootstrap/assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">
<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="/resources/bootstrap/assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="/resources/bootstrap/assets/js/ie-emulation-modes-warning.js"></script>


<!-- jquery 2.1.4버전 -->
<script src="<c:url value='/resources/jquery/1.12.4/jquery-1.12.4.min.js'/>" type="text/javascript"></script>
<script src="<c:url value='/resources/jqueryform/2.8/jquery.form.js'/>" type="text/javascript"></script>
<!-- 합쳐지고 최소화된 bootstrap 최신 자바스크립트 -->
<script src="<c:url value='/resources/bootstrap/dist/js/bootstrap.min.js'/>"></script>
<script src="/resources/bootstrap/select/js/bootstrap-select.js"></script>
<script src="<c:url value='/resources/bootstrap/validator.js'/>" type="text/javascript"></script>
<script src="<c:url value='/resources/bootstrap/moment/moment.min.js'/>" type="text/javascript"></script>
<script src="<c:url value='/resources/bootstrap/moment/moment-with-locales.min.js'/>" type="text/javascript"></script>
<script src="/resources/bootstrap/datetimepicker/js/bootstrap-datetimepicker.js"></script>
<!--jqueryui js jqueryui는 bootstrap js 이후에 와야함-->
<script src="<c:url value='/resources/jqueryui/jquery-ui-1.12.0/jquery-ui.js'/>" type="text/javascript"></script>
<!-- google chart -->
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

<!--dataTable js 2개의 순서가 중요함.-->
<script src="<c:url value='/resources/dataTable/jquery.dataTables.min.js'/>"></script>
<script src="<c:url value='/resources/dataTable/dataTables.bootstrap.min.js'/>"></script>
<!--common script-->
<script src="<c:url value='/resources/js/common/commonScript.js'/>"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->
<script src="/resources/bootstrap/assets/js/ie10-viewport-bug-workaround.js"></script>

<!--header 메뉴-->
<!--<link rel="stylesheet" href="<c:url value='/css/pageCss/justified-nav.css'/>">-->

<!--topHeader-->
<!--<link rel="stylesheet" href="<c:url value='/css/pageCss/topHeader.css'/>">-->


<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<script>
// Include CSRF token as header in JQuery AJAX requests
// See http://docs.spring.io/spring-security/site/docs/3.2.x/reference/htmlsingle/#csrf-include-csrf-token-ajax
var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
$(document).ajaxSend(function(e, xhr, options) {
xhr.setRequestHeader(header, token);
});
</script>
