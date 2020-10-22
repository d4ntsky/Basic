package main;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import thread.ServerThread;


public class mainClass {
	//TCPServerThread와 같음	//서버는 완성형에 가까운편
	public static void main(String[] args) {
/*
	cf) 서버는 UI로 만들지 않는다. 너무 커지기 때문이다.
		web socket 구조도 같음. 
	
	서버에 소켓이 있고 그 것은 문지기 소켓(IP Port)
	클라이언트 소켓은 하나만 있고 다른게 있을수도 있다. 
	소켓끼리 연결되는데
	client의 connect을 하여 server는 accept하여 create socket(담당자 소켓)을 만든다
	client 수의 비례해서 담당자 소켓은 비례하게 늘어난다.
	모든 클라이언트는 문지기 소켓을 지나친다.
	서버는 항상 accept상태를 유지해야한다. 언제 client가 접속할지 모르기 때문이다.
	client는 pecket의 send 혹은 recv 
	하나의 클라이언트 담당자가 recv 혹은 send
	readline함수를 통해 계속 체크해야하기 때문에 Thread를 해준다.
	서버는 클라이언트의 접속을 기다리고 있는 것고 클라이언트 쪽에서 
	클라이언트는 recv만 thread를 돌린다. 채팅이기 때문에
	
	되어있는 코드 올려주시는...
	
*/			
		
		Socket clientsocket = null;
		List<Socket> list = new ArrayList<Socket>();
	
		try {
			// 서버소켓(문지기 소켓) 생성				- 접속을 하기 위한 소켓
			// 192.168.7.44	- 자동적으로 들어감	
			ServerSocket serSocket = new ServerSocket(9000);
														//Port Num
			// IP, Port 설정 
			// binding (적용)
			// listen도 severSocket이 자동적으로 들어감
			
while(true) {	//accept도 유지 하면서 receive쪽도 계속 확인해야함
				//서버에 클라이언트가 많아지면 소켓도 많아진다. accept상태도 유지해야함
				//TCP는 한 번 연결되면 계속 연결되어있다
				//DB는 한 번 연결되서 쿼리에 맞춰 주고 닫는다
			
			// client를 기다림
			System.out.println("접속 대기중...");										//서버는 accept상태 receive상태 둘다 유지
			clientsocket = serSocket.accept();//담당자 소켓 - 담당을 하기 위한 소켓						// > Thread를 사용
			//clientsocket은 접속client정보를 갖고있음															// > accept은 계속 계속 켜고 receive 체크?
			list.add(clientsocket);//다른 클라이언트들에게 보내주기 위해
			//cf) 소켓은 최소 항상 두개/받는 클라이언트는 하나면 됨
			
			System.out.println("client IP : " + clientsocket.getInetAddress()
							+  " Port : "	  + clientsocket.getPort()	);
															 //getPort값은 OS가 정해주는 것

			
			new ServerThread(clientsocket, list).start();
	
//------------------------------------------------------cf)데드락
			/* severthread에 보냄
			//receive (받다) 2
			BufferedReader reader = new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));
			String packetStr = reader.readLine();	//실제 수신데이터 받는 부분
			
			System.out.println("클라이언트로부터 패킷 : " + packetStr);
			
			
			//send	 (보내다) 3
			PrintWriter writer = new PrintWriter(clientsocket.getOutputStream());
			writer.println(packetStr);				//실제 송신
			writer.flush();
			*/
}		
		
//------------------------------------------------------
			
//			clientsocket.close();
//			serSocket.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
													
		
		
	}
}
