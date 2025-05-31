package uap.interfaces;

// Interface untuk objek yang biaya kirimnya bisa dihitung
public interface ShippingCostCalculator {
    int PRICE_PER_KG = 2000; // Konstanta harga pengiriman per kilogram

    // Metode untuk menghitung biaya kirim
    double calculateCost();
}