<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
<!-- chart.js cdn -->
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<!-- 그래프 스크립트 -->
<script src="/js/admin-dashboard.js"></script>
	
	<div class="container-800">
		<div class="row w-100 pb-50">
			<a class="form-btn w-100 neutral medium" href="/admin/members/list">회원관리</a>
		</div>
		<div class="row">
			<h1 class="title">DASHBOARD</h1>
		</div>
		<div class="row">
			<div class="row">
				<h2>회원 현황</h2>
			</div>
			<div class="row pb-50">
				<canvas id="memberStat"></canvas>
			</div>
		</div>
		<div class="row">
			<div class="row">
				<h2>강의 현황</h2>
			</div>
			<div class="row pb-50">
				<table class="table table-row w-100">
					<thead>
						<tr>
							<th>개수</th>
							<th>평균 강의료</th>
							<th>최저 강의료</th>
							<th>최고 강의료</th>
							<th>평균 시수</th>
							<th>최단 시수</th>
							<th>최장 시수</th>
						</tr>
					</thead>
					<c:forEach var="lectureStatDto" items="${lectureList}">
						<tbody align="center">
							<tr>
								<td>
									<fmt:formatNumber value="${lectureStatDto.cnt}" pattern="#,##0"></fmt:formatNumber>
								</td>
								<td>
									<fmt:formatNumber value="${lectureStatDto.avgFee}" pattern="#,##0"></fmt:formatNumber>
								</td>
								<td>
									<fmt:formatNumber value="${lectureStatDto.minFee}" pattern="#,##0"></fmt:formatNumber>
								</td>
								<td>
									<fmt:formatNumber value="${lectureStatDto.maxFee}" pattern="#,##0"></fmt:formatNumber>
								</td>
								<td>
									<fmt:formatNumber value="${lectureStatDto.avgHours}" pattern="#,##0"></fmt:formatNumber>
								</td>
								<td>
									<fmt:formatNumber value="${lectureStatDto.minHours}" pattern="#,##0"></fmt:formatNumber>
								</td>
								<td>
									<fmt:formatNumber value="${lectureStatDto.maxHours}" pattern="#,##0"></fmt:formatNumber>
								</td>
							</tr>
						</tbody>
					</c:forEach>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="row">
				<h2>게시판 현황</h2>
			</div>
			<div class="row pb-50">
				<canvas id="boardStat"></canvas>
			</div>
		</div>
	</div>
		
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
