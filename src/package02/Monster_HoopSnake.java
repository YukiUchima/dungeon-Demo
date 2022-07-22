package package02;

public class Monster_HoopSnake extends SuperMonster {

        String charClassDesc;
//        String name;

        //Constructor
        public Monster_HoopSnake(String name) {
            setName(name);
            setStrength(6);      //predetermined STRENGTH by char type
            setHealth(45);        //predetermined HEALTH by char type
            setDefense();
        }

        @Override
        public String classType() {
            setCharClass("Monster");
            charClassDesc = getName() + "\n\t'Slept in the chamber slumbering while undisturbed for centuries...'";
            return charClassDesc;
        }
    }

