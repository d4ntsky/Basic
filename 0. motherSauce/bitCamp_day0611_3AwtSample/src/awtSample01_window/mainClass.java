package awtSample01_window;

public class mainClass {

	public static void main(String[] args) {
		/*
			Application -> App

			자동화 기능 	-> Application(C#)	게임만
			Web		-> editor			돈하고 관련
			
			Java
			AWT, swing	-> User Interface(연결)
			
			Abstract Window Toolkit == Android
			button, label, textField,,
			
			Application <--> Database
					JDBC
		*/
		
	//	new WindowTest();	//instance 필요없음
	//	new WindowTest1();
		//window 상속받는게 편함
		
		//cf)awt를 경량화하면서 간단하게 swing
		new WindowTestJ();	//swing 쓴 것
		
	}

}