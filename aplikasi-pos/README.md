Aplikasi Point of Sale

Fitur Aplikasi:

* Transaksi Penjualan
* Transaksi Barang Masuk
* Master Kategori
* Master Produk
* Master Customer
* Master Supplier

Package dalam Aplikasi:
* Domain Object : mendefinisikan struktur data
* Data Access Object : mengelola akses ke database (insert, update, delete, search)
* Business Service : proses bisnis
* User Interface : menerima input, validasi input, konversi tipe data, menampilkan output

Menggunakan Driver Database Oracle

1. Download dari [websitenya](http://www.oracle.com/technetwork/database/enterprise-edition/jdbc-10201-088211.html)
2. Install di folder .m2 dengan perintah berikut

    ```
    mvn install:install-file -Dfile=ojdbc14.jar -DgroupId=com.oracle -DartifactId=ojdbc14 -Dversion=10.2.0.5 -Dpackaging=jar
    ```
3. Gunakan di project dengan menambahkan dependensinya di `pom.xml`

    ```
    <dependency>
     <groupId>com.oracle</groupId>
     <artifactId>ojdbc14</artifactId>
     <version>10.2.0.5</version>
    </dependency>
    ```
