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

//        Story story = new Story(this, ui, vm);

    public static void main(String[] args) {
        new RoomGame();
    }

    public RoomGame() {
        ui.createUI(msHandler); //create window frame
        vm.showTitleScreen();   //show login screen
    }

    public class ChoiceHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String yourChoice = e.getActionCommand();

            switch (yourChoice) {
                case "start":
                    vm.showGameScreen();
                    break;
                case "c1":
                    break;
                case "c2":
                    break;
                case "c3":
                    break;
                case "c4":
                    break;
                case "signIn":
                    vm.showGameScreen();
                    break;
                default:
                    break;
            }
        }
    }
}




//        window = new JFrame();
//        window.setSize(1200,700);
//        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        window.getContentPane().setBackground(Color.white);
//        window.setLayout(null);
//        con = window.getContentPane();
//
//        loginPanel = new JPanel();
//        loginPanel.setBounds(450,250, 100, 50);
//        loginPanel.setBackground(Color.darkGray);
//        loginPanel.setLayout(new GridLayout(1,1));
//
////        userLabel = new JLabel("Username");
////        userLabel.setBorder(new EmptyBorder(0,20,0,0));
////        userLabel.setBounds(10,10, 180, 100);
////        userLabel.setForeground(Color.BLACK);
////        userLabel.setFont(commonFont);
////        loginPanel.add(userLabel);
//
////        userField = new JTextField();
////        userField.setFont(commonFont);
////        userField.setEditable(true);
////        loginPanel.add(userField);
////
////        passwordLabel = new JLabel("\tPassword");
////        passwordLabel.setBorder(new EmptyBorder(0,20,0,0));
////        passwordLabel.setBackground(Color.BLACK);
////        passwordLabel.setFont(commonFont);
////        loginPanel.add(passwordLabel);
////
////        passwordField = new JTextField();
////        passwordField.setFont(commonFont);
////        passwordField.setEditable(true);
////        loginPanel.add(passwordField);
//
//        loginBtn = new JButton("Login");
//        loginBtn.setForeground(Color.CYAN);
//        loginBtn.setFont(commonFont);
//        loginBtn.setBackground(Color.darkGray);
//        loginBtn.setFocusPainted(false);
//        loginBtn.addActionListener(loginHandler);
//        loginPanel.add(loginBtn);
//
//        con.add(loginPanel);
//        window.setVisible(true);
//    }
//
//
//     public void GameScreen(){
//
//         mainPanel = new JPanel();
//         mainPanel.setBounds(20,20, 600, 400);
//         mainPanel.setBackground(Color.lightGray);
//         mainPanel.setBorder(border);
//
//         mainTextArea = new JTextArea("Fight Area\nNavigation UI");
//         mainTextArea.setBounds(20,20, 560, 560);
//         mainTextArea.setBackground(Color.lightGray);
//         mainTextArea.setForeground(Color.darkGray);
//         mainTextArea.setFont(mainText);
//         mainTextArea.setLineWrap(true);
//         mainPanel.add(mainTextArea);
//
////         `````````````````````````````````````````````````PLAYER Panel```````````````````````````````````````````````
////         `````````````````````````````````````````````````PLAYER Panel```````````````````````````````````````````````
//         playerPanel = new JPanel();
//         playerPanel.setBounds(620, 20, 400, 400);
//         playerPanel.setLayout(null);
//         playerPanel.setBackground(Color.darkGray);
//         playerPanel.setBorder(border);
//
//         statsPanel = new JPanel();
//         statsPanel.setBounds(10,20, 380, 40);
//         statsPanel.setBackground(Color.green);
//         statsPanel.setLayout(new GridLayout(1, 4));
//         playerPanel.add(statsPanel);
//
//         healthLabel = new JLabel("Health: ");
//         healthLabel.setFont(statsFont);
//         healthLabel.setForeground(Color.white);
//         statsPanel.add(healthLabel);
//
//         currentHealthLabel = new JLabel("" + playerHP);
//         currentHealthLabel.setFont(statsFont);
//         currentHealthLabel.setForeground(Color.white);
//         statsPanel.add(currentHealthLabel);
//
////         keyItemPanel = new JPanel();
////         keyItemPanel.setBounds(10,20, 380, 40);
//
//         weaponLabel = new JLabel("Weapon: ");
//         weaponLabel.setFont(statsFont);
//         weaponLabel.setForeground(Color.white);
//         statsPanel.add(weaponLabel);
//
//         currentWeaponLabel = new JLabel("None");
//         currentWeaponLabel.setFont(statsFont);
//         currentWeaponLabel.setForeground(Color.white);
//         statsPanel.add(currentWeaponLabel);
//
//         inventoryPanel = new JPanel();
//         inventoryPanel.setBounds(40,80, 320, 100);
//         inventoryPanel.setBackground(Color.green);
//         inventoryPanel.setForeground(Color.white);
//         inventoryPanel.setLayout(new GridLayout(2,2));
//         playerPanel.add(inventoryPanel);
//
//         item1Label = new JLabel("Item1");
//         item1Label.setFont(statsFont);
//         inventoryPanel.add(item1Label);
//
//         item2Label = new JLabel("Item2");
//         item2Label.setFont(statsFont);
//         inventoryPanel.add(item2Label);
//
//         item3Label = new JLabel("Item3");
//         item3Label.setFont(statsFont);
//         inventoryPanel.add(item3Label);
//
//         item4Label = new JLabel("Item4");
//         item4Label.setFont(statsFont);
//         inventoryPanel.add(item4Label);
//
//
////         `````````````````````````````````````````````````
//         outputPanel = new JPanel();
//         outputPanel.setBounds(20, 420, 600,180);
//         outputPanel.setBackground(Color.lightGray);
//         outputPanel.setBorder(border);
//
//         commandPanel = new JPanel();
//         commandPanel.setBounds(620, 420, 400, 180);
//         commandPanel.setBackground(Color.lightGray);
//         commandPanel.setBorder(border);
//         commandPanel.setLayout(new GridLayout(2,2));
//
//         choice1 = new JButton("Choice A");
//         choice1.setBackground(Color.black);
//         choice1.setForeground(Color.white);
//         choice1.setFont(commandFont);
//         choice1.setFocusPainted(false);
//         choice1.setVisible(false);
////         choice1.addActionListener(choiceHandler);
//         choice1.setActionCommand("c1");
//         commandPanel.add(choice1);
//
//         choice2 = new JButton("Choice B");
//         choice2.setBackground(Color.black);
//         choice2.setForeground(Color.white);
//         choice2.setFont(commandFont);
//         choice2.setFocusPainted(false);
////         choice2.addActionListener(choiceHandler);
//         choice2.setActionCommand("c2");
//         commandPanel.add(choice2);
//
//         choice3 = new JButton("Choice C");
//         choice3.setBackground(Color.black);
//         choice3.setForeground(Color.white);
//         choice3.setFont(commandFont);
//         choice3.setFocusPainted(false);
////         choice3.addActionListener(choiceHandler);
//         choice3.setActionCommand("c3");
//         commandPanel.add(choice3);
//
//         choice4 = new JButton("Choice D");
//         choice4.setBackground(Color.black);
//         choice4.setForeground(Color.white);
//         choice4.setFont(commandFont);
//         choice4.setFocusPainted(false);
////         choice4.addActionListener(choiceHandler);
//         choice4.setActionCommand("c4");
//         commandPanel.add(choice4);
//
//
//
//         con.add(mainPanel);
//         con.add(playerPanel);
//         con.add(outputPanel);
//         con.add(commandPanel);
//
//    }
//
//    public void playerSetup(){
//        playerHP = 100;
//        wpn = "None";
//
//
//    }
//    public class LoginScreenHandler implements ActionListener{
//
//        public void actionPerformed(ActionEvent event){
//            loginPanel.setVisible(false);
//
//
//            GameScreen();
//        }
//    }
////
////    public class ChoiceButtonHandler implements ActionListener{
////
////        public void actionPerformed(Action event){
////            String yourChoice = event.getActionCommand();
////        }
////    }
//
//
//
//
//}
