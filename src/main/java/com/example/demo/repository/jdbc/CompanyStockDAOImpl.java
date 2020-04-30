package com.example.demo.repository.jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.CompanyData;
import com.example.demo.repository.CompanyStockDAO;

@Repository
public class CompanyStockDAOImpl implements CompanyStockDAO{
	@Autowired
	JdbcTemplate jdbc;

	@Override
	public List<CompanyData> selectAll(String name) throws DataAccessException {
		// TODO 自動生成されたメソッド・スタブ
		List<Map<String,Object>> getList = jdbc.queryForList("Select * From Companydata" + " WHERE code like ?","%"+name+"%");
		if(getList.size() ==0) {
			getList = jdbc.queryForList("Select * From CompanyData" + " WHERE company_name like ?","%"+name+"%");
		}
		//結果返却用の変数
				List<CompanyData> companyList = new ArrayList<CompanyData>();

				//取得したデータを結果返却用のListへ格納していく
				for(Map<String,Object> map:getList) {
					//Productインスタンスの生成
					CompanyData companyData = new CompanyData();
					//Productインスタンスに取得したデータをセットする
					companyData.setCode((Integer)map.get("code"));
					companyData.setCompany_name((String)map.get("company_name"));
					companyData.setClassification((String)map.get("Classification"));
					companyData.setUnit_shares((String)map.get("unit_shares"));

					companyList.add(companyData);
				}
		return companyList;
	}

	@Override
	public List<Map<String, Object>> selectStock(String id) throws DataAccessException {
		// TODO 自動生成されたメソッド・スタブ
		List<Map<String,Object>> getList = jdbc.queryForList("Select * From CompanyStock WHERE code = ? order by number desc limit 30",id);

		return getList;
	}

	@Override
	public List<Map<String, Object>> selectStockM(String id, String Month) throws DataAccessException {
		// TODO 自動生成されたメソッド・スタブ
				//List<Map<String,Object>> getList = jdbc.queryForList("Select * From CompanyStock WHERE code = ? and Daily like ?",id,"%"+Month+"%");
		List<Map<String,Object>> getList = jdbc.queryForList("Select * From CompanyStock WHERE code = ? and Daily like ?",id,"%"+Month+"%");

				return getList;
	}

	@Override
	public List<Map<String, Object>> selectStockY(String id) throws DataAccessException {
		// TODO 自動生成されたメソッド・スタブ
		List<Map<String,Object>> getList = jdbc.queryForList("Select * From CompanyStock");
		return getList;
	}

	@Override
	public List<CompanyData> selectAll() throws DataAccessException {
		// TODO 自動生成されたメソッド・スタブ
		List<Map<String,Object>> getList = jdbc.queryForList("Select * From Companydata");
		if(getList.size() ==0) {
			getList = jdbc.queryForList("Select * From CompanyData");
		}
		//結果返却用の変数
				List<CompanyData> companyList = new ArrayList<CompanyData>();

				//取得したデータを結果返却用のListへ格納していく
				for(Map<String,Object> map:getList) {
					//Productインスタンスの生成
					CompanyData companyData = new CompanyData();
					//Productインスタンスに取得したデータをセットする
					companyData.setCode((Integer)map.get("code"));
					companyData.setCompany_name((String)map.get("company_name"));
					companyData.setClassification((String)map.get("Classification"));
					companyData.setUnit_shares((String)map.get("unit_shares"));

					companyList.add(companyData);
				}
		return companyList;
	}



}
