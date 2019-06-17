package util;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;


import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class BuildedSqlMapClientStudent {
	private static SqlMapClient client;
	
	static{
		
		try {
			Charset charset = Charset.forName("UTF-8");
			Resources.setCharset(charset); 
			
			Reader rd = Resources.getResourceAsReader("sqlMapConfigStudent.xml");
			
			client = SqlMapClientBuilder.buildSqlMapClient(rd);
			
			rd.close();		
		} catch (IOException e) {
			throw new RuntimeException("SqlMapClient 생성 실패" + e);
		}
	}
	
	public static SqlMapClient getSqlMapClient(){
		return client;
	}
}
