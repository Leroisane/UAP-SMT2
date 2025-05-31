package uap.mains;

// Mengimpor kelas-kelas yang dibutuhkan
import uap.models.Torus;
import uap.models.Sphere;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

// Kelas utama program kalkulator pabrik
public class KalkulatorPabrik {

    // Metode utama yang akan dijalankan saat program dimulai
    public static void main(String[] args) {
        System.out.println("Kalkulator Pabrik Cetakan Donat Rumahan");
        System.out.println("MUHAMMAD IHSAN FADILLAH"); 
        System.out.println("245150700111023");           

        // Mengatur format angka untuk Rupiah (menggunakan titik sebagai pemisah ribuan)
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("id", "ID")); // Menggunakan lokal Indonesia
        symbols.setGroupingSeparator('.'); // Menetapkan titik sebagai pemisah ribuan
        DecimalFormat numberFormat = new DecimalFormat("###,###", symbols); // Format untuk angka ribuan

        // Memulai bagian output untuk donat dengan lubang (Torus)
        System.out.println("============================================="); 
        System.out.println("Donat dengan lubang"); 
        System.out.println("============================================="); 
        System.out.print("Isikan Radius \t: "); 
        double majorRadiusTorus = 7; // Input radius mayor Torus (sesuai soal)
        System.out.println(majorRadiusTorus); // Menampilkan input

        System.out.print("Isikan radius \t: "); 
        double minorRadiusTorus = 3.5; // Input radius minor Torus (sesuai soal)
        System.out.println(minorRadiusTorus); // Menampilkan input
        System.out.println("============================================="); 

        // Membuat objek Torus dengan radius yang sudah ditentukan
        Torus torus = new Torus(majorRadiusTorus, minorRadiusTorus);
        torus.printInfo(); // Memanggil metode untuk mencetak info volume, luas permukaan, dan massa (gram) dari Torus
        System.out.printf("Massa dalam kg\t\t: %.3f kg\n", torus.gramToKilogram()); // Menampilkan massa Torus dalam kg (3 angka desimal)
        System.out.printf("Biaya kirim\t\t: Rp%s\n", numberFormat.format(torus.calculateCost())); // Menampilkan biaya kirim Torus dalam format Rupiah
        System.out.println("============================================="); 

        // Memulai bagian output untuk donat tanpa lubang (Sphere)
        System.out.println("Donat tanpa lubang"); 
        System.out.println("============================================="); 
        System.out.print("Isikan radius\t\t: "); 
        double radiusSphere = 21; // Input radius Sphere (sesuai soal)
        System.out.println(radiusSphere); // Menampilkan input
        System.out.println("============================================="); 

        // Membuat objek Sphere dengan radius yang sudah ditentukan
        Sphere sphere = new Sphere(radiusSphere);
        sphere.printInfo(); // Memanggil metode untuk mencetak info volume, luas permukaan, dan massa (gram) dari Sphere
        System.out.printf("Massa dalam kg\t\t: %.3f kg\n", sphere.gramToKilogram()); // Menampilkan massa Sphere dalam kg (3 angka desimal)
        System.out.printf("Biaya kirim\t\t: Rp%s\n", numberFormat.format(sphere.calculateCost())); // Menampilkan biaya kirim Sphere dalam format Rupiah
        System.out.println("============================================="); 
    }
}