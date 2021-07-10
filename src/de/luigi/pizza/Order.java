package de.luigi.pizza;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private String orderName;
    private List<Pizza> orderList = new ArrayList<Pizza>();

    public Order(String orderName) {
        this.orderName = orderName;
    }

//    setter
    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public void setOrderList(List<Pizza> orderList) {
        this.orderList = orderList;
    }

//    getter
    public String getOrderName() {
        return orderName;
    }

    public List<Pizza> getOrderList() {
        return orderList;
    }

//    get specific pizza via index
    public Pizza getPizza(int pizza) {
        return orderList.get(pizza);
    }


//    get total cost of order
    public double getTotalCost() {
        double totalCost = 0;

        for (Pizza pizza : orderList) {
            totalCost += pizza.getCost();
        }
        return totalCost;
    }

    public void addPizza(Pizza pizza) {
        orderList.add(pizza);
    }

    public void clearOrder() {
        orderList.clear();
    }
}
