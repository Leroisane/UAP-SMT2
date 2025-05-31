package uap.models;

import uap.bases.Shape;
import uap.interfaces.ThreeDimensional;
import uap.interfaces.PiRequired;
import uap.interfaces.MassCalculable;
import uap.interfaces.MassConverter;
import uap.interfaces.ShippingCostCalculator;

public class Torus extends Shape implements ThreeDimensional, PiRequired, MassCalculable, MassConverter, ShippingCostCalculator {
    private double majorRadius;
    private double minorRadius;

    public Torus() {
        super();
    }

    public Torus(double majorRadius, double minorRadius) {
        super();
        this.majorRadius = majorRadius;
        this.minorRadius = minorRadius;
    }

    public double getMajorRadius() {
        return majorRadius;
    }

    public void setMajorRadius(double majorRadius) {
        this.majorRadius = majorRadius;
    }

    public double getMinorRadius() {
        return minorRadius;
    }

    public void setMinorRadius(double minorRadius) {
        this.minorRadius = minorRadius;
    }

    @Override
    public double getVolume() {
        // V = 2 * pi^2 * R * r^2
        return 2 * PI * PI * this.majorRadius * this.minorRadius * this.minorRadius;
    }

    @Override
    public double getSurfaceArea() {
        // A = 4 * pi^2 * R * r
        return 4 * PI * PI * this.majorRadius * this.minorRadius;
    }

    @Override
    public double getMass() {
        // m = rho * A * t
        return DENSITY * getSurfaceArea() * THICKNESS;
    }

    @Override
    public void printInfo() {
        System.out.printf("Volume\t\t\t: %.2f cm^3\n", getVolume());
        System.out.printf("Luas permukaan\t\t: %.2f cm^2\n", getSurfaceArea());
        System.out.printf("Massa\t\t\t: %.2f gr\n", getMass());
    }

    @Override
    public double gramToKilogram() {
        return getMass() / DENOMINATOR;
    }

    @Override
    public double calculateCost() {
        double massInKg = gramToKilogram();
        // perhitungan biaya kirim dihitung per kg dengan angka bulat, dibulatkan ke atas bila angka kg tidak bulat
        return Math.ceil(massInKg) * PRICE_PER_KG;
    }
}