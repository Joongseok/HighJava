package argumentTest;
/*
	가변형 인수 ==> 메서드의 매개변수의 개수가 실행될 때 마다 다를수 있을 때 사용한다.
	
*/
public class ArgTest {
	// 배열을 이용한 가변형 인수 구현 메서드
	public int test(int[] a){
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		return sum;
	}
	
	//가변형 인수를 이용한 메서드
	public int sumArg(int...a){ // 가변형 인수 형식) 자료형명... 변수명 
		// 이 가변형 변수는 메서드 안에서는 배열로 처리된다.
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		return sum;
	}
	
	// 일반 변수와 가변형 변수를 같이 사용할 경우에는 
	// 가변형 변수를 끝쪽에 배치해야 한다.
	/*
	public void testArg(int...num, int num2){ // 오류
		
	}
	*/
	public void testArg(int num2,int...num){
		
	}
	
	public static void main(String[] args) {
		ArgTest arg = new ArgTest();
		int[] data = {10, 20, 30};
		int result = arg.test(data);
		System.out.println("result = " + result);
		
		result = arg.test(new int []{100, 200, 300, 400, 500});
		System.out.println("result = " + result);
		
		int result2 = arg.sumArg(1,2,3,4);
		System.out.println("result2 = " + result2);
		
		result2 = arg.sumArg(10,20,30,40,50,60,70,80,90,100);
		System.out.println("result2 = " + result2);
	}
	
}
