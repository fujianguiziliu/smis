package com._520it._01_pss.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;




public class JdbcUtil {

	
//	private static String url ;
//	private static String username ;
//	private static String password ;
	private static DataSource dataSource ;
	
	static{
		try {
			InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties");
			Properties properties = new Properties();
			properties.load(inputStream);
			
			/*Class.forName(properties.getProperty("driverClassName"));
			url=properties.getProperty("url");
			username=properties.getProperty("username");
			password=properties.getProperty("password");*/
			//dataSource = BasicDataSourceFactory.createDataSource(properties);
			
			dataSource=DruidDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static Connection getconn(){
		
		//1.jia
				try {
					
					//2.lian
					return  dataSource.getConnection() ;
				}catch (Exception e) {
					e.printStackTrace();
				}
		
		return null;
			
	}
	
	public static void close
	(Connection connection ,Statement statement ,ResultSet resultSet ){
		
		//5.shi
		try {
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			if (statement != null) {
				statement.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

			try {
				if (connection != null ) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	
		
		
	}
	
	
	

