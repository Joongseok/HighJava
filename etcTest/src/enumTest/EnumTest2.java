package enumTest;

public class EnumTest2 {
	// 열거형 상수에 다른 값을 설정하는 방법
	// 데이터 값을 정해 줄 경우에는 생성자를 만들어서 괄호 속의 값이
	// 변수에 저장되도록 한다.
	public enum Season{
		봄("3월부터 5월까지"),
		여름("6월부터 8월까지"),
		가을("8월부터 11월까지"),
		겨울("12월부터 2월까지");
		
		private String span; // 다른값이 저장될 변수 선언
		
		//  생성자 ==> 열거형의 생성자는 묵시적으로 private이다.
		Season(String span){
			this.span = span;	// 다른값을 변수에 초기화
		}

		public String getSpan() {
			return span;
		}

		public void setSpan(String span) {
			this.span = span;
		}
		
	}
	
	
	public static void main(String[] args) {
		
		Season ss = Season.valueOf("봄");
		System.out.println("name : " + ss.name());
		System.out.println("ordinal : " + ss.ordinal());
		System.out.println("span : " + ss.getSpan());
		
		// 열거형명.values() ==> 열거형의 상수값들을 배열로 가져온다.
		for(Season time : Season.values()){
			System.out.println(time + " - " + time.getSpan());
		}
		
//		Season summer = Season.여름;
//		String a = summer.getSpan();
//		System.out.println(a);
//		Season spring = Season.봄;
//		
//		String span = spring.getSpan();
//		
//		System.out.println(span);
//		
	}
	
}
