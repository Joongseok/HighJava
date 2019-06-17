package genericTest;

// 제네릭을 사용하지 않는 클래스
class NonGenericClass{
	private Object value;

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
}

/*
	제네릭 클래스 만드는 방법
class 클래스명<제네릭타입글자>{
	제네릭타입글자 변수명;  // 변수 선언에 사용할 경우 
	...
	
	제네릭타입글자 메서드명(){ // 메서드의 반환값으로 사용할 경우
		...
		return 값;
	}
	
	반환값타입 메서드명(제네릭타입글자 변수명){ //메서드의 매개변수에 사용할 경우  
		...
	}
	
}


=== 제네릭 타입 글자 ===
T == Type(타입)
K == Key(키)
V == Value(값)
E == Element(구성요소)
*/

class MyGenericClass<T>{
	private T value;
	
	public void setValue(T value){
		this.value = value;
	}
	
	public T getValue(){
		return value;
	}
}

public class GenericTest {

	public static void main(String[] args) {
		NonGenericClass ng1 = new NonGenericClass();
		ng1.setValue("가나다라");
		String rtn = (String)ng1.getValue();
		System.out.println("문자열 반환값 : " +  rtn);
		
		NonGenericClass ng2 = new NonGenericClass();
		ng2.setValue(100);
		int irtn = (int)ng2.getValue();
		System.out.println("정수 반환값 : " + irtn);
		/*
		// 형변환이 잘못되면 실행시 오류가 발생한다.
		String rtn2 = (String)ng2.getValue();
		System.out.println("반환값 : " + rtn2);
		ng1.setValue("가나다라");
		*/
		
		// ===============================
		MyGenericClass<String> mg1 = new MyGenericClass<String>();
		mg1.setValue("우리나라");
		String strRtn = mg1.getValue(); // 형변환이 필요없다.
		System.out.println("제네릭 문자열 반환값 = " +  strRtn);
		
		MyGenericClass<Integer> mg2 = new MyGenericClass<Integer>();
		mg2.setValue(200);
		int intRtn = mg2.getValue();
		System.out.println("제네릭 정수형 반환값 = " + intRtn);
		
		// 제네릭에 설정한 데이터와 다른 종류의 데이터를 셋팅할 때 오류가 발생
		// (컴파일 단계에서 오류 발생)
		//mg1.setValue(123);
		//mg2.setValue("abcd");
		//String st = (String)mg2.getValue();
		
		
	}
	
}