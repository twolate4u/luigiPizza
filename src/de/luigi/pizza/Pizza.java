package de.luigi.pizza;

import java.util.ArrayList;
import java.util.List;

public class Pizza {

//    maximale Anzahl von Zutaten pro Pizza.
    private int maxZutat = 8;
//    maximale Anzahl von Saucen pro Pizza
    private int maxSauce = 1;
    private double cost;
    private String name;
    private List<Zutat> zutatList = new ArrayList<Zutat>();
    private List<Sauce> sauceList = new ArrayList<Sauce>();

//    methods

//    adds a Zutat to the pizza.
//    returns true if successful, false if the maximum off toppings is reached
    public boolean addZutat(Zutat zutat) {
        if (zutatList.size() >= maxZutat) {
            return false;
        }
        zutatList.add(zutat);
        return true;
    }

//    adds a Sauce to the pizza.
//    returns true if successful, false if there is already a sauce on the pizza.
    public boolean addSauce(Sauce sauce) {
        if (sauceList.size() >= maxSauce) {
            return false;
        }
        sauceList.add(sauce);
        return true;
    }

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
    public List<Zutat> getZutatList() {
        return zutatList;
    }
    public List<Sauce> getSauceList() {
        return sauceList;
    }
}
