package de.luigi.pizza;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private String orderName;
    private List<Pizza> orderList = new ArrayList<Pizza>();

    public Order(String orderName) {
        this.orderName = orderName;
    }

//    get total cost of order
    public double getTotalCost() {
        double totalCost = 0;

        for (Pizza pizza : orderList) {
            totalCost += pizza.getCost();
        }
        return totalCost;
    }

    public void clearOrder() {
        orderList.clear();
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
}

