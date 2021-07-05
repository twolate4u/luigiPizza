package de.luigi.pizza;

import java.util.ArrayList;
import java.util.List;

public class Pizza {

    private double cost;
    private String Name;
//    maximale Anzahl von Belägen pro Pizza
    private int maxBelag = 8;
//    maximale Anzahl von Saucen pro Pizza
    private int maxSauce = 1;
    private List<Belag> belagList = new ArrayList<Belag>(maxBelag);
    private List<Sauce> sauceList = new ArrayList<Sauce>(maxSauce);

//    setter
    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setMaxBelag(int maxBelag) {
        this.maxBelag = maxBelag;
    }

    public void setMaxSauce(int maxSauce) {
        this.maxSauce = maxSauce;
    }

    public void setBelagList(List<Belag> belagList) {
        this.belagList = belagList;
    }

    public void setSauceList(List<Sauce> sauceList) {
        this.sauceList = sauceList;
    }

//    getter
    public double getCost() {
        return cost;
    }

    public String getName() {
        return Name;
    }

    public int getMaxBelag() {
        return maxBelag;
    }

    public int getMaxSauce() {
        return maxSauce;
    }

    public List<Belag> getBelagList() {
        return belagList;
    }

    public List<Sauce> getSauceList() {
        return sauceList;
    }

//    methods
//    adds a Belag to the pizza.
//    returns 0 if successful, 1 if the maximum off toppings is reached
    public int addBelag(Belag belag) {

    }

//    adds a Sauce to the pizza.
//    returns 0 if successful, 1 if the maximum off toppings is reached, 2 if there is already a sauce on the pizza.
    public int addSauce(Sauce sauce) {

    }

//    removes a Belag from the pizza.
//    returns 0 if successful, 1 if there were none
    public int removeBelag(Belag belag) {

    }

//    removes a Sauce from the pizza.
//    returns 0 if successful, 1 if there was none.
    public int removeSauce(Sauce sauce) {

    }
}
