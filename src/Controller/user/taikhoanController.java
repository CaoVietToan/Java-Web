package Controller.user;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.KhachHangBean;
import bo.KhachhangBo;
import util.AccountUtil;

/**
 * Servlet implementation class taikhoanController
 */
@WebServlet(urlPatterns = { "/my-account", "/handle-account" })
public class taikhoanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public taikhoanController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			if (KhachhangBo.isLogin(request)) {
				HttpSession session = request.getSession();
				if (session.getAttribute("username") != null) {
					AccountUtil.getUser(request);
				}
				request.setAttribute("customer", session.getAttribute("customer"));
				request.getRequestDispatcher("my-account.jsp").forward(request, response);
			} else
				response.sendRedirect(request.getContextPath() + "/login");
		} catch (SQLException | IOException | ServletException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		KhachHangBean khbean = (KhachHangBean) session.getAttribute("customer");
		khbean.setHoten(request.getParameter("fullname"));
		khbean.setDiachi(request.getParameter("address"));
		khbean.setSdt(request.getParameter("phoneNumber"));
		khbean.setEmail(request.getParameter("email"));
		khbean.setPassword(request.getParameter("password"));
		KhachhangBo khbo = new KhachhangBo();
		if (khbo.update(khbean) > 0) {
			session.setAttribute("username", khbean.getHoten());
			session.setAttribute("customer", khbean);
			request.setAttribute("status", "success");
			request.setAttribute("message", "Update customer success!");
		} else {
			request.setAttribute("status", "danger");
			request.setAttribute("message", "Update customer failed!");
		}
		doGet(request, response);
	}

}
