package collection.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private List<Card> cards = new ArrayList<>();

    public Deck() {
        initCard();
        shuffle();
    }

    private void shuffle() {
        Collections.shuffle(cards);
    }

    private void initCard() {
        for (int i = 1; i <= 13; i++) {
            for (CardType value : CardType.values()) {
                cards.add(new Card(value, i));
            }
        }
    }

    public Card drawCard() {
        return cards.removeFirst();
    }
}
