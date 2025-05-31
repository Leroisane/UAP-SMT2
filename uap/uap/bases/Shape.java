package uap.bases;

// Kelas dasar (abstrak) untuk semua bentuk cetakan donat
public abstract class Shape {
    private String name; // Untuk menyimpan nama bentuk (misal: "Donat Torus")

    // Konstruktor default
    public Shape() {
    }

    // Metode untuk mengatur nama bentuk
    public void setName(String inputName) {
        this.name = inputName;
    }

    // Metode untuk mendapatkan nama bentuk
    public String getName() {
        return name;
    }

    // Metode abstrak untuk menampilkan informasi spesifik bentuk
    // Setiap bentuk turunan (Torus, Sphere) wajib mengimplementasikan ini
    public abstract void printInfo();
}