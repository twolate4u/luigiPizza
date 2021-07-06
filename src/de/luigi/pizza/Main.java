package de.luigi.pizza;

import java.util.Scanner;

import static java.awt.SystemColor.menu;

public class Main {

    public static void main(String[] args) {
        Auswahl auswahl = new Auswahl();

        System.out.println("zwiebeln = " + auswahl.zwiebeln);

        welcomeMenu();
    }

    static void welcomeMenu() {
        Scanner in = new Scanner(System.in);

        System.out.println("**********Luigis-Pizza**********");
        System.out.println("Herzlich willkommen bei Luigis Pizza!");
        System.out.println();
        System.out.println("Bitte geben Sie ihren Namen ein um eine neue Bestellung zu erstellen.");
        System.out.println("**********Luigis-Pizza**********");

        String orderName;
        orderName = in.next().trim();
        while (orderName.length() > 31) {
            System.out.println("Der Name ist zu lang. Bitte versuchen Sie es mit einem kürzeren Namen: ");
            orderName = in.next().trim();
        }

        System.out.println("Bitte wähle aus"); //Was soll bestellt werden?

        Order order = new Order(orderName);
        orderMenu(orderName, order);
    }

    private static void orderMenu(String orderName, Order order) {
        /*hier müsste eine Pizza erstellt werden und dann die Zutatenauswahl angezeigt werden*/
        System.out.println();
        System.out.println("Bestellung: " + orderName);
        System.out.println();
        System.out.println("Pizza: " + order.getOrderList().);

    }

}

   /* int befehl = befehlParsen("Bitte geben Sie eine Ganzzahl ein: ");
        System.out.println("befehl = " + befehl);

                }

private static int befehlParsen(String eingabeText) {
        Scanner scanner = new Scanner(System.in);
        int befehlscode = -1;

        do {
        System.out.print(eingabeText);
        String befehl = scanner.nextLine();
        try {
        befehlscode = Integer.parseInt(befehl);
        } catch (NumberFormatException e) {
        System.out.println("Falsche Eingabe.");
        // print commands
        }
        } while (befehlscode == -1);
        return befehlscode;*/