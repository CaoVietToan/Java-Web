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
 * Servlet implementation class dathangAdController
 */
@WebServlet("/admin/order")
public class dathangAdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dathangAdController() {
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
					dathangBo orderBo = new dathangBo();
					request.setAttribute("orders", orderBo.getHD());
					request.getRequestDispatcher("/admin/order.jsp").forward(request, response);
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
