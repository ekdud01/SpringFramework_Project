package mylab.user.di.annot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-user-di.xml")
public class UserServiceTest {
	
	@Autowired
	UserService userService;
	
	@Test
	void testUserService() {
		// 해당 객체가 Null인지 아닌지 검증.
		assertNotNull(userService);
		// 해당 객체가 Null인지 아닌지 검증.
		assertNotNull(userService.getUserRepository());
		// 값이 "MySQL"인지 검증.
		assertEquals("MySQL", userService.getUserRepository().getDbType());
		// 해당 객체가 Null인지 아닌지 검증.
		assertNotNull(userService.getSecurityService());
		
		// userService.registerUser() 메서드가 True/False인지 검증.
		// True의 경우, Password가 있어야 함.
		assertTrue(userService.registerUser("ID", "NAME", "PASSWORD"));
		// False의 경우, Password가 없어야 함.
		assertFalse(userService.registerUser("ID2", "NAME2", ""));
		//assertTrue(userService.getSecurityService().authorize("ID", "RESOURCE"));
	}

}
