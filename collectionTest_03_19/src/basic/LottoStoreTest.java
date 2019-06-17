package basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

/*로또를 구매하는 프로그램 작성하기 (class명 : LottoStoreTest)

사용자는 로또를 구매할 때 구매할 금액을 입력하고
입력한 금액에 맞게 로또번호를 출력한다.
(단, 로또 한장의 금액은 1000원이며 최대 100장까지만 구입할 수 있고,
     거스름돈도 계산하여 출력한다.)
*/
public class LottoStoreTest {
	public static void main(String[] args) {
		Lotto lotto = new Lotto();
		lotto.start();
		
	}
}
class Lotto{
	void start(){
		while(true){
			Scanner sc = new Scanner(System.in);
			System.out.println("==================");
			System.out.println("Lotto 프로그램");
			System.out.println("------------------");
			System.out.println("1. Lotto 구입");
			System.out.println("2. 프로그램 종료");
			System.out.println("========================");
			System.out.print("메뉴 선택 : ");
			int num = sc.nextInt();
			switch (num) {
			case 1:
				lottoStart();
				break;
				
			default:
				return;
			}
			
		}
	}
	void lottoStart(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Lotto 구입 시작");
		System.out.println();
		System.out.println("(1000원에 로또번호 한개 입니다.)");
		System.out.print("금액 입력 : ");
		int price = sc.nextInt();

		int qty = price / 1000;
		
		if(price > 10001){
			System.out.println("입력금액이 너무 많습니다. 로또번호 구입 실패!!!");
			return;
		}else if(price<1000){
			System.out.println("입력금액이 너무 적습니다. 로또번호 구입 실패!!!");
			return;
		}
		
	
		System.out.println("행운의 로또번호는 아래와 같습니다.");
		HashSet<Integer> lotto = new HashSet<Integer>();
		ArrayList<Integer> lottoList = null;
		for (int i = 1; i < qty+1; i++) {
			while (lotto.size() < 6) {
				int a = (int) (Math.random() * 45 + 1);
				lotto.add(a);
				lottoList = new ArrayList<Integer>(lotto);
				Collections.sort(lottoList);
			}
			lotto.clear();
			
			System.out.println("로또번호"+i+" : "+lottoList);
		}
		System.out.println("받은 금액은 "+price+"원이고 개수는 "+qty+"개입니다");
		
	}
}