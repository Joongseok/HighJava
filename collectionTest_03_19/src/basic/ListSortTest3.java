package basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*

	문제) 학번(int), 이름(String), 국어점수(int), 영어점수(int), 수학점수(int),
		 총점(int), 등수(int)를 멤버로 갖는 Student클래스를 만든다.
		 
		 이 클래스의 생성자에서는 학번, 이름, 국어점수, 영어점수, 수학점수, 만 매개변수로
		 받아서 처리한다.
		 
		  이 Student객체들은 List에 저장하여 관리한다.
		  List에 저장된 데이터들을 학번의 오름차순으로 정렬할 수 있는 기능을 포함시킨다.
		  그리고, 외부 정렬 기준을 이용하여 총점의 역순으로 정렬하도록 하고 만약
		  총점이 같으면 이름의 오름차순으로 정렬되도록 한다.

*/
 class Student implements Comparable<Student>{
	private int num;
	private String name;
	private int guk;
	private int eng;
	private int mat;
	private int sum;
	private int rank;
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGuk() {
		return guk;
	}

	public void setGuk(int guk) {
		this.guk = guk;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}
	

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public Student(int num, String name, int guk, int eng, int mat) {
		super();
		this.num = num;
		this.name = name;
		this.guk = guk;
		this.eng = eng;
		this.mat = mat;
		this.sum = guk+eng+mat;
	}

	@Override
	public String toString() {
		return "Student [num=" + num + ", name=" + name + ", guk=" + guk
				+ ", eng=" + eng + ", mat=" + mat + ", sum=" + sum + ", rank="
				+ rank + "]";
	}

	@Override
	public int compareTo(Student mem) {
		
		return Integer.compare(this.num ,mem.getNum());
	}
	
	
}
public class ListSortTest3 {
	
	public void setRanking(List<Student>stdList){
		for(Student std : stdList){
			int rank = 1;
			for(Student std2 : stdList){
				if (std.getSum() < std2.getSum()) {
					rank++;
				}
			}
			std.setRank(rank);
		}
		
	}
	public static void main(String[] args) {
		ArrayList<Student> studentList = new ArrayList<Student>();
		
		studentList.add(new Student(13, "홍길동", 30, 80, 70));
		studentList.add(new Student(15, "강감찬", 58, 30, 90));
		studentList.add(new Student(12, "성춘향", 70, 70, 80));
		studentList.add(new Student(17, "이순신", 90, 70, 90));
		studentList.add(new Student(19, "일지매", 30, 80, 70));
		
//		for (int i = 0; i < studentList.size(); i++) {
//			int rank = 1;
//			studentList.get(i).setRank(rank);
//			for (int j = 0; j < studentList.size(); j++) {
//				if (studentList.get(i).getSum()< studentList.get(j).getSum()) {
//					rank += 1;
//					studentList.get(i).setRank(rank);
//					
//				}
//				
//			}
//		}
		//등수를 구하는 메서드 호출하기
//		ListSortTest3 stdTest = new ListSortTest3();
//		stdTest.setRanking(studentList);
		
		new ListSortTest3().setRanking(studentList);
		
		System.out.println("정렬전");
		for(Student student : studentList){
			System.out.println(student);
		}
		System.out.println("---------------------");
		
		System.out.println("학번의 오름차순 정렬 후 ");
		Collections.sort(studentList);
		for(Student student : studentList){
			System.out.println(student);
		}
		System.out.println("---------------------");
		
		//총점의 내림차순 정렬
		Collections.sort(studentList, new SortSumDesc());
		System.out.println("총점의 내림차순 , 총점이 같으면 이름의 오름차순 정렬후");
		for(Student student : studentList){
			System.out.println(student);
		}
		
	}
}
class SortSumDesc implements Comparator<Student>{

//	@Override
//	public int compare(Student st1, Student st2) {
//		
//		if (st1.getSum() < st2.getSum()) {
//			return 1;
//		}else if(st1.getSum() > st2.getSum()){
//			return -1;
//		}else if(st1.getSum() == st2.getSum()){
//			return st1.getName().compareTo(st2.getName());
//		}else{
//			return 0;
//		}
//	}
	@Override
	public int compare(Student std1, Student std2) {
		if (std1.getSum() == std2.getSum()) {
			return std1.getName().compareTo(std2.getName());
		}else{
			return new Integer(std1.getSum()).compareTo(std2.getSum())*-1;
		}
			
	}


	
}