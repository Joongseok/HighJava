package basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
	문제) 5명의 사람 이름을 차례로 입력받아 ArrayList에 저장한다.
		저장이 모두 완료되면 이 ArrayList에 있는 데이터 중 '김'씨
		성을 가진 데이터를 모두 출력하시오.
		(단, 입력은 Scanner를 이용하여 입력 받는다.)
*/
public class ArrayListTest2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		System.out.println("5명의 이름을 입력하세요.");
		for (int i = 1; i <= 5; i++) {
			System.out.println(i+ "번째 이름을 입력하세요");
			String name = sc.nextLine();
			list1.add(name);
		}
		System.out.println("입력받은 사람 목록 : "+ list1);
		for(String testName : list1){
			if (testName.startsWith("김")) {
				System.out.println(testName);
			}
		}
		for (int i = 0; i < list1.size(); i++) {
			if (list1.get(i).indexOf("김")==0) {
				list2.add(list1.get(i));
			}
//			if (list1.get(i).substring(0, 1).equals("김")) {
//				list2.add(list1.get(i));
//			}
//			if (list1.get(i).startsWith("김")) {
//				list2.add(list1.get(i));
//			}
//			if (list1.get(i).charAt(0)=='김') {
//				list2.add(list1.get(i));
//			}
		}
		System.out.println("김씨의 성을 가진 사람 : "+list2);
		
		
		
	}

}
