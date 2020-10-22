package Task0602_2_TV;

public class TV1 {
	public static void main(String args[]) {

		MyTV t = new MyTV();

		t.setChannel(10);
		System.out.println("CH:" + t.getChannel());
		t.setVolume(20);
		System.out.println("VOL:" + t.getVolume());

	}

}

			//[실행결과] CH:10 VOL:20 