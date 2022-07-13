package package01;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RoomGame {
    ChoiceHandler msHandler = new ChoiceHandler();
    UI ui = new UI();
    VisibilityManager vm = new VisibilityManager(ui);
    Story story = new Story(this, ui, vm);

    String nextPosition1, nextPosition2, nextPosition3, nextPosition4;
//

    public static void main(String[] args) {
        new RoomGame();
    }

    public RoomGame() {
        ui.createUI(msHandler); //create window frame
        story.defaultSetup();
        vm.showTitleScreen();   //show login screen
    }

    public class ChoiceHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String yourChoice = e.getActionCommand();

            switch (yourChoice) {
                case "signIn":
                    vm.showGameScreen();
                    break;
                case "c1":
                    story.selectPosition(nextPosition1);
                    break;
                case "c2":
                    story.selectPosition(nextPosition2);
                    break;
                case "c3":
                    story.selectPosition(nextPosition3);
                    break;
                case "c4":
                    story.selectPosition(nextPosition4);
                    break;
                default:
                    break;
            }
        }
    }
}
