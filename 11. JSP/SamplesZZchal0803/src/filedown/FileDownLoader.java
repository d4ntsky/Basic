package filedown;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PdsDao;

//webXML로...
public class FileDownLoader extends HttpServlet {
	
	//pdsupload와 getrealPath 이어지는곳
	ServletConfig mConfig = null;
	final int BUFFER_SIZE = 8192;

	
	//확인!			//getRealPath를 얻어오려면
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		mConfig = config;	// file 업로드 경로(path)를 취득하려는 목적
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//	System.out.println("FileDownLoader doGet()");	//확인용
	
		// filename과 sequence가 가져옴
		String filename = req.getParameter("filename");
		String sseq = req.getParameter("seq");
		int dlc	= Integer.parseInt(req.getParameter("seq"));
				
		
		// download 횟수를 증가(DB 접근)
		BufferedOutputStream out = new BufferedOutputStream(resp.getOutputStream());//데이터를 모아둘수 있는 공간
		
		String filePath = "";	//config로 한 이유
		
		// 1.tomcat(Server)
		filePath = mConfig.getServletContext().getRealPath("/upload");	//파일로 사라질 가능성...
		
		// 2.폴더(Client)
		// filePath = "d:\\tmp";
		
		filePath = filePath + "\\" + filename;
		System.out.println("filePath:" + filePath);
		
		File f = new File(filePath);
		
			if(f.exists() && f.canRead()) {
				
				// download window set - 다운로드 윈도우 화면
				resp.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\";"); //파일명 확인
				resp.setHeader("Content-Transfer-Encoding", "binary;");								 //전송.
				resp.setHeader("Content-Length", "" + f.length());									 //다운시 막대
				resp.setHeader("Pragma", "no-cache;"); 
				resp.setHeader("Expires", "-1;");			
				
				//파일 생성, 기입
				BufferedInputStream fileInput = new BufferedInputStream(new FileInputStream(f));
				
				byte buffer[] = new byte[BUFFER_SIZE];
				
				int read = 0;
				
				while((read = fileInput.read(buffer)) != -1) {
					out.write(buffer, 0, read);	//실제 다운로드			//!!!
				}
				//----------------------------------------------------------
				
				PdsDao dao = PdsDao.getInstance();
				dao.downcount(dlc);
				
				//----------------------------------------------------------
				fileInput.close();									//!!!
				out.flush();										//!!! 중요 부분
			}
			
			
		}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	
}
