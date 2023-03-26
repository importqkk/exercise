<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
<!-- summernote css, js cdn -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
<script type="text/javascript">
    $(function() {
        $('[name=boardContent]').summernote({
            placeholder: '내용을 입력해주세요.',
            tabsize: 4,
            height: 450,
            disableResizeImage: true,
            // 메뉴 설정
            toolbar: [
                ['style', ['style']],
                ['font', ['bold', 'underline', 'clear']],
                ['color', ['color']],
                ['para', ['ul', 'ol', 'paragraph']],
                ['table', ['table']],
                ['insert', ['link', 'picture']],
            ],
            callbacks: {
                onImageUpload: function(files) {
                    // if(files.length != 1) return;
                    // [1] FormData / [2] processData / [3] contentType
                    var fd = new FormData();
                    fd.append("attachment", files[0]);
                    $.ajax({
                        url:"/rest/attachment/upload",
                        method:"post",
                        data:fd,
                        processData:false,
                        contentType:false,
                        success:function(response) {
                            // 서버로 전송할 이미지 번호 정보 생성
                            var input = $("<input>").attr("type", "hidden")
                                                    .attr("name", "attachmentNo")
                                                    .val(response.attachmentNo);
                            $("form").prepend(input);
                            // 에디터에 추가할 이미지 생성
                            var imgNode = $("<img>").attr("src", "/rest/attachment/download/" + response.attachmentNo);
                            $("[name=boardContent]").summernote('insertNode', imgNode.get(0));
                        },
                        error:function() {
                        }
                    })
                }
            }
        });
        $('.note-statusbar').hide();
        $(".list-btn").click(function() {
        	var result = confirm("목록으로 이동하면 작성중인 내용이 저장되지 않습니다.\n정말 이동하시겠습니까?");
        	if(!result) return false;
        })
        $(".post-btn").click(function() {
        	var title = $("[name=boardTitle]").val().length;
        	var content = $("[name=boardContent]").val().length;
        	if(!title) {
        		alert("제목을 입력하세요.");
        		return false;
        	}
        	if(!content) {
        		alert("내용을 입력하세요.");
        		return false;
        	}
        })
    })
</script>

    <div class="container-800">
	    <form action="post" method="post">
	        <div class="row">
	        	<c:choose>
					<c:when test="${boardParent == null}">
				        <h1 class="title">게시글 등록</h1>
				    </c:when>
					<c:otherwise>
						<h1 class="title">답글 등록</h1>
					</c:otherwise>
				</c:choose>
	        </div>
	        <c:if test="${boardParent != null}">
				<input type="hidden" name="boardParent" value="${boardParent}">
			</c:if>
	        <div class="row flex">
	            <select name="boardCategory" class="form-input small w-15 me-10">
	                <c:if test="${sessionScope.memberLevel == 'admin'}">
						<option>공지</option>
						<option>답변</option>
					</c:if>
					<c:if test="${sessionScope.memberLevel != 'admin'}">
	                	<option>질문</option>
	                </c:if>
	            </select>
	            <c:choose>
					<c:when test="${boardParent == null}">
			            <input type="text" name="boardTitle" class="form-input small w-100" placeholder="제목을 입력하세요.">
			        </c:when>
					<c:otherwise>
						<input type="text" name="boardTitle" class="form-input small w-100" value="RE: " placeholder="제목을 입력하세요.">
	        		</c:otherwise>
				</c:choose>
	        </div>
	        <div class="row">
	            <textarea name="boardContent"></textarea>
	        </div>
	        <div class="row flex">
	            <div class="w-50">
	                <a class="form-btn small neutral w-20 list-btn" href="/board/list">목록으로</a>
	            </div>
	            <div class="w-50 right">
	                <button type="submit" class="form-btn small positive w-20 post-btn">등록하기</button>
	            </div>
	        </div>
	    </form>
    </div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>
