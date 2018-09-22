package week04.data;

import week04.AtmException;

/**
 * Data Access Exception class
 * @author Scott LaChance
 *
 */
public class AtmDataException extends AtmException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor
	 */
	public AtmDataException()
	{
		
	}

	/**
	 * Extends base class exception
	 * @param description Error description
	 */
	public AtmDataException(String description)
	{
		super(description);
	}

	/**
	 * Extends base class exception
	 * 
	 * @param ex Root exception cause 
	 */
	public AtmDataException(Throwable ex)
	{
		super(ex);
	}

	/**
	 * Extends base class exception
	 * @param description Error description
	 * @param ex The root exception causing the error
	 */
	public AtmDataException(String description, Throwable ex)
	{
		super(description, ex);
	}

	/**
	 * Extends base class exception
	 * 
	 * @param description Error description
	 * @param ex The root exception causing the error
	 * @param suppression enable suppression
	 * @param writable writable stack trace
	 */
	public AtmDataException(String description, Throwable ex, boolean suppression,
			boolean writable)
	{
		super(description, ex, suppression, writable);
	}

}
