-- create table produk(
--   id integer primary key,
--   kode varchar2,
--   nama varchar2,
--   harga decimal(19,2),
--   tanggal_kadaluarsa date
-- );
-- 
-- create table customer(
--     id_csr integer primary key,
--     kode_csr varchar2(20),
--     nama_csr varchar2(255),
--     alamat_csr varchar2(255),
--     tanggal_daftar date
-- );

create table penjualan(
    id integer primary key,
    nama_barang varchar2(50),
    nama_pembeli varchar2(50),
    jml_barang integer,
    harga decimal(19,2),
    tgl_penjualan date
);