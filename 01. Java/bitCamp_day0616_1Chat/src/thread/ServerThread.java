package thread;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class ServerThread extends Thread{
	
	Socket clientsocket;
	List<Socket> list;
	
	
	public ServerThread(Socket clientsocket, List <Socket> list) {
		this.clientsocket = clientsocket;	// 자기 자신의 Socket
		this.list = list;					// Socket의 묶음
	}

	@Override
	public void run() {

		super.run();
		
		try {
		
			while(true) {
		//receive (받다) 2
			BufferedReader reader = new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));
			String packetStr = reader.readLine();	//실제 수신데이터 받는 부분
		
			System.out.println("클라이언트로부터 패킷 : " + packetStr);
		
		
		//send	 (보내다) 3
			//list
			for (int i = 0; i < list.size(); i++) {
			Socket soc = list.get(i);
			if(clientsocket != soc)
			{PrintWriter writer = new PrintWriter(soc.getOutputStream());
			writer.println(packetStr);				//실제 송신
			writer.flush();
				}
			
			}
			Thread.sleep(100);
			
		}
				} catch (IOException | InterruptedException e) {
					System.out.println("열결이 끊긴 IP : " + clientsocket.getInetAddress()
										+ "  Port : " + clientsocket.getPort());
					
					list.remove(clientsocket); //리스트에 담당소켓 지우는
					
					//남은 client 확인
					for (Socket s : list) {
						System.out.println("접속되어 있는 IP : " + s.getInetAddress() +
										   "  Port : " + s.getPort());
					}
					
					try {
						clientsocket.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
		} 
		
	}
}
		