<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
body{
height: 100vh;
display: flex;
justify-content: center;
align-items: center;
}

.container{
height:400px;
width: 400px;
display: flex;
justify-content: center;
align-items: center;
background: #aaaaaa;
}
.container label{
display: block;
}
</style>
</head>
<body>
<div class="container">
<form action="/register" >
<label for="name">Username</label>
<input type="text" name="username" id="name">
<label for="mail">Email</label>
<input type="email" name="mail" id="mail">
<label for="">Password</label>
<input type="password" name="password">
<label for="">Re-password</label>
<input type ="password" name="re-password">
<input type="submit" value="submit">
</form>
</div>

</body>
</html>