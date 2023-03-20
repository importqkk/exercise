<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
<style>
    span {
        display: inline-block;
    }
    .leave-btn {
        border: none;
        background-color: white;
        color: gray;
        font-size: x-small;
        cursor: pointer;
    }
    .leave-btn[disabled],
    .leave-btn[disabled]:hover {
        font-weight: normal;
        cursor: unset;
    }
    .leave-btn:hover {
        font-weight: bold;
    }
</style>
<script type="text/javascript">
    $(function() {
        $(".leave-btn").prop("disabled", true);
        $("[name=memberPW").on("input", function() {
            var isTyped = $("[name=memberPW").val().length > 0;
            if(isTyped) $(".leave-btn").prop("disabled", false);
            else $(".leave-btn").prop("disabled", true);
        })
       	var params = new URLSearchParams(location.search);
		var mode = params.get("mode");
		if(mode == "error") {
	        $(".leave-btn").click(function() {
	            var result = confirm("회원 탈퇴시 모든 정보가 삭제되며 되돌릴 수 없습니다.\n정말 탈퇴하시겠습니까?");
	            if(!result) return false;
	            else {
	                var result = confirm("정말정말 탈퇴하시겠습니까?");
	                if(!result) return false;
	                else {
	                    var result = confirm("진짜진짜로?");
	                    if(!result) return false;
	                    else {
	                        alert("안녕히 가세요..")
	                    }
	                }
	            }
	        })
		}
    });
</script>

    <div class="container-450">
    	<form action="leave" method="post">
	        <div class="row center pb-20">
	            <h1 class="title">회원 탈퇴</h1>
	        </div>
	        <div class="row center">
	            <span>본인 확인을 위해 비밀번호를 입력해주세요.</span>
	            <span style="color: #c10e0e;">회원 탈퇴 후에는 되돌릴 수 없습니다.</span>
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
	            <a class="form-btn large positive w-100" href="/members/mypage">마이페이지</a>
	        </div>
	        <div class="row center pb-10">
	            <button type="submit" class="leave-btn">회원 탈퇴</button>
	        </div>
    	</form>
    </div>
	
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
