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

        <form method="POST"  class="form-horizontal" role="form">
            <div class="form-group">
                <label for="kode" class="col-sm-2 control-label">Kode</label>
                <div class="col-sm-10">      
                    <input type="text" id="kode" name="kode" value="${produk.kode}">
                </div>
            </div>
            <div class="form-group">
                <label for="nama" class="col-sm-2 control-label">Nama</label>
                <div class="col-sm-10">      
                    <input type="text" id="nama" name="nama" value="${produk.nama}">
                </div>
            </div>
            <div class="form-group">
                <label for="harga" class="col-sm-2 control-label">Harga</label>
                <div class="col-sm-10">      
                    <input type="text"  id="harga" name="harga" value="${produk.harga}">
                </div>
            </div>
            <div class="form-group">
                <label for="tanggalKadaluarsa" class="col-sm-2 control-label">Tanggal Kadaluarsa</label>
                <fmt:formatDate pattern="dd-MM-yyyy" var="tanggalKadaluarsa" value="${produk.tanggalKadaluarsa}" />
                <div class="col-sm-10">      
                    <input type="text" id="tanggalKadaluarsa" name="tanggalKadaluarsa" value="${tanggalKadaluarsa}">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">Simpan</button>
                </div>
            </div>

        </form>

    </body>
</html>
