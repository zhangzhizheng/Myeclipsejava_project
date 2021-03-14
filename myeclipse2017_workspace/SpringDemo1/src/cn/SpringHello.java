package cn;

/**
 * 入门实现类
 * @author Administrator
 *
 */
public class SpringHello implements SpringImple {
	private String info;

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public void sayhello() {
		// TODO Auto-generated method stub
		System.out.println("你好"+info);
	}
	
}
