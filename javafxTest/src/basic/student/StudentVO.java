package basic.student;

public class StudentVO {
	private String stuname;
	private int guk;
	private int su;
	private int eng;
	
	public StudentVO() {
		super();
	}
	
	public StudentVO(String stuname, int guk, int su, int eng) {
		super();
		this.stuname = stuname;
		this.guk = guk;
		this.su = su;
		this.eng = eng;
	}
	
	public String getStuname() {
		return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	public int getGuk() {
		return guk;
	}
	public void setGuk(int guk) {
		this.guk = guk;
	}
	public int getSu() {
		return su;
	}
	public void setSu(int su) {
		this.su = su;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	
	
	
}
