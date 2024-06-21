package Controller.user;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.giohangBean;
import bean.KhachHangBean;
import bean.dathangBean;
import bean.lichsuBean;
import bo.giayBo;
import bo.GiohangBo;
import bo.KhachhangBo;
import bo.dathangBo;

/**
 * Servlet implementation class thanhtoanController
 */
@WebServlet("/check-out")
public class thanhtoanController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public thanhtoanController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			if (KhachhangBo.isLogin(request)) {
				dathangBo dathangbo = new dathangBo();
				giayBo giaybo = new giayBo();
				HttpSession session = request.getSession();
				// Insert Order
				dathangBean dathangbean = new dathangBean();
				KhachHangBean khachhangbean = (KhachHangBean) session.getAttribute("customer");
				if (khachhangbean != null)
				dathangbean.setMakh(khachhangbean.getMakh());
				dathangbean.setNgaymua(new Date());
				long mahd = dathangbo.insertHD(dathangbean);
				GiohangBo giohangbo = (GiohangBo) session.getAttribute("cart");
				lichsuBean lichsubean = new lichsuBean();
				boolean flag = true;
				for (giohangBean st : giohangbo.ds) {
					lichsubean.setMagiay(st.getMaGiay());
					lichsubean.setMahd(mahd);
					lichsubean.setSoluong((int) st.getSoLuong());
					if (dathangbo.insertCTHD(lichsubean) > 0) {
						giaybo.updateQuantityShoes(lichsubean.getMagiay(), st.getSoLuong());
						session.removeAttribute("cart");
					} else {
						flag = false;
						break;
					}
				}
				if (flag)
					response.sendRedirect(request.getContextPath() + "/purchase?status=success");
				else
					response.sendRedirect(
							request.getContextPath() + "/purchase?status=fail&message=Insert Order Detail Failed!");
			} else {
				response.sendRedirect("login");
			}
		} catch (SQLException | IOException e) {
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
