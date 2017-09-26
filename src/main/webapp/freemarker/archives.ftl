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

        <div class="col-sm-6 col-md-12 blog-main">
		<#if archivePager??>
          <div class="blog-post">
            <h2 class="blog-post-title">Blog List</h2>
            <hr>
          	<#list archivePager.blogList as blog>
          	<table style="text-align: left;">
          		<tbody>
	                <tr>
	                  <td >${blog.date?string("yyyy-MM-dd")} &nbsp;&nbsp;</td>
	                  <td style="display: table-cell;vertical-align: inherit; "><a href="/Blog/blog/${blog.id}">${blog.title}</a></td>
	                </tr>
          		</tbody>
          	</table>
			</#list>
          </div><!-- /.blog-post -->
          <#else>
          <h2 class="blog-post-title">博主暂时还没写博文</h2>
		</#if>


        </div><!-- /.blog-main -->

		

      </div><!-- /.row -->

    </div><!-- /.container -->

	<#include "/include/footer.ftl">

</body></html>