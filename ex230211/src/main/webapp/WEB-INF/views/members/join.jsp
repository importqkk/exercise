<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
<!-- 회원가입 유효성 검사 -->
<script src="/js/member-join-checker.js"></script>
<!-- LightPick -->
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/lightpick@1.6.2/css/lightpick.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/lightpick@1.6.2/lightpick.min.js"></script>
<script src="/js/date-picker.js"></script>

<style>
    .icon {
        font-size: 9px;
        color: #4431bf;
        vertical-align: text-top;
    }
</style>

	<form class="join-form" action="join" method="post" enctype="multipart/form-data" autocomplete="off">
        <div class="container-450">
            <div class="row center">
                <h1 class="title">회원가입</h1>
            </div>
            <div class="row">
                <h4 class="title"><i class="fa-regular fa-asterisk icon"></i>표는 필수 입력입니다.</h4>
            </div>
            <div class="row">
                <label class="form-lable">프로필 이미지</label>
                <input class="form-input medium w-100 valid" type="file" name="attach">
            </div>
            <div class="row">
                <label class="form-lable">아이디<i class="fa-regular fa-asterisk icon"></i></label>
                <input class="form-input medium w-100 form-regex" type="text" name="memberID" data-regex="^[a-z0-9-_]{5,20}$">
                <div class="valid-message">사용할 수 있는 아이디입니다.</div>
                <div class="invalid-message1">아이디는 영문 소문자와 숫자, _를 포함한 5~20자입니다.</div>
                <div class="invalid-message2">이미 사용중인 아이디 입니다.</div>
            </div>
            <div class="row">
                <label class="form-lable">비밀번호<i class="fa-regular fa-asterisk icon"></i></label>
                <input class="form-input medium w-100 form-regex" type="password" name="memberPW" data-regex="^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*?=+_-])[A-Za-z0-9!@#$%^&*?=+_-]{8,16}$">
                <div class="valid-message">올바른 비밀번호 형식입니다.</div>
                <div class="invalid-message1">비밀번호는 영문 대/소문자, 숫자, 특수문자를 1개 이상 포함한 8~16자입니다.</div>
            </div>
            <div class="row">
                <label class="form-lable">비밀번호 확인<i class="fa-regular fa-asterisk icon"></i></label>
                <input class="form-input medium w-100" type="password" id="memberPWCheck">
                <div class="invalid-message1">비밀번호가 일치하지 않습니다.</div>
                <div class="invalid-message2">비밀번호를 입력하세요.</div>
            </div>
            <div class="row">
                <label class="form-lable">닉네임<i class="fa-regular fa-asterisk icon"></i></label>
                <input class="form-input medium w-100 form-regex" type="text" name="memberNick" data-regex="^[가-힣0-9]{2,10}$">
                <div class="valid-message">사용할 수 있는 닉네임입니다.</div>
                <div class="invalid-message1">닉네임은 한글과 숫자로 이루어진 2~10자입니다.</div>
                <div class="invalid-message2">이미 사용중인 닉네임 입니다.</div>
            </div>
            <div class="row">
                <label class="form-lable">이메일<i class="fa-regular fa-asterisk icon"></i></label>
                <input class="form-input medium w-100 form-regex" type="email" name="memberEmail" data-regex=".+@.+">
                <div class="invalid-message1">유효하지 않은 이메일 형식입니다.</div>
            </div>
            <div class="row">
                <label class="form-lable">성<i class="fa-regular fa-asterisk icon"></i></label>
                <input class="form-input medium w-100 form-regex" type="text" name="memberLastName" data-regex="^[가-힣]{1,2}$">
                <div class="invalid-message1">성을 올바르게 입력해주세요.</div>
            </div>
            <div class="row">
                <label class="form-lable">이름<i class="fa-regular fa-asterisk icon"></i></label>
                <input class="form-input medium w-100 form-regex" type="text" name="memberFirstName" data-regex="^[가-힣]{1,5}$">
                <div class="invalid-message1">이름을 올바르게 입력해주세요.</div>
            </div>
            <div class="row">
                <label class="form-lable">전화번호</label>
                <input class="form-input medium w-100 form-regex" type="tel" name="memberTel" placeholder="010XXXXXXXX" data-regex="^010[1-9][0-9]{7}$">
                <div class="invalid-message1">유효하지 않은 전화번호 형식입니다.</div>
            </div>
            <div class="row">
                <label class="form-lable">생년월일</label>
                <input class="form-input medium w-100 date-picker valid" type="text" name="memberBirth">
            	<div class="invalid-message1">생년월일을 올바르게 입력해주세요.</div>
            </div>
            <div class="row">
                <button class="form-btn medium positive w-100">회원가입</button>
            </div>
        </div>
    </form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
