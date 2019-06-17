package basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
	10마리의 말들이 경주하는 경마 프로그램 작성하기
	
	말은 Horse라는 이름의 클래스로 구성한다.
	이 클래스는 말이름(String), 등수(int), 현재위치(int)를 멤버변수로 갖는다.
	그리고 이 클래스는 등수를 오름차순으로 처리할 수 있는 기능이 있다.
	( Comparable인터페이스 구현)
	
	경기 구간은 1 ~ 50 구간으로 되어 있다.
	
	일정한 시간마다 말들의 위치를 아래와 같이 출력한다.
	출력예)
		1번말 --->---------------------------
		1번말 ------------->-----------------
		1번말 --------->---------------------
		1번말 ---------------------->--------
		...
		10번말 ---------------------->--------
		
	경기가 끝나면 등수 순으로 출력한다.
*/
public class ThreadTest15 {
	public static int rank = 1;
	public static List<Horse> hList;
	public static void main(String[] args) {
	int select=0;
	Scanner sc =  new Scanner(System.in);
	AutoCheckThread auto = new AutoCheckThread();
	hList = new ArrayList<Horse>();
		
		while(true){
			
		System.out.print("경주시킬 말의 마리수를 선택해주세요 >> ");
		try {
			select = sc.nextInt();
			if (select <1) {
				System.out.println("숫자를 너무 작게입력하셨습니다.");
				continue;
			}else if(select>20){
				System.out.println("마리수를 너무 많이 입력하셨습니다.");
				continue;
			}
		} catch (Exception e) {
			System.out.println("잘못입력하셨습니다.");
			continue;
		}
		 break;
		}
		
		for (int i = 1; i <= select; i++) {
			hList.add(new Horse(i+"번마"));
		}
		auto.setDaemon(true);
		
		for (int i = 0; i < hList.size(); i++) {
			hList.get(i).start();
		}
		auto.start();
		for (int i = 0; i < hList.size(); i++) {
			try {
				hList.get(i).join();
				
			} catch (Exception e) {
			}
			
		}
		System.out.println();
		System.out.println("경기 결과");


		Collections.sort(hList);
		for (int i = 0; i < ThreadTest15.hList.size(); i++) {
			System.out.println(ThreadTest15.hList.get(i).getRank() + "위 " + 
					ThreadTest15.hList.get(i).getName1());

		}
	
		
	}
}

class Horse extends Thread implements Comparable<Horse>{
	private  String name1;
	private int rank =1;
	private int meter;
	
	public String getName1() {
		return name1;
	}


	public void setName1(String name1) {
		this.name1 = name1;
	}


	public Horse(String name1){
		this.name1 = name1;
	}


	public int getRank() {
		return rank;
	}


	public void setRank(int rank) {
		this.rank = rank;
	}


	public int getMeter() {
		return meter;
	}


	public void setMeter(int meter) {
		this.meter = meter;
	}


	
	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			meter++;
			try {
				Thread.sleep((int)(Math.random()*301+200));
			} catch (InterruptedException e) {
			}
		}
		for (int i = 0; i < ThreadTest15.hList.size(); i++) {
			if(ThreadTest15.hList.get(i).getName1().equals(name1)){
				ThreadTest15.hList.get(i).setRank(ThreadTest15.rank);
				ThreadTest15.rank++;
			}
		}
	}


	@Override
	public int compareTo(Horse o) {
		return Integer.compare(this.rank, o.rank);
	}
	
}

class AutoCheckThread extends Thread{
	public void check(){
		int length = 50;
		StringBuffer stb = new StringBuffer();
		List<Horse> list = ThreadTest15.hList;
		System.out.println();
		System.out.println("*******************************************************");
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < length; j++) {
				if (j==list.get(i).getMeter()) {
					stb.append(">");
				}else{
					stb.append("=");
				}
			}
			System.out.println(list.get(i).getName1() +stb );
			stb.delete(0, stb.length());
			
		}
		System.out.println("*******************************************************");
		System.out.println();
		
		
	}
	@Override
	public void run() {
//		int meter = 50;
		while(true){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
			check();
//			meter--;
//			if (meter==0) {
//			}
		}
	}
//		public void r15(){
			
//			
//		}
}