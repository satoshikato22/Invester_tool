package com.example.demo.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.CompanyStock;
import com.example.demo.model.StockPrice;
import com.example.demo.service.ChartService;
import com.example.demo.service.CompanyStockService;

@Controller
public class ChartController {
	@Autowired
	ChartService chartService;
	@Autowired
	CompanyStockService companyStockService;
    @PostMapping("/M_chart")
    // ビュー側にグラフで使う値を渡すためにModelを引数にとっておきます。
    public String GetM_chart(Model model,@RequestParam("Month") String Month) {
    	List<Map<String, Object>> getList = chartService.selectAllM(Month);

        // グラフの横軸と縦軸の値を、それぞれString、int型の配列に格納しておきます。

        // 横軸
        // ラベルです。String型の配列に、適当に値を入れておきます。
    	List<String> label = new ArrayList<String>();
    	List<String> point = new ArrayList<String>();
		//結果返却用の変数
    	List<Map<String, Object>> StockList = new ArrayList<>();

		//取得したデータを結果返却用のListへ格納していく
		for(Map<String,Object> map:getList) {
			//Productインスタンスの生成
			StockPrice stock = new StockPrice();
			//Productインスタンスに取得したデータをセットする
			stock.setData((String)map.get("Month"));
			stock.setEnd_price((String)map.get("end_price"));


			//結果返却用のListに追加
			label.add(stock.getData());
			point.add(stock.getEnd_price());
		}

        // 縦軸
        // 具体的な値です。int型で、この値も適当です。

        // Modelに格納します。ビュー側でグラフ用の配列を受け取れるようにしておきます。
        model.addAttribute("label",label);
        model.addAttribute("point",point);

        return "chart";
    }

    @GetMapping("/Y_chart")
    // ビュー側にグラフで使う値を渡すためにModelを引数にとっておきます。
    public String GetY_chart(Model model) {
    	List<Map<String, Object>> getList = chartService.selectAllY();

        // グラフの横軸と縦軸の値を、それぞれString、int型の配列に格納しておきます。

        // 横軸
        // ラベルです。String型の配列に、適当に値を入れておきます。
    	List<String> label = new ArrayList<String>();
    	List<String> point = new ArrayList<String>();
		//結果返却用の変数
    	List<Map<String, Object>> StockList = new ArrayList<>();

		//取得したデータを結果返却用のListへ格納していく
		for(Map<String,Object> map:getList) {
			//Productインスタンスの生成
			StockPrice stock = new StockPrice();
			//Productインスタンスに取得したデータをセットする
			stock.setData((String)map.get("Year"));
			stock.setEnd_price((String)map.get("end_price"));


			//結果返却用のListに追加
			label.add(stock.getData());
			point.add(stock.getEnd_price());
		}

        // 縦軸
        // 具体的な値です。int型で、この値も適当です。

        // Modelに格納します。ビュー側でグラフ用の配列を受け取れるようにしておきます。
        model.addAttribute("label",label);
        model.addAttribute("point",point);

        return "chart";
    }

    @GetMapping("/D_chart")
    // ビュー側にグラフで使う値を渡すためにModelを引数にとっておきます。
    public String GetD_chart(Model model) {
    	List<Map<String, Object>> getList = chartService.selectAllD();

        // グラフの横軸と縦軸の値を、それぞれString、int型の配列に格納しておきます。

        // 横軸
        // ラベルです。String型の配列に、適当に値を入れておきます。
    	List<String> label = new ArrayList<String>();
    	List<String> point = new ArrayList<String>();
    	List<String> label1 = new ArrayList<String>();
    	List<String> point1 = new ArrayList<String>();
		//結果返却用の変数
    	List<Map<String, Object>> StockList = new ArrayList<>();

		//取得したデータを結果返却用のListへ格納していく
		for(Map<String,Object> map:getList) {
			//Productインスタンスの生成
			StockPrice stock = new StockPrice();
			//Productインスタンスに取得したデータをセットする
			stock.setData((String)map.get("Daily"));
			stock.setEnd_price((String)map.get("end_price"));


			//結果返却用のListに追加
			label.add(stock.getData());
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

        return "chart";
    }
    @GetMapping("/CD_chart")
    public String CD_Chart(@RequestParam String id,Model model) {


    	List<Map<String, Object>> getList = companyStockService.selectStock(id);
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



		return "Company/companyChart";

    }

    @PostMapping("/CM_chart")
    // ビュー側にグラフで使う値を渡すためにModelを引数にとっておきます。
    public String GetCM_chart(Model model,@RequestParam("Month") String Month,@RequestParam("id")String id) {
    	List<Map<String, Object>> getList = companyStockService.selectStockM(id,Month);

        // グラフの横軸と縦軸の値を、それぞれString、int型の配列に格納しておきます。

        // 横軸
        // ラベルです。String型の配列に、適当に値を入れておきます。
    	List<String> label = new ArrayList<String>();
    	List<String> point = new ArrayList<String>();
		//結果返却用の変数
    	List<Map<String, Object>> StockList = new ArrayList<>();

		//取得したデータを結果返却用のListへ格納していく
		for(Map<String,Object> map:getList) {
			//Productインスタンスの生成
			StockPrice stock = new StockPrice();
			//Productインスタンスに取得したデータをセットする
			stock.setData((String)map.get("Daily"));
			stock.setEnd_price((String)map.get("end_price"));


			//結果返却用のListに追加
			label.add(stock.getData());
			point.add(stock.getEnd_price());
		}
		System.out.println(label.size());
		System.out.println(point.size());

        // 縦軸
        // 具体的な値です。int型で、この値も適当です。

        // Modelに格納します。ビュー側でグラフ用の配列を受け取れるようにしておきます。
        model.addAttribute("label",label);
        model.addAttribute("point",point);

        return "Company/companyChart";
    }
    @GetMapping("/CY_chart")
    // ビュー側にグラフで使う値を渡すためにModelを引数にとっておきます。
    public String GetCY_chart(@RequestParam("id")String id,Model model) {
    	List<Map<String, Object>> getList = companyStockService.selectAllY(id);

        // グラフの横軸と縦軸の値を、それぞれString、int型の配列に格納しておきます。

        // 横軸
        // ラベルです。String型の配列に、適当に値を入れておきます。
    	List<String> label = new ArrayList<String>();
    	List<String> point = new ArrayList<String>();
		//結果返却用の変数
    	List<Map<String, Object>> StockList = new ArrayList<>();

		//取得したデータを結果返却用のListへ格納していく
		for(Map<String,Object> map:getList) {
			//Productインスタンスの生成
			StockPrice stock = new StockPrice();
			//Productインスタンスに取得したデータをセットする
			stock.setData((String)map.get("Daily"));
			stock.setEnd_price((String)map.get("end_price"));


			//結果返却用のListに追加
			label.add(stock.getData());
			point.add(stock.getEnd_price());
		}

        // 縦軸
        // 具体的な値です。int型で、この値も適当です。

        // Modelに格納します。ビュー側でグラフ用の配列を受け取れるようにしておきます。
        model.addAttribute("label",label);
        model.addAttribute("point",point);

        return "Company/companyChart";
    }

}