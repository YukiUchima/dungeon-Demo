package package01;

public class VisibilityManager {
    UI ui;

    public VisibilityManager(UI userInterface){
        ui = userInterface;
    }

    public void showTitleScreen(){
//        Show title screen
        ui.gameTitlePanel.setVisible(true);
        ui.usernamePanel.setVisible(true);
        ui.passwordPanel.setVisible(true);
        ui.signPanel.setVisible(true);

//        Hide game screen

        ui.mainPanel.setVisible(false);
        ui.playerPanel.setVisible(false);
        ui.statsPanel.setVisible(false);
        ui.inventoryPanel.setVisible(false);
        ui.outputPanel.setVisible(false);
        ui.commandPanel.setVisible(false);
    }

    public void showGameScreen(){
//        Show Game screen
        ui.mainPanel.setVisible(true);
        ui.playerPanel.setVisible(true);
        ui.statsPanel.setVisible(true);
        ui.inventoryPanel.setVisible(true);
        ui.outputPanel.setVisible(true);
        ui.commandPanel.setVisible(true);

//       Hide Title screen
        ui.gameTitlePanel.setVisible(false);
        ui.usernamePanel.setVisible(false);
        ui.passwordPanel.setVisible(false);
        ui.signPanel.setVisible(false);

    }
}
