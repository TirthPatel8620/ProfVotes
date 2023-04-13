<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ManageVoter</title>
<link rel="stylesheet" href="Webcss.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
			<li
				style="float: left; color: aliceblue; justify-content: center; font-size: 30px; padding: 7px; margin: 3px; font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;">
				ProfVotes</li>
			<li><a href="logout.jsp"><i class="fa fa-sign-out"></i> Log Out</a></li>

			<li><a href="ManageVoter"><i class="fa fa-tasks"></i> Manage Voters</a></li>
			<li><a href=""><i class="fa fa-tasks"></i> Manage Admins</a></li>
			<li><a href="authorityHome.jsp"><i class="fa fa-home"></i> Home</a></li>

		</ul>

	</nav>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<div class="showProf">

		<table><p style="background-color:#8D9EFF;color:#E14D2A;font-size:larger">
		Vote to candidate 1 : ${candidate1Vote}<br>
		Vote to candidate 2 : ${candidate2Vote}<br>
		Vote to candidate 3 : ${candidate3Vote}<br>
		Vote to nota : ${notaVote}<br>
		Total Votes : ${totalLen}<br>
		Winner Candidate is ${winnerCandidate} got ${winnerVote} votes.
		</p>
			<tr>

				<th>Name</th>
				<th>Vote</th>
				<th>Email Address</th>
			</tr>
			<c:forEach var="vte" items="${votereviewlist}">
			<tr>
				<td>${vte.name}</td>
				<td>${vte.vote}</td>
				<td>${vte.email}</td>
				
			</tr>
			</c:forEach>
		</table>
	</div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<script>
		let g = document.getElementById("voterGen").innerHTML;
		if (g === "male") {
			document.getElementById("genImg").src = "./assets/pictures/male.jpg";
		} else if (g === "female") {
			document.getElementById("genImg").src = "./assets/pictures/female.png";
		}
	</script>

</body>
</html>