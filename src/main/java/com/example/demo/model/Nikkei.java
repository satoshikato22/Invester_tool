package com.example.demo.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Nikkei implements Serializable{
	private String averageStock;
	private String startPrice;
	private String highPrice;
	private String lowPrice;

	public Nikkei(String averageStock,String startPrice,String highPrice,String lowPrice){
		this.averageStock = averageStock;
		this.startPrice = startPrice;
		this.highPrice = highPrice;
		this.lowPrice = lowPrice;
	}
}
