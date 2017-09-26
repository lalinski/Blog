<!DOCTYPE html>
<html lang="zh-CN">
<head>
<#include "/include/admin_head.ftl">
</head>
  <body>

	<!-- 顶部导航系统 -->
	<#include "/include/admin_nav_top.ftl">
    
    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-6  col-md-12 main">
        
          <h2 class="sub-header">Blog list</h2>
          <div class="table-responsive">
            <#if blogList??>
            <table class="table table-striped table-bordered">
              <tbody>
                <tr>
                  <td><strong>#</strong></td>
                  <td hidden>Id</td>
                  <td><strong>Title</strong></td>
                  <td><strong>CreateDate</strong></td>
                  <td><strong>LastUpdate</strong></td>
                  <td><strong>Options</strong></td>
                </tr>
            <#list blogList as blog>
              	<tr>
					<td>${blog_index+1}</td>
					<td hidden>${blog.id}</td>
					<#if blog.title?length gt 40>
						<td>${blog.title?substring(0,40)}</td>
					<#else>
						<td>${blog.title}</td>
					</#if>
					<td>${blog.date?string("yyyy-MM-dd")}</td>
					<td>${blog.updateTime?datetime}</td>
					<td><button onclick="deleteBlog(${blog.id})"><a href="#">Delete</a></button>&nbsp;&nbsp;
						<button ><a href="blogUpdateView/${blog.id?c}">Update</a></button></td>
				</tr>
              </#list>
              </tbody>
            </table>
            <#else>
            <h4 >Blogs not found</h2>
          	</#if>
          </div>
          <!-- 隐藏表单，用于删除博文 -->
          <form type="hidden" id="deleteForm" method="post" action="blogDelete">
          	<input type="hidden" name="id" id="id" />
          </form>
          
        </div>
      </div>
    </div>
    
	<#include "/include/admin_footer.ftl">
	<script type="text/javascript">
			// 删除方法
			function deleteBlog(id){
				var sure = confirm("确认要删除？");
				// 1为确认，0为取消
				if(sure==1){
					$("#id").val(id);
					$("#deleteForm").submit();
				}
			}
	</script>
</body></html>