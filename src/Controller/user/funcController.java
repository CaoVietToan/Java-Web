package Controller.user;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.GiohangBo;

/**
 * Servlet implementation class funcController
 */
@WebServlet("/save-delete")
public class funcController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public funcController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		GiohangBo gh = (GiohangBo) session.getAttribute("cart");
		if (request.getParameterValues("check") != null) {
			String[] checkList = request.getParameterValues("check");
			for (String c : checkList) {
				gh.Delete(c);
			}
		} else {
			Enumeration<String> d = request.getParameterNames();
			while (d.hasMoreElements()) {
				String name = d.nextElement();
				String magiay = request.getParameter(name);
				if (name.equals("update-quantity")) {
					gh.update(magiay, Long.parseLong(request.getParameter(magiay)));
				}
				if (name.equals("delete"))
					gh.Delete(magiay);
			}
		}
		session.setAttribute("cart", gh);
		response.sendRedirect(request.getContextPath() + "/cart");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
