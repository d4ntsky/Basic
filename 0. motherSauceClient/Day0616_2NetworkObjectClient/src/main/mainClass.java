package main;

import java.io.IOException;

import java.net.Socket;
import thread.ReadThread;
import view.ClientFrame;

public class mainClass {
	public static void main(String[] args) {
		Socket socket=null;
		ClientFrame cf;
		
		try{
			socket=new Socket("127.0.0.1",9000);
			System.out.println("연결성공!");
			
			cf = new ClientFrame(socket);
			
			new ReadThread(socket, cf).start();
			
		}catch(IOException ie){
			System.out.println(ie.getMessage());
		}
	}
}









