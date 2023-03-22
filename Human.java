/**
 * Represents a type of Fighter, of the Human sub-type.
 * @author James Bebarski
 *
 */
public class Human extends Fighter {
    
	/**
     * Constructor for the Human class.
     * @param name - the name of the Human
     * @param health - the starting health points of the Human
     * @param weapon - the weapon that the Human will use to attack.
     */
	public Human(String name, int health, Weapon weapon) {
        super(name, health, weapon);
    }

	/**
	 * Overrides the attack method from the Fighter class for Human specific implementation.
	 * Human deal more damage with swords and opponents who successfully dodge their attacks take half damage.
	 * Humans get a + 2 
	 * @param opponent - the Fighter object that the Human will attack.
	 */
    @Override
    public void attack(Fighter opponent) {
        if (Math.random() * 100 < getWeapon().getAccuracy()) { // Accuracy Check
            int damage = getAttackDamage(opponent);
            if (Math.random() * 100 < getWeapon().getCritical()) { // Crit check
                damage = (damage * 2) + 2; // Humans get + 2 extra base points on crits
                System.out.println("Critical hit!");
            }
            if (opponent.isDodging()) {
                damage /= 2; // Some damage on dodge
                System.out.println(opponent.getName() + " successfully dodges some of the damage!");
            }
            System.out.println(getName() + " attacks " + opponent.getName() + " with a " + getWeapon().getClass().getSimpleName() + " for " + damage + " damage.");
            opponent.takeDamage(damage);
        } else {
            System.out.println(getName() + " misses the attack.");
        }
    }
    
    /**
     * Overrides the dodge method from the Fighter class. Humans have a 52.5% chance to dodge an attack.
     * @param opponentAction - the action of the opponent fighter.
     */
    @Override
    public void dodge(int opponentAction) {
        if (opponentAction == 1 && Math.random() < 0.525) {
            System.out.println(getName() + " dodges the attack!");
            setDodging(true);
        } else {
            System.out.println(getName() + " failed to dodge!");
            setDodging(false);
     
        }
    }
    
    
    /**
     * Overrides the getAttackDamage method from Fighter class. The Humans deals extra damage with swords, and less with with bows.
     * @param opponent - the opponent fighter is to attack
     * @return the amount of damage the Dwarf fighter can deal.
     */
    @Override
	 public int getAttackDamage(Fighter opponent) {
        double damage = getWeapon().getDamage();
        if (this instanceof Human && getWeapon() instanceof Sword) {
            damage *= 1.2;
        }
        if (this instanceof Human && getWeapon() instanceof Bow) {
            damage *= 0.8;
  
        }
        return (int)damage;
    }
}