package cn.spring4;

public class Car2 {
	private String name;//车的名字
	private Double price;//车的价格
	
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Car2 [name=" + name + ", price=" + price + "]";
	}
}
