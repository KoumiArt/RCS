<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Insert title here</title>
	</head>
	<body>
	<script type="text/javascript">
		$(function(){
			$("#${classNameVar}_backId").click(function() {
				closeWindow();
				refresh${className}List();
			});
			$("#stu_saveId").click(function() {
				var r = $("#${classNameVar}Form").form("validate");
				if(!r) {
					return false;
				}
				
				$.post(basePath+"/manager/save${className}",$("#${classNameVar}Form").serializeArray(),function(data){ 
					if(data !=null && $.trim(data) != "" && data == true){
						closeWindow();
						//$.messager.alert("操作提示","保存成功！","info");
						$.messager.show({
							title:"操作提示",
							msg:"保存成功！",
							timeout:5000,
							showType:"slide"
						});
						refresh${className}List();
					} else {
						$.messager.alert("操作提示","保存失败！","error");
					}						
				});
			});
		});
	</script>
  	<center>
		<form id="${classNameVar}Form" style="width:480;height:255;" action="${contextPath}/manager/saveResource" method="post">
			<table style="font-size: 13px;" width="480" height="255">
				<#list columns as column>
					<tr>
					<td width="100px">${column.remark}：</td>
					<td>
					<input type="text" name="${column.columnName}" class="easyui-validatebox" data-options="required:true" /></td>			
				</tr>
				</#list>
				<tr>
					<td align="center" colspan="2">
						<a id="${classNameVar}_backId" class="easyui-linkbutton" data-options="iconCls:'icon-back'">取消</a>
					<span style="width: 56px"></span>
						<a id="${classNameVar}_saveId" class="easyui-linkbutton" data-options="iconCls:'icon-save'">保存</a>
					</td>
				</tr>
			</table>
		</form>
	</center>
  </body>
</html>