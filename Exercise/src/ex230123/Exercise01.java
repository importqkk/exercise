package ex230123;

public class Exercise01 {
	public static void main(String[] args) {
		
		KakaoTalk k = new KakaoTalk();
		k.open();
		k.send();
		k.voiceTalk();
		k.close();
		System.out.println();
		
		SMS s = new SMS();
		s.open();
		s.send();
		s.emergency();
		s.close();
		System.out.println();
		
		Youtube y = new Youtube();
		y.open();
		y.play();
		y.upload();
		y.subscribe();
		y.close();
		System.out.println();
		
		Netflix n = new Netflix();
		n.open();
		n.play();
		n.download();
		n.lock();
		n.close();
		System.out.println();
		
	}
}
