package week04;

import static org.junit.Assert.*;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import test.TestResult;
import test.TestResultDetail;
import test.javadoc.ConstructorTestData;
import test.javadoc.FileTestData2;
import test.javadoc.JUnitJavadocValidationUtility2;
import test.javadoc.MethodTestData2;

/**
 * Tests the Javadoc in the source file.
 * 
 * @author Scott
 *
 */
public class JUnitJavadocValidation
{
	public JUnitJavadocValidation()
	{
		m_stream = System.out; // Standard out
		
		trace("########### Initializing JUnitJavadocValidation for week02 ###########");
		
		List<FileTestData2> testFiles = new ArrayList<FileTestData2>();
		List<MethodTestData2> methods = new ArrayList<MethodTestData2>();
		List<ConstructorTestData> constructors = new ArrayList<ConstructorTestData>();
				
		constructors.add(new ConstructorTestData("User", 0, "public"));
		constructors.add(new ConstructorTestData("User", 2, "public"));
		constructors.add(new ConstructorTestData("User",3, "public"));
		constructors.add(new ConstructorTestData("User",4, "public"));
		
		methods.add(new MethodTestData2("equals", "Object", "boolean","public"));
		methods.add(new MethodTestData2("getFirstName", "", "String","public"));
		methods.add(new MethodTestData2("getLastName", "", "String","public"));
		methods.add(new MethodTestData2("getPin", "", "int","public"));
		methods.add(new MethodTestData2("getUserId", "", "long","public"));
		methods.add(new MethodTestData2("setFirstName", "String", "void","public"));
		methods.add(new MethodTestData2("setLastName", "String", "void","public"));
		methods.add(new MethodTestData2("setPin", "int", "void","public"));
		methods.add(new MethodTestData2("setUserId", "long", "void","public"));
		methods.add(new MethodTestData2("toString", "", "String","public"));
		
		testFiles.add(new FileTestData2("week04.app", "User.java", methods,constructors));		
		
		List<MethodTestData2> methods2 = new ArrayList<MethodTestData2>();
		List<ConstructorTestData> constructors2 = new ArrayList<ConstructorTestData>();
				
		constructors2.add(new ConstructorTestData("DataAccess", 0, "private"));
		constructors2.add(new ConstructorTestData("DataAccess",2, "private"));
		
		methods2.add(new MethodTestData2("connect", "", "void","public"));
		methods2.add(new MethodTestData2("getAccount", "int", "Account","public"));
		methods2.add(new MethodTestData2("getAllAccounts", "", "List<Account>","public"));
		methods2.add(new MethodTestData2("getConnection", "", "Connection","public"));
		methods2.add(new MethodTestData2("getUserById", "long", "User","public"));
		methods2.add(new MethodTestData2("getUsers", "", "List<User>","public"));
		methods2.add(new MethodTestData2("saveAccount", "Account", "void","public"));
		methods2.add(new MethodTestData2("saveUser", "User", "void","public"));			
		
		testFiles.add(new FileTestData2("week04.data", "DataAccess.java", methods2,constructors2));
		
		List<MethodTestData2> methods3 = new ArrayList<MethodTestData2>();
		List<ConstructorTestData> constructors3 = new ArrayList<ConstructorTestData>();
		methods3.add(new MethodTestData2("addAtmLoggerHandlers", "Logger", "void","public"));
		methods3.add(new MethodTestData2("getAtmLogger", "", "Logger","public"));
		
		testFiles.add(new FileTestData2("week04.util", "AtmLogger.java", methods3,constructors3));
		
		List<MethodTestData2> methods4 = new ArrayList<MethodTestData2>();
		List<ConstructorTestData> constructors4 = new ArrayList<ConstructorTestData>();
		constructors4.add(new ConstructorTestData("Account", 0, "public"));
		constructors4.add(new ConstructorTestData("Account", 2, "public"));
		constructors4.add(new ConstructorTestData("Account", 3, "public"));
		constructors4.add(new ConstructorTestData("Account", 4, "public"));
		
		methods4.add(new MethodTestData2("equals", "Object", "boolean","public"));
		methods4.add(new MethodTestData2("getAccountId", "", "long","public"));
		methods4.add(new MethodTestData2("getBalance", "", "double","public"));
		methods4.add(new MethodTestData2("getName", "", "String","public"));
		methods4.add(new MethodTestData2("getUser", "", "User","public"));
		methods4.add(new MethodTestData2("getUserId", "", "long","public"));
		methods4.add(new MethodTestData2("setAccountId", "long", "void","public"));
		methods4.add(new MethodTestData2("setName", "String", "void","public"));
		methods4.add(new MethodTestData2("setUser", "User", "void","public"));
		methods4.add(new MethodTestData2("toString", "", "String","public"));
		
		testFiles.add(new FileTestData2("week04.app", "Account.java", methods4,constructors4));		
		
		m_validator = new JUnitJavadocValidationUtility2("Week04 Javadoc Test",
				testFiles);
		
		m_validator.suppressParserTrace(true);
	}

	@Test
	public void testJavadoc()
	{
		trace("** Validating Javadoc **");

		// Update these values for each assignment
		// m_packageName = "week02";
		TestResult result = m_validator.runTest();
		StringBuilder details = new StringBuilder();
		if(!result.passed())
		{			
			List<TestResultDetail> detailList = result.getTestResultDetails();
			for(TestResultDetail detail : detailList)
			{
				trace(detail.testDetails());
				details.append(detail.testDetails());
				details.append(CRLF);
			}
		}
		trace(String.format("** Test result: %s **", result.passed() ? "Passed" : "Failed"));
		assertTrue(details.toString(), result.passed());
	}
	
	/**
	 * Trace the msg to a PrintStream Provides the method for tests to report
	 * status
	 * 
	 * @param msg
	 */
	private void trace(String msg)
	{
		m_stream.println(msg);
	}
	
	private JUnitJavadocValidationUtility2 m_validator;
	protected PrintStream m_stream;
	private static String CRLF = System.getProperty("line.separator");
}
