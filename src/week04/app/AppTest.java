package week04.app;

import static org.junit.Assert.*;

import org.junit.Test;
import test.AbstractJUnitBase;

public class AppTest extends AbstractJUnitBase
{	
	@Test
	public void testUserClassEquals()
	{
		boolean equalTest = true;
		
		// simple user creation
		User user = new User();						
		
		User user2 = new User();						
		
		// expect to be same
		if( !user.equals(user2))
		{
			equalTest = false;
		}
		
		user2.setFirstName("Jim");
		user2.setLastName("Bo");
		user2.setUserId(1);					

		// expect to be different
		if( user.equals(user2))
		{
			equalTest = false;
		}
		
		User user3 = new User(user2.getUserId(), user2.getFirstName(), user2.getLastName());		
		
		// expect to be same
		if( !user3.equals(user2))
		{
			equalTest = false;
		}
		
		if(!equalTest)
		{
			fail("User.equals test failed");
		}
	}

	@Test
	public void testAccountClassEquals()
	{
		boolean equalTest = true;
		
		// simple user creation
		User user = new User("Account Test", "Account Test");						
		
		Account acc1 = new Account();						
		Account acc2 = new Account();
		
		// defaults expect to be same
		if( !acc1.equals(acc2))
		{
			equalTest = false;
			trace("Failed default test: expected default to be same");
			trace("acc1: " + acc1.toString());
			trace("acc2: " + acc2.toString());
		}
		
		acc1.setUser(user);		

		// expect to be different
		if( acc1.equals(acc2))
		{
			equalTest = false;
			trace("Failed update test: expected to be different after update");
			trace("acc1: " + acc1.toString());
			trace("acc2: " + acc2.toString());
		}
		
		Account acc3 = new Account(acc1.getAccountId(), acc1.getUser(), acc1.getName(), acc1.getBalance());		
		
		// expect to be same
		if( !acc3.equals(acc1))
		{
			equalTest = false;
			trace("Failed copy constructor test: expected to be same after creating copy");
			trace("acc1: " + acc1.toString());
			trace("acc3: " + acc2.toString());
		}
		
		if(!equalTest)
		{
			trace("Account.equals test failed");
			fail("Account.equals test failed");
		}
		
	}
}
