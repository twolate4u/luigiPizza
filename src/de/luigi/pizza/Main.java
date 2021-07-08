package de.luigi.pizza;

import java.util.Scanner;

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

        String orderName;
        orderName = in.nextLine().trim();
        while (orderName.length() > 31) {
            System.out.println("Der Name ist zu lang. Bitte versuchen Sie es mit einem kürzeren Namen: ");
            orderName = in.nextLine().trim();
        }

//        System.out.println("Bitte wähle aus"); //Was soll bestellt werden?

        Order order = new Order(orderName);
        orderMenu(orderName, order);
    }

    private static void orderMenu(String orderName, Order order) {
//        neue Pizza wird erstellt und der Bestellung hinzugefügt. So lange wir keine Änderungen zulassen reicht das so aus.
//        sonst müssen wir auch die Möglichkeit einplanen eine bestehende Pizza zu laden.
        neuePizza:
        while (true) {  //schleife die ermöglicht mehr als eine pizza zu erstellen.
            Pizza pizza = new Pizza();
            order.getOrderList().add(pizza);

            Scanner in = new Scanner(System.in);
            String command = "";
//        Menü:
            System.out.println();
            System.out.println("Bestellung: " + orderName);
            System.out.println("Pizza No.: " + (order.getOrderList().indexOf(pizza)+1)); // +1 weil sonst die erste Pizza 0 ist.
            Auswahl.printAuswahl();
            System.out.println("Bitte geben Sie nacheinander eine Soße und bis zu acht weitere Zutaten für Ihre Pizza ein.");
            System.out.println("Mit <Zutaten> können Sie diese erneut anzeigen, mit <fertig> schliessen Sie diese Pizza ab.");

            while (true) {
                command = in.nextLine().trim().toLowerCase();
                if (command.equals("zutaten")) {
                    Auswahl.printAuswahl();
                }
                else if (command.equals("fertig")) {
                    break;
                }
                else if (Auswahl.inAuswahl(command)) {     //ist die zutat vorhanden?
                    Belag Wahl = Auswahl.getBelag(command);
                    if (Wahl instanceof Zutat) {        //das hier ist absurd. das muss anders gehen... instanceof erkennt den richtigen objekttyp aber die überladene methode nicht
                        if (pizza.addBelag((Zutat) Wahl) == 1) {
                            System.out.println("Ihre Pizza hat bereits 8 Zutaten. Falls noch nicht geschehen, wählen Sie " +
                                    "eine Sauce und schliessen Sie die Pizza mit <fertig>.");
                        }
                    }
                    else if (Wahl instanceof Sauce) {
                        if (pizza.addBelag((Sauce) Wahl) == 2) {
                            System.out.println("Ihre Pizza hat bereits eine Sauce. Wählen Sie noch bis zu 8 Zutaten " +
                                    "und schliessen Sie die Pizza mit <fertig>.");
                        }
                    }
                }
                else {
                    System.out.println("ungültiger Befehl. <Zutaten> für eine Liste der Zutaten. <Fertig> zum " +
                            "Schliessen der Pizza.");
                }
            }
            System.out.println("Möchten Sie eine weitere Pizza zu Ihrer Bestellung hinzufügen <Ja> <Nein>?");

            while (true) {
                command = in.nextLine().trim().toLowerCase();
                if (command.equals("nein")) {
                    break neuePizza; //beendet die äußerste Schleife
                }
                else if (command.equals("ja")) {
                    continue neuePizza; //springt an den Anfang und erstellt neue Pizza.
                }
                else {
                    System.out.println("ungültiger Befehl. <ja> für eine weitere Pizza. <nein> zum Abschicken der Bestellung.");
                }
            }
        }
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