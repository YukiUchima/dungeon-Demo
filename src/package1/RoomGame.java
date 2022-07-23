package package1;

import javax.swing.*;

import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.xml.crypto.Data;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RoomGame {
    ChoiceHandler msHandler = new ChoiceHandler();
    //SaveHandler svHandler = new SaveHandler();
    UI ui = new UI();
    VisibilityManager vm = new VisibilityManager(ui);
    Story story = new Story(this, ui, vm);
    RandomEncounter monsterEncounter = new RandomEncounter();

    String nextPosition1, nextPosition2, nextPosition3, nextPosition4;
    
//

    public static void main(String[] args) {
        new RoomGame();
    }

    public RoomGame() {
//        db.initializeDatabase();              //creates database using postGres
        ui.createUI(msHandler);                 //create window frame
        Story.defaultSetup();                   //default setup
        vm.showTitleScreen();                   //show login screen
        monsterEncounter.monsterSetup();        //setup monsters
    }
   /*
    public class SaveHandler implements ActionListener{
    	
    	@Override
    	public void actionPerformed(ActionEvent e) {
    		Database.main(null);
    		Database.save();
    		
    		
    		
    		
    	}
    }
    */
    public class ChoiceHandler implements ActionListener {
    	
    	

        @Override
        public void actionPerformed(ActionEvent e) {
        	String username = ui.usernameTf.getText();
        	
        	String password = ui.passwordTf.getText();
        	
            String yourChoice = e.getActionCommand();

            switch (yourChoice) {
                case "signIn":
                	vm.showGameScreen();
                    Database.main(null);
                    Database.logIn(username, password);
                    //if(Database.logIn(username, password) == 1) {
                    	//vm.showGameScreen();
                    //}
                    
                    break;
                case "signUp":
                	vm.showGameScreen();
                	Database.main(null);
                	Database.signUp(username, password);
                	//if (Database.signUp(username, password) == 1) {
                		//vm.showGameScreen();
                	//}
                	
                	break;
                //case "quit":
                	//main(null);
                    //Story.defaultSetup();
                    //vm.showTitleScreen();
                case "save":
                	Database.main(null);
                    Database.save(username, password, Story.getLocation(), 
                    		Player.getHP());
                    break;
                case "c1":
                    story.setLocation(nextPosition1);
                    Story.selectPosition(nextPosition1);
                    break;
                case "c2":
                    story.setLocation(nextPosition2);
                    Story.selectPosition(nextPosition2);
                    break;
                case "c3":
                    story.setLocation(nextPosition3);
                    Story.selectPosition(nextPosition3);
                    break;
                case "c4":
                    story.setLocation(nextPosition4);
                    Story.selectPosition(nextPosition4);
                    break;
                default:
                    break;
            }
        }
    }
}
