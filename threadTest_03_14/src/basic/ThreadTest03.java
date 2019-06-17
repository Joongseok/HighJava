package basic;

public class ThreadTest03 {
	
	public static void main(String[] args) {
		// 쓰레드의 수행 시간을 체크해 보자.
//		MyRunner r = new MyRunner();
//		Thread th = new Thread(r);
//		th.start();
		Thread th  = new Thread(new MyRunner());
		// 1970년 1월1일 0시0분0초(표준시간)로 부터 경과한 시간을 
		// 밀리세컨드(1/1000초) 단위로 나타낸다.
		long startTime = System.currentTimeMillis();
		th.start();
		try {
			th.join(); // 현재 쓰레드에서 th쓰레드가 종료될 때까지 기다린다.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("경과시간 : " + (endTime-startTime));
		
	}
	
}

class MyRunner implements Runnable{

	@Override
	public void run() {
		long sum = 0L;
		for(long i = 1L; i <= 1_000_000_000L; i ++){
			sum += i;
		}
		System.out.println("합계 : " + sum);
	}
}
