<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Accueil Agent</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
            background: #f4f4f4;
        }

        h2 {
            color: #333;
        }

        form {
            margin-top: 20px;
            width: 80%;
            text-align: center;
        }

        input[type="submit"] {
            background-color: #4caf50;
            color: #fff;
            border: none;
            padding: 10px 15px;
            font-size: 14px;
            margin: 5px;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

<h2>Accueil Agent</h2>

<form action="ListerHotelsServlet" method="get">
    <input type="submit" value="Consulter la liste des hôtels">
</form>

<form action="AddHotelServlet" method="get">
    <input type="submit" value="Ajouter un nouvel hôtel">
</form>

<form action="edit-hotel.jsp" method="get">
    <input type="submit" value="Modifier un hôtel">
</form>

<form action="DeleteHotelServlet" method="post">
    <input type="submit" value="Supprimer un hôtel">
</form>

<form action="IndexServlet" method="get">
    <input type="submit" value="Se déconnecter">
</form>

</body>
</html>
