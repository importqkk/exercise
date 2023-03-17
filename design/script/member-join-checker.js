// 회원가입 페이지 유효성 검사 모듈

$(function() {

    // 검사 결과 저장 객체
    var valid = {
        memberIDValid:false,
        memberPWValid:false,
        memberPWCheckValid:false,
        memberNickValid:false,
        memberEmailValid:false,
        memberLastNameValid:false,
        memberFirstNameValid:false,
        memberTelValid:true,
        memberBirthValid:true,
        isAllValid:function() {
			return this.memberIDValid && this.memberPWValid 
                    && this.memberPWCheckValid && this.memberNickValid && memberEmailValid
                    && this.memberLastNameValid && this.memberFirstNameValid 
                    && this.memberTelValid && this.memberBirthValid;
		}
    }

    // 아이디 검사
    $("[name=memberID]").blur(function() {
        var regex = /^[a-z0-9-_]{5,20}$/;
        var target = $(this);
        var memberID = $(this).val();
        var isValid = regex.test(memberID);
        valid.memberIDValid = isValid;
        if(!isValid) {  // 형식 위반
            target.removeClass("valid invalid1 invalid2").addClass("invalid1");
            return;
        }
        $.ajax({
            url:"/rest/members/memberID/" + memberID,
            method:"get",
            success:function(response) {
                if(response == "Y") {   // 사용할 수 있는 아이디
                    valid.memberIDValid = true;
                    target.removeClass("valid invalid1 invalid2").addClass("valid");
                }
                else {  // 이미 있는 아이디
                    valid.memberIDValid = false;
                    target.removeClass("valid invalid1 invalid2").addClass("invalid2");
                }
            },
            error:function() {  // 통신 오류
                alert("오류가 발생했습니다.\n나중에 다시 시도해주세요.");
                valid.memberIDValid = false;
            }
        })
    })
    // 비밀번호 검사
    $("[name=memberPW]").blur(function() {
        var regex = /^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*?=+_-])[A-Za-z0-9!@#$%^&*?=+_-]{8,16}$/;
        var isValid = regex.test($(this).val());
        valid.memberPWValid = isValid;
        $(this).removeClass("valid invalid1").addClass(isValid ? "valid" : "invalid1");
    })
    // 비밀번호 확인 검사
    $("#memberPWCheck").blur(function() {
        var memberPW = $("[name=memberPW]").val();
        var memberPWCheck = $(this).val();
        var isEmpty = !memberPW;
        var isValid = memberPW == memberPWCheck;
        valid.memberPWCheckValid = isValid && !isEmpty;
        $(this).removeClass("valid invalid1 invalid2")
        if(isEmpty) $(this).addClass("invalid2");   // 비밀번호 미입력
        else if(isValid) $(this).addClass("valid"); // 비밀번호 일치
        else $(this).addClass("invalid1");          // 비밀번호 불일치
    })
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
        $.ajax({
            url:"/rest/members/memberNick/" + memberNick,
            method:"get",
            success:function(response) {
                if(response == "Y") {   // 사용할 수 있는 닉네임
                    valid.memberNickValid = true;
                    target.removeClass("valid invalid1 invalid2").addClass("valid");
                }
                else {  // 이미 사용중인 닉네임
                    valid.memberNickValid = false;
                    target.removeClass("valid invalid1 invalid2").addClass("invalid2");
                }
            },
            error:function() {  // 통신 오류
                alert("오류가 발생했습니다.\n나중에 다시 시도해주세요.");
                valid.memberNickValid = false;
            }
        })
    })
    // 이메일 검사
    $("[name=memberEmail]").blur(function() {
        var regex = /.+@.+/;
        var memberEmail = $(this).val();
        var isValid = regex.test(memberEmail);
        valid.memberTelValid = isValid;
        $(this).removeClass("valid invalid1").addClass(isValid ? "valid" : "invalid1");
    })
    // 이름 검사
    // 성
    $("[name=memberLastName]").blur(function() {
        var regex = /^[가-힣]{1,2}$/;
        var memberLastName = $(this).val();
        var isValid = regex.test(memberLastName);
        valid.memberLastNameValid = isValid;
        $(this).removeClass("valid invalid1").addClass(isValid ? "valid" : "invalid1")
    })
    // 이름
    $("[name=memberFirstName]").blur(function() {
        var regex = /^[가-힣]{1,5}$/;
        var memberFirstName = $(this).val();
        var isValid = regex.test(memberFirstName);
        valid.memberFirstNameValid = isValid;
        $(this).removeClass("valid invalid1").addClass(isValid ? "valid" : "invalid1");
    })
    // 전화번호 검사
    $("[name=memberTel]").blur(function() {
        var regex = /^010[1-9][0-9]{7}$/;
        var memberTel = $(this).val();
        var isValid = regex.test(memberTel);
        valid.memberTelValid = isValid;
        $(this).removeClass("valid invalid1").addClass(isValid ? "valid" : "invalid1");
    })
    // 생년월일 검사
    $("[name=memberBirth]").blur(function() {
        var regex = /^(19[0-9]{2}|20[0-9]{2})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|02-(0[1-9]|[12][0-9]))$/;
        var memberBirth = $(this).val();
        var isValid = regex.test(memberBirth);
        valid.memberBirthValid = isValid;
        $(this).removeClass("valid invalid1").addClass(isValid ? "valid" : "invalid1");
    })

    // form 검사
    $(".join-form").submit(function(e) {
        if(valid.isAllValid == false) {
			e.preventDefault();
		}
        return valid.isAllValid();
    })

});