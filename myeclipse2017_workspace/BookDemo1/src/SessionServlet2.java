import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

public class SessionServlet2 extends HttpServlet implements HttpSession {

	/**
		 * Constructor of the object.
		 */
	protected void processRequest( HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html;charser=UTF-8");
		PrintWriter outPrintWriter=response.getWriter();
		try {
			
			HttpSession mysSession=request.getSession();
			String mymsg=(String)mysSession.getAttribute("msg");
			outPrintWriter.print("mymsg");
			mysSession.setAttribute("msg", mymsg);
			String sessionid=mysSession.getId();
			outPrintWriter.print(sessionid);
			outPrintWriter.print("<br/>");
			outPrintWriter.print("<a href=\"SessionServlet3\">链接到SessionServlet3</a>");
					
			
		} finally {
			// TODO: handle finally clause
			outPrintWriter.close();
		}
	}
	public SessionServlet2() {
		super();
	}

	/**
		 * Destruction of the servlet. <br>
		 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		doPost(request, response);
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", Hello	world");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
		 * Initialization of the servlet. <br>
		 *
		 * @throws ServletException if an error occurs
		 */
	public void init() throws ServletException {
		// Put your code here
	}

	@Override
	public Object getAttribute(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enumeration<String> getAttributeNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getCreationTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getLastAccessedTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMaxInactiveInterval() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public HttpSessionContext getSessionContext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getValue(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getValueNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void invalidate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isNew() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void putValue(String name, Object value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAttribute(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeValue(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAttribute(String name, Object value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMaxInactiveInterval(int interval) {
		// TODO Auto-generated method stub
		
	}

}
