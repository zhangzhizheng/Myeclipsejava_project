package cn.domain;

public class Student {
	private int id;
	private String sname;
	private String sno;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int id, String sname, String sno) {
		this.id = id;
		this.sname = sname;
		this.sno = sno;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", sname=" + sname + ", sno=" + sno + "]";
	}
	
	
}
