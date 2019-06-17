package basic;

public class LambdaTest03 {
	
	// 메서드의 매개변수는 그 메서드 내에서의 '지역변수'이다.
	public void mymethod(final int temp) {
		int localVar = 40;
		
		
		// 람다식 
		LambdaTestInterface1 lt = () -> {
			// 람다식 내에서 지역변수 사용하기
			// 람다식(익명구현체) 내에서 사용되는 지역변수는 final이어야 한다.
			System.out.println("temp => " + temp);
			System.out.println("localVar => " + localVar);
		};
		
		lt.test();
	}
	
	public static void main(String[] args) {
		new LambdaTest03().mymethod(100);

	}

}
