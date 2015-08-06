package ${package};

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koumi.framework.product.rcs.entity.${className};
import com.koumi.framework.product.rcs.service.${className}Service;
import com.koumi.framework.product.rcs.util.DataGrid;


@Controller
public class ${className}Controller {
	
	private ${className}Service ${classNameVar}Service;
	
	public void set${className}Service(${className}Service ${classNameVar}Service) {
		this.${classNameVar}Service = ${classNameVar}Service;
	}

	@RequestMapping("/${classNameVar}List")
	@ResponseBody
	public DataGrid get${className}List(int page, int rows,${className} ${classNameVar}){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("begin", ((page-1)*rows)+1);
		map.put("end", page*rows);
		map.put("${classNameVar}", ${classNameVar});
		return ${classNameVar}Service.queryDataGrid(map);
	}
	
	@RequestMapping("/save${className}")
	@ResponseBody
	public boolean save${className}(${className} ${classNameVar}){
		boolean result = false;
<#list columns as column>
	<#if column.pk == 1>
		<#if column.columnType.javaType == "int">
		if(${classNameVar}.get${statics["com.koumi.framework.product.rcs.util.SystemUtils"].firstToUpperCase(column.property)}() >0){
		<#else>
		if(SystemUtils.isEmpy(${classNameVar}.get${statics["com.koumi.framework.product.rcs.util.SystemUtils"].firstToUpperCase(column.property)}()){
		</#if>
	</#if>
</#list>
			result = ${classNameVar}Service.update${className}(${classNameVar});
		} else {
			result = ${classNameVar}Service.save${className}(${classNameVar});
		}
		return result;
	}

	@RequestMapping("/get${className}")
	@ResponseBody
	public ${className} get${className}(int ${classNameVar}Id){
		return ${classNameVar}Service.query${className}By${className}Id(${classNameVar}Id);
	}
	
	@RequestMapping("/delete${className}")
	@ResponseBody
	public boolean delete${className}(${className} ${classNameVar}){
		return ${classNameVar}Service.delete${className}(${classNameVar});
	}
	
	@RequestMapping("/batchDelete${className}")
	@ResponseBody
	public boolean batchDelete${className}(int[] ${classNameVar}Arr){
		return ${classNameVar}Service.batchDelete${className}(${classNameVar}Arr);
	}
}