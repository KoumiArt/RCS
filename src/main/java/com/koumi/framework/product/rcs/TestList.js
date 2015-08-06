$(function($) {
	$('#testList').datagrid(
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
					url : basePath+"/manager/testList",
					
					idField : 'sId', //主键字段
					pagination : true, //显示分页
					rownumbers : true, //显示行号
					columns : [ [  {
						[{"title":"主键","field":"id","width":200,"rowspan":null,"colspan":null,"align":"center","halign":null,"sortable":null,"order":null,"resizable":null,"fixed":null,"hidden":null,"checkbox":null,"formatter":null,"styler":null,"sorter":null,"editor":null,"value":null},{"title":"名称","field":"Name","width":200,"rowspan":null,"colspan":null,"align":"center","halign":null,"sortable":null,"order":null,"resizable":null,"fixed":null,"hidden":null,"checkbox":null,"formatter":null,"styler":null,"sorter":null,"editor":null,"value":null},{"title":"性别","field":"Sex","width":200,"rowspan":null,"colspan":null,"align":"center","halign":null,"sortable":null,"order":null,"resizable":null,"fixed":null,"hidden":null,"checkbox":null,"formatter":null,"styler":null,"sorter":null,"editor":null,"value":null}]
					},
					{
						field : 'opt',
						title : '操作',
						width : 400,
						align : 'center',
						rowspan : 2,
						formatter : function(value, rec) {
							return '<input type="button" onclick="testEdit('+rec.testId+')" class="button_Csss" value="修改" /> <input type="button" onclick="removeTest('+rec.testId+')" class="button_Csss" value="删除" />';
						}
					} ] ],
					toolbar : [ {
						text : '新增',
						iconCls : 'icon-add',
						handler : function() {
							testEdit();
						}
					},{
						text : '批量删除',
						iconCls : 'icon-remove',
						handler : function() {
							batchRemoveTest();
						}
					}],
					onLoadSuccess : function() {
						$('#testList').datagrid('clearSelections'); //一定要加上这一句，要不然datagrid会记住之前的选择状态，删除时会出问题
						$("#testList").datagrid('resize',{
							width:'auto'});
					}
				});
	
	$("#searchTestId").click(function(){
		var params = $('#testList').datagrid('options').queryParams; //先取得 datagrid 的查询参数
		var fields = $('#searchTestFormId').serializeArray(); //自动序列化表单元素为JSON对象
		$.each(fields, function(i, field) {
			params[field.name] = field.value; //设置查询参数
		});
		refreshTestList();
	});
});

//重新加载列表
function refreshTestList() {
	$('#testList').datagrid('reload');
}


function testEdit(testId){
	var url = basePath+'/jsp/manager/editTest.jsp';
	var title = "新增";
	if(testId!=undefined && testId !=null && testId !=""){
		url = url + "?testId="+testId;
		title = "修改";
	}
	showWindow({
			title:title,
			href:url,
			width:530,
			height:350,
			onLoad:function(){
				if(testId!=null&&testId!=""&&testId!=undefined){
					$.post(basePath+"/manager/getTest",{"testId":testId},function(data){
							$("#testForm").append("<input type='hidden' name='testId' value='"+testId+"'/>");
							$("#testForm input[name=Name]").val(data.Name);
							$("#testForm input[name=Sex]").val(data.Sex);
						
					});
				}
			}
		});
}

function removeTest(testId){
	$.messager.confirm('操作提示', '是否要删除该信息？', function(r){
		if(r){
			$.post(basePath+"/manager/deleteTest",{"testId":testId},function(data){
				if(data){
					//$.messager.alert("操作提示","删除成功！","info");
					$.messager.show({
						title:"操作提示",
						msg:"删除成功！",
						timeout:5000,
						showType:"slide"
					});
					refreshTestList();
				} else {
					$.messager.alert("操作提示","删除失败！","error");
				}
			});
		}
	});
}


function batchRemoveTest(){
	$.messager.confirm('操作提示', '是否要删除该信息？', function(r){
		if(r){
			var rows = $('#testList').datagrid('getSelections');
			if (rows.length == 0) {
				$.messager.alert('提示', "请选择你要删除的学生！", 'info');
				return;
			}
			var testArr = [];
			$.each(rows, function(i, n) {
				testArr.push(n.testId);
			});
			$.post(window.parent.basePath+"/manager/batchDeleteTest",$.param({"testArr":testArr},true),function(data){
				if(data){
					//$.messager.alert("操作提示","删除成功！","info");
					$.messager.show({
						title:"操作提示",
						msg:"删除成功！",
						timeout:5000,
						showType:"slide"
					});
					refreshTestList();
				} else {
					$.messager.alert("操作提示","删除失败！","error");
				}
			});
		}
	});
}