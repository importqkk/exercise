// 회원가입 페이지 유효성 검사 모듈

$(function() {

    // 검사 결과 저장 객체
    var valid = {
        inIDValid:false,
        inEmailValid:false,
        isAllValid:function() {
			return this.inIDValid && inEmailValid;
		}
    }

    // 아이디 검사
    $("[name=inID]").blur(function() {
        var regex = /^[a-z0-9-_]{5,20}$/;
        var target = $(this);
        var inID = $(this).val();
        var isValid = regex.test(inID);
        valid.inIDValid = isValid;
        if(!isValid) {  // 형식 위반
            target.addClass("invalid1");
            return;
        }
    })
    // 이메일 검사
    $("[name=inEmail]").blur(function() {
        var regex = /.+@.+/;
        var inEmail = $(this).val();
        var isValid = regex.test(inEmail);
        valid.inEmailValid = isValid;
        $(this).addClass(isValid ? "valid" : "invalid1");
    })

    // form 검사
    $(".findPW-form").submit(function(e) {
        if(valid.isAllValid == false) {
			e.preventDefault();
		}
        return valid.isAllValid();
    })

});