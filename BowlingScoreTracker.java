import java.util.*;

public class BowlingScoreTracker {

    private String playerName = "";
    private int playerNumGames = 0;
    private double playerAvgScore = 0.0;
    private int playerLastGameScore = 0;
    private String playerDateLastGame = "";

    public BowlingScoreTracker(String bowlerName, int numGames, double avgScore, int lastGameScore, String dateLastGame) {
        playerName = bowlerName;
        playerNumGames = numGames;
        playerAvgScore = avgScore;
        playerLastGameScore = lastGameScore;
        playerDateLastGame = dateLastGame;
    }
   
  public static void main(String[] argv)  {
    ArrayList<BowlingScoreTracker> objlist = new ArrayList<BowlingScoreTracker>();
    
    BowlingScoreTracker tom = new BowlingScoreTracker("Tom",5, 150.5, 160, "02/15/2023");
    BowlingScoreTracker bob = new BowlingScoreTracker("Bob",10, 175.5, 200, "01/20/2023");
    objlist.add(tom);
    objlist.add(bob);

    for (BowlingScoreTracker player: objlist) {
        System.out.println("Bowler Name: " + player.playerName);
        System.out.println("Bowler Number of games: " + player.playerNumGames);
        System.out.println("Bowler Average Score of all of their games: " + player.playerAvgScore);
        System.out.println("Bowler Score of their last game: " + player.playerLastGameScore);
        System.out.println("Bowler Date of their last game: " + player.playerDateLastGame);
        System.out.println("\n");
    }
}
}
