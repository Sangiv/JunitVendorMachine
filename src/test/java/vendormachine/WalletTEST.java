package vendormachine;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import vendormachine.users.util.Wallet;

public class WalletTEST {
	
	static Wallet wallet;
	static double delta = 0.01;
	
	@Before
	public void init() {
		wallet = new Wallet("Gucci", 300.95f);
	}
	@Test
	public void emptyconstructorTest() {
		Wallet nonWallet = new Wallet();
		assertEquals("Generic", nonWallet.getBrand());
		assertEquals(0.5f, nonWallet.getAllCredit(), delta);
	}
	@Test
	public void constructorTest() {
		Wallet startWallet = new Wallet(200.0f);
		assertEquals(200.0f, startWallet.getAllCredit(), delta);
		assertEquals("Generic", startWallet.getBrand());
	}
	
	@Test
	public void addCreditTest() {
		wallet.addCredit(50f);		
		assertEquals(350.95, wallet.getAllCredit(), delta);
	}
		
	@Test
	public void getCreditOverTest() {
		float creditgot = wallet.getCredit(400f);		
		assertEquals(0f, creditgot, delta);
	}
	
	@Test
	public void getCreditUnderTest() {
		float creditgot = wallet.getCredit(300f);		
		assertEquals(300.0f, creditgot, delta);
	}
	
	@Test
	public void getBrandTest() {
		assertEquals("Gucci", wallet.getBrand());
	}
	
	@Test
	public void setCreditTest() {
		wallet.setCredit(400.0f);
		assertEquals(400.0f, wallet.getAllCredit(), delta);
	}

	@Test
	public void setBrandTest() {
		wallet.setBrand("Armani");
		assertEquals("Armani", wallet.getBrand());
	}
	
	/** 
	 * Task 1:
	 * 	Objective:
	 * 		Test the Wallet class from:
	 * 		'vendormachine.users.util.Wallet'
	 * 
	 * 		Goal: 80% code/line coverage
	 * */
	
	// Hint: 
	// Others Tests for other classes that use Wallet may impact code coverage
	// Avoid relying on these tests, one test for one class; keep "Single Responsibility" in mind.
	
}
