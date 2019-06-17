package board.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mvc.dao.MemberDaoImpl;
import mvc.vo.MemberVO;

import com.ibatis.sqlmap.client.SqlMapClient;

import util.BuildedSqlMapClient;
import util.BuildedSqlMapClientBoard;
import board.vo.JdbcBoardVO;

public class JdbcBoardDaoImpl implements IJdbcBoardDao {
	
	private static JdbcBoardDaoImpl dao; // 자신의 클래스 객체인dao를 생성한다.
	private SqlMapClient smc; // SqlMapClient인터페이스의 객체인 smc를 생성
	
	private JdbcBoardDaoImpl(){	//Impl클래스의 객체를 생성할때 smc도 xml에 연결시킨다.?
		smc = BuildedSqlMapClientBoard.getSqlMapClient(); // util패키지에 있는 BuildedSqlMapClient클래스에 xml을 연결하는 객체 client를 대입한다.
	}
	
	public static JdbcBoardDaoImpl getInstance(){
		
		if(dao == null) dao = new JdbcBoardDaoImpl(); //자신의 클래스객체를 싱글톤 패턴을 이용해서 한번만 생성할수 있게 한다.
		
		return dao;
	}
	
	@Override
	public int insertBoard(JdbcBoardVO jBoardVo) { // 게시글을 작성하는 메서드 매개변수로 Board의 속성들을 받아서 반환타입 int를 이용해 성공 실패 여부를 반환해준다.
		
		int cnt = 0;
		
		try {
			//SqlMapClient에 insert메서드는 반환타입이 Object이므로 Object변수를 만들어서 대입시켜줘야한다.
			//insert메서드에 jdbcMyBoard라는 namespace를 가진 xml. insertBoard라는 insert태그의 아이디 값에 매개변수로 jBoardVo라는 BoardVo객체를 넘겨준다.
			Object obj = smc.insert("jdbcMyBoard.insertBoard", jBoardVo);
			if (obj==null) {
				cnt = 1;
			} else {
				cnt = 0;
			}
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} 
		
		return cnt;
	}

	@Override
	public int deleteBoard(int boardNo) { // primary key인 boardNo을 매개변수로 받아서 boardNo 즉 게시물 번호에 해당하는 정보를 delete한다.
		int cnt = 0;
		try {
			//namespace가 jdbcMyBoard인 xml에 delete태그의 아이디값인 delteBoard에 parameterClass 즉 매개변수인 boardNo을 넘겨준다.
			// SqlMapClient의 delete메서드의 반환타입은 int이기 떄문에 int타입인 cnt에 대입시켜준다. delete가 성공하면 1 실패하면 0
			cnt = smc.delete("jdbcMyBoard.deleteBoard", boardNo);
			
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} 
		return cnt;
	}

	@Override
	public int updateBoard(JdbcBoardVO jBoardVo) {// 매개변수로 controller에서 셋팅한 BoardVO의 정보를 받아온다.
		int cnt = 0;
		try {
			//SqlMapClient의 update메서드는 반환타입이 int이다.
			// 	namespace가 jdbcMyBoard인 xml에 update태그의 id값이 updateBoard인 sql문에 parameterClass로 jBoardVo를 넘겨준다. update가 성공하면 1 실패하면 0
			cnt = smc.update("jdbcMyBoard.updateBoard", jBoardVo);
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<JdbcBoardVO> getAllBoardList() { // 반환타입이 BoardVo의 정보를 가지고있는 List이다..
		List<JdbcBoardVO> boardList =null;//boardVO들의 정보를 담을 변수를 초기화
		try {
			boardList = smc.queryForList("jdbcMyBoard.getAllBoard");//queryForList메서드를 통해 boardList에 대입해준다.
							//namespace가 jdbcMyBoard인 xml에 select태그에 id값이 getAllBoard인 sql문의 결과를 가져온다.
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return boardList;
	}

	@Override
	public List<JdbcBoardVO> getSearchBoardList(String jBoardTitle) { // 게시글의 제목을 매개변수로 제목에 대한 정보를 List에 담고 담긴 List를 반환해준다.
		List<JdbcBoardVO> boardList =null; // 제목으로 검색한 정보들을 담을 List변수
		try {
			
			// namespace가 jdbcMyboard인 xml에 select태그의 아이디값이 getSearchBoradList인 sql문에 parameterClass로 jBoardTitle : 제목을 넘겨준다.
			boardList = smc.queryForList("jdbcMyBoard.getSearchBoardList", jBoardTitle); 
		} catch (SQLException e) {
			boardList = null;
			e.printStackTrace();
		}
		
		return boardList;
	}

	@Override
	public JdbcBoardVO getBoard(int boardNo) { // 게시글의 번호를 매개변수로 받아서 그 번호에 대한 정보를 검색하고 검색한 정보를 담은 객체를 반환해준다.
		JdbcBoardVO jBoardVo =null; //게시글 번호에 대한 정보가 담길 boardVo객체
		try {
			// 객체 하나를 반환하는 것이기때문에 queryForObject메서드를 사용하고 이 메서드의 반환타입은 Object이기때문에 다운캐스팅을 한다.
			// namespace가 jdbcMyBoard인 xml파일의 select태그의 아이디값이 getBoard인 sql문에 int 타입 boardNo을 넘겨준다.
			jBoardVo =  (JdbcBoardVO) smc.queryForObject("jdbcMyBoard.getBoard", boardNo);
			
		} catch (SQLException e) {
			jBoardVo = null;
			e.printStackTrace();
		}
		return jBoardVo;
	}

	@Override
	public int setCountIncrement(int boardNo) { // 해당 게시글번호에 대한 조회수를 증가시키는 메서드
		int cnt = 0;
		try {	//조회수를 증가시키는것은 데이터베이스에서 정보가 무언가 변화가 있는 것이기 때문에 update메서드를 사용해ㅑㅇ한다.
			// namespace가 jdbcMyBoard인 xml파일의 update태그에 아이디값이 setCountIncrement인 sql문에 boardNo을 parameter클래스로 넘겨준다.
			cnt = smc.update("jdbcMyBoard.setCountIncrement", boardNo);
			
					
		} catch (SQLException e) {
			cnt = 0;
			e.printStackTrace();
		} 
		return cnt;
	}
	
	@Override
	public List<JdbcBoardVO> getSearchBoard(String boxName, String tf) { // fieldName은 항목이다 ex) 검색할 항목이 이름인지? ID인지 전화번호인지 ... value ex) a가 들어간 회원의 아이디
		Map<String, String> searchMap = new HashMap<String, String>();	//  key값과 value값을 가지고 있는 Map의 객체를 만든다.
		List<JdbcBoardVO> boardList = null; // 리스트 하나만 넘겨줘야하기떄문에 리스트의 객체도 만든다.
		
		searchMap.put("searchFieldName", boxName);	// searchfieldName이라는 key에 항목의 값인 fieldName이라는 매개변수를 넘겨준다.
		searchMap.put("searchValue", tf);	//searchValue라는 value값에 매개변수 value를 넘겨준다.
		
		try {
			boardList = smc.queryForList("jdbcMyBoard.getSearchBoard", searchMap);// List객체인 memList에 getSearchMember라는 아이디값을 가진 select태그에 seachMap이라는 map의 객체를 매개변수로 넘겨준다.,
		} catch (SQLException e) {
			boardList = null;
			e.printStackTrace();
		}
		
		
		return boardList;
	}

}
