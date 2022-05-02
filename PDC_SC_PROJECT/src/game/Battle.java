
package game;

import java.util.Random;

/**
* @author Jade Thompson-Tavai
 * Student ID: 20108594
 */
public class Battle {
    
    public static Random rand = new Random();

    
    public static void startBattle(Player player, Enemy enemy){
    
        boolean battle = true;
       while(battle){
           GameLogic.clearConsole();
           GameLogic.printHeading(enemy.name + " HP: " + enemy.getHp());
           GameLogic.printHeading(player.name + " HP: " + player.getHp());
           System.out.println("Choose an Action");
           GameLogic.printPartition(30);
           System.out.println("(1) Fight");
           System.out.println("(2) Run");
           int input = GameLogic.getInput("->", 2);
           switch(input){
               case 1:
                    GameLogic.clearConsole();
                   int dmgDealt = attack();
                   System.out.println("You dealt " + dmgDealt + " damage to the enemy!");
                   enemy.hp -= dmgDealt;
                   int dmgTaken = attack();
                    System.out.println("The enemy dealt " + dmgTaken + " damage to you!");
                   player.hp -= dmgTaken;
                   GameLogic.anyKeyToContinue();

                   //if player wins
                   if(enemy.hp <= 0)
                   {
                       System.out.println("You have defeated the " + enemy.getName() +"! You gained " + enemy.getXp() + "xp points!");
                       player.win(player, enemy.getXp());
                       GameLogic.anyKeyToContinue();
                       battle = false;
                   }

                   //if plaver loses
                   else if(player.getHp() <= 0){
                       Player.death(enemy.getName());
                       battle = false;
                   }
                   break;

                   //attempt to escape
               case 2:
                    GameLogic.clearConsole();
                   int escapeChance = rand.nextInt(100);
                   //success
                   if(escapeChance > 50){
                       System.out.println("You successfully escaped!");
                       battle = false;
                   }
                   //fail
                   else{
                       System.out.println("You cannot escape!");
                       dmgTaken = attack();
                        System.out.println("The enemy dealt " + dmgTaken + " damage to you!");
                        player.hp -= dmgTaken;
                        GameLogic.anyKeyToContinue();
                        if(player.getHp() <= 0){
                       Player.death(enemy.getName());
                       battle = false;
                   }
                   }
                   break;
               default:
                   break;
               
           }
       }
    }
    
     
    public static int attack() {
        int dmg = new Random().nextInt(15) + 1;
        return dmg;

    }
    
     public static int bossAttack() {
        int dmg = new Random().nextInt(20) + 1;
        return dmg;

    }

    public static void finalBattle(Player player) {
        Enemy Gnosis = new Enemy("Evil Emperor Gnosis", 85, 97);
        boolean battle = true;
        while(battle){
         GameLogic.clearConsole();
           GameLogic.printHeading(Gnosis.name + " HP: " + Gnosis.getHp());
           GameLogic.printHeading(player.name + " HP: " + player.getHp());
           System.out.println("Choose an Action");
           GameLogic.printPartition(30);
           System.out.println("(1) Fight");
           System.out.println("(2) Run");
           int input = GameLogic.getInput("->", 2);
           switch(input){
               case 1:
                    GameLogic.clearConsole();
                   int dmgDealt = attack();
                   System.out.println("You dealt " + dmgDealt + " damage to the enemy!");
                   Gnosis.hp -= dmgDealt;
                   int dmgTaken = bossAttack();
                    System.out.println("The enemy dealt " + dmgTaken + " damage to you!");
                   player.hp -= dmgTaken;
                   GameLogic.anyKeyToContinue();

                   //if player beats emperor
                   if(Gnosis.hp <= 0)
                   {
                       System.out.println("You have defeated the " + Gnosis.getName() +"! You gained " + Gnosis.getXp() + "xp points!");
                       //Play final boss winning story
                       finale();
//                       player.win(player, Gnosis.getXp());
                       GameLogic.anyKeyToContinue();
                       battle = false;
                   }
                   //if player loses
                   else if(player.getHp() <= 0){
                       Player.death(Gnosis.getName());
                       battle = false;
                   }
                   break;
               case 2:
                    GameLogic.clearConsole();
                       System.out.println("THERE IS NO ESCAPE!");
                       dmgTaken = attack();
                        System.out.println("The Emperor dealt " + dmgTaken + " damage to you!");
                        player.hp -= dmgTaken;
                        GameLogic.anyKeyToContinue();
                        if(player.getHp() <= 0){
                       Player.death(Gnosis.getName());
                       battle = false;
                        }
                   break;
               default:
                   break;
               
           }
       }
        
    }

    //print final story lines
    private static void finale() {
        GameLogic.clearConsole();
        System.out.println("The Evil Emperor falls to his knees, defeated. You stand above him, sword raised.");
        GameLogic.anyKeyToContinue();
        GameLogic.clearConsole();        
        System.out.println("As you swing down, the moon shines off your blade, blinding you momentairily. \nThe Evil Emperor raises his hand and you are sent flying back.");
        GameLogic.anyKeyToContinue();        
        GameLogic.clearConsole();        
        System.out.println("He stands and laughs. The robes wrap around him and when you blink again, he is gone.");
        GameLogic.anyKeyToContinue();
        GameLogic.clearConsole();     
        System.out.println("Congratualtions, you beat the emperor!");
        System.out.println("The kingdom is safe once more...but for how long?");
        
        
    }

}
