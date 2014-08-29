<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Daftar Produk</title>
    </head>
    <body>
        <h1>Daftar Produk</h1>
        
        <a href="form">Tambah Data Produk</a>
        <a href="download">Download Data Produk</a>
        
        Jumlah produk : ${daftarProduk.size()}
        
        <table border="1">
            <thead>
                <tr>
                    <th>Kode</th>
                    <th>Nama</th>
                    <th>Harga</th>
                    <th>Tanggal Kadaluarsa</th>
                    <th>&nbsp;</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${daftarProduk}" var="x">
                <tr>
                    <td>${x.kode}</td>
                    <td>${x.nama}</td>
                    <td>${x.harga}</td>
                    <td>${x.tanggalKadaluarsa}</td>
                    <td>
                        <a href="form?id=${x.id}">edit</a> |
                        <a href="hapus?id=${x.id}">delete</a>                        
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>

        
    </body>
</html>
