<#-- @ftlvariable name="" type="info.youhavethewrong.dashboard.resources.ProjectView" -->
<html>
    <body>
        <h2>These projects have been worked on recently.</h2>
        <ul>
        <#list projects as i>
            <li>${i}</li>
        </#list> 
        </ul>
    </body>
</html>