<!DOCTYPE html>
<html lang="zh">
    <head>
        <meta charset="utf-8" />
        <title>Simple example - Editor.md examples</title>
        
        <link rel="stylesheet" href="../css/editormd/editormd.css" type="text/css">
        <link rel="stylesheet" href="../css/editormd/style.css" type="text/css"/>  
        
        <link rel="shortcut icon" href="https://pandao.github.io/editor.md/favicon.ico" type="image/x-icon" />

    </head>
    <body>
        <div id="layout">
            <header>
                <h1>Simple example</h1>
            </header>
           <div id="test-editormd">
                <textarea style="display:none;">
                   aaaaaaaaaaaa
                </textarea>

           </div>
        </div>
        <script src="../js/jquery.min.js"></script>
        <script src="../js/editormd.min.js"></script> 
        
  <!--     <script src="https://cdn.bootcss.com/jquery/3.1.1/jquery.min.js"></script>
        <script src="../js/editormd.js"></script>  -->
        <script type="text/javascript">

           var testEditor;

           $(function() {
   
              testEditor = editormd("test-editormd", {
 
              width   : "90%",
      
              height  : 640,
     
              syncScrolling : "single",
     
              path    : "../lib/"
   
           });

        });
    </script>
    </body>
</html>