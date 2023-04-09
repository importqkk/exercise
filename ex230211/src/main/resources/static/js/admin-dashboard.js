// 관리자 메인 대시보드

$(function() {

	// 회원 통계
    $.ajax({
		url: "/rest/admin/memberStat",
		method: "get",
		success: function(rsp) {
			var ctx = document.querySelector('#memberStat');
			new Chart(ctx, {
				type: 'bar',
				data: {
					labels: rsp.label,
					datasets: [{
						label: '인원',
						data: rsp.cnts,
						borderWidth: 1,
						backgroundColor: ['rgba(130, 151, 255, 0.5)'],
						borderColor: ['rgba(130, 151, 255, 1)'],
						yAxisID: 'y1'
					},
					{
						label: '평균 포인트',
						data: rsp.avgs,
						type: 'line',
						fill: 'false',
						pointRadius: 1,
						borderWidth: 2,
						backgroundColor: ['rgba(0, 0, 0, 0.5)'],
						borderColor: ['rgba(0, 0, 0, 1)'],
						yAxisID: 'y2'
					},
					{
						label: '최대 포인트',
						data: rsp.maxs,
						type: 'line',
						fill: 'false',
						pointRadius: 1,
						borderWidth: 1,
						backgroundColor: ['rgba(247, 93, 134, 0.5)'],
						borderColor: ['rgba(247, 93, 134, 1)'],
						yAxisID: 'y2'
					},
					{
						label: '최소 포인트',
						data: rsp.mins,
						type: 'line',
						fill: 'false',
						pointRadius: 1,
						borderWidth: 1,
						backgroundColor: ['rgba(68, 49, 191, 0.5)'],
						borderColor: ['rgba(68, 49, 191, 1)'],
						yAxisID: 'y2'
					}]
				},
				options: {
					scales: {
						y1: {
							beginAtZero: true,
							type: 'linear',
							display: true,
							position: 'left'
						},
						y2: {
							beginAtZero: true,
							type: 'linear',
							display: true,
							position: 'right'
						}
					}
				},
				error: function() {
					alert("오류가 발생했습니다.\n잠시 후 다시 시도해주세요.")
				}
			})
		}
	})

	// 게시판 통계
    $.ajax({
		url: "/rest/admin/boardStat",
		method: "get",
		success: function(rsp) {
			var ctx = document.querySelector('#boardStat');
			new Chart(ctx, {
				type: 'pie',
				data: {
					labels: rsp.label,
					datasets: [{
						label: '게시글 수',
						data: rsp.cnts,
						borderWidth: 1,
						backgroundColor: ['rgba(68, 49, 191, 0.25)', 'rgba(247, 93, 134, 0.25)'],
						borderColor: ['rgba(68, 49, 191, 0.5)', 'rgba(247, 93, 134, 0.5)'],
					}]
				},
				options: {

				},
				error: function() {
					alert("오류가 발생했습니다.\n잠시 후 다시 시도해주세요.")
				}
			})
		}
	})
    
});