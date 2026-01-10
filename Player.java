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

    public Player(){
        this.playerLevel = 1;
        this.playerXp = 0;
    }

    public void action(){
        // Player needs to see options and select one via number input.
        // display a menu of choices
        actionMenu();
        // make selection
        int sel = sc.nextInt();
        // resolve action of choice
        resolveAction(sel);
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
                System.out.println("You train your skills... ");
                train();
                break;
            case 2: 
                System.out.println("You go hunting...");
                hunt();
                break;
            case 3: 
                craft();
                break;;
            case 4: 
                rest();
                break;
            case 5: 
                
            default: //player will rest
        }
    }

    private void train(){
        this.playerXp += 10;
        System.out.println("You have gained +10xp through your training.");
        checkXp();
    }

    public void hunt(){
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
}
