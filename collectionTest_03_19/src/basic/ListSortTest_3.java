package basic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Student1 implements Comparable<Student>{
	private int stdNum;
	private String stdName;
	private int kor;
	private int eng;
	private int mat;
	private int tot;
	private int rank;
	
	public int getStdNum() {
		return stdNum;
	}

	public void setStdNum(int stdNum) {
		this.stdNum = stdNum;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
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

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public Student1(int stdNum, String stdName, int kor, int eng, int mat) {
		super();
		this.stdNum = stdNum;
		this.stdName = stdName;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.tot = kor+eng+mat;
		
	}
	

	@Override
	public String toString() {
		return "Student [stdNum=" + stdNum + ", stdName=" + stdName + ", kor="
				+ kor + ", eng=" + eng + ", mat=" + mat + ", tot=" + tot
				+ ", rank=" + rank + "]";
	}
	//학번의 오름차순으로  정렬기준 정하기
	public int compareTo(Student1 std) {
		
		return Integer.compare(this.stdNum, std.getStdNum());
	}

	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return 0;
	}
}

// 총점의 역순으로 정렬하도록 하고 만약 총점이 같으면 이름의 오름차순으로 정렬되도록 설정
class SortByTotal implements Comparator<Student1>{

	@Override
	public int compare(Student1 std1, Student1 std2) {
		if (std1.getTot() == std2.getTot()) {
			return std1.getStdName().compareTo(std2.getStdName());
		}else{
			return new Integer(std1.getTot()).compareTo(std2.getTot())*-1;
		}
			
	}
	
}
public class ListSortTest_3 {
	public static void main(String[] args) {
		List<Student1> stdList = new ArrayList<Student1>();
		
	}
}
