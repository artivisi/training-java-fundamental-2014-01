create sequence produk_id_seq start with 1 increment by 1;
create table produk(
  id integer primary key,
  kode varchar2,
  nama varchar2,
  harga decimal(19,2),
  tanggal_kadaluarsa date
);

create table kantor_cabang(
    id_kantorCbg integer primary key,
    kode_kantorCbg varchar2 (10),
    nama_kantorCbg varchar2 (30),
    alamat_kantorCbg varchar2 (50),
    noTelp_kantorCbg varchar2 (20),
    namaKepala_kantorCbg varchar2 (30)
);
create table customer(
    id_csr integer primary,
    kode_csr vsrchar2 (10),
    nama_csr varchar2 (30),
    alamat_csr varchar2 (50),
    tanggal_daftar date
);




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

