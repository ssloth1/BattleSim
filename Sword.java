/**
 * The Sword class represents a weapon type of Sword that implements the Weapon interface.
 * It provides methods to get the damage, accuracy, and critical value of the Sword.
 * @author James
 *
 */
public class Sword implements Weapon {
    
	/**
	 * Returns the default damage done by a Sword.
	 * @return an integer value representing the damage of a Sword.
	 */
	@Override
    public int getDamage() {
        return 15;
    }

	/**
	 * Returns the default accuracy done by a Sword.
	 * @return an integer value representing the accuracy of a Sword.
	 */
    @Override
    public int getAccuracy() {
        return 80;
    }
    
	/**
	 * Returns the default critical value of a Sword.
	 * @return an integer value representing the critical value of a Sword.
	 */
    @Override
    public int getCritical() {
        return 20;
    }
}
