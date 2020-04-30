package com.example.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.CompanyData;
import com.example.demo.service.CompanyStockService;

@Controller
public class CompanyStockController {
	@Autowired
	CompanyStockService companyStockService;
	@GetMapping("/search")
	public String GetSearch(Model model) {
		List<CompanyData> companyList = companyStockService.selectAll();
		model.addAttribute("companyList",companyList);

		return "Company/search";

	}
	@GetMapping("/search/result")
	public String GetResult(Model model,@RequestParam("name") String name) {
		List<CompanyData> companyList = companyStockService.selectAll(name);
		model.addAttribute("companyList",companyList);

		return "Company/search";

	}
	@GetMapping("/search/company")
	public String GetCompany(@RequestParam("id") String id,Model model) {
		/*
		 * Idを使用し、企業株DBへアクセスし、株価をリアルタイム表示可能。
		 * かつ、歴代株価のグラフを表示可能にする
		 */
		List<String> list1 = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();
        List<String> list3 = new ArrayList<String>();
        List<String> modorichi = new ArrayList<String>();

	    //try-catch文が必要
	    try {
	        //Document A = Jsoup.connect("url").get(); urlにスクレイピング対象
	        //Document doc = Jsoup.connect("http://archaeology.jp/learning/university/2018kougiichiran/#").get();
	    	String url = "https://minkabu.jp/stock/"+id;
	    	Document doc = Jsoup.connect(url).get();

	        //Elements B = A.select("タグ"); この形でソースに含まれるタグで指定された範囲を書き出す。
	        Elements elm1 = doc.select("div.stock_price");// dd.ly_vamd_inner
	        Elements elm2 = doc.select("dt.ly_vamd_inner.ly_colsize_3_fix.wsnw");
	        Elements elm3 = doc.select("dd.ly_vamd_inner.ly_colsize_9_fix.fwb.tar.wsnw");


	        //拡張for文

	        for(Element elms : elm1) {
	            String title = elms.text();
	            	list1.add("終値"+" "+title);
	        }


	        for(Element elms : elm2) {
	            String title = elms.text();
	            	list2.add(title);
	        }
	        for(Element elms : elm3) {
	            String title = elms.text();
	                list3.add(title);
	        }

	        //例外処理
	    }catch(IOException e) {
	        e.printStackTrace();
	    }
	    for(int i = 0;i <list2.size()-1;i++) {
	    	if(i == 0) {
	    		modorichi.add(list1.get(i));
	    	}else {
	    		modorichi.add(list2.get(i-1)+" "+list3.get(i-1));
	    	}
	    }

/*
	    List<Map<String, Object>> getList = companyStockService.selectStock(id);

        // グラフの横軸と縦軸の値を、それぞれString、int型の配列に格納しておきます。

        // 横軸
        // ラベルです。String型の配列に、適当に値を入れておきます。
    	List<String> label = new ArrayList<String>();
    	List<String> point = new ArrayList<String>();
    	List<String> label1 = new ArrayList<String>();
    	List<String> point1 = new ArrayList<String>();

		//取得したデータを結果返却用のListへ格納していく
		for(Map<String, Object> map:getList) {
			//Productインスタンスの生成
			CompanyStock stock = new CompanyStock();
			//Productインスタンスに取得したデータをセットする
			stock.setDaily((String)map.get("Daily"));
			stock.setEnd_price((String)map.get("end_price"));

			//結果返却用のListに追加
			label.add(stock.getDaily());
			point.add(stock.getEnd_price());
		}

		for(int i = label.size()-1;0 <= i;i--) {
			label1.add(label.get(i));
		}
		for(int i = point.size()-1;0 <= i;i--) {
			point1.add(point.get(i));
		}

        // 縦軸
        // 具体的な値です。int型で、この値も適当です。

        // Modelに格納します。ビュー側でグラフ用の配列を受け取れるようにしておきます。
        model.addAttribute("label",label1);
        model.addAttribute("point",point1);
 */
	    model.addAttribute("modorichi",modorichi);
	    model.addAttribute("id",id);

		return "Company/companyInformation";

	}

}
