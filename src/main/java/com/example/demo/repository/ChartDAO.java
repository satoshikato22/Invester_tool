package com.example.demo.repository;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

public interface ChartDAO {
	public List<Map<String, Object>> selectAllM(String Month) throws DataAccessException;
	public List<Map<String, Object>> selectAllY() throws DataAccessException;
	public List<Map<String, Object>> selectAllD() throws DataAccessException;
	
}
