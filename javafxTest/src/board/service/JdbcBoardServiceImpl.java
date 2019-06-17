package board.service;

import java.util.List;

import mvc.service.MemberServiceImpl;
import mvc.vo.MemberVO;
import board.dao.IJdbcBoardDao;
import board.dao.JdbcBoardDaoImpl;
import board.vo.JdbcBoardVO;

public class JdbcBoardServiceImpl implements IJdbcBoardService{
	
	private IJdbcBoardDao dao;// 인터페이스인 IJdbcBoardDao의 객체를 선언한다.
	private static JdbcBoardServiceImpl service; // 자신의 클래스의 객체를 선언함
	
	//생성자
	private JdbcBoardServiceImpl() { // 싱글톤 패턴을 사용하여 생성자에서 한번 생성할때만 객체를 생성하게함
		dao = JdbcBoardDaoImpl.getInstance();
	}
	
	public static JdbcBoardServiceImpl getInstance(){
		if(service ==null) service = new JdbcBoardServiceImpl();
		return service;
	}
	@Override
	public int insertBoard(JdbcBoardVO jBoardVo) {
		return dao.insertBoard(jBoardVo);
	}

	@Override
	public int deleteBoard(int boardNo) {
		return dao.deleteBoard(boardNo);
	}

	@Override
	public int updateBoard(JdbcBoardVO jBoardVo) {
		return dao.updateBoard(jBoardVo);
	}

	@Override
	public List<JdbcBoardVO> getAllBoardList() {
		return dao.getAllBoardList();
	}

	@Override
	public List<JdbcBoardVO> getSearchBoardList(String jBoardTitle) {
		return dao.getSearchBoardList(jBoardTitle);
	}

	@Override
	public JdbcBoardVO getBoard(int boardNo) {
		// 해당 게시글을 가져오기 전에 조회수를 1 증가 시킨다.
		int cnt = dao.setCountIncrement(boardNo);
		
		// 조회수 증가가 성공하면 해당 게시글을 가져온다.
		if(cnt>0) 
			return dao.getBoard(boardNo);
		else 
			return null;
	}

	@Override
	public int setCountIncrement(int boardNo) {
		return dao.setCountIncrement(boardNo);
	}

	@Override
	public List<JdbcBoardVO> getSearchBoard(String boxName, String tf) {
		return dao.getSearchBoard(boxName, tf);
	}
	
}
