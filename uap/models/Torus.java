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

    @Override
    public double getVolume() {
        return 2 * PI * PI * this.majorRadius * this.minorRadius * this.minorRadius;
    }

    @Override
    public double getSurfaceArea() {
        return 4 * PI * PI * this.majorRadius * this.minorRadius;
    }

    @Override
    public double getMass() {
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
        return Math.ceil(massInKg) * PRICE_PER_KG;
    }
}