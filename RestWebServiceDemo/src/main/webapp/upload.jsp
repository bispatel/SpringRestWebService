<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Upload File Example</title>
</head>
<body>
    <h1>Upload File</h1>
    <form action="rest/test/upload" method="post" enctype="multipart/form-data">
        <p>Select a file : <input type="file" name="file"/></p>
        <input type="submit" value="Upload File" />
    </form>
</body>
</html>