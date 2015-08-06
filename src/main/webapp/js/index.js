jQuery.ajaxSetup({
	cache : false,
	contentType:"application/x-www-form-urlencoded;charset=utf-8",
	complete:function(XMLHttpRequest,textStatus){   
        var sessionstatus=XMLHttpRequest.getResponseHeader("sessionstatus"); //通过XMLHttpRequest取得响应头，sessionstatus，  
        if(sessionstatus=="timeout"){   
            //如果超时就处理 ，指定要跳转的页面  
            window.location.replace(basePath+"/jsp/login.jsp");   
        }   
	}   
});//ajax不缓存

$(document).ajaxError(function(e,xhr,o){
	closeMyDialog();
	if(xhr.status ==500){
		showWindow({
			title : "错误页面",
			content :  xhr.responseText,
			href:'',
			width:530,
			height:350
		});
	} else if(xhr.status ==404){
		showWindow({
			title : "错误页面",
			href:basePath+"/jsp/errors/404.jsp",
			width:530,
			height:350
		});
	}
});

function setmain(title, url) {
	if($.trim(url) == ""){
		url = basePath+"/jsp/errors/404.jsp";
		title = "访问错误";
	} else {
		url = basePath+"/jsp"+url;
	}
	 $('body').layout('panel', 'center').panel({
		title : "所在位置：" + title
	}); 
	addTab(title,url);	
	return false;
}

function addTab(title,url){
	addTabById("tt",title,url);
}

function reSetTab(url){
	var tab = $('#tt').tabs('getSelected');
	$('#tt').tabs('update', {
		tab:tab,
		options:{
			href : url
		}
	});
	
}

function addTabById(id,title,url){
	if ($('#'+id).tabs('exists', title)){
        $('#'+id).tabs('select', title);
    } else {
		$('#'+id).tabs('add',{
			title:title,
			href:url,
			closable:true
		});
		$('#'+id).tabs('select', title);
    }
}

//弹出窗口
function showWindow(options) {
	try {
		jQuery("#MyPopWindow").window(options);
	} catch (e) {
		// TODO: handle exception
	}
}
//关闭弹出窗口
function closeWindow() {
	try {
		$("#MyPopWindow").window('close');
	} catch (e) {
		// TODO: handle exception
	}
}

function centerWindow(){
	$("#MyPopWindow").window('center');
}

function showMyDialog(options){
	try {
		$('#myDialog').dialog(options);
	} catch (e) {
		// TODO: handle exception
	}
}

function destroyWindow(){
	jQuery("#MyPopWindow").window('destroy');
}

function closeMyDialog(){
	try {
		$('#myDialog').dialog('close');
	} catch (e) {
		// TODO: handle exception
	}
}