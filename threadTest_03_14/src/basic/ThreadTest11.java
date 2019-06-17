package basic;

// 쓰레드의 상태를 출력하는 예제.

public class ThreadTest11 {
	
	public static void main(String[] args) {
		TargetThread target = new TargetThread();
		
		StatePrintThread spt = new StatePrintThread(target);
		spt.start();
	}
}

// TargetThread의 상태를 출력하는 쓰레드

class StatePrintThread extends Thread{
	private Thread targetThread; // TargetThread가 저장될 변수
	
	public StatePrintThread(Thread targetThread) {
		this.targetThread = targetThread;
	}
	@Override
	public void run() {
		while(true){
			// 현재 쓰레드의 상태값 구하기
			Thread.State state = targetThread.getState();
			System.out.println("티겟 쓰레드의 상태값 : " + state);
			
			if (state == Thread.State.NEW) { // 쓰레드가 NEW상태인지 ㄱㅁ사
				targetThread.start();
			}
			if (state == Thread.State.TERMINATED) { // 쓰레드가 종료 상태인지 검사
				break;
			}
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
		}
	}
}

// 처리 대상이 되는 쓰레드 (target쓰레드)
class TargetThread extends Thread{
	@Override
	public void run() {
		for (long i = 1L; i <= 2_000_000_000L; i++) {//시간 지연용
		}
			try {
				Thread.sleep(1500);
			} catch (Exception e) {
			}
		for (long i = 1L; i <= 2_000_000_000L; i++); //시간 지연용
	}
}