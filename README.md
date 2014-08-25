Contoh Kode Program Java Fundamental
====================================

* Hello World
* Class dan Object
* Method dan Property
* Encapsulation, Inheritance, Polymorphism

## Hello World ##

* Compile source code

```
javac path/ke/file/Source.java
```

* Menjalankan aplikasi

```
java nama.package.NamaClassYangPunyaMethodMain
```

## Classpath ##

Classpath : path (lokasi) class yang ingin digunakan

Cara setting classpath : 
* opsi command line

* environment variable 

    - menjalankan perintah set/export di command line : hanya berlaku di command line itu saja
    - pasang di environment variable : berlaku seterusnya bahkan setelah reboot


### Cara setting classpath di opsi command line ###

* Linux
```
java -cp /path/pertama:/path/kedua:/bisa/juga/file.jar nama.package.NamaClassYangPunyaMethodMain
```

* Windows
```
java -cp c:/path/pertama;d:/path/kedua;c:/bisa/juga/file.jar nama.package.NamaClassYangPunyaMethodMain
```

### Cara setting classpath di environment variable

* Ubuntu : pasang di file `/etc/environment`
* Windows : Klik kanan My Computer > Properties > Advanced > Environment Variables


