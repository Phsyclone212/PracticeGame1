
import java.util.Scanner;

public class Game {
    // THIS CLASS HOSTS THE GAMELOOP
    // player object is needed 
    private Player player = new Player();
    private boolean isRunning = false;

    Scanner sc = new Scanner(System.in);

    public Game(){
        //default game
        start();
        while(isRunning){
            System.out.println("--MAIN MENU--");
            System.out.println("1. Player Action");
            displayMenu(sc.nextInt());
        }
    }

    public void start(){
        // begins gameloop/this run.
        System.out.println("The game has begun.");
        this.isRunning = true;
    }

    public void displayMenu(int sel){
        switch(sel){
            case 1:
                player.action();
                break;
            default:
                this.isRunning = false;
        }
    }


    // getters and setters
    
    public void setPlayer(Player player){
        this.player = player;
    }
    public Player getPlayer(){
        return this.player;
    }
}
