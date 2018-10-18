package com._520it._01_pss.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com._520it._01_pss.domain.Student;
import com._520it._01_pss.handler.IResultSetHandler;

public class JDBCTemplate {
	
	
	/**
	 * 用于DML（添删改）操作
	 * @param sql 
	 * @param params 参数，几个占位符就有几个参数
	 * @return 
	 */
	public static int update (String sql,Object ...params){
		Connection connection =null;
		PreparedStatement statement =null;
		
		//1.jia
		try {
			connection = JdbcUtil.getconn();
			statement =connection.prepareStatement(sql);
			//设置参数
			for (int i = 0; i < params.length; i++) {
				statement.setObject(i+1, params[i]);
			}
			 int ret =statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//5.shi
			JdbcUtil.close(connection, statement, null);
			
		}
		return 0;
	}
		public static <T> T query (String sql,IResultSetHandler<T> handler,Object ...params){
			Connection connection =null;
			PreparedStatement statement =null;
			ResultSet resultSet = null;
			List<Student> list = new ArrayList<>();
			//1.jia
			try {
				connection = JdbcUtil.getconn();
				statement =connection.prepareStatement(sql);
				//设置参数
				for (int i = 0; i < params.length; i++) {
					statement.setObject(i+1, params[i]);
				}
				  resultSet = statement.executeQuery();
				  return   handler.handle(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				//5.shi
				JdbcUtil.close(connection, statement, resultSet);
				
			}
			
		return null;
	}
		

}
