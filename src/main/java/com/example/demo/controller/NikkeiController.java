package com.example.demo.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.Nikkei;

@Controller
public class NikkeiController {
	@GetMapping("/Nikkei_average")
	public String GetNikkei(Model model) {

	    //try-catch文が必要
	    try {

	        //Document A = Jsoup.connect("url").get(); urlにスクレイピング対象
	        //Document doc = Jsoup.connect("http://archaeology.jp/learning/university/2018kougiichiran/#").get();
	    	Document doc1 = Jsoup.connect("https://minkabu.jp/stock/100000018").get();
	    	Document doc2 = Jsoup.connect("https://minkabu.jp/stock/100000018").get();
	        //Elements B = A.select("タグ"); この形でソースに含まれるタグで指定された範囲を書き出す。
	        Elements elm1 = doc1.select(".stock_price");
	        Elements elm2 = doc2.select("li.ly_vamd");
	        ArrayList<String> Nikkei_Data = new ArrayList<String>();

	        //拡張for文
	        /*
	        for(Element elms : elm) {
	            String title = elms.text();
	            System.out.println(title);
	        }*/
	        for (int i = 0;i <1;i++) {
	        	Nikkei_Data.add("日経平均 "+elm1.get(i).text());
	        }

	        for (int i = 0;i <=2;i++) {
	        	Nikkei_Data.add(elm2.get(i).text());
	        }
	        Nikkei nikkei = new Nikkei(Nikkei_Data.get(0),Nikkei_Data.get(1),Nikkei_Data.get(2),Nikkei_Data.get(3));
	        model.addAttribute("nikkei",nikkei);

	        //例外処理
	    }catch(IOException e) {
	        e.printStackTrace();
	    }

		return "Nikkei/Nikkei_average";

	}
}
