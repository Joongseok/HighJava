package basic;
/*
	람다식 ==> 익명함수를 생성하기 위한 식
		 ==> 자바에서는 '매개변수를 가진 코드 블럭'으로
		 	런타임시 '익명구현체'로 생성된다.

	형식)
		인터페이스명 변수명 = 람다식;
		
	람다식은 인터페이스에서 구현한 메서드의 헤더와 일치하는 모양으로 작성한다.
	람다식 형식)
		(자료형이름1 변수명1, 자료형이름2 변수명2,...) ->{ 실행문들; ...}
		
	람다식 작성시 기본 규칙
	1. 매개변수의 '자료형이름'을 생략할 수 있다.
		(int a) -> { System.out.println(a); }
		(a) -> { System.out.println(a); }
		
	2. 매개변수가 1개만 있을 경우에는 괄호('( )')를 생략할 수 있다.
		a -> { System.out.println(a); }
	
	3. 처리할 실행문이 1개일 경우에는 중괄호('{}')를 생략할 수 있다.
		a -> System.out.println(a)
		
	4. 매개변수가 하나도 없거나 2개 잇아이면 괄호('( )')를 생략할 수 없다.
		( ) -> System.out.println("안녕")
		
	5. 반환값이 있는 경우 return명령을 사용한다.
		(a, b) -> { return a + b; }
		(a, b) -> return a + b;
		
	6. 처리할 실행문이 return문 하나이면 'return'명령과 중괄호('{ }')를 생략할 수 있다.
		(a, b) -> a + b
	=================================================================
	
	람다식으로 변환할 수 있는 인터페이스는 구현해야할 메서드가 1개일 경우에만 가능하다.
	그래서 이런 인터페이스를 '함수적 인터페이스' 라고 하고
	이런 인터페이스에 @FunctionalIneterface라는 애너테이션이 붙여준다.
*/
public class LambdaTest01 {

	public static void main(String[] args) {
		
		// Runnable인터페이스도 '함수적 인터페이스'이다
		
		// 람다식을 사용하지 않고 구현하기
		/*
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				for (int i = 1; i <=10 ; i++) {
					System.out.println(i);
				}
			}
		};
		Thread th1 = new Thread(r);
		*/
		Thread th1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 1; i <=10 ; i++) {
					System.out.println(i);
				}
			}
		});
		th1.start();
		
		// 람다식을 사용하는 경우
		Thread th2 = new Thread(
			() -> {
				for (int i = 1; i <=10 ; i++) {
					System.out.println("람다식 => " +i);
				}
			}	
		);
		th2.start();
		
		
		
		
		
		
	}
	
}
