package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

import thread.ReadThread;

public class mainClass {

	public static void main(String[] args) {
	/*
		1. 접속해야 할 Sever IP(조수)를 설정
		2. Socket을 생성
		3. 접속 --- connect
		
		4. packet을 전송
	*/	
		Scanner sc = new Scanner(System.in);
														//127.0.0.1 무조건 자기 자신을 접속
		InetSocketAddress sockAddr = new InetSocketAddress("192.168.7.44", 9000);
	
		Socket socket = new Socket();
		
		try {
			socket.connect(sockAddr, 10000);//1000이 1초 //10000이 10초
					//connect을 통해서 접속이 되는것.
			
			InetAddress inerAddr; //접속확인용
			if((inerAddr = socket.getInetAddress()) != null) {
				System.out.println("Server connect success! : " + inerAddr);
			}else {
				System.out.println("Server connect fail");
			}
			// 서버 쪽을 켜고 그 다음 이 쪽에서 확인.
			
			// UI/ 언제든지 Packet을 받을 준비를 해놓는 Thread
			new ReadThread(socket).start();	
			
while(true) {			//UI는 while문 필요X 
//------------------------------------------------------
			System.out.println("보낼 문자열 : ");
			String packetStr = sc.next();	//글을 적을 상태를 유지 (while) UI는 while문 필요X
			
			//send	 (보내다) 1
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			writer.println(packetStr);
			writer.flush();//어디까지 보내는지 설정
			
			/*
			//receive (받다) 4  -- 이부 분에서 thread
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			packetStr = reader.readLine();	//client 받는 쪽도 thread가 켜져 있어야함.
			
			System.out.println("서버로부터 패킷 : " + packetStr);
			*/
//------------------------------------------------------	
					
}
//			socket.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
