<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

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
        $(".id_list").hide();
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
        
    })
</script>

<form action="list" method="get">
	<div class="container-1000">
		<!-- 제목 -->
		<div class="row">
			<h1 class="title pb-20">회원 목록</h1>
		</div>
		<!-- 글쓰기버튼, 검색창 -->
		<div class="row">
			<!-- 검색창 -->
			<div class="w-100 pb-20">
				<!-- 카테고리 -->
				<c:choose>
					<c:when test="${vo.column == 'member_level'}">
						<select class="form-input small w-10" name="column">
							<option value="member_id">아이디</option>
							<option value="member_nick">닉네임</option>
							<option value="member_first_name">이름</option>
							<option value="member_level" selected>등급</option>
						</select>
					</c:when>
					<c:when test="${vo.column == 'member_first_name'}">
						<select class="form-input small w-10" name="column">
							<option value="member_id">아이디</option>
							<option value="member_nick">닉네임</option>
							<option value="member_first_name" selected>이름</option>
							<option value="member_level">등급</option>
						</select>
					</c:when>
					<c:when test="${vo.column == 'member_nick'}">
						<select class="form-input small w-10" name="column">
							<option value="member_id">아이디</option>
							<option value="member_nick" selected>닉네임</option>
							<option value="member_first_name">이름</option>
							<option value="member_level">등급</option>
						</select>
					</c:when>
					<c:otherwise>
						<select class="form-input small w-10" name="column">
							<option value="member_id" selected>아이디</option>
							<option value="member_nick">닉네임</option>
							<option value="member_first_name">이름</option>
							<option value="member_level">등급</option>
						</select>
					</c:otherwise>
				</c:choose>
				<!-- 검색창 -->
				<input class="form-input small w-30" type="text" name="keyword" placeholder="검색어를 입력하세요." value="${vo.keyword}">
				<!-- 검색버튼 -->
				<button class="form-btn small positive w-5" type="submit">검색</button>
			</div>
		</div>
		
		<!-- 정렬 -->
		<div class="row flex right">
			<a class="pe-10 sort not-selected">아이디순</a> | 
			<a class="ps-10 pe-10 sort not-selected">닉네임순</a> |
			<a class="ps-10 pe-10 sort not-selected">등급순</a> |
			<a class="ps-10 pe-10 sort not-selected">가입일 오름차</a> |
			<a class="ps-10 sort not-selected default-sort">가입일 내림차</a>
		</div>
		
		<!-- 목록 -->
		<!-- 가입일 내림차순 -->
		<div class="row join_desc_list">
			<c:choose>
				<c:when test="${list.isEmpty()}">
					<h3 class="center">검색 결과가 없습니다.</h3>
				</c:when>
				<c:otherwise>
					<table class="table table-row table-hover w-100">
						<thead>
							<tr>
								<th width=30%>아이디</th>
								<th>닉네임</th>
								<th>이름</th>
								<th>등급</th>
								<th>가입일</th>
								<th>관리</th>
							</tr>
						</thead>
						<tbody class="center">
							<c:forEach var="membersDto" items="${joinDescList}">
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
		
		<!-- 가입일 오름차순 -->
		<div class="row join_asc_list">
			<c:choose>
				<c:when test="${list.isEmpty()}">
					<h3 class="center">검색 결과가 없습니다.</h3>
				</c:when>
				<c:otherwise>
					<table class="table table-row table-hover w-100">
						<thead>
							<tr>
								<th width=30%>아이디</th>
								<th>닉네임</th>
								<th>이름</th>
								<th>등급</th>
								<th>가입일</th>
								<th>관리</th>
							</tr>
						</thead>
						<tbody class="center">
							<c:forEach var="membersDto" items="${joinAscList}">
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
		
		<!-- 닉네임순 -->
		<div class="row nick_list">
			<c:choose>
				<c:when test="${list.isEmpty()}">
					<h3 class="center">검색 결과가 없습니다.</h3>
				</c:when>
				<c:otherwise>
					<table class="table table-row table-hover w-100">
						<thead>
							<tr>
								<th width=30%>아이디</th>
								<th>닉네임</th>
								<th>이름</th>
								<th>등급</th>
								<th>가입일</th>
								<th>관리</th>
							</tr>
						</thead>
						<tbody class="center">
							<c:forEach var="membersDto" items="${nickList}">
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
		
		<!-- 아이디순 -->
		<div class="row id_list">
			<c:choose>
				<c:when test="${list.isEmpty()}">
					<h3 class="center">검색 결과가 없습니다.</h3>
				</c:when>
				<c:otherwise>
					<table class="table table-row table-hover w-100">
						<thead>
							<tr>
								<th width=30%>아이디</th>
								<th>닉네임</th>
								<th>이름</th>
								<th>등급</th>
								<th>가입일</th>
								<th>관리</th>
							</tr>
						</thead>
						<tbody class="center">
							<c:forEach var="membersDto" items="${idList}">
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
		
		<!-- 등급순 -->
		<div class="row level_list">
			<c:choose>
				<c:when test="${list.isEmpty()}">
					<h3 class="center">검색 결과가 없습니다.</h3>
				</c:when>
				<c:otherwise>
					<table class="table table-row table-hover w-100">
						<thead>
							<tr>
								<th width=30%>아이디</th>
								<th>닉네임</th>
								<th>이름</th>
								<th>등급</th>
								<th>가입일</th>
								<th>관리</th>
							</tr>
						</thead>
						<tbody class="center">
							<c:forEach var="membersDto" items="${levelList}">
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
