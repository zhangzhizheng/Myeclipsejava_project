package cn.my.domain;
/**
 *实体
 * @author Administrator
 *
 */
public class User {
	private String username;
	private String password;  
	private String verifycode;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", verifycode=" + verifycode + "]";
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getVerifycode() {
		return verifycode;
	}
	public void setVerifycode(String verifycode) {
		this.verifycode = verifycode;
	}
}
