package com.acme.testing;

import com.acme.domain.Good;
import com.acme.domain.Liquid;
import com.acme.domain.Solid;

import java.util.Collections;
import java.util.List;

/*
import com.acme.domain.Good;
import com.acme.domain.Liquid;
import com.acme.domain.Solid;
import com.acme.domain.Good.UnitOfMeasureType;
*/
public class TestGoods {

	public static void main(String[] args) {

		Liquid glue = new Liquid("Acme Glue", 2334, 4, Good.UnitOfMeasureType.LITER,
				false, 15, 6);
		Liquid paint = new Liquid("Acme Invisible Paint", 2490, 0.65,
				Good.UnitOfMeasureType.GALLON, true, 0.70, 12);
		Solid anvil = new Solid("Acme Anvil", 1668, 0.3, Good.UnitOfMeasureType.CUBIC_METER, false, 5000, 0.5,
				0.5);

		System.out.println(glue);
		System.out.println(paint);
		System.out.println(anvil);
		
		System.out.println("The weight of " + glue + " is " + glue.weight());
		System.out.println("The weight of " + paint + " is " + paint.weight());
		System.out.println("The weight of " + anvil + " is " + anvil.weight());

		Good x = glue;
		System.out.println("Is " + x + " flammable?  " + x.isFlammable());
		x = paint;
		System.out.println("Is " + x + " flammable?  " + x.isFlammable());

		// bonus lab 9 :: step 5
		System.out.println(glue + " can ship via Post office? " + glue.canShipViaPostOffice());
		System.out.println(anvil + " can ship via Post office? " + anvil.canShipViaPostOffice());
		System.out.println(paint + " can ship via Post office? " + paint.canShipViaPostOffice());

		// lab 15 :: step 2
		System.out.println(Good.getCatalog());
		// lab 15 :: step 3
		Good.getCatalog().remove(1); // want to remove "invisible" paint
		Solid toaster = new Solid("Acme Toaster", 1755, 0.75, Good.UnitOfMeasureType.CUBIC_FEET, false, 1.0, 1.0, 1.0);
		Good.getCatalog().add(toaster);
		Good.getCatalog().add(toaster);
		System.out.println(Good.getCatalog());

		// lab 15 :: step 4
		System.out.println("Flammable products: " + Good.flammablesList());

		// lab 16 :: step 4(bonus)
		Good.getCatalog().add(paint);

		// lab 16 :: step 3
		Collections.sort(Good.getCatalog());
		System.out.println(Good.getCatalog());

		// lab 16 :: step 4 (bonus)
		for (Good good : Good.getCatalog()) {
			if (good.getName().equals("Acme Invisible Paint") && good.getModelNumber() == 2490) {
				if (Good.getCatalog().indexOf(good) != 3) {
					int random = (int) (Math.random() * 3);
					Good.getCatalog().remove(random);
				}
				System.out.println("Found " + good.getName() + "-" + good.getModelNumber() + " (liquid) " + good.volume()+ " " + good.getUnitOfMeasure() + " in the catalog at location: " + Good.getCatalog().indexOf(good));
				break;
			}
		}
	}
}
