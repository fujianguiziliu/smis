package com._520it._01_pss.handler;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BeanListHandler<T> implements IResultSetHandler<List<T>>{

	private Class<T> clz;
	public BeanListHandler(Class<T> clz){
		this.clz=clz;
	}
	@Override
	public List<T> handle(ResultSet resultSet) throws Exception {
		List<T> list = new ArrayList<>();
		while (resultSet.next()) {
			T t = clz.newInstance();
			BeanInfo beanInfo = Introspector.getBeanInfo(clz,Object.class);
			PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
			
			for (PropertyDescriptor pd : pds) {
				String name =pd.getName();
				Object object = resultSet.getObject(name);
				
				pd.getWriteMethod().invoke(t, object);
				
			}
			list.add(t);
			
		}
		return list;
	
}

		
	
}
