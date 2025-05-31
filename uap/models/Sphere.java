package uap.models;

// Mengimpor kelas dan interface yang dibutuhkan
import uap.bases.Shape;
import uap.interfaces.ThreeDimensional;
import uap.interfaces.PiRequired;
import uap.interfaces.MassCalculable;
import uap.interfaces.MassConverter;
import uap.interfaces.ShippingCostCalculator;

// Kelas Sphere (donat tanpa lubang), merupakan turunan dari Shape dan mengimplementasikan beberapa interface
public class Sphere extends Shape implements ThreeDimensional, PiRequired, MassCalculable, MassConverter, ShippingCostCalculator {
    private double radius; // Menyimpan radius bola

    // Konstruktor default
    public Sphere() {
        super(); // Memanggil konstruktor kelas Shape
    }

    // Konstruktor dengan parameter radius
    public Sphere(double radius) {
        super(); // Memanggil konstruktor kelas Shape
        this.radius = radius; // Mengatur radius bola
    }

    // Implementasi metode untuk menghitung volume bola
    @Override
    public double getVolume() {
        // Rumus: (4/3) * PI * r^3
        return (4.0 / 3.0) * PI * this.radius * this.radius * this.radius;
    }

    // Implementasi metode untuk menghitung luas permukaan bola
    @Override
    public double getSurfaceArea() {
        // Rumus: 4 * PI * r^2
        return 4 * PI * this.radius * this.radius;
    }

    // Implementasi metode untuk menghitung massa bola
    @Override
    public double getMass() {
        // Rumus: MassaJenis * LuasPermukaan * Ketebalan
        return DENSITY * getSurfaceArea() * THICKNESS;
    }

    // Implementasi metode untuk menampilkan informasi bola
    public void printInfo() {
        // Menampilkan volume, luas permukaan, dan massa (gram) dengan format 2 angka desimal
        System.out.printf("Volume\t\t\t: %.2f cm^3\n", getVolume());
        System.out.printf("Luas permukaan\t\t: %.2f cm^2\n", getSurfaceArea());
        System.out.printf("Massa\t\t\t: %.2f gr\n", getMass());
    }

    // Implementasi metode untuk mengkonversi massa dari gram ke kilogram
    @Override
    public double gramToKilogram() {
        // Massa (gram) dibagi 1000
        return getMass() / DENOMINATOR;
    }

    // Implementasi metode untuk menghitung biaya kirim
    @Override
    public double calculateCost() {
        double massInKg = gramToKilogram(); // Mendapatkan massa dalam kg
        // Biaya dihitung per kg, dibulatkan ke atas jika tidak bulat, dikali harga per kg
        return Math.ceil(massInKg) * PRICE_PER_KG;
    }
}