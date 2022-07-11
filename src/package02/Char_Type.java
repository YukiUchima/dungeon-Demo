package package02;

import java.util.Random;

public abstract class Char_Type {
    Random rand = new Random();
    protected String name;
    private String charClass;
    private int strength;
    private int health;
    private int defense;

    //NAME
    public void setName(String n1) {
        this.name = n1;
    }

    public String getName() {
        return name;
    }

    public void setCharClass(String charType) {
        charClass = charType;
    }

    public String getCharClass() {
        return charClass;
    }
    //DEFENSE

    public void setDefense() {
        this.defense = 1 + rand.nextInt(8);  //adds randomness
    }

    public int getDefense() {
        return defense;
    }

    //STRENGTH
    public void setStrength(int s1) {
        this.strength = s1 + rand.nextInt(5);
    }

    public int getStrength() {
        return strength;
    }

    //HEALTH
    public void setHealth(int h1) {
        this.health = h1 + rand.nextInt(10);
    }


    public int getHealth() {
        if (health < 0) {
            health = 0;
        }
        return health;
    }

    public int attack() {
        return strength;
    }

    public void hit(int points) {
        health = health - points;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public abstract String classType();     //description unique to each type

    @Override
    public String toString() {
        return getName() + " the " + classType() + "\n\t\t+Strength: " + getStrength() + "\n\t\t+Health: " + getHealth() +
                "\n\t\t+Defense: " + getDefense() + "\n";
    }
}
