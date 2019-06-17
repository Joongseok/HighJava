package mvc.dao;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.BuildedSqlMapClient;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

import mvc.vo.MemberVO;

public class MemberDaoImpl implements IMemberDao {
	private static MemberDaoImpl dao;
	private SqlMapClient smc;
	
	//생성자
	private MemberDaoImpl() {
//		try{
//		Charset charset = Charset.forName("UTF-8");
//		Resources.setCharset(charset); // 문자 인코딩 캐릭터셋 설정하기
//		
//		Reader rd = Resources.getResourceAsReader("sqlMapConfig.xml");
//		
//		// 1-2. 위에서 읽어온 Reader객체를 이용하여 실제 작업을 진행할 객체 생성
//		smc = SqlMapClientBuilder.buildSqlMapClient(rd);
//		
//		rd.close();		// Reader객체 닫기
//		}catch(IOException e){
//			e.printStackTrace();
//		}
		// SqlMapClient의 객체인 smc를 BuildedSqlMapClient클래스의 메서드인.getSqlMapClient()를 통해 대입시킨다. // SqlMapConfig.xml의 정보가 담겨있음
		smc = BuildedSqlMapClient.getSqlMapClient();
	}
	
	// MemerDaoImpl를 싱글톤 패턴을 이용해서 객체를 한번만 생성할수 있도록함
	public static MemberDaoImpl getInstance(){
		
		// dao가 null이면 생성되지 않았으므로 생성해준다.
		if(dao == null) dao = new MemberDaoImpl();
		
		return dao;
	}
	
	// MemberVO의 내용을 DB에 insert하는 메서드
	@Override
	public int insertMember(MemberVO memvo) {// 매개변수로 하나의 멤버의 정보를 받아와 데이터베이스에 담아준다.
		
		int cnt = 0; // 정보가 담기는지 확인할 변수 성공하면 : 1 실패하면 : 0
		try {
			//insert메서드는 Object타입이기 때문에 obj에 scm를 담아준다.
			// mvcMymember.xml에 insertMember라는 아이디를 가진 태그에 매개변수로 객체 memvo를 넘겨준다
			Object obj = smc.insert("mvcMymember.insertMember", memvo);
			if(obj==null){
				// insert가 성공하면 obj는 null이고 실패하면 exception을 반환한다?
				cnt = 1;
			}else{
				cnt = 0;
			}
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;// cnt를 service에 넘겨준다.
	}

	// 회원 정보를 삭제하는 메서드
	@Override
	public int deleteMember(String memId) { //매개변수로 primary key인 memId를 받는다.
				
		int cnt = 0;
		try {
			//	SqlMapClient의 객체인 smc에 delete메서드를 사용해서 mvcMymember.xml에 deleteMember라는 아이디를 가진 delete태그에 memId를 넣어준다. 성공하면 :1 실패하면 : 0
			 cnt = smc.delete("mvcMymember.deleteMember", memId);
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

	//회원 정보를 수정하는 메서드 
	@Override
	public int updateMember(MemberVO memvo) { //하나의 멤버정보를 가지고 있는 객체를 매개변수로 받아서 업데이트 를 수행한다.
		int cnt = 0;
		try {
//			memvo.setMem_id(memvo.getMem_id());
//			memvo.setMem_name(memvo.getMem_name());
//			memvo.setMem_tel(memvo.getMem_tel());
//			memvo.setMem_addr(memvo.getMem_addr());
			cnt = smc.update("mvcMymember.updateMember", memvo); // 하나의 정보가 담긴 memvo를 mvcMymember.xml의 updateMember라는 아이디값을 가진 update태그에 매개변수를 넘겨준다 
			if (cnt > 0) {// 성공하면 1 실패하면 0
				System.out.println("update 작업 성공");
			} else {
				System.out.println("update 작업 실패");
			}
			
			
		} catch (Exception e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt; // 성공여부를 service에 넘겨주고 service는 controller에 반환함
	}

	@Override
	public List<MemberVO> getAllMember() { // 반환값이 MemberVO의 정보를 가지고 있는 List
		List<MemberVO> memList =null; // memList를 초기화함
		try {
			// SqlMapClient의 객체인 smc에 smc.queryForList를 통해 memList에 리스트의 정보를 넘겨준다. mvcMember.xml의 getAlMember라는 아이디 값을 가진 select태그의 값을 받아옴
			memList = smc.queryForList("mvcMymember.getAllMember");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memList; //queryForList메서드를 통해 받아온 memList의 정보를 service에 넘겨준다.
	}

/*	
   @Override
	public boolean getMember(String memId) {
		boolean check = false;
		try {
			MemberVO memVo4 = (MemberVO) smc.queryForObject("mvcMymember.getMember", memId);
			if(memVo4==null){
				check =false;
			}else{
				check =true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}

		return check;
	}
	*/
	@Override
	public boolean getMember(String memId) { //회원아이디가 기존에 있어서 중복되지 않는지 체크하기 위해 primary key인 Memid를 매개변수로 받아서 true false를 반환해준다.
		boolean check = false; // 회원아이디가 있는지 없는지 확인하기 위한 boolean타입의 변수
		try {
			int cnt= (int) smc.queryForObject("mvcMymember.getMemberCount", memId); // 매개변수로 받은 memId의 정보가 있는지 없는지 확인하는 것이기때문에 List가 아닌 Object메서드를 이용한다.
			if (cnt > 0) {
				check = true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return check;
	}

	@Override
	public List<MemberVO> getSearchMember(String fieldName, String value) { // fieldName은 항목이다 ex) 검색할 항목이 이름인지? ID인지 전화번호인지 ... value ex) a가 들어간 회원의 아이디
		Map<String, String> searchMap = new HashMap<String, String>();	//  key값과 value값을 가지고 있는 Map의 객체를 만든다.
		List<MemberVO> memList = null; // 리스트 하나만 넘겨줘야하기떄문에 리스트의 객체도 만든다.
		
		searchMap.put("searchFieldName", fieldName);	// searchfieldName이라는 key에 항목의 값인 fieldName이라는 매개변수를 넘겨준다.
		searchMap.put("searchValue", value);	//searchValue라는 value값에 매개변수 value를 넘겨준다.
		
		try {
			memList = smc.queryForList("mvcMymember.getSearchMember", searchMap);// List객체인 memList에 getSearchMember라는 아이디값을 가진 select태그에 seachMap이라는 map의 객체를 매개변수로 넘겨준다.,
		} catch (SQLException e) {
			memList = null;
			e.printStackTrace();
		}
		
		
		return memList;
	}
}