package package02.monsters;

import package02.Char_Type;

 public class Boss1 extends Char_Type {

        String charClassDesc;

        //Constructor
        public Boss1(String name) {
            this.name = name;
            setStrength(6);      //predetermined STRENGTH by char type
            setHealth(8);        //predetermined HEALTH by char type
            setDefense();
        }

        @Override
        public String classType() {
            setCharClass("Bloated Frog Monster");
            charClassDesc = getCharClass() + "\n\t'Slimy frogs that can increase their size at will, croaks can cause disorientation'";
            return charClassDesc;
        }
    }

