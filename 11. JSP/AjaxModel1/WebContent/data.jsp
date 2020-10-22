<%@page import="java.util.Spliterator"%>
<%@page import="dto.CustUserDto"%>
<%@page import="java.util.List"%>
<%@page import="dao.CustUserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
CustUserDao dao = CustUserDao.getInstance();//class가 생성되는 시점
List<CustUserDto> list = dao.getCustUserList();

//값이 NULL이 되면.........................

String json;

out.println("[");
for(int i = 0; i < list.size()-1; i++) {
	CustUserDto cust = list.get(i);
	
	json = "{ \"id\":\"" + cust.getId() + "\", \"name\":\"" + cust.getName() + "\", \"address\":\"" + cust.getAddress() + "\" },";
	
	
	out.println(json);
}

for(int i = list.size()-1; i < list.size(); i++) {
	CustUserDto cust = list.get(i);
	
	json = "{ \"id\":\"" + cust.getId() + "\", \"name\":\"" + cust.getName() + "\", \"address\":\"" + cust.getAddress() + "\" }";
	
	
	out.println(json);
}
out.println("]");
%>

