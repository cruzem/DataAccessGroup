package week04.app;


/**
 * Represents a user in the system.
 * This is one of the "primitive" data types in the system
 * 
 * @author Scott LaChance
 *
 */
public class User
{
	/**
	 * Default constructor
	 * Typically used when creating a new user
	 */
	public User()
	{
		this(-1, "Default", "Default");
	}

	/**
	 * Parameterized constructor
	 * 
	 * Typically used when creating a new user
	 * Defaults to an ID of -1
	 * 
	 * @param first First name
	 * @param last last name
	 */
	public User(String first, String last)
	{
		this(-1, first, last);
	}
	
	/**
	 * Parameterized constructor
	 * Typically used by the data layer when restoring a user
	 * from the data layer
	 * 
	 * @param id userid
	 * @param first First name
	 * @param last last name
	 */
	public User(long id, String first, String last)
	{
		this(id, -1, first, last);
	}
	
	/**
	 * Parameterized constructor
	 * Typically used by the data layer when restoring a user
	 * from the data layer
	 * 
	 * @param id userid
	 * @param pin the user pin
	 * @param first First name
	 * @param last last name
	 */
	public User(long id, int pin, String first, String last)
	{
		m_userId = id;
		m_pin = pin;
		m_firstName = first;
		m_lastName = last;
	}
	
	/**
	 * Get the User ID
	 * @return the user ID
	 */
	public long getUserId()
	{
		return m_userId;
	}
	
	/**
	 * Sets the User ID
	 * @param userId The user id to set
	 */
	public void setUserId(long userId)
	{
		this.m_userId = userId;
	}
	
	/**
	 * Get the first name of the user
	 * @return the users first name
	 */
	public String getFirstName()
	{
		return m_firstName;
	}

	/**
	 * Set the first name of the user
	 * @param firstName the name to assign as the first name
	 */
	public void setFirstName(String firstName)
	{
		this.m_firstName = firstName;
	}
	
	/**
	 * Get the last name of the user
	 * @return the users last name
	 */
	public String getLastName()
	{
		return m_lastName;
	}

	/**
	 * Set the first name of the user
	 * @param lastName the name to assign as the last name
	 */
	public void setLastName(String lastName)
	{
		this.m_lastName = lastName;
	}
	
	/**
	 * User pin
	 * @return user pin
	 */
	public int getPin()
	{
		return m_pin;
	}
	
	/**
	 * Set User pin
	 * @param pin the user pin to assign
	 */
	public void setPin(int pin)
	{
		m_pin = pin;
	}

	/**
	 * Overrides the Object.equals to compare two User references.
	 * The are equal if the attributes of the User instance are equal.
	 * 
	 * @param rhs The object on the right-hand side to evaluate
	 * @return true if match, otherwise false
	 */
	@Override
	public boolean equals(Object rhs)
	{
		boolean result = true;
		
		if( rhs == null )
		{
			result = false;
		}
		else if( getClass() != rhs.getClass())
		{
			result = false;
		}
		else
		{
			// valid User object, check the contents
			final User otherUser = (User) rhs;
			if( !this.m_firstName.equals(otherUser.m_firstName) ||
				!this.m_lastName.equals(otherUser.m_lastName) ||
				!(this.m_userId == otherUser.m_userId))
			{
				result = false;
			}
		}
				
		return result;
	}
	
	/**
	 * Overrides the default toString to provide a formatted version of the User object
	 * 
	 * @return formatted string representation of the User object
	 */
	@Override
	public String toString()
	{
		String fmt = String.format("ID: %d, %s %s", this.m_userId, this.m_firstName, this.m_lastName);
		return fmt;
	}
	
	
	private String m_firstName;
	private String m_lastName;
	private int m_pin;
	private long m_userId;
}
