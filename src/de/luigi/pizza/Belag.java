package de.luigi.pizza;

public class Belag {
    protected double cost;
    protected String name;
    protected int id;

//    constructor


    public Belag() { }

    public Belag(double cost, String name, int id) {
        this.cost = cost;
        this.name = name;
        this.id = id;
    }

    //    getter
    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

//    setter
    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
