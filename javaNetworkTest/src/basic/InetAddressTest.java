package basic;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
	
	public static void main(String[] args) throws UnknownHostException {
		
		// InetAddress클래스 ==> IP주소를 다루기 위한 클래스
		// 192.168.0.111
		
		// www.naver.com의 IP정보 가져오기
		InetAddress naverIP = InetAddress.getByName("www.naver.com");
		
		System.out.println("HostName : " + naverIP.getHostName());
		System.out.println("HostAddress : " + naverIP.getHostAddress());
		System.out.println();
		
		// 자신 컴퓨터의 IP정보 가져오기
		InetAddress localIP = InetAddress.getLocalHost();
		System.out.println("HostName : " + localIP.getHostName());
		System.out.println("HostAddress : " + localIP.getHostAddress());
		System.out.println();
		
		// IP 주소가 여러개인 호스트의 정보 가져오기
//		InetAddress[] navers = InetAddress.getAllByName("www.naver.com");
//		InetAddress[] navers = InetAddress.getAllByName("www.daum.com");
//		InetAddress[] navers = InetAddress.getAllByName("www.nate.com");
		InetAddress[] navers = InetAddress.getAllByName("www.ddit.or.kr");
		for(InetAddress naver : navers) {
			System.out.println(naver.toString());
		}
		
	}
	
}
