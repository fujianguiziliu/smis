package com._520it._01_pss.handler;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.util.List;




public class BeanHandler<T> implements IResultSetHandler<T>{

	private Class<T> clz;
	public BeanHandler(Class<T> clz) {
		this.clz =clz;
	}
	@Override
	public T handle(ResultSet resultSet) throws Exception {
		
		T t = clz.newInstance();
		if (resultSet.next()) {
			BeanInfo beanInfo = Introspector.getBeanInfo(clz,Object.class);
			PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
			
			for (PropertyDescriptor pd : pds) {
				Object name = pd.getName();
				Object value = resultSet.getObject(name.toString());
				
				Method writeMethod = pd.getWriteMethod();
			writeMethod.invoke(t, value);
				
			}
		}
		
			return t;
	
	}
}
