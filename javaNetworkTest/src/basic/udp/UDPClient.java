package basic.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 수신용, 송신용 패킷 변수 선언
		DatagramPacket inpacket, outpacket;
		
		byte[] bMsg = new byte[512];
		
		try {
			// UDP용 소켓 객체 생성
			DatagramSocket socket = new DatagramSocket();
			
			// 받을 곳의 주소 생성
			InetAddress address = InetAddress.getByName("127.0.0.1");
			
			while(true) {
				// 전송할 메시지 입력 받기
				System.out.print("보낼 메시지 입력 : ");
				String msg = sc.nextLine();
				
				if ("/end".equals(msg)) {
					break;
				}
				
				// 송신용 패킷 객체 생성
				outpacket = new DatagramPacket(msg.getBytes(), msg.getBytes().length,
							address, 8888);
				// 서버로 전송
				socket.send(outpacket);
				
				// 서버에서 수신한 데이터 출력하기
				// 수신용 패킷 생성
				inpacket = new DatagramPacket(bMsg, bMsg.length);
				// 수신
				socket.receive(inpacket);
				
				System.out.println("서버 응답 : " + new String(inpacket.getData(),0,inpacket.getLength()));
				System.out.println();
			}
			
			
			System.out.println("통신 끝...");
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}
