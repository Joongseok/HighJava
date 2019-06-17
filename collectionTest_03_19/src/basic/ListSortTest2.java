package basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
	정렬과 관련된 Interface는 Comparable과 Comparator 이렇게 두 가지가 있다.
	
	- 보통 객체 (VO객체) 자체 정렬 기능을 넣기 위해서는 Comparable을 구현하고,
	   앞의 예제처럼 정렬 기준을 별도로 구현하고 싶을 때에는 Comparator를 구현하여
	   사용하면 된다.
	   
	- Comparable에서는 compareTo()메서드를 구현해야 하고,
	  COmparator에서는 compre()메서드를 구현해야 한다.
*/

// 예) 회원번호, 이름, 전화번호를 멤버로 갖는 Member클래스를 구성하는데
//	   회원의 이름을 기준으로 오름차순이 될 수 있는 class를 만드시오.

class Member implements Comparable<Member>{
	
	private int num;
	private String name;
	private String tel;
	
	
	public Member(int num, String name, String tel) {
		super();
		this.num = num;
		this.name = name;
		this.tel = tel;
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", tel=" + tel + "]";
	}


	// 이름을 기준으로 오름차순 정렬이 되도록 설정한다.
	@Override
	public int compareTo(Member mem) {
		return this.name.compareTo(mem.getName());
	}
	
}

public class ListSortTest2 {
	public static void main(String[] args) {
		ArrayList<Member> memList = new ArrayList<Member>();
		
		memList.add(new Member(1, "홍길동", "010-1111-1111"));
		memList.add(new Member(5, "변학도", "010-2222-2222"));
		memList.add(new Member(10, "성춘향", "010-3333-3333"));
		memList.add(new Member(3, "이순신", "010-4444-4444"));
		memList.add(new Member(6, "강감찬", "010-5555-5555"));
		memList.add(new Member(2, "일지매", "010-6666-6666"));
		
		System.out.println("정렬전");
		for(Member mem : memList){
			System.out.println(mem);
		}
		System.out.println("--------------------------");
		
		Collections.sort(memList);
		System.out.println("이름의 오름차순 정렬후");
		for(Member mem : memList){
			System.out.println(mem);
		}
		System.out.println("--------------------------");
		
		// 번호의 내림차순 정렬
		Collections.sort(memList, new SortNumDesc());
		
		System.out.println("번호의 내림차순 정렬후");
		for(Member mem : memList){
			System.out.println(mem);
		}
		System.out.println("--------------------------");
		
		
		
	}
}

// 정렬 기준을 외부에 따로 선언하기 위해서는 Comparator를 구현한다.
// Member의 num값의 내림차순으로 정렬하는 기준 class를 작성한다.
class SortNumDesc implements Comparator<Member>{

	@Override
	public int compare(Member mem1, Member mem2) {
		/*
		if (mem1.getNum() < mem2.getNum()) {
			return 1;
		}else if(mem1.getNum() > mem2.getNum()){
			return -1;
		}else{
			return 0;
		}
		*/
		
		// Wrapper클래스를 이용하는 방법1
//		return Integer.compare(mem1.getNum(), mem2.getNum()) * -1;
		
		// Wrapper클래스를 이용하는 방법2
		return new Integer(mem1.getNum()).compareTo(mem2.getNum()) * -1;
	}
	
}
