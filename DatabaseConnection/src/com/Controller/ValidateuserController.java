package com.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.userDao.UserDao;

@Controller
public class ValidateuserController {
	
	@RequestMapping("/Validate")
	@POST
	
	public void validateUser(HttpServletRequest request, HttpServletResponse response)
	
	{
		
		String uName = request.getParameter("uname");
		String pass = request.getParameter("pass");
				
				if(new UserDao().validateUser(uName,pass))
						{
					
					//success page
					
					try {
						request.getRequestDispatcher("Success.jsp").forward(request, response);
					} catch (ServletException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
								}
				else
				{
					//failure page
					
					try {
						request.getRequestDispatcher("Failure.jsp").forward(request, response);
					} catch (ServletException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
								}
				}
	}


