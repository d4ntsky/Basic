package main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import thread.EchoThread;

public class mainClass {
	public static void main(String[] args) {
		
		ServerSocket server = null;
		Socket socket =null;		
		
		//클라이언트와 연결된 소켓들을 배열처럼 저장할 벡터객체 생성
		Vector<Socket> vec = new Vector<Socket>();
		
		try{
			server= new ServerSocket(9000);
			
			while(true){
				System.out.println("접속대기중..");				
				
				socket = server.accept();
				
				//클라이언트와 연결된 소켓을 벡터에 담기
				vec.add(socket);
				
				//스레드 구동
				new EchoThread(socket, vec).start();
			}
		}catch(IOException ie){
			System.out.println(ie.getMessage());
		}
	}
}

//cf)

/*
dto clientnumber 기입받는name play번호
전송을 돌아가면서 누르는 ex)오목,바둑
차례가 한번씩 왔다갔다.
턴제 프로그램
dto를 넘겨서 서버가 제어하는
buffered reader 가 아닌
outstream으로 object 왔다갔다
object 받아서 object를 넘겨주는
클릭했을때 차례가 아니면 당신차례가 아닙니다.
client가 공평하게 한번씩 눌리게

a=0 b=1일때
a는 b와 같아지려고 하고 
b는 a와 달라지려고 하고
a != b
	if 참이면 
		a = 1로 바뀌고
	else
		같은상태라 뜨는 메시지를 > 당신차례가 아닙니다로
b = 0
	if 참이면
		
 */