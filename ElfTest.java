/**
 * ElfTest.java
 * Tests the Elf class
 * @author James Bebarski
 */

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Tests the Elf Class.
 * @author James Bebarski
 *
 */
public class ElfTest {
	
	/**
	 * Tests the attack method of the Elf class with a Bow weapon against a Dwarf opponent.
	 * Verifies that the opponent takes the expected amount of damage.
	 */
	@Test
	public void testAttackWithBow() {
		Fighter elf = new Elf("Legolas", 100, new Bow());
		Fighter opponent = new Dwarf("Gimlee", 100, new Sword());
		elf.attack(opponent);
		assertEquals(88, opponent.getHealth());
	}
	
	/**
	 * Tests the attack method of the Elf class with a Hammer weapon against a Dwarf opponent.
	 * Verifies that the opponent takes the expected amount of damage.
	 */
	@Test
	public void testAttackWithHammer() {
		Fighter elf = new Elf("Legolas", 100, new Hammer());
		Fighter opponent = new Dwarf("Gimlee", 100, new Sword());
		elf.attack(opponent);
		assertEquals(84, opponent.getHealth());
	}
	
	/**
	 * Tests the dodge method of the Elf class with a successful dodge action.
	 * Verifies that the isDodging flag is set to true.
	 */
	@Test
	public void testDodgeSuccessful() {
		Fighter elf = new Elf("Legolas", 100, new Bow());
		elf.dodge(1);
		assertEquals(true, elf.isDodging());
	}
	
	/**
	 * Tests the dodge method of the Elf class with a failed dodge action.
	 * Verifies that the isDodging flag is set to false.
	 */
	@Test
	public void testDodgeFailed() {
		Fighter elf = new Elf("Legolas", 100, new Bow());
		elf.dodge(2);
		assertEquals(false, elf.isDodging());
	}
	
	/**
	 * Tests the attack method of the Elf class against a dodging opponent.
	 * Verifies that the opponent takes the expected amount of damage.
	 */
	@Test
	public void testAttackWithDodgingOpponent() {
		Fighter elf = new Elf("Legolas", 100, new Bow());
		Fighter opponent = new Dwarf("Gimlee", 100, new Sword());
		opponent.setDodging(true);
		elf.attack(opponent);
		assertEquals(94, opponent.getHealth());
	}
	
	/**
	 * Tests the isAlive method of the Elf class.
	 * Verifies that a living Elf fighter returns true, and a dead Elf fighter returns false.
	 */
	@Test
	public void testIsAlive() {
	    Fighter elf = new Elf("Legolas", 100, new Sword());
	    assertTrue(elf.isAlive());
	    elf.takeDamage(100);
	    assertFalse(elf.isAlive());
	}
	
	/**
	 * Tests the setHealth method of the Elf class.
	 * Verifies that the health of the Elf fighter is set to the expected value.
	 */
	@Test
	public void testSetHealth() {
	    Elf elf = new Elf("Legolas", 100, new Sword());
	    elf.setHealth(50);
	    assertEquals(50, elf.getHealth());
	}
	
	/**
	 * Tests the setWeapon method of the Elf class.
	 * Verifies that the weapon of the Elf fighter is set to the expected weapon.
	 */
	@Test
	public void testSetWeapon() {
	    Elf elf = new Elf("Legolas", 100, new Sword());
	    Weapon newWeapon = new Bow();
	    elf.setWeapon(newWeapon);
	    assertEquals(newWeapon, elf.getWeapon());
	}

}
