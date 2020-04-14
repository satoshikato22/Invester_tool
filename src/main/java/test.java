import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class test{
	public static void main(String[] args) {


	    //try-catch文が必要
	    try {

	        //Document A = Jsoup.connect("url").get(); urlにスクレイピング対象
	        //Document doc = Jsoup.connect("http://archaeology.jp/learning/university/2018kougiichiran/#").get();

	    	for(int i = 1949;i <= 2020;i++) {
	    		String url = "https://kabuoji3.com/stock/9749/"+i+"/";


	    	Document doc = Jsoup.connect(url).get();

	        //Elements B = A.select("タグ"); この形でソースに含まれるタグで指定された範囲を書き出す。
	        Elements elm = doc.select("tbody tr");

	        //拡張for文
	        int num = 1;
	        for(Element elms : elm) {
	            String title = elms.text();
	            	System.out.println(title);
	        }
	    	}
	        //例外処理
	    }catch(IOException e) {
	        e.printStackTrace();
	    }



	}
}
