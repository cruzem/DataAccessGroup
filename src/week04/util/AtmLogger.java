package week04.util;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


/**
 * The ATM Logger for ATM project.
 * This class encapsulates a set of Java Logger Instances
 * and setup handlers.
 * 
 * @author 
 *
 */
public class AtmLogger
{
	/**
	 * Returns the singleton instance of the logger
	 * @return atmLogger
	 */
	static Logger getAtmLogger()
	{
		return atmLogger;
	}
	
	/**
	 * Initializes the logging system for our purposes
	 * 
	 * @throws IOException
	 */
	static public void setup() throws IOException
	{
		//suppress the logging output to the console
		Logger rootLogger = Logger.getLogger("");
		Handler[] handlers = rootLogger.getHandlers();
		if(handlers.length > 0)
		{
			if(handlers[0] instanceof ConsoleHandler)
			{
				rootLogger.removeHandler(handlers[0]);
			}
		}
		
		//Set the log level and the file names
		atmLogger.setLevel(Level.INFO);
		fileTxt = new FileHandler("Logging.txt");
		fileHTML = new FileHandler("Logging.html");
		
		//Create a TXT formatter
		formatterTxt = new SimpleFormatter();
		fileTxt.setFormatter(formatterTxt);
		atmLogger.addHandler(fileTxt);
		
		//create an HTML formatter
		formatterHTML = new AtmHtmlLoggingFormatter();
		fileHTML.setFormatter(formatterHTML);
		atmLogger.addHandler(fileHTML);
				
	}
	
	/**
	 * Adds the configured handlers to the provided logger
	 * Used by other classes that implement logging to
	 * ensure the logging is routed to the right files.
	 * 
	 * @param logger
	 */
	static public void addAtmLoggerHandlers(Logger logger)
	{
		logger.addHandler(fileTxt);
		logger.addHandler(fileHTML);
		
	}
	
	static private FileHandler fileTxt;
	static private SimpleFormatter formatterTxt;
	static private FileHandler fileHTML;
	static private Formatter formatterHTML;
	
	static public String ATM_LOGGER = "ATM_LOGGER";
	static Logger atmLogger;
	
	/**
	 * Static Initializer
	 */
	static
	{
		//COnfigure the root application logger
		atmLogger = Logger.getLogger(ATM_LOGGER);
	}
}
