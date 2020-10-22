package dao;

import java.util.List;

import dto.Batter;
import dto.Human;
import dto.Pitcher;
import file.FileClass;

public class BaseballDao {

	private static BaseballDao dao = null;
	public List<Human> list;
	int memberNumber; 
	
	FileClass fc = new FileClass(); 
	
	private BaseballDao() {		
		// file로부터 data 읽어 들이기
		list = fc.fileLoad();
				
		// list에서 제일 마지막 선수의 number 취득
		memberNumber = list.get(list.size() - 1).getNumber();
		
		if(memberNumber >= 2000) {
			memberNumber = memberNumber - 1000;			
		}
		memberNumber = memberNumber + 1;
	}
	
	public static BaseballDao getInstance() {
		if(dao == null) {
			dao = new BaseballDao();
		}
		return dao;
	}
	
	public boolean insert(Human h) {
		
		if(h instanceof Pitcher) {
			h.setNumber(memberNumber);
		}else if(h instanceof Batter){
			h.setNumber(memberNumber + 1000);
		}
		
		boolean b = list.add(h);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
		memberNumber++;
		
		return b;
	}
	
	public Human delete(String name) {
		
		return null;
	}
	
	public Human select(String name) {
		
		return null;
	}
	
	public boolean update(String name) {
		
		return true;
	}
	
	public List<Human> allprint() {
		return this.list;
	}
	
	public void dataSave() {
		fc.fileSave(list);		
	}
	
	
} 