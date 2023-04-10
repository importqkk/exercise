<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
<!-- 개인정보 변경 유효성 검사 -->
<script src="/js/admin-member-info-checker.js"></script>
<!-- LightPick -->
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/lightpick@1.6.2/css/lightpick.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/lightpick@1.6.2/lightpick.min.js"></script>
<script src="/js/date-picker.js"></script>

	<form class="change-form" action="changeInfo" method="post" enctype="multipart/form-data" autocomplete="off">
        <div class="container-450">
            <div class="row center">
                <h1 class="title">회원정보 변경</h1>
            </div>
            <div class="row">
                <h4 class="title"><i class="fa-regular fa-asterisk icon"></i>표는 필수 입력입니다.</h4>
            </div>
            <div class="row">
                <label class="form-lable">아이디<i class="fa-regular fa-asterisk icon"></i></label>
                <input class="form-input medium w-100 form-regex" type="text" name="memberID" value="${membersDto.memberID}" readonly>
            </div>
            <div class="row">
                <label class="form-lable">닉네임<i class="fa-regular fa-asterisk icon"></i></label>
                <input class="form-input medium w-100 form-regex" type="text" name="memberNick" value="${membersDto.memberNick}">
                <div class="valid-message">사용할 수 있는 닉네임입니다.</div>
                <div class="invalid-message1">닉네임은 한글과 숫자로 이루어진 2~10자입니다.</div>
                <div class="invalid-message2">이미 사용중인 닉네임 입니다.</div>
            </div>
            <div class="row">
                <label class="form-lable">이메일<i class="fa-regular fa-asterisk icon"></i></label>
                <input class="form-input medium w-100 form-regex" type="email" name="memberEmail" value="${membersDto.memberEmail}">
                <div class="invalid-message1">유효하지 않은 이메일 형식입니다.</div>
            </div>
            <div class="row">
                <label class="form-lable">성<i class="fa-regular fa-asterisk icon"></i></label>
                <input class="form-input medium w-100 form-regex" type="text" name="memberLastName" value="${membersDto.memberLastName}">
                <div class="invalid-message1">성을 올바르게 입력해주세요.</div>
            </div>
            <div class="row">
                <label class="form-lable">이름<i class="fa-regular fa-asterisk icon"></i></label>
                <input class="form-input medium w-100 form-regex" type="text" name="memberFirstName" value="${membersDto.memberFirstName}">
                <div class="invalid-message1">이름을 올바르게 입력해주세요.</div>
            </div>
            <div class="row">
                <label class="form-lable">전화번호</label>
                <input class="form-input medium w-100 form-regex" type="tel" name="memberTel" placeholder="010XXXXXXXX" value="${membersDto.memberTel}">
                <div class="invalid-message1">유효하지 않은 전화번호 형식입니다.</div>
            </div>
            <div class="row">
                <label class="form-lable">생년월일</label>
                <input class="form-input medium w-100 date-picker valid" type="text" name="memberBirth" value="${membersDto.memberBirth}">
            	<div class="invalid-message1">생년월일을 올바르게 입력해주세요.</div>
            </div>
            <div class="row">
                <label class="form-lable">포인트 (기존: ${membersDto.memberPoint} point)</label>
                <input class="form-input medium w-100 valid" type="text" name="memberPoint" value="${membersDto.memberPoint}">
            	<div class="invalid-message1">0 이상의 숫자를 입력해주세요.</div>
            </div>
            <div class="row">
                <label class="form-lable">등급</label>
                <c:choose>
                	<c:when test="${membersDto.memberLevel == 'admin'}">
                		<select class="form-input medium w-100 valid" name="memberLevel">
		                	<option>bronze</option>
		                	<option>silver</option>
		                	<option>gold</option>
		                	<option>platinum</option>
		                	<option selected>admin</option>
		                </select>
                	</c:when>
                	<c:when test="${membersDto.memberLevel == 'platinum'}">
                		<select class="form-input medium w-100 valid" name="memberLevel">
		                	<option>bronze</option>
		                	<option>silver</option>
		                	<option>gold</option>
		                	<option selected>platinum</option>
		                	<option>admin</option>
		                </select>
                	</c:when>
                	<c:when test="${membersDto.memberLevel == 'gold'}">
                		<select class="form-input medium w-100 valid" name="memberLevel">
		                	<option>bronze</option>
		                	<option>silver</option>
		                	<option selected>gold</option>
		                	<option>platinum</option>
		                	<option>admin</option>
		                </select>
                	</c:when>
                	<c:when test="${membersDto.memberLevel == 'silver'}">
                		<select class="form-input medium w-100 valid" name="memberLevel">
		                	<option>bronze</option>
		                	<option selected>silver</option>
		                	<option>gold</option>
		                	<option>platinum</option>
		                	<option>admin</option>
		                </select>
                	</c:when>
                	<c:otherwise>
                		<select class="form-input medium w-100 valid" name="memberLevel">
		                	<option selected>bronze</option>
		                	<option>silver</option>
		                	<option>gold</option>
		                	<option>platinum</option>
		                	<option>admin</option>
		                </select>
                	</c:otherwise>
                </c:choose>
            	<div class="invalid-message1">올바른 등급을 선택해주세요.</div>
            </div>
            <div class="row">
                <button class="form-btn medium positive w-100">변경</button>
            </div>
            <div class="row">
                <a class="form-btn medium neutral w-100" href="/admin/members/detail?memberID=${membersDto.memberID}">회원상세</a>
            </div>
            <div class="row center">
                <a class="link" href="/admin/members/list">목록으로</a>
            </div>
        </div>
	</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
