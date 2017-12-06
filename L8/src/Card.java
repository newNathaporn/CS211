public class Card {

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

    public String toString() {
        return rank + " of " + suit;
    }
}
