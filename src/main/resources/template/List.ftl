<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>Insert title here</title>
	</head>
	<body>
		<script type="text/javascript" src="${contextPath}/js/manager/${classNameVar}List.js"></script>
		<div id="tabdiv_${classNameVar}">
			<form method="post" id="search${className}FormId" action="${contextPath}/manager/${classNameVar}List" style="padding-top: 5px;">
				<table style="font-size: 12px;width :100%;height: 80px;border: #7b9ebd 1px solid;padding-top: 5px;" cellSpacing="0" cellPadding="0"
					border="0">
					<tr>
						<td nowrap style="padding-left: 5px;width: 660px">
							<#list columns as column>
								${column.remark}：<input name="${column.columnName}" type="text" />
							</#list>
						</td>
						<td align="left" style="padding-left: 15px;">
							<a id="search${className}Id" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
						</td>
					</tr>
				</table>
			</form>
			<table id="${classNameVar}List"></table>
		</div>
	</body>
</html>