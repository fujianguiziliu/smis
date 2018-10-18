package com._520it._01_pss.handler;

import java.sql.ResultSet;
import java.util.List;

public interface IResultSetHandler<T> {

	
	/**
	 * 处理传进来的结果集
	 * @param resultSet   执行查询语句之后，返回的结果集
	 * @return            将结果集包装后得到的对象集合：List<Student>
	 * @throws Exception
	 */
	T  handle(ResultSet resultSet ) throws Exception;
	
}
