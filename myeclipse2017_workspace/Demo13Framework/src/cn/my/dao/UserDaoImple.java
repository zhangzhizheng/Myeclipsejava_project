package cn.my.dao;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import cn.my.domain.User;
/**
 * 数据
 * @author Administrator
 *
 */
public class UserDaoImple implements UserDao {
	private String path="D:/myeclipse2017_workspace/user.xml";//依赖文件
	/**
	 * 按用户名查找
	 * @param username
	 * @return
	 */
	public User findByUsername(String username){
		/**
		 * 得到document
		 * 使用xpath查询
		 * 校验结果：null返回null
		 *        不为null，要把Element封装到user对象中
		 *           
		 */
		//创建解析器，得到document
		SAXReader reader=new SAXReader();
		try {
			Document document=reader.read(path);//导这个包org.dom4j
			//通过xpath查询
			Element elseElement=(Element)document.selectSingleNode("//user[@username='"+username+"']");
			//校验
			if(elseElement==null){
				return null;
			}
			//把数据封装到user对象中
			User user=new User();
			String addUsername=elseElement.attributeValue("username");//username属性值
			String addPassword=elseElement.attributeValue("password");//password属性值
			user.setUsername(addUsername);//设置数据给user
			user.setPassword(addPassword);
		    return user;
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
	}
	/**
	 * 添加用户
	 * @param user
	 */
	public void addUser(User user) {
		/**
		 * 得到document
		 * 通过document得到root元素
		 * 使用参数user，转发Elment对象
		 * 把elment添加到root
		 * 保存document
		 */
		//创建解析器，得到document
		SAXReader reader=new SAXReader();
		try {
			Document document=reader.read(path);//导这个包org.dom4j
			//得到根元素
			Element root=document.getRootElement();
			//通过新元素创建新元素
			Element useElseEle=root.addElement("user");
			//为userElseEle设置属性
			useElseEle.addAttribute("username", user.getUsername());
			useElseEle.addAttribute("password", user.getPassword());
			//保存文档,创建输出格式
			OutputFormat format=new OutputFormat("\t",true);//缩进使用\t；换行
			format.setTrimText(true);//清空原有的换行和缩进
			//创建XMLwriter
			//参数写new FileWriter(path)，但是该流的编码的是系统的gbk,所以要采用其他流FileOutputStream(path)
			try {
				XMLWriter writer=new XMLWriter(
						new OutputStreamWriter(
						new FileOutputStream(path),"utf-8"),format);//使用字符流
				writer.write(document);
				writer.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);//防止异常给上层制造麻烦
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		} 
		
	}
}
