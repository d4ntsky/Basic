package singleton;

import java.util.ArrayList;
import java.util.List;

import dto.Human;

public class SingletonCls {

	private static SingletonCls sc = null;
	
	public List<Human> list = null;
	
	private SingletonCls() {
		list = new ArrayList<Human>();
	}
	
	public static SingletonCls getInstance() {
		if(sc == null) {
			sc = new SingletonCls();
		}
		return sc;
	}
}