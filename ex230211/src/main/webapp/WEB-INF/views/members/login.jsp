<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
	
	<form action="login" method="post">
		<div class="container-450">
		    <div class="row center">
		        <h1 class="title">로그인</h1>
		    </div>
		    <div class="row">
		        <label class="form-label">아이디</label>
		        <input class="form-input large w-100" type="text" name="memberID" required>
		    </div>
		    <div class="row">
		        <label class="form-label">비밀번호</label>
		        <input class="form-input large w-100" type="password" name="memberPW" required>
		    </div>
		    <c:if test="${param.mode == 'error'}">
			    <div class="row center pt-10 pb-10">
			    	<h4 style="color: #c10e0e;">로그인 정보가 일치하지 않습니다.</h4>
			    </div>
		    </c:if>
		    <div class="row">
		        <button class="form-btn large positive w-100">로그인</button>
		    </div>
		    <div class="row center pt-20">
		        <a class="link" href="/members/findID">아이디 찾기</a> | 
		        <a class="link" href="/members/findPW">비밀번호 찾기</a>
		    </div>
		    <div class="row center">
		        <a class="link" href="/members/join">회원가입</a>
		    </div>
		</div>
	</form>
	
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
