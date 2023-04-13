<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <title>Review</title>
    <link rel="stylesheet" href="Webcss.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <style>
        .card {
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
            max-width: 300px;
            margin: auto;
            text-align: center;
            font-family: arial;
        }

        .title {
            color: grey;
            font-size: 18px;
        }

        button {
            border: none;
            outline: 0;
            display: inline-block;
            padding: 8px;
            color: white;
            background-color: #000;
            text-align: center;
            cursor: pointer;
            width: 100%;
            font-size: 18px;
        }

        .aCss {
            text-decoration: none;
            font-size: 22px;
            color: black;
        }

        button:hover,
        a:hover {
            opacity: 0.7;
        }
    </style>
</head>

<body>
    <nav class="upperNav">
        <ul>
            <li style="float: left; color: aliceblue;  justify-content: center; font-size: 30px;
            padding: 7px; margin: 3px; font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif ;">
                ProfVotes </li>
                
            <li><a href="login.jsp"><i class="fa fa-tasks"></i> Log In</a></li>
            <li><a href="index.jsp"><i class="fa fa-fw fa-home"></i> Home</a></li>

        </ul>

    </nav>
    <br><br><br><br><br><br>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <!-- With big size -->

    <h2 style="text-align:center">Developer Profile Card</h2>

    <div class="card">
        <img src="/w3images/team2.jpg" alt="John" style="width:100%">
        <h1>John Doe</h1>
        <p class="title">CEO & Founder, Example</p>
        <p>Harvard University</p>
        <div style="margin: 24px 0;">
            <a href="#" class="aCss"><i class="fa fa-dribbble"></i></a>
            <a href="#" class="aCss"><i class="fa fa-twitter"></i></a>
            <a href="#" class="aCss"><i class="fa fa-linkedin"></i></a>
            <a href="#" class="aCss"><i class="fa fa-facebook"></i></a>
        </div>
        <p><button>Contact</button></p>
    </div>


</body>

</html>