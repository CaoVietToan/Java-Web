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
import bo.dathangBo;
import util.AccountUtil;

/**
 * Servlet implementation class lichsuController
 */
@WebServlet("/payment")
public class lichsuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public lichsuController() {
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

				request.setAttribute("orders",
						dh.getHD_makh(((KhachHangBean) session.getAttribute("customer")).getMakh()));
				if (request.getParameter("status") != null) {
					if (request.getParameter("status").equals("success")) {
						request.setAttribute("message", "Order Success");
						request.setAttribute("status", "success");
					}
					if (request.getParameter("status").equals("fail")) {
						request.setAttribute("message", request.getParameter("message"));
						request.setAttribute("status", "danger");
					}
				}
				request.getRequestDispatcher("order.jsp").forward(request, response);
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
