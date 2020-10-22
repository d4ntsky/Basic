package Task0528;
//과제6 함수후
public class Task0528_SecurityFunctionalize {

/* 과제6
	다음은 알파벳과 숫자를 아래에 주어진 암호표로 암호화하는 프로그램이다. (1)에 알맞은 코드를 넣어서 완성하시오. 
		a b c d e f g h i j k l m n o p q r s t u v w x y z 
		` ~ ! @ # $ % ^ & * ( ) - _ + = | [ ] { } ; : , . / 
		0 1 2 3 4 5 6 7 8 9 
		q w e r t y u i o p 
	char[] abcCode =   
		{  
		'`','~','!','@','#','$','%','^','&','*',    
		'(',')','-','_','+','=','|','[',']','{',    
		'}',';',':',',','.','/'}; 

	0 1 2 3 4 5 6 7 8 9  
	char[] numCode = {'q','w','e','r','t','y','u','i','o','p'}; 
		암호화/복호화
*/	
	public static void main(String[] args) {
	

// 		
//		char[] abcCode =								//a~z
//		{  '`','~','!','@','#','$','%','^','&','*',    
//			'(',')','-','_','+','=','|','[',']','{',    
//				'}',';',':',',','.','/' }; 
//		
//    	char[] numCode =								//0~9
//    	{'q','w','e','r','t','y','u','i','o','p'}; 
//    	
//    	//암호화
//    	String src = "abc0123"; //바꿀려는 데이터
//    	
//    	String resultCode = "";
//    	
//    	for (int i = 0; i < src.length(); i++) {
//			
//    		char ch = src.charAt(i);
//    		int n = (int)ch;
//    		
//    		// 알파벳의 경우
//    		if(n >= 97 && n <= 122) {
//    			n = n - 97;			//n이 a ascii코드가 97이면 -97을 하면 0이 된다
//    			resultCode = resultCode + abcCode[n];
//    		}
//    		// 숫자의 경우
//    		if(n >= 48 && n <= 57) {
//    			n = n - 48;			//알파벳의 경우와 비교해서 보면 48 == 0
//        		resultCode = resultCode + numCode[n];
//    		}
//		}
//    	System.out.println("원본 코드 	 : " + src);
//    	System.out.println("암호화된 코드 : " + resultCode);
//    	
//    	
//    	//복호화 //암호화보다 복호화가 힘들다...
//    	String baseCode = "";
//    	
//    	for (int i = 0; i < resultCode.length(); i++) {
//			
//    		char ch = resultCode.charAt(i);
//    		int n = (int)ch;//abc0123에서 a의 코드가 "`"기 떄문에 어디위치해있는지
//    		
//    		int index = 0;
//    		if(n >= 97 && n <=122) {		//암호화된 숫자
//    			for (int j = 0; j < numCode.length; j++) {
//					//같은글자가 무엇인지
//    				if(ch == numCode[j]) {
//    					index = j;	//0~9 index number
//    					break;
//    				}
//				}
//    			index = index + 48;	//숫자가 암호화 된거니까
//    			baseCode = baseCode + (char)index;
//    		}
//    		else {							//암호화된 알파벳
//    			for (int j = 0; j < abcCode.length; j++) {
//					if(ch == abcCode[j]) {
//						index = j;
//						break;
//					}
//				}
//    			index = index + 97;	 //알파벳이 암호화 된거니까
//    			baseCode = baseCode + (char)index;
//    		}
//		}
//    	System.out.println("복호화된 코드 : " + baseCode);
//	
//	
		String str = "abcd012";
		
		String scode = security(str);
		System.out.println("암호화된 코드 : " + scode);
		String dcode = deciphering(scode);
		System.out.println("복호화된 코드 : " + dcode);
		
	}
	
	static String security(String src) {
		char[] abcCode =								//a~z
		{  '`','~','!','@','#','$','%','^','&','*',    
			'(',')','-','_','+','=','|','[',']','{',    
				'}',';',':',',','.','/' }; 
		
    	char[] numCode =								//0~9
    	{'q','w','e','r','t','y','u','i','o','p'}; 
		

	String resultCode = "";
	
	for (int i = 0; i < src.length(); i++) {
		
		char ch = src.charAt(i);
		int n = (int)ch;
		
		// 알파벳의 경우
		if(n >= 97 && n <= 122) {
			n = n - 97;			//n이 a ascii코드가 97이면 -97을 하면 0이 된다
			resultCode = resultCode + abcCode[n];
		}
		// 숫자의 경우
		if(n >= 48 && n <= 57) {
			n = n - 48;			//알파벳의 경우와 비교해서 보면 48 == 0
    		resultCode = resultCode + numCode[n];
		}
		
	}
	return resultCode;
}
	static String deciphering(String src) {
		char[] abcCode =								//a~z
		{  '`','~','!','@','#','$','%','^','&','*',    
			'(',')','-','_','+','=','|','[',']','{',    
				'}',';',':',',','.','/' }; 
		
    	char[] numCode =								//0~9
    	{'q','w','e','r','t','y','u','i','o','p'}; 
    	String baseCode = "";
    	
    	for (int i = 0; i < src.length(); i++) {
			
    		char ch = src.charAt(i);
    		int n = (int)ch;//abc0123에서 a의 코드가 "`"기 떄문에 어디위치해있는지
    		
    		int index = 0;
    		if(n >= 97 && n <=122) {		//암호화된 숫자
    			for (int j = 0; j < numCode.length; j++) {
					//같은글자가 무엇인지
    				if(ch == numCode[j]) {
    					index = j;	//0~9 index number
    					break;
    				}
				}
    			index = index + 48;	//숫자가 암호화 된거니까
    			baseCode = baseCode + (char)index;
    		}
    		else {							//암호화된 알파벳
    			for (int j = 0; j < abcCode.length; j++) {
					if(ch == abcCode[j]) {
						index = j;
						break;
					}
				}
    			index = index + 97;	 //알파벳이 암호화 된거니까
    			baseCode = baseCode + (char)index;
    		}
		}
    	return baseCode;
	}
}