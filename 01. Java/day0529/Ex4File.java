package day0529;

import java.io.File;
import java.io.IOException;

public class Ex4File {

	public static void main(String[] args) {
		/*
			Code -> logic (구현)
					기능적: file, database
					
			저장매체 : 파일, DB
					 이름		나이		 주소
					홍길동	 24		서울시	-> write, read 
			목적 : 데이터의 저장, 불러오기
			
			파일명
			*.txt	모든 파일의 원조격
			.jpg/ .dll/ .lib/ .jar/ .png/
			
			.dll(Dynamic Link Library) 	- 동적 
			.lib(Library)				- 정적(static)
		*/
			
			//파일 목록
		/*
		File fdir = new File("c:\\"); //instance만 생성
		
		String filelist[] = fdir.list();//c문자의 파일을 문자로 받는것
			for (int i = 0; i < filelist.length; i++) {
				System.out.println(filelist[i]);//c드라이브 파일목록
			}*/
		
		// 파일, 폴더, 그 외의 것
		File fdir = new File("c:\\"); 
		File filelist[] = fdir.listFiles();
		for (int i = 0; i < filelist.length; i++) {
			
			if(filelist[i].isFile()) {
				System.out.println("[파일]" + filelist[i].getName());
			}
			else if(filelist[i].isDirectory()) {
				System.out.println("[폴더]" + filelist[i].getName());
			}
			else {
				System.out.println("[?]" + filelist[i].getName());
			}
		}		//목적을 예를 들자면 동일한 파일명이 있는지 없는지
		
		
		// 파일 생성 //폴더 tmp는 만든 상태
		String fileStr = "d:\\tmp\\newfile.txt";
		File newfile = new File(fileStr);
		//파일 만들기
		try {
		if(newfile.createNewFile()) {
			System.out.println("파일 생성 성공!");
		}else {
			System.out.println("파일 생성 실패!");
		}				//같은 파일명이 있을땐 실패로
		}catch (IOException e) {
			e.printStackTrace();
		}

		// 파일의 존재 여부
		if(newfile.exists()) {
			System.out.println("파일이 존재합니다");
		}else {
			System.out.println("파일이 존재하지 않습니다");
		}
	
		// 파일 삭제
//		if(newfile.delete()){
//			System.out.println("파일을 삭제하였습니다");
//		}else {
//			System.out.println("파일을 삭제하지 못 하였습니다");
//		}
		
		// 읽기 가능?
		if(newfile.canRead()) {
			System.out.println("파일을 읽을 수 있습니다");
		}else {
			System.out.println("파일을 읽을 수 없습니다");
		}
		
		//읽기 전용
		newfile.setReadOnly(); //바꿔서 저장 불가
		
		// 쓰기 가능?
		if(newfile.canWrite()) {
			System.out.println("파일 쓰기가 가능합니다.");
		}else {
			System.out.println("파일 쓰기가 불가능합니다.");
		}
		
		//학생 점수 관련 클래스에서 데이터를 가져읽어와서 시험할 수 있게 
		//평소엔 계속 직접 적었다
	}

}
