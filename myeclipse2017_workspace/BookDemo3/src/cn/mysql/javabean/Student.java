package cn.mysql.javabean;
/**
 *实体
 * @author Administrator
 *
 */
public class Student {
	private int id;
	private String sname;  
	private String sno;

	@Override
	public String toString() {
		return "Student [id=" + id + ", sname=" + sname + ", sno=" + sno + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int i) {
		this.id = i;
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
	
	
}
