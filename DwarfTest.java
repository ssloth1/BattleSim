/**
 * DwarfTest.java
 */

import static org.junit.Assert.*;

import org.junit.Test;

/**
 *  Tests the Dwarf class
 * @author James Bebarski
 *
 */
public class DwarfTest {
	
	/**
	 * Tests the attack method with a sword against an Elf.
	 * Dwarf deals more damage with hammers and opponents who successfully dodge their attacks take half damage.
	 */
	@Test
	public void testAttackWithSword() {
		Fighter dwarf = new Dwarf("Gimlee", 100, new Sword());
		Fighter opponent = new Elf("Legolas", 100, new Bow());
		dwarf.attack(opponent);
		assertEquals(88, opponent.getHealth());
	}
	
	/**
	 * Tests the attack method with a hammer against an Elf.
	 * Dwarf deals more damage with hammers and opponents who successfully dodge their attacks take half damage.
	 */
	@Test
	public void testAttackWithHammer() {
		Fighter dwarf = new Dwarf("Gimlee", 100, new Hammer());
		Fighter opponent = new Elf("Legolas", 100, new Bow());
		dwarf.attack(opponent);
		assertEquals(76, opponent.getHealth());
	}
	
	/**
	 * Tests the dodge method with a successful dodge.
	 */
	@Test
	public void testDodgeSuccessful() {
		Fighter dwarf = new Dwarf("Gimlee", 100, new Sword());
		dwarf.dodge(1);
		assertEquals(true, dwarf.isDodging());
	}
	
	/**
	 * Tests the dodge method with a failed dodge.
	 */
	@Test
	public void testDodgeFailed() {
		Fighter dwarf = new Dwarf("Gimlee", 100, new Sword());
		dwarf.dodge(2);
		assertEquals(false, dwarf.isDodging());
	}
	
	/**
	 * Tests the attack method with an opponent who successfully dodges.
	 */
	@Test
	public void testAttackWithDodgingOpponent() {
		Fighter dwarf = new Dwarf("Gimlee", 100, new Sword());
		Fighter opponent = new Elf("Legolas", 100, new Bow());
		opponent.setDodging(true);
		dwarf.attack(opponent);
		assertEquals(100, opponent.getHealth());
	}
	
	/**
	 * Tests the isAlive method after the dwarf has taken damage.
	 */
	@Test
	public void testIsAlive() {
	    Fighter dwarf = new Dwarf("Gimlee", 100, new Sword());
	    assertTrue(dwarf.isAlive());
	    dwarf.takeDamage(100);
	    assertFalse(dwarf.isAlive());
	}
	
	/**
	 * Tests the setHealth method to ensure that the Dwarf's health is updated correctly.
	 */
	@Test
	public void testSetHealth() {
	    Dwarf dwarf = new Dwarf("Gimlee", 100, new Sword());
	    dwarf.setHealth(50);
	    assertEquals(50, dwarf.getHealth());
	}
	
	/**
	 * Tests the setWeapon method to ensure that the Dwarf's weapon is updated correctly.
	 */
	@Test
	public void testSetWeapon() {
	    Dwarf dwarf = new Dwarf("Gimlee", 100, new Sword());
	    Weapon newWeapon = new Bow();
	    dwarf.setWeapon(newWeapon);
	    assertEquals(newWeapon, dwarf.getWeapon());
	}

}
