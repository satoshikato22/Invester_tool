import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class test2 {
	public static void main(String[] args) {
		List<String> list1 = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();
        List<String> list3 = new ArrayList<String>();
        List<String> modorichi = new ArrayList<String>();

	    //try-catch文が必要
	    try {
	        //Document A = Jsoup.connect("url").get(); urlにスクレイピング対象
	        //Document doc = Jsoup.connect("http://archaeology.jp/learning/university/2018kougiichiran/#").get();
	    	String url = "https://minkabu.jp/stock/9749";
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
	    for(String a : modorichi) {
	    	System.out.println(a);
	    }


	}
}
