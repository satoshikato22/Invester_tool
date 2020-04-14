package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.repository.ChartDAO;

@Service
public class ChartService {
	@Autowired
	ChartDAO dao;
	public List<Map<String, Object>> selectAllM(String Month) throws DataAccessException {
		List<Map<String, Object>> getList = dao.selectAllM(Month);
		return getList;
	}
	public List<Map<String, Object>> selectAllY() throws DataAccessException {
		List<Map<String, Object>> getList = dao.selectAllY();
		return getList;
	}
	public List<Map<String, Object>> selectAllD() throws DataAccessException {
		List<Map<String, Object>> getList = dao.selectAllD();
		return getList;
	}

}
