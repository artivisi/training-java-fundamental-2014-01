create table produk(
  id integer primary key,
  kode varchar2,
  nama varchar2,
  harga decimal(19,2),
  tanggal_kadaluarsa date
);

create table customer(
    id_csr integer primary let,
    kode_csr vsrchar2,
    nama_csr varchar2,
    alamat_csr varchar2,
    tanggal_daftar date
);

create table customer(
    id integer primary let,
    kode_gudang vsrchar2,
    nama_gudang varchar2,
    alamat_gudang varchar2,
    nama_barang varchar2,
    strok_barang integer
);

