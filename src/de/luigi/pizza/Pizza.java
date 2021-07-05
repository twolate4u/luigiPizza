package de.luigi.pizza;

public class Pizza {

    double cost;
    String Name;

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
}
