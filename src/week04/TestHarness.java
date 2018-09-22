package week04;

import test.AbstractTestHarness;


/**
 * File: TestHarness.java
 */
class TestHarness extends AbstractTestHarness
{
	public static void main(String[] args)
	{
		new TestHarness().runTests();
	}

	/**
	 * Implements the base class abstract method
	 */
	protected void runTests()
	{
		try
		{			
			boolean appTest = executeTest(week04.app.AppTest.class);
			boolean testData = executeTest(week04.data.DataAccessTest.class);
			boolean testLogging = executeTest(TestLogging.class);
			boolean testJavadoc = executeTest(JUnitJavadocValidation.class);
			boolean result = appTest && testData && testLogging && testJavadoc;

			trace(result ? "Tests Passed" : "Tests Failed");
		}
		catch(Exception ex)
		{
			trace(ex.getMessage());
		}
	}
}