package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.model.CompanyData;
import com.example.demo.repository.CompanyStockDAO;

@Service
public class CompanyStockService {
	@Autowired
	CompanyStockDAO dao;
	public List<CompanyData> selectAll(String name) throws DataAccessException {
		List<CompanyData> companyList = dao.selectAll(name);
		return companyList;
	}
	public List<Map<String, Object>> selectStock(String id) throws DataAccessException {
		List<Map<String, Object>> getList= dao.selectStock(id);
		return getList;
	}

}
