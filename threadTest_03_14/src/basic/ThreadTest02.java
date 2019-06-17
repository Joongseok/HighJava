package basic;

public class ThreadTest02 {
	public static void main(String[] args) {
		// 멀티 쓰레드 프로그램
		
		// Thread를 사용하는 방법
		
		// 방법1 ==> Thread클래스를 상속 받기
		//		==>	Thread클래스를 상속한 class의 인스턴스를 생성한 후 
		//			이 인스턴스의 start()메서드를 호출한다.
		long start = System.currentTimeMillis();
		MyThread1 th1 = new MyThread1();
		th1.start(); // 쓰레드 환경을 만들고, 해당 쓰레드의 run메서드를 호출해 준다.

		// 방법2 ==> Runnable인터페이스를 구현하기
		//		==> Runnable인터페이스를 구현한 class의 인스턴스를 생성한 후
		//			이 인스턴스를 Thread객체의 인스턴스를 생성할 때
		//			생성자의 매개변수로 넘겨준다.
		//			그리고, 이 때 생성된 Thread의 인스턴스의 start()메서드를 호출한다.
		MyThread2 r = new MyThread2();
		Thread th2 = new Thread(r);
		th2.start();
		
		// 방법3 ==> 익명구현체를 이용하기
		//		==>	Runnable인터페이스를 구현한 익명구현체를 Thread인스턴스를
		//			생성할 때 생성자의 매개변수로 넘겨준다.
		Thread th3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 1; i <= 200; i++) {
					System.out.print("@");
					try {
						Thread.sleep(111);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		
		th3.start();
		
		System.out.println("main메서드(main쓰레드) 작업 끝...");
		
		long end =System.currentTimeMillis();
		System.out.println("걸린시간 : " + (start - end));
		
	}
}


// Thread클래스를 상속한 class
class MyThread1 extends Thread{
	private int a;
	public void test(){
		
	}
	@Override
	public void run() {
		// 이 run()메서드 영역에 쓰레드에서 처리할 내용을 기술한다.
		for (int i = 1; i <= 200; i++) {
			System.out.print("*");
			try {
				// Thread.sleep(시간)메서드는 주어진 '시간'동안 작업을 잠시 멈춘다.
				// '시간'은 밀리세컨드 단위를 사용한다.
				// 즉, 1000은 1초를 의미한다.
				Thread.sleep(101);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

// Runnable인터페이스를 구현한 class
class MyThread2 implements Runnable{
	@Override
	public void run() {
		for (int i = 1; i <=200; i++) {
			System.out.print("$");
			try {
				Thread.sleep(111);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}