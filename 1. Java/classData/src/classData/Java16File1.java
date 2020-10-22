package classData;

public class Java16File1 {
	public static void main(String[] args) {
	/*	File 클래스
	Java에서 파일을 처리하려면 File클래스를 사용한다. 우선 File클래스를
	살펴보면 우선 취급하고 파일에 대해 하나의 File클래스의 객체를 대응시키고
	있다. 어떤 파일을 대상으로 하고 있는지 확인하려면 파일이 있는 디렉토리
	(위치)와 파일 이름이 필요하다. 우선 절대 파일 이름을 지정해보겠다.
	File 객체명  = new File(파일 이름);
	대상 파일 이름을 디렉토리 위치 + 파일이름의 형태로 지정한다. 예를 들면,
	File file = new File("c:\\tmp\\test.txt");
	Windows의 경우 C 드라이브에 있는 tmp라는 디렉토리 안에 있는 test.txt
	라는 파일에 대해 File의 객체인 file을 연결했다. 예를 들어 앞으로 이 
	파일의 내용을 읽고 쓸때, 방금 만든 File 클래스의 file객체를 사용하여
	수행할 수 있게 되었다. 즉, File클래스를 사용하면 로컬디스크에 있는 파일을
	Java에서 사용할 수 있게 해주는 것이다.
	참고로 파일이름을 지정할 때,
	c:\tmp\test.txt 대신 c:\\tmp\\test.txt와 같이 \를 두번 기입한다.
	이것은 문자열에서 \는 \\로 기입한다.
	*/
	/*	절대 지정 및 상대 지정	
	방금 파일위치를 드라이브의 위치에서 절대지정으로 작성했다. 파일의 지정은 절대
	지정뿐만 아니라 상대 위치에서 지정도 가능하다. 상대 위치의 경우, 이 프로그램을
	작성하는 Java 파일이 놓여있는 위치를 기준으로 한다. 예를 들어, 프로그램
	파일과 같은 디렉토리에 해당 파일이 있는 경우에는 아래와 같이 작성한다.
	File file = new File("test.txt");
	또한 프로그램 파일 디렉토리 안에 "txt"라는 디렉토리가 있고, 그 디렉토리에
	해당 파일이 있는 경우에는 아래와 같이 작성한다.
	File file = new File("\\txt\\test.txt");
	*/	
	/*	파일과 디렉토리
	Java에서 파일을 디렉토리도 동일하게 처리한다. 즉, 디렉토리도 하나의 File
	도 하나의 File 클래스의 객체로 취급할 수 있다. 예를 들어 C드라이브에 있는
	tmp라는 디렉토리를 Java에서 이용하기 위해서는
	File file = new File("c:\\tmp\\");   와 같이 작성한다.
	File 클래스에는 list라는 메소드를 사용하여 File 클래스의 객체에 포함된 
	파일 및 디렉토리 목록을 검색할 수 있다. File클래스의 객체를 파일로 지정한 
	경우엔 불가능하지만, 디렉토리에 할당하면 해당 디렉토리에 파일이나 서브
	디렉토리가 포함되어 있어서 그 목록을 검색할 수 있다.
	*/	
	/*	
	import java.io.File;
	class fileTest1{
		public static void main(String[] args) {
			File cdirectory = new File ("c:\\");
			
			String filelist[] = cdirectory.list();
			for(int i = 0; i < filelist.length; i++) {
				System.out.println(filelist[i]);
			}
		}
	}	
	*/
	/*	파일인지 디렉토리인지 판별
	이젠 샘플 디렉토리에 포함된 파일 및 디렉토리의 목록을 가져와 보았을 때, 취득한 
	목록에 포함된 항목이 파일인지 디렉토리인지 외형을 모를 것이다. 그래서 여기선
	디렉토리와 파일을 구분하는 방법을 살펴본다. 우선 이전의 예제에서 사용한 File
	클래스에서 제공되는 "list"방법에 대해 살펴보겠다.
	  list public String[] list()
	이 추상 경로명이 가리키는 디렉토리에 있는 파일 및 디렉토리를 나타내는 문자열의
	배열을 리턴한다. 이 추상 경로명의 디렉토리가 나타내지 않는 경우, 이 메소드는
	null을 리턴한다. 디렉토리를 나타내는 경우는 문자열의 배열이 반환된다.
	문자열은 디렉토리 내의 각 파일 또는 디렉토리마다 한 개이다. 그 디렉토리 자체
	및 그 부목의 디렉토리를 나타내는 이름은 결과에 포함되지 않습니다. 각 문자열은
	절대 경로가 아닌 파일 이름이다.
	결과의 배열의 이름 String은 특정의 순서로 되지않는다. 알파벳 순서가 되는것은
	아니다.
		반환값:
	이 추상 경로명이 가리키는 디렉토리에 있는 파일 및 디렉토리를 나타내는 캐릭터
	라인의 배열. 디렉토리가 비어있는 경우, 배열은 비어있게 된다. 이 추상 경로명
	이 디렉토리를 나타내지 않는 경우 또는 입출력 에러가 발생했을 경우는 null이
	리턴된다.
		예외:
	SecurityException - 보안매니저가 존재해 시큐리티의 매니저의
	SecuriyuManager.checkRead (java.lang.String) 메소드가 
	디렉토리를 읽어들였을 때 액세스를 허가하지않는 경우
	*/
		
	/*	
		작성한 File클래스의 객체에 대해서 이 list를 사용하면 File클래스 객체의
	바탕으로 되어있는 것이 디렉토리인 경우는 그 디렉토리에 포함된 파일 이름 목록을
	문자열 배열로 반환해준다. 이전 예제에서 C드라이브의 루트 디렉토리에서 File
	클래스의 객체를 작성했으므로 그 디렉토리에 포함된 파일 및 디렉토리 목록을 나타
	내는 문자열 배열을 검색할 수 있었다. 이번에는 파일과 디렉토리 목록을 디렉토리
	인지 파일인지를 판별한다. 이 판정하는 법도 File클래스에서 사용할 수 있는데,
	방금 전 list메소드에서는 파일 목록을 이름만 문자열로 취득하기 때문에 이 이름
	에서 하나하나 File클래스 객체를 생성하고 판정한다.
		그래서 이번에는 파일이나 디렉토리의 이름 목록을 검색하는 것이 아니라 디렉
	토리에 포함된 파일이나 디렉토리를  File클래스의 개체 목록으로 취득할 수 있는
	listFiles메소드를 사용한다. 이 방법도 File클래스에 준비되어있다.
	listFiles
	public File [] listFiles ()
	이 추상 패스명이 나타내는 디렉토리 내의 파일을 나타내는 추상 경로명의 배열을 
	리턴한다. 이 추상 경로명이 디렉토리를 나타내지 않는 경우, 이 메소드는 null
	을 리턴한다. 디렉토리를 나타내는 경우, File 오브젝트의 배열이 반환된다.
	File객체는 디렉토리 내의 각 파일 또는 디렉토리마다 한 개이다. 
	디렉토리 자체 및 그 부모의 디렉토리를 나타내는 경로명은 결과에 포함되지 않는다.
	결과의 각 추상 경로명은 File (File, String) 생성 자를 사용하여 이 
	추상 패스명으로부터 생성된다.
	*/
	/*
	따라서 이 경로명이 절대의 경우, 결과의 각 경로명은 절대이다. 이 패스명이 
	상대의 경우, 결과의 각 경로명은 같은 디렉토리에 상대적이다. 결과의 배열의
	이름 스트링은 특정의 순서로 되지 않는다. 알파벳 순서가 되는 것은 아니다.
		반환값:
	이 추상 패스 명이 나타내는 디렉토리 내의 파일 및 디렉토리를 나타내는 추상
	경로명의 배열. 배열은 디렉토리가 비어있을 경우는 배열은 비어 있게된다.
	이 추상 경로명이 디렉토리를 나타내지 않는 경우, 또는 입출력 에러가 발생했을
	경우는 null
		예외:
	SecurityException - 보안매니저가 존재해 시큐리티의 매니저의
	SecuriyuManager.checkRead (java.lang.String) 메소드가 
	디렉토리를 읽어들였을 때 액세스를 허가하지않는 경우
	*/
	/*
	이 메소드는 기본적으로 list방법과 동일합니다만 목록을 File클래스의 객체
	로서 리턴합니다. 사용법은 아래와 같다.
	File directory = new File("c:\\");
	File[] filelist = directory.listFiles();
	이것으로 디렉토리에 포함된 파일 및 디렉토리 목록을 File클래스의 객체 배열
	로서 취득할 수 있다.
	*/
	/*	파일 및 디렉토리 판별
	그런 하나 하나의 File클래스의 객체가 파일인지 디렉토리인지를 판별한다.
	File클래스에서 제공되는 isFile은 대상 File클래스의 객체가 파일인 경우,
	True를 반환하는 메소드이다. 마찬가지로 isDirectory는 대상 File
	클래스의 객체가 디렉토리인 경우, True를 반환하는 메소드이다.
	isFile
	public boolean isFile ()
	이 추상 경로명이 가리키는 파일이 보통 파일인지를 판정한다. 파일은 그것이
	디렉토리는 아니고, 시스템에 의존하는 것 외의 기준에 맞는 경우에 보통의 
	파일로 간주된다. Java 어플리케이션이 생성한 디렉토리 이외의 파일은 
	반드시 보통 파일입니다.
		반환값:
	이 추상 경로명이 가리키는 곳에 파일이 존재하며, 그것이 보통 파일인 경우는
	True, 그렇지 않은 경우는 false
		예외:
	SecurityException - 보안매니저가 존재해 시큐리티의 매니저의
	SecuriyuManager.checkRead (java.lang.String) 메소드가 
	디렉토리를 읽어들였을 때 액세스를 허가하지않는 경우		
	*/	
	/*	
	isDirectory 메소드 :
	isDirectroy public boolean isDirectory()의 추상 경로명이 
	가르키는 파일이 디렉토리인지 여부를 판정한다.
		반환값:
	이 추상 경로명이 가리키는 파일이 존재하고 그것이 디렉토리인 경우는 true,
	그렇지 않은 경우는 false
		예외:
	SecurityException - 보안매니저가 존재해 시큐리티의 매니저의
	SecuriyuManager.checkRead (java.lang.String) 메소드가 
	디렉토리를 읽어들였을 때 액세스를 허가하지않는 경우
	*/	
	/*
	이 방법을 사용하여 결정하고 있습니다. 구체적으로는 아래와 같이 된다.
	File directory = new File("c:\\")
	File[] filelist = directory.listFiles();
	for(int i = 0; i < filelist.length; i++) {
		if(filelist[i].isFile()) {
			//파일일 때의 처리
		}else if(filelist[i].isDirectory()) {
			//디렉토리일 때의 처리
		}
	}
	*/	
	/*
	또한 이전 예제와는 달리 파일 이름과 디렉토리 목록을 문자열로 File클래스의
	객체 배열로서 취득하고 있기때문에 파일이나 디렉토리 이름을 화면에 표실할 때는
	File클래스에서 제공되고있는 getName메소드를 사용하여 File클래스의 객체
	에서 파일이나 디렉토리 이름을 산출한다.
	getName
	public String getName()
	이 추상 경로명이 가리키는 파일 또는 디렉토리의 이름을 리턴한다. 이것은 패스
	명의 이름 순서의 마지막 이름입니다.
	패스명의 이름 순서가 비어있으면 빈 문자열이 반환된다.
		반환값:
	이 추상 경로명이 가리키는 파일 또는 디렉토리의 이름이다. 이 패스명의 이름순서가
	빈 경우 빈 문자열을 리턴한다.
	*/
	/*
import java.io.File; 
class fileTest2 { 
	public static void main (String args []) { 
		File cdirectory = new File ( "c:\\"); 
		File filelist [] = cdirectory.listFiles (); 
		for (int i = 0; i <filelist.length; i ++) { 
			if (filelist [i] .isFile ()) { 
				System.out.println ( "[F]"+ filelist [i] .getName ()); 
			} 
			else if (filelist [i] .isDirectory ()) { 
				System.out.println ( "[D]"+ filelist [i] .getName ()); 
			} 
			else { 
				System.out.println ( "[?]"+ filelist [i] .getName ()); 
			} 
		} 
	} 
}
	파일이라면 앞에 [F]를 디렉토리라면 앞에 [D]로 표시한다. 어느쪽도 해당되지 않으면 ?
	*/
	/*	
	이전에 사용한 getName은 파일의 이름만 취득할 수 있었다. 
	File클래스에서 제공되는 getAbsolutePath는 절대 경로로 파일의 위치와 이름을 얻을 수 있다.
	getAbosolutePath
	public String getAbsolutePath()
	이 추상 경로명의 절대 경로명 스트링을 리턴한다. 이 추상 경로명이 절대인 경우, 패스명 문자열은
	getPath() 메소드와 같이 리턴된다. 이 추상 패스명이 빈 추상 패시명의 경우, 현재의 유저 
	디렉토리(시스템 프로퍼티 user.dir로 나타난다)의 패스명 문자열이 반환된다. 그렇지 않은 경우,
	이 경로는 시스템에 의존하는 방법으로 해결된다. UNIX 시스템의 경우, 상대 경로명은 현재의 사용자
	디렉토리를 기준으로 된다. Microsoft Windows 시스템의 경우, 상대 경로명으로 나타난 드라이브의
	현재 디렉토리가 있으면 그것을 기준으로 된다. 없는 경우는 현재의 사용자의 디렉토리가 기준이 된다.
		반환값:
	이 추상 경로명과 같은 파일 또는 디렉토리를 나타내는 절대 패스 명 문자열
		예외:
	SecurityException - 필수의 시스템 프로퍼티의 값에 액세스할 수 없는 경우, 이 메소드가 
	실행되면 절대 경로로 파일의 정보를 얻을 수 있다.
	*/
		
	/*	샘플 프로그램
	현재 작업 디렉토리에 test.txt라는 파일을 준비합니다. 그리고 Java 샘플 프로그램도 같은 디렉토리에
	설치 상대 경로로 지정합니다. test.txt에서 File클래스의 객체를 생성하고 절대 경로의 위치와 이름을
	가져보자
	import java.io.File;
	class fileTest3 {
		public static void main(String[] args) {
			File file = new File("test.txt")
			String path = file.getAbsolutePath():
			System.out.println("File : " + path);
		}
	}
	*/
		
	/*	파일 만들기
	지금까지 있는 파일에 대한 작업이었지만,이번엔 새로운 파일을 만들려고 한다. File클래스에서 제공되는
	createNewFile메소드를 사용한다.
	createNewFile
	public bollean createNewFile() throws IOException
	이 추상 패스명이 가리키는 새로운 파일을 자동(atomic)에 생성한다. (그 파일이 아직 존재하지 않는 경우)
		반환값:
	지정된 파일이 존재하지 않고, 파일의 생성에 성공했을 경우는 true, 나타난 파일이 이미 존재하는 경우는
	false
		예외:
	IOException - 입출력 에러가 발생했을 경우
	SecurityException - 보안매니저가 존재해 시큐리티의 매니저의
	SecuriyuManager.checkWrite (java.lang.String) 메소드가 파일에 쓰기를 했을 경우,
	액세스를 허가하지않는 경우와 만들려고 하는 새로운 파일이 이미 존재하는 경우는 만들 수 없다. 
	생성 방법을 단계별로 살펴보면 우선 만들려고 하는 파일 이름에서 File클래스의 객체를 만든다.
	File newfile = new File("c:\\tmp\\newfile.txt");
	상기에서 만들 파일을 절대 경로로 지정하고 있지만, 상대 경로로 지정해도 된다.
	다음 작성한 File클래스의 객체에 대해 createNewFile메소드를 실행한다.
	File newfile = new File("c:\\tmp\\newfile.txt");
	newfile.createNewFile();
	createNewFile메소드를 사용하는 경우에는 IOException이라는 예외가 발생할 수 있다. 프로그램을
	실행하는 동안 발생할 수 있는 오류다. 문법적으로 잘못된 프로그램의 경우 컴파일 시 에러가 표시되지만,
	문법적으로 문제없는 프로그램 실행시 발생하는 오류를 예외라고 한다. 실행시 오류가 발생하면 프로그램이
	강제 종료되어 버린다. 갑자기 강제 종료하면 심각한 문제가 발생한 경우가 있으므로, 프로그램의 실행 중에
	에러가 발생했을 경우, 강제 종료하지않고 오류가 발생했을 때의 처리를 기술하는 것이 가능하다.
	런타임 오류는 이 메소드에 국한된 것이 아니다. 그렇지만 반드시 예외처리를 기술해야하는 메소드가 있다.
	방금 전의 createNewFile메소드의 설명 문장의 첫부분을 보면
	public boolean createNewFile() throws IOException
	위와 같이 throws IOExcetion을 가진 메소드는 IOException이라는 런타임 오류가 발생할 가능성이
	있으므로 반드시 예외 처리를 기술하라는 메소드다.
	예외 처리를 덧붙인 것의 형태를 고쳐는 것
	File newfile = new File("c:\\tmp\\newfile.txt");
	try {
		newfile.createNewFile();
	}
	catch(IOException e) {
		System.out.println(e);
	}
	예외가 발생될 수 있는 부분에 try {} 안에 기술한다. 이 try {} 안에 작성된 프로그램을 실행하는동안
	예외가 발생하면 프로그램을 강제 종료시키는 대신에 catch {} 안에 쓰여진 처리를 대신에 실행한다.
	try{
		//예외가 발생하는 프로그램
		//예외가 발생하는 프로그램
		//예외가 발생하는 프로그램
	}
	catch(예외가 발생했습니다 1변수) {
		//예외 1이 발생했을 때의 처리
	}
	catch(발생한 예외 2 변수) {
		//예외 2가 발생했을 때의 처리
	}
	*/
	/*	
import java.io.File;
import java.io.IOException;

class fileTest4 {
	public static void main(String[] args) {
		File newfile = new File ("c:\\tmp\\newfile.txt");
		try {
			if (newfile.createNewFile()) {
				System.out.println("파일을 만드는 데 성공했습니다.")
			}else {
				System.out.println("파일을 만드는 데 실패했습니다.")
			}
		}
		catch(IOException e) {
			System.out.println(e);
		}
	}
}
	파일이 작성되어 있는지 확인해본다. 또한 IOException을 사용하기 때문에 프로그램의 첫부분에서
	import java.io.IOException;이 필요하다. 또한 계속해서 같은 프로그램을 실행하면 지금
	만들려고 하는 새로운 파일이 첫번째 프로그램으로 작성되어 있기 때문에 두번째로 실행하면 파일의
	작성에 실패한다.
	*/
	/*	디렉토리 만들기	
	이번엔 디렉토리를 만들려고 한다. File클래스에서 제공되는 mkdir메소드를 사용한다
	mkdir public boolean mkdir()
	이 추상 경로명이 가리키는 디렉토리를 생성한다.
		반환값:
	디렉토리가 생성되었을 경우는 true, 그렇지 않은 경우는 false
		예외:
	SecurityException - 보안매니저가 존재해 시큐리티의 매니저의
	SecuriyuManager.checkWrite (java.lang.String) 메소드가 지정된 디렉토리의 생성을
	허가하지 않는 경우
	만드는 방법을 단계별로 살펴보면 우선 만들려고 하는 디렉토리 이름에서 File클래스의 객체를 만든다.
	File newdir = new File("c:\\tmp\\sub");
	다음 작성한 File클래스의 객체에 대해 "mkdir"메소드를 실행한다.
	File newdir = new File("c:\\tmp\\sub");
	newdir.mkdir();
	이제 디렉토리가 생성되었다.
import java.io.File;
class fileTest5 {
	public static void main(String[] args) {
		File newfile = new File("c:\\tmp\\sub");
		if(newfile.mkdir()) {
			System.out.println("디렉토리 생성에 성공했습니다.");
		}
		else {
			System.out.println("디렉토리 생성에 실패했습니다.");
		}
	}
}
	*/	
		
	/*	부모 디렉토리가 존재하지 않는 디렉토리 생성
	앞서 이미 있는 디렉토리에서 다른 디렉토리를 만들어봤다. 이번에는 부모 디렉토리도 함께 만들려고한다.
	부모 디렉토리도 같이 생성이란, 예를 들어 C드라이브에는 temp라는 디렉토리는 없으면, c:\temp\sub
	라는 부모 디렉토리도 존재하지 않는 sub이라는 디렉토리를 만들어 보겠다.
	temp란 부모 디렉토리가 없는 경우엔 "디렉토리 생성에 실패했습니다."가 뜬다. 이런 경우 부모디렉토리에서
	하나하나 만들어가는거나 File클래스에서 제공되는 mkdirs메소드를 사용한다.
import java.io.File;
	class fileTest7 {
		public static void main (String[] args) {
			File newfile = new File ("c:\\temp\\sub");
			if(newfile.mkdir()) {
			System.out.println("디렉토리 생성에 성공했습니다.");
		}
		else {
			System.out.println("디렉토리 생성에 실패했습니다.");
		}
	}
}
	위의 컴파일을 실행하면 디렉토리 생성에 성공한다. sub디렉토리와 존재하지 않았던 디렉토리의 temp도
	함께 작성된다.
	*/	
	
	/*	파일의 확인 및 삭제
	이번에는 파일을 삭제해보자. 그 전에 저장된 파일이 존재하는지 확인하는 방법을 살펴볼 것이다. File클래스
	에서 제공되는 "exists" 메소드를 사용한다.
	exists
	public boolean exists ()
	이 추상 경로명이 가리키는 파일 또느 디렉토리가 존재하는지 여부를 판정한다.
		반환값:
	이 추상경로명이 가르키는 파일 또는 디렉토리가 존재하는 경우는 true, 그렇지 않은 경우는 false
		예외:
	SecurityException - 보안매니저가 존재해 시큐리티의 매니저의
	SecuriyuManager.checkWrite (java.lang.String) 메소드가 파일 또는 디렉토리에 대한
	액세스를 허가하지 않는 경우
	확인하고 싶은 파일이나 디렉토리를 바탕으로 File클래스의 객체를 생성하고 exists메소드를 실행하면 
	존재하는지 여부를 판별할 수 있다.
	File file = new File("c:\\tmp\\newfile.txt");
	if(file.exists()){
		System.out.println("파일이 존재합니다");
	}
	else {
		System.out.println("파일이 존재하지 않습니다");
	}
	다음 삭제합니다. File클래스에서 제공되는 delete메소드를 사용합니다.
	delete
	public boolean delete()
	이 추상 경로명이 가리키는 파일 또는 디렉토리를 삭제한다. 이 경로명이 디렉토리를 나타내는 경우, 그
	디렉토리가 삭제되기 위하여는 파일이 없고 비어있어야 한다.
		반환값:
	파일 또는 디렉토리가 성공적으로 제거된 경우는 true, 그렇지 않은 경우는 false
		예외:
	SecurityException - 보안매니저가 존재해 시큐리티의 매니저의
	SecuriyuManager.checkWrite (java.lang.String) 
	메소드가 파일의 삭제,	액세스를 허가하지 않는 경우
	다음과 같이 사용한다.
	File newdir = new File("c:\\tmp\\sub");
	newdir.delete();
import java.io.File;
	class fileTest8 {
		public static void main (String[] args) {
			File file = new File ("c:\\temp\\newfile.txt");
			if(file.exists()) {
				if(file.delete()){
					System.out.println("파일을 삭제했습니다.");
				}
				else{
				System.out.println("파일 삭제를 실패했습니다.");
				}
			}else {
					System.out.println("파일을 찾을 수 없습니다.");
			}
	}
}
	실행해보면 파일을 삭제하고 같은 프로그램을 다시 실행할 시 이미 파일이 삭제돼 존재하지 않아 실패한다.
	*/
	
	/*	읽기 권한과 쓰기 권한
	여기선 파일의 현재 권한 (파일에 대한 읽기 권한과 쓰기 권한 등의 수)을 확인하거나 변경하는 방법을 본다.
	우선 확인하는 방법은 해당 파일을 읽을 수 있는지 확인하려면 File클래스의 canWrite메소드를 사용한다.
	canRead:
	canRead public boolean canRead()
	이 추상 경로명이 가리키는 파일을 어플리케이션을 읽어들일 수 있을지 어떨지를 판정한다.
		반환값:
	이 추상경로명이 가리키는 파일이 존재하고, 어플리케이션이 그것을 읽어들일 수 있는 경우 true, 그렇지
	않은 경우는 false
		예외:
	SecurityException - 보안매니저가 존재해 시큐리티의 매니저의
	SecuriyuManager.checkRead (java.lang.String) 메소드가 파일에 읽어들여 액세스를 
	허가하지않는 경우
	canWrite:
	canWrite public boolean canWrite()
	이 추상 경로명이 가리키는 파일을 어플리케이션을 적용할 수 있는지 여부를 판정한다.
		반환값:
	파일 시스템이 이 추상 경로명이 가리키는 파일이 실제로 있어 어플리케이션이 그 파일에 기입할 수 있는
	경우는 true, 그렇지 않은 경우는 false
		예외:
	SecurityException - 보안매니저가 존재해 시큐리티의 매니저의
	SecuriyuManager.checkWrite (java.lang.String) 메소드가 파일에 기입하고 액세스를 
	허가하지않는 경우	
	두 메소드 모두 확인하고싶은 대상의 원래 파일 이름에 File클래스의 객체를 만들고 그 객체에 대해 
	canRead메소드 또는 canWrite메소드를 실행한다. 예를 들면 다음과 같다.
	File file = new File ("c:\\tmp\\newfile.txt");
	if(file.canRead()){
		System.out.println("파일을 읽을 수 있습니다.");
	}
	if(file.canWrite()){
		System.out.println("파일 쓰기가 가능합니다.");
	}
	다음 권한을 변경하는 방법이다. 살펴보니 쓰기 금지하는 방법은 있었지만 읽을 수 없습니다는 방법이 없다.
	쓰기 금지 (읽기 전용) 하려면 File클래스에서 제공되는 setReadOnly 메소드를 사용한다.
	setReadOnly
	public boolean setReadOnly()
	이 추상 경로명이 가리키는 파일 또는 디렉토리에 마크를 설정해서 read 오퍼레이션만 허가되도록 한다.
	이 메소드를 호출하면 파일 또는 디렉토리는 그것이 삭제되는지 쓰기 액세스를 허용하도록 마크를 설정할 때
	까지 변경되지 않는다. 읽기 전용 파일 또는 디렉토리를 삭제할 수 있는 지 여부는 배후의 시스템에 의존한다.
		반환값:
	오퍼레이션 성공했을 경우는 true, 그렇지 않은 경우는 false
		예외:
	SecurityException - 보안매니저가 존재해 시큐리티의 매니저의
	SecuriyuManager.checkWrite (java.lang.String) 메소드가 지정된 파일에 대한 쓰기
	액세스를 허가하지 않는 경우
	사용법은 지금까지와 동일하다. 대상 파일 이름을 바탕으로 File클래스의 객체를 만들고 그 객체에 대해
	setReadOnly메소드를 실행한다.
	
	File file = new File("c:\\tmp\\newfile.txt");
	if(file.setReadOnly()){
		System.out.println("파일을 읽기 전용으로 설정했습니다");
	}
	else{
		System.out.println("읽기 전용으로 변경이 실패했습니다");
	}
	아래 예제는 읽기 가능, 쓰기 가능 파일의 권한을 검사하여 읽기 전용으로 변경한다. 다시 권한을 확인한다.
import java.io.File;
class fileTest9 {
	public static void main(String[] args) {
		File file = new File ("c:\\tmp\\test.txt");
		checkPermission(file);
		if(file.setReadOnly()) {
			System.out.println("파일을 읽기 전용으로 설정했습니다");
		}
		else {
			System.out.println("읽기 전용으로 변경 실패했습니다");
		}
		checkPermission(file);
	}
	private static void checkPermission(File file) {
		if(file.canRead()) {
			System.out.println("파일을 읽을 수 있습니다");
		}
		if(file.canWrite()) {
			System.out.println("파일은 쓰기 가능합니다");
		}
	}
} 위를 컴파일 실행해보면
읽을 수 있다 > 쓰기 가능하다 > 읽기 전용으로 설정 > 읽을 수 있다
	*/
	}
}

