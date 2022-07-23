package package1;

import package03.SuperWeapon;

public class Player {

    public static int hp;
    public static SuperWeapon currentWeapon;
    public static String currWeapon;
    
    public static void setHP(int health) {
    	hp = health;
    }
    
    public static int getHP() {
    	return hp;
    }
    
    public static void setWeapon(String weapon) {
    	currWeapon = weapon;
    }
    
    public static String getWeaponName() {
    	return currentWeapon.getWeaponName();
    }
    
    
}
