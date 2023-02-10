package com.acme.domain;

import com.acme.utils.HolidayOrdersNotAllowedException;
import com.acme.utils.MyDate;

public class Order {

	private MyDate orderDate;
	private double orderAmount = 0.00;
	private String customer;
	private Product product;
	private int quantity;
	private static double taxRate = 0.05;
//	static {
//		taxRate = 0.05;
//	}
	// lab 12 :: step 1
	public static Rushable rushable;

	public static Rushable getRushable() {
		return rushable;
	}

	public static void setRushable(Rushable rushable) {
		Order.rushable = rushable;
	}

	// getters & setters
	public MyDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(MyDate orderDate) throws HolidayOrdersNotAllowedException {
		if (isHoliday(orderDate)) {
			System.out.println("Order date, " + orderDate + ", cannot be set to a holiday!"); // like, is already a holiday
			throw new HolidayOrdersNotAllowedException(orderDate);
		} else {
			this.orderDate = orderDate;
		}
	}

	public double getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(double orderAmount) {
		if (positive(orderAmount, quantity)) {
			this.orderAmount = orderAmount;
		}
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		if (positive(orderAmount, quantity)) {
			this.quantity = quantity;
		}
	}

	public static double getTaxRate() {
		return taxRate;
	}

	public static void setTaxRate(double taxRate) {
		Order.taxRate = taxRate;
	}

	// constructors
	public Order(MyDate d, double amt, String c, Product p, int q) {
		try {
			setOrderDate(d);
		} catch (HolidayOrdersNotAllowedException e) {
			System.out.println("The order date for an order cannot be a holiday! Application closing.");
			System.exit(0);
		}
		orderDate = d;
		orderAmount = amt;
		customer = c;
		product = p;
		quantity = q;
	}
	public Order(MyDate d, double amt, String c) {
		this(d, amt, c, new Solid("Acme Anvil", 1668, 0.3, Good.UnitOfMeasureType.CUBIC_METER, false, 500, 0.25, 0.3), 1);
	}

	// methods
	private boolean positive(double orderAmount, int quantity) {
		//return !(orderAmount <= 0) && quantity > 0;
		// return orderAmount > 0 && quantity > 0;
		if (orderAmount > 0 && quantity > 0) {
			return true;
		} else {
			if (orderAmount <= 0) {
				System.out.println("Attempting to set the orderAmount to a value less than or equal to zero");
				//System.out.println("order sum is negative or zero value: " + orderAmount);
			} else {
				System.out.println("Attempting to set the quantity to a value less than or equal to zero");
				//System.out.println("quantity is negative or zero value: " + quantity);
			}
			return false;
		}
	}

	public static void computeTaxOn(double anAmount) {
		System.out.println("The tax for " + anAmount + " is: " + anAmount * Order.taxRate);
	}
	public String toString(){
		return quantity + " ea. " + product + " for " + customer; 
	}
	public double computeTax() {
		System.out.println("The tax for this order is: " + orderAmount * Order.taxRate);
		return orderAmount * Order.taxRate;
	}

	// lab 6 syntax start
	public char jobSize() {
		if (quantity <= 25) {
			return 'S';
		} else if (quantity <= 75) {
			return 'M';
		} else if (quantity <= 150) {
			return 'L';
		}
		return 'X';
	}

	public double computeTotal() {
		double discountRate = 0.00;
		switch (this.jobSize()) {
			case 'S':
				discountRate = 0.00;
				break;
			case 'M':
				discountRate = 0.01;
				break;
			case 'L':
				discountRate = 0.02;
				break;
			case 'X':
				discountRate = 0.03;
				break;
		}
		// 'greater than' 등호 포함 여부가 항상 헷갈림
		return orderAmount > 1500 ? orderAmount * (1 - discountRate) : orderAmount * (1 - discountRate + taxRate);
	}

	public boolean isPriorityOrder() {
		boolean priorityOrder = false;
		if (rushable != null) {
			priorityOrder = rushable.isRushable(orderDate, orderAmount);
		}
		return priorityOrder;
	}

	private boolean isHoliday(MyDate proposedDate) {
		boolean result = false;
		for (MyDate holiday : MyDate.getHolidays()) {
			if (holiday.equals(proposedDate)) {
				result = true;
				// no break?
			}
		}
		return result;
	}
}
