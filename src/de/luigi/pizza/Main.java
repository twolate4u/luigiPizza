package de.luigi.pizza;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        welcomeMenu();
    }

    static void welcomeMenu() { //eigentlich könnte das hier auch in die main.

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
        orderMenu(order);
    }

    private static void orderMenu(Order order) {
//        neue Pizza wird erstellt und der Bestellung hinzugefügt. So lange wir keine Änderungen zulassen reicht das so aus.
//        sonst müssen wir auch die Möglichkeit einplanen eine bestehende Pizza zu laden.
        Scanner in = new Scanner(System.in);
        String command = "";
        while (!command.equals("nein")) {  //schleife die ermöglicht mehr als eine pizza zu erstellen.
            Pizza pizza = new Pizza();
            order.getOrderList().add(pizza);

            System.out.println();
            System.out.println("Bestellung: " + order.getOrderName());
            System.out.println("Pizza No.: " + (order.getOrderList().indexOf(pizza)+1)); // +1 weil sonst die erste Pizza 0 ist.
            saucenWahl(pizza);
            System.out.println();
            zutatenWahl(pizza);
            System.out.println("Möchten Sie eine weitere Pizza zu Ihrer Bestellung hinzufügen <Ja> <Nein>?");

            do {
                command = in.nextLine().trim().toLowerCase();
                switch (command) {
                    case "nein":
                    case "ja":
                        break; //innere Schleife wird gestoppt, äußere wenn command = "nein", bei "ja" wird sie erneut ausgeführt und erstellt eine neue Pizza.
                    default:
                        System.out.println("ungültiger Befehl. <ja> für eine weitere Pizza. <nein> zum Abschicken der Bestellung.");
                }
            } while (!(command.equals("nein") || command.equals("ja")));
        }
        farewellMenu(order);
    }

    private static void saucenWahl(Pizza pizza) {
        Scanner in = new Scanner(System.in);
        String command;

        System.out.println("Bitte wählen Sie zunächst eine Sauce für diese Pizza aus.");
        System.out.println("Wählen Sie <keine> oder <0>, wenn Sie keine Sauce möchten.");
        Auswahl.printSaucenAuswahl();
       do {
            command = in.nextLine().trim().toLowerCase();
            if (Auswahl.inSaucen(command)) {     //ist die Sauce vorhanden?
                Sauce wahl = Auswahl.getSauce(command);
                pizza.addSauce(wahl);
                System.out.println(wahl.name + " zu Pizza hinzugefügt.");
                break;
            }
            else if (!(command.equals("keine") || command.equals("0"))) {
                System.out.println("ungültiger Befehl. Bitte wählen Sie eine Sauce.");
            }
        } while (!(command.equals("keine") || command.equals("0")));
    }

    private static void zutatenWahl(Pizza pizza) {
        Scanner in = new Scanner(System.in);
        String command = "";

        System.out.println("Bitte wählen Sie nun bis zu acht Zutaten für diese Pizza aus.");
        System.out.println("Geben Sie <fertig> ein, wenn Sie mit Ihrer Pizza zufrieden sind.");
        System.out.println("Mit <Zutaten> können Sie die Liste der Zutaten erneut anzeigen.");
        Auswahl.printZutatenAuswahl();
        while (!command.equals("fertig")) {
            command = in.nextLine().trim().toLowerCase();

            if (Auswahl.inZutaten(command)) {     //ist der Befehl eine Zutat?
                Zutat wahl = Auswahl.getZutat(command);
                if (!pizza.addZutat(wahl)) {
                    System.out.println("Ihre Pizza hat bereits acht Zutaten. Bitte schliessen Sie diese Pizza mit <fertig> ab.");
                }
                else {
                    System.out.println(wahl.name + " zu Pizza hinzugefügt.");
                }
            }
            else {
                switch (command) {
                    case "fertig":
                        break;
                    case "zutaten":
                        Auswahl.printZutatenAuswahl();
                        break;
                    default:
                        System.out.println("ungültiger Befehl. Bitte wählen Sie eine Zutat oder <fertig>.");
                        break;
                    }
                }
            }
        }

    private static void farewellMenu(Order order) { // funktioniert so weit, aber es fehlt noch alles was mit dem Preis zu tun hat. Zu dem weiß ich keine Lösung für das Löschen der Konsole.
        Scanner in = new Scanner(System.in);
        String command = "";

        System.out.println();
        System.out.println("Vielen Dank für ihre Bestellung " + order.getOrderName() + "!");
        if (order.getOrderList().size() > 1) {
            System.out.println("Sie haben folgende Pizzen bestellt: ");
        }
        else {
            System.out.println("Sie haben folgende Pizza bestellt: ");
        }
        for (Pizza pizza: order.getOrderList()) {
            System.out.println("Pizza No.: " + (order.getOrderList().indexOf(pizza)+1)); // +1 weil sonst die erste Pizza 0 ist.
            for (Sauce sauce: pizza.getSauceList()) {
                System.out.print(sauce.getName() + ", ");
            }
            for (Zutat zutat: pizza.getZutatList()) {
                if (pizza.getZutatList().indexOf(zutat) == pizza.getZutatList().size()-1) { //letzte Zutat braucht kein Komma mehr. Zu dem ist hier ein Zeilenumbruch nötig.
                    System.out.println(zutat.getName() + ". Diese Pizza kostet: " + pizza.getCost() + "€");
                }
                else {
                    System.out.print(zutat.getName() + ", ");
                }
            }
        }
        System.out.println();
        System.out.println("Die Bestellung kostet: " + order.getTotalCost() + "€");
        System.out.println("Bitte drücken Sie <Enter> um die Bestellung zu schließen.");
        in.nextLine();
        order.clearOrder();
        welcomeMenu();
    }

}