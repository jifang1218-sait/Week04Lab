<%-- 
    Document   : editnote
    Created on : Jan 26, 2023, 2:43:05 AM
    Author     : jifang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>Edit Note</h2><br>
        <form method="POST" action="note">
            Title: <input type="text" name="title" value="${note.title}"><br>
            Contents: <textarea name="content" rows="4" cols="20">${note.content}</textarea><br>
        <input type="submit" value="Save">
        </form>
    </body>
</html>
