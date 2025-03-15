import java.util.Random;
import java.util.Scanner;

abstract class Character {
    protected String name;
    protected int health;
    protected int attackPower;

    public Character(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    public abstract void attack(Character opponent);

    public boolean isAlive() {
        return health > 0;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) health = 0;
    }

    public void displayStats() {
        System.out.println(name + " - Health: " + health);
    }
}

class Warrior extends Character {
    public Warrior(String name) {
        super(name, 120, 20);
    }

    @Override
    public void attack(Character opponent) {
        System.out.println(name + " swings a mighty sword!");
        opponent.takeDamage(attackPower);
    }
}

class Mage extends Character {
    public Mage(String name) {
        super(name, 80, 30);
    }

    @Override
    public void attack(Character opponent) {
        System.out.println(name + " casts a fireball!");
        opponent.takeDamage(attackPower);
    }
}

class Archer extends Character {
    public Archer(String name) {
        super(name, 100, 25);
    }

    @Override
    public void attack(Character opponent) {
        System.out.println(name + " shoots an arrow!");
        opponent.takeDamage(attackPower);
    }
}

class Enemy extends Character {
    private static final Random random = new Random();

    public Enemy() {
        super("Goblin", 100, 15);
    }

    @Override
    public void attack(Character opponent) {
        System.out.println(name + " attacks fiercely!");
        opponent.takeDamage(attackPower + random.nextInt(5));
    }
}

public class RPGGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the RPG Battle Game!");
        System.out.print("Enter your character name: ");
        String playerName = scanner.nextLine();

        System.out.println("Choose your class:");
        System.out.println("1. Warrior");
        System.out.println("2. Mage");
        System.out.println("3. Archer");
        System.out.print("Enter choice (1-3): ");
        int choice = scanner.nextInt();

        Character player;
        switch (choice) {
            case 1:
                player = new Warrior(playerName);
                break;
            case 2:
                player = new Mage(playerName);
                break;
            case 3:
                player = new Archer(playerName);
                break;
            default:
                System.out.println("Invalid choice, defaulting to Warrior.");
                player = new Warrior(playerName);
        }

        Character enemy = new Enemy();
        System.out.println("\nBattle Begins! You encounter a " + enemy.name);

        while (player.isAlive() && enemy.isAlive()) {
            System.out.println("\nYour Turn!");
            System.out.println("1. Attack");
            System.out.println("2. Defend");
            System.out.println("3. Heal");
            System.out.println("4. Check Stats");
            System.out.print("Choose an action (1-4): ");
            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    player.attack(enemy);
                    break;
                case 2:
                    System.out.println(player.name + " defends and reduces incoming damage!");
                    player.takeDamage(enemy.attackPower / 2); // Reduce damage by half
                    break;
                case 3:
                    System.out.println(player.name + " heals for 20 health points!");
                    player.health += 20;
                    if (player.health > 120) player.health = 120; // Cap health at max value
                    break;
                case 4:
                    System.out.println("\n--- Player Stats ---");
                    player.displayStats();
                    System.out.println("\n--- Enemy Stats ---");
                    enemy.displayStats();
                    continue; // Skip enemy's turn and continue player's turn
                default:
                    System.out.println("Invalid action, you lose your turn.");
            }

            enemy.displayStats();

            if (!enemy.isAlive()) {
                System.out.println("You defeated the " + enemy.name + "!");
                break;
            }

            System.out.println("\nEnemy's Turn!");
            enemy.attack(player);
            player.displayStats();

            if (!player.isAlive()) {
                System.out.println("You have been defeated...");
            }
        }

        System.out.println("Game Over.");
        scanner.close();
    }
}
