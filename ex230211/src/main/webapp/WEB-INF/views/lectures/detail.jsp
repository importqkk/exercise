<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
<script type="text/javascript">
    $(function() {
        $(".delete-btn").click(function() {
            var result = window.confirm("정말 삭제하시겠습니까?");
            if(!result) return false;
        })
    })
</script>

	<div class="container-800">
	    <div class="row pb-10">
	        <h1 class="title">${lecturesDto.lecturesLecture}</h1>
	    </div>
	    <div class="row flex pb-20">
	        <div class="flex w-33">
	            <div class="flex pe-10">
	                <h3 class="title"><i class="fa-solid fa-chalkboard-user pe-5"></i>강사</h3>
	            </div>
	            <div class="flex font-h3">${lecturesDto.lecturesLecturer}</div>
	        </div>
	        <div class="flex w-33 center">
	            <div class="flex pe-10">
	                <h3 class="title"><i class="fa-regular fa-clock pe-5"></i>시수</h3>
	            </div>
	            <div class="flex font-h3">
	            	<fmt:formatNumber value="${lecturesDto.lecturesHours}" pattern="#,##0시간"></fmt:formatNumber>
	            </div>
	        </div>
	        <div class="flex w-33 right">
	            <div class="flex pe-10">
	                <h3 class="title"><i class="fa-solid fa-won-sign pe-5"></i>수강료</h3>
	            </div>
	            <div class="flex font-h3">
	            	<fmt:formatNumber value="${lecturesDto.lecturesFee}" pattern="#,##0원"></fmt:formatNumber>
	            </div>
	        </div>
	    </div>
	    <div class="pb-20">
	        <hr>
	    </div>
	    <div class="row center pb-20">
	        <c:choose>
			<c:when test="${image != null}">
				<img src="/attachment/download?attachmentNo=${image.attachmentNo}">
			</c:when>
			<c:otherwise>
				<img src="/images/defaultLecture.png">
			</c:otherwise>
		</c:choose>
	    </div>
	    <div>
	        <hr>
	    </div>
	    <div class="row flex">
	        <div class="flex w-50">
	            <a href="list" class="form-btn small neutral w-20">목록</a>
	        </div>
	        <c:if test="${sessionScope.memberLevel == 'admin'}">
		        <div class="flex w-50 right">
		            <a href="edit?no=${lecturesDto.lecturesNo}" class="form-btn small neutral w-20 me-5">수정</a>
		            <a href="delete?no=${lecturesDto.lecturesNo}" class="form-btn small warning w-20 delete-btn">삭제</a>
		        </div>
		    </c:if>
	    </div>
	</div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
