<%@page import="dto.PdsDto"%>
<%@page import="dao.PdsDao"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="java.io.File"%>
<%@page import="java.io.IOException"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!
// upload 함수
public String processUploadFile(FileItem fileItem, String dir) throws IOException {	
						//매개변수 확인  		abc.txt			d:\tmp\	톰캣의 경로 dir은 경로 지정
	
	String filename = fileItem.getName();	// 경로 + 파일명
	long sizeInBytes = fileItem.getSize();
	
	//파일이 정상
	if(sizeInBytes > 0) {	// ex) d:\\tmp\\abc.txt				//0보다 크면 파일이 존재
									
		int idx = filename.lastIndexOf("\\");	// indexOf로 거꾸로 올라오면 abc.txt만 뽑아내려고
		
		if(idx == -1) {	//찾지 못한 경우 -파일의 상태는 d:/tmp/abc.txt로 되어있을 듯..
			idx = filename.lastIndexOf("/");
		}
		
		filename = filename.substring(idx + 1);	// 시작 위치만 정해줌	/나\\다음 첫번째 글자부터 끝까지 -> abc.txt
		
		File uploadFile = new File(dir, filename);
		
		try{
			fileItem.write(uploadFile);		// 실제 upload 부분
		}catch(Exception e){}
	}
	return filename;	// DB에 저장하기 위한 return
}
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pdsupload.jsp</title>
</head>
<body>

<%		//기능 부분
	//1. tomcat 배포(server에 업로드)	- 서버를 껐다켜면 자료가 없어질 수도 있음
String fupload = application.getRealPath("/upload"); //내장객체 - 무거워서 잘 안씀	//webcontent upload 폴더 생성
	
	//2. 지정 폴더(client)
//String fupload = "d:\\tmp";	//이건 프로젝트 할때

//-----------------------------------------
System.out.println("업로드 폴더: " + fupload);

String yourTempDir = fupload;

int yourMaxRequestSize = 100 * 1024 * 1024; 	// 1 Mbyte
int yourMaxMemorySize = 100 * 1024;				// 1 Kbyte

// form field의 데이터를 저장할 변수	id title content
String id = "";
String title = "";
String content = "";

// file
String filename = "";

boolean isMultipart = ServletFileUpload.isMultipartContent(request);
if(isMultipart == true) {
	
	// Fileitem 생성
	DiskFileItemFactory factory = new DiskFileItemFactory();
	
	factory.setSizeThreshold(yourMaxMemorySize);
	factory.setRepository(new File(yourTempDir));
	
	ServletFileUpload upload = new ServletFileUpload(factory);
	upload.setSizeMax(yourMaxRequestSize);
	
	List<FileItem> items = upload.parseRequest(request);		//파라미터로 들어가는 부분이 list로 넘어가는 부분
	Iterator<FileItem> it = items.iterator();
	
	// 구분
	while(it.hasNext()) {
		FileItem item = it.next();
		
		if(item.isFormField()) {	//id title content
			if(item.getFieldName().equals("id")) {
				id = item.getString("utf-8");
			}else if(item.getFieldName().equals("title")) {
				title = item.getString("utf-8");	
			}else if(item.getFieldName().equals("content")) {
				content = item.getString("utf-8");	
			}
			
		}else{						//fileload
			if(item.getFieldName().equals("fileload")) {
				filename = processUploadFile(item, fupload);
			}
		}
	}
}

// DB에 저장
PdsDao dao = PdsDao.getInstance();
boolean isS = dao.writePds(new PdsDto(id, title, content, filename));
if(isS == true) {
	%>
	<script type="text/javascript">
	alert("파일 업로드 성공");
	location.href = "pdslist.jsp";
	</script>
	<%
}else{
	%>
	<script type="text/javascript">
	alert("파일 업로드 실패");
	location.href = "pdslist.jsp";
	</script>
	<%
}
%>

</body>
</html>