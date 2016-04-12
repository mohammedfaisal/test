package com.mycompany.project.dao.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mycompany.project.dao.StudentDao;
/**
 * 
 * @author Mohammed.Faisal
 *
 */
@Repository
public class StudentDaoImpl implements StudentDao {
	
	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;
	
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public DataSource getDataSource() {
		return dataSource;
	}
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);
		System.err.println("JDBC Template Initialized");
	}
	@Override
	public Long count() {
		System.out.println("counting student records");
		return this.jdbcTemplate.queryForLong("select count(*) from student");
	}
	
	
	
	
}
