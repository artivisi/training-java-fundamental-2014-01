create table produk(
  id integer primary key,
  kode varchar2,
  nama varchar2,
  harga decimal(19,2),
  tanggal_kadaluarsa date
);

create table customer(
    id_csr integer primary key,
    kode_csr varchar (10),
    nama_csr varchar(30),
    alamat_csr varchar (50),
    tanggal_daftar date
);

<<<<<<< HEAD
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
  id integer primary key,
  kode varchar2,
  nama varchar2,
  definisi varchar2
>>>>>>> b56e4c0904fb40dfd3e6fe9f4e0d2074cd82d997
);