package de.luigi.pizza;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        welcomeMenu();
    }

    static void welcomeMenu() {
        Scanner in = new Scanner(System.in);

        System.out.println("**********Luigis-Pizza**********");
        System.out.println("Herzlich willkommen bei Luigis Pizza! :) ");
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

//        Menü
            System.out.println();
            System.out.println("Bestellung: " + orderName);
            System.out.println("Pizza No.: " + (order.getOrderList().indexOf(pizza)+1)); // +1 weil sonst die erste Pizza 0 ist.
            System.out.println("Bitte wählen Sie zunächst eine Sauce für diese Pizza aus.");
            System.out.println("Wählen Sie <keine> oder <0>, wenn Sie keine Sauce möchten.");
            Auswahl.printSaucenAuswahl();

            while (true) {
                command = in.nextLine().trim().toLowerCase();
                if (Auswahl.inSaucen(command)) {     //ist die Sauce vorhanden?
                    Sauce wahl = Auswahl.getSauce(command);
                    pizza.addSauce(wahl);
                    System.out.println(wahl.name + " zu Pizza hinzugefügt.");
                    break;
                }
                else if (command.equals("keine") || command.equals("0")) {
                    break;
                }
                else {
                    System.out.println("ungültiger Befehl. Bitte wählen Sie eine Sauce.");
                }
            }

            System.out.println();
            System.out.println("Bitte wählen Sie nun bis zu acht Zutaten für diese Pizza aus.");
            System.out.println("Geben Sie <fertig> ein, wenn Sie mit Ihrer Pizza zufrieden sind.");
            System.out.println("Mit <Zutaten> können Sie die Liste der Zutaten erneut anzeigen.");
            Auswahl.printZutatenAuswahl();

            while (true) {
                command = in.nextLine().trim().toLowerCase();
                if (Auswahl.inZutaten(command)) {     //ist die Sauce vorhanden?
                    Zutat wahl = Auswahl.getZutat(command);
                    if (!pizza.addZutat(wahl)) {
                        System.out.println("Ihre Pizza hat bereits acht Zutaten. Bitte schliessen Sie diese Pizza mit <fertig> ab.");
                    }
                    else {
                        System.out.println(wahl.name + " zu Pizza hinzugefügt.");
                    }
                }
                else if (command.equals("fertig")){
                    break;
                }
                else {
                    System.out.println("ungültiger Befehl. Bitte wählen Sie eine Zutat oder <fertig>.");
                }
            }

            System.out.println("Möchten Sie eine weitere Pizza zu Ihrer Bestellung hinzufügen <Ja> <Nein>?");

            while (true) {
                command = in.nextLine().trim().toLowerCase();
                switch (command) {
                    case "nein":
                        break neuePizza; //beendet die äußerste Schleife
                    case "ja":
                        continue neuePizza; //springt an den Anfang und erstellt neue Pizza.
                    default:
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