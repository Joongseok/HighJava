package basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 문제) Set을 이용하여 숫자 야구 게임 프로그램을 작성하시오.
 컴퓨터의 숫자는 난수를 이용하여 구한다.
 (스트라이크는 S, 볼은 B로 출력한다.)

 실행 예)	컴퓨터 난수 ==> 9 5 7
 숫자입력 => 3 5 6
 3 5 6 => 1S 0B
 숫자입력 => 7 8 9
 7 8 9 => 0S 2B
 숫자입력 => 9 7 5
 9 7 5 => 1S 2B
 숫자입력 => 9 5 7
 9 5 7 => 3S 0B

 4번만에 맞췄군요!!
 */
public class BaseBallTest {
	ArrayList<Integer> numList; // 난수를 저장할 리스트
	ArrayList<Integer> userList = new ArrayList<Integer>(); // 사용자가 입력한 값을 저장할
															// 리스트

	int strike; // 스트라이크 개수가 저장될 변수
	int ball; // 볼의 개수

	Scanner sc = new Scanner(System.in);

	// 1~9사이의 서로 다른 난수 3개를 만들어서 리스트에 저장하는 메서드
	public void getNum() {
		Set<Integer> numSet = new HashSet<Integer>();

		// Set을 이용한 3개의 난수 만들기
		while (numSet.size() < 3) {// Set의 사이즈가 3보다 작을때 까지 반복
			numSet.add((int) (Math.random() * 9 + 1));
		}
		// Set의 값들을 List에 저장하기
		numList = new ArrayList<Integer>(numSet);// 이렇게 하면 정렬이 되서 리스트에 저장?

		// 리스트의 데이터 섞기
		Collections.shuffle(numList);
	}

	// 사용자로부터 3개의 정수를 입력 받아 리스트에 저장하는 메서드
	public void inputNum() {
		int n1, n2, n3;
		do {
			System.out.print("중복되지 않은 정수 3개를 입력 >> ");
			n1 = sc.nextInt();
			n2 = sc.nextInt();
			n3 = sc.nextInt();
			if (n1 == n2 || n1 == n3 || n2 == n3) {
				System.out.println("입력값이 중복됩니다. 다시 입력하세요");
			}
		} while (n1 == n2 || n1 == n3 || n2 == n3);

		userList.clear();
		userList.add(n1);
		userList.add(n2);
		userList.add(n3);

	}

	// 스트라이크와 볼 판정 및 출력하는 메서드
	public void ballCount() {
		strike = 0;
		ball = 0; // 스트라이크와 볼의 개수 초기화

		for (int i = 0; i < numList.size(); i++) {
			for (int j = 0; j < userList.size(); j++) {
				if (numList.get(i) == userList.get(j)) { // 값이 같은지 비교
					if (i == j) {
						strike++;
					} else {
						ball++;
					}
				}
			}
		}

		// 판정 결과 출력
		System.out.println(userList.get(0) + ", " + userList.get(1) + ", "
				+ userList.get(2) + " => " + strike + "S " + ball + "B");

	}

	// 전체 게임을 진행하는 메서드
	public void gameStart() {
		// 난수 만드는 메서드 호출
		getNum();
		// 확인용 출력
//		System.out.println("난수값 => " + numList.get(0) + ", " + numList.get(1)
//				+ ", " + numList.get(2));

		int cnt = 0;

		do {
			cnt++;

			// 사용자 입력
			inputNum();

			// 볼카운트 메서드 호출
			ballCount();

		} while (strike != 3); // 스트라이크가 3이 될때까지 반복한다.

		System.out.println(cnt + "번째만에 맞췄군요!!");

	}

	public static void main(String[] args) {
		new BaseBallTest().gameStart();
	}

}
