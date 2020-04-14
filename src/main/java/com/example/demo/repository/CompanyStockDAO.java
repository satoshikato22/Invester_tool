package com.example.demo.repository;

import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.example.demo.model.CompanyData;

public interface CompanyStockDAO {
	public List<CompanyData> selectAll(String name) throws DataAccessException;
	public List<Map<String, Object>> selectStock(String id) throws DataAccessException;
	public List<Map<String, Object>> selectStockM(String id,String Month) throws DataAccessException;
	public List<Map<String, Object>> selectStockY(String id)throws DataAccessException;
}
