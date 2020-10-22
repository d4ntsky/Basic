package music;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MusicManager {

	public static void getMelonData() {
		
		Document doc;
		
		try {
			doc = Jsoup.connect("https://www.melon.com/chart/index.htm").get();
	
			Elements titles = doc.select("div.wrap_song_info span a");
		
			for(int i = 0; i < 10; i++) {
				Element eTitle = titles.get(i);
				String title = eTitle.text();
				System.out.println(title);
			}
			
			Elements likes = doc.select("div.wrap span.cnt");
			
			for(int i = 0; i < 10; i++) {
				Element eLike = likes.get(i);
				String like = eLike.text();
				System.out.println(like);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
