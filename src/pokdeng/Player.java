package pokdeng;
import java.util.Arrays;
public class Player {
    protected int fund=100; //starting fund
    protected int[] card=new int[3]; //in any given game, the max cards you can have on your hand is 3
    protected int points=0,dengStat = 1; //initialize starting state
    protected boolean drawmore=false,pokStat=false,specialwin=false;
    String pok="",deng="";
    public Player() {
    }
    public int getFund() {
        return fund;
    }
    public void setFund(int bet) {
        fund+=bet;
    }
    public void draw(int times,int seed) { //Auto draw 2 times at start
        card[times-1] = Game.gameDeck.drawCard(seed);
    }
    public void drawMore() { //Draw more duh
        card[2] = Game.gameDeck.drawCard(Game.seed);
        drawmore = true;
        Game.seed+=1;
    }
    public int getPoints() {
        pok = ""; //reset
        deng = "";
        pokStat = false;
        dengStat = 1;
        points = 0;
        for (int i=0;i<2;i++) {
            if(card[i]%13>8) {points+=0;}
            else {points+=(card[i]%13)+1;} //count points for Ace(1) to 10 cards
        }
        if (drawmore == false){
            if (card[0]%4 == card[1]%4 || card[0]%13 == card[1]%13) { //if both cards have the same suit, 2 Deng
                deng = "2 Deng";
                dengStat = 2;
            }
            if (points%10 == 8) { //Pok is only for when that player didn't draw
                pok = "Pok 8";
                pokStat = true;
            }
            else if (points%10 == 9) {
                pok = "Pok 9";
                pokStat = true;
            }
        }
        else if (drawmore) {
            if(card[2]%13>8) {points+=0;}
            else {points+=(card[2]%13)+1;}                     
            if (card[0]%13 == card[1]%13 && card[0]%13 == card[2]%13) { //3 of the same number
                deng = "3 of a kind"; 
                dengStat = 5;
                specialwin = true;
            }
            else if (card[0]%13 > 9 && card[1]%13 > 9 && card[2]%13 > 9) { //J, Q, and K
                deng = "3 Yellow";
                dengStat = 3;
                specialwin = true;
            }
            else {
                    int[] straightcheck = new int[3];
                    for (int i=0;i<3;i++) {
                        straightcheck[i] = card[i]%13;
                        if (straightcheck[i] == 0) {straightcheck[i] = 14;} //A is actually highest
                    }
                    Arrays.sort(straightcheck);
                    if(straightcheck[2]-straightcheck[1]==1 && straightcheck[1]-straightcheck[0]==1) { //check if it's in order
                        deng = "Straight";
                        dengStat = 3; 
                    }
            }            
            if ((card[0]%4 == card[1]%4 && card[0]%4 == card[2]%4)) { //3 of the same suits
                deng += "3 Deng";
                dengStat = 3;
            }
        }
        return points%10; //points in PokDeng don't count past 10
    }
}
