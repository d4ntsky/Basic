package file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import dao.BaseballDao;
import dto.Batter;
import dto.Human;
import dto.Pitcher;

public class FileClass {

	File file = new File("d:\\tmp\\baseball.txt");
	
	public FileClass() {
		createFile();
	}
	
	public void createFile() {
		try {
			if(file.createNewFile()) {
				System.out.println("파일 생성 성공!");
			}else {
				System.out.println("동일한 이름의 파일이 존재합니다");
			}
		} catch (IOException e) {}
	}
	
	public List<Human> fileLoad() {
		List<Human> list = new ArrayList<Human>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
					
			// 배열 저장
			String str;		
			while( (str = br.readLine()) != null ) {
				// str -> 번호-이름-나이-신장-				
				// 문자열을 자른다
				String data[] = str.split("-");				
				int number = Integer.parseInt(data[0]);
				if(number < 2000) {
					// 투수				
					Pitcher p = new Pitcher(	Integer.parseInt(data[0]), 
												data[1], 
												Integer.parseInt(data[2]), 
												Double.parseDouble(data[3]), 
												Integer.parseInt(data[4]), 
												Integer.parseInt(data[5]), 
												Double.parseDouble(data[6]) );
					list.add(p);
				}
				else {
					Batter b = new Batter(		Integer.parseInt(data[0]), 
												data[1], 
												Integer.parseInt(data[2]), 
												Double.parseDouble(data[3]), 
												Integer.parseInt(data[4]), 
												Integer.parseInt(data[5]), 
												Double.parseDouble(data[6]) );
					list.add(b);
				}				
			}
			br.close();
			
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}		
		
		return list;
	}
	
	public void fileSave(List<Human> list) {				
		
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
			
			for (int i = 0; i < list.size(); i++) {
				Human h = list.get(i);
				pw.println(h.toString());
			}			
			pw.close();
			
		} catch (IOException e) {			
			e.printStackTrace();
		}			
	}
	
}
