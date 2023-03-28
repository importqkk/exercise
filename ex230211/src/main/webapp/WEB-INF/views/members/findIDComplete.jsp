<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

	<div class="container-450">
        <div class="row pb-40 center">
            <h1 class="title">아이디 찾기</h1>
        </div>
        <div class="row pb-40 center">
            <h3>회원님의 아이디는 ${findID} 입니다.</h3>
        </div>
        <div class="row center">
            <a class="form-btn positive medium w-100" href="/members/login">로그인</a>
        </div>
        <div class="row center">
            <a class="form-btn neutral medium w-100" href="/">메인으로</a>
        </div>
    </div>
	
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
