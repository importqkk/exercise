$(function() {

    // 글 번호 가져오기
    var params = new uURLSearchParams(location.search);
    var boardNo = params.get("boardNo");
    
    // 댓글 목록 불러오기
    loadList();
    
    function loadList() {
		$(".comment-list").empty();
		$.ajax({
			url:"/rest/comment/" + boardNo,
			method:"get",
			success:function(rsp) {
				for(var i=0; i<rsp.length; i++) {
					var template = $("#comment-template").html();
					var html = $.parseHTML(template);
					$(html).find(".commentWrither").text(rsp[i].commentWriter);
					$(html).find(".commentContent").text(rsp[i].commentContent);
					$(html).find(".commentTime").text(rsp[i].commentTime);
					if(memberID == rsp[i].commentWriter) {
						var editBtn = $("<i>").addClass("fa-solid fa-edit ms-20")
							.attr("data-comment-no", rsp[i].commentNo)
							.attr("data-comment-content", rsp[i].commentContent)
							.click(editComment);
						var deleteBtn = $("<i>").addClass("fa-solid fa-trash ms-10")
							.attr("data-comment-no", rsp[i].commentNo)
							.click(deleteComment);
						$(html).find(".commentWriter").append(editBtn).append(deleteBtn);
					}
					$(".comment-list").append(html);
				}
			},
			error() {
				alert("오류가 발생했습니다.\n잠시 후 다시 시도해주세요.")
			}
		})
	}
    
});