import java.util.Scanner;

/**
 * BattleSim simulates a fictional battle between a player and an opponent in an arena.
 * The player can choose to play as a character between three playable races (Human, Dwarf, Elf), they may also select a weapon of choice (Sword, Hammer, or Bow). 
 * You may choose between Gimlee (Dwarf with a Hammer), Aragorn (Human with a sword), Leogolas (Elf with a bow), or a completely random opponent with a random weapon.
 * 
 * GAME TIPS:
 * 
 * Bonus Damage:
 * Hammers when used by a Dwarf increase damage by 20%.
 * Bows when used by a Elf increase damage by 20%.
 * Swords when used by a human increase damage by 20%.
 * 
 * Reduced Damage:
 * Hammers when used by an elf reduce damage out by 20%.
 * Bows when used by a human reduce damage out by 20%.
 * Swords when used by a dwarf reduce damage out by 20%.
 * 
 * Humans get a +2 Base Attack Bonus on Top of critical, and 2.5 percent bonus towards chance of dodge.
 * Elves get a 5 percent bonus towards chance of dodge.
 * Dwarfs get a +5 Base Attack Bonus on top of critical.
 * 
 * Playing with a random opponent can sometimes provide a fun challenge!
 * 
 * @author James Bebarski
 * CS 5004: Object Oriented Design Practical 
 * 
 */
public class BattleSim {
	/**
	 * Main Driver for BattleSim
	 * @param args main
	 */
	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);

	    // Prompts user to create their character.
	    Fighter player = createFighter(scanner);

	    // Prompt the player to choose their opponent
	    System.out.println("Choose your opponent:");
	    System.out.println("1. Legolas");
	    System.out.println("2. Aragorn");
	    System.out.println("3. Gimlee");
	    System.out.println("4. Random");
	    int opponentChoice = scanner.nextInt();
	    scanner.nextLine();

	    // Create a null opponent. Depending on which, opponent the player selects this gets reassigned. 
	    Fighter opponent = null;
	    switch (opponentChoice) {
	        case 1:
	            opponent = new Elf("Legolas", 100, new Bow()); // Option 1, fight Legolas.
	            break;
	        case 2:
	            opponent = new Human("Aragorn", 100, new Sword()); // Option 2, fight Aragorn.
	            break;
	        case 3:
	            opponent = new Dwarf("Gimlee", 100, new Hammer()); // Option 3, fight Gimlee.
	            break;
	        case 4:
	            opponent = createRandomOpponent(); // Random opponent is assigned to opponent.
	            break;
	            
	        default: // Defaults to creating Legolas if there was an invalid entry, essentially he is the default enemy.
	            System.out.println("Invalid opponent choice. Defaulting to Legolas.");
	            opponent = new Elf("Legolas", 100, new Bow());
	            break;
	    }

	    // Print out the player and opponent's details
	    System.out.println("Welcome to the Arena " + player.getName() + "\n");
	    System.out.println("Opponent:");
	    System.out.println("Name: " + opponent.getName());
	    System.out.println("Race: " + opponent.getClass().getSimpleName());
	    System.out.println("Weapon: " + opponent.getWeapon().getClass().getSimpleName());
	    System.out.println("\n");

	    // Start the game loop
	    boolean gameOver = false;
	    while (!gameOver) {
	        // Player's turn
	        System.out.println("Your turn. Choose your action:");
	        System.out.println("1. Attack");
	        System.out.println("2. Dodge");
	        int playerAction = scanner.nextInt();
	        scanner.nextLine();

	        // Opponent's turn
	        int opponentAction;
	        if (playerAction == 2) {
	            // If player chooses to dodge, opponent has a higher chance of attacking
	            opponentAction = (Math.random() < 0.8) ? 1 : 2;
	        } else {
	            opponentAction = (Math.random() < 0.6) ? 1 : 2;
	        }

	        // Check if opponent is still alive before executing player's action
	        if (!opponent.isAlive()) {
	            System.out.println("You win!");
	            break;
	        }
	        
	        //Checks opponent action.
	        if (opponentAction == 1) {
	            opponent.attack(player);
	        } else {
	            opponent.dodge(opponentAction);
	        }

	        // Check if player is still alive
	        if (!player.isAlive()) {
	            System.out.println("You lose!");
	            break;
	        }
	        
	        // Player Action
	        if (playerAction == 1) {
	            // Player attacks.
	            player.attack(opponent);
	        } else {
	            // Player dodges
	            player.dodge(opponentAction);
	        }

	        // Print out the current status of the fighters
	        System.out.println("Player health: " + player.getHealth());
	        System.out.println("Opponent health: " + opponent.getHealth());
	    }
	}
    
    /**
     * This method is the player's character creator. 
     * It allows the user to input the desired race, name, and weapon.
     * 
     * @param scanner - scanner object is used to read input from the player.
     * @return a Fighter object with a specified race, name, and weapon.
     */
    public static Fighter createFighter(Scanner scanner) {
        // prompt the player to choose their fighter's race
        System.out.println("Choose your fighter's race:");
        System.out.println("1. Elf");
        System.out.println("2. Human");
        System.out.println("3. Dwarf");
        int raceChoice = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        // prompt the player to enter their fighter's name
        System.out.print("Enter your fighter's name: ");
        String name = scanner.nextLine();

        // prompt the player to choose their fighter's weapon
        System.out.println("Choose your fighter's weapon:");
        System.out.println("1. Bow");
        System.out.println("2. Sword");
        System.out.println("3. Hammer");
        int weaponChoice = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        // create the chosen fighter
        Fighter fighter = null;
        Weapon weapon = null;
        switch (raceChoice) {
            case 1:
                fighter = new Elf(name, 100, null);
                switch (weaponChoice) {
                    case 1:
                        weapon = new Bow();
                        break;
                    case 2:
                        weapon = new Sword();
                        break;
                    case 3:
                        weapon = new Hammer();
                        break;
                    default:
                        System.out.println("Invalid weapon choice. Defaulting to Bow.");
                        weapon = new Bow();
                        break;
                }
                break;
            case 2:
                fighter = new Human(name, 100, null);
                switch (weaponChoice) {
                    case 1:
                        weapon = new Bow();
                        break;
                    case 2:
                        weapon = new Sword();
                        break;
                    case 3:
                        weapon = new Hammer();
                        break;
                    default:
                        System.out.println("Invalid weapon choice. Defaulting to Sword.");
                        weapon = new Sword();
                        break;
                }
                break;
            case 3:
                fighter = new Dwarf(name, 100, null);
                switch (weaponChoice) {
                    case 1:
                        weapon = new Bow();
                        break;
                    case 2:
                        weapon = new Sword();
                        break;
                    case 3:
                        weapon = new Hammer();
                        break;
                    default:
                        System.out.println("Invalid weapon choice. Defaulting to Hammer.");
                        weapon = new Hammer();
                        break;
                }
                break;
            default:
                System.out.println("Invalid race choice. Defaulting to Human.");
                fighter = new Human(name, 100, null);
                weapon = new Sword();
                break;
        }

        // assign the chosen weapon to the fighter
        fighter.setWeapon(weapon);

        return fighter; // Returns the generated fighter.
    }
    
    /**
     * Creates a random opponent fighter object with a random race and weapon.
     * @return the created random opponent fighter object.
     */
    public static Fighter createRandomOpponent() {
        int randomRace = (int) (Math.random() * 3) + 1;
        Fighter randomOpponent = null;
        switch (randomRace) {
            case 1:
                randomOpponent = new Elf("Random Elf", 100, getWeapon());
                break;
            case 2:
                randomOpponent = new Human("Random Human", 100, getWeapon());
                break;
            case 3:
                randomOpponent = new Dwarf("Random Dwarf", 100, getWeapon());
                break;
        }
        return randomOpponent;
    }
    
    
    /**
     * This method provides a randomly generated Weapon object. 
     * It is used when we need to generate a random opponent for a player. 
     * @return a new Weapon object.
     */
    public static Weapon getWeapon() {
        int weaponChoice = (int) (Math.random() * 3) + 1;
        switch (weaponChoice) {
            case 1:
                return new Bow();
            case 2:
                return new Sword();
            case 3:
                return new Hammer();
            default:
                System.out.println("Invalid weapon choice. Defaulting to Bow.");
                return new Bow();
        }
    }
}