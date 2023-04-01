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

    <div class="container-800">
        <div class="row pb-20">
            <h1 class="title">${membersDto.memberNick}님, 안녕하세요.</h1>
        </div>
        <div class="flex">
            <div class="w-25 me-40" style="position: relative; border-right: 0.5px solid rgb(169, 169, 169)">
                <div class="row">
                    <h3><a class="link" href="/members/PWCheck">개인정보 변경</a></h3>
                </div>
                <div class="row">
                    <h3><a class="link" href="/members/changePW">비밀번호 변경</a></h3>
                </div>
                <div class="row" style="position: absolute; bottom: 0; padding-bottom: 0.3em;">
                    <a class="link" href="/members/leave" style="font-size: x-small; color: rgb(169, 169, 169)">회원 탈퇴</a>
                </div>
            </div>
            <div class="w-75">
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
                                <th class="w-30">아이디</th>
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
                                <th>아이디</th>
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
