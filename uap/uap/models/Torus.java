package uap.models;

// Mengimpor kelas dan interface yang dibutuhkan
import uap.bases.Shape;
import uap.interfaces.ThreeDimensional;
import uap.interfaces.PiRequired;
import uap.interfaces.MassCalculable;
import uap.interfaces.MassConverter;
import uap.interfaces.ShippingCostCalculator;

// Kelas Torus (donat dengan lubang), merupakan turunan dari Shape dan mengimplementasikan beberapa interface
public class Torus extends Shape implements ThreeDimensional, PiRequired, MassCalculable, MassConverter, ShippingCostCalculator {
    private double majorRadius; // Menyimpan radius mayor torus (R)
    private double minorRadius; // Menyimpan radius minor torus (r)

    // Konstruktor default
    public Torus() {
        super(); // Memanggil konstruktor kelas Shape
    }

    // Konstruktor dengan parameter majorRadius dan minorRadius
    public Torus(double majorRadius, double minorRadius) {
        super(); // Memanggil konstruktor kelas Shape
        this.majorRadius = majorRadius; // Mengatur radius mayor
        this.minorRadius = minorRadius; // Mengatur radius minor
    }

    // Implementasi metode untuk menghitung volume torus
    @Override
    public double getVolume() {
        // Rumus: 2 * PI^2 * R * r^2
        return 2 * PI * PI * this.majorRadius * this.minorRadius * this.minorRadius;
    }

    // Implementasi metode untuk menghitung luas permukaan torus
    @Override
    public double getSurfaceArea() {
        // Rumus: 4 * PI^2 * R * r
        return 4 * PI * PI * this.majorRadius * this.minorRadius;
    }

    // Implementasi metode untuk menghitung massa torus
    @Override
    public double getMass() {
        // Rumus: MassaJenis * LuasPermukaan * Ketebalan
        return DENSITY * getSurfaceArea() * THICKNESS;
    }

    // Implementasi metode untuk menampilkan informasi torus
    @Override
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