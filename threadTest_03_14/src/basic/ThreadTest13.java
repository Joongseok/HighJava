package basic;
/*
	Thread의 stop()메서드를 호출하면 쓰레드가 바로 멈춘다.
	이때 사용하던 자원을 정리하지 못하고 프로그램이 종료되어서
	나중에 실행되는 프로그램에 영향을 줄 수 있다.
	그래서 이 stop()메서드는 비추천
*/
public class ThreadTest13 {
	
	public static void main(String[] args) {
		/*
		ThreadStopEx01 th = new ThreadStopEx01();
		
		th.start();
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
		}//catch()
		th.setStop(true);
		*/
		
		// interrupt()메서드를 이용한 쓰레드 멈추기
		ThreadStopEx02 th2 = new ThreadStopEx02();
		th2.start();
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
		}
		th2.interrupt();	//interrupt()메서드를 호출해서 쓰레드를 멈추게 한다.
	}//main()
	
}//class

class ThreadStopEx01 extends Thread{
	private boolean stop;


	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
	@Override
	public void run() {
		while(!stop){
			System.out.println("쓰레드 실행 중...");
		}//end while()
		System.out.println("자원 정리하기...");
		System.out.println("실행 종료...");
	}//end run()
}//end class

// interrupt()메서드를 이용하여 쓰레드를 멈추게 하는 방법
class ThreadStopEx02 extends Thread{
	@Override
	public void run() {
		/*
		// 방법1
		try {
			while(true){
				System.out.println("실행 중...");
				
				// interrupt()메서드가 호출되면 InterruptedException이 발생한다.
				Thread.sleep(1);  
			}
		} catch (InterruptedException e) {
		}
		*/
		
		// 방법2
		while(true){
			/*
			System.out.println("쓰레드 실행 중.");
			// interrupt()메서드가 호출되었는지 검사하는 방법1
			// isInterrupted()메서드 ==> 인스턴스 객체용 메서드로
			//							interrupt()메서드가 호출되면 true를 반환하고
			//							그렇지 않으면 false를 반환한다.
			if (this.isInterrupted()) { 
				break;
			}
			*/
			// interrupt()메서드가 호출되었는지 검사하는 방법2
			// interrupted()메서드는 Thread의 정적메서드이고
			//		interrupt()메서드가 호출되면 true, 그렇지 않으면 false가 반환된다.
			if (Thread.interrupted()) {
				break;
			}
		}
		System.out.println("자원 정리...");
		System.out.println("실행 종료...");
	}//end run()
}//end class