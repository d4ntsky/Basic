package Task0529;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Scanner;
public class Task0530_FileFunction1 {

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
	*/
	wrt(arrArr[]);
	/*
		read	함수
			String strArr[]; 
			[0]<-	"Hi",
			[1]<-	"Hello",
			[2]<-	"안녕하세요"
			//return 데이터
	 */
	//red();
}
//---------------------------------------------------------------------------------
static void wrt() throws Exception {
	
	Scanner sc = new Scanner(System.in);
	
	System.out.println("몇 개의 인삿말을 넣겠냐?");
	int g = sc.nextInt();
	String arrArr1[] = new String[g];
	
	File file = new File("d:\\tmp\\greeting.txt");
	FileWriter fWriter = new FileWriter(file);
	BufferedWriter bw = new BufferedWriter(fWriter);
	PrintWriter pw = new PrintWriter(bw);
	
	pw.print(arrArr1);
		for (int i = 0; i < arrArr1.length; i++) {
			System.out.println("인사말을 입력 해주세요");
			String grt = sc.next();
		}
		sc.close();
		pw.close();
	
		
}

//---------------------------------------------------------------------------------
                                                                                         //---------------------------------------------------------------------------------	
//	static void red(String arrArr[]) {
//		
//	
//		File file = new File("d:\\tmp\\greeting.txt");
//		FileReader fr = new FileReader(file);
//		BufferedReader br = new BufferedReader(fr);
//
//			String str2;
//			
//			while((str2 = br.readLine()) != null) {//데이터가 있을때까지
//				System.out.println(str2);
//
//			
//			
//			}
//			br.close();
//	}
//	
//	
//
}
