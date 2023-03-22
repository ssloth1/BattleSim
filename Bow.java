
/**
 * The Bow class represents a weapon type of Bow that implements the Weapon interface.
 * It provides methods to get the damage, accuracy, and critical value of the bow.
 * @author James Bebarski
 */
public class Bow implements Weapon {
    
	/**
	 * Returns the default damage done by a Bow.
	 * @return an integer value representing the damage of a Bow.
	 */
	@Override
    public int getDamage() {
        return 10;
    }
	
	/**
	 * Returns the default accuracy done by a Bow.
	 * @return an integer value representing the accuracy of a Bow.
	 */
    @Override
    public int getAccuracy() {
        return 70;
    }
    
	/**
	 * Returns the default critical value of a Bow.
	 * @return an integer value representing the critical value of a Bow.
	 */
    @Override
    public int getCritical() {
        return 30;
    }
}