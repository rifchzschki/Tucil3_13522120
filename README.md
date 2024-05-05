# Tucil3_13522120

Penyelesaian Permainan Word Ladder Menggunakan Algoritma UCS, Greedy Best First Search, dan A\*

<p align="center">  
   <img src="assets/word_ladder_title.jpg">
</p>

## Algoritma yang Diimplementasikan

1. **Uniform Cost Search (UCS)**:

   - UCS adalah algoritma pencarian graf yang mencari solusi dengan cost terendah.
   - Algoritma ini mengeksplorasi node berdasarkan cost yang diperlukan untuk mencapainya dari node awal.
   - Pada kasus ini cost didefinisikan sebagai jarak dari current node ke start node

2. **Greedy Best-First Search**:

   - Greedy Best-First Search adalah algoritma pencarian graf yang memilih node yang paling dekat dengan node tujuan tanpa mempertimbangkan cost sebelumnya.
   - Algoritma ini memprioritaskan node yang memiliki nilai fungsi evaluasi terendah, yang sering kali diukur dengan heuristik yang menghitung jarak estimasi dari node ke node tujuan.
   - Pada kasus ini jarak terendah didefinisikan sebagai jumlah perbedaan karakter dari kata pada current node dengan kata pada target node

3. **A\* (A-Star)**:
   - A\* adalah algoritma pencarian graf yang menggabungkan konsep dari UCS dan Greedy Best-First Search.
   - Algoritma ini mencari jalur dari node awal ke node tujuan dengan mempertimbangkan jarak dari node awal hingga node saat ini (cost aktual) ditambah dengan estimasi cost dari node saat ini ke node tujuan (heuristik) dalam hal ini adalah perbedaan karakter pada kata.
   - A\* memilih node dengan cost terendah (cost aktual + heuristik) untuk dieksplorasi berikutnya.

## Prerequisite

Untuk menjalankan program ini, pastikan Anda telah menginstal Java Development Kit (JDK) di sistem operasi Anda.

### Cara Menginstal Java di Windows

> Berikut adalah langkah-langkah untuk menginstal Java di sistem operasi Windows:
>
> 1. **Unduh JDK**:
>
> - Kunjungi situs resmi Oracle Java di [Oracle JDK Downloads](https://www.oracle.com/java/technologies/javase-jdk15-downloads.html).
> - Unduh JDK sesuai dengan versi Windows Anda (32-bit atau 64-bit).
>
> 2. **Instalasi JDK**:
>
> - Buka berkas instalasi yang sudah diunduh.
> - Ikuti petunjuk instalasi yang muncul.
> - Setelah instalasi selesai, buka Command Prompt (cmd) dan ketik perintah `java -version` untuk memastikan JDK terinstal dengan benar.

## Cara Menginstal Java di Linux (Ubuntu/Debian)

> Berikut adalah langkah-langkah untuk menginstal Java di sistem operasi Linux (Ubuntu/Debian):
>
> 1. **Buka Terminal**:
>
> - Buka Terminal di Ubuntu/Debian dengan menekan `Ctrl + Alt + T`.
>
> 2. **Instal OpenJDK**:
>
> - Ubuntu dan Debian biasanya menggunakan OpenJDK sebagai implementasi standar Java.
> - Jalankan perintah berikut di Terminal untuk menginstal OpenJDK:
>   ```
>   sudo apt update
>   sudo apt install default-jdk
>   ```
>
> 3. **Verifikasi Instalasi**:
>
> - Setelah instalasi selesai, Anda dapat memeriksa versi Java yang terinstal dengan menjalankan perintah:
>
>   ```
>   java -version
>   ```
>
> - Jika instalasi berhasil, Anda akan melihat output yang menunjukkan versi JDK yang terinstal.

## Cara Mengkompilasi

1. Untuk windows

   > lakukan build terlebih dahulu

   ```bash
   cd src
   ./scripts/build.ps1
   ```

   > run program

   ```bash
   cd src
   ./scripts/run.ps1
   ```

2. Untuk Linux(Ubuntu/Debian)
   >  lakukan build terlebih dahulu
      ```bash
      cd src
      ./scripts/build.sh
      ```
   > run program
   ```bash
   cd src
   ./scripts/run.sh
   ```

## Author

| NIM      | NAMA                               |
| -------- | ---------------------------------- |
| 13522120 | Muhamad Rifki Virziadeili Harisman |
