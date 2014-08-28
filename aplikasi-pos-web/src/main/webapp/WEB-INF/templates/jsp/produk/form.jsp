<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Produk</title>
    </head>
    <body>
        <h1>Edit Produk</h1>
        
        <form method="POST">
            <table border="1">
                <tbody>
                    <tr>
                        <td>Kode</td>
                        <td><input type="text" name="kode" value="${produk.kode}"></td>
                    </tr>
                    <tr>
                        <td>Nama</td>
                        <td><input type="text" name="nama" value="${produk.nama}"></td>
                    </tr>
                    <tr>
                        <td>Harga</td>
                        <td><input type="text" name="harga" value="${produk.harga}"></td>
                    </tr>
                    <tr>
                        <td>Tanggal Kadaluarsa</td>
                        <fmt:formatDate pattern="dd-MM-yyyy" var="tanggalKadaluarsa" value="${produk.tanggalKadaluarsa}" />
                        <td><input type="text" name="tanggalKadaluarsa" value="${tanggalKadaluarsa}"></td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td><input type="submit" value="Simpan"></td>
                    </tr>
                </tbody>
            </table>

        </form>
        
    </body>
</html>
