window.addEventListener("load", function() {
    // [1] 입력창에 입력을 마치면 형식 검사 후 메세지 출력
    var regexInputs = document.querySelectorAll(".form-regex");
    for(var i=0; i<regexInputs.length; i++) {
        regexInputs[i].addEventListener("blur", function() {
            var input = this.value;
            var testRegex = new RegExp(this.dataset.regex); // 문자열을 정규표현식으로 생성
            this.classList.remove("valid", "invalid1");
            this.classList.add(testRegex.test(input) ? "valid" : "invalid1");
        })
    }
    // [2] 비밀번호 확인창에 입력을 마치면 비밀번호 일치 검사 후 메세지 출력
    document.querySelector("#memberPWCheck").addEventListener("blur", function() {
        var memberPW = document.querySelector("[name=memberPW]").value;
        var checkPW = this.value;
        this.classList.remove("valid", "invalid1", "invalid2");
        if(!memberPW) {
            this.classList.add("invalid2")
        }
        else if(memberPW == checkPW) {
            this.classList.add("valid")
        }
        else {
            this.classList.add("invalid1")
        }
    })
});
