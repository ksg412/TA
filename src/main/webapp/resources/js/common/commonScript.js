
//숫자만numberonly='true'
$(document).on("keyup", "input:text[numberOnly]", function() {$(this).val( $(this).val().replace(/[^0-9]/gi,"") );});

//영문만engOnly='true'
$(document).on("keyup", "input:text[engOnly]", function() {$(this).val( $(this).val().replace(/[0-9]|[^\!-z]/gi,"") );});

//영문 + 띄어쓰기
$(document).on("keyup", "input:text[engOnly]", function() {$(this).val( $(this).val().replace(/[0-9]|[^\!-z\s]/gi,"") );});

//한글만korOnly='true' --테스트결과 IE에서 안먹을 때가 종종있음.
$(document).on("keyup", "input:text[korOnly]", function() {$(this).val( $(this).val().replace(/[a-z0-9]|[ \[\]{}()<>?|`~!@#$%^&*-_+=,.;:\"\\]/g,"") );});

//영문+숫자
$(document).on("keyup", "input:text[engNum]", function() {$(this).val( $(this).val().replace(/[^a-z0-9]/gi,'') );});
