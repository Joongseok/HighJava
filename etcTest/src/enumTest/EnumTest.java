package enumTest;

// 열거형(enum) ==> 서로 관련있는 상수들의 집합(클래스처럼 보이게 하는 상수)


public class EnumTest {
	public final static int YES = 1;
	public final static int NO = 0;
	
	public final static int ON = 1;
	public final static int OFF = 0;
	
	//City열거형 객체 선언
	public enum City{ 서울, 부산, 대구, 광주, 대전 }
	public enum City2{ 서울, 부산, 대구, 광주, 대전 }
	
	public static void main(String[] args) {
		if (EnumTest.YES == EnumTest.ON) {
			System.out.println("참...");
		}
//		if (City.서울 == City2.서울) {
//			System.out.println("참...");
//		}
		
		/*
		valueOf("열거형상수명"); ==> 지정된 열거형에서 '열거형상수명'과 일치하는 열거형
								  상수를 반환한다.
		name();		==> 열거형 상수명을 문자열로 반환한다.
		ordinal();  ==> 열거형 상수가 정의된 순서값을 반환한다.(0부터 시작)
		*/
		// City enum에서 '대구'를 가져온다.
		City city1 = City.valueOf("대구");
		
		System.out.println("name : " + city1.name());
		System.out.println("ordinal : " + city1.ordinal());
		System.out.println();
		
		// City enum에서 '서울'을 가져온다.
//		City city2 = City.서울;
		City city2 = City.대구;
		System.out.println("name : " + city2.name());
		System.out.println("ordinal : " + city2.ordinal());
		
		
		// enum은 비교를 '=='연사자를 이용하여 할 수 있다.
		if (city1==city2) {
//		if (city1==City.대구){
			System.out.println("같음");
		}else{
			System.out.println("다름");
		}
		
		// switch 문에서 사용할 수 있다.
		switch(city1){
		case 서울 : System.out.println("city1은 서울입니다."); break; 
		case 부산 : System.out.println("city1은 부산입니다."); break; 
		case 대구 : System.out.println("city1은 대구입니다."); break; 
		case 광주 : System.out.println("city1은 광주입니다."); break; 
		case 대전 : System.out.println("city1은 대전입니다."); break; 
		}
		System.out.println();
		for(City ci : City.values())
			System.out.println(ci.name() + "==>" + ci.ordinal());
	}
}