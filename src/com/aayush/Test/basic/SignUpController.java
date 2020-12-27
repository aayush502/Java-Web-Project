package com.aayush.Test.basic;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aayush.Test.member.MemberImpl;
import com.aayush.Test.member.MemberVar;


@WebServlet("/SignUpController")
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberImpl member = new MemberImpl();
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String actions = request.getParameter("action");
		if(actions.equals("sign_up")) {
			RequestDispatcher rd=request.getRequestDispatcher("register.jsp");
			rd.forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberVar memberVar = new MemberVar();
		memberVar.setFirstname(request.getParameter("firstname"));
		memberVar.setLastname(request.getParameter("lastname"));
		memberVar.setEmail(request.getParameter("email"));
		memberVar.setPassword(request.getParameter("password"));
		member.saveMemberInfo(memberVar);
		RequestDispatcher rd1=request.getRequestDispatcher("Login.jsp");
		rd1.forward(request, response);
		
		
		
	}

}
