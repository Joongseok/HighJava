package basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/*
	이름, 주소, 전화번호 속성을 갖는 Phone클래스를 만들고,
	이 Phone클래스를 이용하여 전화번호 정보를 관리하는 프로그램을 완성하시오.
	이 프로그램에는 전화번호를 등록, 수정, 삭제, 검색, 전체출력하는 기능이 있다.
	(단, 전체 전화번호 정보는 Map을 이용하여 관리한다.
	    - key는 이름으로 하고 value는 Phone클래스의 인스턴스로 한다.)
	    
	실행예시)
	===========================
	   전화번호 관리 프로그램
	===========================
	
	메뉴를 선택하세요.
	 1. 전화번호 등록
	 2. 전화번호 수정
	 3. 전화번호 삭제
	 4. 전화번호 검색
	 5. 전화번호 전체 출력
	 0. 프로그램 종료
   ---------------------
   번호입력 >> 1
   
   새롭게 등록할 전화번호 정보를 입력하세요.
   이름 >> 홍길동
   전화번호 >> 010-1111-1111
   주소 >> 대전시
   
   홍길동 정보가 저장되었습니다.
   
	메뉴를 선택하세요.
	 1. 전화번호 등록
	 2. 전화번호 수정
	 3. 전화번호 삭제
	 4. 전화번호 검색
	 5. 전화번호 전체 출력
	 0. 프로그램 종료
   ---------------------
   번호입력 >> 5
   
   ----------------------------------------
    번호   이 름       전화번호      주소  
   ----------------------------------------
     1   홍길동    010-1111-1111   대전시
     ~~~
   ----------------------------------------
   출력 완료...
   
   	메뉴를 선택하세요.
	 1. 전화번호 등록
	 2. 전화번호 수정
	 3. 전화번호 삭제
	 4. 전화번호 검색
	 5. 전화번호 전체 출력
	 0. 프로그램 종료
   ---------------------
   번호입력 >> 0
   
   프로그램을 종료합니다...
	
*/
public class MapTest3 {
	private HashMap<String, Phone> phoneBookMap;
	private Scanner scan;
	
	public MapTest3() {
		scan = new Scanner(System.in);
		phoneBookMap = new HashMap<String, Phone>();
	}
	
	// 메뉴를 출력하고 작업할 번호를 입력 받는 메서드
	public int displayMenu(){
		System.out.println();
		System.out.println("메뉴를 선택하세요.");
		System.out.println("  1. 전화번호 등록");
		System.out.println("  2. 전화번호 수정");
		System.out.println("  3. 전화번호 삭제");
		System.out.println("  4. 전화번호 검색");
		System.out.println("  5. 전화번호 전체 출력");
		System.out.println("  0. 프로그램 종료");
		System.out.println("--------------------------");
		System.out.print(" 번호 입력 >> ");
		int num = scan.nextInt();
		return num;
	}
	
	// 프로그램을 시작하는 메서드
	public void phoneBookStart(){
		System.out.println("=====================================");
		System.out.println("     전 화 번 호 관리 프 로 그 램");
		System.out.println("=====================================");
		
		while(true){
			int choice = displayMenu();  // 메뉴 출력 및 작업 번호 입력
			
			switch(choice){
				case 1 : insert(); break; // 등록
				case 2 : update(); break; // 수정
				case 3 : delete(); break; // 삭제
				case 4 : search(); break; // 검색
				case 5 : displayAll(); break; // 전체 출력
				case 0 : 
					System.out.println("프로그램을 종료합니다.");
					return; // 프로그램 종료
				default : System.out.println("작업 번호를 잘못 입력했습니다. 다시 선택하세요.");
			}
			
		}
	}
	
	// 전화번호 정보를 검색하는 메서드
	public void search(){
		System.out.println();
		System.out.println("검색할 전화번호 정보를 입력하세요.");
		System.out.print("이름 >> ");
		String name = scan.next();
		
		if(phoneBookMap.containsKey(name)==false){
			System.out.println(name + "씨의 전화번호 정보가 없습니다.");
			return;
		}
		
		Phone p = phoneBookMap.get(name);
		
		System.out.println(name + "씨 전화번호 정보");
		System.out.println("이    름 : " + p.getName());
		System.out.println("주    소 : " + p.getAddr());
		System.out.println("전화번호 : " + p.getTel());
		System.out.println();
		System.out.println("검색 작업 완료...");
	}
	
	// 전화번호 정보를 삭제하는 메서드
	public void delete(){
		System.out.println();
		System.out.println("삭제할 전화번호 정보를 입력하세요.");
		System.out.print("이름 >> ");
		String name = scan.next();
		
		if(phoneBookMap.containsKey(name)==false){
			System.out.println(name + "씨의 전화번호 정보가 없습니다.");
			return;
		}
		phoneBookMap.remove(name); 
		
		System.out.println(name + "씨 정보를 삭제했습니다.");
		
	}
	
	
	// 전화번호 정보를 수정하는 메서드
	public void update(){
		System.out.println();
		System.out.println("수정할 전화번호 정보를 입력하세요.");
		System.out.print("이름 >> ");
		String name = scan.next();
		
		if(phoneBookMap.containsKey(name)==false){
			System.out.println(name + "씨의 전화번호 정보가 없습니다.");
			return;
		}
		
		System.out.print("새로운 주소 >> ");
		String addr = scan.next();
		
		System.out.print("새로운 전화번호 >> ");
		String tel = scan.next();
		
		phoneBookMap.put(name, new Phone(name, addr, tel));
		System.out.println(name + "씨 정보를 수정했습니다.");
		
	}
	
	
	// 전체 자료를 출력하는 메서드
	public void displayAll(){
		Set<String> keySet = phoneBookMap.keySet();
		
		System.out.println();
		System.out.println("---------------------------------------");
		System.out.println(" 번호     이 름       전화번호       주소");
		System.out.println("---------------------------------------");
		if(keySet.size()==0){
			System.out.println("   등록된 전화번호 정보가 하나도 없습니다.");
		}else{
			Iterator<String> it = keySet.iterator();
			int num = 0;
			while(it.hasNext()){
				num++;
				String name = it.next();  // 키값 이면서 이름인 데이터 구하기
				Phone p = phoneBookMap.get(name);
				System.out.println(num + "   " + name + "   " + p.getTel() + "  " + p.getAddr());
			}
		}
		System.out.println("---------------------------------------");
		System.out.println("출력 끝...");
		
	}
	
	
	// 전화번호 정보를 등록하는 메서드
	public void insert(){
		System.out.println();
		System.out.println("등록할 새로운 전화번호 정보를 입력하세요.");
		System.out.print("이름 >> ");
		String name = scan.next();
		
		// 이미 등록된 사람인지 검사
		//if(phoneBookMap.get(name)!=null){  // key값에 해당하는 value값이 없으면 null
		if(phoneBookMap.containsKey(name)){  // 주어진 값이 key값에 있으면 true
			System.out.println(name + "씨는 이미 등록된 사람입니다.");
			return;
		}
		
		System.out.print("주 소 >> ");
		String addr = scan.next();
		
		System.out.print("전화번호 >> ");
		String tel = scan.next();
		
		phoneBookMap.put(name, new Phone(name, addr, tel));
		System.out.println(name + "씨 정보가 저장되었습니다.");
	}
	
	
	public static void main(String[] args) {
		new MapTest3().phoneBookStart();
	}

}

// 이름, 주소, 전화번호
class Phone{
	private String name;
	private String addr;
	private String tel;
	
	// 생성자
	public Phone() {}

	public Phone(String name, String addr, String tel) {
		super();
		this.name = name;
		this.addr = addr;
		this.tel = tel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
}
