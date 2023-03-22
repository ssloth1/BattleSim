/**
 * Represents a type of Fighter, of the Elf sub-type.
 * @author James
 *
 */
public class Elf extends Fighter {
    
	/**
     * Constructor for the Elf class.
     * @param name - the name of the Elf
     * @param health - the starting health points of the Elf
     * @param weapon - the weapon that the Elf will use to attack.
     */
	public Elf(String name, int health, Weapon weapon) {
        super(name, health, weapon);
    }
    
	/**
	 * Overrides the attack method from the Fighter class for Elf specific implementation.
	 * Elfs  deal more damage with hammers and opponents who successfully dodge their attacks take half damage.
	 * @param opponent - the Fighter object that the Elf will attack.
	 */
    @Override
    public void attack(Fighter opponent) {
        if (Math.random() * 100 < getWeapon().getAccuracy()) { // Accuracy Check.
            int damage = getAttackDamage(opponent);
            if (Math.random() * 100 < getWeapon().getCritical()) { // Crit check.
                damage *= 2; // Double on crit.
                System.out.println("Critical hit!");
            }
            if (opponent.isDodging()) {
                damage /= 2; // Slight damage on dodge
                System.out.println(opponent.getName() + " successfully dodges some of the damage!");
            }
            System.out.println(getName() + " attacks " + opponent.getName() + " with a " + getWeapon().getClass().getSimpleName() + " for " + damage + " damage.");
            opponent.takeDamage(damage);
        } else {
            System.out.println(getName() + " misses the attack.");
        }
    }
    
    /**
     * Overrides the dodge method from the Fighter class. Elfs have a 55% chance to dodge an attack.
     * @param opponentAction - the action of the opponent fighter.
     */
    @Override
    public void dodge(int opponentAction) {
        if (opponentAction == 1 && Math.random() < 0.55) {
            System.out.println(getName() + " dodges the attack!");
            setDodging(true);
        } else {
            System.out.println(getName() + " failed to dodge!");
            setDodging(false);
     
        }
    }
    
    
    /**
     * Overrides the getAttackDamage method from Fighter class. The Elfs deals extra damage with Bows, and less with with Hammers.
     * @param opponent - the opponent fighter is to attack
     * @return the amount of damage the Elf fighter can deal.
     */
    @Override
	 public int getAttackDamage(Fighter opponent) {
    	double damage = getWeapon().getDamage();
        if (this instanceof Elf && getWeapon() instanceof Bow) {
            damage *= 1.2;
        }
        if (this instanceof Elf && getWeapon() instanceof Hammer) {
            damage *= 0.8;
  
        }
        return (int) damage;
    }
}