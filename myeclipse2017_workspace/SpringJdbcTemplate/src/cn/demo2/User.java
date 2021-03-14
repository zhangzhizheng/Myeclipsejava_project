package cn.demo2;
/**
 * 实体类
 * @author Administrator
 *
 */
public class User {
	private Integer id;
	private String name;
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
