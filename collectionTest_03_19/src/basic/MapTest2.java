package basic;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Scanner;
//
///*
// 이름, 주소, 전화번호 속성을 갖는 Phone클래스를 만들고,
// 이 Phone클래스를 이용하여 전화번호 정보를 관리하는 프로그램을 완성하시오
// 이 프로그램은 전화번호를 등록, 수정, 삭제, 검색, 전체출력하는 기능이 있다.
// (단, 전체 전화번호 정보는 Map을 이용하여 관리한다.
// -key는 이름으로 하고 value는 Phone클래스의 인스턴스로 한다.)

//   (1. 6번 메뉴를 구현한다.
//	  2. 프로그램이 처음 실행될 때 저장된 데이터를 읽어 오도록 처리한다. 
//	  3. 프로그램을 종료할 때 저장이 안되었으면 저장하고 종료되도록 한다.
//	 ) 
//
// 실행예시)
// =========================
// 전화번호 관리 프로그램
// =========================
//
// 메뉴를 선택하세요.
// 1. 전화번호 등록
// 2. 전화번호 수정
// 3. 전화번호 삭제
// 4. 전화번호 검색
// 5. 전화번호 전체 출력
// 6. 전화번호 자료 저장
// 0. 프로그램 종료
// ----------------
// 번호입력 >> 1
//
// 새롭게 등록할 전화번호 정보를 입력하세요.
// 이름 >> 홍길동
// 전화번호 >> 010-1111-1111
// 주소 >> 대전시
//
// 홍길동 정보가 저장되었습니다.
//
// 메뉴를 선택하세요.
// 1. 전화번호 등록
// 2. 전화번호 수정
// 3. 전화번호 삭제
// 4. 전화번호 검색
// 5. 전화번호 전체 출력
// 0. 프로그램 종료
// ----------------
// 번호입력 >> 5
//
//
// -------------------------------------
// 번호		이 름	     	전화번호    	주소
// -------------------------------------
// 1		홍길동	010-1111-1111	대전시
// ~~~
// -------------------------------------
// 출력 완료...
//
// 메뉴를 선택하세요.
// 1. 전화번호 등록
// 2. 전화번호 수정
// 3. 전화번호 삭제
// 4. 전화번호 검색
// 5. 전화번호 전체 출력
// 0. 프로그램 종료
// ----------------
// 번호입력 >> 0
//
// 프로그램을 종료합니다....
// */
//
////이름, 주소, 전화번호 속성을 갖는 Phone클래스를 만들고,
////이 Phone클래스를 이용하여 전화번호 정보를 관리하는 프로그램을 완성하시오
////이 프로그램은 전화번호를 등록, 수정, 삭제, 검색, 전체출력하는 기능이 있다.
////(단, 전체 전화번호 정보는 Map을 이용하여 관리한다.
////	-key는 이름으로 하고 value는 Phone클래스의 인스턴스로 한다.)
//class Phone {
//	String name; // 이름을 담을 변수
//	String addr; // 주소를 담을 변수
//	String tel; // 전화번호를 담을 변수
//
//	public Phone(String name, String addr, String tel) {
//		super();
//		this.name = name;
//		this.addr = addr;
//		this.tel = tel;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getAddr() {
//		return addr;
//	}
//
//	public void setAddr(String addr) {
//		this.addr = addr;
//	}
//
//	public String getTel() {
//		return tel;
//	}
//
//	public void setTel(String tel) {
//		this.tel = tel;
//	}
//
//}
//
//public class MapTest2 {
//	// 뷰 메서드
//	static HashMap<String, Phone> phoneList = new HashMap<String, Phone>();// 입력받은 키와
//	static Scanner sc = new Scanner(System.in);// 입력받을때 사용할 스캐너
//	static String name;
//	static String addr;
//	static String tel;
//	public static void view() {
//		int num;
//		while (true) {
//			System.out.println("=======================");
//			System.out.println("전화번호 관리 프로그램");
//			System.out.println("========================\n");
//			System.out.println("메뉴를 선택하세요.");
//			System.out.println(" 1. 전화번호 등록");
//			System.out.println(" 2. 전화번호 수정");
//			System.out.println(" 3. 전화번호 삭제");
//			System.out.println(" 4. 전화번호 검색");
//			System.out.println(" 5. 전화번호 전체 출력");
//			System.out.println(" 0. 프로그램 종료");
//			num = sc.nextInt();
//			switch (num) {
//			case 1:
//				createPhone();
//				break;
//			case 2:
//				updatePhone();
//				break;
//			case 3:
//				removePhone();
//				break;
//			case 4:
//				selectPhone();
//				break;
//			case 5:
//				break;
//			case 0:
//				System.out.println("종료합니다.");
//				return;
//			}
//
//		}
//	}
//
//	//스트링 값을 받는 메서드
//	public static String string(){
//		Scanner sc = new Scanner(System.in);
//		String input = sc.next();
//		return input;
//	}
//	// 전화번호를 등록하는 메서드
//	public static void createPhone() {
//		Phone ph = new Phone();
//		System.out.println("새롭게 등록할 전화번호 정보를 입력하세요.");
//		System.out.println("이름을 입력 하세요");
//		name = string();
//		ph.setName(name);
//		System.out.println("전화번호를 입력하세요.");
//		tel = string();
//		ph.setTel(tel);
//		System.out.println("주소를 입력하세요.");
//		addr = string();
//		ph.setAddr(addr);
//		System.out.println(ph.getName() + "의 정보가 저장되었습니다.");
//		phoneList.put("name", ph);
//		
//	}
//
//	// 전화번호를 삭제하는 메서드
//	public static void removePhone() {
//		System.out.println("삭제하실 사람의 이름을 입력하세요.");
//		System.out.println("이름을 입력하세요.");
//		name = string();
//		for (int i = 0; i < phoneList.size(); i++) {
//			if (name.equals(phoneList.get(i).get("name"))) {// 입력받은 이름과 리스트의 이름이
//															// 같으면
//				phoneList.remove(phone);
//				System.out.println("삭제되었습니다.");
//			}
//		}
//
//	}
//
//	// 전화번호를 수정하는 메서드
//	public static void updatePhone() {
//		System.out.println("전화번호를 수정할 사람의 이름을 입력하세요");
//		name = sc.next();
//		for (int i = 0; i < phoneList.size(); i++) {
//			if (name.equals(phoneList.get(i).get("name"))) {// 입력받은 이름과 리스트의 이름이
//															// 같으면
//				System.out.println("수정하실 전화번호를 입력해주세요");
//				tel = sc.next();
//				phone.put("tel", tel);
//				System.out
//						.println("수정하신 전화번호는 => " + phone.get("tel") + "입니다.");
//			}
//		}
//	}
//
//	// 전화번호를 검색하는 메서드
//	public static void selectPhone() {
//		System.out.println("검색할 사람의 이름을 입력하세요");
//		name = sc.next();
//		for (int i = 0; i < phoneList.size(); i++) {
//			if (name.equals(phoneList.get(i).get("name"))) {// 입력받은 이름과 리스트의 이름이
//															// 같으면
//				System.out.println(phone);
//			}
//		}
//	}
//
//	// 전화번호 전체출력 메서드
//	public void astricPhone() {
//		for (int i = 0; i < phoneList.size(); i++) {
//
//		}
//	}
//
//	public static void main(String[] args) {
//		view();
//	}
//}
