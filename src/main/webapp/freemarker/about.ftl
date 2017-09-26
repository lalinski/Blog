<!DOCTYPE html>
<html lang="zh-CN">
<#include "/include/head.ftl">
<body>
	<#include "/include/nav_top.ftl">

	<!-- 内容栏 -->
	<div class="container">

		<div class="row">

			<div class="col-sm-12 blog-main">

				<br>
				<div class="blog-post">
				${(blogger.html)!}
				</div>
				<!-- /.blog-post -->

			</div>
			<!-- /.blog-main -->

		</div>
		<!-- /.row -->

	</div>
	<!-- /.container -->

	<#include "/include/footer.ftl">

</body>
</html>