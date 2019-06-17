package basic;

public class ThreadTest09 {
	public static void main(String[] args) {
		//쓰레드의 우선순위 연습
		Thread th1 = new ThreadTest1();
		Thread th2 = new ThreadTest2();
		
		System.out.println("th1의 현재 우선순위 : " + th1.getPriority());
		System.out.println("th2의 현재 우선순위 : " + th2.getPriority());
		
		// 우선순위 설정은 start()메서드 호출 전에 설정해야 한다. ==> 
		th1.setPriority(6);
		th2.setPriority(8);
		
		System.out.println("th1의 변경된 우선순위 : " + th1.getPriority());
		System.out.println("th2의 변경된 우선순위 : " + th2.getPriority());
		
		th1.start();
		th2.start();
	}
}


// 대문자를 출력하는 쓰레드

class ThreadTest1 extends Thread{
	@Override
	public void run() {
		for (char ch ='A'; ch <= 'Z'; ch++) {
			System.out.println(ch);
			for (long i = 1; i <= 1_000_000_000L; i++){} // 시간때우기
		}
	}
}

// 소문자를 출력하는 쓰레드
class ThreadTest2 extends Thread{
	@Override
	public void run() {
		for (char ch ='a'; ch <= 'z'; ch++) {
			System.out.println(ch);
			for (long i = 1; i <= 1_000_000_000L; i++); // 시간때우기
		}
	}
}