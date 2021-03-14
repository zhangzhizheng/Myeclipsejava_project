import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

public class SessionServlet1 extends HttpServlet implements HttpSession {
protected void processRequest( HttpServletRequest request,HttpServletResponse response) throws IOException {
	
	response.setContentType("text/html;charser=UTF-8");
	PrintWriter outPrintWriter=response.getWriter();
	try {
		String mymsg=request.getParameter("msg");
		outPrintWriter.print("<br/>");
		HttpSession mysSession=request.getSession();
		mysSession.setAttribute("msg", mymsg);
		String sessionid=mysSession.getId();
		outPrintWriter.print(sessionid);
		outPrintWriter.print("<br/>");
		outPrintWriter.print("<a href=\"SessionServlet2\">链接到SessionServlet2</a>");
				
		
	} finally {
		// TODO: handle finally clause
		outPrintWriter.close();
	}
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
public ServletContext getServletContext() {
	// TODO Auto-generated method stub
	return null;
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
