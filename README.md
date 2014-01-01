git-dashboard
=============

Keep track of which of your git projects have recent commits with git-dashboard.  This project is intended to allow you to easily stay on top of which projects have been worked on.  All you have to do is modify your '''post-receive''' git hook.


Git Configuration
----
Just modify your hook to make a call like this:

    curl -v -H "Content-Type: application/json" -X POST -d '{"id":"8e914a7d2522b8722145050890f3b7d0653cf1a4", "message":"initial", "author":"Negated <youhavethewrong@gmail.com>", "project":"git-dashboard"}' http://localhost:8080/


Customization
----
To change the look and branding, just modify the FreeMarker templates in:

    src/main/resources/info/youhavethewrong/dashboard/resources/
