package basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class DaeDeokHotelTest {
	HashMap<Integer, Room1> hotelMap = new HashMap<Integer, Room1>();
	Scanner sc = new Scanner(System.in);
	
	
	// 생성자에서 각 방을 셋팅한다.
	public DaeDeokHotelTest() {
		for (int i = 2; i <= 4; i++) {
			String roomType = null;
			switch (i) {
			case 2: roomType = "싱글룸"; break;
			case 3: roomType = "더블룸"; break;
			case 4: roomType = "스위트룸"; break;
			}
			for (int j = 1; j < 10; j++) {
				int roomNum = i * 100 + j;
				Room1 room = new Room1(roomNum, roomType);
				hotelMap.put(roomNum, room);
			}
		}
	}
	
	//메뉴 출력 및 작업 번호 입력
	public int dispalyMenu(){
		System.out.println();
		System.out.println("-----------------------------------------------------------");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료");
		System.out.println("-----------------------------------------------------------");
		System.out.print("선택>> ");
		int num = sc.nextInt();
		
		return num;
	}
	
	public void hotelStart(){
		System.out.println("*********************************************");
		System.out.println("   호텔문을 열었습니다. 어서오십시요.");
		System.out.println("*********************************************");
		while(true){
		    int choice = dispalyMenu();
		    switch (choice) {
			case 1: checkIn(); break; // 체크인
			case 2: checkOut(); break; // 체크 아웃
			case 3: showRoom(); break; // 객실 상태
			case 4: // 업무 종료
				System.out.println("*********************************************");
			    System.out.println("   호텔문을 닫았습니다");
			    System.out.println("*********************************************");
				return;

			default: System.out.println("번호를 잘못 선택했습니다.('1'또는 '2', '3', '4'를 입력하세요)");
			}
		}
	}
	//체크 아웃 하는 메서드
	public void checkOut(){
		System.out.println("----------------------------------------------");
		System.out.println("   체크아웃 작업");
		System.out.println("----------------------------------------------");
		System.out.println("체크아웃 할 방 번호를 입력하세요.");
		System.out.println("방번호 입력 >>");
		int num = sc.nextInt();
		if (!hotelMap.containsKey(num)) {
			System.out.println(num+"호 객실은 존재하지 않습니다.");
		}else if(hotelMap.get(num).getGuestName()==null){
			System.out.println(num+"호 객실에는 체크인 한 사람이 없습니다.");
		}else{
			System.out.println(num+"호 객실의 "+hotelMap.get(num).getGuestName()+"님 체크아웃을 완료하였습니다." );
			hotelMap.get(num).setGuestName(null);
		}
	}
	//체크인 하는 메서드
	public void checkIn(){
		System.out.println("----------------------------------------------");
		System.out.println("   체크인 작업 ");
		System.out.println("----------------------------------------------");
		System.out.println(" * 201~209 : 싱글룸");
		System.out.println(" * 301~309 : 더블룸");
		System.out.println(" * 401~409 : 스위트룸");
		System.out.println("----------------------------------------------");
		System.out.print("방 번호 입력 >> ");
		
		int num = sc.nextInt();
		
		if (!hotelMap.containsKey(num)) {
			System.out.println(num+"호 객실은 존재하지 않습니다.");
		}else if(hotelMap.get(num).getGuestName()!=null){
			System.out.println(num+"호 객실은 이미 손님이 있습니다.");
		}else{
			System.out.println("누구를 체크인 하시겠습니까?");
			System.out.print("이름 입력 >> ");
			String name = sc.next();
			hotelMap.get(num).setGuestName(name);
			System.out.println("체크인이 완료되었습니다.");
			
		}
	}
	
	//객실 상태를 출력하는 메서드
	public void showRoom(){
		System.out.println("----------------------------------------------");
		System.out.println("		현재 객실 상태");
		System.out.println("----------------------------------------------");
		System.out.println("방 번호	 방 종류	 투숙객 이름");
		System.out.println("----------------------------------------------");
		
		// Map의 키값(방번호)
		ArrayList<Integer> roomNumList = new ArrayList<Integer>(hotelMap.keySet());
		Collections.sort(roomNumList); //번호 순으로 정렬
		
		for(int roomNum : roomNumList){
			Room1 room = hotelMap.get(roomNum);
			String guestName = "-";
			if (room.getGuestName()!=null) {
				guestName = room.getGuestName();
			}
			System.out.println(room.getRoomNumber() + "      " +
								room.getRoomType() + "       " + 
								guestName);
		}
		System.out.println("----------------------------------------------");
	}
	
	public static void main(String[] args) {
		new DaeDeokHotelTest().hotelStart();
	}
}


class Room1{
	// Room클래스는 방번호(int), 방종류, 투숙객이름
	private int roomNumber;
	private String roomType;
	private String guestName;
	//생성자
	public Room1(int roomNumber, String roomType) {
		super();
		this.roomNumber = roomNumber;
		this.roomType = roomType;
	}
	
	// getter, setter...
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public String getGuestName() {
		return guestName;
	}
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}
	
	
	
	
}