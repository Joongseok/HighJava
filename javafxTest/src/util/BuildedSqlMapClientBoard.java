package util;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;


import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class BuildedSqlMapClientBoard {
	private static SqlMapClient client;
	
	static{
		
		try {
			Charset charset = Charset.forName("UTF-8");
			Resources.setCharset(charset); // 문자 인코딩 캐릭터셋 설정하기
			
			Reader rd = Resources.getResourceAsReader("sqlMapConfigBoard.xml");
			
			// 1-2. 위에서 읽어온 Reader객체를 이용하여 실제 작업을 진행할 객체 생성
			client = SqlMapClientBuilder.buildSqlMapClient(rd);
			
			rd.close();		// Reader객체 닫기
		} catch (IOException e) {
			throw new RuntimeException("SqlMapClient 생성 실패" + e);
		}
	}
	
	public static SqlMapClient getSqlMapClient(){
		return client;
	}
}
