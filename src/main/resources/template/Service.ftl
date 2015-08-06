package ${package};

import java.util.List;
import java.util.Map;

import com.koumi.framework.product.rcs.entity.${className};
import com.koumi.framework.product.rcs.util.DataGrid;

public interface ${className}Service {

	/**
	 * 获取jquery easyui DataGrid数据
	 * @param params
	 * @return
	 */
	public DataGrid queryDataGrid(Map<String, Object> params);
	
	/**
	 * 根据主键查询
	 * @param pkId
	 * @return
	 */
	public ${className} query${className}By${className}Id(int ${classNameVar}Id);
	
	/**
	 * 根据具体条件返回 数据库中的某一条数据对象
	 * @param ${classNameVar}
	 * @return
	 */
	public ${className} query${className}(${className} ${classNameVar});
	
	/**
	 * 根据具体条件返回 数据库中的某一条数据对象
	 * @param ${classNameVar}
	 * @return
	 */
	public ${className} query${className}(Map<String,Object> params);
	
	/**
	 * 查询所有数据
	 * @return
	 */
	public List<${className}> queryAll();
	
	
	/**
	 * 根据条件查询
	 * @param ${classNameVar}
	 * @return
	 */
	public List<${className}> query${className}ByCondition(${className} ${classNameVar});
	
	/**
	 * 根据条件查询,支持排序等
	 * @param ${classNameVar}
	 * @return
	 */
	public List<${className}> query${className}ByCondition(Map<String,Object> params);

	/**
	 * 添加
	 * @param ${classNameVar}
	 * @return
	 */
	public boolean save${className}(${className} ${classNameVar});
	
	/**
	 * 删除
	 * @param ${classNameVar}
	 * @return
	 */
	public boolean delete${className}(${className} ${classNameVar});
	
	/**
	 * 修改
	 * @param ${classNameVar}
	 * @return
	 */
	public boolean update${className}(${className} ${classNameVar});
	
	/**
	 * 批了删除
	 * @param batchArr
	 * @return
	 */
	public boolean batchDelete${className}(int[] batchArr);
	
}
