package ver2;
public class Card {
    enum Suit {
        SPADE, HEART, DIAMOND, CLUB
    }

    enum Rank {
        ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
    }

    private Suit suit;
    private Rank rank;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    Rank getRank() {
        return rank;
    }

    Suit getSuit() {
        return suit;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Card)) return false;
        Card card = (Card)obj;
        return card.getSuit() == this.getSuit() && card.getRank() == this.getRank();
    }
    
    public String toString() {
        return rank + " of " + suit;
    }
}
