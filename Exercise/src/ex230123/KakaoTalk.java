package ex230123;

public class KakaoTalk extends Apps implements Messenger {

	@Override
	public void send() {
		System.out.println("카카오톡 메세지 전송");
	}

	@Override
	public void open() {
		System.out.println("카카오톡 열기");
	}

	@Override
	public void close() {
		System.out.println("카카오톡 종료");
	}
	
	public void voiceTalk() {
		System.out.println("보이스톡 걸기");
	}
	
}
