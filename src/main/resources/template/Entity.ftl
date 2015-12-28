package ${basePackage}.entity;

public class ${className} {
	<#list columns as column> 
	private ${column.columnType.javaType} ${column.property};
	public ${column.columnType.javaType} get${statics["com.koumi.framework.product.rcs.util.SystemUtils"].firstToUpperCase(column.property)}() {
		return ${column.property};
	}

	public void set${statics["com.koumi.framework.product.rcs.util.SystemUtils"].firstToUpperCase(column.property)}(${column.columnType.javaType} ${column.property}) {
		this.${column.property} = ${column.property};
	}
	</#list>	
}
