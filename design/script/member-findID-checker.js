// 회원가입 페이지 유효성 검사 모듈

$(function() {

    // 검사 결과 저장 객체
    var valid = {
        memberNickValid:false,
        memberEmailValid:false,
        isAllValid:function() {
			return this.memberNickValid && memberEmailValid;
		}
    }

    // 닉네임 검사
    $("[name=memberNick]").blur(function() {
        var regex = /^[가-힣0-9]{2,10}$/;
        var target = $(this)
        var memberNick = $(this).val();
        var isValid = regex.test(memberNick);
        valid.memberNickValid = isValid;
        if(!isValid) {  // 닉네임 형식 위반
            target.removeClass("valid invalid1 invalid2").addClass("invalid1");
            return;
        }
    })
    // 이메일 검사
    $("[name=memberEmail]").blur(function() {
        var regex = /.+@.+/;
        var memberEmail = $(this).val();
        var isValid = regex.test(memberEmail);
        valid.memberTelValid = isValid;
        $(this).removeClass("valid invalid1").addClass(isValid ? "valid" : "invalid1");
    })

    // form 검사
    $(".findID-form").submit(function(e) {
        if(valid.isAllValid == false) {
			e.preventDefault();
		}
        return valid.isAllValid();
    })

});