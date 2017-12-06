import java.util.ArrayList;

public class DeckOfCards {
    private ArrayList<Card> deck;

    public DeckOfCards() { // constructor
        deck = new ArrayList<Card>();
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                deck.add(new Card(suit, rank));
            }
        }
    }

    public void print() {
        int i = 0;
        for (Card card : deck) {
            System.out.print(card + "\t"); // print all cards
            i++;
            if (i % 4 == 0)
                System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DeckOfCards deck = new DeckOfCards();
        deck.print();
    }
}
