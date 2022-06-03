
package game;

import java.util.Random;

/**
* @author Jade Thompson-Tavai
 * Student ID: 20108594
 */
public class Battle {
    
    public static Random rand = new Random();
    public static Enemy opp;
    public static Player pc;
    public static GUI g;
    
    public static void startBattle(Player player, Enemy enemy){
        pc = player;
        opp = enemy;
        g = GameLogic.gameGui;
        String enemyStats = opp.name + " HP: " + opp.getHp();
        String pcStats =  player.name + " HP: " + player.getHp();
        g.playerStats.setText(pcStats);
        g.enemyStats.setText(enemyStats);
        g.battleText.setText("A " + enemy.name + " blocks your path! What do you want to do?");
        g.fightBtn.setVisible(true);
        g.runBtn.setVisible(true);
        g.battleEndedContinueBtn.setVisible(false);

        g.battleStart();
          
    }
    
     public static void fight(){
                   int dmgDealt = attack();
                   String dmg = "You dealt " + dmgDealt + " damage to the enemy!\n";
                   opp.hp -= dmgDealt;
                   int dmgTaken = attack();
                    dmg += "The enemy dealt " + dmgTaken + " damage to you!";
                   pc.hp -= dmgTaken;
                   g.battleText.setText(dmg);
                   g.playerStats.setText(pc.name + " HP: "+pc.hp);
                   if(opp.hp <= 0)
                        g.enemyStats.setText(opp.name + " HP: 0");

                    g.enemyStats.setText(opp.name + " HP: "+opp.hp);


                   //if player wins
                   if(opp.hp <= 0)
                   {
                       String win = "You have defeated the " + opp.getName() +"! You gained " + opp.getXp() + "xp points!";
                       g.battleText.setText(win);
                       pc.win(pc, opp.getXp());
                       g.fightBtn.setVisible(false);
                       g.runBtn.setVisible(false);
                       g.battleEndedContinueBtn.setVisible(true);
                   }

                   //if plaver loses
                   else if(pc.getHp() <= 0){
                       Player.death(opp.getName());
                   }
              

     }
     
     public static boolean  escape(Player player){
                 g = GameLogic.gameGui;

                   int escapeChance = rand.nextInt(100);
                   //success
                   if(escapeChance > 50){
                       System.out.println("You successfully escaped!");
                       return true;
                   }
                   //fail
                   else{
                       String dmg ="You cannot escape!";
                      int dmgTaken = attack();
                        dmg += "The enemy dealt " + dmgTaken + " damage to you!";
                        g.battleText.setText(dmg);
                        player.hp -= dmgTaken;
                        if(player.getHp() <= 0){
                       Player.death(opp.getName());
                      return false;
                   }
                    }
                   return false;
     }
    public static int attack() {
        int dmg = new Random().nextInt(15) + 1;
        return dmg;

    }
    
     public static int bossAttack() {
        int dmg = new Random().nextInt(20) + 1;
        return dmg;

    }

               public static Enemy Gnosis;

    public static void finalBattle(Player player) {
            Gnosis  = new Enemy("Evil Emperor Gnosis", 85, 97);
           g.enemyStats.setText(Gnosis.name + " HP: " + Gnosis.getHp());
            String pcStats =  player.name + " HP: " + player.getHp();
           g.playerStats.setText(pcStats);
      
           }

    static void finalPlayerAttack(Player player) {
           String pcStats =  player.name + " HP: " + player.getHp();
           g.playerStats.setText(pcStats);
            int dmgDealt = attack();
                    Gnosis.hp -= dmgDealt;
                   int dmgTaken = bossAttack();
                   player.hp -= dmgTaken;
                   String dmg = "You dealt " + dmgDealt + " damage to the enemy!\nThe enemy dealt " + dmgTaken + " damage to you!";
                   g.bossBattleText.setText(dmg);

                   //if player beats emperor
                   if(Gnosis.hp <= 0)
                   {
                       //Play final boss winning story
                       g.finale();
                       player.win(player, Gnosis.getXp());
                   }
                   //if player loses
                   else if(player.getHp() <= 0){
                       Player.death(Gnosis.getName());
                   }    }
       }
        
    




