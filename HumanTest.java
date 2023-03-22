/**
 * HumanTest.java
 * Tests the Human Class
 * @author James Bebarski
 */

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Tests the Human Class.
 * @author James Bebarski
 *
 */
public class HumanTest {
	
	/**
	 * Tests the attack method of the Human class with a Sword weapon.
	 * The attack should reduce the opponent's health by the Sword's damage value.
	 */

	@Test
	public void testAttackWithSword() {
		Fighter human = new Human("Aragorn", 100, new Sword());
		Fighter opponent = new Elf("Legolas", 100, new Bow());
		human.attack(opponent);
		assertEquals(82, opponent.getHealth());
	}

	/**
	 * Tests the attack method of the Human class with a Bow weapon.
	 * The attack should reduce the opponent's health by the Bow's damage value.
	 */
	@Test
	public void testAttackWithBow() {
		Fighter human = new Human("Aragorn", 100, new Bow());
		Fighter opponent = new Elf("Legolas", 100, new Bow());
		human.attack(opponent);
		assertEquals(92, opponent.getHealth());
	}
	
	/**
	 * Tests the dodge method of the Human class with a successful dodge.
	 * The dodge method should set the isDodging boolean to true.
	 */
	@Test
	public void testDodgeSuccessful() {
		Fighter human = new Human("Aragorn", 100, new Sword());
		human.dodge(1);
		assertEquals(true, human.isDodging());
	}

	/**
	 * Tests the dodge method of the Human class with a failed dodge.
	 * The dodge method should set the isDodging boolean to false.
	 */
	@Test
	public void testDodgeFailed() {
		Fighter human = new Human("Aragorn", 100, new Sword());
		human.dodge(2);
		assertEquals(false, human.isDodging());
	}
	
	/**
	 * Tests the attack method of the Human class against a dodging opponent.
	 * If the opponent is dodging, the attack should not affect their health.
	 */
	@Test
	public void testAttackWithDodgingOpponent() {
		Fighter human = new Human("Aragorn", 100, new Sword());
		Fighter opponent = new Elf("Legolas", 100, new Bow());
		opponent.setDodging(true);
		human.attack(opponent);
		assertEquals(91, opponent.getHealth());
	}
	
	/**
	 * Tests the isAlive method of the Human class.
	 * A human should be alive if their health is greater than 0.
	 */
	@Test
	public void testIsAlive() {
	    Fighter human = new Human("Aragorn", 100, new Sword());
	    assertTrue(human.isAlive());
	    human.takeDamage(100);
	    assertFalse(human.isAlive());
	}
	
	/**
	 * Tests the setHealth method of the Human class.
	 * The setHealth method should change the fighter's health to the specified value.
	 */
	@Test
	public void testSetHealth() {
	    Human human = new Human("Aragorn", 100, new Sword());
	    human.setHealth(50);
	    assertEquals(50, human.getHealth());
	}
	
	/**
	 * Tests the setWeapon method of the Human class.
	 * The setWeapon method should change the fighter's weapon to the specified weapon.
	 */
	@Test
	public void testSetWeapon() {
	    Human human = new Human("Aragorn", 100, new Sword());
	    Weapon newWeapon = new Bow();
	    human.setWeapon(newWeapon);
	    assertEquals(newWeapon, human.getWeapon());
	}
}