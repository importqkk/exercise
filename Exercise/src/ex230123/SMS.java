package ex230123;

public class SMS extends Apps implements Messenger {

	@Override
	public void send() {
		System.out.println("문자 메세지 전송");		
	}

	@Override
	public void open() {
		System.out.println("문자 앱 열기");		
	}

	@Override
	public void close() {
		System.out.println("문자 앱 종료");		
	}

	public void emergency() {
		System.out.println("긴급재난문자 수신");
	}
	
}
