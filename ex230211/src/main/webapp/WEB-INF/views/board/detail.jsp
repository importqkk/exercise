<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
<!-- 좋아요 모듈 -->
<script src="/js/board-like.min.js"></script>
<!-- 댓글 모듈 -->
<script src="/js/board-comment.js"></script>
<style>
    .fa-heart,
    .fa-trash {
        color: #f75d86;
        cursor: pointer;
    }
    .fa-comment,
    .fa-edit {
        color: #4431bf;
    }
    .ti-eye {
        font-size: larger;
    }
    .content-box {
        min-height: 10vh;
    }
    [name=commentContent],
    .edit-box {
    	min-height: 80px;
    	resize: none;
    }
</style>
<script type="text/javascript">
	var memberID = "${sessionScope.memberID}";
	var boardWriter = "${boardDto.boardWriter}";
	
    $(function() {
        $(".delete-btn").click(function() {
            var result = confirm("정말 삭제하시겠습니까?");
            if(!result) return false;
        })
    })
</script>
<script type="text/template" id="comment-template">
	<div class="comment-item">
        <div class="flex pb-10 pt-30">
            <div class="commentWriter w-50">작성자 닉네임</div>
            <div class="commentTime w-50 right">2023-04-14</div>
        </div>
		<div class="commentContent">?</div>
		<div class="manageBtns right pb-30" style="border-bottom:0.5px solid grey;"></div>
	</div>
</script>

    <div class="container-800">
        <div class="row">
            <h2>[${boardDto.boardCategory}] ${boardDto.boardTitle}</h2>
        </div>
        <div class="row flex">
            <div class="me-15">
                no.${boardDto.boardNo}
            </div>
            <div class="me-15">
                |
            </div>
            <div class="me-15">
                ${boardDto.boardWriter}
            </div>
            <div class="me-15">
                |
            </div>
            <div class="me-15">
                <fmt:formatDate value="${boardDto.boardDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
            </div>
            <div class="me-15">
                |
            </div>
            <div class="flex" style="align-items: center;">
                <i class="ti ti-eye me-5"></i> ${boardDto.boardView}
            </div>
        </div>
        <div class="row">
            <hr>
        </div>
        <div class="row content-box p-10">
			${boardDto.boardContent}
        </div>
        <div class="row">
            <hr>
        </div>
        <div class="flex row">
            <div class="flex w-50">
                <div class="me-15">
                    <i class="fa-heart"></i>
                    <span class="heart-count">${boardDto.boardLike}</span>
                </div>
                <div>
                    <i class="fa-regular fa-comment"></i>
                    <span>${boardDto.boardComment}</span>
                </div>
            </div>
            <div class="flex w-50 right">
	            <c:if test="${owner}">
	                <a href="/board/edit?boardNo=${boardDto.boardNo}" class="link edit-btn me-15">수정</a>
                </c:if>
                <c:if test="${boardDto.boardCategory != '공지' && !owner}">
                	<a href="/board/post?boardParent=${boardDto.boardNo}" class="link re-btn me-15">답글달기</a>
                </c:if>
                <c:if test="${owner || admin}">
                	<a href="/board/delete?boardNo=${boardDto.boardNo}" class="link delete-btn warning">삭제</a>
                </c:if>
                <c:if test="${!admin && !owner}">
                	<a href="#" class="link report-btn warning">신고</a>
                </c:if>
            </div>
        </div>
        <div class="row comment-list pb-20">
            <!-- 댓글 목록 위치 -->
            댓글 목록 위치
        </div>
        <div class="row">
        	<div class="row">
	            <c:choose>
	            	<c:when test="${sessionScope.memberID != null}">
	            		<textarea class="form-input small w-100" name="commentContent" placeholder="댓글을 입력하세요."></textarea>
	            	</c:when>
	            	<c:otherwise>
	            		<textarea class="form-input small w-100" name="commentContent" placeholder="로그인한 회원만 댓글을 작성할 수 있습니다." disabled></textarea>
	            	</c:otherwise>
	            </c:choose>
	        </div>
	        <c:if test="${sessionScope.memberID != null}">
	        	<div class="row right">
	        		<button type="button" class="form-btn positive small comment-btn w-10">댓글 쓰기</button>
	        	</div>
	        </c:if>
        </div>
        <div class="row flex">
            <a href="/board/list" class="form-btn small neutral w-10 me-15">목록보기</a>
            <a href="/board/post" class="form-btn small neutral w-10">새글쓰기</a>
        </div>
    </div>
	
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
