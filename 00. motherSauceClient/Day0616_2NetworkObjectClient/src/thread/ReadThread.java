package thread;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import dto.NetworkSerialize;
import view.ClientFrame;
import view.SingletonClass;

public //서버가 보내온 문자열을 전송받는 스레드
class ReadThread extends Thread{
	
	Socket socket;
	ClientFrame cf;
	
	
	public ReadThread(Socket socket, ClientFrame cf) {
		this.cf = cf;
		this.socket=socket;
	}
	
	public void run() {	
		NetworkSerialize ns = null;
		try{
			//서버로부터 전송된 문자열 읽어오기 위한 스트림객체 생성			
			while(true){
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				//소켓으로부터 문자열 읽어옴
				try{
					ns = (NetworkSerialize)ois.readObject();
					
					SingletonClass sc = SingletonClass.getInstance();
					sc.ns = ns;
					
					cf.txtA.append("---------" + ns.toString()+"\n");
					
				}catch(ClassNotFoundException e){}
	
				if(ns==null){
					System.out.println("접속이 끊겼음");
					break;
				}				
			}
		}catch (UnknownHostException e) 
		{
		}catch(IOException ie){
			System.out.println(ie.getMessage());
		}
	}
}