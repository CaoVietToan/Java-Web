package Controller.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.KhachHangBean;
import bo.TaiKhoanBo;
import bo.KhachhangBo;
import dao.KetNoiDao;

/**
 * Servlet implementation class dangnhapController
 */
@WebServlet("/login")
public class dangnhapController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dangnhapController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String message = request.getParameter("message");
			String status = request.getParameter("status");
			if (message != null && status != null) {
				request.setAttribute("message", message);
				request.setAttribute("status", status);
			}
			request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("username") != null && request.getParameter("password") != null) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			KhachhangBo kh = new KhachhangBo();
			TaiKhoanBo tk = new TaiKhoanBo();
			KetNoiDao kn = new KetNoiDao();
			kn.getConnection();
			try {
				HttpSession session = request.getSession();
				if (tk.checkAdminLogin(username, password) != null) {
					session.setAttribute("username", "ADMIN");
					session.setMaxInactiveInterval(24 * 60 * 60);
					response.sendRedirect(request.getContextPath() + "/admin/order");
				} else if (kh.checkLogin(username, password) != null) {
					KhachHangBean khbean = kh.checkLogin(username, password);
					session.setAttribute("username", khbean.getHoten());
					session.setAttribute("customer", khbean);
					session.setMaxInactiveInterval(24 * 60 * 60);
					response.sendRedirect(request.getContextPath() + "/home");
				} else {
					request.setAttribute("report", "failed");
					doGet(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
