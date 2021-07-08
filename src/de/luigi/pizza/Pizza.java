package de.luigi.pizza;

import java.util.ArrayList;
import java.util.List;

public class Pizza {

    private double cost;
    private String name;
//    maximale Anzahl von Zutaten pro Pizza.
    private int maxZutat = 8;
//    maximale Anzahl von Saucen pro Pizza
    private int maxSauce = 1;
    private List<Zutat> zutatList = new ArrayList<Zutat>();
    private List<Sauce> sauceList = new ArrayList<Sauce>();

//    setter
    public void setCost(double cost) {
        this.cost = cost;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setMaxZutat(int maxZutat) {
        this.maxZutat = maxZutat;
    }
    public void setMaxSauce(int maxSauce) {
        this.maxSauce = maxSauce;
    }
    public void setBelagList(List<Zutat> zutatList) {
        this.zutatList = zutatList;
    }
    public void setSauceList(List<Sauce> sauceList) {
        this.sauceList = sauceList;
    }

//    getter
    public double getCost() {
        return cost;
    }
    public String getName() {
        return name;
    }
    public int getMaxZutat() {
        return maxZutat;
    }
    public int getMaxSauce() {
        return maxSauce;
    }
    public List<Zutat> getBelagList() {
        return zutatList;
    }
    public List<Sauce> getSauceList() {
        return sauceList;
    }

//    methods
//    adds a Belag to the pizza.
//    returns 0 if successful, 1 if the maximum off toppings is reached

    public int addBelag(Zutat zutat) {
        if (zutatList.size() >= maxZutat) {
            return 1;
        }
        zutatList.add(zutat);
        return 0;
    }

//    adds a Sauce to the pizza.
//    returns 0 if successful, 2 if there is already a sauce on the pizza.
    public int addBelag(Sauce sauce) {
        if (sauceList.size() >= maxSauce) {
            return 2;
        }
        sauceList.add(sauce);
        return 0;
    }
}
