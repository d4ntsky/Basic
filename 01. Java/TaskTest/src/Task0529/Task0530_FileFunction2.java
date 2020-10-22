package Task0529;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Task0530_FileFunction2 {
	public static void main(String[] args) {
		/*	
			write	함수
				String arrArr[] = {
				//데이터 몇 개 넣을지 모른다는 가정
				"Hi",
				"Hello",
				"안녕하세요"
				};
				greeting.txt 저장되는 함수 만들기
				//매개 변수로 
				
			read	함수
				String strArr[]; 
				[0]<-	"Hi",
				[1]<-	"Hello",
				[2]<-	"안녕하세요"
				//return 데이터
		 */
		File file = new File("d:\\tmp\\text.txt");
		
		//문자열
		String arrStr[] = {
				"Hi",
				"Hello",
				"안녕하세요",
				"..."
		};
		//1boolean = dataSave(file,arrStr);
			//1if(b) {
						//성공적//
			//1}else {	//실패
			//1}
				//위에 파일 //위에 arrStr
		dataSave(file, arrStr);
		
		//-----------------------------------------------------------
		String arrayStr[] = dataLoad(file);
		for (int i = 0; i < arrayStr.length; i++) {
			System.out.println(arrayStr[i]);
		}
	}
	//-----------------------------------------------------------
	//File f의 저장 변수가 매우 중요
	static void dataSave(File f, String datas[]) {
		try {
			FileWriter fWriter = new FileWriter(f);//thrown으로 하면 위도 고쳐야됨
			BufferedWriter bw = new BufferedWriter(fWriter);
			PrintWriter pw = new PrintWriter(bw);
			
			for (int i = 0; i < datas.length; i++) {
				pw.println(datas[i]);
			}
			pw.close();
			
		} catch (IOException e) {
			System.out.println("파일에 데이터가 저장이 되지 않았습니다");
			//1return false;
		}
		System.out.println("성공적으로 파일에 데이터가 저장되었습니다");
		//1return true; //1위가 불리언
	}//텍스트 파일의 커서!!!!!!!
	
	
	//-------------------------------------------------------어렵...
	static String[] dataLoad(File f) {
		String str[] = null;
		try {
			FileReader fr = new FileReader(f);
			
			// 데이터를 카운터 (몇개?)
			int count = 0;
			String s;//while에 들어갈
			BufferedReader br = new BufferedReader(fr);
			while((s = br.readLine())  != null){
				count++;
			}
			br.close();//커서를 맨처음으로 되돌리는!!!!!!!!!!!!!!!!!!
			
			// 배열을 셋팅
			str = new String[count];
			
			// 읽고 데이터를 저장
			int i = 0;
			fr = new FileReader(f);
			br = new BufferedReader(fr);
			while((s = br.readLine()) != null){
				str[i] = s;
				i++;
			}
			br.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	
	}
	//-----------------------------------------------------------
	
}

