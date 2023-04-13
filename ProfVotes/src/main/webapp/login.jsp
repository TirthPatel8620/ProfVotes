<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    
    <title>Vote</title>
    <link rel="stylesheet" href="Webcss.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        .loginBox{
            max-width: 500px;
            align-items: center;
            justify-content: center;
            border: 2px solid #25316D;
            border-radius: 3px;
            background-color: #B4CDE6;
            overflow: hidden;
            margin: auto;
            position: relative;

        }
        
        input{
            width: 95%;
            justify-content: center;
            padding: 7px;
            margin: 9px;
            text-align: center;
            border-radius: 5px;

        }
        input[type="submit"]{
            color: white; 
            font-size: large; 
            font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif; 
            background-color: #25316D;
        }
        input[type="submit"]:hover{
            background-color:#4649FF;
        }
    </style>
</head>
<body>

    <nav class="upperNav">
        <ul>
            <li style="float: left; color: aliceblue;  justify-content: center; font-size: 30px;
            padding: 7px; margin: 3px; font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif ;">
                ProfVotes </li>
            <li><a href="aboutDev.jsp"><img src="./assets/pictures/dev.svg" style="height: 20px;" alt=""> About Developer</a></li>
            <li><a href="adminLogin.jsp"><i class="fa fa-user"></i> Admin Login</a></li>
            <li><a href=""><i class="fa fa-check"></i> Vote</a></li>
            <li><a href="index.jsp"><i class="fa fa-fw fa-home"></i> Home</a></li>
            
        </ul>
        
    </nav>
    <br><br><br><br><br><br>
    <div class="loginBox">
        <form action="LoginController" method="post">
        <h3 style="text-align: center; color: #25316D; font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif; font-weight: bold; padding: 5px;
        margin: 7px;" >User/Voter Log In</h3>
            <input type="text" placeholder="Enter Email Address " name="email">
            <input type="password" placeholder="Enter Password" id="password" name="password" >
            <p style="color: red; text-align: center;" id="msg"></p>
            <input type="submit" value="Log In" id="login" name="login">
            <p style="text-align: center;">Didn't have an account?<a href="signup.jsp">click here to signup...</a></p>
        </form>

    </div>
    
    
    <br><br><br><br><br><br>
    <script>
        
        
        
    </script>
</body>
</html>