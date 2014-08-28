<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Gudang</title>
    </head>
    <body>
        <h1>Edit Gudang</h1>
        
        <form method="POST">
            <table border="1">
                <tbody>
                    <tr>
                        <td>Kode Gudang</td>
                        <td><input type="text" name="kode" value="${p.kode}"></td>
                    </tr>
                    <tr>
                        <td>Nama Gudang</td>
                        <td><input type="text" name="nama" value="${p.nama}"></td>
                    </tr>
                    <tr>
                        <td>Alamat Gudang</td>
                        <td><input type="text" name="harga" value="${p.harga}"></td>
                    </tr>
                    <tr>
                        <td>Nama Barang</td>
                        <td><input type="text" name="harga" value="${p.harga}"></td>
                    </tr>
                    <tr>
                        <td>Stok Barang</td>
                        <td><input type="text" name="harga" value="${p.harga}"></td>
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
