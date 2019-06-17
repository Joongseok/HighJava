package basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListSortTest {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		
		list.add("일지매");
		list.add("홍길동");
		list.add("성춘향");
		list.add("변학도");
		list.add("이몽룡");
		
		list1.add(100000);
		list1.add(10);
		list1.add(100);
		list1.add(1000);
		list1.add(10000);
		
		System.out.println("정렬 전 : " + list);
		System.out.println("정렬 전 : " + list1);
		
		// 정렬은 Collections.sort()메서드를 이용하여 정렬한다.
		// 이 메서드의 기본적인 정렬방식은 '오름차순' 방식이다.
		Collections.sort(list);
		Collections.sort(list1);
		
		System.out.println("정렬 후 : " + list);
		System.out.println("정렬 후 : " + list1);
		
		Collections.shuffle(list);
		Collections.shuffle(list1);
		System.out.println("자료 섞기 후  : " + list);
		System.out.println("자료 섞기 후  : " + list1);
		Desc dd = new Desc();
//		Collections.sort(list, dd);
		Collections.sort(list, new Desc());// 정렬 기준 객체를 지정하여 정렬하기
		System.out.println("정렬 후 : " + list);
		
		
	}
}


// 정렬 방식을 사용자가 임의로 정하고 싶으면 Comparator인터페이스를 
// 구현하는 클래스를 작성하고 이 클래스의 인스턴스를 sort()메서드의 
// 매개값으로 넣어주면 된다.

class Desc implements Comparator<String>{
	// Comparator 인터페이스에는 compare()메서드가 선언되어 있어서
	// 이것을 재정의 해야 한다.
	
	// compare()메서드를 구현하는 방법
	// 오름차순일 경우 
	//		==> 앞의 값이 크면 양수, 같으면 0, 앞의 값이 작으면 음수를 반환한도록 한다.
	
	// 이 메서드가 양수를 반환하면 앞, 뒤 값의 순사가 바뀐다.
	
	// String 객체에는 정렬을 위해서 compareTo()메서드가 구현되어 있는데
	// 이 메서드의 반환값은 오름차순에 맞게 반환되도록 구현되어 있다.
	// (Wrapper클래스아 Data 객체, File객체에도 구현되어 있다.)
	@Override
	public int compare(String o1, String o2) {
		
		if(o1.compareTo(o2)>0){
			return -1;
		}else if(o1.compareTo(o2)<0){
			return 1;
		}else{
			return 0;
		}
	}
}

class Desc1 implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		
		return o1.compareTo(o2) * -1;
	}
	
}