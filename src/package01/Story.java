package package01;

import package02.monsters.Boss_Troll;
import package02.monsters.Reaper;
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
    RandomEncounter randMonster = new RandomEncounter();

//    int enteredLeft = 0;
    int byPassEncounter = 0;
//    int currentBattle = 0;
    int winBattle = 0;

    String saveLocation = null;
    String currentLocation = null;
    SuperMonster curMonster = null;

    //-----------------------Start of progressKey Vals-----------------------
    static int hasTalisman;
    static int hasMap;
    static int hasMonsterKey;
    static int hasHiddenTreasure;
    static int enteredDungeon;
    static int westTrollDefeated;
    static int candle;
    static int trapDoorKey;
    static int hiddenWpn;
    static int enteredWestRoom;
    static int enteredMainEntrance;
    static int bossEncountered;
    static int acceptedQuest;
    Boss_Troll troll;
    ArrayList<String> itemList = new ArrayList<>();

    static int[] progressKey = new int[]{hasTalisman, hasMap};
    //We also need to include player.hp


    //-----------------------End of progressKey Vals-------------------------

    public Story(RoomGame g, UI userInterface, VisibilityManager vManager){
        game = g;
        ui = userInterface;
        vm = vManager;
    }

    public void setLocation(String saveLoc){
        saveLocation = saveLoc;
    }
    public void defaultSetup(){
        player.hp = 100;

        hasTalisman = 0;
        hasMap = 0;
        hasMonsterKey = 0;
        hasHiddenTreasure = 0;
        enteredDungeon = 0;
        westTrollDefeated = 0;
        candle = 0;
        trapDoorKey = 0;
        hiddenWpn = 0;
        enteredWestRoom = 0;
        bossEncountered = 0;
        enteredMainEntrance = 0;
        acceptedQuest = 0;

        ui.currentHealthLabel.setText("" + player.hp);
        String introduction = "Welcome to our first text adventure game! This is the main console screen.\n" +
                "\n\n+On the right is the player's panel" +
                "\n\n+Below is an output panel where you will find hints and directions to help you." +
                "\n\n+On the bottom right, you have the option to save/quit, as well as the game's command console.";
        ui.mainTextArea.setText(introduction);
        ui.outputTextArea.setText("You shall find messages here to help you during your adventure." +
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

        ui.inventoryTitleLabel.setText("INVENTORY");
        ui.item1.setText("");
        ui.item2.setText("");
        ui.item3.setText("");
        ui.item4.setText("");
        ui.item5.setText("");
        ui.item6.setText("");
        ui.item7.setText("");
        ui.item8.setText("");
    }

    public void selectPosition(String nextPosition){

        switch(nextPosition){
            //    WEST ROOM
            case "dungeonEntrance":
                dungeonEntrance();
                break;
//            case "mainDoor":
//                openDoor();
//                break;
            case "mainRoom":
                mainRoom();
                break;
            case "battleReaper":
                battleReaper();
                break;
            case "quest":
                quest();
                break;
            case "turnBack":
                turnBack();
                break;
            case "westRoomEncounter":
                currentLocation = "westRoom";
                monsterEncounter();
                break;
            case "midRoomEncounter":
                currentLocation = "midRoom";
                monsterEncounter();
                break;
            case "eastRoomEncounter":
                currentLocation = "eastRoom";
                monsterEncounter();
                break;
            case "eastRoom":
                eastRoom();
                break;
            case "table":
                westRoomTable();
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
            case "westUnderground":
                westUnderground();
                break;
            case "fightWestBoss":
                bossFight();
                break;
            case "playerAttack":
                playerAttack();
                break;
            case "monsterAttack":
                monsterAttack();
                break;
            case "speakMonster":
                speakTroll();
                break;
            case "correctRiddle":
                correctRiddle();
                break;
            case "wrongRiddle":
                wrongRiddle();
                break;
            case "run":
                run();
                break;
            case "lose":
                lose();
                break;
            case "exit":
                defaultSetup();
                vm.showTitleScreen();
                break;
            case "save":
                save();
                break;

//    MIDDLE DOOR ------------------------------------------------------------------------------------------ MIDDLE DOOR
//    MIDDLE DOOR ------------------------------------------------------------------------------------------ MIDDLE DOOR
            case "midRoom":
                midRoom();
                break;
            case "lake":
                lake();
                break;
            case "hiddenStairway":
                hiddenStairway();
                break;
            case "altar":
                altar();
                break;
            case "talisman":
                talisman();
                break;
            case "hiddenTreasure":
                hiddenTreasure();
                break;

//    RIGHT DOOR -------------------------------------------------------------------------------------------- RIGHT DOOR
            case "westRoom":
                westRoom();
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
    //    Locations -- Text Area Story Line ---------------------------------------------------------------------------
    public void dungeonEntrance(){
        ui.mainTextArea.setText("You realize the daylight has past quickly - it is dark as you approach the door. " +
                "\n\nAround the door you see brush and rocks, the path ends here, with trees around blocking your view except the door. " +
                "\n\nOnly way forward is through this heavy steel door, between the ominous, lowly lit torches");

        ui.outputTextArea.setText("");

        ui.northBtn.setText("North");
        ui.eastBtn.setText("");
        ui.southBtn.setText("South");
        ui.westBtn.setText("");

        game.nextPosition1 = "mainRoom";
        game.nextPosition2 = "";
        game.nextPosition3 = "turnBack";
        game.nextPosition4 = "";
    }

    public void mainRoom() {
        currentLocation = "mainRoom";
        if (enteredMainEntrance < 1) {
            ui.mainTextArea.setText("You Entered into the main dungeon room.\n\n A ghostly figure appears before you and...floats towards you." +
                    "\n\nReaper: 'For you to continue forward, you must accept my quest or face the unknown... '");

            enteredMainEntrance = 1;
            ui.outputTextArea.setText("You must decide to accept or refuse the Reaper");

            ui.northBtn.setText("Accept");
            ui.eastBtn.setText("");
            ui.southBtn.setText("Refuse!");
            ui.westBtn.setText("");

            game.nextPosition1 = "quest";
            game.nextPosition2 = "";
            game.nextPosition3 = "battleReaper";
            game.nextPosition4 = "";
        } else if(acceptedQuest != 0){
            ui.mainTextArea.setText("\"The Reaper vaporized in to thin air... what will you do next?\n\n" +
                    "There are three doors:" +
                    "\n  Left door (WEST)" +
                    "\n  Middle Door (NORTH)" +
                    "\n  Right Door (EAST)");
            ui.northBtn.setText("North");
            ui.eastBtn.setText("East");
            ui.southBtn.setText("South");
            ui.westBtn.setText("West");

            game.nextPosition1 = "midRoomEncounter";
            game.nextPosition2 = "eastRoomEncounter";
            game.nextPosition3 = "exit";
            game.nextPosition4 = "westRoomEncounter";
        }else {
            ui.mainTextArea.setText("You returned to the main dungeon room\nWhich way do you want to go?...");
            ui.northBtn.setText("North");
            ui.eastBtn.setText("East");
            ui.southBtn.setText("South");
            ui.westBtn.setText("West");

            game.nextPosition1 = "midRoomEncounter";
            game.nextPosition2 = "eastRoomEncounter";
            game.nextPosition3 = "exit";
            game.nextPosition4 = "westRoomEncounter";
        }
    }

    public void quest(){
        acceptedQuest = 1;
        ui.mainTextArea.setText("Reaper: 'The unknown paths are through each of the three doors... Will you survive?'");

        ui.outputTextArea.setText("Continue to see what awaits you on your Quest");

        ui.northBtn.setText(">");
        ui.eastBtn.setText("");
        ui.southBtn.setText("");
        ui.westBtn.setText("");

        game.nextPosition1 = currentLocation;
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void turnBack(){
        ui.mainTextArea.setText("You are deciding to abandon the story... would you like to quit or enter the dungeon?");

        ui.northBtn.setText("Enter");
        ui.eastBtn.setText("");
        ui.southBtn.setText("Quit");
        ui.westBtn.setText("");

        game.nextPosition1 = "mainRoom";
        game.nextPosition2 = "";
        game.nextPosition3 = "exit";
        game.nextPosition4 = "";

    }

//    WEST DOOR         LEFT DOOR                  LEFT DOOR                  LEFT DOOR         ------------------------
//    WEST DOOR         LEFT DOOR                  LEFT DOOR                  LEFT DOOR         ------------------------
    public void westRoom() {
        if(bossEncountered != 0){
            westTrollDefeated=1;
        }
        if (enteredWestRoom == 0) {
            ui.mainTextArea.setText("You decide to walk cautiously to the left door and look around you. \n\n    You" +
                    " see a note on a table to the WEST.\n    You see a wardrobe to the EAST.\n    North of you is a " +
                    "trapdoor before you reach the north wall.");
            ui.outputTextArea.setText("Explore this room in order to progress.");
            enteredWestRoom = 1;
            ui.northBtn.setText("North");
            ui.eastBtn.setText("East");
            ui.southBtn.setText("South");
            ui.westBtn.setText("West");

            game.nextPosition1 = "trapDoor";
            game.nextPosition2 = "wardrobe";
            game.nextPosition3 = "mainRoom";
            game.nextPosition4 = "table";
        }else if(westTrollDefeated != 0 && hiddenWpn != 0){
            ui.mainTextArea.setText("You have returned to the west room.\n\n" +
                    "It appears you have accomplished all you can here.");
            hasMonsterKey=1;

            ui.northBtn.setText("");
            ui.eastBtn.setText("");
            ui.southBtn.setText("Return");
            ui.westBtn.setText("");

            game.nextPosition1 = "";
            game.nextPosition2 = "";
            game.nextPosition3 = "mainRoom";
            game.nextPosition4 = "";
        }else{
            ui.mainTextArea.setText("You have returned to the west room.\n\n" +
                    "You may find something here...");
            ui.northBtn.setText("North");
            ui.eastBtn.setText("East");
            ui.southBtn.setText("South");
            ui.westBtn.setText("West");

            game.nextPosition1 = "trapDoor";
            game.nextPosition2 = "wardrobe";
            game.nextPosition3 = "mainRoom";
            game.nextPosition4 = "table";
        }
    }

    public void westRoomTable(){
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
            ui.eastBtn.setText("Drawer");
            ui.southBtn.setText("Leave");
            ui.westBtn.setText("");

            game.nextPosition1 = "trapDoor";
            game.nextPosition2 = "hidden";
            game.nextPosition3 = "westRoom";
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
            game.nextPosition3 = "westRoom";
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

            ui.northBtn.setText("Open");
            ui.eastBtn.setText("Wardrobe");
            ui.southBtn.setText("Leave");
            ui.westBtn.setText("Table");

            game.nextPosition1 = "westUnderground";
            game.nextPosition2 = "wardrobe";
            game.nextPosition3 = "mainRoom";
            game.nextPosition4 = "table";

        }else if(trapDoorKey < 1){
            ui.mainTextArea.setText("You find that the trapdoor is locked...\n");
            ui.outputTextArea.setText("Hint: You may need to search...");
            ui.northBtn.setText("Table");
            ui.eastBtn.setText("Wardrobe");
            ui.southBtn.setText("Leave");
            ui.westBtn.setText("");

            game.nextPosition1 = "table";
            game.nextPosition2 = "wardrobe";
            game.nextPosition3 = "mainRoom";
            game.nextPosition4 = "";
        }else{
            ui.mainTextArea.setText("It will be too dark to enter...\n");
            ui.outputTextArea.setText("Hint: You may need to search...");
            ui.northBtn.setText("Table");
            ui.eastBtn.setText("Wardrobe");
            ui.southBtn.setText("Leave");
            ui.westBtn.setText("");

            game.nextPosition1 = "table";
            game.nextPosition2 = "wardrobe";
            game.nextPosition3 = "mainRoom";
            game.nextPosition4 = "";
        }
    }

    public void westUnderground(){
        ui.mainTextArea.setText("You walked down with the sound of stone steps of a cold chamber. You approach " +
                "the end of this stairway to a large open, chamber.\n\nTroll: \"Who disturbs me?!\"");
        bossEncountered = 1;
        ui.outputTextArea.setText("You have encountered a beast!");

        ui.northBtn.setText("Fight");
        ui.eastBtn.setText("Speak");
        ui.southBtn.setText("");
        ui.westBtn.setText("");

        game.nextPosition1 = "fightWestBoss";
        game.nextPosition2 = "speakTroll";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void speakTroll(){
        ui.mainTextArea.setText("The Troll is taken aback you are speaking to them...\n\n" +
                "Monster: \"Solve my riddle and I shall bestow upon thee a gift.\"" +
                "\n\n    What exists while hidden, but ceases to exist when revealed?");

        ui.outputTextArea.setText("Hint: Solve the riddle to face the consequences...");
        ui.northBtn.setText("Thoughts");
        ui.eastBtn.setText("Promises");
        ui.southBtn.setText("Secrets");
        ui.westBtn.setText("");

        game.nextPosition1 = "wrongRiddle";
        game.nextPosition2 = "wrongRiddle";
        game.nextPosition3 = "correctRiddle";
        game.nextPosition4 = "";
    }

    public void wrongRiddle(){
        ui.mainTextArea.setText("You failed to answer the riddle correctly. The troll towers over you with a an angry look..." +
                "\n\n Brace yourself for a fight!");

        ui.outputTextArea.setText("Hint: You must defeat him!");
        ui.northBtn.setText(">");
        ui.eastBtn.setText("");
        ui.southBtn.setText("");
        ui.westBtn.setText("");

        game.nextPosition1 = "fightWestBoss";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void correctRiddle(){
        ui.mainTextArea.setText("You solved the monster's riddle correctly. \n\n" +
                "Monster: \"Take this gem as a reward. Good luck on your quest\"");

        ui.outputTextArea.setText("You received a large Gem!");
        ui.item3.setText("Gem");
        hasMonsterKey = 1;


        ui.northBtn.setText("Return");
        ui.eastBtn.setText("");
        ui.southBtn.setText("");
        ui.westBtn.setText("");

        game.nextPosition1 = "mainRoom";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

//  North DOOR         Middle DOOR                  BUTHAINA                  Middle DOOR         ------------------------
//  North DOOR         Middle DOOR                  BUTHAINA                  Middle DOOR         ------------------------

    public void midRoom() {

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

            ui.northBtn.setText("");
            ui.eastBtn.setText("");
            ui.southBtn.setText("Return");
            ui.westBtn.setText("");

            game.nextPosition1 = "";
            game.nextPosition2 = "";
            game.nextPosition3 = "mainRoom";
            game.nextPosition4 = "";

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
    }

    public void altar() {
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

            game.nextPosition1 = "midRoom";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
    }

    public void hiddenStairway() {
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
    }

    public void talisman() {
        hasTalisman = 1;
        ui.mainTextArea.setText("As you open the door, the inside reveals a bright object "
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

    }

    public void lake() {

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
        game.nextPosition3 = "midRoom";
        game.nextPosition4 = "";

    }

    public void hiddenTreasure() {
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
    }



// EAST ROOM -------------------MITSUAKI ----------------------------------------------------------------------EAST ROOM
// EAST ROOM -------------------MITSUAKI ----------------------------------------------------------------------EAST ROOM


    public void eastRoom() {
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
            game.nextPosition3 = "midRoom";
            game.nextPosition4 = "";
        }
    }

    public void rightTableNoMap() {
        ui.outputTextArea.setText("You decide to not take the map.");

        ui.northBtn.setText(">");
        ui.eastBtn.setText("");
        ui.southBtn.setText("");
        ui.westBtn.setText("");

        game.nextPosition1 = "westRoom";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void receiveMap() {
        ui.outputTextArea.setText("You have received a map of the 'Secret Lake'");

        hasMap = 1;
        ui.item4.setText("Map");

        ui.northBtn.setText(">");
        ui.eastBtn.setText("");
        ui.southBtn.setText("");
        ui.westBtn.setText("");

        game.nextPosition1 = "westRoom";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }


//    FIGHT SIMULATION -------------------------------------------------------------------------------------------------
//    FIGHT SIMULATION -------------------------------------------------------------------------------------------------
    public void run(){
        int runAway = new java.util.Random().nextInt(100);
        if(runAway > 40){
            ui.outputTextArea.setText("You successfully escaped! \n\n You may continue your Journey.");
            game.nextPosition1 = currentLocation;

        }else{
            ui.outputTextArea.setText(curMonster.getName() + " health: " + curMonster.getHealth() +
                    "\n\nYou failed to escape! The monster attacks!");
            game.nextPosition1 = "monsterAttack";
        }
        ui.northBtn.setText(">");
        ui.eastBtn.setText("");
        ui.southBtn.setText("");
        ui.westBtn.setText("");

        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }


    public void bossFight(){
        currentLocation = "westRoom";
        Boss_Troll troll = new Boss_Troll();
        curMonster = troll;
        ui.mainTextArea.setText("You are in a boss battle with " + curMonster.getName() + " (HP): " + curMonster.getHealth() +  "\n\nThere's no escape!");
        ui.outputTextArea.setText("");

        ui.northBtn.setText("Attack");
        ui.eastBtn.setText("");
        ui.southBtn.setText("");
        ui.westBtn.setText("");

        game.nextPosition1 = "playerAttack";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";

    }

    public void battleReaper(){
        currentLocation = "mainRoom";
        Reaper reaper = new Reaper();
        curMonster = reaper;
        ui.mainTextArea.setText("The " + curMonster.getName() + " confronts you!\n\nThere's no escape!");
        ui.outputTextArea.setText("");

        ui.northBtn.setText("Attack");
        ui.eastBtn.setText("");
        ui.southBtn.setText("");
        ui.westBtn.setText("");

        game.nextPosition1 = "playerAttack";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";

    }

    public void monsterEncounter() {

        if (randMonster.monsterSpawned()) {
            curMonster = randMonster.monster();

            ui.mainTextArea.setText(curMonster.getName() + "(HP: " + curMonster.getHealth() +") appeared!" +
                    "\n\nWhat will you do?");

            ui.outputTextArea.setText("You can choose to attack or run...");

            ui.northBtn.setText("Attack");
            ui.eastBtn.setText("Run");
            ui.southBtn.setText("");
            ui.westBtn.setText("");

            game.nextPosition1 = "playerAttack";
            game.nextPosition2 = "run";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }else{
            switch (currentLocation){
                case "westRoom":
                    westRoom();
                    break;
                case "midRoom":
                    midRoom();
                    break;
                case "eastRoom":
                    eastRoom();
                    break;
                default:
                    mainRoom();
                    break;
            }
        }

    }

    public void monsterAttack(){
        System.out.println("The Monster Attacked!");
        int monsterDamage = curMonster.attack();
        System.out.println("Monster damage: " + monsterDamage);
        if(monsterDamage < 1){
            ui.mainTextArea.setText(curMonster.getName() + "'s attack missed!");
        }else{
            ui.mainTextArea.setText(curMonster.getAttackMsg() + " \n\t" +  monsterDamage + " damage was inflicted!");
            player.hp -= monsterDamage;
            if(player.hp < 0){
                player.hp = 0;
            }
        }

        ui.currentHealthLabel.setText("" + player.hp);
        ui.northBtn.setText(">");
        ui.eastBtn.setText("");
        ui.southBtn.setText("");
        ui.westBtn.setText("");

        if (player.hp > 0) {
            game.nextPosition1 = "playerAttack";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        } else {
            game.nextPosition1 = "lose";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
    }

    public void playerAttack(){
        System.out.println("You attacked the monster with your " + player.currentWeapon.name + "!");
        int playerDamage = new java.util.Random().nextInt(player.currentWeapon.damage);
        if(playerDamage > 0) {
            curMonster.hit(playerDamage);
            ui.mainTextArea.setText("You attacked the monster with your " + player.currentWeapon.name + " and inflicted " + playerDamage + " damage!");
        }else{
            ui.mainTextArea.setText("You tried to attack with your " + player.currentWeapon.name + " but missed!");
        }

        ui.outputTextArea.setText(curMonster.getName() + " health: " + curMonster.getHealth() +
                "\n\n");
        ui.northBtn.setText(">Continue");
        ui.eastBtn.setText("");
        ui.southBtn.setText("");
        ui.westBtn.setText("");

        if (curMonster.getHealth() > 0) {
            game.nextPosition1 = "monsterAttack";
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        } else {
            randMonster.monsterSetup();
            game.nextPosition1 = currentLocation;
            game.nextPosition2 = "";
            game.nextPosition3 = "";
            game.nextPosition4 = "";
        }
    }

    public void save() {
        System.out.println("Game saved...");

        ui.outputTextArea.setText("Game has been saved...");

        ui.northBtn.setText("Main Menu");
        ui.eastBtn.setText("");
        ui.southBtn.setText("");
        ui.westBtn.setText("");

        game.nextPosition1 = "exit";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

    public void lose() {
        ui.mainTextArea.setText("You lost the battle and must start over...");
        ui.northBtn.setText(">");
        ui.eastBtn.setText("");
        ui.southBtn.setText("");
        ui.westBtn.setText("");

        game.nextPosition1 = "exit";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }

//    public static void main(String [] args) {
//        String progressKey = "30";
//
//        readProgressKey(progressKey);
//    }














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