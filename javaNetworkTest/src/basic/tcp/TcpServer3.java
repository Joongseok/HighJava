package basic.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpServer3 {
	
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		ServerSocket server = new ServerSocket(7777);
		System.out.println("서버가 준비되어 접속을 기다립니다...");
		
		Socket socket = server.accept();
		

		 InputStream is = socket.getInputStream();
		 BufferedInputStream bin = new BufferedInputStream(is);
		 
		 FileOutputStream fout =  new FileOutputStream("D:/D_Other/연습용/튤립.jpg");
		 BufferedOutputStream bout = new BufferedOutputStream(fout);
		
		
		System.out.println("복사 시작");
		int c;
		
		while( (c= bin.read())!= -1 ) {
			bout.write(c);
		}
		
		bout.flush();
		
		System.out.println("복사끝");
		
		bin.close();
		bout.close();
		socket.close();
	}
}
