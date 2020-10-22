package DaoClass;

import java.util.Scanner;

import DaoInterface.DaoImpl;
import dto.Human;
import singleton.SingletonCls;

public class DeleteClass implements DaoImpl {
	Scanner scan = new Scanner(System.in);
	
	public DeleteClass() {
	}
	
	@Override
	public void process() {
		SingletonCls sc = SingletonCls.getInstance();

		System.out.print("삭제하고 싶은 선수명 입력 = ");
		String name = scan.next();
		
		if(name.equals("")) {
			System.out.println("이름을 정확히 입력해 주십시오.");
			return;		// continue
		}
		
		int findIndex = SelectClass.search(name);
		if(findIndex == -1) {
			System.out.println("선수 명단에 없습니다. 삭제할 수 없습니다");
			return;
		}
		
		Human h = sc.list.remove(findIndex);
		
		System.out.println(h.getName() + "의 데이터는 삭제되었습니다");
	}

}