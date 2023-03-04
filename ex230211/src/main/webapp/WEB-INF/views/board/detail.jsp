<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

	<table border="0" width="700">
		<tbody>
			<tr>
				<td>
					<h2>
						[${boardDto.boardCategory}]
						${boardDto.boardTitle}
					</h2>
				</td>
			</tr>
			<tr>
				<td>
					번호 ${boardDto.boardNo} |
					작성자 ${boardDto.boardWriter} | 
					작성일 <fmt:formatDate value="${boardDto.boardDate}" pattern="yyyy-MM-dd HH:mm:ss"/> |
					조회 ${boardDto.boardView}
				</td>
			</tr>
			<tr>
				<td height="300" valign="top">
					<c:if test="${image != null}">
						<img src="/attachment/download?attachmentNo=${image.attachmentNo}"><br>
					</c:if>
					${boardDto.boardContent}
				</td>
			</tr>
			<tr>
				<td>
					좋아요 ${boardDto.boardLike}
					댓글 ${boardDto.boardComment} | 
					<a href="#">신고</a>
				</td>
			</tr>
			<tr>
				<td>
					<a href="/board/post">새글쓰기</a>
					<c:if test="${boardDto.boardCategory != '공지'}">
						<a href="/board/post?boardParent=${boardDto.boardNo}">답글쓰기</a>
					</c:if>
					<c:if test="${owner}">
						<a href="/board/edit?boardNo=${boardDto.boardNo}">수정</a>
					</c:if>
					<c:if test="${owner || admin}">
						<a href="/board/delete?boardNo=${boardDto.boardNo}">삭제</a>
					</c:if>
				</td>
			</tr>
		</tbody>
	</table>
	
	<br><br>
	
	<a href="/board/list">게시판 목록</a>
	<a href="/">메인으로</a>
	
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
