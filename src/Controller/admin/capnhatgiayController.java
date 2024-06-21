package Controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import bo.HangGiayBo;
import bo.LoaiGiayBo;
import bo.giayBo;
import dao.KetNoiDao;

/**
 * Servlet implementation class capnhatgiayController
 */
@WebServlet(urlPatterns = { "/admin/shoes/save"})
public class capnhatgiayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public capnhatgiayController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		try {
			List<FileItem> fileItems = upload.parseRequest(request);// Lấy về các đối tượng gửi lên
			// duyệt qua các đối tượng gửi lên từ client gồm file và các control
			for (FileItem fileItem : fileItems) {
				if (!fileItem.isFormField()) {// Nếu ko phải các control=>upfile lên
					// xử lý file
					String nameimg = fileItem.getName();
					if (!nameimg.equals("")) {
						// Lấy đường dẫn hiện tại, chủ ý xử lý trên dirUrl để có đường dẫn đúng
						String dirUrl = request.getServletContext().getRealPath("image_giay") + File.separator;
						File dir = new File(dirUrl);
						if (!dir.exists()) {// nếu ko có thư mục thì tạo ra
							dir.mkdir();
						}
						String fileImg = dirUrl + nameimg;
						System.out.println(fileImg);
						File file = new File(fileImg);// tạo file
						try {
							fileItem.write(file);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}

		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		KetNoiDao kn = new KetNoiDao();
		kn.getConnection();
		String maGiay = request.getParameter("maGiay");
		String tenGiay = request.getParameter("tenGiay");
		String mota = request.getParameter("mota");
		String gia = request.getParameter("gia");
		String anh = request.getParameter("anh");
		String maLoai = request.getParameter("maLoai");
		String maHang = request.getParameter("maHang");
		String maGT = request.getParameter("gioiTinh");
		String soLuong = request.getParameter("soLuong");
		LoaiGiayBo loaigiayBo = new LoaiGiayBo();
		request.setAttribute("loai1", loaigiayBo.getLoai());
		HangGiayBo hanggiayBo = new HangGiayBo();
		request.setAttribute("hang1", hanggiayBo.getHang());
		if(maGiay != null && tenGiay != null && soLuong != null&& mota != null&& gia != null&& maLoai != null&& anh != null&&maHang!=null&&maGT!=null) {
			long sl = Long.parseLong(soLuong);
			long price = Long.parseLong(gia);
			giayBo sb = new giayBo();
			try {
				String message = "";
				String status = "";
				if (sb.addGiay(maGiay, tenGiay, sl, mota, price, anh, maLoai,maHang,maGT) > 0) {
					status = "success";
					message = "Add new book is success!";
				} else {
					status = "danger";
					message = "Add new book is failed!";
				}
				response.sendRedirect(request.getContextPath() + "/admin/shoes?message=" + message + "&status=" + status);
				return;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String url = request.getRequestURI();
		if (url.contains("/save")) {
			request.getRequestDispatcher("/admin/shoes-save.jsp").forward(request, response);
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
