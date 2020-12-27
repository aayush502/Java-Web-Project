package com.aayush.Test.basic;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aayush.Test.school.StudentImp1;
import com.aayush.Test.school.StudentVar;


@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String HOME = "home.jsp";
	public static final String STUDENT_DETAIL = "studentdetails.jsp";
	public static final String STUDENT_FORM = "studentform.jsp";
	public static final String SIGN_UP = "register.jsp";
	StudentImp1 student = new StudentImp1();
       
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String actions = request.getParameter("action");
		String forward = "";
		if(actions.equals("home")) {
			forward = HOME;
		}else if(actions.equals("student_detail")) {
			request.setAttribute("students", student.getStudentInfo());
			forward = STUDENT_DETAIL;
		}else if(actions.equals("new_form")) {
			forward=STUDENT_FORM;
		}else if(actions.equals("delete")) {
			
			int id=Integer.parseInt(request.getParameter("id"));
			student.deleteStudentInfo(id);
			request.setAttribute("students", student.getStudentInfo());
			forward=STUDENT_DETAIL;
			
		}else if(actions.equals("edit")) {
			int id=Integer.parseInt(request.getParameter("id"));
			request.setAttribute("students", student.getAllStudentInfo(id));
			forward=STUDENT_FORM;
		}
		else if(actions.equals("sign_up")) {
			forward=SIGN_UP;
			
		}
		RequestDispatcher rd = request.getRequestDispatcher(forward);
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentVar studentVar = new StudentVar();
		studentVar.setName(request.getParameter("sname"));
		studentVar.setGrade(request.getParameter("grade"));
		studentVar.setRoll(Integer.parseInt(request.getParameter("roll")));
		studentVar.setGender(request.getParameter("gender"));
		String id=request.getParameter("id");
		if (id==null || id.isEmpty()) {
			student.saveStudentInfo(studentVar);
		}else {
			studentVar.setId(Integer.parseInt(id));
			student.updateStudentInfo(studentVar);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(STUDENT_DETAIL);
		request.setAttribute("students", student.getStudentInfo());
		rd.forward(request, response);
	}

}
