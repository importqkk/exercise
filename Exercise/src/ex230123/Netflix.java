package ex230123;

public class Netflix extends Apps implements Video {

	@Override
	public void play() {
		System.out.println("넷플릭스 영상 재생");		
	}

	@Override
	public void open() {
		System.out.println("넷플릭스 열기");				
	}

	@Override
	public void close() {
		System.out.println("넷플릭스 종료");				
	}

	public void download() {
		System.out.println("넷플릭스 영상 다운로드");
	}
	
	public void lock() {
		System.out.println("넷플릭스 화면 잠금");
	}
	
}
