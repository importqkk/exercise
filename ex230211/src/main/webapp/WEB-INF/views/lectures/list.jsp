<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
<script type="text/javascript">
    $(function() {
        $("#delete").click(function() {
            var result = confirm("정말 삭제하시겠습니까?");
            if(!result) return false;
        })
    })
</script>

	<form action="list" method="get">
	    <div class="container-800">
	        <!-- 제목 -->
	        <div class="row">
	            <h1 class="title pb-20">강의</h1>
	        </div>
	        <!-- 등록버튼, 검색창 -->
	        <div class="row" style="display: flex;">
	            <!-- 등록버튼 -->
	            <div class="left w-25">
	            	<c:if test="${sessionScope.memberLevel == 'admin'}">
	                	<a class="form-btn small positive w-50" href="/lectures/add">등록</a>
	                </c:if>
	            </div>
	            <!-- 검색창 -->
	            <div class="right w-75 pb-20">
	                <!-- 카테고리 -->
	               	<c:choose>
	               		<c:when test="${vo.column == 'lecturer'}">
			                <select class="form-input small w-15" name="column">
			                    <option value="lecture">강의명</option>
			                    <option value="lecturer" selected>강사명</option>
			                </select>
		                </c:when>
		                <c:otherwise>
		                	<select class="form-input small w-15" name="column">
			                    <option value="lecture" selected>강의명</option>
			                    <option value="lecturer">강사명</option>
			                </select>
		                </c:otherwise>
	                </c:choose>
	                <!-- 검색창 -->
	                <input class="form-input small w-40" type="text" name="keyword" placeholder="검색어를 입력하세요." value="${vo.keyword}" required>
	                <!-- 검색버튼 -->
	                <button class="form-btn small positive w-10" type="submit">검색</button>
	            </div>
	        </div>
	        <!-- 목록 -->
	        <c:choose>
	        	<c:when test="${list.isEmpty()}">
	        		<div class="row center">
						<h3>검색 결과가 없습니다.</h3>
					</div>
				</c:when>
				<c:otherwise>
			        <div class="row">
			            <table class="table table-row table-hover w-100">
			                <thead>
			                    <tr>
			                        <th>번호</th>
			                        <th class="w-45">강의명</th>
			                        <th>강사명</th>
			                        <th class="right">수강료</th>
			                        <c:if test="${sessionScope.memberLevel == 'admin'}">
			                        	<th>관리</th>
			                        </c:if>
			                    </tr>
			                </thead>
			                <tbody class="center">
			                	<c:forEach var="lecturesDto" items="${list}">
				                    <tr>
				                        <td>${lecturesDto.lecturesNo}</td>
				                        <td>
				                        	<a class="link" href="detail?lecturesNo=${lecturesDto.lecturesNo}">
				                        		${lecturesDto.lecturesLecture}
				                        	</a>
				                        </td>
				                        <td>${lecturesDto.lecturesLecturer}</td>
				                        <td class="right">
				                        	<fmt:formatNumber value="${lecturesDto.lecturesFee}" pattern="#,##0">
											</fmt:formatNumber>
				                        </td>
				                        <c:if test="${sessionScope.memberLevel == 'admin'}">
				                        	<td>
				                        		<a class="link" id="delete" href="delete?no=${lecturesDto.lecturesNo}">삭제</a> | 
				                        		<a class="link" href="edit?no=${lecturesDto.lecturesNo}">수정</a>
				                        	</td>
				                        </c:if>
				                    </tr>
				                </c:forEach>
			                </tbody>
			            </table>
			        </div>
			    </c:otherwise>
	        </c:choose>
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
