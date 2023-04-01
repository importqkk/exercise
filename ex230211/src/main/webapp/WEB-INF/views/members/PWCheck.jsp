<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
<style>
    
</style>
<script type="text/javascript">
    $(function() {
        $(".confirm-btn").prop("disabled", true);
        $("[name=memberPW").on("input", function() {
            var isTyped = $("[name=memberPW").val().length > 0;
            if(isTyped) $(".confirm-btn").prop("disabled", false);
            else $(".confirm-btn").prop("disabled", true);
        })
    });
</script>

    <div class="container-450">
    	<form action="PWCheck" method="post">
	        <div class="row center pb-20">
	            <h1 class="title">개인정보 변경</h1>
	        </div>
	        <div class="row center">
	            <span>본인 확인을 위해 비밀번호를 입력해주세요.</span>
	        </div>
	        <div class="row">
	            <input type="password" name="memberPW" class="form-input large w-100">
	        </div>
	        <c:if test="${param.mode == 'error'}">
		        <div class="row center pt-10 pb-10">
		            <h4 style="color: #c10e0e;">비밀번호가 일치하지 않습니다.</h4>
		        </div>
	    	</c:if>
	        <div class="row">
	        	<button type="submit" class="form-btn large positive w-100 confirm-btn">비밀번호 인증</button>
	        </div>
	        <div class="row center pb-10">
	            <a class="form-btn large neutral w-100" href="/members/mypage">마이페이지</a>
	        </div>
    	</form>
    </div>
	
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
