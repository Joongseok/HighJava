package basic.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient3 {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		
		Socket socket = new Socket("localhost", 7777);
		
		
		FileInputStream fin = new FileInputStream("D:/D_Other/Tulips.jpg");
		BufferedInputStream bin = new BufferedInputStream(fin);

		OutputStream os = socket.getOutputStream();
		BufferedOutputStream bos = new BufferedOutputStream(os);
		
		int c;
		while((c = bin.read()) != -1) {
			bos.write(c);
			bos.flush();
		}
		
		System.out.println("전송완료");
		
		bin.close();
		bos.close();
		socket.close();
	}
}
