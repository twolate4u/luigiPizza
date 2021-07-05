package de.luigi.pizza;

import java.util.ArrayList;
import java.util.List;

public class Pizza {

    private double cost;
    private String Name;
//    maximale Anzahl von Belägen pro Pizza. inkl. Sauce.
    private int maxBelag = 8;
//    maximale Anzahl von Saucen pro Pizza
    private int maxSauce = 1;
    private List<Belag> belagList = new ArrayList<Belag>();
    private List<Sauce> sauceList = new ArrayList<Sauce>();

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

    public void setBelagList(List<Belag> belagList) { this.belagList = belagList; }

    public void setSauceList(List<Sauce> sauceList) { this.sauceList = sauceList; }

//    getter
    public double getCost() { return cost; }

    public String getName() { return Name; }

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
        if ((belagList.size() + sauceList.size()) >= maxBelag) {
            return 1;
        }
        else {
            belagList.add(belag);
            return 0;
        }
    }

//    adds a Sauce to the pizza.
//    returns 0 if successful, 1 if the maximum off toppings is reached, 2 if there is already a sauce on the pizza.
//    returns 1 if both errors occur.
    public int addSauce(Sauce sauce) {
        if ((belagList.size() + sauceList.size()) >= maxBelag) {
            return 1;
        }
        else if (sauceList.size() >= maxSauce) {
            return 2;
        }
        else {
            sauceList.add(sauce);
            return 0;
        }
    }

//    removes a Belag from the pizza. Maybe overload for removal via index?
//    returns true if sucessful, false if belag not in list
    public boolean removeBelag(Belag belag) {
        return belagList.remove(belag);
    }

//    does this even work or do i need a temp object?
    public boolean removeBelag(int belag) {
        if (belagList.remove(belag) == belagList.get(belag)) {
            return true;
        }
        return false;
    }

//    removes a Sauce from the pizza. Maybe overload for removal via index?
//    returns true if sucessful, false if belag not in list
    public boolean removeSauce(Sauce sauce) {
        return belagList.remove(sauce);
    }

    public boolean removeSauce(int sauce) {
        if (belagList.remove(sauce) == belagList.get(sauce)) {
            return true;
        }
        return false;
    }
}
