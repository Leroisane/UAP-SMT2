package uap.mains;

import uap.models.Torus;
import uap.models.Sphere;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class KalkulatorPabrik {

    public static void main(String[] args) {
        // Identitas Praktikan
        System.out.println("Kalkulator Pabrik Cetakan Donat Rumahan");
        System.out.println("MUHAMMAD IHSAN FADILLAH"); 
        System.out.println("245150700111023");           

        DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("id", "ID"));
        symbols.setGroupingSeparator('.');
        DecimalFormat numberFormat = new DecimalFormat("###,###", symbols);

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
        torus.printInfo(); 
        System.out.printf("Massa dalam kg\t\t: %.3f kg\n", torus.gramToKilogram()); 
        System.out.printf("Biaya kirim\t\t: Rp%s\n", numberFormat.format(torus.calculateCost())); 
        System.out.println("============================================="); 

        System.out.println("Donat tanpa lubang"); 
        System.out.println("============================================="); 
        System.out.print("Isikan radius\t\t: "); 
        double radiusSphere = 21; 
        System.out.println(radiusSphere);
        System.out.println("============================================="); 

        Sphere sphere = new Sphere(radiusSphere);
        sphere.printInfo(); 
        System.out.printf("Massa dalam kg\t\t: %.3f kg\n", sphere.gramToKilogram()); 
        System.out.printf("Biaya kirim\t\t: Rp%s\n", numberFormat.format(sphere.calculateCost())); 
        System.out.println("============================================="); 
    }
}