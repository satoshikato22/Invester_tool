package com.example.demo.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class CompanyStock implements Serializable{
	private String code;
	private String Daily;
	private String end_price;
	private String start_price;
	private String high_price;
	private String low_price;
}
