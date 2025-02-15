package Controller.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bo.KhachhangBo;
import dao.KetNoiDao;

/**
 * Servlet implementation class dangkyController
 */
@WebServlet("/register")
public class dangkyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dangkyController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		KetNoiDao kn = new KetNoiDao();
		kn.getConnection();
		String fullName = request.getParameter("fullname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (fullName != null && username != null && password != null) {
			KhachhangBo kh = new KhachhangBo();
			try {
				String message = "";
				String status = "";
				if (kh.register(username, password, fullName) > 0) {
					status = "success";
					message = "Register is success! You can login";
				} else {
					status = "danger";
					message = "Register is failed!";
				}
				response.sendRedirect(request.getContextPath() + "/login?message=" + message + "&status=" + status);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
