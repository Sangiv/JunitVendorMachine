package vendormachine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import vendormachine.users.Person;
import vendormachine.users.util.Wallet;
import vendormachine.vendors.DrinkVendingMachine;
import vendormachine.vendors.enums.BRANDS;
import vendormachine.vendors.item.Snack;

public class DrinkVendingMachineTEST {
	
	static DrinkVendingMachine drink;
	
	@Before
	public void init() {
		drink = new DrinkVendingMachine(6.55f, BRANDS.InFuse);
	}
	
	@Test
	public void constructorTest() {
		DrinkVendingMachine drinkC = new DrinkVendingMachine();
		assertEquals(drinkC.getBrandName().getClass(), BRANDS.class);
		assertEquals(0f, drinkC.getAvailableCredit(), 0.01f);
	}
	
	@Test
	public void getBrandNameTest() {
		assertEquals(drink.getBrandName(), BRANDS.InFuse);
	}
	
	@Test
	public void selectLegitDrinkTest() {
		Snack ans = drink.selectDrink(0);
		assertEquals(ans.name, "Water");
	}
	
	@Test
	public void selectBadDrinkTest() {
		Snack ans = drink.selectDrink(-1);
		assertNull(ans);
	}
	
	@Test
	public void selectExpDrinkTest() {
		DrinkVendingMachine drinkE = new DrinkVendingMachine();
		assertNull(drinkE.selectDrink(1));
	}
	
	@Test
	public void giveCreditTest() {
		Wallet wallet = new Wallet(20.0f);
		Person user = new Person("gio", wallet);
		
		assertEquals(13.45f, drink.giveCredit(user, 6.55f), 0.01f);
	}
	/** 
	 * Task 2:
	 * 	Objective:
	 * 		Test the Wallet class from:
	 * 		'vendormachine.vendors.DrinkVendingMachine'
	 * 
	 * 	Goal: 
	 * 		80% code/line coverage
	 * 		TDD: analyse code and add missing methods.
	 * */

}
