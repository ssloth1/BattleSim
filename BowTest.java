/**
 * BowTest.java
 * Tests the BowClass
 * @author James Bebarski
 */

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests the Bow Class.
 * @author James
 *
 */
public class BowTest {
	
	/**
	 * Tests the getDamage() method of the Bow class.
	 * It checks whether the returned default damage value of a Bow is 10.
	 */
    @Test
    public void testGetDamage() {
        Bow bow = new Bow();
        assertEquals(10, bow.getDamage());
    }
    
    /**
     * Tests the getAccuracy() method of the Bow class.
     * It checks whether the returned default accuracy value of a Bow is 70.
     */
    @Test
    public void testGetAccuracy() {
        Bow bow = new Bow();
        assertEquals(70, bow.getAccuracy());
    }
    
    /**
     * Tests the getCritical() method of the Bow class.
     * It checks whether the returned default critical value of a Bow is 30.
     */
    @Test
    public void testGetCritical() {
        Bow bow = new Bow();
        assertEquals(30, bow.getCritical());
    }
}