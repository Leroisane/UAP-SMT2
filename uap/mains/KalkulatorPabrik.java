package uap.mains;

import uap.models.Torus;
import uap.models.Sphere;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class KalkulatorPabrik {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String namaPraktikan = "Muhammad Ihsan Fadillah";
        String nimPraktikan = "245150700111023";  

        System.out.println("Kalkulator Pabrik Cetakan Donat Rumahan");
        System.out.println(namaPraktikan.toUpperCase());
        System.out.println(nimPraktikan);

        // Torus Calculation
        System.out.println("=============================================");
        System.out.println("Donat dengan lubang");
        System.out.println("=============================================");
        System.out.print("Isikan Radius \t: ");
        double majorRadiusTorus = 7;
        System.out.println(majorRadiusTorus);

        System.out.print("Isikan radius \t: ");
        double minorRadiusTorus = 3.5;
        System.out.println(minorRadiusTorus);
        System.out.println("=============================================");

        Torus torus = new Torus(majorRadiusTorus, minorRadiusTorus);
        torus.setName("Donat Torus");
        torus.printInfo();
        System.out.printf("Massa dalam kg\t\t: %.2f kg\n", torus.gramToKilogram());

        // 
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("id", "ID"));
        symbols.setGroupingSeparator('.');
        DecimalFormat rupiahFormat = new DecimalFormat("Rp###,###", symbols); 

        System.out.printf("Biaya kirim\t\t: %s\n", rupiahFormat.format(torus.calculateCost()));
        System.out.println("=============================================");

        // Sphere Calculation
        System.out.println("Donat tanpa lubang");
        System.out.println("=============================================");
        System.out.print("Isikan radius\t\t: ");
        double radiusSphere = 21;
        System.out.println(radiusSphere);
        System.out.println("=============================================");

        Sphere sphere = new Sphere(radiusSphere);
        sphere.setName("Donat Sphere");
        sphere.printInfo();
        System.out.printf("Massa dalam kg\t\t: %.2f kg\n", sphere.gramToKilogram());
        System.out.printf("Biaya kirim\t\t: %s\n", rupiahFormat.format(sphere.calculateCost()));
        System.out.println("=============================================");

        scanner.close();
    }
}