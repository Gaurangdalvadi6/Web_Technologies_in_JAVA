package Controller;

import java.io.IOException;
import java.util.Random;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.StudentDao;
import Model.Student;
import Services.Service;


/**
 * Servlet implementation class StudentController
 */
@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("register")) {
			Student s = new Student();
			s.setFname(request.getParameter("fname"));
			s.setLname(request.getParameter("lname"));
			s.setEmail(request.getParameter("email"));
			s.setMobile(Long.parseLong(request.getParameter("mobile")));
			s.setGender(request.getParameter("gender"));
			s.setPassword(request.getParameter("password"));
			StudentDao.insertStudent(s);
			System.out.println(s);
			request.setAttribute("msg", "Account Registed successfully.");
			request.getRequestDispatcher("login.jsp").forward(request, response);	
		}
		else if (action.equalsIgnoreCase("login")) {
			Student s = new Student();
			s.setEmail(request.getParameter("email"));
			String email = request.getParameter("email");
			s.setPassword(request.getParameter("password"));
			boolean flag = StudentDao.checkEmail(email);
			if (flag == true) {
				Student s1 = StudentDao.loginSeller(s);
				if (s1 != null) {
					HttpSession session = request.getSession();
					session.setAttribute("data", s1);
					request.getRequestDispatcher("home.jsp").forward(request, response);
				}
				else {
					request.setAttribute("msg2", "password is incorrect.");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			}
			else {
				request.setAttribute("msg1", "account is not registed");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
		else if (action.equalsIgnoreCase("update")) {
			Student s = new Student();
			s.setId(Integer.parseInt(request.getParameter("id")));
			s.setFname(request.getParameter("fname"));
			s.setLname(request.getParameter("lname"));
			s.setEmail(request.getParameter("email"));
			s.setMobile(Long.parseLong(request.getParameter("mobile")));
			s.setGender(request.getParameter("gender"));
			StudentDao.updateProfile(s);
			HttpSession session = request.getSession();
			session.setAttribute("data", s);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
		else if (action.equalsIgnoreCase("change password")) {
			Student s = new Student();
			int id = Integer.parseInt(request.getParameter("id"));
			String op = request.getParameter("op");
			String np = request.getParameter("np");
			String cnp = request.getParameter("cnp");
			boolean flag = StudentDao.checkOldPassword(id, op);
			if (flag==true) {
				if (np.equals(cnp)) {
					StudentDao.changePassword(id, np);
					response.sendRedirect("login.jsp");
				} else {
					request.setAttribute("msg1", "new password and confirm new password is not match");
					request.getRequestDispatcher("change-password.jsp").forward(request, response);
				}
			}
			else {
				request.setAttribute("msg", "old password is incorrect");
				request.getRequestDispatcher("change-password.jsp").forward(request, response);
			}
		}
		else if (action.equalsIgnoreCase("GET OTP")) {
			String email = request.getParameter("email");
			boolean flag = StudentDao.checkEmail(email);
			if (flag == true) {
				Service s = new Service();
				Random r = new Random();
				int num = r.nextInt(9999);
				System.out.println(num);
				s.sendMail(email, num);
				request.setAttribute("email", email);
				request.setAttribute("otp", num);
				request.getRequestDispatcher("verify-otp.jsp").forward(request, response);
			}
			else {
				
			}
		}
		else if (action.equalsIgnoreCase("verify")) {
			String email = request.getParameter("email");
			int otp1 = Integer.parseInt(request.getParameter("otp1"));
			int otp2 = Integer.parseInt(request.getParameter("otp2"));
			if (otp1 == otp2) {
				request.setAttribute("email", email);
				request.getRequestDispatcher("new-password.jsp").forward(request, response);
			} else {
				request.setAttribute("email", email);
				request.setAttribute("otp", otp1);
				request.setAttribute("msg","otp is not matched");
				request.getRequestDispatcher("verify-otp.jsp").forward(request, response);
			}
		}
		else if (action.equalsIgnoreCase("Update Password")) {
			String email = request.getParameter("email");
			String np = request.getParameter("np");
			String cnp = request.getParameter("cnp");
			if (np.equals(cnp)) {
				StudentDao.changeNewPassword(email, np);
				response.sendRedirect("login.jsp");
			}
			else {
				request.setAttribute("email", email);
				request.setAttribute("msg1", "new password and confirm new password is not matched");
				request.getRequestDispatcher("new-password.jsp").forward(request, response);
			}
		}
	}

}
