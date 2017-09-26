          <nav>
            <ul class="pager">
              <#if (homePager.preBlog)??>
              <li><a href="/Blog/blog/${(homePager.preBlog.id)!}">↑ ${(homePager.preBlog.title)!}</a></li>
              </#if>
              <#if (homePager.nextBlog)??>
              <li><a href="/Blog/blog/${(homePager.nextBlog.id)!}">↓ ${(homePager.nextBlog.title)!}</a></li>
              </#if>
            </ul>
          </nav>