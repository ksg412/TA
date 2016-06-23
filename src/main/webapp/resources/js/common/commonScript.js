
/*ajax 요청 csrf 통과*/
var csrftoken = $('meta[name=csrf-token]').attr('content');
$.ajaxSetup({
    beforeSend: function(xhr, settings) {
        if (!/^(GET|HEAD|OPTIONS|TRACE)$/i.test(settings.type) && !this.crossDomain) {
            xhr.setRequestHeader("X-CSRFToken", csrftoken)
        }
    }
})


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


/*bootstrap select generator*/
function cmCodeSelectGenerator(targetId, groupId, size, liveSearch, noSelect, selectValue){
    $.ajax({
        method: "POST",
        url: "/common/selectComboboxData.do",
        dataType: 'json',
        data: { groupId: groupId}
    })
    .done(function( data ) {

        if(noSelect){
            $('#'+targetId).append("<option value=''>-선택하세요-</option>");
        }

        for(var i=0;i<data.length;i++){
                $('#'+targetId).append("<option value='"+data[i].codeId+"'>"+data[i].codeNm+"</option>");
        }
        $('#'+targetId).selectpicker({
          size: size
          ,noneSelectedText:"-선택하세요-"
          ,liveSearch:liveSearch
        });
        if(selectValue != null){
            $('#'+targetId).selectpicker('val', selectValue);
        }

    });
}

$.fn.serializeObject = function(){
   var obj = {};

   $.each( this.serializeArray(), function(i,o){
      var n = o.name, v = o.value;

      obj[n] = obj[n] === undefined ? v
         : $.isArray( obj[n] ) ? obj[n].concat( v )
         : [ obj[n], v ];
   });

   return obj;
};

function datetimeGenerator(targetId){
    $('#'+targetId).datetimepicker({
        locale:'ko'
        ,format: 'YYYY-MM-DD'
    });
}


function checkLength( o, n, tip,min, max ) {
    o = $("#"+o);
    if ( o.val().length > max || o.val().length < min ) {
        o.addClass( "ui-state-error" );

        $("#"+tip).text(n + " 길이는 " +
        min + "보다 크고 " + max + "보다 작아야 한다.").addClass( "ui-state-highlight" );
        setTimeout(function() {
            $("#"+tip).removeClass( "ui-state-highlight", 1500 );
        }, 500 );
        return false;
    } else {
        return true;
    }
}

function checkEmpty( o, n, tip){
    o = $("#"+o);
    if ( o.val() == null || o.val() == "" ) {
        o.addClass( "ui-state-error" );

        $("#"+tip).text(n + " 필수값입니다.").addClass( "ui-state-highlight" );
        setTimeout(function() {
            $("#"+tip).removeClass( "ui-state-highlight", 1500 );
        }, 500 );
        return false;
    } else {
        return true;
    }
}

    function dataTableSingleSelect(table, tableId){
    $('#'+tableId+' tbody').on( 'click', 'tr', function () {
        if ( $(this).hasClass('selected') ) {
            $(this).removeClass('selected');
        }
        else {
            table.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }
    });

    $('#button').click( function () {
        table.row('.selected').remove().draw( false );
    } );

}


