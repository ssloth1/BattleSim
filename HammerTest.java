/**
 * BowTest.java
 * Tests the Bow class
 * @author James Bebarski
 */

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the Hammer Class.
 * @author James Bebarski
 */
public class HammerTest {

	/**
	 * Tests the getDamage() method of the Hammer class to ensure that it returns the default damage of a Hammer.
	 */
    @Test
    public void testGetDamage() {
        Hammer hammer = new Hammer();
        assertEquals(20, hammer.getDamage());
    }
    
    /**
     * Tests the getAccuracy() method of the Hammer class to ensure that it returns the default accuracy of a Hammer.
     */
    @Test
    public void testGetAccuracy() {
        Hammer hammer = new Hammer();
        assertEquals(90, hammer.getAccuracy());
    }
    
    /**
     * Tests the getCritical() method of the Hammer class to ensure that it returns the default critical value of a Hammer.
     */
    @Test
    public void testGetCritical() {
        Hammer hammer = new Hammer();
        assertEquals(10, hammer.getCritical());
    }
}
