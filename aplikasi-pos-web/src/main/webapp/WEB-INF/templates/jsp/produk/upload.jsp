<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Upload Data Produk</title>
    </head>
    <body>
        <h1>Upload Data Produk</h1>
        
        <form method="post" enctype="multipart/form-data">
            Data produk (dalam csv) 
            <input type="file" name="dataProduk">
            <input type="submit" value="Proses">
        </form>
        
    </body>
</html>
