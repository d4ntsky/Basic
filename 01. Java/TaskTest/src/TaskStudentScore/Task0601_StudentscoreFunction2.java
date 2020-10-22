package TaskStudentScore;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Task0601_StudentscoreFunction2 {

	public static void main(String[] args) {
		/*
			학생 성적 관리
			String student[][];
			
			메뉴----
			1. 학생 정보 추가 		insert		(예: 홍길동, 나이, 영어, 수학)
			2. 학생 정보 삭제 		delete
			3. 학생 정보 검색 		search
			4. 학생 정보 수정 		update
			5. 모든 학생 정보 출력 	print
		
			6. 과목의 총점			1. 영어
			7. 과목의 평균			
		
			8. 성적 순으로 정렬 출력
		*/
		
		Scanner sc = new Scanner(System.in);
		
		//(3)data load
		String student[][] = dataLoad();
		
		//(1)String student[][] = new String[20][4];
		
		
		//계속 등록하고 적어두기 힘드니까 임시데이터를 만들어둔다.
		/*(2)테스트용 
		{
				{"ㄷㄷㄷ","23","89","78"},
				{"ㄴㄴㄴ","24","87","88"},
				{"ㄱㄱㄱ","22","88","77"}
		};
		*/
		
		int choice;
		/*
		for (int i = 0; i < student.length; i++) {
			for (int j = 0; j < student[i].length; j++) {
				student[i][j] = ""; //초기화 // 나중에 필요없음1
			}
		}
		*/
		while(true) {
			System.out.println("======메뉴======");
			System.out.println("1. 학생 정보 추가");
			System.out.println("2. 학생 정보 삭제");	//이름으로 검색해서 삭제
			System.out.println("3. 학생 정보 검색");	//이름으로 검색
			System.out.println("4. 학생 정보 수정");	//을 찾고 수정
			System.out.println("5. 모든 학생 정보 출력");	//
			System.out.println("6. 과목의 총점");
			System.out.println("7. 과목의 평균");
			System.out.println("8. 성적의 정렬");
			System.out.println("9. 데이터 저장");		//저장은 있어야되고 불러오기는 자동이여야함
			
			
		System.out.println("메뉴 번호를 입력해 주십시오.");
		System.out.print(">>> ");
		choice = sc.nextInt();
		
		switch(choice) {
			case 1:		//학생 추가
				insert(student);
				break;
			case 2:		//학생 삭제
				delete(student);
				break;
			case 3:		//학생 검색	//유틸리티 함수
				search(student);
				break;
			case 4:		//학생 수정
				update(student);
				break;
			case 5:		//모든 학생 정보 출력
				allPrint(student);
				break;
			case 6:		//과목의 총점	
				chapSum(student);
				break;
			case 7:		//과목의 평균	//관건
				chapAvg(student);
				break;
			case 8:		//성적순으로 정렬(원본 데이터는 건들면 안된다.	
				sorting(student);
				break;
			case 9:		//데이터의 저장
				dataSave(student);
				break;	
			}
		}
	}
	//데이터 - 추가insert 삭제delete 검색search 수정update (기본) cf)확인  
	//삭제와 수정은 검색을 내포하고 있다. //oracle에서는 search 검색이 중요/복잡
	//create
//1.추가---------------------------------------------------------------------------------
	static void insert(String student[][]) {
		Scanner sc = new Scanner(System.in);
			
		int findIndex = -1;//-1인 이유 0으로 해두면 제로번지? 
		for (int i = 0; i < student.length; i++) {
			if(student[i][0].equals("")) { //0 1 2 데이터가 있으면
				findIndex = i;
				break;
			}
		}
		System.out.println("findIndex: " + findIndex); //확인작업
		//지금있는거에 마지막데이터를 불러와야함
		//if(student[i][0].contentEquals(""))
		
		System.out.print("이름: ");
		String name = sc.next();
		
		System.out.print("나이: ");
		String age = sc.next();
		
		System.out.print("영어: ");
		String eng = sc.next();
		
		System.out.print("수학: ");
		String math = sc.next();
		
		student[findIndex][0] = name;
		student[findIndex][1] = age;
		student[findIndex][2] = eng;
		student[findIndex][3] = math;
		
		System.out.println("입력완료: " + student[findIndex][0]);
	}
//2.삭제---------------------------------------------------------------------------------
	static void delete(String student[][]) {
		Scanner sc = new Scanner(System.in);

		System.out.print("검색할 학생의 이름 = ");
		String name = sc.next();
		
		int findIndex = getSearchIndex(student, name);
		
		if(findIndex != -1) {
			student[findIndex][0] = "";
			student[findIndex][1] = "";
			student[findIndex][2] = "";
			student[findIndex][3] = "";
			System.out.println("데이터를 삭제하였습니다");
		}else {
			System.out.println("데이터를 찾을 수 없습니다");
		}
	}
//3.검색---------------------------------------------------------------------------------
	static void search(String student[][]) {
		Scanner sc = new Scanner(System.in);

		System.out.print("검색할 학생의 이름 = ");
		String name = sc.next();
		
		/*
		//데이터의 로드
		int findIndex = -1;//cf)못찾았을때 0부터 나오기 때문에..
		for (int i = 0; i < student.length; i++) {
			String n = student[i][0];
			if(n.equals(name)) {
				findIndex = i;
				//동명이인이 있다면 여기다 출력
				break;
			}
		}
		*/
		int findIndex = getSearchIndex(student, name);
		
		if(findIndex != -1) {	 //찾았다
			System.out.println("데이터를 찾았습니다");
			System.out.println("이름: " + student[findIndex][0]);
			System.out.println("나이: " + student[findIndex][1]);
			System.out.println("영어: " + student[findIndex][2]);
			System.out.println("수학: " + student[findIndex][3]);
		}else {					 //못찾았다.
			System.out.println("데이터를 찾을 수 없습니다");
		}
	
	
	}
//4.수정---------------------------------------------------------------------------------
	static void update(String student[][]) {
		Scanner sc = new Scanner(System.in);

		System.out.print("수정할 학생의 이름 = ");
		String name = sc.next();
		
		int findIndex = getSearchIndex(student, name);
		
		if(findIndex != -1) { //점수수정
			System.out.println("수정 데이터를 입력해 주십시오");
			System.out.print("영어: ");
			String eng = sc.next();
			
			System.out.print("수학: ");
			String math = sc.next();
			student[findIndex][2] = eng;
			student[findIndex][3] = math;
			System.out.println("데이터가 수정되었습니다.");
		}else {
			System.out.println("데이터를 찾을 수 없습니다");
		}
	}
//5.출력---------------------------------------------------------------------------------
	static void allPrint(String student[][]) {//점수하나 안뜸
		for (int i = 0; i < student.length; i++) {
			if(student[i][0] == null || student[i][0].equals("") == false) {
				System.out.println(student[i][0]+ " "+student[i][1]+ " "+student[i][2]+ " "+student[i][3]+ " "  );
			}
		}
	}
////6.총점---------------------------------------------------------------------------------
	static void chapSum(String student[][]) {
		Scanner sc = new Scanner(System.in);
		//학생 수
		int count = 0;
		for (int i = 0; i < student.length; i++) {
			if(!student[i][0].equals("")){ //== student[i][0]).equals("") == flase
				count++;
			}
		}
		System.out.println("학생 수: " + count + "명");
		
		//입력받기
		int arrSum[] = new int[count];
		
		//영어, 수학 선택
		System.out.println("합계를 구할 과목, 영어(1), 수학(2) = ");
		int num = sc.nextInt();
		int sum = 0;
		for (int i = 0; i < student.length; i++) { //영어 student[][2] //수학 student[][3]
			if(!student[i][0].equals("")){
				sum = sum + Integer.parseInt(student[i][num + 1]);	//유저가 1,2 입력
			}
		}
		
		if(num == 1)		System.out.print("영어의 합계는");
		else				System.out.print("수학의 합계는");
		System.out.println(sum + "점입니다");
	}
//7.평균---------------------------------------------------------------------------------
	static void chapAvg(String student[][]) {	//합계구하는 코드까지 같고 영어수학 선택도 같음
		Scanner sc = new Scanner(System.in);
		
		int count = 0;
		for (int i = 0; i < student.length; i++) {
			if(!student[i][0].equals("")){ //== student[i][0]).equals("") == flase
				count++;
			}
		}
		System.out.println("학생 수: " + count + "명");
		
		//입력받기
		int arrSum[] = new int[count];
		
		//영어, 수학 선택
		System.out.println("평균을 구할 과목, 영어(1), 수학(2) = ");
		int num = sc.nextInt();
		int sum = 0;
		for (int i = 0; i < student.length; i++) { //영어 student[][2] //수학 student[][3]
			if(!student[i][0].equals("")){
				sum = sum + Integer.parseInt(student[i][num + 1]);	//유저가 1,2 입력
			}
		}
		
		double avg = (double)sum / arrSum.length;
		
		if(num == 1)		System.out.print("영어의 평균은");
		else				System.out.print("수학의 평균은");
		System.out.println(avg + "점입니다");
	}
//8.정렬---------------------------------------------------------------------------------
	static void sorting(String student[][]) {
		String sortDatas[][] = new String[student.length][student[0].length];
		//원본데이터 헤치지 않으려고
		System.out.println(student[0].length);
				
		for (int i = 0; i < student.length; i++) {
			for (int j = 0; j < student[0].length; j++) {
				sortDatas[i][j] = student[i][j];
			}
		}
	
	
	//student[][2];
		String temp[] = null;
		for (int i = 0; i < sortDatas.length - 1; i++) {
			for (int j = i+ 1; j < sortDatas.length; j++) {
				if(!sortDatas[i][2].equals("")&& !sortDatas[j][2].equals("")) {
				int num1 = Integer.parseInt(sortDatas[i][2]);
				int num2 = Integer.parseInt(sortDatas[j][2]);
				if(num1 > num2) {
					temp = sortDatas[i];
					sortDatas[i] = sortDatas[j];
					sortDatas[j] = temp;
				}
			}
		}
	}
		for (int i = 0; i < sortDatas.length; i++) {
			if(!sortDatas[i][0].equals("")) {
			System.out.println(sortDatas[i][0] + " " + sortDatas[i][1] + " " + sortDatas[i][2] + " " + sortDatas[i][3]);
			}
		}
	}
////9.저장---------------------------------------------------------------------------------
	static void dataSave(String student[][]) {
		/*
		이름
		나이
		영어
		수학 ... 보다는
		이름-나이-영어-수학 
		이름-나이-영어-수학 
		이름-나이-영어-수학  ... 이런식
		*/
		//학생수
		
		int count = 0;
		for (int i = 0; i < student.length; i++) {
			if(!student[i][0].equals("")){ //== student[i][0]).equals("") == false
				count++;
			}
		}
		
		String saveData[] = new String[count];
		//데이터 집어넣기 - 토큰 통해
		for (int i = 0; i < saveData.length; i++) {
			saveData[i] = student[i][0] + "-" 
						 	+ student[i][1] + "-" 
						 	+ student[i][2] + "-" 
						 	+ student[i][3];
		}
		
		for (int i = 0; i < saveData.length; i++) {
			System.out.println(saveData[i]);//확인
		}

		File file = new File("d:\\tmp\\student.txt");
		
		try {
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			for (int i = 0; i < saveData.length; i++) {
				pw.println(saveData[i]);
			}
			pw.close();
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
////10.불러오기---------------------------------------------------------------------------------
	static String[][] dataLoad() {
		//배열을 사용해서 코드가 길어짐
		String str[] = null;
		//1. 파일 읽기
		File file = new File("d:\\tmp\\student.txt");
		try {
			FileReader fr = new FileReader(file);
			
		//2.데이터 갯수 파악
			int count = 0;
			String s;
			BufferedReader br = new BufferedReader(fr);
			while( (s = br.readLine()) != null ) {
				count++;
			}
			br.close();		
			
		//3.할당
		str = new String[count];
		
		//4.데이터를 저장
		int i = 0;
		fr = new FileReader(file);
		br = new BufferedReader(fr);
			while((s = br.readLine()) != null) {
				str[i] = s;
				i++;
			}
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
//		for (int i = 0; i < str.length; i++) {
//			System.out.println(str[i]);
//		}
	
		//5.student[][] return
		//student[][] < str[]
		
		String student[][] = new String[20][4];
		//초기화
		for (int i = 0; i < student.length; i++) {
			for (int j = 0; j < student[i].length; j++) {
				student[i][j] = "";
			}
		}
		
		for (int i = 0; i < str.length; i++) {
			//데이터 자르기
			String s = str[i]; //s는 이름-나이-영어-수학
			String split[] = s.split("-");
			
			student[i][0] = split[0];
			student[i][1] =	split[1];
			student[i][2] =	split[2];
			student[i][3] =	split[3];
		}
		
		return student;
	}
	
	
	
	
	
	
	
////서치용----------------------------------------------------------------------------
	
	static int getSearchIndex(String student[][], String name) {

		int findIndex = -1;
		for (int i = 0; i < student.length; i++) {
			String n = student[i][0];
			if(n.equals(name)) {
				findIndex = i;
				break;
			}
		}
		return findIndex;
	}
	
}
////---------------------------------------------------------------------------------

//절차지향은 여기까지...