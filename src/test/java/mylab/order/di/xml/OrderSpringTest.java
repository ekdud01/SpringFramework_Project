package mylab.order.di.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-order-di.xml")
public class OrderSpringTest {
	
	@Autowired
	ShoppingCart shoppingCart;
	
	@Autowired
	OrderService orderService;
	
	@Test
	void shoppingCartTest() {
		// shoppingCart 객체가 Null인지 아닌지 검증.
		assertNotNull(shoppingCart);
		System.out.println(shoppingCart);
		// 크기가 2인지 검증.
		assertEquals(2, shoppingCart.getProducts().size());
		// 값이 "노트북"인지 검증.
		assertEquals("노트북", shoppingCart.getProducts().get(0).getName());
		// 값이 "스마트폰"인지 검증.
		assertEquals("스마트폰", shoppingCart.getProducts().get(1).getName());
	}
	
	@Test
	void orderServiceTest() {
		// 해당 객체가 Null인지 아닌지 검증.
		assertNotNull(orderService);
		assertNotNull(orderService.getShoppingCart());
		System.out.println(orderService);
		// 해당 메서드의 호출 결과값을 검증.
		assertEquals(2300000, orderService.calculateOrderTotal());
		System.out.println(orderService.calculateOrderTotal());
	}
	
}
