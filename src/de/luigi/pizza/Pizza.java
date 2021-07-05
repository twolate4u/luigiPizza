package de.luigi.pizza;

import java.util.ArrayList;
import java.util.List;

public class Pizza {

    double cost;
    String Name;
//    maximale Anzahl von Belägen pro Pizza
    int maxBelag = 8;
    Belag[] belagList = new Belag[maxBelag];
//    maximale Anzahl von Saucen pro Pizza
    int maxSauce = 1;
    Sauce[] sauceList = new Sauce[maxSauce];

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getCost() {
        return cost;
    }

    public String getName() {
        return Name;
    }

    public void addBelag(Belag belag) {

    }

    public void addSauce(Sauce sauce) {

    }
}
