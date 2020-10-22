package Task0602_2_TV;
//MyTv2클래스의 멤버변수 isPowerOn, channel, volume을 클래스 외부에서 
//접근할 수 없도록 제어자를 붙이고 대신 이 멤버변수들의 값을 어디서나 읽고 변경할 수 있도록
//getter와 setter메소드를 추가하라. 
public class MyTV {
	
	private boolean isPowerOn;  
	private int channel;  
	private int volume;				//private  
	
	private int prevChannel; //저장할 공간 확보
	
	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;  
	final int MAX_CHANNEL = 100;  
	final int MIN_CHANNEL = 1; 
	 //final int
	//상수라 초기화하면 안됨//인위적으로 바꿀수 없다
	
	
	//is 붙었을때 getter가 자동적으로 붙지않음!!
	public boolean isPowerOn() {
		return isPowerOn;
	}
	public void setPowerOn(boolean isPowerOn) {
		this.isPowerOn = isPowerOn;
	}
	public int getChannel() {
		return channel;
	}
	public void setChannel(int channel) {
		//기존에 있던 값이 들어감
		prevChannel = this.channel;
		
		this.channel = channel; //현재 들어온 값으로 앞부분이 셋팅됨
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	 /*   핵심문제!
	  	  (1) 알맞은 코드를 넣어 완성하시오.  
	  	  (2) 앞의 예제에서 작성한 MyTv2클래스에 이전 채널(previous channel)로 이동하는 
	  	            기능의 메소드를 추가해서 실행결과와 같은 결과를 얻도록 하시오. 
	 	      [Hint] 이전 채널의 값을 저장할 멤버변수를 정의하라. 
 		             메소드명 : gotoPrevChannel 
 		             기 능 : 현재 채널을 이전 채널로 변경한다. 
 		             반환타입 : 없음 
 		             매개변수 : 없음 
	                문제7-10의 MyTv2클래스에 gotoPrevChannel메소드를 추가하여 완성하시오.  
	  */
	
	public void gotoPrevChannel() {	//previous 이 전의 <-> next
		//setchannel이 현재 채널
		this.setChannel(prevChannel);
	}
	
	
}
