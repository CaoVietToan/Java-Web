package Controller.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.giayBean;
import bean.giayPT;
import bo.HangGiayBo;
import bo.LoaiGiayBo;
import bo.giayBo;
import dao.HangGiayDao;
import dao.KetNoiDao;
import util.AccountUtil;

/**
 * Servlet implementation class htgiayController
 */
@WebServlet("/home")
public class htgiayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public htgiayController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		KetNoiDao kn = new KetNoiDao();
		kn.getConnection();
		HttpSession session = request.getSession();
		if (session.getAttribute("username") != null) {
			AccountUtil.getUser(request);
		}
		if (request.getParameter("message") != null) {
			if (request.getParameter("message").equals("logout")) {
				session.removeAttribute("username");
				AccountUtil.removeUser(request);
				session.removeAttribute("customer");
			}
		}
		LoaiGiayBo loaigiayBo = new LoaiGiayBo();
		request.setAttribute("loai", loaigiayBo.getLoai());
		HangGiayBo hanggiayBo = new HangGiayBo();
		request.setAttribute("hang", hanggiayBo.getHang());
		giayBo giaybo = new giayBo();
		request.setAttribute("giay", giaybo.getGiay());
		giayBo giayBo = new giayBo();
		giayPT pt = new giayPT();
		List<giayBean> shoesList = new ArrayList<>();
		int page = Integer.parseInt((request.getParameter("page") != null) ? request.getParameter("page") : "1");
		pt = giayBo.getshoesPagination(page);
		shoesList = pt.getList();
		int endPage = pt.getTotalPage();
		request.setAttribute("p", page);
		if (page <= 2) {
			request.setAttribute("begin", 1);
			request.setAttribute("end", 5);
		} else if (page >= endPage - 2) {
			request.setAttribute("begin", page - 2);
			request.setAttribute("end", endPage);
		} else {
			request.setAttribute("begin", page - 2);
			request.setAttribute("end", page + 2);
		}

		String maloai = request.getParameter("loaiId");
		String search = request.getParameter("search");
		String mahang = request.getParameter("hangId");
		if (maloai != null) {
			pt = giayBo.findbyLoai(maloai, page);
			shoesList = pt.getList();
			request.setAttribute("begin", 1);
			request.setAttribute("end", pt.getTotalPage());
			request.setAttribute("maloai", maloai);
		} else if (search != null) {
			shoesList = giayBo.searchShoes(search);
			request.setAttribute("searchloai", 1);
		}
		if (mahang != null) {
			pt = giayBo.findbyHang(mahang, page);
			shoesList = pt.getList();
			request.setAttribute("begin", 1);
			request.setAttribute("end", pt.getTotalPage());
			request.setAttribute("mahang", mahang);
		} else if (search != null) {
			shoesList = giayBo.searchShoes(search);
			request.setAttribute("search", 1);
		}
		request.setAttribute("p", page);
		request.setAttribute("shoes", shoesList);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
