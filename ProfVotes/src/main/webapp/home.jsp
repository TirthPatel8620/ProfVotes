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
        table,
        th,
        tr,
        td {
            align-items: center;
            text-align: center;
            justify-content: center;
            margin: 5px;
            padding: 5px;
            
            /* border: 0.5px solid gray; */
            background-color: #EAEAEA;
            border-collapse: collapse;
            text-align: left;
            color: #3C4048;
            width: 99%;
            border-radius: 10px;
            font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
        }
        th,
        td {
            
            padding: 20px;
        }
        td{

            width: 50%;
        }
        th{
            width: 50%;
        }
     
    
    </style>
</head>

<body>

    <nav class="upperNav">
        <ul>
            <li style="float: left; color: aliceblue;  justify-content: center; font-size: 30px;
            padding: 7px; margin: 3px; font-family:'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif ;">
                ProfVotes </li>
                <li><a href="logout.jsp"><i class="fa fa-sign-out" ></i> Log Out</a></li>
          

            <li><a href="vote.jsp"><i class="fa fa-check"></i> Vote</a></li>

        </ul>

    </nav>
    <br><br><br><br><br><br>
	

    <div class="showProf">
        <table >
            <tr aria-colspan="2">
               
			<img src='' style="height: 200px; width:200px;" id="genImg" alt="">
            </tr>
            <tr>
                <th>Id</th>
                <td>${voter.id}</td>
            </tr>
            <tr>
                <th>Name</th>
                <td>${voter.name}</td>
            </tr>
            <tr>
                <th>Gender</th>
                <td id="voterGen">${voter.gender}</td>
            </tr>
            <tr>
                <th>Mobile Number</th>
                <td>${voter.mobile}</td>
            </tr>
            <tr>
                <th>Role</th>
                <td>Voter</td>
            </tr>
            <tr>
                <th>Email Address</th>
                <td>${voter.email}</td>
            </tr>
        </table>
    </div>

    <br><br><br><br><br><br>
        <script>
        let g=document.getElementById("voterGen").innerHTML;
        if (g==="male") {
            document.getElementById("genImg").src="./assets/pictures/male.jpg";
        }
        else if(g==="female"){
            document.getElementById("genImg").src="./assets/pictures/female.png";
        }
    </script>
    
</body>

</html>