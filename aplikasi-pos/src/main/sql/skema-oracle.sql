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

create table kantor_cabang(
    id_kantorCbg integer primary let,
    kode_kantorCbg vsrchar2,
    nama_kantorCbg varchar2,
    alamat_kantorCbg varchar2,
    noTelp_kantorCbg varchar2,
    namaKepala_kantorCbg varchar2
);



