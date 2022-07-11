package package01;

import package03.Weapon_Knife;

public class Story {
    RoomGame game;
    UI ui;
    VisibilityManager vm;
    Player player = new Player();

    public Story(RoomGame g, UI userInterface, VisibilityManager vManager){
        game = g;
        ui = userInterface;
        vm = vManager;
    }

    public void defaultSetup(){
        player.hp = 100;
        ui.currentHealthLabel.setText("" + player.hp);

        player.currentWeapon = new Weapon_Knife();
        ui.currentWeaponLabel.setText(player.currentWeapon.name);
    }
}
