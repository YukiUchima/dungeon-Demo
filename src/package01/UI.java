package package01;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;
//import javax.swing.border.LineBorder;

public class UI {

    JFrame window;
    Container container;

//    Title screen panels
    JPanel gameTitlePanel, usernamePanel, passwordPanel, signUpPanel, signInPanel, signPanel;
//    Main Game Panels
    JPanel mainPanel, playerPanel, statsPanel, inventoryPanel, outputPanel, commandPanel;
    JTextArea mainTextArea;
    JLabel gameTitleLbl, usernameLbl, passwordLbl, healthLabel,currentHealthLabel, weaponLabel;
    JLabel currentWeaponLabel, item1Label,item2Label,item3Label,item4Label;
    JTextField usernameTf;
    JPasswordField passwordTf;
    JButton signUpBtn, signInBtn, choice1, choice2,choice3,choice4;

    Font titleFont = new Font("Times New Roman", Font.PLAIN, 60);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 22);
    Font choiceFont = new Font("Times New Roman", Font.PLAIN, 26);
    Font loginFont = new Font("Lucida Grande", Font.PLAIN, 24);

    Border border = new LineBorder(Color.white, 2, true);

    public void createUI(RoomGame.ChoiceHandler msHandler) {
        int width = 1200;
        int height = 900;

//      MAIN WINDOW SCREEN      MAIN WINDOW SCREEN      MAIN WINDOW SCREEN      MAIN WINDOW SCREEN
//      MAIN WINDOW SCREEN      MAIN WINDOW SCREEN      MAIN WINDOW SCREEN      MAIN WINDOW SCREEN
        window = new JFrame();
        window.setSize(width, height);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane()
                .setBackground(Color.black);
        window.setLayout(null);
        container = window.getContentPane();
//        int containerXCenter = width/2
//        container.setBounds();

//      LOGIN SCREEN          LOGIN SCREEN          LOGIN SCREEN          LOGIN SCREEN          LOGIN SCREEN
//      LOGIN SCREEN          LOGIN SCREEN          LOGIN SCREEN          LOGIN SCREEN          LOGIN SCREEN

        //game title panel setup
        int gameTitleWidth = 600;
        int gameTitleHeight = 100;
        int gameTitleXCenter = width/2 - (gameTitleWidth/2);
        gameTitlePanel = new JPanel();
        gameTitlePanel.setBounds(gameTitleXCenter,100,gameTitleWidth,gameTitleHeight);
        gameTitlePanel.setBackground(Color.yellow);

        gameTitleLbl = new JLabel();
        gameTitleLbl.setText("GAME TITLE");
        gameTitleLbl.setForeground(Color.black);
        gameTitleLbl.setFont(titleFont);
        gameTitlePanel.add(gameTitleLbl);

        //username panel setup
        int userNameWidth = 300;
        int userNameHeight = 40;
        int userNameXCenter = width/2 - (userNameWidth/2);
        usernamePanel = new JPanel();
        usernamePanel.setBounds(userNameXCenter, 260, userNameWidth,userNameHeight);
        usernamePanel.setBackground(Color.black);

        usernameLbl = new JLabel();
        usernameLbl.setText("Username");
        usernameLbl.setForeground(Color.white);
        usernameLbl.setFont(loginFont);
        usernamePanel.add(usernameLbl);

        int userTFwidth = 300;
        int userTFheight = 40;
        int userTFXCenter = width/2 - userTFwidth/2;
        usernameTf = new JTextField();
        usernameTf.setBackground(Color.white);
        usernameTf.setFont(loginFont);
        usernameTf.setEditable(true);
        usernameTf.setBounds(userTFXCenter,320, userTFwidth,userTFheight);

        int passwordWidth = 300;
        int passwordHeight = 40;
        int passwordXCenter = width/2 - passwordWidth/2;
        passwordPanel = new JPanel();
        passwordPanel.setBounds(passwordXCenter, 380, passwordWidth,passwordHeight);
        passwordPanel.setBackground(Color.black);

        passwordLbl = new JLabel();
        passwordLbl.setText("Password");
        passwordLbl.setForeground(Color.white);
        passwordLbl.setFont(loginFont);
        passwordPanel.add(passwordLbl);

        int passwordTfWidth = 300;
        int passwordTfheight = 40;
        int passwordTfXCenter = width/2 - passwordTfWidth/2;
        passwordTf = new JPasswordField();
        passwordTf.setBackground(Color.white);
        passwordTf.setEditable(true);
        passwordTf.setFont(loginFont);
        passwordTf.setBounds(passwordTfXCenter,440, passwordTfWidth,passwordTfheight);

        signPanel = new JPanel();
        int signPanelWidth = 400;
        int signPanelXCenter = width/2 - signPanelWidth/2;
        signPanel.setBounds(signPanelXCenter, 500, signPanelWidth, 60);
        signPanel.setLayout(new GridLayout(1,2));
        signPanel.setBackground(Color.black);

        signUpBtn = new JButton("Sign Up");
        signUpBtn.setBackground(new Color(0,0,0));
        signUpBtn.setBorderPainted(false);
        signUpBtn.setForeground(Color.white);
        signUpBtn.setFont(loginFont);
        signUpBtn.setFocusPainted(false);
        signUpBtn.addActionListener(msHandler);
        signUpBtn.setActionCommand("signUp");


        signInBtn = new JButton("Sign In");
        signInBtn.setBackground(Color.black);
        signInBtn.setBorderPainted(false);
        signInBtn.setForeground(Color.white);
        signInBtn.setFont(loginFont);
        signInBtn.setFocusPainted(false);
        signInBtn.addActionListener(msHandler);
        signInBtn.setActionCommand("signIn");
//        signInPanel.add(signInBtn);

        signPanel.add(signUpBtn);
        signPanel.add(signInBtn);

//          GAME SCREEN          GAME SCREEN          GAME SCREEN          GAME SCREEN          GAME SCREEN
//          GAME SCREEN          GAME SCREEN          GAME SCREEN          GAME SCREEN          GAME SCREEN

         mainPanel = new JPanel();
         mainPanel.setBounds(20,20, 600, 400);
         mainPanel.setBackground(Color.lightGray);
         mainPanel.setBorder(border);

         mainTextArea = new JTextArea("Fight Area\nNavigation UI");
         mainTextArea.setBounds(20,20, 560, 560);
         mainTextArea.setBackground(Color.lightGray);
         mainTextArea.setForeground(Color.darkGray);
         mainTextArea.setFont(normalFont);
         mainTextArea.setLineWrap(true);
         mainPanel.add(mainTextArea);

//         `````````````````````````````````````````````````PLAYER Panel```````````````````````````````````````````````
         playerPanel = new JPanel();
         playerPanel.setBounds(620, 20, 400, 400);
         playerPanel.setLayout(null);
         playerPanel.setBackground(Color.darkGray);
         playerPanel.setBorder(border);
//         `````````````````````````````````````````````````STATS Panel```````````````````````````````````````````````
         statsPanel = new JPanel();
         statsPanel.setBounds(10,20, 380, 40);
         statsPanel.setBackground(Color.darkGray);
         statsPanel.setLayout(new GridLayout(1, 4));
         playerPanel.add(statsPanel);
//         `````````````````````````````````````````````````HEALTH Label```````````````````````````````````````````````
         healthLabel = new JLabel("Health: ");
         healthLabel.setFont(normalFont);
         healthLabel.setForeground(Color.white);
         statsPanel.add(healthLabel);

         currentHealthLabel = new JLabel("20");
         currentHealthLabel.setFont(normalFont);
         currentHealthLabel.setForeground(Color.white);
         statsPanel.add(currentHealthLabel);
//         `````````````````````````````````````````````````WEAPON Panel```````````````````````````````````````````````
         weaponLabel = new JLabel("Weapon: ");
         weaponLabel.setFont(normalFont);
         weaponLabel.setForeground(Color.white);
         statsPanel.add(weaponLabel);

         currentWeaponLabel = new JLabel("None");
         currentWeaponLabel.setFont(normalFont);
         currentWeaponLabel.setForeground(Color.white);
         statsPanel.add(currentWeaponLabel);
//         `````````````````````````````````````````````````INVENTORY Panel````````````````````````````````````````````
         inventoryPanel = new JPanel();
         inventoryPanel.setBounds(40,80, 320, 100);
         inventoryPanel.setBackground(Color.darkGray);
         inventoryPanel.setForeground(Color.white);
         inventoryPanel.setLayout(new GridLayout(2,2));
         playerPanel.add(inventoryPanel);

         item1Label = new JLabel("Item1");
         item1Label.setFont(normalFont);
         inventoryPanel.add(item1Label);

         item2Label = new JLabel("Item2");
         item2Label.setFont(normalFont);
         inventoryPanel.add(item2Label);

         item3Label = new JLabel("Item3");
         item3Label.setFont(normalFont);
         inventoryPanel.add(item3Label);

         item4Label = new JLabel("Item4");
         item4Label.setFont(normalFont);
         inventoryPanel.add(item4Label);


//         `````````````````````````````````````````````````OUTPUT Panel```````````````````````````````````````````````
         outputPanel = new JPanel();
         outputPanel.setBounds(20, 420, 600,200);
         outputPanel.setBackground(Color.lightGray);
         outputPanel.setBorder(border);

         commandPanel = new JPanel();
         commandPanel.setBounds(620, 420, 400, 200);
         commandPanel.setBackground(Color.lightGray);
         commandPanel.setBorder(border);
         commandPanel.setLayout(new GridLayout(2,2));

//         `````````````````````````````````````````````````COMMAND Panel```````````````````````````````````````````````
         choice1 = new JButton("Move");
         choice1.setBackground(Color.black);
         choice1.setForeground(Color.white);
         choice1.setFont(choiceFont);
         choice1.setFocusPainted(false);
         choice1.setVisible(true);
//         choice1.addActionListener(choiceHandler);
         choice1.setActionCommand("c1");
         commandPanel.add(choice1);

         choice2 = new JButton("Loot");
         choice2.setBackground(Color.black);
         choice2.setForeground(Color.white);
         choice2.setFont(choiceFont);
         choice2.setFocusPainted(false);
//         choice2.addActionListener(choiceHandler);
         choice2.setActionCommand("c2");
         commandPanel.add(choice2);

         choice3 = new JButton("Quest");
         choice3.setBackground(Color.black);
         choice3.setForeground(Color.white);
         choice3.setFont(choiceFont);
         choice3.setFocusPainted(false);
//         choice3.addActionListener(choiceHandler);
         choice3.setActionCommand("c3");
         commandPanel.add(choice3);

         choice4 = new JButton("-------");
         choice4.setBackground(Color.black);
         choice4.setForeground(Color.white);
         choice4.setFont(choiceFont);
         choice4.setFocusPainted(false);
//         choice4.addActionListener(choiceHandler);
         choice4.setActionCommand("c4");
         commandPanel.add(choice4);



        //add to container
        container.add(mainPanel);
        container.add(playerPanel);
        container.add(outputPanel);
        container.add(commandPanel);
        container.add(usernamePanel);
        container.add(gameTitlePanel);
        container.add(usernameTf);
        container.add(passwordPanel);
        container.add(passwordTf);
        container.add(signPanel);

        window.setVisible(true);
    }
}

