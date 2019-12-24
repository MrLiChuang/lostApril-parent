function doLogin() {
    $.ajax({
        type : "post",
        url : "/login/doLogin",
        data :  $("#loginForm").serialize(),
        success : function (data) {
            console.log(data);
            if (data.success){
                window.location.href = "/lostApril/main";
            }

            else
                alert(data.errorMessage);
        },
        error : function (XMLHttpRequest,textStatus,errorThrown) {
            console.log(textStatus);
        }
    })
}