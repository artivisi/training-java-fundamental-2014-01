<<<<<<< HEAD
create table produk(
  id integer primary key,
  kode varchar2,
  nama varchar2,
  harga decimal(19,2),
  tanggal_kadaluarsa date
);

create table customer(
    id_csr integer primary,
    kode_csr vsrchar2 (10),
    nama_csr varchar2 (30),
    alamat_csr varchar2 (50),
    tanggal_daftar date
);

create table kantor_cabang(
    id_kantorCbg integer primary let,
    kode_kantorCbg vsrchar2,
    nama_kantorCbg varchar2,
    alamat_kantorCbg varchar2,
    noTelp_kantorCbg varchar2,
    namaKepala_kantorCbg varchar2
);



=======
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

create table customer(
    id_csr integer primary key,
    kode_csr varchar (10),
    nama_csr varchar(30),
    alamat_csr varchar (50),
    tanggal_daftar date
);

create table gudang(
    id_gudang integer primary key,
    kode_gudang varchar(10),
    nama_gudang varchar(30),
    alamat_gudang varchar(50),
    nama_barang varchar(30),
    stok_barang integer
);

create table region(
    id integer primary key,
    id_reg varchar (10),
    provinsi varchar (20),
    kota varchar (30),
    kecamatan varchar (30),
    desa varchar (30),
    created date
);

create table kategori(
    id_kat integer primary key,
    kode_kat varchar (10),
    nama_kat varchar (30)
);
>>>>>>> 502154c58d5a5e58bb7aebb4a9078f7b67811a6e
