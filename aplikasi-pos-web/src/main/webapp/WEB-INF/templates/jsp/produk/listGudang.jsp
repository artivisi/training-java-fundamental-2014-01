<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Daftar Produk</title>
    </head>
    <body>
        <h1>Daftar Gudang</h1>

        <a href="form">Tambah Data Gudang</a>

        Jumlah produk : ${daftarGudang.size()}

        <table border="1">
            <thead>
                <tr>
                    <th>kode Gudang</th>
                    <th>nama Gudang</th>
                    <th>alamat Gudang</th>
                    <th>nama Barang</th>
                    <th>stok Barang</th>
                    <th>&nbsp;</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${daftarGudang}" var="x">
                    <tr>
                        <td>${x.kodeGudang}</td>
                        <td>${x.namaGudang}</td>
                        <td>${x.alamatGudang}</td>
                        <td>${x.namaBarang}</td>
                        <td>${x.stokBarang}</td>
                        <td>
                            <a href="form?id=${x.id}">edit</a> 
                            <a href="hapus?id=${x.id}">delete</a>                        
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>


    </body>
</html>
