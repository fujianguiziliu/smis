package com._520it._01_pss.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.omg.CORBA.PRIVATE_MEMBER;

import com._520it._01_pss.dao.IStudentDAO;
import com._520it._01_pss.domain.Student;
import com._520it._01_pss.handler.BeanHandler;
import com._520it._01_pss.handler.IResultSetHandler;
import com._520it._01_pss.util.JDBCTemplate;
import com._520it._01_pss.util.JdbcUtil;

public class StudentDAOImpl implements IStudentDAO{

	//--------------------------------------DML--------------------------
	@Override
	public void save(Student student) {
	
		String sql = "INSERT INTO t_beauty (name ,age) VALUES (?,?)";
		Object[] params = {student.getName(),student.getAge()};
		JDBCTemplate.update(sql, params);
//		Connectioobjn  connection= null;
//		PreparedStatement statement = null;
//		try{
//			connection = JdbcUtil.getconn();
//			//3.yu
//			 statement = connection.prepareStatement(sql);
//			 statement.setString(1, student.getName());
//			 statement.setInt(2, student.getAge());
//			//4.zhi
//			 statement.executeUpdate();
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//		}
//		//5.shi
//		JdbcUtil.close(connection, statement, null);
	}

	@Override
	public void delete(Long id) {
		String sql = "DELETE FROM t_beauty WHERE id = ?" ;
		Object[] params ={id};
		JDBCTemplate.update(sql, params);
//		Connection  connection= null;
//		PreparedStatement statement = null;
//		//1.jia
//		try {
//			connection = JdbcUtil.getconn();
//			//3.yu
//			 statement = connection.prepareStatement(sql);
//			statement.setLong(1, id);
//			//4.zhi
//			 statement.executeUpdate();
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//		}
//		//5.shi
//		JdbcUtil.close(connection, statement, null);
		
	}

	@Override
	public void update(Student student) {
		/*StringBuilder sb = new StringBuilder(50);
		sb.append("UPDATE t_beauty SET ");
		sb.append("name = '").append(student.getName()).append("' ");
		sb.append(", ");
		sb.append(" age =  ").append(student.getAge());
		sb.append(" WHERE id = ").append(id);*/
		String sql = "UPDATE t_beauty SET name =? , age =? WHERE id = ?";
		Object[] params ={student.getName(),student.getAge(),student.getId()};
		JDBCTemplate.update(sql, params);
//		System.out.println(sb.toString());
		/*Connection connection =null;
		PreparedStatement statement =null;
		
		//1.jia
		try {
			connection = JdbcUtil.getconn();
			statement =connection.prepareStatement(sql);
			statement.setString(1, student.getName());
			statement.setInt(2, student.getAge());
			statement.setLong(3, id);
			//4.zhi
			int ret = statement.executeUpdate( );
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//5.shi
			JdbcUtil.close(connection, statement, null);
			
		}*/
		
	}
		//----------------------------------DQL----------------------
	@Override
	public Student get(Long id) {
		/*Connection connection = null;
		PreparedStatement statement =null;
		ResultSet resultSet = null;*/
		String sql = "SELECT id, name, age FROM t_beauty WHERE id = ?" ;
		return  JDBCTemplate.query(sql, new BeanHandler<Student>(Student.class), new Object[]{id});
		
		/*//1.jia
		try {
			connection = JdbcUtil.getconn();
			//3.yu
			statement = connection.prepareStatement(sql);
			//4.zhi
			statement.setLong(1, id);
			 resultSet = statement.executeQuery();
			

			Student student = new Student();
			if (resultSet.next()) {
				student.setId(resultSet.getLong("id"));
				student.setName(resultSet.getString("name"));
				student.setAge(resultSet.getInt("age"));
			}
			return student;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//5.shi
			JdbcUtil.close(connection, statement, resultSet);
		}
		return null;*/
	}

	@Override
	public List<Student> listAll() {
		
		String sql = "SELECT id, name, age FROM t_beauty";
		List<Student> list = JDBCTemplate.query(sql, new StudentResultSetHandler());
		return list;
	}
	private class StudentResultSetHandler implements IResultSetHandler<List<Student>>{
		
	@Override
	public List<Student> handle(ResultSet resultSet ) throws Exception{
	List<Student> list =new ArrayList<>();
		while (resultSet.next()) {
			Student student = new Student();
			student.setId(resultSet.getLong("id"));
			student.setName(resultSet.getString("name"));
			student.setAge(resultSet.getInt("age"));
			list.add(student);
		}
		return list;
	}
}
}	

			/*List<Student> list = new ArrayList<>();
			Connection connection = null;
			PreparedStatement statement =null;
			ResultSet resultSet = null;
			String sql = "SELECT id, name, age FROM t_beauty";
			
			
			//1.jia
			try {
					connection = JdbcUtil.getconn();
					statement = connection.prepareStatement(sql);
						//4.zhi
					 resultSet = statement.executeQuery();
						

						
					while (resultSet.next()) {
							Student student = new Student();
							student.setId(resultSet.getLong("id"));
							student.setName(resultSet.getString("name"));
							student.setAge(resultSet.getInt("age"));
							list.add(student);
						}
						return list;
					} catch (Exception e) {
						e.printStackTrace();
					}finally{
						//5.shi
						JdbcUtil.close(connection, statement, resultSet);
					}	*/
	/*		
			return list;
	}
}
	*/


