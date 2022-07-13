package package02.monsters;

import package02.Char_Type;

 public class Boss1 extends Char_Type {

        String charClassDesc;

        //Constructor
        public Boss1(String name) {
            this.name = name;
            setStrength(6);      //predetermined STRENGTH by char type
            setHealth(45);        //predetermined HEALTH by char type
            setDefense();
        }

        @Override
        public String classType() {
            setCharClass("Monster");
            charClassDesc = getCharClass() + "\n\t'Slept in the chamber slumbering while undisturbed for centuries...'";
            return charClassDesc;
        }
    }

