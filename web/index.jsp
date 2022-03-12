

<%@page import="java.util.Base64"%>
<%@ page import="java.sql.*"%>

<%@ page import="java.io.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>File Upload</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            .main{
                width: 300px;
                height: 200px;
                position: absolute;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
                text-align: center;
                border: 2px solid;
            }
            form{
                width: 100%;
                position: relative;
                display: block;
                margin: 20px auto;
            }
            input{
                margin: 10px 0;
            }

        </style>
    </head>
    
    <body>
       
        <div class="main">
            <form method="POST" action="UploadServlet" enctype="multipart/form-data" >
                <input type="file" name="file"/>
                <input type="submit" value="Upload"/>
            </form>
            <div class="downlaod">
                <span>1. File Name: Chart.png <a href="DownloadServlet?filename=29.jpg">Download</a></span>
            </div>
        </div>
    </body>
</html>
