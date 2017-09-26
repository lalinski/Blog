<!DOCTYPE html>
<!-- saved from url=(0038)http://v3.bootcss.com/examples/signin/ -->
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="http://v3.bootcss.com/favicon.ico">

<title>Signin Template for Bootstrap</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link href="css/ie10-viewport-bug-workaround.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/signin.css" rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script	src="js/ie-emulation-modes-warning.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<style type="text/css" adt="123"></style>
<!-- <script src="/js/dislodge-baidu.js"></script> -->
<link href="/Blog/css/home.css" rel="stylesheet">
</head>

<body>
	<#if Request.loginResult?? >
		<input type="hidden" name="code" id="code" value="${Request.loginResult.code}"/>
	</#if>
    <div class="container" style="text-align: center;">
		
      <form id="form-signin" class="form-signin" method="post" action="/Blog/dologin">
        <h2 class="form-signin-heading">Please sign in</h2>
     <!--   <input type="username" name="username" id="username" class="form-control" placeholder="Username" required="" autofocus=""> -->
        <input type="text" name="username" id="username" class="form-control" placeholder="Username" required="" autofocus="">
   <!--     <input type="password" id="beforePassword" class="form-control" placeholder="Password" required=""> -->
        <input type="password" name="password" class="form-control" placeholder="Password" required="">
      <!--  <input type="hidden" name="password" id="password" value="aa"/> -->
        <!-- 暂时不启用Remember me -->
        <!-- <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div> -->
    <!--    <button class="btn btn-lg btn-primary btn-block" id="submit">Sign in</button>  -->
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
	  </form>
	  <!-- 登录失败信息展示 -->
	  <#if Request.loginResult?? >
	  <label id="message_show">
	  	<button type="button" class="close" aria-label="Close">
				<span aria-hidden="true">&times;</span>
		</button>
			${Request.loginResult.message}
			<!-- Please check your username or password! -->
	  </label>
	  </#if>
	  
	</div> <!-- /container -->
	
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="/Blog/js/ie10-viewport-bug-workaround.js"></script>
    <!-- 登录js需要的jQuery -->
	<script src="/Blog/js/jquery.min.js"></script>
	<!-- 弹框 -->
<!-- 	<script src="/Blog/js/jquery.bootstrap-growl.min.js"></script> -->
    <!-- md5加密 -->
    <script src="/Blog/js/md5.js"></script>
  	<!-- 登录js -->
    <script src="/Blog/js/login.js"></script>

</body>
</html>