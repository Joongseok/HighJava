package basic;
// yield()메서드 연습 예제
public class ThreadTest12 {
	public static void main(String[] args) {
		ThreadYield th1 = new ThreadYield("1번 쓰레드");
		ThreadYield th2 = new ThreadYield("2번 쓰레드");
		
		th1.start();
		th2.start();
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
		}
		System.out.println("******************************************");
		th1.work = false;
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
		}
		
		System.out.println("#############################################");
		th1.work = true;
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
		}
		th1.stop = true;
		th2.stop = true;
	}//main
}//class


//yield()메서드 연습용 쓰레드
class ThreadYield extends Thread{
	public boolean stop = false;
	public boolean work = true;
	
	public ThreadYield(String name) {
		super(name); // 쓰레드의 이름을 설정하는 조상쓰레드의 생성자 호출
	}
	
	@Override
	public void run() {
		while(!stop){ // stop이 true가 되면 반복문 종료
			if (work) {
				// getName()메서드는 현재 쓰레드의 name값을 반환한다.
				System.out.println(getName() + "작업중...");
			}else{
				System.out.println(getName() + "양보...");
				Thread.yield();
			}
		}
		System.out.println(getName() + " 종료 !!!");
	}//run
}//class