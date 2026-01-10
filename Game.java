public class Game {
    // THIS CLASS HOSTS THE GAMELOOP
    // player object is needed 
    private Player player = new Player();
    private boolean isRunning = false;

    public Game(){
        //default game
        start();
        while(isRunning){
            player.action();
        }
    }

    public void start(){
        // begins gameloop/this run.
        System.out.println("The game has begun.");
        this.isRunning = true;
    }


    // getters and setters
    
    public void setPlayer(Player player){
        this.player = player;
    }
    public Player getPlayer(){
        return this.player;
    }
}
