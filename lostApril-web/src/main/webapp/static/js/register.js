var step = 1;

function userNameCheck(){
    var username = $("#username").val();
    if( username !== "" && username !== null){
        $.ajax({
            type : "get",
            url : "/register/usernameCheck",
            data : { "username" : username },
            success : function (data) {
                if(data.success){
                    alert("该用户名可使用");
                }else
                    alert("该用户名已被占用");
            }
        });
    }

}

function emailCheck(){
    var email = $("#emailStep1").val();
    if( email !== "" && email !== null){
        $.ajax({
            type : "get",
            url : "/register/emailCheck",
            data : { "email" : email },
            success : function (data) {
                if(data.success){
                    alert("该邮箱可以使用");
                }else
                    alert("该邮箱已被注册");
            }
        });
    }

}

function passwordRecheck() {
    var pwd1 = $("#password").val();
    var pwd2 = $("#passwordRecheck").val();

    if( pwd1 !== "" && pwd1 !==null && pwd2 !== "" && pwd2 !==null)
        if (pwd1 !== pwd2)
            alert("两次输入的密码不一致");
}

function next(){
        if(this.step===1){
            this.step++;
            var email = $('#emailStep1');
            $("#emailStep2").val(email.val());
            $("#registerForm").css("display","none");
            $("#emailConfigForm").css("display","block");

            // $.ajax({
            //     type: "post",
            //     url: "/register/doRegister",
            //     data: $("#registerForm").serialize(),
            //     success: function (data) {
            //         if (data.success) {
            //             alert("注册成功");
            //         } else {
            //             alert("注册失败");
            //         }
            //     }
            // });
        }




}
function forward() {
    if(this.step===2){
        $("#registerForm").css("display","block");
        $("#emailConfigForm").css("display","none");
    }
}
function getEmailActiveCode() {
    $.ajax({
        type : "post",
        url : "/register/getEmailActiveCode",
        data : {"email": $("#emailStep2").val() },
        success : function (data) {
            if (data.success)
                alert("验证码发送成功");
            else
                alert("验证码发送失败");
        }
    })
}
function confirmEmailActiveCode() {
    $.ajax({
        type : "post",
        url : "/register/confirmEmailActiveCode",
        data : {"email": $("#emailStep2").val() , "activeCode" : $("#emailActiveCode").val() },
        success : function (data) {
            if (data.success)
                alert("验证成功");
            else
                alert("验证失败");
        }
    })
}
