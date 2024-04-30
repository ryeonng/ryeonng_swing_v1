package ch07;

import java.util.Arrays;
import java.util.Random;

// 클래스를 설계할 때 , 단일 책임 원칙을 설정하는 것이 좋다.
// 
public class LottoRandomNumber {

	final int LOTTO_NUMBER_COUNT = 6;
	
	// 6개의 랜덤 번호를 생성하는 메서드 필요.
	public int[] createNumber() {
		
		int[] lottoWinNum = new int[LOTTO_NUMBER_COUNT];
		Random random = new Random();
		// outer for -> 0 -> inner for -->
		// outer for -> 1 -> inner for -->동작 안 함
		// outer for -> 2 -> inner for -->두 번 동작
		// 10
		// 10 20
		// 10 20 10 ( 같은 수가 있다면, 다시 한 번 더 반복하라.)
		for (int i = 0; i < lottoWinNum.length; i++) {
			// 20    30 20
			lottoWinNum[i] = random.nextInt(45) + 1; // 0 ~ 45 까지
			//             0 < 1 한 번 반복
			for(int j = 0; j < i; j++) {
				// 20 == 20
				if(lottoWinNum[j] == lottoWinNum[i]) {
					//  값이 중복된 상태이다.
					i--;
				}
				
			}
		}
		// 중복 제거 완료
		
		Arrays.sort(lottoWinNum); // 기본값을 오름차순으로 자동 정렬해준다.
		
		return lottoWinNum;
	}
	
	// 코드 테스트
	public static void main(String[] args) {
		LottoRandomNumber randomNumber = new LottoRandomNumber();
		
		int[] resultArray = randomNumber.createNumber();
		for (int i = 0; i < resultArray.length; i++) {
			System.out.println(resultArray[i]);
		}
	}
	
}
