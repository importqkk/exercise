<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

	<h2>임시비밀번호 발급이 완료되었습니다.</h2>
	발급된 임시비밀번호는 회원 정보에 등록된 이메일을 통해 발송되었습니다.
	
	<br><br><br>
	
	<a href="/admin/members/list">목록으로</a>


<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
