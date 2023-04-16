$(function() {

    // 글 번호 가져오기
    var params = new URLSearchParams(location.search);
    var boardNo = params.get("boardNo");
    
    // 댓글 목록 불러오기
    loadList();
    
    // 댓글 등록
    $(".comment-btn").click(function() {
		var content = $("[name=commentContent").val();
		if(content.trim().length == 0) return;
		$.ajax({
			url:"/rest/comment/",
			method:"post",
			data:{
				boardNo:boardNo,
				commentContent:content,
				commentWriter:memberID
			},
			success:function(rsp) {
				loadList();
				$("[name=commentContent]").val("");
			},
			error:function() {
				alert("오류가 발생했습니다.\n잠시 후 다시 시도해주세요.");
			}
		});
	})
    
    // 댓글 목록
    function loadList() {
		$(".comment-list").empty();
		$.ajax({
			url:"/rest/comment/" + boardNo,
			method:"get",
			success:function(rsp) {
				for(var i=0; i<rsp.length; i++) {
					var template = $("#comment-template").html();
					var html = $.parseHTML(template);
					$(html).find(".commentWriter").text(rsp[i].commentWriter);
					$(html).find(".commentTime").text(rsp[i].commentTime);
					$(html).find(".commentContent").text(rsp[i].commentContent);
					if(boardWriter == rsp[i].commentWriter) {
						$(html).find(".commentWriter").css("color", "#4431bf")
					}
					if(memberID == rsp[i].commentWriter) {
						var editBtn = $("<i>").addClass("fa-solid fa-edit right")
							.attr("data-comment-no", rsp[i].commentNo)
							.attr("data-comment-content", rsp[i].commentContent)
							.click(editComment);
						var deleteBtn = $("<i>").addClass("fa-solid fa-trash ms-10 right")
							.attr("data-comment-no", rsp[i].commentNo)
							.click(deleteComment);
						$(html).find(".manageBtns").append(editBtn).append(deleteBtn);
					}
					$(".comment-list").append(html);
				}
			},
			error() {
				alert("오류가 발생했습니다.\n잠시 후 다시 시도해주세요.");
			}
		})
	}
	
	// 삭제
	function deleteComment() {
		var result = confirm("댓글을 삭제하시겠습니까?");
		if(!result) return;
		var commentNo = $(this).data("comment-no");
		$.ajax({
			url:"/rest/comment/" + commentNo,
			method:"delete",
			success:function(rsp) {
				loadList();
			},
			error:function() {
				alert("오류가 발생했습니다.\n잠시 후 다시 시도해주세요.");
			}
		})
	}
	
	// 수정
	function editComment() {
		var commentNo = $(this).data("comment-no");
		var commentContent = $(this).data("comment-content");
		var textarea = $("<textarea>").addClass("form-input small w-100 edit-box mt-30")
			.attr("placeholder", "댓글을 입력하세요.")
			.val(commentContent);
		var editBtn = $("<button>").addClass("form-btn positive small comment-btn w-10 mt-10 ms-10")
			.text("댓글 수정").click(function() {
				$.ajax({
					url:"/rest/comment/",
					method:"patch",
					data:{
						commentNo:commentNo,
						commentContent:textarea.val()
					},
					success:function(rsp) {
						loadList();
					},
					error:function() {
						alert("오류가 발생했습니다.\n잠시 후 다시 시도해주세요.");
					}
				})
			})
			var cancelBtn = $("<button>").addClass("form-btn neutral small cancel-btn w-10")
				.text("수정 취소").click(function() {
					$(this).parents(".comment-item").prev(".comment-item").show();
					$(this).parents(".comment-item").remove();
				})
			var div = $("<div>").addClass("comment-item right");
			div.append(textarea).append(cancelBtn).append(editBtn);
			$(this).parents(".comment-item").hide().after(div);
	}
    
});
