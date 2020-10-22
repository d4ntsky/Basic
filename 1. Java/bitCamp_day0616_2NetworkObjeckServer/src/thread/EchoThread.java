package thread;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Vector;

import dto.NetworkSerialize;

//클라이언트로 부터 전송된 문자열을 받아서 다른 클라이언트에게 문자열을
//보내주는 스레드
public class EchoThread extends Thread{
	
	Socket socket;
	Vector<Socket> vec;
			
	public EchoThread(Socket socket, Vector<Socket> vec){
		this.socket = socket;
		this.vec = vec;			
	}
	
	public void run(){		
		NetworkSerialize ns = null;
		try{						
			while(true){
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());		
				try{					
					ns = (NetworkSerialize)ois.readObject();
					
					System.out.println("네트워크 전송된 객체는 " +ns.toString());										
				}catch(ClassNotFoundException e){}
				
				//상대가 접속을 끊으면 break;
				if(ns==null){
					//벡터에서 없애기
					vec.remove(socket);
					break;
				}
				
				//연결된 소켓들을 통해서 다른 클라이언트에게  보내주기					
				if(ns.getPlay() == 1) ns.setPlay(2);
				else		ns.setPlay(1);
												
				sendMsg(ns);					
			}
			
		} catch(IOException ie){
			System.out.println(ie.getMessage());
		}
	}
	
	//전송받은 문자열 다른 클라이언트들에게 보내주는 메서드
	public void sendMsg(NetworkSerialize ns){
		int num = 0;
				
		try{			
			for(Socket socket:vec){
				//for를 돌되 현재의 socket이 데이터를 보낸 클라이언트인 경우를 제외하고 
				//나머지 socket들에게만 데이터를 보낸다.
			//	if(socket != this.socket){				
					ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
					num++;
					ns.setNumber(num);								
					oos.writeObject(ns);
					oos.flush();				
					//단,여기서 얻어온 소켓들은 남의것들이기 때문에 여기서 닫으면 안된다.
			//	}
			}
		}catch(IOException ie){
			System.out.println(ie.getMessage());
		}		
	}
}