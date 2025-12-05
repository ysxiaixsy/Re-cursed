// MAIN IMPLEMENTATION OF COMBAT SEQUENCE


import java.util.*;

public class Combat{

    Player player1 = new Player();
    Monster monster1 = new Monster();
    StatCheck checker = new StatCheck();
    Random rand = new Random();
    Scanner sc = new Scanner(System.in);

    int playerHealth = player1.playerHP;
    int playerMana = player1.playerTotalMana;
    int monsterHealth = monster1.monsterHP;
 

    public void sequence (){
        while (playerHealth > 0 && monsterHealth > 0){

            System.out.println("\n\nPlayer HP: " + playerHealth);
            System.out.println("Player Mana: " + playerMana);
            System.out.println("Monster HP: " + monsterHealth);
            System.out.println("Choose your action:");
            System.out.println("1. Attack");
            System.out.println("2. Run");
            System.out.print("> ");
            int choice = sc.nextInt();

            if (choice == 2) {
                System.out.println("You ran away! Battle Over!");
                return;
            }

            // PLAYER
            if (choice == 1) {

                if (playerMana > 0){
                    System.out.print("\nChoose Attack: 1 2 3: ");
                    int attackChoice = sc.nextInt();
                    int pIndex = attackChoice - 1;
                    int manaCost = player1.manaCost[pIndex];

                    if (playerMana >= manaCost){
                        int pDamage =  player1.playerDamage[pIndex];
                        playerMana = playerMana - manaCost;

                        System.out.println("\nYou use **" + player1.playerAttacks[pIndex] + "**!");
                        System.out.println("It dealt " + pDamage + " damage!");
                        System.out.println("Mana Cost: " + player1.manaCost[pIndex]);
                        
                        monsterHealth -= pDamage;

                        if (monsterHealth <= 0) {
                            playerHealth = checker.playerHPCheck(playerHealth);
                            monsterHealth = checker.monsterHPCheck(monsterHealth);
                            playerMana = checker.playerManaCheck(playerMana);
                            System.out.println("\nMonster HP: " + monsterHealth);
                            System.out.println("You defeated the Monster!");
                            System.out.println("\nPlayer HP: " + playerHealth);
                            System.out.println("Player Mana: " + playerMana);
                            break;
                        }

                        checker.monsterHPCheck(monsterHealth);
                        System.out.println("Monster HP: " + monsterHealth);
                        System.out.println();
                    }
                    else{
                        System.out.println("\nYou have insufficient Mana. Turn Wasted!");
                    }
                }

                else{
                    System.out.println("\n\nYou are out of Mana (" + playerMana + ") No Actions Left!");
                }

            }


            // MONSTER
            int mIndex = rand.nextInt(monster1.monsterAttacks.length);
            int mDamage = monster1.monsterDamage[mIndex];

            System.out.println("\nMonster uses **" + monster1.monsterAttacks[mIndex] + "**!");
            System.out.println("It dealt " + mDamage + " damage!");
            playerHealth -= mDamage;

            if (playerHealth <= 0) {
                playerHealth = checker.playerHPCheck(playerHealth);
                monsterHealth = checker.monsterHPCheck(monsterHealth);
                playerMana = checker.playerManaCheck(playerMana);
                System.out.println("\nPlayer HP: " + playerHealth);
                System.out.println("Player Mana: " + playerMana);
                System.out.println("Monster HP: " + monsterHealth);
                System.out.println("You were defeated...");
                break;
            }

            System.out.println("\nPlayer HP: " + playerHealth);
            System.out.println("Player Mana Regen: " + playerMana + " + 20");
            playerMana += 20;
            playerMana = checker.playerManaCheck(playerMana);
        }

        System.out.println("\n=== BATTLE OVER ===");
    }

}

