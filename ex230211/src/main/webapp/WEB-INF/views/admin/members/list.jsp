<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
<!-- LightPick -->
<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/lightpick@1.6.2/css/lightpick.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.22.2/moment.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/lightpick@1.6.2/lightpick.min.js"></script>
<script src="/js/date-picker.js"></script>

<style>
	.sort {
		text-decoration: none;
	    cursor: pointer;
	}
	.not-selected {
		color: black;
	}
	.not-selected:hover{
		font-weight: bold;
    	color: #4431bf;
	}
	.selected {
		font-weight: bold;
		color: #4431bf;
	}
</style>
<script type="text/javascript">
    $(function() {
        $(".delete-btn").click(function() {
            var result = confirm("회원 강제 탈퇴를 진행합니다.");
            if(!result) return false;
        })
        
        $(".pw-btn").click(function() {
        	var result = confirm("임시비밀번호를 회원 이메일로 전송합니다.");
            if(!result) return false;
        })
        
        // 정렬 처리
        /*$(".id_list").hide();
   		$(".nick_list").hide();
   		$(".level_list").hide();
   		$(".join_asc_list").hide();
   		$(".join_desc_list").show();
   		
        $(".not-selected").click(function() {
        	$(".selected").removeClass("selected").addClass("not-selected");
        	$(this).removeClass("not-selected").addClass("selected");
        	if($(this).text() == "아이디순") {
        		$(".id_list").show();
        		$(".nick_list").hide();
        		$(".level_list").hide();
        		$(".join_asc_list").hide();
        		$(".join_desc_list").hide();
        	}
        	else if($(this).text() == "닉네임순") {
        		$(".id_list").hide();
        		$(".nick_list").show();
        		$(".level_list").hide();
        		$(".join_asc_list").hide();
        		$(".join_desc_list").hide();
        	}
        	else if($(this).text() == "등급순") {
        		$(".id_list").hide();
        		$(".nick_list").hide();
        		$(".level_list").show();
        		$(".join_asc_list").hide();
        		$(".join_desc_list").hide();
        	}
        	else if($(this).text() == "가입일 오름차") {
        		$(".id_list").hide();
        		$(".nick_list").hide();
        		$(".level_list").hide();
        		$(".join_asc_list").show();
        		$(".join_desc_list").hide();
        	}
        	else if($(this).text() == "가입일 내림차") {
        		$(".id_list").hide();
        		$(".nick_list").hide();
        		$(".level_list").hide();
        		$(".join_asc_list").hide();
        		$(".join_desc_list").show();
        	}
        })
        
        $(".default-sort").removeClass("not-selected").addClass("selected");
    })*/
</script>

<form action="list" method="get">
	<div class="container-800">
		<!-- 제목 -->
		<div class="row">
			<h1 class="title">회원 목록</h1>
		</div>
		<!-- 글쓰기버튼, 검색창 -->
		<div class="row pb-30">
			<!-- 검색창 -->
			<div class="w-100 flex">
				<!-- 검색창 -->
				<div class="row w-50 pe-10">
					<div class="row">
						<label>아이디</label>
						<input type="text" name="memberID" class="form-input small w-100" value="${vo.memberID}">
					</div>
					<div class="row">
						<label>닉네임</label>
						<input type="text" name="memberNick" class="form-input small w-100" value="${vo.memberNick}">
					</div>
					<div class="row">
						<label>이메일</label>
						<input type="text" name="memberEmail" class="form-input small w-100" value="${vo.memberEmail}">
					</div>
					<div class="row">
						<label>전화번호</label>
						<input type="text" name="memberTel" class="form-input small w-100" value="${vo.memberTel}">
					</div>
				</div>
				<div class="row w-50 ps-10"">
					<div class="row">
						<label>성</label>
						<input type="text" name="memberLastName" class="form-input small w-100" value="${vo.memberLastName}">
					</div>
					<div class="row">
						<label>이름</label>
						<input type="text" name="memberFirstName" class="form-input small w-100" value="${vo.memberFirstName}">
					</div>
					<div class="row">
						<label>생년</label>
						<input type="text" name="memberBirthYear" class="form-input small w-100" value="${vo.memberBirthYear}">
					</div>
					<div class="row">
						<label>생월</label>
						<input type="text" name="memberBirthMonth" class="form-input small w-100" value="${vo.memberBirthMonth}">
					</div>
				</div>
			</div>
			<div class="row">
				<label>등급</label>
				<div class="w-100">
					<input type="checkbox" name="memberLevels" value="bronze" ${vo.memberLevels.contains('bronze') ? 'checked' : ''}> bronze
					<input type="checkbox" name="memberLevels" class="ms-40" value="silver" ${vo.memberLevels.contains('silver') ? 'checked' : ''}> silver
					<input type="checkbox" name="memberLevels" class="ms-40" value="gold" ${vo.memberLevels.contains('gold') ? 'checked' : ''}> gold
					<input type="checkbox" name="memberLevels" class="ms-40" value="platinum" ${vo.memberLevels.contains('platinum') ? 'checked' : ''}> platinum
					<input type="checkbox" name="memberLevels" class="ms-40" value="admin" ${vo.memberLevels.contains('admin') ? 'checked' : ''}> admin
				</div>
			</div>
			<div class="row w-100 flex">
				<div class="row w-45">
					<label>최소포인트</label>
					<input type="text" name="minPoint" class="form-input small w-100" value="${vo.minPoint}">				
				</div>
				<div class="row w-10">
					<div class="center">~</div>
				</div>
				<div class="row w-45">
					<label>최대포인트</label>
					<input type="text" name="maxPoint" class="form-input small w-100" value="${vo.maxPoint}">				
				</div>
			</div>
			<div class="row w-100 flex">
				<div class="row w-45">
					<label>가입일</label>
					<input type="text" name="joinStart" class="form-input small w-100 date-picker" value="${vo.joinStart}">				
				</div>
				<div class="row w-10">
					<div class="center">~</div>
				</div>
				<div class="row w-45">
					<label>가입일</label>
					<input type="text" name="joinEnd" class="form-input small w-100 date-picker2" value="${vo.joinEnd}">				
				</div>
			</div>
			<div class="row w-100">
				<label class="w-100">최종 로그인</label><br>
				<input type="text" name="memberLogin" class="form-input small w-10" value="${vo.memberLogin}"> 일 전
			</div>
			<!-- 검색버튼 -->
			<div class="row">
				<button class="form-btn small positive w-100" type="submit">검색</button>
			</div>
		</div>
		
		<!-- 목록 -->
		<div class="row">
			<c:choose>
				<c:when test="${list.isEmpty()}">
					<h3 class="center">검색 결과가 없습니다.</h3>
				</c:when>
				<c:otherwise>
					<table class="table table-row table-hover w-100">
						<thead>
							<tr>
								<th width=20%>아이디</th>
								<th>닉네임</th>
								<th>이름</th>
								<th>등급</th>
								<th>가입일</th>
								<th>관리</th>
							</tr>
						</thead>
						<tbody class="center">
							<c:forEach var="membersDto" items="${list}">
								<tr>
									<td>
										<a href="/admin/members/detail?memberID=${membersDto.memberID}">
											${membersDto.memberID}
										</a>
									</td>
									<td>${membersDto.memberNick}</td>
									<td>${membersDto.memberLastName}${membersDto.memberFirstName}</td>
									<td>${membersDto.memberLevel}</td>
									<td>${membersDto.memberJoin}</td>
									<td>
										<a class="link delete-btn" href="/admin/members/leave?memberID=${membersDto.memberID}&page=${vo.page}">탈퇴</a> | 
										<a class="link" href="/admin/members/changeInfo?memberID=${membersDto.memberID}">수정</a> | 
										<a class="link pw-btn" href="/admin/members/tempPW?memberID=${membersDto.memberID}">임시비밀번호</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:otherwise>
			</c:choose>
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
