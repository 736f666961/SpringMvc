package ma.youcode.api.dao.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ma.youcode.api.service.UserServiceImpl;

public class UserDaoImplTest {
	private UserServiceImpl userServiceImpl = new UserServiceImpl();

	@Test
	public void testLogin() {
		String email = "  ";
		String password = "  ";

		if (userServiceImpl != null) {
			
			boolean isVlidated = userServiceImpl.validateLogin(email, password);
			
			System.out.println("Validated: " + isVlidated);
			
			assertEquals(false, isVlidated);
			
		} else {
			System.out.println("Null");
		}
	}

}
