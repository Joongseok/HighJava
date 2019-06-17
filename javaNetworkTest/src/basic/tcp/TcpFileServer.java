package basic.tcp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpFileServer {
	
	private ServerSocket server;
	private Socket socket;
	private InputStream is;
	private FileOutputStream fos;
	
	public void serverStart() {
		
		File file = new File("D:/D_Other/연습용/Tulips복사본.jpg");
		
		try {
			
			server = new ServerSocket(7777);
			System.out.println("서버가 준비 되었습니다.");
			
			socket = server.accept();	
			
			System.out.println("파일 다운로드 시작...");
			is = socket.getInputStream();
			fos = new FileOutputStream(file);
			
			byte[] tmp = new byte[1024];
			int length = 0;
			while( (length=is.read(tmp)) !=-1 ) { 	// 클라이언트가 보내온 자료 읽기
				fos.write(tmp, 0, length); // 읽어온 데이터를 파일에 저장하기
			}
			System.out.println("파일 다운로드 끝");
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (fos!=null)
				try {fos.close();} catch (IOException e2) {}
			if (is!=null)
				try {is.close();} catch (IOException e2) {}
			if (socket!=null)
				try {socket.close();} catch (IOException e2) {}
			if (server!=null)
				try {server.close();} catch (IOException e2) {}
				
			
		}
		
	}
	
	public static void main(String[] args) {
		
		new TcpFileServer().serverStart();
		
	}
	
	
	
}
