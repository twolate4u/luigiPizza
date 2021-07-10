package de.luigi.pizza;
//TEST

//    Das ist alles höchst unsauber, weil hart vercoded aber es dient dem test.
public class Auswahl {
    public static Zutat[] zutaten = new Zutat[]{
            new Zutat(0.99, "Gouda", 11),
            new Zutat(1.39, "Salami", 13),
            new Zutat(1.39, "Schinken", 14),
            new Zutat(0.59, "Zwiebeln", 19),
    };
    public static Sauce[] saucen = new Sauce[]{
            new Sauce(0.00, "Tomatensauce", 01),
            new Sauce(0.00, "BBQ-Sauce", 02)
    };


    public static void printZutatenAuswahl() {
        String space = " ";
        System.out.println("Mögliche Zutaten:");
        for (Zutat zutat: zutaten) {
            System.out.println(zutat.id + space + zutat.name + space + zutat.cost + "€");
        }
    }
    public static void printSaucenAuswahl() {
        String space = " ";
        System.out.println("Mögliche Saucen:");
        for (Sauce sauce: saucen) {
            System.out.println(sauce.id + space + sauce.name + space + sauce.cost + "€");
        }
    }

    public static boolean inZutaten(String name) {
        for (Zutat zutat: zutaten) {
            if (zutat.name.toLowerCase().equals(name) || Integer.toString(zutat.id).equals(name)) return true;
        }
        return false;
    }

    public static boolean inSaucen(String name) {
        for (Sauce sauce: saucen) {
            if (sauce.name.toLowerCase().equals(name) || Integer.toString(sauce.id).equals(name)) return true;
        }
        return false;
    }

    public static Zutat getZutat(String name) {
        for (Zutat zutat: zutaten) {
            if (zutat.name.toLowerCase().equals(name) || Integer.toString(zutat.id).equals(name)) return zutat;
        }
        return null;
    }

    public static Sauce getSauce(String name) {
        for (Sauce sauce : saucen) {
            if (sauce.name.toLowerCase().equals(name) || Integer.toString(sauce.id).equals(name)) return sauce;
        }
        return null;
    }
}
