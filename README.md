git-dashboard
=============

Keep track of which of your git projects have recent commits with git-dashboard.  Just add a hook like this:

    curl -v -H "Content-Type: application/json" -X POST -d '{"id":"8e914a7d2522b8722145050890f3b7d0653cf1a4", "message":"initial", "author":"Negated <youhavethewrong@gmail.com>", "project":"git-dashboard"}' http://localhost:8080/

