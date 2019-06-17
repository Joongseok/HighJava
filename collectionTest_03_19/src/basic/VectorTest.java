package basic;

import java.util.Vector;

public class VectorTest {
	
	// Collection에 저장할 수 있는 데이터는 객체형 데이터만 저장할 수 있다.
	public static void main(String[] args) {
		// Vector객체 사용하기
		Vector v1 = new Vector();
		
		System.out.println("크기 : "+ v1.size());
	
		// Vector는 add()메서드를 이용하여 데이터를 추가한다.
		v1.add("aaa");
		v1.add(111); //==> Integer형으로 auto-boxing된다.
		v1.add(new Integer(123));
		v1.add('a');
		v1.add(true);
		v1.add(3.14);
		
		System.out.println("크기 : "+ v1.size());
		System.out.println("v1 => "+ v1);
		
		// addlement()를 이용하여 추가할 수 있다. ==> 예전 버전과 호환을 위해 존재
		v1.addElement("ccc");
		System.out.println("v1 => "+ v1);
		
		// add(index, 데이터); ==> 벡터의 index번째에 '데이터'를 끼워 넣는다.
		v1.add(1, "kkk");
		System.out.println("v1 => "+ v1);
		
		//set(index, 데이터); ==> 벡터의 index번째의 값을 주어진 '테이터'로 덮어쓴다.
		//					==> 반환값 : 원래의 데이터를 반환해준다??
		String temp = (String)v1.set(0, "zzz");
		System.out.println("원래의 데이타 : "+temp);
		System.out.println("v1 => "+ v1);
		
		// remove(index); ==> 벡터의 index번째 데이터를 삭제한다.
		//				  ==> 자료가 삭제되면 index번? 다음번째의 데이터들이 앞으로 
		//					   자동으로 다겨져서 채워진다.
		//				  ==> 반환값 : 삭제된 데이터
		
		// remove(삭제할데이터);	==> 벡터에서 '삭제할데이터'를 찾아 삭제한다.
		//						==> 삭제할 데이터가 여러개이면 앞에서부터 삭제된다.
		//			==> '삭제할데이터'가 '정수형'이거나 'char형'일 경우 객체로 변환해서 
		//				사용해야 한다.
		v1.remove(0);
		System.out.println("삭제 후 v1 => "+ v1);
		
		String temp1 = (String) v1.remove(0);
		System.out.println("삭제된 데이터 : "+ temp1);
		System.out.println("삭제 후 v1 => "+ v1);
		
		v1.add(123);
		System.out.println("삭제 전 v1 => " +v1);
		
		v1.remove(true);
		System.out.println("삭제 후 v1 => "+v1);
		
//		v1.remove(123); //안?
		v1.remove((Integer)123);//둘다가능
		v1.remove(new Integer(123));
		System.out.println("삭제 후 v1 => "+v1);
		
//		v1.remove('a'); //안?
		v1.remove((Character)'a');//둘다가능
		v1.remove(new Character('a'));
		v1.remove(3.14);
		System.out.println("삭제 후 v1 => "+v1);
		
		// get(index); ==> 벡터의 index번째 자료를 반환한다.
		int data = (int) v1.get(0);
		System.out.println("0번째 자료 : "+data);
		
//		int data2 = (int) v1.get(1);//안?
		
		//---------------------------------------------------------------------------------------------
		/*
		 제네릭 타입(generic type)  ==> 객체를 선언할 때 < > 괄호 안에 그 Collection이
		  							사용할 데이터 타입을 저장해 주는 것을 말한다.
		  							이런식으로 선언하게 되면 지정한 데이터 타입 이외의 다른 데이터를 저장할 수 없다.
		  							제네릭 타입으로 선언하면 데이터를 꺼내올 때 별도의 형변환이 필요 없다.
		  							
		  							단, 제네릭으로 지정할 수 있는 데이터 타입은 '클래스형'이어야 한다.
		  							 (그래서 int는 Integer, boolean은 Boolean, char는 Character등으로 
		  							  대체해서 사용해야 한다.)
		*/
		Vector<String> v2 = new Vector<String>(); // String만 저장할 수 있는 벡터
		Vector<Integer> v3 = new Vector<Integer>();// int형만 저장할 수 있는 벡터
		
		v2.add("안녕하세요");
		String temp2= v2.get(0);
		System.out.println("temo2 = > "+ temp2);
		//---------------------------------------------------------
		
		Vector<Vector> vv = new Vector<Vector>();
		Vector<Vector<Vector>> vvv = new Vector<Vector<Vector>>();
		System.out.println("----------------------------------------------------");
		System.out.println();
		
			
		v2.clear();		//벡터의 모든 데이터를 삭제한다.
		System.out.println("v2의 크기 : "+ v2.size());
		
		v2.add("AAA");
		v2.add("BBB");
		v2.add("CCC");
		v2.add("DDD");
		v2.add("EEE");
		
		Vector<String> v4 = new Vector<String>();
		v4.add("BBB");
		v4.add("EEE");
		
		System.out.println("v2 = > "+ v2);
		
		// removeAll(Collection객체);  ==> 'Collection객체'가 가지고 있는 데이터를 
		//								  모두 삭제한다.
		v2.removeAll(v4);
		System.out.println("v2 = > "+ v2);
		System.out.println("--------------------------------------");
		
		v2.clear();
		v2.add("AAA");
		v2.add("BBB");
		v2.add("CCC");
		v2.add("DDD");
		v2.add("EEE");
		
		//벡터의 데이터를 순서대로 모두 하나씩 가져와서 사용하고 싶으면 
		//반복문을 사용하면 된다.(주로 for문을 많이 사용한다.)
		for (int i = 0; i < v2.size(); i++) {
			System.out.println(i+ "번째 자료 : "+v2.get(i));
		}
		System.out.println("--------------------------------------");
		
		//향상된 for문
		for(String s : v2){
			System.out.println(s);
		}
		System.out.println();
		
		for(Object obj : v1){// 제네릭을 사용하지 않으면 Object형으로 처리한다.
			System.out.println(obj);
		}
		
		
	}
}
