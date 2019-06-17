package basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

class Room  {
	private int room;// 방번호
	private String rName; // 방이름
	private String mName; // 투숙객 이름
	Map<Integer, Room> roomManager = new HashMap<Integer, Room>();
	public Room() {
		for (int i = 1; i < 10; i++) { 
			roomManager.put(200+i, new Room(200+i, "싱글룸", "-"));
			roomManager.put(300+i, new Room(300+i, "더블룸", "-"));
			roomManager.put(400+i, new Room(400+i, "스위트룸", "-"));
		}
	}

	public Room(int room, String rName, String mName) {
		super();
		this.room = room;
		this.rName = rName;
		this.mName = mName;

	}

	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	public String getrName() {
		return rName;
	}
	public void setrName(String rName) {
		this.rName = rName;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}

}

public class HotelTest  {

	Room r = new Room();
	
	private Scanner sc = new Scanner(System.in);



	//실행시 메뉴를 보여주고 번호를 받는 메서드
	public int roomMenu(){
		System.out.println("-----------------------------------------------------------");
		System.out.println("어떤 업무를 하시겠습니까?");
		System.out.println("1. 체크인    2. 체크아웃    3. 객실상태    4. 업무종료");
		System.out.println("-----------------------------------------------------------");
		System.out.print("선택>> ");
		int num = sc.nextInt();
		return num;
	}
	//프로그램을 시작하는 메서드
	public void RoomMenuStrat(){
		System.out.println();
		System.out.println("*********************************************");
		System.out.println("       호텔문을 열었습니다. 어서오십시요.");
		System.out.println("*********************************************");
		System.out.println();
		System.out.println();
		while(true){
			int select = roomMenu();
			
			switch (select) {
			case 1: checkin(); break;//체크인
			case 2: checkout(); break;//체크아웃
			case 3: roomview(); break;//객실상태
			case 4:
				System.out.println("*********************************************");
				System.out.println("       호텔문을 닫았습니다.");
				System.out.println("*********************************************");
				return;//업무종료
			default:  System.out.println("작업 번호를 잘못 입력했습니다. 다시 선택하세요");
			
			
		}
		}
	}
	//체크아웃 메서드
	public void checkout(){
		System.out.println();
		System.out.println("----------------------------------------------");
		System.out.println("   체크아웃 작업");
		System.out.println("----------------------------------------------");
		System.out.println("체크아웃 할 방 번호를 입력하세요.");
		System.out.print("방 번호 입력 >> ");
		int select = sc.nextInt();
		if (r.roomManager.containsKey(select) == false) {// key값에 해당하는 value값이 없으면 null
			System.out.println(select + "호 객실은 존재하지 않습니다.");
			return;
		}else if (r.roomManager.get(select).getmName().toString()=="-"){
			System.out.println(select+"호 객실에는 체크인 한 사람이 없습니다.");
			return;
		}
		String name = "-";
		System.out.println(select +"호 객실의 "+r.roomManager.get(select).getmName()+"님 체크아웃을 완료하였습니다.");
		r.roomManager.put(select, new Room(select, r.roomManager.get(select).getrName() , name));
	}
	//객실 상태 메서드
	public void roomview(){
		TreeMap<Integer, Room> rl = new TreeMap<Integer, Room>(r.roomManager);
		Set<Integer> keySet = rl.keySet();
		System.out.println();
		System.out.println("----------------------------------------------");
		System.out.println("		현재 객실 상태");
		System.out.println("----------------------------------------------");
		System.out.println("방 번호	 방 종류	 투숙객 이름");
		System.out.println("----------------------------------------------");
		
		Iterator<Integer> it = keySet.iterator();
		int num = 0;
		while(it.hasNext()){
			 num = it.next();
		rl.get(num);
		System.out.println(rl.get(num).getRoom() + "	 " + rl.get(num).getrName() + " 	" + rl.get(num).getmName());
		}
	}
	
	public void checkin(){
		System.out.println();
		System.out.println("----------------------------------------------");
		System.out.println("   체크인 작업");
		System.out.println("----------------------------------------------");
		System.out.println(" * 201~209 : 싱글룸");
		System.out.println(" * 301~309 : 더블룸");
		System.out.println(" * 401~409 : 스위트룸");
		System.out.println("----------------------------------------------");
		System.out.print("방 번호 입력 >> ");
		int select = sc.nextInt();
		if (r.roomManager.containsKey(select) == false) {// key값에 해당하는 value값이 없으면 null
			System.out.println(select + "호 객실은 존재하지 않습니다.");
			return;
		}else if (r.roomManager.get(select).getmName().toString()!="-"){
			System.out.println(select+"호 객실은 이미 손님이 있습니다.");
			return;
		}
		System.out.println("누구를 체크인 하시겠습니까?");
		System.out.print("이름 입력 >> ");
		String name = sc.next();
		r.roomManager.put(select, new Room(select, r.roomManager.get(select).getrName() , name));
		System.out.println("체크인이 완료되었습니다.");
	}
	public static void main(String[] args) {
		new HotelTest().RoomMenuStrat();
	}

}
