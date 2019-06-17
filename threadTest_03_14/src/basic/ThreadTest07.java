package basic;


import javax.swing.JOptionPane;

/*
	컴퓨터와 가위 바위 보를 진행하는 프로그램을 작성하시오.
	
	컴퓨터와 가위 바위 보 난수를 이용하여 구하고,
	사용자는 showInputDialog()메서드를 이용하여 입력 받는다.
	
	입력 시간은 5초로 제한하고 카운트 다운을 진행한다.
	5초안에 입력이 없으면 게임을 진것으로 처리하고 프로그램을 종료한다.
	
	5초안에 입력이 완료되면 승패를 구해서 그 결과를 출력한다.
	
	결과예시)
		=== 결  과 ===
		 컴퓨터 : 바위
		 당  신 : 보
		 결  과 : 당신이 이겼습니다.

*/
public class ThreadTest07 {
	public static boolean inputCheck = false;
	public static void main(String[] args) {
		new CountDown1().start();
		new Input().start();
	}
	
}
//컴퓨터 클래스
class Com{
	
	//컴퓨터가 랜덤하게 값을 받는 메서드
	public String comtuper(){
		int num = (int)(Math.random()*3+1);
		String game = null;
		switch (num) {
		case 1:
			game = "가위";break;
		case 2:
			
			game = "바위";break;
		case 3:
			
			game = "보";break;

		default:
			break;
		}
		return game;
	}
	
}

class Input extends Thread{
	@Override
	public void run() {
		String str1 = new Com().comtuper();
		String str = JOptionPane.showInputDialog("가위 바위 보 를 입력하세요");
		ThreadTest07.inputCheck = true;
		if (str==null) {
			System.out.println("입력하지 않았습니다. 종료합니다.");
			return;
		}
		System.out.println("=== 결  과 ===");
		System.out.println("컴퓨터  :" +str1);
		System.out.println("당  신 : " + str);
		if((str.equals("가위")&&(str1.equals("바위")))||(str.equals("보")&&(str1.equals("가위")))||(str.equals("바위")&&(str1.equals("보")))){
			System.out.println("컴퓨터의 승리입니다.");
		}else if((str.equals("바위")&&(str1.equals("가위")))||(str.equals("가위")&&(str1.equals("보")))||(str.equals("보")&&(str1.equals("바위")))){
			System.out.println("당신의 승리입니다.");
		}else{
			System.out.println("비겼습니다.");
		}
			
		
	}
}
//카운트 처리하는 메서드
class CountDown1 extends Thread{
	@Override
	public void run() {
		for (int i = 5; i>=1; i--) {
			if (ThreadTest07.inputCheck == true) {
				return;
			}
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
		
		System.out.println("5초가 지났습니다. 당신의 패배입니다.");
		System.exit(0);
	}
}