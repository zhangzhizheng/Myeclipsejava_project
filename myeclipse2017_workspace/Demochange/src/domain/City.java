package domain;

public class City {
	private int cid;
	private String name;
	private int  pid;
	public City() {
		super();
		// TODO Auto-generated constructor stub
	}
	public City(int cid, String name, int pid) {
		super();
		this.cid = cid;
		this.name = name;
		this.pid = pid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	@Override
	public String toString() {
		return "City [cid=" + cid + ", name=" + name + ", pid=" + pid + "]";
	}
	
	
}
