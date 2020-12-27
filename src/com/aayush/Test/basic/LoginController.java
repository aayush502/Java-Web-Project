package com.aayush.Test.basic;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aayush.Test.member.MemberImpl;
import com.aayush.Test.member.MemberVar;
import com.aayush.Test.school.StudentVar;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberImpl member=new MemberImpl();

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String actions=request.getParameter("action");
		if (actions.equals("logout")) {
			HttpSession session=request.getSession();
			session.invalidate();
			RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
			request.setAttribute("logout", "you are sucessfully logged out");
			rd.forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	MemberVar memberVar = new MemberVar();
	memberVar.setEmail(request.getParameter("email"));
	memberVar.setPassword(request.getParameter("password"));
	if(member.checkUser(memberVar)) {
		RequestDispatcher rd=request.getRequestDispatcher("header.jsp");
		rd.forward(request, response);
	}else {
		RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
		request.setAttribute("loginfail", "Wrong username or password!!!please sign up");
		rd.include(request, response);
	}
		
		
	}
}
