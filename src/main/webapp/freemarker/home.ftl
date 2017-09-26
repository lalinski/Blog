<!DOCTYPE html>
<html lang="zh-CN">
<#include "/include/head.ftl">
<body>
	<!-- 导航栏 -->
	<#include "/include/nav_top.ftl">

	<!-- 内容栏 -->
    <div class="container">

      <div class="blog-header">
    <!--     <h1 class="blog-title">Shawn's Blog</h1>
        <p class="lead blog-description">This blog records what i learned.</p> -->
      </div>  

      <div class="row">

        <div class="col-sm-10 blog-main">
		<#if homePager??>
          <div class="blog-post">
            <h2 class="blog-post-title">${(homePager.blog.title)!}</h2>
            <p class="blog-post-meta">Edited at ${(homePager.blog.date?datetime)!}</p>

            <div>${(homePager.blog.html)!}</div>
          </div><!-- /.blog-post -->
          <#else>
          <h2 class="blog-post-title">博主暂时还没写博文</h2>
		</#if>


		<#include "/include/pager.ftl">

        </div><!-- /.blog-main -->

		
		<!-- 侧边栏 -->
		<#include "/include/nav_sidebar.ftl">

      </div><!-- /.row -->

    </div><!-- /.container -->

	<#include "/include/footer.ftl">

</body></html>