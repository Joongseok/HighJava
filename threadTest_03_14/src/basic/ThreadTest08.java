package basic;

import javax.swing.JOptionPane;

public class ThreadTest08 {
	public static boolean inputCheck = false;
	
	public static void main(String[] args) {
		GameTimer gt = new GameTimer();
		
		// 난수를 이용하여 컴퓨터의 가위 바위 보를 정한다.
		String[] data = {"가위","바위","보"};
		int index = (int)(Math.random()*3); // 0~2 사이의 난수 만들기
		String com = data[index];
		
		// 사용자로부터 가위 바위 보 입력 받기
		String man = null;
		gt.start();		// 카운트 다운 시작
		do{
			man = JOptionPane.showInputDialog("가위 바위 보를 입력하세요.");
		}while(man==null || !man.equals("가위")&&!man.equals("바위")&&!man.equals("보"));
		
		inputCheck = true;	//입력이 완료 되었다는 표시를 한다.
		// 결과 판정
		String result = null;
		if (com.equals(man)) {
			result = "비겼습니다.";
		}else if(com.equals("가위")&& man.equals("보")||
				com.equals("바위")&& man.equals("가위")||
				com.equals("보")&&man.equals("바위")){
			result = "당신이 졌습니다.";
		}else{
			result = "당신이 이겼습니다.";
		}
		
		//결과 출력
		System.out.println("  === 결  과 ===");
		System.out.println("컴퓨터 : " + com);
		System.out.println("사용자 : " + man);
		System.out.println("결  과 : " + result);
		}
	}

// 카운트 다운을 처리하는 쓰레드
class GameTimer extends Thread{
	
	@Override
	public void run() {
		for (int i = 5; i >= 1; i--) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			if (ThreadTest08.inputCheck==true) {
				return;
			}
		}
		
		System.out.println("시간이 초과되어 당신이 졌습니다.");
		System.exit(0);
	}
}