<#-- @ftlvariable name="" type="info.youhavethewrong.dashboard.resources.CommitView" -->
<html>
    <body>
        <h1>Hello, ${commit.author?html}!</h1>
        <p>I see you committed ${commit.id?html} from project ${commit.project?html}.</p>
    </body>
</html>