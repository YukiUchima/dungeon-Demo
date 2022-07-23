package package01;

import package02.Monster_HoopSnake;

import package02.SuperMonster;

import javax.management.MalformedObjectNameException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import package02.Monster_HoopSnake;


import package02.SuperMonster;

public class RandomEncounter {
    private static ArrayList<SuperMonster> monsters;

    public void monsterSetup() {
//        Assigning various monsters to choose from randomly
        Random rand = new Random();

        monsters = new ArrayList<>();

        Monster_HoopSnake hoopSnake1 = new Monster_HoopSnake("Monster1");
        Monster_HoopSnake hoopSnake2 = new Monster_HoopSnake("secondMOnster");
        Monster_HoopSnake hoopSnake3 = new Monster_HoopSnake("ThirdMOnster");
        Monster_HoopSnake hoopSnake4 = new Monster_HoopSnake("4thMOnster");
        Monster_HoopSnake hoopSnake5 = new Monster_HoopSnake("5thMonster");

        monsters.add(hoopSnake1);
        monsters.add(hoopSnake2);
        monsters.add(hoopSnake3);
        monsters.add(hoopSnake4);
        monsters.add(hoopSnake5);
    }

    public boolean monsterSpawned(){
        Random rand = new Random();
        int chance = rand.nextInt(100);
        if(chance > 75){return true;}
        return false;
    }

    public SuperMonster monster(){
        Collections.shuffle(monsters);
        return monsters.get(0);
    }
}
