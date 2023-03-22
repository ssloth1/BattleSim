/**
 * An interface that is used by various weapon classes that is used to return default statistics for a weapon class.
 * @author James Bebarski
 */
public interface Weapon {
    /**
     * Gets the damage value of the weapon.
     * @return the damage value of a weapon.
     */
	int getDamage();
	
	/**
	 * Gets the accuracy value of the weapon.
	 * @return the accuracy value of the weapon.
	 */
    int getAccuracy();
   
    /**
     * Gets the critical value of the weapon.
     * @return the critical value of a weapon.
     */
    int getCritical();
}
