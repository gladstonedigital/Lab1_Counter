/**
* Tests Counter.java
*
* @author Ben Gladstone
* @version 0.0.1
*/
public class CounterTester {
	private static int failedTests = 0;
	private static int totalTests = 0;
	
    /**
    * Runs a series of tests on the class Counter
    * @param args   command line arguments
    */
	public static void main(String[] args) {
		// Test default constructor
		Counter c = new Counter();
		System.out.println(c.toString());
		test(c.getCount() == 0, "Initial value was not 0");
		test(c.getMaximumCount() == -1, "Counter created with default constructor did not have maximum count of -1");
		
		// Test incrementCount()
		c.incrementCount();
		test(c.getCount() == 1, "incrementCount() didn't increment");
		
		// Test setMaximumCount()
		c = new Counter();
		c.setMaximumCount(1);
		test(c.getMaximumCount() == 1, "setMaximumCount(int) did not set maximum count");
		
		// Test int constructor
		c = new Counter(1);
		test(c.getMaximumCount() == 1, "Constructor with int parameter did not set maximum value");
		
		// Test rollover at maximum
		c.incrementCount();
		c.incrementCount();
		test(c.getCount() == 0, "Counter did not rollover to 0 after incremented past maximum");
		
		// Test disabling maximum
		c.setMaximumCount(-1);
		for (int i = 0; i < 100; i++) {
			c.incrementCount();
		}
		test(c.getCount() == 100, "Counter that had a maximum, which was then disabled, did not actually disable the maximum value");
		
		// Test reset()
		c = new Counter();
		c.incrementCount();
		c.reset();
		test(c.getCount() == 0, "Counter which was reset did not reset to 0");
		
		// Test unReset()
		c = new Counter();
		for (int i = 0; i < 37; i++) {
			c.incrementCount();
		}
		c.reset();
		c.unReset();
		test(c.getCount() == 37, "Counter which was reset and then unReset did not restore the previous value");
		
		// Test that unReset() does not change a counter which has never been reset
		c = new Counter();
		c.incrementCount();
		c.unReset();
		test(c.getCount() == 1, "Counter which was never reset was changed by unReset()");
		
		reportResults();
	}
	
    /**
    * Prints the results of the tests
    */
	private static void reportResults() {
		if (failedTests == 0) {
			System.out.printf("Passed all %d tests!\n", totalTests);
		} else {
			System.out.printf("Failed %d/%d tests.\n", failedTests, totalTests);
		}
	}
	
    /**
    * Run a test of the statement. If statement is true, the test passes.
    * If statement is false, print message to the user.
    * @param statement  the logical statement being tested
    * @param message    error message if the test fails
    */
	private static void test(boolean statement, String message) {
		totalTests++;
		if (!statement) {
			System.out.printf("Failed test %d: %s\n", totalTests, message);
			failedTests++;
		}
	}
}