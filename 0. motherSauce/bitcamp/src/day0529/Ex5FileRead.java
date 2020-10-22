package day0529;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex5FileRead {

	public static void main(String[] args) throws Exception {
		//file read (시작전 tmp폴더 안에 text.txt 만들고 내용 적음
						//		\\은 /한번 으로 적어도됨
		File file = new File("d:\\tmp\\text.txt");
		
//		try {
			FileReader fr = new FileReader(file);
			
	//마지막에 친거		
//			String str = "";
//			//한문자씩 읽어 들인다
//			int c = fr.read();
//			while(c != -1) {  //= -1 == 파일의 끝
//					System.out.println((char)c);
//					str = str + (char)c;
//				c= fr.read();
//			}
//			
//			System.out.println(str);
//			
			
			
			
			//문장으로 읽어 들인다	buffer == 저장공간
			BufferedReader br = new BufferedReader(fr);
//		String str2 = br.readLine();
			String str2;
			
			while((str2 = br.readLine()) != null) {//데이터가 있을때까지
				System.out.println(str2);
//				str2 = br.readLine();
			}
			
			br.close();
			
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
		
		
	}

}	
		
		
		
		
		
//----------------------------Exception은 모든 예외를 내포하고 있다.
//이렇게 해두면 한번에 받음
//		try {
//			FileReader fr = new FileReader(file);
//			int c = fr.read();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} 
//----------------------------
//	public static void main throws Exception (String[] args) {
//		File file = new File("d:\\tmp\\text.txt");
//		FileReader fr = new FileReader(file);
//
//			int c = fr.read();
//				
//	
//		
//----------------------------

