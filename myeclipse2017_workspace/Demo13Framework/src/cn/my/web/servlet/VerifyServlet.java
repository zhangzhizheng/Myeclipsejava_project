package cn.my.web.servlet;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.my.service.VerifyCode;
/**
 * 验证码处理
 * @author Administrator
 *
 */
public class VerifyServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=uft-8");
		/**要是get请求
		 * 生成图片
		 * 保存图片的文本到session文件中
		 * 把图片响应给客服端
		 */
		VerifyCode vCode=new VerifyCode();
		BufferedImage image=vCode.getImage();
		request.getSession().setAttribute("session_vcode", vCode.getText());//将图片上的文本获取到session域中
		VerifyCode.output(image, response.getOutputStream());
		
	}

}
