<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>HR Tables</h1>

<p>모든 테이블의 목록을 출력한다</p>

<%
// java 영역 //자바코드 안에 
Class.forName("oracle.jdbc.driver.OracleDriver");

String url = "jdbc:oracle:thin:@192.168.7.44:1521:xe"; //localhost 말고 자기 ip -테이블 변화 구별위해
String user = "hr";
String password = "hr";

Connection conn = DriverManager.getConnection(url, user, password);

String sql = "SELECT * FROM TAB";
PreparedStatement psmt = conn.prepareStatement(sql);
ResultSet rs = psmt.executeQuery();			//executeUpdate는 나머지

ResultSetMetaData rsmd = rs.getMetaData();	// column 정보
int count = rsmd.getColumnCount();			// column 갯수	
%>

<table border="1">
	<tr>
		<%
		for(int i = 1; i < count + 1; i++) {
		%>	
			<th><%=rsmd.getColumnName(i) %></th>
		<%
		}
		%>
	</tr>
	
<%
while(rs.next()){
	%>
	<tr>
		<%
		for(int i = 1; i < count + 1; i++) {
			String cols = rs.getString(i);
		%>
			<td><%=cols %></td>
		<%
		}
		%>
	</tr>
	<%
}
%>
</table>

</body>
</html>