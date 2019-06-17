package mvc.service;

import java.util.List;

import mvc.dao.IMemberDao;
import mvc.dao.MemberDaoImpl;
import mvc.vo.MemberVO;

public class MemberServiceImpl implements IMemberService {
	private IMemberDao dao;// ServiceImpl는 dao의 인터페이스 객체를 만든다. 즉 클래스인 memberDaoImpl가 아닌 ImemberDao라는 인터페이스의 객체를 선언함
	private static MemberServiceImpl service;	//싱글톤 패턴을 사용하기 위해 접근제한자를 private static으로 하여 자신의 클래스인 MemberSErviceImpl의 객체 service를 만듬
	
	//생성자
	private MemberServiceImpl() {
		// 인터페이스 ImemberDao의 객체인 dao에 인터페이스를 구현한 구현체클래스 MemberDaoImpl의 getInstance메서드를 통해 dao를 생성해준다. service가 생성될때 dao도 생성된다?
		dao = MemberDaoImpl.getInstance();
	}
	
	public static MemberServiceImpl getInstance(){ //싱글톤 패턴은 객체를 그냥 생성할 수 없고 메서드를 이용해서 한번만 생성할수 있다. 주로 객체를 만드는데 있어서 getInstance라는 이름을 가짐
		if(service ==null) service = new MemberServiceImpl();//service가 만들어지지 않아있으면 service를 생성하고 반환한다.
		return service;
	}
	
	
	//MemberController에 연결되어있는 service에서 매개변수를 받아서 dao.insetMember메서드에 넘겨주고 daoImpl에서 받아온 결과를 return 해서 controller에 넘겨줌
	// controller ==> service  ==> dao ==> xml 받아오는 순서
	// xml ==> dao ==> service ==> controller 넘겨주는 순서
	@Override
	public int insertMember(MemberVO memvo) {
		
		return dao.insertMember(memvo);
	}

	@Override
	public int deleteMember(String memId) {
		
		return dao.deleteMember(memId);
	}

	@Override
	public int updateMember(MemberVO memvo) {
		return dao.updateMember(memvo);
	}

	@Override
	public List<MemberVO> getAllMember() {
		return dao.getAllMember();
	}

	@Override
	public boolean getMember(String memId) {
		return dao.getMember(memId);
	}

	@Override
	public List<MemberVO> getSearchMember(String fieldName, String value) {
		return dao.getSearchMember(fieldName, value);
	}

}
