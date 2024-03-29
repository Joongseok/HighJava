package basic;
/*
	1~20억까지의 합계를 구하시는데 걸린 시간 체크하기
	
	전체 합계를 구하는 작업을 단독으로 했을때와 
	여러 쓰레드가 분할해서 작업할때의 시간을 확인해 보자. 
*/
public class ThreadTest04 {
		public static void main(String[] args) {
			SumThread sm = new SumThread( 1L , 2_000_000_000L);
			
			
			SumThread[] sums = new SumThread[]{
					new SumThread(			  1L, 500_000_000L),
					new SumThread(  500_000_001L, 1_000_000_000L),
					new SumThread(1_000_000_001L, 1_500_000_000L),
					new SumThread(1_500_000_001L, 2_000_000_000L)
			};
			
			// 단독으로 처리했을 경우
			long startTime = System.currentTimeMillis();
			sm.start();
			try {
				sm.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			long endTime = System.currentTimeMillis();
			
			System.out.println("단독 처리의 시간 : " + (endTime-startTime));
			
			// 여러 쓰레드가 분할 해서 처리했을 경우
			startTime = System.currentTimeMillis();
			for(SumThread sum : sums){
				sum.start();
			}
			for (int i = 0; i < sums.length; i++) {
				try {
					sums[i].join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			endTime = System.currentTimeMillis();
			
			System.out.println("분할 처리의 시간 : " + (endTime-startTime));
		}
}

class SumThread extends Thread{
	private long min, max;
	
	public SumThread(long min, long max) {
		this.min = min;
		this.max = max;
	}
	
	@Override
	public void run() {
		long sum = 0;
		for (long i = min; i <= max; i++) {
			sum += i;
		}
		System.out.println(min + "부터" + max + "까지의 합계 : " + sum);
	}
}
