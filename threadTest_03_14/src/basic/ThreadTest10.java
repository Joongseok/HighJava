package basic;

// 데몬 쓰레드 연습 ==> 3초에 한번씩 저장하는 프로그램
public class ThreadTest10 {
	
	public static void main(String[] args) {
		AutoSaveThread autosave = new AutoSaveThread();
		
		// 데몬 쓰레드로 설정 ==> start()메서드 호출전에 설정한다.
		autosave.setDaemon(true);
		autosave.start();
		
		try {
			for (int i = 1; i <=20; i++) {
				System.out.println(i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
		}
		System.out.println("메인 쓰레드 종료..");
	}
	
}


//
class AutoSaveThread extends Thread{
	public void save(){
		System.out.println("작업 내용을 저장합니다...");
	}
	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
			}
			
			save();
		}
	}
}