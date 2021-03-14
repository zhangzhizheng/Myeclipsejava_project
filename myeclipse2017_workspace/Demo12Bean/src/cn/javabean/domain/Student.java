package cn.javabean.domain;

/**
 * 必须为成员提供get/set方法（只提供一个也是可以的）
 * 必须要有默认的构造器(无参的)
 * 一般对于具有get/set方法的成员变量称之为属性
 * 其实就算一个属性没有对应的成员变量，只有get/set方法也是可以的
 *  
 * @author Administrator
 *
 */
public class Student {
	private String name;
	private int age;
	private String sex;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		
		return "Student[name="+name+",age="+age+",sex="+sex+"]";
	}
}
