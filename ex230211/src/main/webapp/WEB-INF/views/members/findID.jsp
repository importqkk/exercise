<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

	<form action="findID" method="post">
		<div class="container-450">
	        <div class="row center">
	            <h1 class="title">아이디 찾기</h1>
	        </div>
	        <div class="row">
	            <label class="form-label">닉네임</label>
	            <input class="form-input large w-100" type="text" name="memberNick">
	        </div>
	        <div class="row">
	            <label class="form-label">이메일</label>
	            <input class="form-input large w-100" type="email" name="memberEmail">
	        </div>
	        <c:if test="${param.mode == 'error'}">
		        <div class="row center pt-10 pb-10">
		            <h4 style="color: #c10e0e;">회원 정보가 일치하지 않습니다.</h4>
		        </div>
	        </c:if>
	        <div class="row">
	            <button class="form-btn large positive w-100">아이디 찾기</button>
	        </div>
	        <div class="row center pb-10">
	            <a class="link form-btn large neutral w-100" href="/members/login">로그인</a>
	        </div>
	        <div class="row center">
	            <a class="link" href="/members/join">회원가입</a>
	        </div>
	    </div>
	</form>
	
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
