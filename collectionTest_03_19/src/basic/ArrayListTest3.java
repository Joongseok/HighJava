package basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
	문제1) 5명의 별명을 입력하여 ArrayList에  저장하고
		별명이 제일 긴 별명을 출력하시오
		(단, 각 별명의 길이는 모두 다르게 입력한다.)
		
	문제2) 문제1에서 별명의 길이가 같은 것이 여러개 일 경우를 처리하시오.
*/
public class ArrayListTest3 {
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		ArrayListTest3 test = new ArrayListTest3();
		test.first();
//		test.second();
	}
	// 문제 1번 처리하는 메서드
	public void first(){
		ArrayList<String> aliasList = new ArrayList<String>();
		
		System.out.println("서로 다른 길이의 별명 5개를 입력하세요.");
		for (int i = 1; i <= 5; i++) {
			System.out.print(i + "번째 별명 : ");
			String alias = sc.next();
			aliasList.add(alias);
		}
		
		int maxIndex = 0; // 제일 긴 별명이 들어있는 index값을 저장할 변수 선언
		for (int i = 0; i < aliasList.size(); i++) {
			if (aliasList.get(maxIndex).length() < aliasList.get(i).length()) {
				maxIndex = i;
			}
		}
		
		System.out.println("제일 긴 별명 : " + aliasList.get(maxIndex));
		
//		// 제일 긴 글자수가 저장 될 변수 선언
//		// 이 변수에는 List의 첫번째 데이터의 길이값을 초기화 한다.
//		int maxLength = aliasList.get(0).length();
//		for (int i = 1; i < aliasList.size(); i++) {
//			int len = aliasList.get(i).length();
//			if (maxLength < len) {
//				maxLength = len;
//			}
//		}
//		
//		for (int i = 0; i < aliasList.size(); i++) {
//			if (aliasList.get(i).length() == maxLength) {
//				System.out.println(aliasList.get(i));
//				
//			}
//		}
	}
	// 문제 2번 처리하는 메서드
	public void second(){
		ArrayList<String> aliasList = new ArrayList<String>();
		
		System.out.println("별명 5개를 입력하세요.");
		for (int i = 1; i <= 5; i++) {
			System.out.print(i + "번째 별명 : ");
			String alias = sc.next();
			aliasList.add(alias);
		}
		// 제일 긴 글자수가 저장 될 변수 선언
		// 이 변수에는 List의 첫번째 데이터의 길이값을 초기화 한다.
		int maxLength = aliasList.get(0).length();
		for (int i = 1; i < aliasList.size(); i++) {
			int len = aliasList.get(i).length();
			if (maxLength < len) {
				maxLength = len;
			}
		}
		System.out.println("제일 긴 별명들");
		for (int i = 0; i < aliasList.size(); i++) {
			if (aliasList.get(i).length() == maxLength) {
				System.out.println(aliasList.get(i));
				
			}
		}
	}
	
}
