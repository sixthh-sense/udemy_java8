package com.acme.testing;

import com.acme.domain.Good.UnitOfMeasureType;
import com.acme.domain.Solid;
import com.acme.domain.Service;
import com.acme.utils.MyDate;
import com.acme.domain.Order;

import java.time.LocalDate;

public class TestOrders {
	public static void main(String[] args) {
		MyDate date1 = new MyDate(1,20,2008);
		Solid s1 = new Solid("Acme Anvil", 1668, 0.3, UnitOfMeasureType.CUBIC_METER, false, 500, 0.25, 0.3);
		Order anvil = new Order(date1, 2000.00, "Wile E Coyote", s1, 10);

		MyDate date2 = new MyDate(4,10,2008);
		Solid s2 = new Solid("Acme Balloon", 1401, 15, UnitOfMeasureType.CUBIC_FEET, false, 10, 5, 5);
		Order balloons = new Order(date2, 1000.00, "Bugs Bunny", s2, 125);

		balloons.setQuantity(-200); // lab 08 test code

		System.out.println(anvil);
		System.out.println(balloons);

		System.out.println("The tax rate is currently: " + Order.getTaxRate());
		Order.computeTaxOn(3000.00);
		anvil.computeTax();
		balloons.computeTax();

		Order.setTaxRate(0.06);
		System.out.println("The tax rate is currently: " + Order.getTaxRate());
		Order.computeTaxOn(3000.00);
		anvil.computeTax();
		balloons.computeTax();

		MyDate date3 = new MyDate(5, 20, 2008);
		Order anotherAnvil = new Order(date3, 200, "Road Runner");
		System.out.println(anotherAnvil);

		// lab 06
		System.out.println("The total bill for: " + anvil + " is " + anvil.computeTotal());
		System.out.println("The total bill for: " + balloons + " is " + balloons.computeTotal());

		// lab 10 :: bonus(step 3)
		System.out.println("The volume of the anvil is: " + ((Solid)anvil.getProduct()).volume());
		System.out.println("The length of the anvil is: " + ((Solid) anvil.getProduct()).getLength()); // if the product(anvil) was liquid, get radius rather than length

		// lab 11 :: step 5
		MyDate date3_2 = new MyDate(4, 10, 2008);
		Service s3 = new Service("Road Runner Eradication", 14, false);
		Order birdEradication = new Order(date3_2, 20000, "Daffy Duck", s3, 1);
		System.out.println("The total bill for: " + birdEradication + " is " + birdEradication.computeTotal());

		// lab 12 :: step 4
		Order.setRushable((orderDate, orderAmount) -> orderAmount > 1500);
		System.out.println("Anvil isPriorityOrder: " + anvil.isPriorityOrder());
		System.out.println("Balloons isPriorityOrder: " + balloons.isPriorityOrder());

		// lab 13 :: step 1
		Order.setRushable((od, oa) -> {
			LocalDate now = LocalDate.now();
			LocalDate orderDate = LocalDate.of(od.getYear(), od.getMonth(), od.getDay());
			LocalDate after30Days = orderDate.plusMonths(1);
			return now.isAfter(after30Days);
		});

		// lab 13 :: step 2
		// MyDate hammerDate = new MyDate(1, 26, 2023); // change this date to one that is within the last 15 days of today
		// wanted to have real-time random effect
		LocalDate within15 = LocalDate.now().minusDays((long)(Math.random() * 16));
		MyDate hammerDate = new MyDate(within15.getMonthValue(), within15.getDayOfMonth(), within15.getYear());
		System.out.println("within 15 date: " + hammerDate);
		Solid hammerType = new Solid("Acme Hammer", 281, 0.3, UnitOfMeasureType.CUBIC_METER, false, 100, 0.25, 0.3);
		Order hammer = new Order(hammerDate, 10.00, "Wile E Coyote", hammerType, 10);

		// verify that the anvil is considered a priority item and the hammer is not
		System.out.println("Anvil isPriorityOrder: " + anvil.isPriorityOrder()); // intended: true
		System.out.println("Hammer isPriorityOrder: " + hammer.isPriorityOrder()); // intended: false
	}
}
