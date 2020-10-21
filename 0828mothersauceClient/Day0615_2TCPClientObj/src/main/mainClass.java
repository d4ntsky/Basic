package main;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

import dto.MemberDto;

public class mainClass {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		InetSocketAddress sockAddr = new InetSocketAddress("127.0.0.1", 9000);

		Socket socket = new Socket();
		
		socket.connect(sockAddr);
		
		InetAddress inerAddr; //접속확인용
		if((inerAddr = socket.getInetAddress()) != null) {
			System.out.println("Server connect success! : " + inerAddr);
		}else {
			System.out.println("Server connect fail");
		}
		
		MemberDto sendDto = new MemberDto(101, "홍길동");
		
		//send
		ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
		oos.writeObject(sendDto);
		oos.flush();
		
		//receive
		ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
		MemberDto recvDto = (MemberDto)ois.readObject();
		
		System.out.println("Server로부터 전송된 Dto: " + recvDto);
	}

}
