package basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/*
	이름, 주소, 전화번호 속성을 갖는 Phone1클래스를 만들고,
	이 Phone1클래스를 이용하여 전화번호 정보를 관리하는 프로그램을 완성하시오.
	이 프로그램에는 전화번호를 등록, 수정, 삭제, 검색, 전체출력하는 기능이 있다.
	(단, 전체 전화번호 정보는 Map을 이용하여 관리한다.
	    - key는 이름으로 하고 value는 Phone1클래스의 인스턴스로 한다.)
	    
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
public class MapTest4 {
	private HashMap<String, Phone1> Phone1BookMap;
	private Scanner scan;
	private String fileName ="d:/D_Other/phoneBook1.dat";
	private boolean dataChange;	// 데이터의 변경 여부를 나타내는 변수(변경되면  true)
	public MapTest4() {
		scan = new Scanner(System.in);
		//Phone1BookMap = new HashMap<String, Phone1>();
		Phone1BookMap = load();
		if (Phone1BookMap == null) {
			Phone1BookMap = new HashMap<String, Phone1>();
		}
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
		System.out.println("  6. 전화번호 자료 저장");
		System.out.println("  0. 프로그램 종료");
		System.out.println("--------------------------");
		System.out.print(" 번호 입력 >> ");
		int num = scan.nextInt();
		return num;
	}
	
	// 프로그램을 시작하는 메서드
	public void Phone1BookStart(){
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
				case 6 : save(); break; // 저장
				case 0 : //종료
					if(dataChange==true){
						System.out.println("변경된 내용을 저장합니다...");
						save();
					}
					System.out.println("프로그램을 종료합니다.");
					return; // 프로그램 종료
				default : System.out.println("작업 번호를 잘못 입력했습니다. 다시 선택하세요.");
			}
			
		}
	}
	
	// 저장된 전화번호 정보를 읽어오는 메서드
	public HashMap<String, Phone1> load(){
		HashMap<String, Phone1> pMap = null;	// 읽어온 데이터를 저장할 Map
		File file = new File(fileName);
		if(!file.exists()){ 	//저장된 파일이 없으면..
			return null;
		}
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(
					new BufferedInputStream(new FileInputStream(file))
					);
			pMap = (HashMap<String, Phone1>) ois.readObject();
		} catch (IOException e) {
			return null;
		} catch (ClassNotFoundException e) {
			return null;
		}finally{
			if(ois!= null) try{ois.close();}catch(IOException e){}
		}
		return pMap;
	}
	
	// 전화번호 정보를 저장하는 메서드
	public void save(){
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(
					new BufferedOutputStream(
							new FileOutputStream(fileName))
					);
			oos.writeObject(Phone1BookMap);
			System.out.println("저장이 완료되었습니다.");
			dataChange = false;
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			// 스트림 객체 닫기
			if(oos!=null)try{oos.close();}catch(IOException e){}
		}
	}
	
	// 전화번호 정보를 검색하는 메서드
	public void search(){
		System.out.println();
		System.out.println("검색할 전화번호 정보를 입력하세요.");
		System.out.print("이름 >> ");
		String name = scan.next();
		
		if(Phone1BookMap.containsKey(name)==false){
			System.out.println(name + "씨의 전화번호 정보가 없습니다.");
			return;
		}
		
		Phone1 p = Phone1BookMap.get(name);
		
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
		
		if(Phone1BookMap.containsKey(name)==false){
			System.out.println(name + "씨의 전화번호 정보가 없습니다.");
			return;
		}
		Phone1BookMap.remove(name); 
		dataChange = true;
		System.out.println(name + "씨 정보를 삭제했습니다.");
		
	}
	
	
	// 전화번호 정보를 수정하는 메서드
	public void update(){
		System.out.println();
		System.out.println("수정할 전화번호 정보를 입력하세요.");
		System.out.print("이름 >> ");
		String name = scan.next();
		
		if(Phone1BookMap.containsKey(name)==false){
			System.out.println(name + "씨의 전화번호 정보가 없습니다.");
			return;
		}
		
		System.out.print("새로운 주소 >> ");
		String addr = scan.next();
		
		System.out.print("새로운 전화번호 >> ");
		String tel = scan.next();
		
		Phone1BookMap.put(name, new Phone1(name, addr, tel));
		dataChange = true;
		System.out.println(name + "씨 정보를 수정했습니다.");
		
	}
	
	
	// 전체 자료를 출력하는 메서드
	public void displayAll(){
		Set<String> keySet = Phone1BookMap.keySet();
		
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
				Phone1 p = Phone1BookMap.get(name);
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
		scan.nextLine();
		String name = scan.nextLine();
		
		// 이미 등록된 사람인지 검사
		//if(Phone1BookMap.get(name)!=null){  // key값에 해당하는 value값이 없으면 null
		if(Phone1BookMap.containsKey(name)){  // 주어진 값이 key값에 있으면 true
			System.out.println(name + "씨는 이미 등록된 사람입니다.");
			return;
		}
		
		System.out.print("주 소 >> ");
		String addr = scan.nextLine();
		
		System.out.print("전화번호 >> ");
		String tel = scan.nextLine();
		
		Phone1BookMap.put(name, new Phone1(name, addr, tel));
		dataChange = true;
		System.out.println(name + "씨 정보가 저장되었습니다.");
	}
	
	
	public static void main(String[] args) {
		new MapTest4().Phone1BookStart();
	}

}

// 이름, 주소, 전화번호
class Phone1 implements Serializable{
	private static final long serialVersionUID = -4513130242226074778L;
	
	private String name;
	private String addr;
	private String tel;
	
	// 생성자
	public Phone1() {}

	public Phone1(String name, String addr, String tel) {
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
