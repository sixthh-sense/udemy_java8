package com.acme.testing;

import com.acme.utils.ConversionService;

import java.math.BigDecimal;

public class TestConversionService {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(ConversionService.fluidOunces(1.1f));
		System.out.println(ConversionService.gallons(2.2f));
		System.out.println(ConversionService.grams(BigDecimal.valueOf(30)));
		System.out.println(ConversionService.milliliters(40));
		System.out.println(ConversionService.ounces(BigDecimal.valueOf(50)));
		System.out.println(ConversionService.pints(6.6f));
		System.out.println(ConversionService.pounds(BigDecimal.valueOf(7.7)));

		// can you figure out why these do not compile
		ConversionService.fluidOunces(1.1f); // 1.1 -> 1.1f :: double -> float
		ConversionService.grams(BigDecimal.valueOf(30)); //  30L -> 30 :: long -> int
		ConversionService.milliliters((int) 4.0); // 4.0 -> (int) 4.0 or 4? :: double -> int
		short grams = ConversionService.grams(BigDecimal.valueOf(30)).shortValueExact(); // short grams -> int grams :: short -> int // can't decide what part i should change
		byte byteGrams = ConversionService.grams(BigDecimal.valueOf(30)).byteValue(); // byte byteGrams -> int byteGrams :: byte -> int // can't decide what part i should change
		System.out.println(grams);
		 System.out.println(byteGrams);

		// why do these still work even though the types are different
		// small range -> big range
		// (when going from big to small u need to cast, but the other way around, it's not necessary)
		System.out.println("------------------------------------");
		double ounces = ConversionService.fluidOunces(1.1f); // float to double
		System.out.println(ounces);
		long milliliters = ConversionService.milliliters(40); // int to long
		System.out.println(milliliters);
		double decimalMilliliters = ConversionService.milliliters(40); // int to double
		System.out.println(decimalMilliliters);
		short s = 30;
		System.out.println(ConversionService.grams(BigDecimal.valueOf(s))); // short to int
		byte b = 4;
		System.out.println(ConversionService.milliliters(b)); // byte to int
		char z = 'z';
		System.out.println(ConversionService.milliliters(z)); // char to int(get that unicode something)
		System.out.println(ConversionService.gallons(200)); // int to float
		System.out.println(ConversionService.ounces(BigDecimal.valueOf(50.5f))); // float to double
		System.out.println(ConversionService.pints(6L)); // long to float
		System.out.println(ConversionService.pounds(BigDecimal.valueOf(7L))); // long to double

		// compare these results.  Can you tell why they are different?
		// in the small world(range), when things get out of range, they get chunked(precision loss)
		System.out.println("------------------------------------");
		float bigGallons = ConversionService.gallons(123456789123456789L);
		System.out.println(bigGallons);
		double bigGallons2 = 123456789123456789L * 0.2642;
		System.out.println(bigGallons2);

		System.out.println("------------------------------------");
		int bigGrams = ConversionService.grams(BigDecimal.valueOf(1234567890)).intValue();
		System.out.println(bigGrams);
		long bigGrams2 = 1234567890L * 1000L;
		System.out.println(bigGrams2);

		// lab 14 :: step 4.4.2
		double[][] results = ConversionService.allKgToPounds(14.0, 29.0, 6.5, 7.7);
		for (double[] result : results) {
			System.out.println(result[0] + " -> " + result[1]);
		}

		results = ConversionService.allKgToPounds(2, 5, 8, 4);
		for (double[] result : results) {
			System.out.println(result[0] + " -> " + result[1]);
		}
	}
}
