		<!-- 侧边栏 -->
        <div class="col-sm-2  blog-sidebar">
        <!-- 
          <div class="sidebar-module sidebar-module-inset">
            <h4>About</h4>
            <p>Etiam porta <em>sem malesuada magna</em> mollis euismod. Cras mattis consectetur purus sit amet fermentum. Aenean lacinia bibendum nulla sed consectetur.</p>
          </div>
           -->
          <#if (homePager.dateGroup)??>
          <div class="sidebar-module">
            <h4>Archives</h4>
            <ol class="list-unstyled">
              <#list homePager.dateGroup as date>
              <li><a href="/archives/${date}">${date}</a></li>
              </#list>
            </ol>
          </div>
          </#if>
          <div class="sidebar-module">
            <h4>Elsewhere</h4>
            <ol class="list-unstyled">
              <li><a href="https://github.com/lalin" target="_blank">GitHub</a></li>
              <li><a href="mailto:761571595@qq.com">Email</a></li>
              <li style="display:none"><a href="https://my.oschina.net/Shawn1in/blog" target="_blank">OSChina</a></li>
            </ol>
          </div>
<!--           <div class="sidebar-module">
            <h4>Friendly Link</h4>
            <ol class="list-unstyled">
              <li><a href="https://github.com/Pickacat">GitHub</a></li>
              <li><a href="mailto:13927425737@163.com">Email</a></li>
            </ol>
          </div> -->
          
        </div><!-- /.blog-sidebar -->