package basic;
/*
	3개(명)의 쓰레드가 각각 알파벳을 A~Z까지 출력하는데 
	출력을 끝낸 순서대로 결과를 나타내는 프로그램을 작성해 보자.
*/
public class ThreadTest14 {
	public static String strRank ="";
	public static void main(String[] args) {
	DisplayCharactor[] dcArray = new DisplayCharactor[]{
			new DisplayCharactor("홍길동"),
			new DisplayCharactor("이순신"),
			new DisplayCharactor("강감찬")
	};
	
	for (int i = 0; i < dcArray.length; i++) {
		dcArray[i].start();
	}
	
	for (int i = 0; i < dcArray.length; i++) {
		try {
			dcArray[i].join();
		} catch (InterruptedException e) {
		}
	}
	
	System.out.println();
	System.out.println("경기 결과");
	System.out.println("순위 : " + strRank);
	}
}


//알파벳을 출력하는 쓰레드
class DisplayCharactor extends Thread{
	private String name;
	
	// 생성자
	public DisplayCharactor(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		for (char c = 'A'; c <= 'Z'; c++) {
			System.out.println(name + "의 출력 문자 : " + c);
			try {
				// 200 ~ 500사이의 난수를 sleep의 값으로 설정한다.
				int a = (int)(Math.random()*301 + 200);
				Thread.sleep(a);
			} catch (InterruptedException e) {
			}
		}
		
		System.out.println(name + " 출력 끝...");
		ThreadTest14.strRank += name + " ";
	}
}