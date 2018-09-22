package week04.app;

/**
 * Account class
 * 
 * @author Scott LaChance
 *
 */
public class Account
{
	/**
	 * Default constructor
	 */
	public Account()
	{
		this(-1, new User(), "Default Account", 0.0);
	}
	
	/**
	 * Parameterized constructors
	 * 
	 * @param user User reference
	 * @param name account name
	 */
	public Account(User user, String name)
	{
		this(-1, user, name, 0.0);
	}
	
	/**
	 * Parameterized constructors
	 * 
	 * @param user User reference
	 * @param name account name
	 * @param balance Account balance
	 */
	public Account(User user, String name, double balance)
	{
		this(-1, user, name, balance);
	}
	
	/**
	 * Parameterized constructors
	 * 
	 * @param id account id
	 * @param user User reference
	 * @param name account name
	 * @param balance Account balance
	 */
	public Account(long id, User user, String name, double balance)
	{
		m_accountId = id;
		m_user = user;
		m_accountName = name;
		m_balance = balance;
	}
	
	/**
	 * Get the account ID
	 * 
	 * @return the m_userId
	 */
	public long getAccountId()
	{
		return m_accountId;
	}
	
	/**
	 * Get the User associated with the account
	 * @return User reference
	 */
	public User getUser()
	{
		return m_user;
	}
	
	/**
	 * Get the user id directly
	 * 
	 * @return the m_userId
	 */
	public long getUserId()
	{
		return m_user.getUserId();
	}
	
	/**
	 * Sets the account id
	 * 
	 * @param id account id to set
	 */
	public void setAccountId(long id)
	{
		m_accountId = id;
	}
	
	/**
	 * Set the user to associate with the account
	 * @param user the user reference to associate
	 */
	public void setUser(User user)
	{
		this.m_user = user;
	}
		
	/**
	 * The name of the accont
	 * 
	 * @return the name of the account
	 */
	public String getName()
	{
		return m_accountName;
	}
	
	/**
	 * Return account balance
	 * 
	 * @return Current account balance
	 */
	public double getBalance()
	{
		return m_balance;
	}

	/**
	 * Set the name of the account
	 * @param name the name of the account
	 */
	public void setName(String name)
	{
		this.m_accountName = name;
	}

	/**
	 * Tests the equality of two account objects
	 * They are equal if the Account attributes are equal
	 * 
	 * @param obj The right hand object (rhs) to test
	 * @return true if equal, otherwise false
	 */
	@Override
	public boolean equals(Object obj)
	{
		boolean result = true;
		
		if( obj == null )
		{
			result = false;
		}
		else if( getClass() != obj.getClass())
		{
			result = false;
		}
		else
		{
			// valid User object, check the contents
			final Account otherUser = (Account) obj;
			if( !this.m_accountName.equals(otherUser.m_accountName) ||
				!this.m_user.equals(otherUser.m_user) ||
				!(this.m_balance == otherUser.m_balance) ||
				!(this.m_accountId == otherUser.m_accountId))
			{
				result = false;
			}
		}
				
		return result;
	}
	
	/**
	 * Formatted string of the Account instance
	 * @return a formatted string representation of the class
	 */
	@Override
	public String toString()
	{
		String fmt = String.format("ID: %d, %s %f, User: %s", this.m_accountId, this.m_accountName, this.m_balance, this.m_user.toString());
		return fmt;
	}
	
	private long m_accountId;
	private User m_user;
	private String m_accountName;
	private double m_balance;


}
