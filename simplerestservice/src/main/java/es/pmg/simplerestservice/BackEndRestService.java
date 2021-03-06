package es.pmg.simplerestservice;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class BackEndRestService extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("application/json");
		
		ObjectMapper mapper = new ObjectMapper();
		String greeting = req.getParameter("greeting");
		
		ResponseDTO response = new ResponseDTO();
		response.setGreeting(greeting + " desde el backEnd");
		response.setIp(getIp());
		response.setTime(System.currentTimeMillis());
		
		PrintWriter out = resp.getWriter();
		
		mapper.writerWithDefaultPrettyPrinter().writeValue(out, response);
		
	}
	
	private String getIp() {
		String hostname;
		try {
			hostname = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			hostname = "unknown";
		}
		return hostname;
	}
	
	

}
