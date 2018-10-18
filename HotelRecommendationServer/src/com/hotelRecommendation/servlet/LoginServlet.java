package com.hotelRecommendation.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hotelRecommendation.bean.UserBean;
import com.hotelRecommendation.database.UserDataBaseHelper;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		
		
		
		HttpSession session = request.getSession(true);

		String username=request.getParameter("userName");
		String password=request.getParameter("passWord");
		
		if(username.equals("admin") && password.equals("admin123"))
		{
			session.setAttribute("role", "ADMIN");
			response.sendRedirect("admin.jsp");
		}
		else
		{
			
			UserBean userBean = new UserBean();
			userBean.setUserName(username);
			userBean.setPassWord(password);
			
			
			
			UserDataBaseHelper userDataBaseHelper= new UserDataBaseHelper();
			
			UserBean bean=userDataBaseHelper.validateUser(userBean);
			
			if(bean!=null)
			{
				
				session.setAttribute("role", bean.getFirstName());
				session.setAttribute("userId", userBean.getUserId());
				response.sendRedirect("welcomeUser.jsp");
			}
			
			else
			{
				response.sendRedirect("login.jsp");
			}
			
			
		}
		
		
		
	}

}
