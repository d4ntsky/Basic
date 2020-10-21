package thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReadThread extends Thread {

	Socket socket;
	
	public ReadThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		try {
		
		//receive (받다) 4  -- 이부 분에서 thread
		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String packetStr;
		packetStr = reader.readLine();
		System.out.println("서버로부터 패킷 : " + packetStr);
		
			
			Thread.sleep(1000);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}	//client 받는 쪽도 thread가 켜져 있어야함.
		
		
	}
	
	
}
