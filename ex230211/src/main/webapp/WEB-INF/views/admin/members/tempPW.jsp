<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

	<div class="container-450">
        <div class="row pb-40 center">
            <h1 class="title">임시비밀번호 발급</h1>
        </div>
        <div class="row pb-40 center">
            <h3>임시 비밀번호가 회원님의 이메일로 전송되었습니다.</h3>
            <h3>로그인 즉시 비밀번호 변경 안내해주세요.</h3>
        </div>
        <div class="row center">
            <a class="form-btn neutral medium w-100" href="/admin/members/list">목록으로</a>
        </div>
    </div>
	
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
