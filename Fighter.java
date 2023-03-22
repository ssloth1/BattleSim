/**
 * The abstract Fighter class represents a player or an opponent in an Arena Game.
 * It contains attributes such as name, health, and weapon and m various methods, 
 * like dodge, 
 * @author James
 */
public abstract class Fighter {
    
	/** The name of the fighter*/
	private String name;
	/** The health points of the fighter*/
    private int health;
    /** The weapon of the fighter*/
    private Weapon weapon;
    /** Whether the Fighter is dodging */
    private boolean dodging;

    /**
     * Creates a new fighter with the given name, health, and weapon.
     * @param name - the name of the fighter.
     * @param health - the starting health of the fighter.
     * @param weapon - the weapon the fighter is using.
     */
    public Fighter(String name, int health, Weapon weapon) {
        this.name = name;
        this.health = health;
        this.weapon = weapon;
        this.dodging = false;
    }

    /**
     * Attacks the given opponent.
     * @param opponent - the opponent to attack.
     */
    public abstract void attack(Fighter opponent);
    
    /**
     * Attempts to dodge an incoming attack based on the opponent's action.
     * @param opponentAction - the action of the opponent (1 for attack, 2 for dodge)
     */
    public abstract void dodge(int opponentAction);
    
    /**
     * Calculates and returns the damage this fighter's attack would do to a given opponent
     * @param opponent - the opponent to attack.
     * @return The damage this fighter's attack would do.
     */
	public abstract int getAttackDamage(Fighter opponent);
    
	/**
	 * Returns the name of the fighter.
	 * @return the fighter's name.
	 */
    public String getName() {
        return name;
    }
    
    /**
     * Returns the current health of the fighter.
     * @return the fighter's current health.
     */
    public int getHealth() {
        return health;
    }
    
    /**
     * Sets the current health of the fighter.
     * @param health - the new health value to set
     */
    public void setHealth(int health) {
        this.health = health;
    }
    
    /**
     * Returns the weapon the fighter is using.
     * @return the weapon the fighter is using.
     */
    public Weapon getWeapon() {
        return weapon;
    }
    
    /**
     * Sets the weapon the fighter is using.
     * @param weapon the weapon to set.
     */
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
    
    /**
     * Returns whether the fighter is dodging attacks.
     * @return whether the fighter is dodging.
     */
    public boolean isDodging() {
        return this.dodging;
    }
    
    /**
     * Sets whether the fighter is dodging attacks.
     * @param dodging - whether the fighter is currently dodging.
     */
    public void setDodging(boolean dodging) {
        this.dodging = dodging;
    }
    
    /**
     * Returns whether the current fighter is still alive (health above 0.
     * @return Whether the fighter is alive.
     */
    public boolean isAlive() {
        return health > 0;
    }
    
    /**
     * Decreases the fighter's health by the given damage amount. If the health drops to 0 or below, the fighter is defeated.
     * @param damage - the amount of damage to take.
     */
    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
        if (health < 0) {
            System.out.println(name + " has been defeated!");
            isAlive();
        }
    }
}
