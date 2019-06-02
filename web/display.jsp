<%--
  Created by IntelliJ IDEA.
  User: saura
  Date: 6/2/2019
  Time: 12:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>OCR Result</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <style>
        pre {
            background: none;
            border: none;
        }

        h1 {
            color: #ff4411;
            font-size: 48px;
            font-family: 'Axure Handwriting', sans-serif;
        }
    </style>
</head>
<body>

<div class="container" style="padding: 20px;">
    <h1 style="margin:78px 15px;">OCR Result</h1>
    <div class="col-md-6" style="height: 455px !important; border: 2px solid black; ">
        <div style="padding: 20px 40px">
            <h3 style="margin-bottom: 20px;">Image Data: </h3>
            <img src="${image}" width="90%">
        </div>
    </div>

    <div class="col-md-6">
        <div style="border: 2px solid black;height: 455px !important; padding: 20px 40px">
            <h3 style="margin-bottom: 20px;">Text Data: </h3>
            <p class="page-information">
                ${result}
            </p>
        </div>
    </div>
</div>

</body>
</html>
