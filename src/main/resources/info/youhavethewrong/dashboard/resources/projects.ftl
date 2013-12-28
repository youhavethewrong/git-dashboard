<#-- @ftlvariable name="" type="info.youhavethewrong.dashboard.resources.ProjectView" -->
<!DOCTYPE html>
<html>
    <head>
        <title>Projects committed to recently</title>
        <meta charset="utf8">
        <link rel="stylesheet"
            type="text/css"
            href="//ecik.youhavethewrong.info/0.2/themes/bootstrap-responsive.min.css"/>
        <link rel="stylesheet" 
            type="text/css" 
            href="//ecik.youhavethewrong.info/0.2/strapdown.css"/>
        <link rel="stylesheet" 
            type="text/css" 
            href="//ecik.youhavethewrong.info/0.2/themes/readable.min.css"/>
        <script src="//ecik.youhavethewrong.info/tic/jquery-1.10.2.js"></script>
    </head>

    <body>

    <div class="navbar navbar-fixed-top">
        <div class="navbar-inner">
            <div class="container">
                <div class="brand" id="headline"> <a href="//ecik.youhavethewrong.info">YouHaveTheWrong.info</a> </div>
            </div>
        </div>
    </div>

    <div id="content" class="container">

    <div id="h2"><h2>These projects have been worked on recently.</h2></div>
    <ul>
        <#list projects as i>
            <li>${i}</li>
        </#list> 
    </ul>
    </div>
    </body>
</html>
