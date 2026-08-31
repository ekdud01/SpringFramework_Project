package mylab.notification.di.annot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = NotificationConfig.class)
public class NotificationConfigTest {
	@Autowired
	private NotificationManager notificationManager;
	
	@Autowired
	private EmailNotificationService emailService;
	
	@Autowired
	private SmsNotificationService smsService;
	
	@Test
	void testNotificationManager() {
		// 해당 객체가 Null인지 아닌지 검증.
		assertNotNull(notificationManager);
		
		// 해당 객체가 Null인지 아닌지 검증.
		assertNotNull(notificationManager.getEmailService());
		// 값이 "smtp.gmail.com"인지 검증.
		assertEquals("smtp.gmail.com", emailService.getSmtpServer());
		// 값이 "587"인지 검증.
		assertEquals(587, emailService.getPort());
		
		// 해당 객체가 Null인지 아닌지 검증.
		assertNotNull(notificationManager.getSmsService());
		// 값이 "SKT"인지 검증.
		assertEquals("SKT", smsService.getProvider());
		
		// NotificationManager의 메서드 실행 
		notificationManager.sendNotificationByEmail("테스트 이메일");
		notificationManager.sendNotificationBySms("테스트 SMS");
	}
}
