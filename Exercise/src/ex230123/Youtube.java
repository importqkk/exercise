package ex230123;

public class Youtube extends Apps implements Video {

	@Override
	public void play() {
		System.out.println("유튜브 영상 재생");
	}

	@Override
	public void open() {
		System.out.println("유튜브 열기");		
	}

	@Override
	public void close() {
		System.out.println("유튜브 종료");		
	}
	
	public void upload() {
		System.out.println("유튜브 영상 업로드");
	}
	
	public void subscribe() {
		System.out.println("유튜브 구독하기");
	}

}
