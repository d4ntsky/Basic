package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class mainClass {

	public static void main(String[] args) {
		/*
			Server : TCP, DB(oracle), Web(tomcat)
			
			TCP : Transmission Control Protocol
					전송                    제어            규약
			통신 : 송신, 수신
			
			종단 시스템 : host
					  네트워크상에서 더 연장되지 않는 기기
					  PC, Smart Phone, Scanner, Printer
					  
			Router : hardware
					 hsot간의 상호 데이터를 교환할 수 있도록 하는 장비 
			
			inter net : 포괄적인 통신
			
			www : World Wide Web
			URL : Uniform Resource Locator
			
			통신규약
			TCP : Transmission Control Protocol 	동기 통신
			UDP : User Datagram Protocol			비동기 통신
			
			TCP
			신사적인 Protocol.
			전화 -> 상대방 -> 연결 -> 통신
			동기화   send(보낸다) -> recv(받는다)	처리 순서가 일치해야 한다.
			데이터의 경계가 없다. Data 용량의 한계가 없다. 
			1 대 1 통신만 가능.
			채팅, String, Object
			
			UDP
			비 연결형 Protocol
			편지, 지상파 방송
			데이터의 경계가 있다.
			1 대 1 (unicast)
			1 대 다 (broadcast)
			다 대 다 (multicast)
			
			7 Layer
			1 계층 - Physical Layer	 물리 계층
			2 계층 - Data Link Layer	 주소(IP)를 헤더에 첨부
			3 계층 - Network Layer		 네트워크 IP -> address
			4 계층 - Transport Layer	 네트워크 Port 
			5 계층 - Session Layer 	 세션을 동기화
			6 계층 - Presentation Layer 보안, 압축, 확장
			7 계층 - Application Layer	 프로그램
			
			Packet(묶음)
			제어정보, 데이터들이 결합된 형태로 전송이 되는 실제의 데이터
			IP, Port, String, Dto(Object)
			
			IP : Internet Protocol	-> address  v4 v6
			
			IPv4 : 0 ~ 255	XXX.XXX.XXX.XXX	
			IPv6 : 0 ~ 		XXX.XXX.XXX.XXX.XXX.XXX
			
			Port Number
			IP 주소는 internet상에 존재하는 host(PC)를 식별할 수 있으나
			최종 주체인 Process(프로그램)를 식별하지 못하기 때문에
			프로세스를 구별하기 위해서 지정된 수치(0 ~ 1024:sys)외에 수치를 지정한다.
			
			Socket --> 유닉스(File)
			send recv	write, read
			통신의 주체. 통신을 하기위한 Object
			IP, Port, TCP/UDP
			
			
			통신 순서
			
				Server					Client
			1.  Socket 버전 확인			1.  Socket 버전 확인
			2.	Binding : IP, Port설정
			3.	Listen	
			4.  Accept	<-------------	2.  Connect		
			
			5.	recv(받는다), read <----	3.  send(보내다), write
			6.  send			 ---->	4.  recv
			
			DNS(Domain Name System) Server
			IP -> String
			xxx.xxx.xxx.xxx	-> www.naver.com			
		*/
		
		
		Socket clientsocket = null;
		
		try {
			// 문지기 소켓
			// 192.168.7.66			
			ServerSocket serSocket = new ServerSocket(9000);
			// IP, Port 설정 
			// binding(적용)
			// listen
			
			while(true) {
			
				// client를 기다림
				System.out.println("접속 대기중...");
				clientsocket = serSocket.accept();
				
				System.out.println("client IP:" + clientsocket.getInetAddress() 
									+ " Port:" + clientsocket.getPort());				
									
				
				// recv (받는다)
				BufferedReader reader 
					= new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));
				String packetStr = reader.readLine();	// 실제 수신	
				
				System.out.println("클라이언트로부터 패킷:" + packetStr);
				
				// send (보내다)	
				PrintWriter writer = new PrintWriter(clientsocket.getOutputStream());
				writer.println(packetStr);		// 실제 송신
				writer.flush();
					
			}
			
		//	clientsocket.close();
		//	serSocket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
