<html>
    <head>
        <title>注册</title>
        <link rel="stylesheet" href="/static/css/style.css" type="text/css" >
        <script language="JavaScript" type="text/javascript" src="/static/js/jquery-3.4.1.js" ></script>
        <script  language="JavaScript" type="text/javascript" src="/static/js/register.js"></script>
    </head>

    <body>
        <div class="head">
            <h1>注册</h1>
                   <form  id="registerForm" >
                       <div class="text_input">
                           <label>账号</label>
                           <input class="text" type="text" id="username" name="username" value="" onchange="userNameCheck()">
                       </div>
                       <div class="text_input">
                           <label>密码</label>
                           <input class="text" type="password" id="password" name="password" value="">
                       </div>
                       <div class="text_input">
                           <label>确认密码</label>
                           <input class="text" type="password" id="passwordRecheck" name="password" onchange="passwordRecheck()">
                       </div>
                       <div class="text_input">
                           <label>邮箱</label>
                           <input class="text" type="text" id="emailStep1" name="email" onchange="emailCheck()">
                       </div>
                       <#--<div class="text_input">-->
                           <#--<label>状 态</label>-->
                           <#--<input class="text" type="text" id="status" name="status">-->
                       <#--</div>-->
                   </form>

                   <form  id="emailConfigForm" style="display: none">
                       <div class="text_input">
                           <label>邮箱</label>
                           <input class="text" type="text" disabled="disabled" id="emailStep2" name="email" >
                       </div>
                       <div class="text_input">
                           <label>验证码</label>
                           <input class="text" type="text" id="emailActiveCode" name="emailActiveCode">
                           <input type="button" name="getEACode" onclick="getEmailActiveCode()" value="获取验证码">
                       </div>
                       <input type="button" name="confirmEACode" onclick="confirmEmailActiveCode()" value="验证">
                   </form>
            <button onclick="forward()" name="forward" value="">上一步</button>
            <button onclick="next(step)" name="next" value="">下一步</button>
        </div>
    </body>
</html>
