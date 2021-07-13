package de.luigi.pizza;

public abstract class Auswahl {

    public static Zutat[] zutaten = new Zutat[]{
            new Zutat(0.99, "Gouda", 11),
            new Zutat(0.99, "Mozzarella", 12),
            new Zutat(1.39, "Salami", 13),
            new Zutat(1.39, "Schinken", 14),
            new Zutat(0.99, "Thunfisch", 15),
            new Zutat(0.59, "Peperoni", 16),
            new Zutat(0.59, "Ananas", 17),
            new Zutat(0.59, "Mais", 18),
            new Zutat(0.59, "Zwiebeln", 19),
            new Zutat(0.99, "Oliven", 20),
            new Zutat(0.59, "Ei", 21),
            new Zutat(0.99, "Paprika", 22),
            new Zutat(0.59, "Tomaten", 23),
            new Zutat(0.59, "Champignons", 24),
    };

    public static Sauce[] saucen = new Sauce[]{
            new Sauce(0.00, "Tomatensauce", 01),
            new Sauce(0.00, "BBQ-Sauce", 02)
    };

    public static void printZutatenAuswahl() {
        //druckt die Zutatenliste in zwei Spalten nebeneinander und richtet die zweite Spalte linksbündig aus.

        String space = " ";
        int longestZutat = 0;
        int spaltenLaenge;

        for (Zutat zutat: zutaten) {
            if (zutat.name.length() > longestZutat) {
                longestZutat = zutat.name.length();
            }
        }

        //unterschiedliche Werte für gerade und ungerade Zutatenmengen nötig.
        if (zutaten.length%2 == 0) {
            spaltenLaenge = zutaten.length / 2 - 1;
        }
        else {
            spaltenLaenge = zutaten.length / 2;
        }
        System.out.println("Mögliche Zutaten:");

        for (int i = 0; (i <= spaltenLaenge); i++) {
            System.out.print(zutaten[i].id + space + zutaten[i].name + space + zutaten[i].cost + "€");

            if (i+(spaltenLaenge+1) <= zutaten.length-1) { //Verhindert bei ungeraden Zutatenanzahlen ein überschreiten des Indexraums von zutaten[].
                for (int j = 0; j <= longestZutat - zutaten[i].name.length() + 2; j++) { //fügt soviele Leerzeichen ein, damit die zweite Spalte linksbündig ist.
                    System.out.print(space);
                }

                System.out.println(zutaten[i + (spaltenLaenge + 1)].id + space + zutaten[i + (spaltenLaenge + 1)].name +
                        space + zutaten[i + (spaltenLaenge + 1)].cost + "€");
            }
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
