package day0608_1ArrayList;

import java.util.ArrayList;

public class mainClass {

	public static void main(String[] args) {
	/*
		cf) List - 유동적인 배열
	Array - int, char, String, Object
	리스트가 나온 이유
	낭비되는 공간이나 모자르는 공간이 생긴다.
	새로운 값이 들어오면 빠르게 정리되면서 들어갈 수 있게 해준다.
	address는 4byte 32bit로 잡힌다.
	array는 대인용 동적으로 잡아서 정적으로 사용한다. 
	*/
		
	/*	
	  	Collection	: 수집
	  	
			List		: 목록
					데이터의 관릴 유동적으로 할 수 있는 배열.
				1) ArrayList(==Vector)
					배열처럼 사용할 수 있는 목룍
					선형 구조 o-o-o-o-o
					검색 속도가 빠르다
					index number로 관리된다.	0 ~ n-1
				2) LinkedList
					빈번하게 추가/삭제가 되는 경우에 적합한 구조
					검색 속도보다 추가/삭제에 빠르다
					cf) game 쪽에서 많이 사용하는 편 - ex) 총알
				//둘의 큰 차이는 별로 없다.
		
			Map
				1) HashMap (필수)
					key, value로 관리된다.
					key로 접근한다. dictionary
						키값이 apple value가 사과 
						"apple" : "사과"
					key는 하나만 존재한다. key값의 중복은 허용하지 않는다.
					Tree구조
					
				2) TreeMap (선택)
					Sorting이 추가되어있다.
				//둘의 큰 차이는 별로 없다
	*/
		
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		//== Integer arrInt[]; 
		
//------------------------------------------------------------------------------------
	// 추가
		//1)wrapper class에 넣는법
		arrList.add(111);
		
		//2)orginal - 생성해서 집어넣어주는
		Integer in = new Integer(222);
		arrList.add(in);
		//3)
		arrList.add(new Integer(333));		//뒤에다 추가한 것.
		
		
		// array는 length로 접근/list는 size로
		int len = arrList.size();
		System.out.println("len: " + len);
			
		//데이터를 산출 get
		Integer getVal = arrList.get(0);
		System.out.println("getVal: " + getVal);
		
	
		//list 산출 - 1.for문
		for (int i = 0; i < arrList.size(); i++) {
			Integer n = arrList.get(i);
			System.out.println(i + " : " + n);
		}
		//list 산출 - 2.for each문
		for(Integer inte : arrList) {
			System.out.println(inte);
		}
		//원하는 위치에 추가
		Integer inum = new Integer(200); 
		arrList.add(1, inum); 			//앞은 저장할 위치, 뒤는 요소. 밀어서 추가할 수 있다.
		for (int i = 0; i < arrList.size(); i++) {
			Integer n = arrList.get(i);
			System.out.println(i + " : " + n);
		}								//우리가 사용하는 index number 안에서 추가해야함
		
//------------------------------------------------------------------------------------		
	// 삭제
		//배열에서는 Array obj[0].name = ""; 이름을 바꿔줘야 했음. 그리고 땡겨와야했음.
		arrList.remove(2); //없애고 싶은 index number
		for (int i = 0; i < arrList.size(); i++) {
			Integer n = arrList.get(i);
			System.out.println(i + " : " + n);
		}
		
//------------------------------------------------------------------------------------		
	// 검색
		//1)
		arrList.indexOf(new Integer(333));	//original
		int index = arrList.indexOf(333);
		System.out.println("index : " + index); //indexOf 번지수
		System.out.println(arrList.get(index)); //get     값
		//2)
		index = -1;
		for (int i = 0; i < arrList.size(); i++) {
			Integer var = arrList.get(i);
			if(var == 200) {
				index = i;
				break;
			}
		}
		System.out.println("index : " + index); 
		System.out.println(arrList.get(index));
		
//------------------------------------------------------------------------------------	
	// 수정
		Integer updateData = new Integer(555);//수정할 데이터
		arrList.set(2, updateData);
		for (int i = 0; i < arrList.size(); i++) {
			Integer n = arrList.get(i);
			System.out.println(i + " : " + n);
		}
//------------------------------------------------------------------------------------
		
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("AB");
		
		String str = new String("CD");
		list.add(str);
		
		list.add(new String("EF"));
		for (int i = 0; i < list.size(); i++) {
			String n = list.get(i);
			System.out.println(i + " : " + n);
		}			
		
		
		list.remove(0);
		for (int i = 0; i < list.size(); i++) {
			String n = list.get(i);
			System.out.println(i + " : " + n);
		}		
		
		
		String ud = new String("cd");
		list.set(0, ud);
		for (int i = 0; i < list.size(); i++) {
			String n = list.get(i);
			System.out.println(i + " : " + n);
		}
		
		
		list.indexOf(new String ("EF"));
		int ind = list.indexOf("EF");
		System.out.println("ind : " + ind); 
		System.out.println(list.get(ind)); 

//------------------------------------------------------------------------------------
		
		ArrayList<MemberDto> memList = new ArrayList<>();
		
		//추가
		MemberDto dto = new MemberDto(101, "홍길동");
		memList.add(dto);
		
		memList.add(new MemberDto(102, "일지매"));
		
		//원하는 위치에 추가
		memList.add(1, new MemberDto(111,"성춘향"));
		
			//출력
		for (int i = 0; i < memList.size(); i++) {
//			MemberDto mem = memList.get(i);
//			System.out.println(i + " : " + mem.toString());
			
			System.out.println(memList.get(i).toString());
		}
		
//		for (MemberDto mem : memList) {			//번지는 볼 수 없지만, 값만 볼때. 
//			System.out.println(mem.toString());
//		}
		
		//삭제
//		memList.remove(2);
//		for (MemberDto mem : memList) {			
//		System.out.println(mem.toString());
//		}
		
		//검색
			//이름으로 검색(동명이인은 안됨)
		String findName = "성춘향";
		int findIndex = -1;        //-초기값
		for (int i = 0; i < memList.size(); i++) {
			MemberDto mem = memList.get(i); 		//항상 꺼내주기
			//if(member[i] != null) array에서만 있는부분 
			if(findName.equals(mem.getName())) {
				findIndex = i;//동명이인은 여기서 개수 추가
				break;
			}
		}
		System.out.println("데이터를 찾았습니다 >>>");
		System.out.println(memList.get(findIndex).toString());
		System.out.println("-------------------------------------");
		
		
		//------------------------------------------------------------------------------------
			//다수의 데이터를 검색하는 경우
		memList.add(new MemberDto(103, "성춘향"));
		for (MemberDto mem : memList) {			
			System.out.println(mem.toString());
		}
		
		ArrayList<MemberDto> findList = new ArrayList<MemberDto>(); //리스트 한개 더 생성
		findName = "성춘향"; //위쪽꺼
		for (int i = 0; i < memList.size(); i++) {
			MemberDto mem = memList.get(i);
			if(findName.equals(mem.getName())){
				findList.add(mem);									//새 리스트에 성춘향 데이터 추가
			}
		}
		System.out.println("-------------------------------------");
		for (int i = 0; i < findList.size(); i++) {
			MemberDto mem = findList.get(i);
			System.out.println(mem.toString());
		}
		System.out.println("-------------------------------------");
		
		//수정
		MemberDto updateMem = new MemberDto(104, "향단이");
		memList.set(3, updateMem);
		
		for (MemberDto mem : memList) {
			System.out.println(mem.toString());
		}

		//cf) 업데이트와 삭제,,,,
		
	}
}
