<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>
<!DOCTYPE HTML>
<html lang="en-US">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="refresh" content="1;url=http://example.com">
    <script type="text/javascript">
        window.location.href = "/login/index"
    </script>
    <title>Page Redirection</title>
</head>
<body>
<!-- Note: don't tell people to `click` the link, just tell them that it is a link -->
If you are not redirected automatically, follow the <a href='/login/index'>link to example</a>
</body>
</html>