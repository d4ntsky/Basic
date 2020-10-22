package thread;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import dto.NetworkSerialize;
import view.ClientFrame;
import view.IdClass;
import view.SingletonClass;

public // 키보드로 전송문자열 입력받아 서버로 전송하는 스레드
class WriteThread{
	
	Socket socket;
	ClientFrame cf;
	String str;
	String id;	
		
	public WriteThread(ClientFrame cf) {
		this.cf  = cf;
		this.socket= cf.socket;		
	}
	
	public void sendMsg() {
		//키보드로부터 읽어오기 위한 스트림객체 생성		
		ObjectOutputStream oos;
				
		try{
			//서버로 문자열 전송하기 위한 스트림객체 생성
			oos = new ObjectOutputStream(socket.getOutputStream());		
			
			SingletonClass sc = SingletonClass.getInstance();
									
			NetworkSerialize ns1 = sc.ns;					
			
			ns1.setName(IdClass.getId());
			if(cf.isFirst==true){					
				oos.writeObject(ns1);				
				oos.flush();				
			}else{								
				oos.writeObject(ns1);				
				oos.flush();
			}			
		
		}catch(IOException ie){
			System.out.println(ie.getMessage());
		}
	}	
	public void getId(){		
		id = IdClass.getId(); 
	}
}
