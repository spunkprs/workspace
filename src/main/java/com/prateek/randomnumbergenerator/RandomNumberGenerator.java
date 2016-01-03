package com.prateek.randomnumbergenerator;

public class RandomNumberGenerator {
	
	private static int toss() {
		return (int) (System.currentTimeMillis() & new Long(1));
	}
	
	public static int getRandomlyGeneratedNumber(final int number) {
		return getRandom(number);
	}

	private static int getRandom(final int number) {
		if (number == 1) {
			return 0;
		}
		int n = Double.valueOf(Math.ceil(Math.log(number)/Math.log(2))).intValue();
		int x = 0;
		while(true) {
			x = 0;
			for (int i = 0; i <= n; i++) {
				x += Math.pow(2, i) * toss();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if (x < number) {
				break;
			}
		}
		return x;
	}
	
}
