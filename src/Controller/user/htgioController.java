package Controller.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.GiohangBo;
import util.AccountUtil;

/**
 * Servlet implementation class htgioController
 */
@WebServlet(urlPatterns = { "/cart", "/handle-cart" })

public class htgioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public htgioController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURI();
		GiohangBo gh = null;
		HttpSession session = request.getSession();
		if (session.getAttribute("username") != null) {
			AccountUtil.getUser(request);
		}
		if (session.getAttribute("cart") == null) {// value
			gh = new GiohangBo();
			session.setAttribute("cart", gh);
		}
		if (request.getParameter("mg") != null) {
			String magiay = request.getParameter("mg");
			String tengiay = request.getParameter("tg");
			String anh = request.getParameter("anh");
			long gia = Long.parseLong(request.getParameter("gia"));
			long soluong = 1;
			gh = (GiohangBo) session.getAttribute("cart");
			gh.Them(magiay, tengiay, soluong, gia, anh);
			session.setAttribute("cart", gh);
		}
		if (url.contains("/cart")) {
			if (session.getAttribute("username") != null)
				request.setAttribute("username", session.getAttribute("username").toString());
			if (request.getParameter("message") != null) {
				if (request.getParameter("message").equals("logout")) {
					session.removeAttribute("username");
				}
			}
			GiohangBo cartBo = (GiohangBo) session.getAttribute("cart");
			request.setAttribute("cartItems", cartBo.ds);
			request.setAttribute("count", cartBo.ds.size());
			long totalPrice = cartBo.ds.stream().mapToLong(value -> value.getThanhtien()).sum();
			request.setAttribute("totalPrice", totalPrice);
			long discount = 0;
			request.setAttribute("discount", discount);
			request.setAttribute("subTotal", totalPrice - discount);
			request.getRequestDispatcher("show-cart.jsp").forward(request, response);
		}
		if (url.contains("/handle-cart")) {
			response.sendRedirect(request.getContextPath() + "/cart");
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
