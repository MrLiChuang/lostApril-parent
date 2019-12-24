<!doctype html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="/static/css/style.css" type="text/css" >
        <script type="text/javascript" src="/static/js/jquery-3.4.1.js"></script>
        <script type="text/javascript" src="/static/js/login.js"></script>
        <title>登录页</title>
    </head>
    <body>
        <div class="head">
            <h1>登录</h1>
            <form id="loginForm" >
                <div class="text_input">
                    <label>账号</label>
                    <input class="text" type="text" name="username" value="">
                </div>
                <div class="text_input">
                    <label>密码</label>
                    <input class="text" type="password" name="password" value="">
                </div>
                <input type="checkbox" name="remember-me" value="true">记住我
                <input class="submit" type="button" name="submit" value="登录" onclick="doLogin()">
        </form>
        </div>
    </body>
</html>