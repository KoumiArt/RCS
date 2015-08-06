package ${package};

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.koumi.framework.product.rcs.entity.${className};

/**
 * @author koumi
 *
 */
@Repository
public interface ${className}Mapper extends BaseMapper {
	
	/**
	 * 分页查询
	 * @param params
	 * @return
	 */
	public List<${className}> selectByPage(Map<String,Object> params);
	
	/**
	 * 分页查询的count
	 * @param params
	 * @return
	 */
	public int selectPageCount(Map<String,Object> params);
	
	/**
	 * 根据主键查询
	 * @param pkId
	 * @return
	 */
	public ${className} selectByPkId(int pkId);
	
	/**
	 * 根据具体条件返回 数据库中的某一条数据对象
	 * @param ${classNameVar}
	 * @return
	 */
	public ${className} selectByObject(${className} ${classNameVar});
	
	/**
	 * 根据具体条件返回 数据库中的某一条数据对象
	 * @param params
	 * @return
	 */
	public ${className} selectByObject(Map<String,Object> params);
	
	/**
	 * 查询所有数据
	 * @return
	 */
	public List<${className}> selectAll();
	
	
	/**
	 * 根据条件查询
	 * @param ${classNameVar}
	 * @return
	 */
	public List<${className}> selectByCondition(${className} ${classNameVar});
	
	/**
	 * 根据条件查询,支持排序等
	 * @param params
	 * @return
	 */
	public List<${className}> selectByCondition(Map<String,Object> params);
}
