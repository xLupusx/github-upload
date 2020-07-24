package pokdeng;
import java.util.*;
public class Game {
    protected static Player dealer = new Player();
    protected static Player pc = new Player();
    static Deck gameDeck = new Deck();
    Scanner sc = new Scanner(System.in);
    protected static int seed,bet;
    public Game () {
        this.seed = 0; //start at 0
        this.bet = 10; //default bet
    }
    public void startNewGame() {
        pc.fund = 100; //reset funds
        pc.drawmore = false; //reset draw status
        dealer.drawmore = false;
        pc.pokStat = false; //reset PokDeng status
        pc.dengStat = 1;
        pc.specialwin = false;
        dealer.pokStat = false;
        dealer.dengStat = 1;
        dealer.specialwin = false;
        seed = 0; //reset deck
        gameDeck.shuffleDeck();
        for (int time=1;time<=2;time++) {
            pc.draw(time, seed); //draw alternating with dealer
            seed++; //move to next card
            dealer.draw(time, seed);
            seed++;
            }
    }
    public void startNewRound() {
        pc.drawmore = false; //reset draw status
        dealer.drawmore = false;
        pc.pokStat = false; //reset PokDeng status
        pc.dengStat = 1;
        pc.specialwin = false;        
        dealer.pokStat = false;
        dealer.dengStat = 1;
        dealer.specialwin = false;
        seed = 0; //reset deck every new round
        gameDeck.shuffleDeck();
        for (int time=1;time<=2;time++) {
            pc.draw(time, seed); //draw alternating with house
            seed++; //move to next card
            dealer.draw(time, seed);
            seed++;
            }
    }
}