package com.koumi.framework.product.rcs.mapper;

import org.apache.ibatis.annotations.Param;

public interface BaseMapper {

	public <T> int insert(T t);

	public <T> int delete(T t);

	public <T> int update(T t);
	
	public int batchDelete(@Param("batchArr") int[] batchArr);
	
}
