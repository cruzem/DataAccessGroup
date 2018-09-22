package week04;

/**
 * ATM Application Exception class 
 * @author scottl
 *
 */
public class AtmException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 */
	public AtmException()
	{
	}

	/**
	 * Extends the base Exception class constructor
	 * @param description Error description
	 */
	public AtmException(String description)
	{
		super(description);
	}

	/**
	 * Extends the base Exception class constructor
	 * @param ex The root exception causing the error
	 */
	public AtmException(Throwable ex)
	{
		super(ex);
	}

	/**
	 * Extends the base Exception class constructor
	 * 
	 * @param description Error description
	 * @param ex The root exception causing the error
	 */
	public AtmException(String description, Throwable ex)
	{
		super(description, ex);
	}

	/**
	 * Extends the base Exception class constructor
	 * 
	 * @param description Error description
	 * @param ex The root exception causing the error
	 * @param suppression enable suppression
	 * @param writable writable stack trace
	 */
	public AtmException(String description, Throwable ex, boolean suppression, boolean writable)
	{
		super(description, ex, suppression, writable);
	}

}
