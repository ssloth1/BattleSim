/**
 * The Hammer class represents a weapon type of Hammer that implements the Weapon interface.
 * It provides methods to get the damage, accuracy, and critical value of the Hammer.
 * @author James Bebarski
 */
public class Hammer implements Weapon {
    
	/**
	 * Returns the default damage done by a Hammer.
	 * @return an integer value representing the damage of a Hammer.
	 */
	@Override
    public int getDamage() {
        return 20;
    }

	/**
	 * Returns the default accuracy done by a Hammer.
	 * @return an integer value representing the accuracy of a Hammer.
	 */
    @Override
    public int getAccuracy() {
        return 90;
    }

	/**
	 * Returns the default critical value of a Hammer.
	 * @return an integer value representing the critical value of a Hammer.
	 */
    @Override
    public int getCritical() {
        return 10;
    }
}