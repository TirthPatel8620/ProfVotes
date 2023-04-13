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
        .voteBox{
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
<body >
    <nav class="upperNav">
        <ul>
            <li style="float: left; color: aliceblue;  justify-content: center; font-size: 30px;
            padding: 7px; margin: 3px; font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif ;">
                ProfVotes </li>
            <li><a href="logout.jsp"><i class="fa fa-sign-out" ></i> Log Out</a></li>
            <li><a href="home.jsp"><i class="fa fa-fw fa-home"></i> Home</a></li>
            
        </ul>

    </nav>
    <br><br><br><br><br><br>

    <div class="voteBox">
        <form action="home.html" method="post">
        <h3 style="text-align: center; color: #25316D; font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif; font-weight: bold; padding: 5px;
        margin: 7px;" >Vote</h3>
            <p style="color: red; text-align: center;">Submit Vote will enable only after selecting vote</p>
            <input type="radio" id="candidate1" onclick="voteCheck()" name="voteOption"> <p style="text-align: center; justify-content: center;" > Candidate 1 Name</p> <br>
            <input type="radio" id="candidate2" onclick="voteCheck()" name="voteOption"> <p style="text-align: center; justify-content: center;" > Candidate 2 Name</p> <br>
            <input type="radio" id="candidate3" onclick="voteCheck()" name="voteOption"> <p style="text-align: center; justify-content: center;" > Candidate 3 Name</p> <br>
            <p style="color: red; text-align: center;">Note, if you have already given vote and giving vote again, your previous vote will be ignored...</p>
            <input type="submit" value="Submit Vote" id="vote" name="vote" disabled>
            
        </form>

    </div>

    <br><br><br><br><br><br>
    <script>
       
        function voteCheck(){
            document.getElementById("vote").disabled=false;
        }
       
    </script>

</body>
</html>