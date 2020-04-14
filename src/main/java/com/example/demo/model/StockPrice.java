package com.example.demo.model;

import java.io.Serializable;

import lombok.Data;
@Data
public class StockPrice implements Serializable{
	private String Data;
	private String end_price;
	private String start_price;
	private String high_price;
	private String low_price;
	private String Volum;
	private String The_day_before_ratio;

}
