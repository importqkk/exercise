<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
<style>
    .table > thead > tr > th,
    .table > thead > tr > td, 
    .table > tbody > tr > th, 
    .table > tbody > tr > td, 
    .table > tfoot > tr > th,
    .table > tfoot > tr > td {
        padding: 0.3em;
    }
</style>
<script type="text/javascript">
	$(function() {
		$(".tempPW").click(function() {
			var result = confirm("해당 회원의 이메일로 임시비밀번호를 발급합니다.");
			if(!result) return false;
		})
		$(".leave").click(function() {
			var result = confirm("해당 회원을 강제탈퇴합니다.");
			if(!result) return false;
			else {
				var result = confirm("강제탈퇴시에는 되돌릴 수 없습니다.\n정말 탈퇴시키겠습니까?");
				if(!result) return false;
			}
		})
	})
</script>

    <div class="container-800">
        <div class="flex">
        	<div class="w-25 me-40" style="position: relative; border-right: 0.5px solid rgb(169, 169, 169)">
                <div class="row">
                    <h3><a class="link" href="/admin/members/changeInfo?memberID=${membersDto.memberID}">회원정보 변경</a></h3>
                </div>
                <div class="row">
                    <h3><a class="link tempPW" href="/admin/members/tempPW?memberID=${membersDto.memberID}">임시비밀번호 발급</a></h3>
                </div>
                <div class="row">
                    <h3><a class="link leave" href="/admin/members/leave?memberID=${membersDto.memberID}">강제 탈퇴</a></h3>
                </div>
                <div class="row" style="position: absolute; bottom: 0; padding-bottom: 0.3em;">
                    <h3><a class="link" href="/admin/members/list">목록으로</a></h3>
                </div>
        	</div>
	        <div class="w-75">
	        	<div class="row pb-20">
		            <h1 class="title">${membersDto.memberNick}님의 상세정보</h1>
		        </div>
	        	<div>
		        	<c:choose>
			         	<c:when test="${profile != null}">
			        			<img class="profile-img big" src="/attachment/download?attachmentNo=${profile.attachmentNo}">
			            </c:when>
			            <c:otherwise>
							<img class="profile-img big" src="/images/defaultProfile.png">
						</c:otherwise>
					</c:choose>
		        </div>
		        <div class="row">
		            <table class="table small">
		                <tbody class="left">
		                    <tr>
		                        <th class="w-40">아이디</th>
		                        <td>${membersDto.memberID}</td>
		                    </tr>
		                    <tr>
		                        <th>닉네임</th>
		                        <td>${membersDto.memberNick}</td>
		                    </tr>
		                    <tr>
		                        <th>이메일</th>
		                        <td>${membersDto.memberEmail}</td>
		                    </tr>
		                    <tr>
		                        <th>이름</th>
		                        <td>${membersDto.memberLastName}${membersDto.memberFirstName}</td>
		                    </tr>
		                     <tr>
		                         <th>전화번호</th>
		                         <td>
		                         	<c:choose>
		                         		<c:when test="${membersDto.memberTel != null}">
		                         			${membersDto.memberTel}
		                         		</c:when>
		                         		<c:otherwise>
		                         			미입력
		                         		</c:otherwise>
		                         	</c:choose>
		                         </td>
		                     </tr>
		                     <tr>
		                         <th>생년월일</th>
		                         <td>
		                         	<c:choose>
		                         		<c:when test="${membersDto.memberBirth != null}">
		                         			${membersDto.memberBirth}
		                         		</c:when>
		                         		<c:otherwise>
		                         			미입력
		                         		</c:otherwise>
		                         	</c:choose>
		                         </td>
		                     </tr>
		                    <tr>
		                        <th>포인트</th>
		                        <td>
		                        	<fmt:formatNumber value="${membersDto.memberPoint}" pattern="#,##0 point"></fmt:formatNumber>
		                        </td>
		                    </tr>
		                    <tr>
		                        <th>등급</th>
		                        <td>${membersDto.memberLevel}</td>
		                    </tr>
		                    <tr>
		                        <th>가입일</th>
		                        <td>
		                        	<fmt:formatDate value="${membersDto.memberJoin}" pattern="yyyy-MM-dd"/>
		                        </td>
		                    </tr>
		                    <tr>
		                        <th>최종로그인</th>
		                        <td>
		                        	<fmt:formatDate value="${membersDto.memberLogin}" pattern="yyyy-MM-dd HH:mm:ss"/>
		                        </td>
		                    </tr>
		                </tbody>
		            </table>
		        </div>
	        </div>
        </div>
    </div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
