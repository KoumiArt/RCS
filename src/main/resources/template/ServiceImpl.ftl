package ${basePackage}.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import ${basePackage}.entity.${className};
import ${basePackage}.mapper.${className}Mapper;
import ${basePackage}.service.${className}Service;
import ${basePackage}.util.DataGrid;

@Service("${classNameVar}Service")
public class ${className}ServiceImpl implements ${className}Service {

	private ${className}Mapper ${classNameVar}Mapper;

	public void set${className}Mapper(${className}Mapper ${classNameVar}Mapper) {
		this.${classNameVar}Mapper = ${classNameVar}Mapper;
	}

	public boolean save${className}(${className} ${classNameVar}) {
		int result = ${classNameVar}Mapper.insert(${classNameVar});
		if (result == 1)
			return true;
		return false;
	}

	public boolean delete${className}(${className} ${classNameVar}) {
		int result = ${classNameVar}Mapper.delete(${classNameVar});
		if (result == 1)
			return true;
		return false;
	}

	public boolean update${className}(${className} ${classNameVar}) {
		int result = ${classNameVar}Mapper.update(${classNameVar});
		if (result == 1)
			return true;
		return false;
	}

	public boolean batchDelete${className}(int[] batchArr) {
		int result = ${classNameVar}Mapper.batchDelete(batchArr);
		if (result > 0)
			return true;
		return false;
	}

	public DataGrid queryDataGrid(Map<String, Object> params) {
		DataGrid dataGrid = new DataGrid();
		dataGrid.setTotal(${classNameVar}Mapper.selectPageCount(params));
		List<${className}> exams = ${classNameVar}Mapper.selectByPage(params);
		dataGrid.setRows(exams);
		return dataGrid;
	}

	public ${className} query${className}By${className}Id(int ${classNameVar}Id) {
		return ${classNameVar}Mapper.selectByPkId(${classNameVar}Id);
	}

	public ${className} query${className}(${className} ${classNameVar}) {
		return ${classNameVar}Mapper.selectByObject(${classNameVar});
	}

	public ${className} query${className}(Map<String, Object> params) {
		return ${classNameVar}Mapper.selectByObject(params);
	}

	public List<${className}> queryAll() {
		return ${classNameVar}Mapper.selectAll();
	}

	public List<${className}> query${className}ByCondition(${className} ${classNameVar}) {
		return ${classNameVar}Mapper.selectByCondition(${classNameVar});
	}

	public List<${className}> query${className}ByCondition(Map<String, Object> params) {
		return ${classNameVar}Mapper.selectByCondition(params);
	}

}
