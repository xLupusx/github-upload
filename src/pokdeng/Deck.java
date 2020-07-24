package pokdeng;
import java.util.*;
public class Deck {
    private int[] deck;
    static String[] suit = {"♣","♦","♥","♠"};
    static String[] rank = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    public Deck() {
        this.deck = new int[52];
        for (int i = 0;i<deck.length;i++) {
            this.deck[i] = i;
        }
    }
    public void shuffleDeck() {
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0;i<deck.length;i++) {
            temp.add(deck[i]);
        }
        Collections.shuffle(temp);
        for (int i = 0;i<temp.size();i++) {
            deck[i]=temp.get(i);
        }        
    }
    public int drawCard(int seed) {
        return this.deck[seed];
    }
    public static String getCard(int i) {
        return ""+rank[i%13]+suit[i%4];
    }
}
