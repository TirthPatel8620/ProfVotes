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
        input[type="radio"]{
            width: auto;
            justify-content: none;
            padding: 0px;
            margin: 0px;
            text-align: none;
            border-radius: 0px;
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
            <li><a href="adminLogin.jsp"><i class="fa fa-user"></i> admin Login</a></li>
            <li><a href="login.jsp"><i class="fa fa-check"></i> Vote</a></li>
            <li><a href="index.jsp"><i class="fa fa-fw fa-home"></i> Home</a></li>
            
        </ul>
        
    </nav>
    <br><br><br><br><br><br>
    <div class="loginBox">
        <form action="SignupController" method="post">
        <h3 style="text-align: center; color: #25316D; font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif; font-weight: bold; padding: 5px;
        margin: 7px;" >Sign Up</h3>
            <input type="text" placeholder="Enter Name" name="name" />
            <input type="text" placeholder="Enter Email" name="email" />
            <input type="text" placeholder="Enter Mobile Number" name="mobile" />
            
            <p style="text-align: center;">Gender:<input type="radio" name="gender" id="male" value="male"> Male <input type="radio" name="gender" id="female" value="female"> Female</p>
            <input type="password" placeholder="Enter Password" id="password" name="password" />
            <input type="text" placeholder="Confirm Password" id="cpassword" name="conpassword" onchange="passCheck()" />
            <p style="color: red; text-align: center;" id="msg"></p>
            <input type="submit" value="Sign Up" id="signup" name="signup" />
            <p style="text-align: center;">Already have an account?<a href="login.jsp">click here to login...</a></p>
        </form>

    </div>
    
    
    <br><br><br><br><br><br>
    <script>
        
        function passCheck(){
            
            var pw = document.getElementById("password").value;
            var cpw=document.getElementById("cpassword").value;
            if(pw==cpw){
                
                document.getElementById("msg").innerHTML="";
                document.getElementById("login").disabled = false;
            }
            else{
                document.getElementById("msg").innerHTML="Password and Confirm Password didn't match...";
                // alert("Password and Confirm Password didn't match...");
                document.getElementById("login").disabled = true;
            }
        }
        
    </script>
</body>
</html>