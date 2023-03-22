/**
 * SwordTest.java
 * Tests the Sword Class
 * @author James Bebarski
 */

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the Sword Class.
 * @author James Bebarski
 *
 */
public class SwordTest {
	
	/**
	 * Test the getDamage() method of the Sword class. 
	 * Assert that the damage value returned is equal to 15.
	 */
	@Test
	public void testGetDamage() {
		Weapon sword = new Sword();
		assertEquals(15, sword.getDamage());
	}

	/**
	 * Test the getAccuracy() method of the Sword class. 
	 * Assert that the accuracy value returned is equal to 80.
	 */
	@Test
	public void testGetAccuracy() {
		Weapon sword = new Sword();
		assertEquals(80, sword.getAccuracy());
	}

	/**
	 * Test the getCritical() method of the Sword class. 
	 * Assert that the critical value returned is equal to 20.
	 */
	@Test
	public void testGetCritical() {
		Weapon sword = new Sword();
		assertEquals(20, sword.getCritical());
	}
}