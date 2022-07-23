package package1;

import package02.Monster_HoopSnake;
<<<<<<< HEAD:src/package01/Story.java



=======
>>>>>>> e4b81770071cb1e2cdaad117485d187231564dd6:src/package1/Story.java
import package02.SuperMonster;
import package03.SuperWeapon;
import package03.Weapon_Knife;
import package03.Weapon_LongSword;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Story {
<<<<<<< HEAD:src/package01/Story.java
    static RoomGame game;
    static UI ui;
    static VisibilityManager vm;
    static Player player = new Player();
    static RandomEncounter encounter = new RandomEncounter();

    static int candle = 0;
    static int hasMonsterKey = 0;
    static int gem = 0;
    static int hiddenWpn = 0;
    static int enteredLeft = 0;
    static int enteredMiddle = 0;
    static int hasMap = 0;
    static int hasTalisman = 0;
    static int trapDoorKey =0;
    static int hasHiddenTreasure; 
    
    static String location;
    static SuperMonster curMonster;
    static int[] progressKey = new int[3];
    
=======
    RoomGame game;
    UI ui;
    VisibilityManager vm;
    Player player = new Player();
    RandomEncounter encounter = new RandomEncounter();

    
    //-----------------------Start of progressKey Vals-----------------------
    int candle = 0;
    int trapDoorKey = 0;
    int gem = 0;
    int hiddenWpn = 0;
    int enteredLeft = 0;
    static int hasTalisman = 1;
    static int hasMap = 0;
    
    static int[] progressKey = new int[2];
    progressKey[0] = hasTalisman;
	progressKey[1] = hasMap;
    //We also need to include player.hp
    
    //-----------------------End of progressKey Vals-------------------------
    String location;
    SuperMonster curMonster;
>>>>>>> e4b81770071cb1e2cdaad117485d187231564dd6:src/package1/Story.java

    public Story(RoomGame g, UI userInterface, VisibilityManager vManager){
        game = g;
        ui = userInterface;
        vm = vManager;
    }
    
  //-----------------------Start of progressKey Vals-----------------------
    public static void main(String [] args) {
    	String progressKey = "30";
    	
    	readProgressKey(progressKey);
    }
    
    public static String createProgressKey() {
    	
        progressKey[0] = hasTalisman;
    	progressKey[1] = hasMap;
    	progressKey[2] = hasHiddenTreasure;
    	
    	
    	String progressKeyString = "";
    	for (int i = 0; i < progressKey.length ; ++i) {
    		progressKeyString = progressKeyString + String.valueOf(progressKey[i]);
    	}
    	
    	return progressKeyString;
    }
    
    public static void readProgressKey(String progressKeyString) {
    	for (int i = 0; i < progressKeyString.length() ; ++i) {
    		progressKey[i] = progressKeyString.charAt(i);
    	}
    	
    	System.out.println(hasMap);
    	System.out.println(hasTalisman);
    	System.out.println(hasHiddenTreasure);
    }
    
    
  //-----------------------End of progressKey Vals-------------------------
   
    public void setLocation(String saveLocation){
        location = saveLocation;
        
    }
    
    public static String getLocation() {
    	return location;
    }
   
    public static void defaultSetup(){
        Player.setHP(100);
        //player.hp = 100;

        ui.currentHealthLabel.setText("" + Player.getHP());
        ui.outputTextArea.setText("You shall find messages here to help you during your" +
                "\n\tventure." +
                "\n\nTo begin your journey, press start...");

        Player.currentWeapon = new Weapon_Knife();
        Player.setWeapon("Knife");
        ui.currentWeaponLabel.setText(Player.getWeaponName());

        ui.northBtn.setText("Start");
        ui.eastBtn.setText("");
        ui.southBtn.setText("");
        ui.westBtn.setText("");

        game.nextPosition1 = "dungeonEntrance";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";

        ui.item1.setText("");
        ui.item2.setText("");
        ui.item3.setText("");
        ui.item4.setText("");
        ui.item5.setText("");
    }

<<<<<<< HEAD:src/package01/Story.java
    public static void selectPosition(String nextPosition){
=======
    public static String createProgressKey() {
    	String progressKeyString = "";
    	for (int i = 0; i < progressKey.length ; ++i) {
    		progressKeyString = progressKeyString + String.valueOf(progressKey[i]);
    	}
    	
    	return progressKeyString;
    }
    
    public static void readProgressKey(String progressKeyString) {
    	for (int i = 0; i < progressKeyString.length() ; ++i) {
    		progressKey[i] = progressKeyString.charAt(i);
    	}
    	
    	System.out.println(hasMap);
    	System.out.println(hasTalisman);
    }
    
    public void selectPosition(String nextPosition){ //Location parser on loadup
>>>>>>> e4b81770071cb1e2cdaad117485d187231564dd6:src/package1/Story.java
        switch(nextPosition){
            //    LEFT DOOR
            case "dungeonEntrance":
                dungeonEntrance();
                break;
            case "mainDoor":
                openDoor();
                break;
            case "mainRoom":
                mainRoom();
                break;
            case "turnBack":
                turnBack();
                break;
            case "leftDoor":
                leftDoor();
                break;
            case "table":
                leftDoorTable();
                break;
            case "wardrobe":
                wardrobe();
                break;
            case "hidden":
                hidden();
                break;
            case "trapDoor":
                trapDoor();
                break;
            case "leftUnderground":
                leftUnderground();
                break;
            case "fightMonster":
                fight();
                break;
            case "playerAttack":
                playerAttack();
                break;
            case "speakMonster":
                speakMonster();
                break;
            case "correctRiddle":
                correctRiddle();
                break;
            case "wrongRiddle":
                wrongRiddle();
                break;
            case "run":
                System.out.println("You tried to run");
                break;
            case "exit":
                defaultSetup();
                break;
//    MIDDLE DOOR ------------------------------------------------------------------------------------------ MIDDLE DOOR
            case "middleDoor":
            	middleRoom();
                System.out.println("Middle door selected");
                break;
            case "altar":
            	altar();
            	break;
            case "talisman":
            	talisman();
            	break;
            case "hiddenStairway":
            	hiddenStairway();
            	break;
            case "hiddenTreasure":
            	hiddenTreasure();
            	break;
//    RIGHT DOOR -------------------------------------------------------------------------------------------- RIGHT DOOR
            case "rightDoor":
                rightDoor();
                break;
            case "rightTable":
            	rightTable();
            	break;
            case "rightTableNoMap":
            	rightTableNoMap();
            	break;
            case "receiveMap":
            	receiveMap();
            	break;
            default:
                break;
        }
    }
    
 
    

    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    Locations -- Text Area Story Line
    public static void dungeonEntrance(){
//<<<<<<< HEAD
    	
        ui.mainTextArea.setText("You slowly realize the day has gone and it is dark as" +
                "\n    you approach the door. " +
                "\n\nAround the door you see brush and rocks, the path ends here, " +
                "\n    with trees to the sides of you. " +
                "\n\nOnly way forward is through this heavy steel door, between the" +
                "\n    ominous, lowly lit torches");
//=======
        ui.mainTextArea.setText("You slowly realize the day has gone and it is dark as you approach the door. " +
                "\n\nAround the door you see brush and rocks, the path ends here, with trees to the sides of you. " +
                "\n\nOnly way forward is through this heavy steel door, between the ominous, lowly lit torches");
//>>>>>>> branch 'master' of https://github.com/YukiUchima/dungeon-Demo.git
        ui.northBtn.setText("North");
        ui.eastBtn.setText("");
        ui.southBtn.setText("South");
        ui.westBtn.setText("");

        game.nextPosition1 = "mainDoor";
        game.nextPosition2 = "";
        game.nextPosition3 = "turnBack";
        game.nextPosition4 = "";
    }

//    public void
    public static void openDoor(){
        if(encounter.monsterSpawned()){
            curMonster = encounter.monster();
            System.out.println("Monster encountered: " + curMonster.getName());
            fight();
            
        }
        else{
            System.out.println("No monster was found...");
        }
       

        ui.mainTextArea.setText("You Entered into the main dungeon room.\nYou see three doors scattered around you...");
        ui.outputTextArea.setText("You can choose which door to enter or exit.");


        ui.northBtn.setText("North");
        ui.eastBtn.setText("East");
        ui.southBtn.setText("");
        ui.westBtn.setText("West");

        game.nextPosition1 = "middleDoor";
        game.nextPosition2 = "rightDoor";
        game.nextPosition3 = "";
        game.nextPosition4 = "leftDoor";
       }



    public static void mainRoom(){
        ui.mainTextArea.setText("You returned to the main dungeon room\nWhich way do you want to go?...");
        ui.outputTextArea.setText("You can choose which door to enter or exit.");


        ui.northBtn.setText("North");
        ui.eastBtn.setText("East");
        ui.southBtn.setText("");
        ui.westBtn.setText("West");

        game.nextPosition1 = "middleDoor";
        game.nextPosition2 = "rightDoor";
        game.nextPosition3 = "";
        game.nextPosition4 = "leftDoor";
        }


    public static void turnBack(){
        ui.mainTextArea.setText("You are deciding to abandon the story... would you like to save?");

        ui.northBtn.setText("");
        ui.eastBtn.setText("");
        ui.southBtn.setText("");
        ui.westBtn.setText("");

        game.nextPosition1 = "";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";


        vm.showTitleScreen();
        defaultSetup();
    }

//    WEST DOOR         LEFT DOOR                  LEFT DOOR                  LEFT DOOR         ------------------------
//    WEST DOOR         LEFT DOOR                  LEFT DOOR                  LEFT DOOR         ------------------------
    public static void leftDoor(){
        curMonster = encounter.monster();           //pick random monster
        fight();
        System.out.println(curMonster.getName());
        if(enteredLeft < 1) {
            ui.mainTextArea.setText("You decide to walk cautiously to the left door and look around you, where you" +
                    " see a note on a table to the west. You also see a wardrobe to the east. North of you is a " +
                    "trapdoor before you reach the north wall.");
            enteredLeft+=1;
        }else{
            ui.mainTextArea.setText("You are back in the left room.");
        }
        ui.outputTextArea.setText("You can explore this room.");

        ui.northBtn.setText("North");
        ui.eastBtn.setText("East");
        ui.southBtn.setText("South");
        ui.westBtn.setText("West");

        game.nextPosition1 = "trapDoor";
        game.nextPosition2 = "wardrobe";
        game.nextPosition3 = "mainRoom";
        game.nextPosition4 = "table";
    }

    public static void leftDoorTable(){
        if(candle < 1){
            ui.mainTextArea.setText("As you reached the table, you see a note... You reach for the note and " +
                    "read the following:\n\n\" One who wishes to complete his quest must first face the " +
                    "\n darkness below. Take the candle on the table to move forth in your journey...\"");

            ui.outputTextArea.setText("You now have a candle!");
            candle=1;
            ui.item1.setText("Candle");
        }else{
            ui.mainTextArea.setText("You find the note again on the table. It reads:" +
                    "\n\n\" One who wishes to complete his quest must first face the darkness below." +
                    " Take the candle on the table to move forth in your journey...\"");

            ui.outputTextArea.setText("");
        }

        ui.northBtn.setText("North");
        ui.eastBtn.setText("East");
        ui.southBtn.setText("South");
        ui.westBtn.setText("");

        game.nextPosition1 = "trapDoor";
        game.nextPosition2 = "wardrobe";
        game.nextPosition3 = "mainRoom";
        game.nextPosition4 = "";
    }

    public static void wardrobe(){
        if(trapDoorKey < 1) {
            ui.mainTextArea.setText("You reached the wardrobe in wander of what you will find. You notice a metal key...");

            ui.outputTextArea.setText("You received the key!");
            trapDoorKey = 1;

            ui.northBtn.setText("Trapdoor");
            ui.eastBtn.setText("Compartment");
            ui.southBtn.setText("Leave");
            ui.westBtn.setText("");

            game.nextPosition1 = "trapDoor";
            game.nextPosition2 = "hidden";
            game.nextPosition3 = "leftDoor";
            game.nextPosition4 = "";

        }else if(hiddenWpn < 1){
            ui.mainTextArea.setText("You reached the wardrobe again.\n" +
                    "There is not much left to find...");

            ui.northBtn.setText("Trapdoor");
            ui.eastBtn.setText("Hidden");
            ui.southBtn.setText("Leave");
            ui.westBtn.setText("");

            game.nextPosition1 = "trapDoor";
            game.nextPosition2 = "hidden";
            game.nextPosition3 = "leftDoor";
            game.nextPosition4 = "";
        }else{
            ui.mainTextArea.setText("There is nothing else to find here.");
            ui.northBtn.setText("Trapdoor");
            ui.eastBtn.setText("Leave");
            ui.southBtn.setText("");
            ui.westBtn.setText("");

            game.nextPosition1 = "trapDoor";
            game.nextPosition2 = "mainRoom";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
    }

    public static void hidden(){
        ui.mainTextArea.setText("Your curiosity has rewarded you this time... You have " +
                "found a new weapon for your journey.");

        hiddenWpn = 1;

        ui.outputTextArea.setText("You obtained a long sword!");
        Player.currentWeapon = new Weapon_LongSword();
        Player.setWeapon("Long Sword");
        ui.currentWeaponLabel.setText(Player.getWeaponName());
        //ui.currentWeaponLabel.setText(player.currentWeapon.name);

        ui.northBtn.setText("Trapdoor");
        ui.eastBtn.setText("Table");
        ui.southBtn.setText("Leave");
        ui.southBtn.setText("");

        game.nextPosition1 = "trapDoor";
        game.nextPosition2 = "table";
        game.nextPosition3 = "leave";
        game.nextPosition4 = "";
    }

    public static void trapDoor(){
        if (trapDoorKey > 0 && candle > 0){
            ui.mainTextArea.setText("You used the key you found in the wardrobe. You unlocked the trapdoor, will you open it?");
            ui.outputTextArea.setText("You can continue your journey below...");

            ui.northBtn.setText("Open Trapdoor");
            ui.eastBtn.setText("Check Table ");
            ui.southBtn.setText("Check Wardrobe");
            ui.westBtn.setText("Leave");

            game.nextPosition1 = "leftUnderground";
            game.nextPosition2 = "table";
            game.nextPosition3 = "wardrobe";
            game.nextPosition4 = "mainDoor";

        }else if(trapDoorKey < 1){
            ui.mainTextArea.setText("You find that the trapdoor is locked...\n");
            ui.outputTextArea.setText("Hint: You may need to search...");
            ui.northBtn.setText("Check Table");
            ui.eastBtn.setText("Check Wardrobe");
            ui.southBtn.setText("Leave");
            ui.westBtn.setText("");

            game.nextPosition1 = "table";
            game.nextPosition2 = "wardrobe";
            game.nextPosition3 = "leftDoorExit";
            game.nextPosition4 = "";
        }else{
            ui.mainTextArea.setText("It will be too dark to enter...\n");
            ui.outputTextArea.setText("Hint: You may need to search...");
            ui.northBtn.setText("Check Table");
            ui.eastBtn.setText("Check Wardrobe");
            ui.southBtn.setText("Leave");
            ui.westBtn.setText("");

            game.nextPosition1 = "table";
            game.nextPosition2 = "wardrobe";
            game.nextPosition3 = "leftDoorExit";
            game.nextPosition4 = "";
        }
    }

    public static void leftUnderground(){
        ui.mainTextArea.setText("You walked down with the sound of stone steps of a cold chamber. You approach " +
                "the end of this stairway to a large open, chamber.\n\nTroll: \"Who disturbs me?!\"");

        ui.outputTextArea.setText("You have encountered a beast!");
        trapDoorKey=1;

        ui.northBtn.setText("Fight");
        ui.eastBtn.setText("Speak");
        ui.southBtn.setText("");
        ui.westBtn.setText("Run");

        game.nextPosition1 = "fightMonster";
        game.nextPosition2 = "speakMonster";
        game.nextPosition3 = "";
        game.nextPosition4 = "run";
    }

    public static void speakMonster(){
        ui.mainTextArea.setText("The monster is taken aback you are speaking to them...\n\n" +
                "Monster: \"Solve my riddle and I shall bestow upon thee a gift.\"" +
                "\n\n    What exists while hidden, but ceases to exist when revealed?");

        ui.outputTextArea.setText("Hint: Solve the riddle to face the consequences...");
        ui.northBtn.setText("Thoughts");
        ui.eastBtn.setText("Promises");
        ui.southBtn.setText("Secrets");
        ui.westBtn.setText("RUN!");

        game.nextPosition1 = "wrongRiddle";
        game.nextPosition2 = "wrongRiddle";
        game.nextPosition3 = "correctRiddle";
        game.nextPosition4 = "leftDoor";
    }

    public static void wrongRiddle(){
        ui.mainTextArea.setText("You failed to answer the riddle correctly. The monster refuses to cooperate...");

        ui.outputTextArea.setText("Hint: How can you obtain what you need?");
        ui.northBtn.setText("Fight");
        ui.eastBtn.setText("Escape!");
        ui.southBtn.setText("");
        ui.westBtn.setText("");

        game.nextPosition1 = "fightMonster";
        game.nextPosition2 = "run";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public static void correctRiddle(){
        ui.mainTextArea.setText("You solved the monster's riddle correctly. \n\n" +
                "Monster: \"Take this gem as a reward. Good luck on your quest\"");

        ui.outputTextArea.setText("You received a large Gem!");
        ui.item2.setText("Gem");
        gem = 1;


        ui.northBtn.setText("Return");
        ui.eastBtn.setText("");
        ui.southBtn.setText("");
        ui.westBtn.setText("");

        game.nextPosition1 = "mainRoom";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public static void fight(){
        ui.mainTextArea.setText(curMonster.getName() + "(HP): " + curMonster.getStrength() + "\n\nWhat will you do?");
        gem=1;

        ui.outputTextArea.setText("");

        ui.northBtn.setText("Attack");
        ui.eastBtn.setText("Run");
        ui.southBtn.setText("");
        ui.westBtn.setText("");

        game.nextPosition1 = "playerAttack";
        game.nextPosition2 = "run";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public static void monsterAttack(SuperMonster monster){
        ui.outputTextArea.setText("You encountered a " + monster.getName() + "!");
        ui.northBtn.setText("Main");
        ui.eastBtn.setText("");
        ui.southBtn.setText("");
        ui.westBtn.setText("");

        game.nextPosition1 = "mainRoom";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public static void playerAttack(){
        System.out.println("You attacked the monster");
        int playerDamage = new java.util.Random().nextInt(Player.currentWeapon.damage);

        ui.outputTextArea.setText("You attacked the " +curMonster.getName() + "and gave " + playerDamage + " damage!");

        curMonster.setHealth(curMonster.getHealth() - playerDamage);

        ui.northBtn.setText(">");
        ui.eastBtn.setText("");
        ui.southBtn.setText("");
        ui.westBtn.setText("");
        if(curMonster.getHealth()>0)
	        game.nextPosition1 = ">";
	        game.nextPosition2 = "";
	        game.nextPosition3 = "";
	        game.nextPosition4 = "";
    }



<<<<<<< HEAD:src/package01/Story.java

//  North DOOR         Middle DOOR                  Middle DOOR                  Middle DOOR         ------------------------
//  North DOOR         Middle DOOR                  Middle DOOR                  Middle DOOR         ------------------------
    public static void middleRoom() {
 	   
		if (hasMonsterKey == 1 && hasMap == 0) {
			ui.mainTextArea.setText("A pair of worn statues mark the entrance to this dungeon. "
				+ " Beyond the pair of statues lies a narrow, foggy room covered in cobwebs, crawling insects and rubble.");
			
			
    		ui.outputTextArea.setText("You can explore this room.");
    		
    		ui.northBtn.setText("North");
            ui.eastBtn.setText("East");
            ui.southBtn.setText("South");
            ui.westBtn.setText("");

            game.nextPosition1 = "mainRoom";
            game.nextPosition2 = "hiddenStairway";
            game.nextPosition3 = "altar";
            game.nextPosition4 = "";
	}
		
		else if (hasMonsterKey == 0){
			ui.mainTextArea.setText("A pair of worn statues mark the entrance to this dungeon." 
					+ " Beyond the pair of statues lies a narrow, foggy room covered in cobwebs, crawling insects and rubble."
					+ " The room appears to be dark. You cannot enter without a key.");
    		ui.outputTextArea.setText("Hint: you may want to search elsewhere");
    		
    		ui.northBtn.setText("North");
            ui.eastBtn.setText("East");
            ui.southBtn.setText("South");
            ui.westBtn.setText("West");

            game.nextPosition1 = "mainRoom";
            game.nextPosition2 = "mainRoom";
            game.nextPosition3 = "mainRoom";
            game.nextPosition4 = "mainRoom";
    		
		}
	
		else if (hasMonsterKey == 1 && hasMap == 1){
			if (hasHiddenTreasure == 0) {
    			ui.mainTextArea.setText("You are back in the middle room. Once again, "
    					+ "you notice the gloomy room covered in cobwebs, crawling insects and rubble up ahead.");
    			ui.outputTextArea.setText("You can explore this area.");
    			
    			ui.northBtn.setText("North");
                ui.eastBtn.setText("East");
                ui.southBtn.setText("South");
                ui.westBtn.setText("West");

                game.nextPosition1 = "mainRoom";
                game.nextPosition2 = "lake";
                game.nextPosition3 = "mainRoom";
                game.nextPosition4 = "lake";
			}
			else {
				ui.mainTextArea.setText("You are back in the middle room, and have already obtained the hidden treasure");
    			ui.outputTextArea.setText("Hint: explore elsewhere to escape the looming danger of this dungeon");
    			
    			ui.northBtn.setText("");
                ui.eastBtn.setText("East");
                ui.southBtn.setText("");
                ui.westBtn.setText("West");

                game.nextPosition1 = "";
                game.nextPosition2 = "mainRoom";
                game.nextPosition3 = "";
                game.nextPosition4 = "mainRoom";
			}
		}
		
		

		System.out.println(getLocation());
}


	
	public static void altar() {
		if (hasTalisman == 0) {
	    	ui.mainTextArea.setText("You notice an altar that has an eerie atmosphere to it."
	    			+ " Surrounding the altar lie rotting bodies that have been impaled with various weapons."
	    			+ " It appears that no one has been able to approach this altar without reaching an inevitable death.");
	    	
	    	ui.outputTextArea.setText("Hint: You may want to search this room.");
	    	
	    	ui.northBtn.setText("North");
	        ui.eastBtn.setText("East");
	        ui.southBtn.setText("South");
	        ui.westBtn.setText("West");
	
	        game.nextPosition1 = "";
	        game.nextPosition2 = "hiddenStairway";
	        game.nextPosition3 = "hiddenStairway";
	        game.nextPosition4 = "";
	        
		}
		else {
			
			ui.mainTextArea.setText("You are back at the altar. As you approach closer, you reach an area where no being has gotten near."
					+ " Suddenly, arrows and swords come shooting at you from all directions. "
					+ "You notice your talisman releasing a strange form of energy, and suddenly the attack stops."
					+ " A shining orb ascends upon the altar, and as you reach for it, a bright light blinds your vision.");
			
			
			ui.northBtn.setText("Continue");
	        ui.eastBtn.setText("");
	        ui.southBtn.setText("");
	        ui.westBtn.setText("");
	
	        game.nextPosition1 = "middleRoom";
	        game.nextPosition2 = "";
	        game.nextPosition3 = "";
	        game.nextPosition4 = "";
		}
		System.out.println(getLocation());
	}
	
	public static void hiddenStairway() {
		if (hasTalisman == 0) {
			ui.mainTextArea.setText("In a dark corner, you notice a hidden stairway. Going down the stairway, up ahead, "
					+ "there is a large iron door that is shut tight."
					+ "You remember that you obtained a key in a previous room that might help you open this door");
			
			ui.northBtn.setText("Use key");
		    ui.eastBtn.setText("");
		    ui.southBtn.setText("Return");
		    ui.westBtn.setText("");
		
		    game.nextPosition1 = "talisman";
		    game.nextPosition2 = "";
		    game.nextPosition3 = "altar";
		    game.nextPosition4 = "";
		}
		else {
			ui.mainTextArea.setText("You are back at the hidden stairway where you found the talisman.");
			
			ui.northBtn.setText("Return");
		    ui.eastBtn.setText("");
		    ui.southBtn.setText("South");
		    ui.westBtn.setText("");
		
		    game.nextPosition1 = "mainRoom";
		    game.nextPosition2 = "";
		    game.nextPosition3 = "altar";
		    game.nextPosition4 = "";
		}
	    System.out.println(getLocation());
	}
	
	public static void talisman() {
		hasTalisman = 1;
		ui.mainTextArea.setText("As open the door, the inside reveals a bright object "
				+ "floating in the middle of the room. You decide to retrieve the object.");
		ui.item3.setText("Talisman");
		
		ui.outputTextArea.setText("You have obtained a talisman");
		
		ui.northBtn.setText("North");
	    ui.eastBtn.setText("");
	    ui.southBtn.setText("");
	    ui.westBtn.setText("");
	
	    game.nextPosition1 = "altar";
	    game.nextPosition2 = "";
	    game.nextPosition3 = "";
	    game.nextPosition4 = "";
	    
	    System.out.println(getLocation());
	}
	
	public static void lake() {
		
		ui.mainTextArea.setText("Looking at your surroundings, you see smooth, oval rocks lining the bank of a mysterious lake."
				+ " Seemingly neglected, the lake is overlaid with spongy moss and "
				+ " fallen, decaying leaves from the withering trees above. "
				+ " Looking at your map, it appears that this is the final destination leading to the hidden treasure."
				+ " The map indicates to head west.");
		
		ui.outputTextArea.setText("You can explore this area");
		ui.northBtn.setText("");
	    ui.eastBtn.setText("West");
	    ui.southBtn.setText("South");
	    ui.westBtn.setText("");
	
	    game.nextPosition1 = "";
	    game.nextPosition2 = "hiddenTreasure";
	    game.nextPosition3 = "middleRoom";
	    game.nextPosition4 = "";
		
	    System.out.println(getLocation());
		
	}
	
	public static void hiddenTreasure() {
		hasHiddenTreasure = 1;
		
		ui.mainTextArea.setText("As you go west, a force seems to be pulling you towards the lake, prompting"
				+ " you to swim into the darkness. As you swim deeper, you notice a chest with ancient engravings imprinted upon it. "
				+ " Opening the chest, you find a worn out key.");
		
		ui.item4.setText("Treasure Key");
		
		ui.northBtn.setText("North");
	    ui.eastBtn.setText("West");
	    ui.southBtn.setText("South");
	    ui.westBtn.setText("East");
	    
	    game.nextPosition1 = "mainRoom";
	    game.nextPosition2 = "mainRoom";
	    game.nextPosition3 = "mainRoom";
	    game.nextPosition4 = "mainRoom";
	    
	    System.out.println(getLocation());
	}
	
	


//////////////////////////////////////////////////     MIDDLE DOOR END      \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\


//  East DOOR         Right DOOR                  Right DOOR                  Right DOOR         ------------------------
//  East DOOR         Right DOOR                  Right DOOR                  Right DOOR         ------------------------
	public static void rightDoor() {
		if (hasTalisman != 1) {
			ui.mainTextArea.setText("As you push open the right door... \n" + 
		                            "You find that it's too dark to make out anything. May be best to turn back around and return once you found a light source.\n");
		
			ui.northBtn.setText("");
			ui.eastBtn.setText("");
			ui.southBtn.setText("South");
			ui.westBtn.setText("");
			
			game.nextPosition1 = "";
			game.nextPosition2 = "";
			game.nextPosition3 = "mainRoom";
			game.nextPosition4 = "";
		} else {
			ui.mainTextArea.setText("As you push open the right door... \n" + 
		                            "The talisman in your bag shines brightly and illumnates the space around you.\n" +
	                                "As you take out the talisman out of your bag, a table with a large map laid atop of it comes into view.\n" );
			
			ui.outputTextArea.setText("Head North to interact with the table.");
			
			ui.northBtn.setText("North");
			ui.eastBtn.setText("");
			ui.southBtn.setText("South");
			ui.westBtn.setText("");
			
			game.nextPosition1 = "rightTable";
			game.nextPosition2 = "";
			game.nextPosition3 = "mainRoom";
			game.nextPosition4 = "";
			
		}
	}
	
	public static void rightTable() {
=======
//    RIGHT DOOR
    public void rightDoor() {
    	if (hasTalisman != 1) {
    		ui.mainTextArea.setText("As you push open the right door... \n" + 
    	                            "You find that it's too dark to make out anything. May be best to turn back around and return once you found a light source.\n");
    	
    		ui.northBtn.setText("");
    		ui.eastBtn.setText("");
    		ui.southBtn.setText("South");
    		ui.westBtn.setText("");
    		
    		game.nextPosition1 = "";
    		game.nextPosition2 = "";
    		game.nextPosition3 = "mainRoom";
    		game.nextPosition4 = "";
    	} else {
    		ui.mainTextArea.setText("As you push open the right door... \n" + 
    	                            "The talisman in your bag shines brightly and illumnates the space around you.\n" +
                                    "As you take out the talisman out of your bag, a table with a large map laid atop of it comes into view.\n" );
    		
    		ui.outputTextArea.setText("Head North to interact with the table.");
    		
    		ui.northBtn.setText("North");
    		ui.eastBtn.setText("");
    		ui.southBtn.setText("South");
    		ui.westBtn.setText("");
    		
    		game.nextPosition1 = "rightTable";
    		game.nextPosition2 = "";
    		game.nextPosition3 = "mainRoom";
    		game.nextPosition4 = "";
    		
    	}
    }
    
    public void rightTable() {
>>>>>>> e4b81770071cb1e2cdaad117485d187231564dd6:src/package1/Story.java
    	if (hasMap != 1) {
    		ui.mainTextArea.setText("You decide to approach the old dusty table in front of you...\n" +
    	                            "As you step closer, you begin to make out the drawings on the map. This is a map of a huge lake!");
    		
    		ui.outputTextArea.setText("Do you wish to take the map?");
    		
    		ui.northBtn.setText("");
    		ui.eastBtn.setText("No");
    		ui.southBtn.setText("");
    		ui.westBtn.setText("Yes");
    		
    		game.nextPosition1 = "";
    		game.nextPosition2 = "rightTableNoMap";
    		game.nextPosition3 = "";
    		game.nextPosition4 = "receiveMap";
    	} else {
    		ui.mainTextArea.setText("This is where you found the map to the lake.");
    		
    		ui.outputTextArea.setText("Click South to head back.");
    		
    		ui.northBtn.setText("");
    		ui.eastBtn.setText("");
    		ui.southBtn.setText("South");
    		ui.westBtn.setText("");
    		
    		game.nextPosition1 = "";
    		game.nextPosition2 = "";
    		game.nextPosition3 = "rightDoor";
    		game.nextPosition4 = "";
    	}
    }
    
<<<<<<< HEAD:src/package01/Story.java
	  
    public static void rightTableNoMap() {
=======
    public void rightTableNoMap() {
>>>>>>> e4b81770071cb1e2cdaad117485d187231564dd6:src/package1/Story.java
    	ui.outputTextArea.setText("You decide to not take the map.");
    	
    	ui.northBtn.setText(">");
		ui.eastBtn.setText("");
		ui.southBtn.setText("");
		ui.westBtn.setText("");
		
		game.nextPosition1 = "rightDoor";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
    }
    
<<<<<<< HEAD:src/package01/Story.java
    public static void receiveMap() {
    	ui.outputTextArea.setText("You have received a map of the 'Secret Lake'");
    	
    	hasMap = 1;
    	ui.item5.setText("Map");
=======
    public void receiveMap() {
    	ui.outputTextArea.setText("You have received a map of the 'Secret Lake'");
    	
    	hasMap = 1;
    	ui.item4.setText("Map");
>>>>>>> e4b81770071cb1e2cdaad117485d187231564dd6:src/package1/Story.java
    	
    	ui.northBtn.setText(">");
		ui.eastBtn.setText("");
		ui.southBtn.setText("");
		ui.westBtn.setText("");
		
		game.nextPosition1 = "rightDoor";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
    }
<<<<<<< HEAD:src/package01/Story.java
=======
    public static void main(String [] args) {
    	String progressKey = "30";
    	
    	readProgressKey(progressKey);
    }
>>>>>>> e4b81770071cb1e2cdaad117485d187231564dd6:src/package1/Story.java
}

//Frame LOCATIONS
//  Front entrance; main room
//      >LEFT door
//          > search room; weapon, note, key, cellar
//              >   Enter cellar; BOSS
//                    >Boss fight, solve riddle, retreat
//                      Fight; win, lose > retrieve KEY ITEM / lose game
//                      Riddle: win, lose > retrieve weapon and key item / fight or leave
//
//      >Middle
//      >Right
//  Loc: front of entrance
//      open door, turn back
//  Loc: main room
//      left door, middle door, right door,

//      loc: left room