package basic.childWinTest;

public class Sample {

	private int id;
	private String name;
	private String addr;
	
	// 생성자
	public Sample() {
		super();
	}
	// 매개변수 있는 생성자
	public Sample(int id, String name, String addr) {
		super();
		this.id = id;
		this.name = name;
		this.addr = addr;
	}
	
	//Getter Setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
}

