package cn.deal;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;

import javassist.tools.framedump;

public class MyTag1 implements SimpleTag {
private PageContext pc;
	
private JspFragment jspBody;
/**
 * 所有的setXxx()方法都会在dotag()之前被tomcat调用
 * 所在的doTag()中就可以使用tomcat传递过来的对象了
 */
	@Override
	public void doTag() throws JspException, IOException {
		/**
		 * 往页面进行输出
		 */
//		Writer out=this.getJspContext().getOut();
//		PageContext.getOut().print("hello,Tag!");
	}

	@Override
	public JspTag getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setJspBody(JspFragment jspBody) {
		// 标签体
		this.jspBody=jspBody;
	}

	@Override
	public void setJspContext(JspContext pc) {
		// TODO Auto-generated method stub
		/**
		 * 把服务器传过来的东西保存起来
		 */
		this.pc=(PageContext)pc;
	
	}

	@Override
	public void setParent(JspTag parent) {
		// TODO Auto-generated method stub
		
	}

}
