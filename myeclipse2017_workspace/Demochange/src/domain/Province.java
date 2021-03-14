package domain;

public class Province {
	private int pid;
	private String name;
	public Province() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Province(int pid, String name) {
		super();
		this.pid = pid;
		this.name = name;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Province [pid=" + pid + ", name=" + name + "]";
	}
	
}
