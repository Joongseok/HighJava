package basic;

/*
	wait(), notify()를 이용한 두 쓰레드가 서로 번갈아 가며
	한번씩 실행하는 예제 
	(wait(), notify()는 동기화 영역에서만 사용할 수 있다.
*/
public class ThreadTest21 {
	
	public static void main(String[] args) {
		WorkObject workObj = new WorkObject();
		
		
		ThreadA th1 = new ThreadA(workObj);
		ThreadB th2 = new ThreadB(workObj);
		
		th1.start();
		th2.start();
		
	}
	
	
}

// 공통으로 사용할 객체
class WorkObject{
	public synchronized void test1(){
		System.out.println("test1()메서드에서 작업 시작...");
		
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
		}
	}//test1()
	
	public synchronized void test2(){
		System.out.println("test2()메서드에서 작업 시작...");
		
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
		}
	}//test2()
}

// WorkObject의 test1() 메서드만 호출하는 쓰레드
class ThreadA extends Thread{
	private WorkObject workObj;
	
	//생성자
	public ThreadA(WorkObject workObj) {
		this.workObj = workObj;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			workObj.test1();
		}
	}//run()
	
}

// WorkObject의 test2() 메서드만 호출하는 쓰레드
class ThreadB extends Thread{
	private WorkObject workObj;
	
	//생성자
	public ThreadB(WorkObject workObj) {
		this.workObj = workObj;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			workObj.test2();
		}
	}//run()
	
}





