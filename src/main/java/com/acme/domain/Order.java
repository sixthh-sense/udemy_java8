package com.acme.domain;

public class Order {
    private static Rushable rushable;
    public static Rushable getRushabe() { // getter
        return rushable;
    }
    public static void setRushabe(Rushable rushable) { // setter
        Order.rushable = rushable;
    }
    /*public boolean isPriorityOrder() {
        boolean priorityOrder = false;
        if (rushable != null) {
            priorityOrder = rushable.isRushable(orderDate, orderAmount);
        }
        return priorityOrder;
    }*/
}
