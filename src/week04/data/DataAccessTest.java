package week04.data;


import static org.junit.Assert.*;

import org.junit.Test;
import test.AbstractJUnitBase;

import java.sql.Connection;
import java.util.List;

import week04.app.Account;
import week04.app.User;

public class DataAccessTest extends AbstractJUnitBase
{
	@Test
	public void testDBAccess()
	{
		try
		{
			DataAccess da = DataAccess.getInstance("root","root");
			da.connect();

			Connection conn = da.getConnection();
			conn.close();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			fail(ex.getMessage());			
		}
	}
	
	@Test
	public void testAddUser()
	{
		try
		{
			DataAccess da = DataAccess.getInstance("root","root");
			da.connect();

			Connection conn = da.getConnection();

			trace("  -- connected to database: " + conn.toString());
						
			User user = new User("FirstTest", "LastTest");
			da.saveUser(user);
			
			long savedUserId = user.getUserId();
			
			trace("  -- User saved: " + user.toString());
			
			List<User> userList = da.getUsers();

			if(userList.size() > 0)
			{
				String msg = String.format("  -- successful save: Count=%d",
						userList.size());
				trace(msg);
				dumpUserList(userList);
			}
			else
			{
				fail(" failed to save user");
			}
			
			// delete the user
			trace("Deleting user");
			da.deleteUserById(savedUserId);
			userList = da.getUsers();
			dumpUserList(userList);
		}
		catch(AtmDataException ex)
		{
			trace(" -- error: " + ex.getMessage());
			fail(ex.getMessage());
		}
	}
	
	@Test
	public void testAccount()
	{
		try
		{
			DataAccess da = DataAccess.getInstance("root","root");
			da.connect();

			Connection conn = da.getConnection();

			trace("  -- connected to database: " + conn.toString());
						
			User user = new User("FirstTest", "LastTest");
			da.saveUser(user);

			Account newAccount = new Account(user, "Test Account");

			da.saveAccount(newAccount);

			List<Account> accounts = da.getAllAccounts();
			if(accounts.size() > 0)
			{
				String msg = String.format("  -- successful save: Count=%d",
						accounts.size());
				trace(msg);
				dumpAccountList(accounts);
			}
			else
			{
				fail(" failed to save account");
			}
		}
		catch(AtmDataException ex)
		{
			trace(" -- error: " + ex.getMessage());
			fail(ex.getMessage());
		}		
	}

	
	private void dumpUserList(List<User> list)
	{
		for(User user : list)
		{
			trace(user.toString());
		}
	}
	
	private void dumpAccountList(List<Account> list)
	{
		for(Account account : list)
		{
			trace(account.toString());
		}
	}
}
