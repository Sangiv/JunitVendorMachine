package vendormachine;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import vendormachine.users.Person;
import vendormachine.users.util.Wallet;
import vendormachine.vendors.DrinkVendingMachine;
import vendormachine.vendors.enums.BRANDS;

public class DrinkVendingMachineIntegrationTest {		
	
	@Mock
	private static Wallet wallet;
	
	@InjectMocks
	private static Person person;
	
//	@Test
//	public void giveCreditTest() {
//		DrinkVendingMachine drink = new DrinkVendingMachine(5.00f, BRANDS.InFuse);
//		
//		Wallet wallet = new Wallet(20.0f);
//		Person user = new Person("gio", wallet);
//		
//		assertEquals(11.55f, drink.giveCredit(user, 6.55f), 0.01f);
//	}
	
	
	@Test
	public void giveCreditINTTest() {
		
		person = mock(Person.class);
		when(person.getCredit(3.0f)).thenReturn(3.0f);
		
		DrinkVendingMachine drink = new DrinkVendingMachine(1.0f, BRANDS.InFuse);
		
		assertEquals(4.0f, drink.giveCredit(person, 3.0f), 0.01f);
	}
}
