package com.example.demo.repository.jdbc;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.ChartDAO;
@Repository
public class ChartDAOImpl implements ChartDAO{
	@Autowired
	JdbcTemplate jdbc;
	@Override
	public List<Map<String, Object>> selectAllM(String Month) throws DataAccessException {
		// TODO 自動生成されたメソッド・スタブ
		List<Map<String,Object>> getList = jdbc.queryForList("Select * From M_Nikkei_average" + " WHERE Month like ?","%"+Month+"%");

				return getList;
	}
	@Override
	public List<Map<String, Object>> selectAllY() throws DataAccessException {
		// TODO 自動生成されたメソッド・スタブ
		List<Map<String,Object>> getList = jdbc.queryForList("Select * From Y_Nikkei_average");
		return getList;
	}
	@Override
	public List<Map<String, Object>> selectAllD() throws DataAccessException {
		// TODO 自動生成されたメソッド・スタブ
		List<Map<String,Object>> getList = jdbc.queryForList("Select * From D_Nikkei_average order by number desc limit 7");
		return getList;
	}

}
