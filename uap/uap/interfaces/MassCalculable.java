package uap.interfaces;

// Interface untuk objek yang massanya bisa dihitung
public interface MassCalculable {
    int DENSITY = 8;      // Konstanta massa jenis (g/cm^3) untuk stainless steel
    double THICKNESS = 0.5; // Konstanta ketebalan bahan (cm)

    // Metode untuk mendapatkan massa objek
    double getMass();
}