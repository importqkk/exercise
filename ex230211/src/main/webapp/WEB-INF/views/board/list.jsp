<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<script type="text/javascript">
    $(function() {
        $(".delete-btn").click(function() {
            var result = confirm("정말 삭제하시겠습니까?");
            if(!result) return false;
        })
    })
</script>

<form action="list" method="get">
	<div class="container-1000">
		<!-- 제목 -->
		<div class="row">
			<h1 class="title pb-20">QnA 게시판</h1>
		</div>
		<!-- 글쓰기버튼, 검색창 -->
		<div class="row" style="display: flex;">
			<!-- 등록버튼 -->
			<div class="left w-25">
				<a class="form-btn small positive w-50" href="/board/post">글쓰기</a>
			</div>
			<!-- 검색창 -->
			<div class="right w-75 pb-20">
				<!-- 카테고리 -->
				<c:choose>
					<c:when test="${vo.column == 'board_category'}">
						<select class="form-input small w-15" name="column">
							<option value="board_title">제목</option>
							<option value="board_content">내용</option>
							<option value="board_writer">작성자</option>
							<option value="board_category" selected>카테고리</option>
						</select>
					</c:when>
					<c:when test="${vo.column == 'board_writer'}">
						<select class="form-input small w-15" name="column">
							<option value="board_title">제목</option>
							<option value="board_content">내용</option>
							<option value="board_writer" selected>작성자</option>
							<option value="board_category">카테고리</option>
						</select>
					</c:when>
					<c:when test="${vo.column == 'board_content'}">
						<select class="form-input small w-15" name="column">
							<option value="board_title">제목</option>
							<option value="board_content" selected>내용</option>
							<option value="board_writer">작성자</option>
							<option value="board_category">카테고리</option>
						</select>
					</c:when>
					<c:otherwise>
						<select class="form-input small w-15" name="column">
							<option value="board_title" selected>제목</option>
							<option value="board_content">내용</option>
							<option value="board_writer">작성자</option>
							<option value="board_category">카테고리</option>
						</select>
					</c:otherwise>
				</c:choose>
				<!-- 검색창 -->
				<input class="form-input small w-40" type="text" name="keyword" placeholder="검색어를 입력하세요." value="${vo.keyword}">
				<!-- 검색버튼 -->
				<button class="form-btn small positive w-10" type="submit">검색</button>
			</div>
		</div>
		<!-- 목록 -->
		<div class="row">
			<table class="table table-row table-hover w-100">
				<thead>
					<tr>
						<th>번호</th>
						<th class="w-40">제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>좋아요</th>
						<th>조회수</th>
						<c:if test="${sessionScope.memberLevel == 'admin'}">
							<th>관리</th>
						</c:if>
					</tr>
				</thead>
				<tbody class="center">
					<c:forEach var="boardDto" items="${noticeList}">
						<tr style="background-color: #f5f7ff;">
							<td>${boardDto.boardNo}</td>
							<td class="left">
								<c:if test="${boardDto.boardCategory != null}">
	                            	[${boardDto.boardCategory}]
	                            </c:if>
	                            <a class="link" href="/board/detail?boardNo=${boardDto.boardNo}">
									${boardDto.boardTitle}
								</a>
								<c:if test="${boardDto.boardComment != 0}">
									(${boardDto.boardComment})
								</c:if>
							</td>
							<td>${boardDto.boardWriter}</td>
							<td>${boardDto.boardDateAuto}</td>
							<td>${boardDto.boardLike}</td>
							<td>${boardDto.boardView}</td>
							<c:if test="${sessionScope.memberLevel == 'admin'}">
								<td>
									<a class="link delete-btn" href="/board/delete?boardNo=${boardDto.boardNo}">삭제</a> | 
									<a class="link" href="/board/edit?boardNo=${boardDto.boardNo}">수정</a>
								</td>
							</c:if>
						</tr>
					</c:forEach>
					<c:forEach var="boardDto" items="${list}">
						<tr>
							<td>${boardDto.boardNo}</td>
							<td class="left">
								<c:if test="${boardDto.boardCategory != null}">
										[${boardDto.boardCategory}]
								</c:if>
								<c:forEach var="i" begin="1" end="${boardDto.boardDepth}">
									&nbsp;&nbsp;
								</c:forEach>
								<a class="link" href="/board/detail?boardNo=${boardDto.boardNo}">
									<c:if test="${boardDto.boardDepth > 0}">
										ㄴ
									</c:if>
										${boardDto.boardTitle}
									<c:if test="${boardDto.boardComment != 0}">
										(${boardDto.boardComment})
									</c:if>
								</a>
							</td>
							<td>${boardDto.boardWriter}</td>
							<td>${boardDto.boardDateAuto}</td>
							<td>${boardDto.boardLike}</td>
							<td>${boardDto.boardView}</td>
							<c:if test="${sessionScope.memberLevel == 'admin'}">
								<td>
									<a class="link delete-btn" href="/board/delete?boardNo=${boardDto.boardNo}">삭제</a> | 
									<a class="link" href="/board/edit?boardNo=${boardDto.boardNo}">수정</a>
								</td>
							</c:if>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
        <!-- 페이지 네비 -->
        <div class="row pagination pt-20">
            <c:choose>
				<c:when test="${!vo.firstPage}">
					<a href="list?page=1${vo.param}">&laquo;</a>
				</c:when>
				<c:otherwise>
					<a href="#">&laquo;</a>
				</c:otherwise>
			</c:choose>
			<!-- < (이전페이지로) -->
			<c:choose>
				<c:when test="${vo.prev}">
					<a href="list?page=${vo.prevPage}${vo.param}">&lt;</a>
				</c:when>
				<c:otherwise>
					<a href="#">&lt;</a>
				</c:otherwise>
			</c:choose>
			<!-- 숫자 -->
			<c:forEach var="i" begin="${vo.firstBlock}" end="${vo.lastBlock}">
				<c:choose>
					<c:when test="${vo.page == i}">
						<a href="#" class="on">${i}</a>
					</c:when>
					<c:otherwise>
						<a href="list?page=${i}${vo.param}">
							${i}
						</a>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<!-- > (다음페이지로) -->
			<c:choose>
				<c:when test="${vo.next}">
					<a href="list?page=${vo.nextPage}${vo.param}">&gt;</a>
				</c:when>
				<c:otherwise>
					<a href="#">&gt;</a>
				</c:otherwise>
			</c:choose>
			<!-- >> (마지막페이지로) -->
			<c:choose>
				<c:when test="${!vo.lastPage}">
					<a href="list?page=${vo.countTotalPage}${vo.param}">&raquo;</a>
				</c:when>
				<c:otherwise>
					<a href="#">&raquo;</a>
				</c:otherwise>
			</c:choose>
        </div>
	</div>
</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
