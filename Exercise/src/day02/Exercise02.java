package day02;
import java.lang.*;

public class Exercise2 {
	public static void main(String[] args) {
		
		// 아침 8시 40분부터 오후 3시 15분까지 공부했으면 총 공부 시간은?
		
		// input
		int startH = 8, startM = 40;
		int finishH = 3, finishM = 15;
		
		// process
		int startT = (startH * 60) + startM;			// 공부 시작 시간을 분 단위로 변환
		int finishT = ((finishH + 12) * 60) + finishM;	// 공부 종료 시간을 분 단위로 변환 (+ 오후이므로 12시간 더해줌) 
		int totalT = finishT - startT;					// 총 공부시간(분) 구하기
		
		int totalH = totalT / 60;						// 분으로 된 총 공부시간에서 시간만 구하기 (몫)
		int totalM = totalT % 60;						// 총 공부시간에서 시간을 구하고 남은 분 구하기 (나머지)
		
		// output
		System.out.println(totalH);						// 총 공부 시간 (6시간)
		System.out.println(totalM);						// 총 공부 시간 (35분)

	}

}
