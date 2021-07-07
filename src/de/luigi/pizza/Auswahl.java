package de.luigi.pizza;

import java.util.List;
import java.util.Locale;

//    Das ist alles höchst unsauber, weil hart vercoded aber es dient dem test.
public class Auswahl {
    public static Belag[] auswahl = new Belag[]{
            new Sauce(0.00, "Tomatensauce", 01),
            new Sauce(0.00, "BBQ-Sauce", 02),

            new Zutat(0.99, "Gouda", 11),
            new Zutat(1.39, "Salami", 13),
            new Zutat(1.39, "Schinken", 14),
            new Zutat(0.59, "Zwiebeln", 19),
    };

//    Zutat zwiebeln = new Zutat (0.59, "Zwiebeln", 19);
//    Zutat salami = new Zutat (1.39, "Salami", 13);
//    Zutat schinken = new Zutat (1.39, "Schinken", 14);
//    Zutat gouda = new Zutat(0.99, "Gouda", 11);
//
//    Sauce tomatensauce = new Sauce(0.00,"Tomatensauce", 01);
//    Sauce bbqsauce = new Sauce(0.00, "BBQ-Sauce", 02);

    public static void printAuswahl() {
        String space = " ";
        System.out.println("Mögliche Zutaten:");
        for (Belag belag:auswahl) {
            System.out.println(belag.id + space + belag.name + space + belag.cost + "€");
        }
    }

    public static boolean inAuswahl(String name) {
        for (Belag belag:auswahl) {
            if (belag.name.toLowerCase().equals(name)) return true;
        }
        return false;
    }

    public static Belag getBelag(String name) {
        for (Belag belag:auswahl) {
            if (belag.name.toLowerCase().equals(name)) return belag;
        }
        return null;
    }

}
