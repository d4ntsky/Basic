package classData;

public class Java17File2 {
	public static void main(String[] args) {
	/*	텍스트 파일 읽기
	우선 기본이 되는 FileReader클래스를 사용해보면 우선 가져오려는 파일을 대상으로 File클래스의 객체를
	만든다. 그리고 그 객체를 인수로 FileReader클래스의 객체를 만든다.
	File file = new File(file_name);
	FileReadear filereader = new FileReader(file);
	이제 대상 파일에서 텍스트를 로드할 준비가 되었다. 작성한 FileReader클래스의 객체에 문자를 읽기메소드를
	실행한다.
	FileReader클래스의 객체를 만드는 경우에는 FileNotFoundException라는 예외가 발생할 가능성이
	있기때문에 예외처리를 해두지 않으면 안된다.
	try {
		File file = new File ("c:\\tmp\\test.txt");
		FileReader filereader = new FileReader(file);
	}
	catch (FileNotFoundException e) {
		System.out.println(e);\
	}
	*/	
		
	/*	텍스트보기
	다음 파일에서 문자를 읽어드린다. FileReader클래스를 사용하는 경우에 기본적으로 한 문자씩 읽어나간다.
	한꺼번에 읽는다고 할 수 없기 때문에 효율은 매우 나쁘다.
	read
	public int read () throws IOException
	단일의 문자를 읽어들인다.
		반환값:
	읽힌 문자. 스트링의 마지막에 이르렀을 경우는 -1
	IOException - 입출력 에러가 발생했을 경우
	read메소드로 파일에서 한 문자씩 읽어들인다. 읽어들인 값은 int형의 값으로 얻을 수 있고 이 정수는 문자
	코드를 나타내는 정수가 된다. 읽은 문자를 문자로 표시하려면 아래와 같이 합니다.
	try {
		File file = new File("c:\\tmp\\test.txt");
		FileReader filereader = new FileReader(file);
		int ch = filereader.read();
		System.out.println((char)ch);
	}
	catch(FileNotFoundException e) {
		System.out.println(e);
	}
	catch(IOException e) {
		System.out.println(e);
	}
	read로 가져온 정수값을 (char)ch로 문자로 변환한다.
		파일의 끝까지 읽어들인다.
	read 메소드를 사용하면, 우선 파일의 선두로부터 문자를 가져온다. 그리고 자동으로 로드 위치가 다음 문자로
	이동한다. 때문에 연속 read 메소드를 사용하면 파일의 시작부터 한 글자씩 읽어들인다. 그리고 파일의 마지막에
	달했을 때 "-1"값을 리턴한다. 따라서 파일의 선두에서 파일의 끝까지 문자를 가져오려면 read 메소드의 결과
	로서 -1이 반환될 때까지 반복적으로 read 메소드를 실행한다.
	try {
		File file = new File("c:\\tmp\\test.txt")
		FileReader filereader = new FileReader(file);
		int ch = filereader.read();
		while(ch != -1) {
			System.out.print((char)ch);
			ch = filereader.read();
		}
	}
	catch(FileNotFoundException e) {
		System.out.println(e);
	}
	catch(IOException e) {
		System.out.println(e);
	}
	파일로부터 문자를 읽고 그 값이 -1이 되야 화면에 표시하고 -1인 경우에는 종료한다. 또한 상기와 같은 것을 
	작성하는 경우, 정리하고 다음과 같이 작성할 수 있다.
	try {
		File file = new File("c:\\tmp\\test.txt")
		FileReader filereader = new FileReader(file);
		int ch;
		while ((ch = filereader.read()) != -1) {
			System.out.print((char)ch);
		}
	}
	catch(FileNotFoundException e) {
		System.out.println(e);
	}
	catch(IOException e) {
		System.out.println(e);
	}
	위의 while문에서 조건식 부분은 파일에서 한 문자씩 읽어들인 값을 변수 ch에 저장하고 저장한 값을 -1과 
	같은지를 비교하고 있다. 또한 문자 읽고 표시하는 것을 반복하므로 화면에 출력도
	System.out.println((char)ch)하면 한 글자씩 개행되어 표시되기 때문에
	System.out.print((char)ch)를 사용하고 있다.
	이렇게 하면 한글자씩 개행되지 않고, 파일에서 개형 문자를 읽어들인 경우에도 그 개행 문자도 읽어들이게
	되기때문에 결과적으로 파일에서 개행된 곳 화면에서도 개행되어 표시된다.
		파일 닫기
	파일의 모든 작업이 끝나면 파일을 닫는다. close메소드를 사용한다.
	close
	public void close() throws IOException 
	스트림을 닫는다.
		예외:
	IOException - 입출력 에러가 발생했을 경우
	파일에서 문자를 읽어들이는 경우의 일련의 흐름은 다음과 같다.
	try {
		File file = new File("c:\\tmp\\test.txt");
		FileReader filereader = new FileReader(file);
		int ch;
		while((ch = filereader.read()) != 1) {
			System.out.print((char)ch);
		}
		filereader.close();
	}
	catch(FileNotFoundException e) {
		System.out.println(e);
	}
	catch(IOException e) {
		System.out.println(e);
	}
	cf) FileWriter를 직접 사용하여 문자를 읽어들이는 경우, 1 문자 일고 처리를 하는 방법으로 
	효율적이지 않다. 실제로 다른 클래스와 함께 사용한다.
	*/
	
	/*	읽기 사전 확인
	텍스트 파일에서 내용을 읽는 방법을 살펴봤지만 실제로는 파일을 읽기 전 다양하게 확인해두는 것이 좋다.
	구체적으로는 열려고 하는 파일이
		1) 실제로 존재하는지
		2) 그 파일인지
		3) 읽기 가능한 것인지 			확인해야한다.
	예를 들어 다음과 같은 방법을 사용할 수 있어야 파일을 읽기전에 확인할 수 있다.
private boolean checkBeforReadfile(File file) {
	if(file.exists()){
		if(file.isFile() && file.canRead()) {
			return true;
		}
	}
		return false;
}
	위에서는 exists으로 파일이 있는지 확인하고 isFile메소드에서 대상 File클래스 개게가 파일인지
	여부를 확인 후, canRead 메소드로 읽을 수 있는지 여부를 판별한다. 예를 보면
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
class streamTest2 {
	public static void main (String[] args) {
		try{
			File file = new File ("c:\\tmp\\test.txt")
			if(checkBeforReadfile(file)) {
				FileReader filereader = new FileReader(file);
				int ch;
				while((ch = filereader.read()) != -1) {
					System.out.print((char)ch);
				}
				filereader.close();
			}
			else{
				System.out.println("파일이 없거나 열 수 없습니다.");
			}
		}
		catch(FileNotFoundException e) {
			System.out.println(e);
		}
		catch(IOException e) {
			System.out.println(e);
		}
	}
	private static boolean checkBeforeReadfile(File file) {
		if(file.exists()) {
			if(file.isFile() && file.canRead()){
				return true;
			}
		}
		return false;
	}
}
	결과는 같지만 컴파일하고 실제로 실행해보면 아래와 같이 된다.
	*/
		
	/*	한 문장으로 텍스트 읽기
	FileReader를 사용하여 파일에서 데이터를 읽어오는 경우엔 한 문자씩 처리하기 때문에 아주 비효율적이다.
	때문에 통합 처리를 위한 클래스가 준비돼있다. BufferedReader 클래스를 사용한다. 왜 처음부터 이
	클래스를 사용하지 않는 것인가 하면, 이 클래스는 FileReader 클래스를 확장하는 형태로 이용되기 때문이다.
	FileReader 클래스가 가진 기본 기능으로 파일에서 읽어오고, 그것에 BufferedReader 클래스를
	추가하고 정리함으로 로드 기능을 갖게된다. 사용법은 아래와 같다.
	File file = new File(file_name);
	FileReader filereader = new FileReader(file);
	BufferedReader br = new BufferedReader(filereader);
	FileReader 클래스의 객체를 생성할 때까지는 지금까지와 동일하지만 이 객체를 인수로 BufferedReader
	클래스의 객체를 만든다. 그리고 FileReader 클래스의 객체가 아니라 BufferedReader 클래스의 객체
	를 통해서 로드용의 메소드를 실행하여 텍스트 파일에서 텍스트를 읽는다. 아래와 같이 기술해도 된다.
	File file = new File(file_name);
	BufferedRead br = new BufferedReader(new FileReader(file));
		텍스트를 한 줄 단위로 읽기
	다음 파일로드 방법이다. FileReader 클래스와 같이 read도 있지만, 한 줄씩 보기 위한 readLine이 
	따로 준비되어있다.
	readLine
	public String readLine () throws IOException
	한 행의 텍스트를 읽어들인다. 한 줄은 끝은 개행 ("\n")또는 복귀("\r"), 또는 복수의 행으로 거기에
	계속되는 개행의 어떤 것인가로 인식된다.
		반환값:
	행의 내용을 포함한 캐릭터 라인, 다만 행의 끝 문자는 포함하지 않는다. 스트림의 마지막에 이르렀을 경우는
	null
	IOException - 입출력 에러가 발생했을 경우
	텍스트 파일에서 한 줄의 텍스트를 한꺼번에 읽어들인다. 주의할 점은 개행 문자는 읽은 문자에 포함되지 않는
	것이다. 따라서 한 줄마다 줄 바꿈을 포함하지 않는 텍스트를 읽어 String형의 값으로 리턴한다.
	이 메소드를 사용하면 우선 파일의 첫번째 행을 읽어들인다. 그리고 자동으로 로드위치가 다음행으로 이동한다.
	그러므로 반복 readLine메소드를 실행하여 파일의 처음부터 끝까지 순서대로 텍스트를 읽어들인다.
	try {
		File file = new File ("c:\\tmp\\test.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String str = br.readLine();
		while(str != null) {
			System.out.println(str);
			str = br.readLine();
		}
		br.close();
	}
	catch(FileNotFoundException e) {
		System.out.println(e);
	}
	catch(IOException e) {
		System.out.println(e);
	}
	정리해서 다음과 같이 기술이 가능하다.
	try {
		File file = new File ("c:\\tmp\\test.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String str
		while((str = br.readLine()) != null) {
			System.out.println(str);
		}
		br.close();
	}
	catch(FileNotFoundException e) {
		System.out.println(e);
	}
	catch(IOException e) {
		System.out.println(e);
	}
	이번에느 파일로부터 읽어들인 값은 개행 문자는 포함되어 있지않으므로 print가 아니라 println
	메소드를 사용한다.
		파일 닫기
	또한 BufferedReader 클래스를 사요아는 경우에도 사용이 끝나면 닫아야한다. BufferedReader
	클래스에서도 FileReader 클래스와 마찬가지로 close 메소드를 사용한다.
	close
	public void close () throws IOException
	스트림을 닫는다
		예외:
	IOException - 입출력 에러가 발생했을 경우 BufferedReader 클래스의 객체에 close하면
	FileReader 클래스 쪽은 close 하지 않아도 된다.
	샘플
	import java.io.File;
	import java.io.FileReader;
	import java.io.BufferedReader;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	class streamTest3 {
		public static void main(String[] args) {
			try {
				File file = new File("c:\\tmp\\test.txt");
				if(checkBeforeReadFile(file)) {
					BufferedReader br = new BufferedReader(new FileReader(file));
					String str;
					while((str = br.readLine()) != null) {
						System.out.println(str);
					}
					br.close();
				}
				else{
					System.out.print("파일이 없거나 열 수 없습니다.");
				}
			}
			catch(FileNotFoundException e) {
				System.out.println(e);
			}
			catch(IOException e) {
				System.out.println(e);
			}
		}
		private static boolean checkBeforeReadfile(File file) {
			if(file.exists()) {
				if(file.isFile() && file.canRead()){
					return true;
				}
			}
			return false;
		}
}
	여기에서 텍스트파일에 쓰기를 봅니다. 우선 기본이 되는 FileWriter클래스를 사용한다. 절차는 파일로부터
	읽어들일 때와 비슷하다. 텍스트를 기록할 파일을 대상으로 File 클래스의 객체를 만든다. 그리고 그 객체를
	인수로 FileWriter 클래스의 객체를 만든다.
	File file = new File(file_name);
	FileWriter filewriter = new FileWriter(file);
	이제 해당 파일에 대한 쓰기를 할 준비가 되었다.
	FileWriter클래스의 개체를 만드는 경우에 IOException라는 예외가 발생할 가능성이 있기 때문에 예외
	처리를 해놓는 게 좋다.
	try {
		File file = new File ("c:\\tmp\\test.txt");
		FileWriter filewrite = new FileWriter(file);
	}
	catch(IOException e) {
		System.out.println(e);
	}
		파일에 쓰기
	write를 사용한다. 여기에선 문자열을 쓰는 방법을 살펴보면
	write
	public void write(String str) throws IOException
	문자열을 기입한다.
		파라미터 : 
	str - 기입해지는 캐릭터 라인
		예외:
	IOException - 입출력 에러가 발생했을 경우 인수는 지정한 문자열로 쓴다. 
	예를 들어
	try {
		File file = new File ("c:\\tmp\\test.txt");
		FileWriter filewriter = new FileWriter(file);
		fileWriter.write("안녕하세요");
	}
	catch(IOException e){
		System.out.println(e);
	}
		샘플 프로그램
	쓰기를 수행하기 전에 파일이 존재하고 디렉토리가 아닌 것을 확인하고 쓰기 권한이 되어 있는지를 사전에
	확인하고 있다.
	import java.io.File;
	import java.io.FileWriter;
	import java.io.IOException;
	class streamTest4 {
		public static void main(String[] args) {
			try {
				File file = new File("c:\\tmp\\test.txt");
				if(checkBeforeWrtierfile(file)) {
					FileWriter filewriter = new FileWriter(file);
					filewriter.write("안녕하세요 \r\n");
					filewriter.write("안녕하십니까 \r\n");
					filewriter.close();
				}
				else {
					System.out.println("파일에 쓸 수 없습니다.");
				}
			}
			catch(IOException e) {
				System.out.println(e);
			}
		}
		private static boolean checkBeforeWritefile (File file) {
			if(file.exists()) {
				if(file.isFile() && file.canWrite()) {
					return true;
				}
			}
			return false;
	}
}
	화면에는 특히 아무것도 표시되지 않지만 파일을 열어보면 아래와 같이 텍스트가 기록될 것이다
	안녕하세요
	안녕하십니까
	*/
		
	/*	파일에 추가기입	
	지금까지 샘플은 파일에 덧쓰기로 텍스트를 기입했다. 즉, 쓰려고하는 파일에 뭔가 다른 것이 기입되어 있었다
	하더라도 모두 지우고 새로운 텍스트를 기입했다. 이번에는 이미 파일에 적혀있는 텍스트는 지우지않고 파일의
	끝에 추가 텍스트를 작성하는 방법을 살펴보겠다. 변경사항은 FileWriter 클래스의 객체를 생성할 때,
	두번째 인수로 "true"를 지정하면된다.
	File file = new File(file_name);
	FileWriter filewriter = new FileWrite(file,true);
	두번째 인수에 true를 지정하면 뭔가 쓰기를 실시했을 경우는 파일의 마지막에 기록된다. 때문에 이미 파일에
	들어있는 텍스트는 변경하지 않고 추가로 기입된다. 반대로 두번째 인수에 false를 지정하면, 파일의 시작
	부분에 기록된다. (덮어쓰기가 아니라 일단 모든 삭제 후에 쓰기가 이뤄진다.)
	import java.io.File;
	import java.io.FileWriter;
	import java.io.IOException;
	class streamTest5 {
		public static void main(String[] args) {
			try {
				File file = new File ("c:\\tmp\\test.txt");
				
				if(checkBeforeWritefile(file)) {
					FileWrite filewriter = new FileWriter(file, true);
					filewriter.write("네. 하이 \r\n");
					filewriter.write("그럼 또 \r\n");
					filewriter.close();
				}
				else{
					System.out.println("파일에 쓸 수 없습니다.");
				}
			}catch(IOException e) {
				System.out.println(e);
			}
		}
		private static boolean checkBeforWritefile (File file) {
			if(file.exists()) {
				if(file.isFile() && file.canWrite()) {
					return true;
				}
			}
			return false;
		}
	}
	프로그램을 실행하면 아래와 같이 파일의 마지막에 쓰기 작업을 수행하고 있습니다.
	안녕하세요
	안녕하십니까
	네. 하이
	그럼 또
	*/
		
	/*	편리한 write 클래스
	파일에 쓰기 위한 클래스로 좀 더 편리한 PrintWriter 클래스가 준비되어있다.
	PrintWriter 클래스는 기존 파일 출력을 위한 클래스가 더욱 확장됐다.
	BufferedWriter 클래스의 객체를 바탕으로 작성하는 경우가 많다.
	사용법은 아래와 같이 된다.
	File file = new File(file_name);
	FileWriter filewriter = new FileWriter(file);
	BufferedWriter bw = new BufferedWriter(filewriter);
	PrintWriter pw = new PrintWriter(bw);
	아래와 같이 기술해도 상관 없다.
	File file = new File(file_name);
	PrintWriter pw = new PrintWriter ( new BufferedWriter ( new FileWriter (file) ) );
	기반이 되는 파일 내보내기 위한 클래스를 바탕으로 확장한 편리한 형태이다. 이 클래스가 편리한
	점은 화면에 출력할 때처럼 print메소드 또는 println메소드가 준비되어있는 것이다.
	이 두 메소드는 인수로 다양한 데이터 형식의 값을 사용할 수 있도록 데이터 유형마다 메소드가 준비
	되어있다. 그러므로 write 메소드 때처럼 문자열뿐만 아니라 int형이나 boolean형의 값을 
	그대로 출력하도록 작성하는 것이 가능하다. 
	(수치나 다른 값도 그 값을 문자로서 파일에 기입한다)
	File file = new File (file_name);
	PrintWriter pw = new PrintWriter (new BufferedWriter (new FileWriter (file)));
	pw.println("문자열");
	pw.println(10);
	print메소드는 개행하지 않고 파일로 기입하며, println메소드의 경우는 마지막에 개행한다.
	println
	public void println(String x)
	String을 출력하고 행을 종료한다. 이 메소드는 print(String)을 호출하고 나서 println()을
	호출하는 것과 같은 동작을 한다.
		파라미터:
	x - 출력되는 String 값 줄바꿈은 BufferedWriter 클래스에 포함되어 있던 newLine처럼 환경에
	맞게 적절한 개행 문자를 자동으로 출력해준다.
	샘플
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.IOException;
class streamTest6 {
	public static void main (String[] args) {
		try {
			File file = new File("c"\\tmp\\test.txt");
			if(checkBeforeWritefile(file)) {
			PrinterWriter pw
				= new PrintWriter (new BufferedWriter (new FileWriter (file)));
			pw.println("오늘 최고 기온은");
			pw.println(10);
			pw.println("도 입니다");
			pw.close();
			}
			else{
				System.out.println("파일에 쓸 수 없습니다.");
			}
		}
		catch(IOException e) {
			System.out.println(e);
		}
	}
	private static boolean checkBeforeWritefile (File file) {
		if(file.exists ()) {
			if(file.isFile() && file.canWrite()) {
				return true;
			}
		}
		return false;
	}
}
	*/	
		
	
	}
}

