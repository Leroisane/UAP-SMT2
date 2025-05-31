package uap.interfaces;

// Interface untuk objek yang massanya bisa dikonversi
public interface MassConverter {
    int DENOMINATOR = 1000; // Konstanta untuk konversi gram ke kilogram

    // Metode untuk mengkonversi massa dari gram ke kilogram
    double gramToKilogram();
}