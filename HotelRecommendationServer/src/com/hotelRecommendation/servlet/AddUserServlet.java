package com.hotelRecommendation.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hotelRecommendation.bean.UserBean;
import com.hotelRecommendation.database.UserDataBaseHelper;

/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String address=request.getParameter("address");
		String emailId=request.getParameter("emailId");
		String mobileno=request.getParameter("mobileNo");
		String username=request.getParameter("username");
		String password=request.getParameter("passWord");
		
		
		
		UserBean userBean = new UserBean();
		
		userBean.setFirstName(firstname);
		userBean.setLastName(lastname);
		userBean.setAddress(address);
		userBean.setEmaild(emailId);
		userBean.setContactNo(mobileno);
		userBean.setUserName(username);
		userBean.setPassWord(password);
		
		UserDataBaseHelper userDataBaseHelper = new UserDataBaseHelper();
		int result=userDataBaseHelper.addUser(userBean);
		
		if(result==1)
		{
			response.sendRedirect("welcomeUser.jsp");
		}
		
		
		
		
		
		
		
		
		
	}

}
