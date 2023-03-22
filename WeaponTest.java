/**
 * Weapon Test.java
 * Tests the Weapon Interface
 * @author James Bebarski
 */


import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the Weapons
 * @author James
 *
 */
public class WeaponTest {
	
	/**
	 * Test the stat attributes of the Sword class.
	 */
	@Test
	public void testSwordStats() {
		Weapon sword = new Sword();
		assertEquals(15, sword.getDamage());
		assertEquals(80, sword.getAccuracy());
		assertEquals(20, sword.getCritical());
	}

	/**
	 * Test the stat attributes of the Bow class.
	 */
	@Test
	public void testBowStats() {
		Weapon bow = new Bow();
		assertEquals(10, bow.getDamage());
		assertEquals(70, bow.getAccuracy());
		assertEquals(30, bow.getCritical());
	}

	/**
	 * Test the stat attributes of the Hammer class.
	 */
	@Test
	public void testHammerStats() {
		Weapon hammer = new Hammer();
		assertEquals(20, hammer.getDamage());
		assertEquals(90, hammer.getAccuracy());
		assertEquals(10, hammer.getCritical());
	}
}
