package basic;

/*
	원주율을 계산만 하는 쓰레드와 
	계산된 원주율을 출력하는 쓰레드가 있다.
	
	이 두 쓰레드를 이용하여 원주율을 계산한 후 출력하는 프로그램을 작성해 보자.
	
	원주율을 저장하는 객체가 필요하다.
	이 객체를 두 쓰레드가 공통으로 사용해서 처리한다.
*/
public class ThreadTest17 {

	public static void main(String[] args) {
		ShareData sd = new ShareData();	/// 공통으로 사용할 객체 생성
		
		// 쓰레드 객체들을 생성할 때 공통으로 사용할 객체의 참조값을 넣어준다.
		CalcPIThread cp = new CalcPIThread(sd);
		PrinPIThread pp = new PrinPIThread(sd);
		
		cp.start();
		pp.start();
		
	}
	
}

// 원주율을 계산하는 쓰레드
class CalcPIThread extends Thread{
	private ShareData sd;  // 공통으로 사용할 객체가 저장될 변수 선언
	
	public CalcPIThread(ShareData sd) {
		this.sd = sd;
	}

	@Override
	public void run() {
		/*
			원주율 = (1/1 - 1/3 + 1/5 - 1/7 + 1/9 ...) * 4
					1 - 3 + 5 - 7 + 9 - 11 ...	
					0 - 1 + 2 - 3 + 4 - 5
		*/
		double sum = 0.0;
		for (int i = 1; i <=10000000; i+=2) {
			if ((i/2) %2 == 0 ) {
				sum += (1.0/i);
			}else{
				sum -= (1.0/i);
			}
		}
		
		sd.result = sum*4;
		sd.isOk = true;
		
	}
}

// 계산된 원주율을 출력하는 쓰레드
class PrinPIThread extends Thread{
	private ShareData sd;

	public PrinPIThread(ShareData sd) {
		this.sd = sd;
	}
	
	@Override
	public void run() {
		while(!sd.isOk){
			continue;
		}
		
		System.out.println();
		System.out.println("결과 : " + sd.result);
		System.out.println(" PI : " + Math.PI);
		
	}
}


// 원주율을 관리하는 클래스(공유될 클래스)
class ShareData{
	public double result; // 계산된 원주율이 저장될 변수
	// volatile ==> 선언된 변수를 컴파일러의 최적화 대상에서 제외시킨다.
	//				즉 , 캐쉬를 사용하지 않고 메모리에 있는 변수를 직접 사용한다.
	public volatile boolean isOk = false;  // 계산이 완료되었는지를 나타내는 변수
}