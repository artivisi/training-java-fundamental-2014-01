create table produk(
  id integer primary key,
  kode varchar2,
  nama varchar2,
  harga decimal(19,2),
  tanggal_kadaluarsa date
);

create table customer(
    id_csr integer primary let,
    kode_csr varchar2,
    nama_csr varchar2,
    alamat_csr varchar2,
    tanggal_daftar date
);

create table region(
    id integer primary key,
    idregion varchar2(15),
    provinsi varchar2(50),
    kota varchar2(50),
    kecamatan varchar2(50),
    desa varchar2(50),
    created date
);