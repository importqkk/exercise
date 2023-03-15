<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
<script type="text/javascript">
    $(function() {
        // 취소 버튼 경고창
        $(".cancel-btn").click(function() {
            var result = confirm("수정을 취소합니다.")
            if(!result) return false;
            else history.back();
        })
    })
</script>

	<form action="edit" method="post">
		<div class="container-450">
	        <div class="row">
	            <h1 class="title">강의 정보 수정</h1>
	        </div>
	        <div class="row">
	            <label>번호(수정 불가)</label>
	            <input readonly class="form-input medium w-100" name="lecturesNo" value="${lecturesDto.lecturesNo}">
	        </div>
	        <div class="row">
	            <label>강의명</label>
	            <input type="text" class="form-input medium w-100" name="lecturesLecture" value="${lecturesDto.lecturesLecture}" required>
	        </div>
	        <div class="row">
	            <label>강사명</label>
	            <input type="text" class="form-input medium w-100" name="lecturesLecturer" value="${lecturesDto.lecturesLecturer}" required>
	        </div>
	        <div class="row">
	            <label>시수</label>
	            <input type="number" class="form-input medium w-100" name="lecturesHours" value="${lecturesDto.lecturesHours}" min=0 step="30" required>
	        </div>
	        <div class="row">
	            <label>수강료</label>
	            <input type="number" class="form-input medium w-100" name="lecturesFee" value="${lecturesDto.lecturesFee}" min=0 required>
	        </div>
	        <div class="row">
	            <label>사진등록</label>
	            <input type="file" class="form-input medium w-100" name="attach" value="#">
	        </div>
	        <div class="row">
	            <button type="submit" class="form-btn positive medium w-100">수정</button>
	        </div>
	        <div class="row pt-10 pb-10">
	            <hr>
	        </div>
	        <div class="row">
	            <a class="form-btn neutral medium w-100 cancel-btn">취소</a>
	        </div>
	    </div>
	</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
