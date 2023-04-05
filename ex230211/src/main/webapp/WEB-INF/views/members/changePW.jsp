<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
<!-- 회원가입 유효성 검사 -->
<script src="/js/change-pw-checker.js"></script>

	<form action="changePW" method="post" class="change-PW-form">
		<div class="container-450">
	        <div class="row center">
	            <h1 class="title">비밀번호 변경</h1>
	        </div>
	        <div class="row">
	            <label class="form-label">현재 비밀번호</label>
	            <input class="form-input large w-100" type="password" name="currentPW">
	        </div>
	        <div class="row">
	            <label class="form-label">변경할 비밀번호</label>
	            <input class="form-input large w-100" type="password" name="newPW">
	            <div class="invalid-message1">비밀번호는 영문 대/소문자, 숫자, 특수문자를 1개 이상 포함한 8~16자입니다.</div>
	        </div>
	        <div class="row">
	            <label class="form-label">비밀번호 확인</label>
	            <input class="form-input large w-100" type="password" id="checkPW">
	            <div class="invalid-message1">비밀번호가 일치하지 않습니다.</div>
                <div class="invalid-message2">비밀번호를 입력하세요.</div>
	        </div>
	        <c:if test="${param.mode == 'error'}">
		        <div class="row center pt-10 pb-10">
		            <h4 style="color: #c10e0e;">비밀번호가 일치하지 않습니다.</h4>
		        </div>
	        </c:if>
	        <div class="row">
	            <button class="form-btn large positive w-100">변경</button>
	        </div>
	        <div class="row center pb-10">
	            <a class="link form-btn large neutral w-100" href="/members/mypage">마이페이지</a>
	        </div>
	    </div>
	</form>
	
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
