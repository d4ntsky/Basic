package main;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import dto.MemberDto;

public class mainClass {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		ServerSocket serSocket = new ServerSocket(9000);
		
		System.out.println("대기중...");
		
		Socket socket = serSocket.accept();
		
		System.out.println("client IP : " + serSocket.getInetAddress()
		+  "  Port : " + socket.getPort());
		
		//receive
			//input
		ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
		//MemberDto dto = (MemberDto)ois.readObject();
		Object obj = ois.readObject();
		
		//System.out.println("client로부터 DTO: " + dto.toString());
		
		//send
			//output
		ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
		//oos.writeObject(dto);
		oos.writeObject(obj);
		oos.flush();
		
		
	}
}