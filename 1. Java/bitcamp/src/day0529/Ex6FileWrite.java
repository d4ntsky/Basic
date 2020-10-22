package day0529;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Ex6FileWrite {

	public static void main (String[] args) throws Exception {
		// file write
		File file = new File("d:\\tmp\\text.txt");
		
		// 한문자
//		FileWriter fw = new FileWriter(file);
//		fw.write("안녕하세요" + "\n");
//		fw.close();
		
		// 추가 쓰기 append					true란 매개변수
//		FileWriter fw = new FileWriter(file, true);
//		fw.write("건강하세요" + "\n");
//		fw.close();

		FileWriter fWriter = new FileWriter(file);			// 파일 포인터 설정
		BufferedWriter bw = new BufferedWriter(fWriter); 	// 문장으로
		PrintWriter pw = new PrintWriter(bw);				
		
		pw.print("안녕" + "\n");
		pw.println("하이하이");
		pw.println("건강하세요");
		
		//주의 read close는 잊어도됨
		pw.close();
		//write일 때는 close 꼭 하기
	}

}