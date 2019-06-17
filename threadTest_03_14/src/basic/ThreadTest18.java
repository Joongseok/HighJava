package basic;

public class ThreadTest18 {
	
	public static void main(String[] args) {
		ShareObject sObj = new ShareObject(); // 공통으로 사용할 객체 생성
		
		WorkerThread th1 = new WorkerThread("쓰레드1", sObj);
		WorkerThread th2 = new WorkerThread("쓰레드2", sObj);
		
		th1.start();
		th2.start();
	}
	
}

// 작업을 진행하는 쓰레드
class WorkerThread extends Thread{
	private ShareObject sObj;


	public WorkerThread(String name, ShareObject sObj) {
		super(name);
		this.sObj = sObj;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			sObj.add();
		}
	}
	
}

// 공통으로 사용할 클래스
class ShareObject{
	private int sum = 0;
	
	// 동기화 하기
	public void add(){
//	public synchronized void add(){ // 방법1 ==> 메서드에 동기화 설정
		synchronized (this) { // 방법2 ==> 동기화 블럭으로 동기화 설정
			int n = sum;
			
			n += 10; // 10 증가 
			
			sum = n;
			
			System.out.println(Thread.currentThread().getName() + "합계 : " + sum);
		}
	}
}