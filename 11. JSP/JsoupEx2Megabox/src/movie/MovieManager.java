package movie;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MovieManager {

	public static void getMegaboxData() {
		
		Document doc;
		
		try {
			doc = Jsoup.connect("https://www.megabox.co.kr/movie").get();
			
			Elements titles = doc.select("div.tit-area p.tit");
			
			for(int i = 0; i < 1; i++) {
				Element eTitle = titles.get(i);
				String title = eTitle.text();
				System.out.println(title);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
