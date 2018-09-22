package week04;

import static org.junit.Assert.*;

import org.junit.Test;
import test.AbstractJUnitBase;
import java.util.logging.Level;
import java.util.logging.Logger;

import week04.util.AtmLogger;

/**
 * Tests the logging subsystem
 * @author scottl
 *
 */
public class TestLogging extends AbstractJUnitBase
{
	// use the classname for the logger, this way you can refactor
	private final static Logger LOGGER = Logger.getLogger(Logger.class.getName());

	private final static Logger testLogger = 
			Logger.getLogger(AtmLogger.ATM_LOGGER + "." + TestLogging.class.getName());


	@Test
	public void testLogger()
	{
		try
		{
			AtmLogger.setup();
			AtmLogger.addAtmLoggerHandlers(LOGGER);	// Logger class
			AtmLogger.addAtmLoggerHandlers(testLogger);// This class

			// set the LogLevel to Severe, only severe Messages will be written
			LOGGER.setLevel(Level.SEVERE);
			LOGGER.severe("Severe Log");
			LOGGER.warning("Warning Log");
			LOGGER.info("Info Log");
			LOGGER.finest("Really not important");

			// set the LogLevel to Info, severe, warning and info will be
			// written
			// finest is still not written
			LOGGER.setLevel(Level.INFO);
			LOGGER.severe("Severe Log");
			LOGGER.warning("Warning Log");
			LOGGER.info("Info Log");
			LOGGER.finest("Really not important");

			// set the LogLevel to Severe, only severe Messages will be written
			testLogger.setLevel(Level.SEVERE);
			LOGGER.severe("Severe Log");
			LOGGER.warning("Warning Log");
			LOGGER.info("Info Log");
			testLogger.finest("Really not important");

			// set the LogLevel to Info, severe, warning and info will be
			// written
			// finest is still not written
			testLogger.setLevel(Level.INFO);
			LOGGER.severe("Severe Log");
			LOGGER.warning("Warning Log");
			LOGGER.info("Info Log");
			testLogger.finest("Really not important");			
		}
		catch(Exception ex)
		{
			trace("Error testing logger");
			trace(ex.getMessage());
			fail(ex.getMessage());
		}
	}
}
