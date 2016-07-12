var tableslanguage = {
        "sProcessing": "处理中...",
        "sZeroRecords": "没有匹配结果",
        "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
        "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
        "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
        "sInfoPostFix": "",
        "sUrl": "",
        "sEmptyTable": "表中数据为空",
        "sLoadingRecords": "载入中...",
        "sInfoThousands": ",",
        "oPaginate": {
            "sFirst": "首页",
            "sPrevious": "上页",
            "sNext": "下页",
            "sLast": "末页"
        },
        "oAria": {
            "sSortAscending": ": 以升序排列此列",
            "sSortDescending": ": 以降序排列此列"
        }
    };

//dataTables错误消息提示
function handleAjaxError(xhr, textStatus, error) {
	var str = error.message;
	//session过期
	if (str == "Unexpected token <") {
		location.href = "logout";
		return;
	}

	if (textStatus === 'timeout') {
		common.danger('服务器请求超时');
	} else {
		common.danger('服务器请求出现异常!');
	}
}
function load(api) {
	//做一个过滤器处理服务端超时后302的情况
	$.ajaxSetup({
		dataFilter:function(data, type){
			if(data.indexOf('loginform') !== -1){
				//如果返回的文本包含"登陆页面"，就跳转到登陆页面
				window.location.href = '/login';
				//一定要返回一个字符串不能不返回或者不给返回值，否则会进入success方法
				return "";
			}else{
				//如果没有超时直接返回
				return data;
			}
		}
	});
	
	$.ajax({
		url : api,
		success : function(result) {
			$('.content-wrapper').html(result);
		}
	});

}

function initDatePicker(obj){
	return obj.daterangepicker({
		format: "YYYY-MM-DD",
		separator: " ~ ",
	    locale: {
	        applyLabel: "确定",
	        cancelLabel: "取消",
	        fromLabel: "从",
	        toLabel: "到",
	        //customRangeLabel": "Custom",
	        daysOfWeek: [
	            "日",
	            "一",
	            "二",
	            "三",
	            "四",
	            "五",
	            "六"
	        ],
	        monthNames: [
	            "一月",
	            "二月",
	            "三月",
	            "四月",
	            "五月",
	            "六月",
	            "七月",
	            "八月",
	            "九月",
	            "十月",
	            "十一月",
	            "十二月"
	        ],
	        firstDay: 1
	    },
	    linkedCalendars: false,
	    autoUpdateInput: false
	});
}
(function($){
	$.fn.serializeJson = function(){
		var serializeObj={};
		$(this.serializeArray()).each(function(){
			if(this.value.length>0){
				serializeObj[this.name]=this.value;
			}
		});
		return serializeObj;
	};
})(jQuery);
(function($, context) {
	context.common = {
			message:function(type,title,content){
				//type:danger,info,warning,success
				switch(type){
					case 'danger':$('.callout').removeClass().addClass('callout callout-danger');
								  break;
					case 'info':$('.callout').removeClass().addClass('callout callout-info');
								break;
					case 'warning':$('.callout').removeClass().addClass('callout callout-warning');
								break;
					case 'success':$('.callout').removeClass().addClass('callout callout-success');
								  break;
					default:$('.callout').removeClass().add('callout callout-info');
				}
				if(title){
					$('.callout h4').html(title);
				}else{
					$('.callout h4').html('提示');
				}
				$('.callout p').html(content);
				$('.callout').show();
				$(".callout").animate({
				    right:'100px'
				  });
				$(".callout").fadeOut(3000);
			},
			info:function(content){
				common.message('info',null,content);
			},
			danger:function(content){
				common.message('danger',null,content);
			},
			warning:function(content){
				common.message('warning',null,content);
			},
			success:function(content){
				common.message('success',null,content);
			},
			confirm : function(message,callback){
				$('.modal-body').html(message);
				$('#modal_ok').one('click',function(){
					callback();
					$('#modal').modal('hide');
				});
				$('#modal').modal('show');
			},
	};
})(jQuery, window);