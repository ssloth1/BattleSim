/**
 * Represents a type of Fighter, of the Dwarf sub-type.
 * @author James Bebarski
 *
 */
public class Dwarf extends Fighter {
    
	/**
     * Constructor for the Dwarf class.
     * @param name - the name of the Dwarf
     * @param health - the starting health points of the Dwarf
     * @param weapon - the weapon that the Dwarf will use to attack.
     */
	public Dwarf(String name, int health, Weapon weapon) {
        super(name, health, weapon);
    }

	
	/**
	 * Overrides the attack method from the Fighter class for Dwarf specific implementation.
	 * Dwarfs deal more damage with hammers and opponents who successfully dodge their attacks take half damage.
	 * I gave dwarf a special implementation of attack where they get an extra +5 damage on top of their doubled crit damage.
	 * @param opponent - the Fighter object that the Dwarf will attack.
	 */
    @Override
    public void attack(Fighter opponent) {
        if (Math.random() * 100 < getWeapon().getAccuracy()) { // Accuracy check
            int damage = getAttackDamage(opponent);
            if (Math.random() * 100 < getWeapon().getCritical()) { // Crit check
                damage = (damage * 2) + 5; // Double attack + 5 extra because dwarf.
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
     * Overrides the dodge method from the Fighter class. Dwarfs have a 50% chance to dodge an attack.
     * @param opponentAction - the action of the opponent fighter.
     */
    @Override
    public void dodge(int opponentAction) {
        if (opponentAction == 1 && Math.random() < 0.5) {
            System.out.println(getName() + " dodges the attack!");
            setDodging(true);
        } else {
            System.out.println(getName() + " failed to dodge!");
            setDodging(false);
     
        }
    }
    
    /**
     * Overrides the getAttackDamage method from Fighter class. The Dwarf deals extra damage with hammers, and less with with swords.
     * @param opponent - the opponent fighter is to attack
     * @return the amount of damage the Dwarf fighter can deal.
     */
    @Override
	 public int getAttackDamage(Fighter opponent) {
        double damage = getWeapon().getDamage();
        if (this instanceof Dwarf && getWeapon() instanceof Hammer) {
            damage *= 1.2;
        }
        if (this instanceof Dwarf && getWeapon() instanceof Sword) {
            damage *= 0.8;
  
        }
        return (int) damage;
    }
}
