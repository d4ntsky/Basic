package fileLoad;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import dto.Batter;
import dto.Pitcher;
import singleton.SingletonCls;

public class FileLoadClass {

	File file = new File("d:\\tmp\\baseball.txt");
	
	public FileLoadClass() {
		createFile();
	}
	
	public void createFile() {
		try {
			if(file.createNewFile()) {
				System.out.println("파일 생성 성공!");
			}else {
				System.out.println("파일 생성 실패");
			}
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
	
	public void process() {
		SingletonCls sc = SingletonCls.getInstance();
		
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
					sc.list.add(p);
				}
				else {
					Batter b = new Batter(		Integer.parseInt(data[0]), 
												data[1], 
												Integer.parseInt(data[2]), 
												Double.parseDouble(data[3]), 
												Integer.parseInt(data[4]), 
												Integer.parseInt(data[5]), 
												Double.parseDouble(data[6]) );
					sc.list.add(b);
				}				
			}
			br.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
