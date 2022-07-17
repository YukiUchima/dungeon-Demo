package package01;

import package02.monsters.Monster_HoopSnake;
import package02.monsters.SuperMonster;
import package03.SuperWeapon;
import package03.Weapon_Knife;
import package03.Weapon_LongSword;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Story {
    RoomGame game;
    UI ui;
    VisibilityManager vm;
    Player player = new Player();
    RandomEncounter encounter = new RandomEncounter();

    int candle = 0;
    int trapDoorKey = 0;
    int gem = 0;
    int hiddenWpn = 0;
    int enteredLeft = 0;
    String location;
    SuperMonster curMonster;

    public Story(RoomGame g, UI userInterface, VisibilityManager vManager){
        game = g;
        ui = userInterface;
        vm = vManager;
    }

    public void setLocation(String saveLocation){
        location = saveLocation;
    }
    public void defaultSetup(){
        player.hp = 100;

        ui.currentHealthLabel.setText("" + player.hp);
        ui.outputTextArea.setText("You shall find messages here to help you during your" +
                "\n\tventure." +
                "\n\nTo begin your journey, press start...");

        player.currentWeapon = new Weapon_Knife();
        ui.currentWeaponLabel.setText(player.currentWeapon.name);

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
    }

    public void selectPosition(String nextPosition){
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
                System.out.println("Middle door selected");
                break;



//    RIGHT DOOR -------------------------------------------------------------------------------------------- RIGHT DOOR
            case "rightDoor":
                System.out.println("Right Door Selected");
            default:
                break;
        }
    }
//    Locations -- Text Area Story Line
    public void dungeonEntrance(){
        ui.mainTextArea.setText("You slowly realize the day has gone and it is dark as you approach the door. " +
                "\n\nAround the door you see brush and rocks, the path ends here, with trees to the sides of you. " +
                "\n\nOnly way forward is through this heavy steel door, between the ominous, lowly lit torches");
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
    public void openDoor(){
        if(encounter.monsterSpawned()){
            curMonster = encounter.monster();
            System.out.println("Monster encountered: " + curMonster.getName());
            fight();
        }else{
            System.out.println("No monster was found...");
        }

        ui.mainTextArea.setText("You Entered into the main dungeon room.\nYou see three doors ahead of you...");
        ui.outputTextArea.setText("You can choose which door to enter or exit.");


        ui.northBtn.setText("North");
        ui.eastBtn.setText("East");
        ui.southBtn.setText("South");
        ui.westBtn.setText("West");

        game.nextPosition1 = "middleDoor";
        game.nextPosition2 = "rightDoor";
        game.nextPosition3 = "exit";
        game.nextPosition4 = "leftDoor";

    }

    public void mainRoom(){
        ui.mainTextArea.setText("You returned to the main dungeon room\nWhich way do you want to go?...");
        ui.outputTextArea.setText("You can choose which door to enter or exit.");


        ui.northBtn.setText("North");
        ui.eastBtn.setText("East");
        ui.southBtn.setText("South");
        ui.westBtn.setText("West");

        game.nextPosition1 = "middleDoor";
        game.nextPosition2 = "rightDoor";
        game.nextPosition3 = "exit";
        game.nextPosition4 = "leftDoor";
        }


    public void turnBack(){
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
    public void leftDoor(){
        curMonster = encounter.monster();           //pick random monster
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

    public void leftDoorTable(){
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

    public void wardrobe(){
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

    public void hidden(){
        ui.mainTextArea.setText("Your curiosity has rewarded you this time... You have " +
                "found a new weapon for your journey.");

        hiddenWpn = 1;

        ui.outputTextArea.setText("You obtained a long sword!");
        player.currentWeapon = new Weapon_LongSword();
        ui.currentWeaponLabel.setText(player.currentWeapon.name);

        ui.northBtn.setText("Trapdoor");
        ui.eastBtn.setText("Table");
        ui.southBtn.setText("Leave");
        ui.southBtn.setText("");

        game.nextPosition1 = "trapDoor";
        game.nextPosition2 = "table";
        game.nextPosition3 = "leave";
        game.nextPosition4 = "";
    }

    public void trapDoor(){
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

    public void leftUnderground(){
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

    public void speakMonster(){
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

    public void wrongRiddle(){
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

    public void correctRiddle(){
        ui.mainTextArea.setText("You solved the monster's riddle correctly. \n\n" +
                "Monster: \"Take this gem as a reward. Good luck on your quest\"");

        ui.outputTextArea.setText("You received a large Gem!");
        ui.item3.setText("Gem");
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

    public void fight(){
        ui.mainTextArea.setText(curMonster.getName() + "(HP): " +  "\n\nWhat will you do?");
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

    public void monsterAttack(SuperMonster monster){
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

    public void playerAttack(){
        System.out.println("You attacked the monster");
//        int playerDamage = new java.util.Random().nextInt(player.currentWeapon.damage);
//
//        ui.outputTextArea.setText("You attacked the " +curMonster.getName() + "and gave " + playerDamage + " damage!");
//
//        curMonster.setHealth(curMonster.getHealth() - playerDamage);
//
//        ui.northBtn.setText(">");
//        ui.eastBtn.setText("");
//        ui.southBtn.setText("");
//        ui.westBtn.setText("");
//        if(curMonster.getHealth()>0)
//        game.nextPosition1 = ">";
//        game.nextPosition2 = "";
//        game.nextPosition3 = "";
//        game.nextPosition4 = "";
    }


//    MIDDLE DOOR

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