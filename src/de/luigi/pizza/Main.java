package de.luigi.pizza;

import java.util.Scanner;

import static java.awt.SystemColor.menu;

public class Main {

    public static void main(String[] args) {
        welcomeMenu();
    }

    static void welcomeMenu() {
        Scanner in = new Scanner(System.in);

        System.out.println("**********Luigis-Pizza**********");
        System.out.println("Herzlich willkommen bei Luigis Pizza!");
        System.out.println();
        System.out.println("Bitte geben Sie ihren Namen ein um eine neue Bestellung zu erstellen.");
        System.out.println("**********Luigis-Pizza**********");

        String orderName = in.next().trim(); //hier müsste wahrscheinlich noch die Eingabe etwas überprüft werden.
        Order order = new Order(orderName);
        orderMenu(orderName);
    }

    private static void orderMenu(String orderName) {
        /*hier müsste eine Pizza erstellt werden und dann die Zutatenauswahl angezeigt werden*/
        System.out.println("**********" + orderName + "**********");
        System.out.println("**********Luigis-Pizza**********");
        System.out.println("**********Luigis-Pizza**********");
        System.out.println("**********Luigis-Pizza**********");
        System.out.println("**********Luigis-Pizza**********");
    }
}
