package basic.tcp;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

// 이 클래스는 소켓을 통해서 메시지를 보내는 역할을 담당한다.
public class Sender extends Thread{
	
	Socket socket;
	DataOutputStream dos;
	String name;
	
	public Sender(Socket socket) {
		this.socket = socket;
		name = "[" + socket.getLocalSocketAddress() + ":" + socket.getPort() + "]";
		try {
			dos = new DataOutputStream(socket.getOutputStream());
		} catch (Exception e) {
		}
	}

	@Override
	public void run() {
		// 입력한 문자열을 상대방에게 보낸다.
		Scanner sc = new Scanner(System.in);
		while(dos!=null) {
			try {
				dos.writeUTF(name + " : " + sc.nextLine());
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	
	
}
