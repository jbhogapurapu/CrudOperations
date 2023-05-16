package com.service;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import com.model.EmployeeModel;



@Service
public class EmployeeService {
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public EmployeeModel insertData(EmployeeModel employeeModel) {
/*	
 * 		
 		int id = employeeModel.getEid();
		String name = employeeModel.getEname();
		int exp = employeeModel.getExp();
		int salary = employeeModel.getSalary();
		String sql = "INSERT INTO employee (eid,ename,exp,salary) values (?,?,?,?)";
		int result = jdbcTemplate.update(sql,id,name,exp,salary);
		
		*
		*/
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("id", employeeModel.getEid())
				.addValue("ename", employeeModel.getEname()).addValue("exp", employeeModel.getExp())
				.addValue("salary", employeeModel.getSalary());
		String sql = "INSERT INTO employee (eid,ename,exp,salary) values (:id,:ename, :exp,:salary)";
		int result = namedParameterJdbcTemplate.update(sql, sqlParameterSource);

		if (result > 0) {
			return employeeModel;
		} else {
			return employeeModel;
		}
	}

	public EmployeeModel  update(EmployeeModel employeeModel) {
		{
			int id = employeeModel.getEid();
			String name = employeeModel.getEname();
			int exp = employeeModel.getExp();
			int sal = employeeModel.getSalary();
			String sql = "UPDATE employee SET ename=?, exp=?, salary=? WHERE eid =?";
			int result = jdbcTemplate.update(sql, name, exp, sal, id);
//			SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("eid", employeeModel.getEid())
//					.addValue("ename", employeeModel.getEname()).addValue("exp", employeeModel.getExp())
//					.addValue("salary", employeeModel.getSalary());
//			String sql = "UPDATE EMPLOYEE SET ENAME = :ename, EXP = :exp WHERE EID = :eid";
//			int result = namedParameterJdbcTemplate.update(sql, sqlParameterSource);
			if (result > 0) {
				return employeeModel;
			} else {
				return employeeModel;

			}
		}

	}

	public EmployeeModel deleteId(EmployeeModel employeeModel, int  id) {

//		String sql = "DELETE  from employee   WHERE eid=?";
//		int result = jdbcTemplate.update(sql, id);
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("eid", id);
		String sql = "DELETE  from employee   WHERE eid=:eid";
		int result = namedParameterJdbcTemplate.update(sql, sqlParameterSource);
		if (result > 0) {
			return employeeModel;
		} else {
			return employeeModel;

		}
	}

	public String deleteName(String name) {

//		String sql = "DELETE  from employee   WHERE ename=?";
//		int result = jdbcTemplate.update(sql, name);
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("ename", name);
		String sql = "DELETE FROM EMPLOYEE WHERE ENAME = :ename";
		int result = namedParameterJdbcTemplate.update(sql, sqlParameterSource);
		if (result > 0) {
			return "Deleted Successfully";
		} else {
			return "Not Deleted ";

		}
	}

	public List<Map<String, Object>> fetchName(String name) {
//		String sql = "SELECT * FROM EMPLOYEE WHERE ENAME = ?";
//		List<Map<String, Object>> result = jdbcTemplate.queryForList(sql, name);
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("ename", name);
		String sql = "SELECT * FROM EMPLOYEE WHERE ENAME = :ename";
		List<Map<String, Object>> result = namedParameterJdbcTemplate.queryForList(sql, sqlParameterSource);
		return result;

	}

	public List<Map<String, Object>> fetchId(int id) {
//		String sql = "SELECT * FROM EMPLOYEE WHERE EID = ?";
//		List<Map<String, Object>> result = jdbcTemplate.queryForList(sql, id);
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("eid", id);
		String sql = "SELECT * FROM EMPLOYEE WHERE EID = :eid"
				+ "";
		List<Map<String, Object>> result = namedParameterJdbcTemplate.queryForList(sql, sqlParameterSource);
		return result;

	}

	public List<Map<String, Object>> fetch() {
//		String sql = "SELECT * FROM EMPLOYEE";
//	List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource();
		String sql = "SELECT * FROM EMPLOYEE";
		List<Map<String, Object>> result = namedParameterJdbcTemplate.queryForList(sql, sqlParameterSource);
		return result;
	}

	public String delete() {
		SqlParameterSource sqlParameterSource = new MapSqlParameterSource();
		String sql = "DELETE  FROM EMPLOYEE";
		int result = namedParameterJdbcTemplate.update(sql, sqlParameterSource);
		if (result > 0) {
			return "Deleted Successfully";
		} else {
			return "Not Deleted ";

		}
	}
	public List<EmployeeModel> filter(EmployeeModel employeeModel)
	{
		int id = employeeModel.getEid();
		String name = employeeModel.getEname();
		int experience = employeeModel.getExp();
		int salary = employeeModel.getSalary();
//		SqlParameterSource sqlParameterSource = new MapSqlParameterSource().addValue("eid", id);
		List result = null;
		String sql = "SELECT * FROM EMPLOYEE WHERE ";
	
		if(id!=0)
		{
			 String addID = "EID = ?";
			 sql+=addID;
			 result = jdbcTemplate.queryForList(sql,id);
			 System.out.println(sql);
						 
		}
		else if(name!="")
		{
			String addName = "ENAME = ?";
			sql+=addName;
			result = jdbcTemplate.queryForList(sql,name);
			System.out.println(sql);
			
		}
		if (name!="" && experience!=0) {
				String id_name = "exp=? and ename=?";
				sql+=id_name;
				result = jdbcTemplate.queryForList(sql,experience,name);
				System.out.println(sql);
			}
		else if(id==0 && name== "") {
			String query = "SELECT * FROM EMPLOYEE";
			result = jdbcTemplate.queryForList(query);
			System.out.println(query);
		}
		else {
			
			result = jdbcTemplate.queryForList(sql);
			System.out.println(sql);
			
		}
		return result;

	}

}
