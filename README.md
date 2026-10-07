# Minpro-3-PBO-SistemPendataanWargaKurangMampu <br>  

# Judul : Sistem Pendataan Warga Kurang Mampu

---

## 1. Deskripsi Singkat Program  
Pada program ini saya merombak struktur program menggunakan arsitektur MVC untuk memisahkan logika data, tampilan, dan pengontrol program. Di dalam program ini pengguna bisa menambah data warga, menampilkan daftar warga, menampilkan ringkasan data warga, mengubah data, dan menghapus data dari daftar. Program ini berfokus pada pendataan warga kurang mampu (kategori Warga Lansia dan Warga Disabilitas) serta menentukan kelayakan penerimaan bantuan sosial dari pemerintah secara otomatis.

---  

## 2. Penjelasan Class & Atribut  
Pada project ini, strukturnya dibagi ke beberapa package dan class sesuai konsep MVC, yaitu:  

Pada Package pendataanwarga.model disini ada :  

* ValidasiSyarat (Interface)
  * Method: cekKelayakanBantuan(), getCatatanBantuan()

* Warga (superclass & abstract class) 
  * nik
  * nama
  * alamat
  * jumlahTanggungan
  * kriteria
 
* WargaLansia (subclass)
  * umur
  * kondisiKesehatan
 
* WargaDisabilitas (subclass)
  * jenisDisabilitas
  * kebutuhanAlatBantu
 
* KriteriaKemiskinan
  * idKriteria
  * jenisPekerjaan
  * pendapatanBulanan
  * statusRumah

Pada Package pendataanwarga.controller disini ada :  

* WargaController
  * idData
  * tanggalPendataan
  * statusValidasi
  * daftarWargaKurangMampu (ArrayList)  

Pada Package pendataanwarga.view disini ada :  

* WargaView
  * input (Scanner)
  * controller (Objek WargaController)

Pada Package pendataanwarga.main disini ada :  
* MainApp (Entry point)

---

## 3. Penjelasan tiap Class <br>

<img width="222" alt="image" src="https://github.com/user-attachments/assets/1e942e75-cd98-40f0-8e80-e9f6618bd696" />


* Warga
  * Penjelasan class: Class ini bertindak sebagai superclass yang bersifat abstract dan mengimplementasikan interface ValidasiSyarat. Class ini menyimpan informasi umum data diri warga.
  * Pada class ini saya menggunakan atribut private yaitu nik, nama, alamat, jumlahTanggungan, serta objek kriteria dari class KriteriaKemiskinan.
  * Memiliki constructor, getter, setter, abstract method getKategori(), serta dua bentuk method tampilkanInfo() untuk menerapkan method overloading.

* WargaLansia
  * Penjelasan class: Class turunan (subclass) dari class Warga yang khusus menampung data warga kategori lansia.
  * Memiliki atribut tambahan umur dan kondisiKesehatan.
  * Menggunakan super pada constructor untuk memanggil atribut induknya, serta meng-override method getKategori(), cekKelayakanBantuan(), getCatatanBantuan(), dan tampilkanInfo() untuk mencetak data lansia.

* WargaDisabilitas
  * Penjelasan class: Class turunan (subclass) dari class Warga yang khusus menampung data warga kategori penyandang disabilitas.
  * Memiliki atribut tambahan jenisDisabilitas dan kebutuhanAlatBantu.
  * Menggunakan super pada constructor serta meng-override method getKategori(), cekKelayakanBantuan(), getCatatanBantuan(), dan tampilkanInfo() untuk mencetak data disabilitas.  

* KriteriaKemiskinan
  * Penjelasan class: Class ini digunakan untuk menampung syarat status ekonomi warga.
  * Atribut yang dipakai meliputi idKriteria, jenisPekerjaan, pendapatanBulanan, dan statusRumah.
  * Menggunakan validasi pada setPendapatanBulanan agar nilainya tidak bernilai negatif.

* WargaController
  * Penjelasan Class: Class pengolah data dan pusat logika bisnis pada arsitektur MVC.
  * Memiliki atribut idData, tanggalPendataan, statusValidasi, serta daftarWargaKurangMampu yang menggunakan ArrayList untuk menampung data-data warga. Class ini menyediakan method untuk penambahan data, mengambil daftar data, memperbarui data spesifik, dan menghapus data.

* WargaView
  * Penjelasan Class: Class yang bertugas menangani tampilan antarmuka CLI dan menerima masukan dari pengguna.
  * Di dalam class ini terdapat penanganan menu utama, pencetakan header sistem, serta validasi input menggunakan blok try-catch untuk menangani kesalahan input angka atau desimal.

* MainApp
  * Penjelasan Class: Entry point utama tempat program pertama kali dijalankan.
  * Class ini menginisialisasi WargaController dan WargaView, lalu memanggil fungsi untuk menjalankan menu program.

---  

## 4. Penjelasan Penerapan Encapsulation & Inheritance  
* Encapsulation
  * Semua atribut pada setiap class di dalam package model dan controller menggunakan access modifier private agar tidak bisa diakses secara langsung dari luar class.
  * Menggunakan method getter dan setter untuk mengakses dan mengubah nilai atribut.
  * Terdapat validasi data pada setter seperti setJumlahTanggungan (otomatis diset ke 0 jika minus), setPendapatanBulanan (diset ke 0 jika minus), dan setUmur pada WargaLansia (memastikan umur lansia minimal 60 tahun).

* Inheritance
  * Class Warga bertindak sebagai Abstract Superclass yang menyimpan data umum warga.
  * Class WargaLansia dan WargaDisabilitas bertindak sebagai Subclass yang mewarisi (extends) class Warga.
  * Menggunakan super pada constructor subclass untuk meneruskan data ke superclass dan super.tampilkanInfo() untuk memanggil cetakan informasi dari superclass.

---

## 5. Penjelasan Penerapan Polymorphism & Abstraction
* Abstraction
  * Class Warga dideklarasikan sebagai abstract class, sehingga objek Warga tidak bisa diinisialisasi secara langsung tanpa melalui subclass-nya.
  * Memiliki abstract method getKategori() yang wajib diimplementasikan oleh WargaLansia dan WargaDisabilitas.

* Polymorphism Overriding
  * Meng-override method tampilkanInfo() pada WargaLansia dan WargaDisabilitas untuk mencetak informasi spesifik tiap kategori.
  * Meng-override method cekKelayakanBantuan() dan getCatatanBantuan() dari interface ValidasiSyarat untuk menentukan status kelayakan bantuan secara otomatis berdasarkan kriteria masing-masing warga.

* Polymorphism Overloading
  * Diterapkan pada method tampilkanInfo() di class Warga.
  * Versi pertama tampilkanInfo() digunakan untuk menampilkan detail lengkap data warga.
  * Versi kedua tampilkanInfo(boolean ringkas) digunakan untuk menampilkan ringkasan data warga dalam satu baris.

---

## 6. Penjelasan Letak Penerapan Nilai Tambah  
* Nilai tambah pada project ini adalah penggunaan Interface ValidasiSyarat yang diletakkan pada package pendataanwarga.model.
* Interface ini mendeklarasikan method cekKelayakanBantuan() dan getCatatanBantuan(). Interface ini diimplementasikan oleh class Warga sehingga seluruh subclass turunan wajib memiliki fungsi untuk memvalidasi kelayakan bantuan sosial secara terstandar. <br>

<img width="727" alt="image" src="https://github.com/user-attachments/assets/24680e56-aff7-4f8f-827d-42028b434eb4" />

implementasi nya ada pada superclass Warga.java <br>
<img width="645" alt="WhatsApp Image 2026-10-07 at 8 28 13 PM" src="https://github.com/user-attachments/assets/77d7e11b-792f-410c-93b9-805e89a414f5" />


---

## 7. Penjelasan Alur Program dan Dokumentasi Output  
Saat program dijalankan, sistem otomatis memanggil method isiDataAwal() di WargaController untuk mengisikan dummy data awal ke ArrayList 

Pada saat program dijalankan, nanti nya akan menampilkan menu utama di terminal dengan 6 pilihan: <br>  

<img width="500" alt="WhatsApp Image 2026-10-07 at 7 38 15 PM" src="https://github.com/user-attachments/assets/8e3f1ae7-06c4-4cf7-8880-b47473eb8516" />


1. Tambah Data Warga (Create):
Pada menu ini, pengecekan kategori warga (Lansia/Disabilitas) dilakukan di awal sebelum menginput data personal. Jika pilihan kategori salah, pendaftaran langsung dibatalkan. Menu ini juga dilengkapi fungsi validasi try-catch jika pengguna salah memasukkan tipe data (seperti menginput teks pada angka). Setelah berhasil diisi, nanti ada output "Yeyy Data Berhasil ditambahkan!" <br>

<img width="528" alt="WhatsApp Image 2026-10-07 at 8 16 28 PM" src="https://github.com/user-attachments/assets/1e6abe79-47c7-444e-9abc-d7be6aa674d9" />


tampilan saat sudah ditambah <br>
<img width="500" alt="WhatsApp Image 2026-10-07 at 7 41 23 PM" src="https://github.com/user-attachments/assets/40a60e4c-2ba4-4594-b204-216b85ebcdb4" />



2. Tampilkan Data Warga (Read):
Menampilkan daftar semua warga yang ada di dalam ArrayList secara lengkap dengan atribut kategori, kriteria kemiskinan, serta status kelayakan bantuan otomatis dari interface. <br>

<img width="481" alt="WhatsApp Image 2026-10-07 at 7 42 29 PM" src="https://github.com/user-attachments/assets/08600722-fc4a-4f25-9487-2fee44b41d98" />

<img width="505" alt="WhatsApp Image 2026-10-07 at 7 43 06 PM" src="https://github.com/user-attachments/assets/d6656d14-da57-4175-bb30-b2e3a3dd00d4" />


3. Tampilkan Ringkasan Warga (Overloading):
Menampilkan bentuk ringkas dari daftar warga menggunakan konsep method overloading tampilkanInfo(true). Tampilan ini hanya memperlihatkan kategori, nama, NIK, dan status kelayakan bantuan warga secara singkat

<img width="823" alt="WhatsApp Image 2026-10-07 at 7 43 53 PM" src="https://github.com/user-attachments/assets/6bdbd5b3-769d-45a6-bde2-2c55831438f9" />

Fitur ini memperlihatkan penerapan Polymorphism Method Overloading melalui pemanggilan method tampilkanInfo(true). Berbeda dari menu kedua yang menampilkan detail menyeluruh, menu ini menyajikan rangkuman cepat status kelayakan bantuan warga secara ringkas dan padat. <br>

5. Ubah Data Warga (Update):
Pengguna memasukkan nomor data warga yang ingin diubah. Pembaruan data sistem hanya memperbarui nama, alamat, tanggungan, pendapatan, dan status rumah. Atribut umur, kondisi kesehatan, jenis disabilitas, dan kebutuhan alat bantu tidak ikut diperbarui agar data kategori awal tetap konsisten. Nanti ada pemberitahuan "Data warga berhasil diperbarui!" <br>

<img width="442" alt="WhatsApp Image 2026-10-07 at 7 44 51 PM" src="https://github.com/user-attachments/assets/57df4e4b-8acc-4442-aa0c-b9e39654d8d1" />

<img width="435" alt="WhatsApp Image 2026-10-07 at 7 46 36 PM" src="https://github.com/user-attachments/assets/52a13f48-ad77-4dd7-a368-f5270c4f7682" />

Tampilan setelah update <br>
<img width="511" alt="WhatsApp Image 2026-10-07 at 7 47 22 PM" src="https://github.com/user-attachments/assets/abd38ffc-1d3b-4c3e-8b92-81dc4b352562" />



5. Hapus Data Warga (Delete):
Untuk menghapus data warga dari daftar, masukkan nomor data yang mau dihapus. Sesuai revisi, sebelum data dihapus sistem meminta konfirmasi terlebih dahulu (apakah anda yakin ingin menghapus data ini? (y/n)). Jika diketik "y", data berhasil dihapus. <br>

<img width="436" alt="WhatsApp Image 2026-10-07 at 7 48 12 PM" src="https://github.com/user-attachments/assets/62c95f30-ea6e-408e-bd49-d954fa44b49d" />

<img width="585" alt="WhatsApp Image 2026-10-07 at 7 48 43 PM" src="https://github.com/user-attachments/assets/49d7b499-5555-41eb-91d7-f4f17a442e47" />


6. Keluar:
menutup program, nanti ada output "Terima kasih telah menggunakan program ini!" <br>

<img width="664" alt="WhatsApp Image 2026-10-07 at 7 50 03 PM" src="https://github.com/user-attachments/assets/3ab62263-ea84-445a-b762-8e311baaf27b" />
