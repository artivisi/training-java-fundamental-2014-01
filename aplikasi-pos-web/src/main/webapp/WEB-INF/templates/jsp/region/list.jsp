<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Daftar Region</title>
    </head>
    <body>
        <h1>Daftar Regional</h1>
        
   
        
        <table border="1">
            <thead>
                <tr>
                    <th>Kode</th>
                    <th>Provinsi</th>
                    <th>Kota</th>
                    <th>Kecamatan</th>
                    <th>&nbsp;</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${daftar}" var="x">
                <tr>
                    <td>${x.idRegion}</td>
                    <td>${x.provinsi}</td>
                    <td>${x.kota}</td>
                    <td>${x.kecamatan}</td>
                    <td>
                        <a href="form?id=${x.id}">edit</a> |
                        <a href="hapus?id=${x.id}">delete</a>                        
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
            Jumlah record :: ${daftar.size()}
        
    </body>
</html>
