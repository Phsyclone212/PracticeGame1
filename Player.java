import java.util.Scanner;

public class Player {

    private Scanner sc = new Scanner(System.in);

    // personal player details
    private String name; // player name.
    private int playerLevel; // will level up as a personal level, unrelated to skill levels.
    private int playerXp;
    private int xpThreshold = 100;
    // private HashMap<String, Integer> skills; // Holds key(skill name) and value (skill level)
    /* this needs to be done differently in the future to several skills spread over classes. */

    private int stamina = 10;
    private int maxStamina = 100;

    public Player(){
        this.playerLevel = 1;
        this.playerXp = 0;
        this.stamina = 10;
    }

    public void action(){
        // Player needs to see options and select one via number input if they have stamina.

        // display a menu of choices
        actionMenu();
            
        // make selection
        int sel = sc.nextInt();

        // resolve action of choice
        resolveAction(sel);

        playerStats();
    }

    private void actionMenu(){
        System.out.println("--SELECT AN ACTION--");
        System.out.println("1. TRAIN");
        System.out.println("2. HUNT");
        System.out.println("3. CRAFT");
        System.out.println("4. REST");
        System.out.println("5. QUIT");
    }

    private void resolveAction(int sel){
        switch(sel){
            case 1:
                if(stamina >= 1){
                    System.out.println("You train your skills... ");
                    train();
                } else {
                    System.out.println("You don't have enough stamina to complete this action.");
                }
                break;
            case 2:
                if(stamina>=1){
                    System.out.println("You go hunting...");
                    hunt();
                } else {
                    System.out.println("You don't have enough stamina to complete this action.");
                }
                break;
            case 3: 
                craft();
                break;
            case 4: 
                rest();
                break;
            case 5:
                // quit();
                break;
            default: //player will rest
                rest();
        }
    }

    private void train(){
        this.stamina--; // reduce players stamina by 1 (or more based on things?)
        this.playerXp += 10;
        System.out.println("You have gained +10xp through your training.");
        checkXp();
    }

    public void hunt(){
        this.stamina--; // reduce players stamina by 1. 
        int num = (int)(Math.random() * (25-1)+1);
        if(num==1){
            System.out.println("You failed to hunt anything. +0xp");
        } else if (num>=2 && num <5) {
            playerXp+=5;
            System.out.println("You successfully hunt a small creature. +5xp");
        } else if (num>=5 && num<20){
            playerXp+=15;
            System.out.println("You successfully hunt a medium creature. +15xp");
        } else if (num>=20 && num<25){
            playerXp+=25;
            System.out.println("You successfully hunt a large creature! +25xp");
        } else {
            playerXp+=40;
            System.out.println("You successfully hunted a Rare Creature! +40xp");
        }
        checkXp();
    }

    public void craft(){
        System.out.println("You craft...");
        // take away from items/resources to give the player usable equipment.
    }

    public void rest(){
        if(stamina < maxStamina){
            System.out.println("You take time to rest. +5 Stamina");
            stamina += 5;
            if(stamina >= maxStamina){
                System.out.println("You are at maximum stamina");
                stamina = 100;
            }
        }
    }

    // public void quit(){
    //     System.out.println("You have quit the game. Thanks for playing!");
    //     game.isRunning = false;
    // }

    public void checkXp(){
        if(playerXp>=xpThreshold){
            playerLevel++;
            xpThreshold = xpThreshold + (100*playerLevel);
            System.out.println("You leveled up! You are now Level " +playerLevel);
        }
        System.out.println("Level: "+playerLevel);
        System.out.println("Xp: "+playerXp);
        System.out.println("Next Lvl: "+xpThreshold);
    }

    public void playerStats(){
        System.out.println("Name: "+name+" Lvl: "+playerLevel);
        System.out.println("Stamina: "+stamina);
    }
}
