package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/*
			1. 접속해야 할 Server IP(주소)를 설정
			2. Socket을 생성
			3. 접속 --- connect
			
			4. packet을 전송
		*/
														// 127.0.0.1 <- 자기 자신을 접속	
		InetSocketAddress sockAddr = new InetSocketAddress("127.0.0.1", 9000);
		
		Socket socket = new Socket();
		
		try {
			socket.connect(sockAddr, 10000);
			
			InetAddress inerAddr;	// 접속 확인용
			if((inerAddr = socket.getInetAddress()) != null) {
				System.out.println("Server connect success! : " + inerAddr);
			}else {
				System.out.println("Server connect fail~");
			}
			
			while(true) {
			
				System.out.print("보낼문자열:");
				String packetStr = sc.next();
				
				// send (보내다)
				PrintWriter writer = new PrintWriter(socket.getOutputStream());
				writer.println(packetStr);
				writer.flush();
				
				// recv (받는다)
				BufferedReader reader 
					= new BufferedReader(new InputStreamReader(socket.getInputStream()));
				packetStr = reader.readLine();
			
				System.out.println("서버로부터 패킷:" + packetStr);
			}
			
		//	socket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}







