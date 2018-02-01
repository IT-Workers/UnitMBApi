package com.unitmb.api.internal.dao;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 * @author Sun yan
 */
public abstract class UnitMBApiDao {
	
	@Resource
	protected JdbcTemplate jdbcTemplate;
	
	protected <T> RowMapper<T> rowMapper(Class<?> clazz){
		return new RowMapper<T>() {
			@SuppressWarnings("unchecked")
			@Override
			public T mapRow(ResultSet rs, int rowNum) throws SQLException {
				T t = null;
				try {
					t = (T) clazz.newInstance();
					Field[] fields = clazz.getDeclaredFields();
					for (Field field : fields) {
						field.setAccessible(true);
						if(Modifier.isFinal(field.getModifiers())) {
							continue;
						}
						field.set(t, rs.getObject(field.getName()));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return t;
			}
		};
	}
}
