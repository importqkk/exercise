$(function() {

    // [1] 페이지가 로딩되자마자 글에 좋아요를 누른 적이 있는지 확인
    var params = new URLSearchParams(location.search);
    var boardNo = params.get("boardNo");
    $.ajax({
        url:"/rest/board/check",
        method:"post",
        data:{
            boardNo:boardNo
        },
        success:function(response) {
            if(response) { // 좋아요를 누른 적이 있으면 꽉 찬 하트
                $(".fa-heart").addClass("fa-solid");
            }
            else {  // 좋아요 누른 적 없으면 텅 빈 하트
                $(".fa-heart").addClass("fa-regular");
            }
        },
        error:function() {
            $(".fa-heart").remove();
        }
    })

    // [2] 하트를 클릭하면 상황에 따라 좋아요/좋아요 취소
    $(".fa-heart").click(function() {
        $.ajax({
            url:"/rest/board/like",
            method:"post",
            data:{
                boardNo:boardNo
            },
            success:function(response) {
                if(response.result) {
                    $(".fa-heart").removeClass("fa-solid fa-regular").addClass("fa-solid");
                    $(".heart-count").text(response.count);
                }
                else {
                    $(".fa-heart").removeClass("fa-solid fa-regular").addClass("fa-regular");
                    $(".heart-count").text(response.count);
                }
            },
            error:function() {

            }
        })
    })
    
});