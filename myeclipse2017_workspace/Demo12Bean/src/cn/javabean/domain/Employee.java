package cn.javabean.domain;
/**
 * @author Administrator
 *
 */
public class Employee {
	private String name;
	private int salary;
	private Address address;
	public Employee() {
		super();
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String  toString() {
		return "Employee[name:"+name+",salary:"+salary+",address:"+address+"]";
		
	}

}
