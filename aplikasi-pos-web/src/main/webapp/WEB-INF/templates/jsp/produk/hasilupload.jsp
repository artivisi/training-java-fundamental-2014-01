<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hasil Upload</title>
    </head>
    <body>
        <h1>Hasil Upload</h1>
        
        Jumlah yang sukses diimport : ${hasil.data.size()}
        
        <h2>Gagal import</h2>
        
        <table class="table table-condensed table-bordered">
            <thead>
                <tr>
                    <th>Baris</th>
                    <th>Keterangan</th>
                    <th>Data</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${hasil.daftarError}" var="e">
                <tr>
                    <td>${e.baris}</td>
                    <td>${e.keterangan}</td>
                    <td>${e.data}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>

        
    </body>
</html>
