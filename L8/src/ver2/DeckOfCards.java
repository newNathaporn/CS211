package ver2;

import java.util.ArrayList;

public class DeckOfCards {
    private ArrayList<Card> deck;

    public DeckOfCards() { // constructor
        deck = new ArrayList<Card>();
        for (Card.Rank rank : Card.Rank.values()) {
            for (Card.Suit suit : Card.Suit.values()) {
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

    public Card find(String suitName, String rankName) throws IllegalArgumentException {
        Card.Suit suit;
        Card.Rank rank;
        try {
            suit = Card.Suit.valueOf(suitName);
            rank = Card.Rank.valueOf(rankName);
        }
        catch(IllegalArgumentException e) {
            suit = Card.Suit.valueOf(rankName);
            rank = Card.Rank.valueOf(suitName);
        }
        Card searchedCard = new Card(suit, rank);
        for (Card card : deck) {
            if (card.equals(searchedCard))
                return searchedCard;
        }
        return null;
    }

    public static void main(String[] args) {
        DeckOfCards deck = new DeckOfCards();
        deck.print();

        System.out.println("Search for SPADE - ACE: "
                + deck.find("SPADE", "ACE"));
        System.out.println("Search for ACE - SPADE: "
                + deck.find("ACE", "SPADE"));

/*        try {
            System.out.println("Search for SPADE - ACE: "
                    + deck.find("SPADE", "ACE"));
            System.out.println("Search for ACE - SPADE: "
                    + deck.find("ACE", "SPADE"));
        } catch (IllegalArgumentException e) {
            System.out.println("Card not found error: " + e);
        }
*/    }
}
