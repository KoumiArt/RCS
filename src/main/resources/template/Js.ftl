$(function($) {
	$('#${classNameVar}List').datagrid(
				{
					method : 'post',
					iconCls : 'icon-search', //图标
					singleSelect : false, //多选
					autoRowHeight:true,
					height: 460,//高度
					//width: 1000,
					fitColumns : true, //自动调整各列，用了这个属性，下面各列的宽度值就只是一个比例。
					striped : true, //奇偶行颜色不同
					collapsible : true,//可折叠
					url : basePath+"/manager/${classNameVar}List",
					
					idField : 'sId', //主键字段
					pagination : true, //显示分页
					rownumbers : true, //显示行号
					columns : [ [  {
						${easyUIColumns}
					},
					{
						field : 'opt',
						title : '操作',
						width : 400,
						align : 'center',
						rowspan : 2,
						formatter : function(value, rec) {
							return '<input type="button" onclick="${classNameVar}Edit('+rec.${classNameVar}Id+')" class="button_Csss" value="修改" /> <input type="button" onclick="remove${className}('+rec.${classNameVar}Id+')" class="button_Csss" value="删除" />';
						}
					} ] ],
					toolbar : [ {
						text : '新增',
						iconCls : 'icon-add',
						handler : function() {
							${classNameVar}Edit();
						}
					},{
						text : '批量删除',
						iconCls : 'icon-remove',
						handler : function() {
							batchRemove${className}();
						}
					}],
					onLoadSuccess : function() {
						$('#${classNameVar}List').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
						$("#${classNameVar}List").datagrid('resize',{
							width:'auto'});
					}
				});
	
	$("#search${className}Id").click(function(){
		var params = $('#${classNameVar}List').datagrid('options').queryParams; //先取得 datagrid 的查询参数
		var fields = $('#search${className}FormId').serializeArray(); //自动序列化表单元素为JSON对象
		$.each(fields, function(i, field) {
			params[field.name] = field.value; //设置查询参数
		});
		refresh${className}List();
	});
});

//重新加载列表
function refresh${className}List() {
	$('#${classNameVar}List').datagrid('reload');
}


function ${classNameVar}Edit(${classNameVar}Id){
	var url = basePath+'/jsp/manager/edit${className}.jsp';
	var title = "新增";
	if(${classNameVar}Id!=undefined && ${classNameVar}Id !=null && ${classNameVar}Id !=""){
		url = url + "?${classNameVar}Id="+${classNameVar}Id;
		title = "修改";
	}
	showWindow({
			title:title,
			href:url,
			width:530,
			height:350,
			onLoad:function(){
				if(${classNameVar}Id!=null&&${classNameVar}Id!=""&&${classNameVar}Id!=undefined){
					$.post(basePath+"/manager/get${className}",{"${classNameVar}Id":${classNameVar}Id},function(data){
					<#list columns as column>
						<#if column.pk == 1 >
							$("#${classNameVar}Form").append("<input type='hidden' name='${classNameVar}Id' value='"+${classNameVar}Id+"'/>");
						<#else>
							$("#${classNameVar}Form input[name=${column.columnName}]").val(data.${column.columnName});
						</#if>
					</#list>
						
					});
				}
			}
		});
}

function remove${className}(${classNameVar}Id){
	$.messager.confirm('操作提示', '是否要删除该信息？', function(r){
		if(r){
			$.post(basePath+"/manager/delete${className}",{"${classNameVar}Id":${classNameVar}Id},function(data){
				if(data){
					//$.messager.alert("操作提示","删除成功！","info");
					$.messager.show({
						title:"操作提示",
						msg:"删除成功！",
						timeout:5000,
						showType:"slide"
					});
					refresh${className}List();
				} else {
					$.messager.alert("操作提示","删除失败！","error");
				}
			});
		}
	});
}


function batchRemove${className}(){
	$.messager.confirm('操作提示', '是否要删除该信息？', function(r){
		if(r){
			var rows = $('#${classNameVar}List').datagrid('getSelections');
			if (rows.length == 0) {
				$.messager.alert('提示', "请选择你要删除的学生！", 'info');
				return;
			}
			var ${classNameVar}Arr = [];
			$.each(rows, function(i, n) {
				${classNameVar}Arr.push(n.${classNameVar}Id);
			});
			$.post(window.parent.basePath+"/manager/batchDelete${className}",$.param({"${classNameVar}Arr":${classNameVar}Arr},true),function(data){
				if(data){
					//$.messager.alert("操作提示","删除成功！","info");
					$.messager.show({
						title:"操作提示",
						msg:"删除成功！",
						timeout:5000,
						showType:"slide"
					});
					refresh${className}List();
				} else {
					$.messager.alert("操作提示","删除失败！","error");
				}
			});
		}
	});
}