package Controller.admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.KhachhangBo;
import bo.dathangBo;
import util.AccountUtil;

/**
 * Servlet implementation class qlydathangController
 */
@WebServlet("/admin/order-detail")
public class qlydathangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public qlydathangController() {
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
				dathangBo dh = new dathangBo();
				String mahd = request.getParameter("orderId");
				if (request.getParameter("ODId") != null) {
					dh.chitiettthd(request.getParameter("ODId"));
					dh.thanhtoanHD(mahd);
				}
				request.setAttribute("orders", dh.getCTHD(mahd));
				request.getRequestDispatcher("/admin/order-detail.jsp").forward(request, response);
			} else
				response.sendRedirect(request.getContextPath() + "/login");

		} catch (SQLException | ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
