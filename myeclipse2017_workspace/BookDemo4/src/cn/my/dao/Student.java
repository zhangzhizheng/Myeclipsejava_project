package cn.my.dao;

public class Student {
	private String sname;
	private int sage;
	private long sno;
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getSage() {
		return sage;
	}
	public void setSage(int sage) {
		this.sage = sage;
	}
	public long getSno() {
		return sno;
	}
	public void setSno(long sno) {
		this.sno = sno;
	}
	public Student(String sname, int sage, long sno) {
		this.sname = sname;
		this.sage = sage;
		this.sno = sno;
	}
	@Override
	public String toString() {
		return "Student [sname=" + sname + ", sage=" + sage + ", sno=" + sno + "]";
	}
	public Student() {
		
	}
}
